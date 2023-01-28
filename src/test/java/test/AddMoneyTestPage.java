package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.AddMoneyPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.*;

public class AddMoneyTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public AddMoneyTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("receiveMoney");
    }

    @Test
    public void navigateToAddMoney() throws IOException, ParseException, InterruptedException {
        AddMoneyPage money = new AddMoneyPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to Add money page");
        wait.until(ExpectedConditions.visibilityOf(money.addMoneyBtn));
        Thread.sleep(4000);
        money.addMoneyBtn.click();
    }

    @Test
    public void copyAccount() throws InterruptedException {
        AddMoneyPage money = new AddMoneyPage(driver);
        Thread.sleep(2000);
        money.copyAccount.click();
        Thread.sleep(2000);
    }

    @Test
    public void shareAccount() throws InterruptedException {
        AddMoneyPage money = new AddMoneyPage(driver);
        money.shareAccount.click();
        Thread.sleep(2000);
        tapByCoordinates(819,377);
    }

    @Test
    public void backToDashboard() throws InterruptedException {
        AddMoneyPage money = new AddMoneyPage(driver);
        Thread.sleep(1000);
        money.backBtn.click();
    }

   /* @Test
    public void addNewCard() throws InterruptedException {
        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User's can click and be navigated to Card page");
        money.addMoneyWithCardBtn.click();
        Thread.sleep(700);
        money.addNewCardBtn.click();
    }

    @Test
    public void incompleteCardNumber() throws InterruptedException {
        String incompleteCardNumber = (String) envs.get("incompleteCardNumber");
        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User cannot add/use incomplete Card number");
        Thread.sleep(1000);
        money.addCardNumber.click();
        money.addCardNumber.sendKeys(incompleteCardNumber);
//        assertText();
        Thread.sleep(1500);
        money.addCardNumber.clear();
    }

    @Test
    public void wrongCardDate() throws InterruptedException {
        String card = (String) envs.get("card");
        String cardDate = (String) envs.get("cardDate");
        String wrongCardDate = (String) envs.get("wrongCardDate");
        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User cannot add/use a wrong Card date");
        Thread.sleep(1000);
        money.addCardNumber.click();
        money.addCardNumber.sendKeys(card);
        Thread.sleep(700);
        money.addCardDate.click();
        money.addCardDate.sendKeys(wrongCardDate);
        Thread.sleep(1200);
        money.addCardDate.clear();
        Thread.sleep(700);
        money.addCardDate.click();
        money.addCardDate.sendKeys(cardDate);
    }

    @Test
    public void wrongCardNumber() throws InterruptedException {
        String wrongCardNumber = (String) envs.get("wrongCardNumber");
        String cardDate = (String) envs.get("cardDate");
        String cvv = (String) envs.get("cvv");
        String cardNumber = (String) envs.get("card");

        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User cannot add wrong Card details");
        Thread.sleep(1000);
        money.addCardNumber.click();
        money.addCardNumber.sendKeys(wrongCardNumber);
        Thread.sleep(1000);
        money.addCardDate.click();
        money.addCardDate.sendKeys(cardDate);
        Thread.sleep(1000);
        money.addCardCVV.click();
        money.addCardCVV.sendKeys(cvv);
        Thread.sleep(1000);
        money.next.click();
        Thread.sleep(1000);
        money.addAmount.sendKeys();
        Thread.sleep(1000);
        money.addPin.sendKeys();
        // Paystack Modal
    }

    @Test
    public void validCardDetails() throws InterruptedException {
        String cvv = (String) envs.get("cvv");
        String card = (String) envs.get("card");
        String cardDate = (String) envs.get("cardDate");

        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User can add a valid Card number");
        Thread.sleep(1000);
        money.addCardNumber.click();
        money.addCardNumber.sendKeys(card);
        Thread.sleep(1000);
        money.addCardDate.click();
        money.addCardDate.sendKeys(cardDate);
        Thread.sleep(1000);
        money.addCardCVV.click();
        money.addCardCVV.sendKeys(cvv);
        money.next.click(); //modal continue
        // modal pin continue
        money.returnBackHomeBtn.click();
    }

    @Test
    public void wrongPin() throws InterruptedException {
        String wrongPin = (String) envs.get("wrongPin");
        String cardDate = (String) envs.get("cardDate");

        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User cannot add wrong Pin to transact");
        Thread.sleep(1000);
        money.addPin.click();
        money.addPin.sendKeys(wrongPin);
        Thread.sleep(1000);
        money.addPin.clear();
    }

    @Test
    public void pin() throws InterruptedException {
        String pin = (String) envs.get("cardPin");

        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("User can transact successfully with the right Pin");
        money.addPin.click();
        money.addPin.sendKeys(pin);
        Thread.sleep(2000);
    }

    @Test
    public void backToDashboard() {
        AddMoneyPage money = new AddMoneyPage(driver);
        testTitle("Verify User can navigate back to its dashboard");
        money.returnBackHomeBtn.click();
    }
*/
}
