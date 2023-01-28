package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.InvestmentPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.*;

public class SmartGoalTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public SmartGoalTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("saving");
    }

    @Test
    public void navigateToSavingsPage() throws InterruptedException, IOException, ParseException {
        InvestmentPage invest = new InvestmentPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to Savings page");
        wait.until(ExpectedConditions.visibilityOf(invest.saveIconBtn));
        Thread.sleep(6000);
        invest.saveIconBtn.click();
    }

    @Test
    public void checkHistory() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.history.click();
        Thread.sleep(1000);
        swipeScreen();
        Thread.sleep(2000);
        invest.cancelBtn.click();
    }

    @Test
    public void withdraw() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(1000);
        invest.smartWithdrawal.click();
        Thread.sleep(1000);
        swipeScreen();
        Thread.sleep(2000);
        invest.cancelBtn.click();
    }

    @Test
    public void startRenFlex() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        invest.addRenFlex.click();
        Thread.sleep(2000);
    }

    @Test
    public void renFlexAmount() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String amount = (String) envs.get("flex");
        invest.renFlexAmount.click();
        invest.renFlexAmount.sendKeys(amount);
        tapByCoordinates(463,973);
        Thread.sleep(2000);
        invest.renFlexNext.click();
    }

    @Test
    public void flexPin() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.transactionPin1.click();
        Thread.sleep(2000);
        invest.transactionPin2.click();
        Thread.sleep(2000);
        invest.transactionPin3.click();
        Thread.sleep(2000);
        invest.transactionPin4.click();
    }

    @Test
    public void backHome() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.backToInvestmentPage.click();
    }

    @Test
    public void withdrawRenFlex() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        invest.withdrawRenFlex.click();
        Thread.sleep(2000);
    }

    @Test
    public void amountRenFlex() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String amount = (String) envs.get("withdraw");
        invest.renFlexWithdrawAmount.click();
        invest.renFlexWithdrawAmount.sendKeys(amount);
        Thread.sleep(2000);
        tapByCoordinates(935,831);
        invest.withdrawalContinue.click();
    }

    @Test
    public void withDrawPin() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.transactionPin1.click();
        Thread.sleep(2000);
        invest.transactionPin2.click();
        Thread.sleep(2000);
        invest.transactionPin3.click();
        Thread.sleep(2000);
        invest.transactionPin4.click();
    }

    @Test
    public void backHomeAgain() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.backToInvestmentPage.click();
    }


    @Test
    public void createPlanName() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String name = (String) envs.get("PlanName");
        Thread.sleep(2000);
        invest.newPlan.click();
        invest.planName.click();
        invest.planName.sendKeys(name);
        driver.hideKeyboard();
        invest.smartNext.click();
    }

    @Test
    public void smartAmount() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String amount = (String) envs.get("amount");
        Thread.sleep(1000);
        invest.investmentAmount.click();
        invest.investmentAmount.sendKeys(amount);
        driver.hideKeyboard();
    }

    @Test
    public void smartDuration() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(2000);
        invest.smartTenure.click();
        invest.chosenTenure.click();
        tapByCoordinates(935,831);
    }

    @Test
    public void smartTenure() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(2000);
        invest.smartDuration.click();
        invest.smartChose.click();
        tapByCoordinates(935,831);
        Thread.sleep(2000);
        swipeScreen();
        invest.checkBox.click();
        invest.confirmBtn.click();
        Thread.sleep(2000);
        invest.continueBtn.click();
    }

    @Test
    public void transactionPin() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.transactionPin1.click();
        Thread.sleep(2000);
        invest.transactionPin2.click();
        Thread.sleep(2000);
        invest.transactionPin3.click();
        Thread.sleep(2000);
        invest.transactionPin4.click();
    }

    @Test
    public void returnHome() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.backToInvestmentPage.click();

    }

}
