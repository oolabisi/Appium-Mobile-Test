package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.LoginPage;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static AndroidDriver<AndroidElement> driver;
    public static WebDriverWait wait;
    public static AppiumDriverLocalService service;
    public static int waitTime= 60;
    public static ExtentReports reports;
    public static ExtentHtmlReporter htmlReporter;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal<ExtentTest>();
    public static ThreadLocal<ExtentTest> testInfo = new ThreadLocal<ExtentTest>();

    @Parameters({"groupReport"})
    @BeforeSuite(dependsOnMethods = {"killAllNodes"})
    public void startServer(String groupReport){
//        if (!Utilities.checkIfServerIsRunning(4723)){
//            service = AppiumDriverLocalService.buildDefaultService();
//            service.start();
//        } else {
//            System.out.println("Server port in use");
//            //taskkill /F /IM node.exe
//        }
        htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/"+groupReport));
        reports = new ExtentReports();
        reports.attachReporter(htmlReporter);
    }

    @BeforeSuite
    public void killAllNodes() throws IOException, InterruptedException {
        String osName = System.getProperty("os.name");
        if (osName.startsWith("Mac")){
            Runtime.getRuntime().exec("killall -s KILL node");
        } else if (osName.startsWith("Windows")){
            Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        }
        Thread.sleep(3000);
    }

    //    @BeforeClass
    public void startEmulator() throws IOException, InterruptedException {
        if (!Utilities.getProperty("deviceName").equals("real")){
            String osName = System.getProperty("os.name");
            if (osName.startsWith("Mac")){
                Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/test/resources/startEmulator.sh");
            } else if (osName.startsWith("Windows")){
                Runtime.getRuntime().exec(System.getProperty("user.dir")+"/src/test/resources/startEmulator.bat");
            }
            Thread.sleep(10000);
        }
    }

    @BeforeMethod(description = "fetch test cases name")
    public void register(Method method) {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ExtentTest child = parentTest.get().createNode(method.getName());
        testInfo.set(child);
        testInfo.get().assignCategory("Regression");
    }

    @AfterMethod(description = "to display the result after each test method")
    public void captureStatus(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            String screenshotPath = Utilities.getScreenshot();
            testInfo.get().addScreenCaptureFromBase64String(screenshotPath);
            testInfo.get().fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP)
            testInfo.get().skip(result.getThrowable());
        else
            testInfo.get().pass(result.getName() + " Test passed");

        reports.flush();
    }

    @BeforeClass
    public void setUp() throws IOException {
        try {
            File appDir = new File("src/test/resources");
            File app = new File(appDir, Utilities.getProperty("appName")+".apk");
            DesiredCapabilities cap = new DesiredCapabilities();
            String deviceName = Utilities.getProperty("deviceName");
            String appPackage = Utilities.getProperty("appPackage");
            String appActivity = Utilities.getProperty("appActivity");

            if (deviceName.equals("real")){
                cap.setCapability("deviceName", "Android Device");
                try {
                    String devices = Utilities.executeAdbCommand("adb devices");
                    devices = devices.replaceAll("List of devices attached", " ");
                    devices = devices.replaceAll("device", " ").trim();
                    String udid = devices.split(" ")[0].trim();
                    System.out.println(udid);
                    cap.setCapability("udid", udid);
                    cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
                    cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appPackage+appActivity);
                    cap.setCapability("udid", udid);
                } catch (IOException e) {
                    System.out.println("No devices found: " + e.toString());
                }
            } else {
                cap.setCapability("deviceName", deviceName);
                cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
            }
            cap.setCapability("platformName", "Android");
            cap.setCapability("automationName", "uiautomator2");
            cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "150000");

            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, waitTime);
            System.out.println("Application started");
            Thread.sleep(10000);
        } catch(Exception exp) {
            System.out.println(exp.getMessage());
            exp.printStackTrace();
        }
        ExtentTest parent = reports.createTest(getClass().getName());
        parentTest.set(parent);
    }

    public void login(String email, String password) throws IOException, ParseException, InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        wait.until(ExpectedConditions.visibilityOf(loginPage.getStarted));
        loginPage.getStarted.click();

        wait.until(ExpectedConditions.visibilityOf(loginPage.emailAddressField));
        loginPage.emailAddressField.click();
        loginPage.emailAddressField.sendKeys(email);
        driver.hideKeyboard();
        Thread.sleep(500);

        loginPage.nextBtn.click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys(password);
        driver.hideKeyboard();
        Thread.sleep(500);

        loginPage.submitBtn.click();

      }

    //    @AfterSuite
    public void tearDown() {
        driver.quit();
    }

    //    @AfterSuite(dependsOnMethods = {"tearDown"}, alwaysRun = true)
    public void stopServer(){
        service.stop();
    }

}
