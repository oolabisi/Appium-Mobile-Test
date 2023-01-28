package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.AirtimeDataPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.testTitle;

public class AirtimeDataTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public AirtimeDataTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("airtimeData");
    }

    @Test
    public void navigateToAirtimeAndData() throws InterruptedException, IOException, ParseException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can navigate to Airtime and Data page");
        wait.until(ExpectedConditions.visibilityOf(page.buyAirtimeTab));
        Thread.sleep(4000);
        page.buyAirtimeTab.click();
    }

    @Test
    public void rechargeAirtime() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.airtimeTab.click();
    }

    @Test
    public void selectAirtime() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.airtimeProvideTab.click();
    }

    @Test
    public void searchThroughAirtime() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String networkType = (String) envs.get("networkType");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.searchForAirtime.click();
        page.searchForAirtime.sendKeys(networkType);
    }

    @Test
    public void chooseAirtime() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.airtimeNetwork.click();
    }

    @Test
    public void addInvalidPhoneNumber() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String phoneNumber = (String) envs.get("dataPhoneNumber");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.phoneNumberField.click();
        page.phoneNumberField.sendKeys(phoneNumber);
        Thread.sleep(1700);
        page.phoneNumberField.clear();
    }

    @Test
    public void addPhoneNumber() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String phoneNumber = (String) envs.get("phoneNumber");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.phoneNumberField.click();
        page.phoneNumberField.sendKeys(phoneNumber);
    }

    @Test
    public void amountToRecharge() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.amountField.click();
    }

    @Test
    public void autoAmount() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.amountOne.click();
    }

    @Test
    public void autoAmount1() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.amountTwo.click();
    }

    @Test
    public void autoAmount2() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.amountThree.click();
        driver.hideKeyboard();
        Thread.sleep(1700);
        page.next.click();
    }

    @Test
    public void transactionPin() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String pin = (String) envs.get("transactionPin");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.transactionPin.click();
        page.transactionPin.sendKeys(pin);
    }

    @Test
    public void returnHome() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.returnToDashboard.click();
    }

    @Test
    public void rechargeData() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.buyAirtimeTab.click();
    }

    @Test
    public void selectData() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.dataTab.click();
    }

    @Test
    public void selectDataNetwork() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
//        String networkType2 = (String) envs.get("networkType2");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.airtimeProvideTab.click();
        Thread.sleep(1700);
        page.dataNetwork.click();
    }

    @Test
    public void addDataPhoneNumber() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String phoneNumber = (String) envs.get("dataPhoneNumber");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.phoneNumberField.click();
        page.phoneNumberField.sendKeys(phoneNumber);
    }

    @Test
    public void selectDataProvider() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String networkType = (String) envs.get("networkType");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.dataOption.click();
        Thread.sleep(1000);
        page.dataBundle.click();
        driver.hideKeyboard();
        Thread.sleep(1700);
        page.next.click();
    }

    @Test
    public void transactionPinForData() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        String pin = (String) envs.get("transactionPin");
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.transactionPin.click();
        page.transactionPin.sendKeys(pin);
//        Thread.sleep(1700);
    }

    @Test
    public void returnHomeAgain() throws InterruptedException {
        AirtimeDataPage page = new AirtimeDataPage(driver);
        testTitle("Verify User's can navigate to Airtime page");
        Thread.sleep(1700);
        page.returnToDashboard.click();
    }

}
