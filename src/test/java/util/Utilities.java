package util;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.time.Duration;
import java.util.Properties;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static util.TestBase.driver;
import static util.TestBase.testInfo;

public class Utilities {
    public static void scrollIntoText(String element){
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"))");
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + element + "\").instance(0))"));
    }

    public static void scrollByContentDesc(String element) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector()).scrollIntoView().resourceId(\"com.android.vending:id/data_view\")).getChildByDescription("
                       + "new UiSelector().className(\"android.view.View\"), \""+element+"\")"));
    }

    public static void horizontalScroll(String element) {
        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.android.vending:id/items\")).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().descriptionContains(\""+element+"\"))"));
    }

    public static boolean checkIfServerIsRunning(int port){
        boolean isServerRunning = false;
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);
            serverSocket.close();
        } catch (IOException e) {
            isServerRunning = true;
        } finally {
            serverSocket = null;
        }
        return isServerRunning;
    }

    public static String executeAdbCommand(String command) throws IOException {
        StringBuilder builder = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(command).getInputStream()));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            builder.append(line);
        }
        return builder.toString();
    }

    public static String getProperty(String key) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);

        return properties.getProperty(key);
    }

    public static String getScreenshot() throws IOException {
        String scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

        return "data:image/png;base64,"+scrFile;
//        FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"/screenshots/"+testName+".png"));
    }

    public static void testTitle(String phrase) {
        String word = "<b>"+phrase+"</b>";
        Markup w = MarkupHelper.createLabel(word, ExtentColor.WHITE);
        testInfo.get().info(w);
    }

    public static void checkIfVisible(WebElement element){
        if (element.isDisplayed()) {
            testInfo.get().pass(element.getText()+ " VISIBLE");
        } else {
            testInfo.get().error(element.getText()+ " NOT VISIBLE");
        }
    }

    public static void checkIfEnabled(WebElement element){
        if (element.isEnabled()) {
            testInfo.get().pass(element.getText()+ " CLICKABLE");
        } else {
            testInfo.get().error(element.getText()+ " NOT CLICKABLE");
        }
    }

    public static void checkIfDisabled(WebElement element){
        if (!element.isEnabled()) {
            testInfo.get().pass(element.getText()+ " DISABLED");
        } else {
            testInfo.get().error(element.getText()+ " CLICKABLE");
        }
    }

    public static void swipeScreen() {
        Dimension size = driver.manage().window().getSize();
        int height = size.getHeight();
        int width = size.getWidth();

        int startX = width/2;
        int endX = width;
        int startY = (int)(height * 0.8);
        int endY = (int)(height * 0.2);

        TouchAction action = new TouchAction<>(driver);
        action.press(PointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(4000)))
                .moveTo(PointOption.point(endX,endY))
                .release()
                .perform();
    }

    public static void assertText(WebElement element, String expectedText){
        if (element.getText().equals(expectedText)) {
            testInfo.get().info(element.getText()+ " FOUND");
        } else {
            testInfo.get().error("Expected to find ["+expectedText+"] but found ["+element.getText()+"]");
        }
    }

    public static void tapByCoordinates(int x, int y){
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withPosition(PointOption.point(x, y))).perform();
    }



}
