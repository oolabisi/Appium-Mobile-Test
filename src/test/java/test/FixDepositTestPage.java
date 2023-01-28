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

public class FixDepositTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public FixDepositTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("saving");
    }

    @Test
    public void navigateToInvestmentPage() throws InterruptedException, IOException, ParseException {
        InvestmentPage invest = new InvestmentPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to Invest page");
        wait.until(ExpectedConditions.visibilityOf(invest.saveIconBtn));
        Thread.sleep(4000);
        invest.investIconBtn.click();
    }

    @Test
    public void checkHistory() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(1000);
        invest.history.click();
        Thread.sleep(2000);
        swipeScreen();
        Thread.sleep(2000);
        invest.cancelBtn.click();
    }

    @Test
    public void withdraw() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(1000);
        invest.withdrawal.click();
        Thread.sleep(2000);
        swipeScreen();
        Thread.sleep(2000);
        invest.cancelBtn.click();
    }

    @Test
    public void planName() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String name = (String) envs.get("PlanName");
        Thread.sleep(1000);
        invest.newPlan.click();
        invest.planName.click();
        invest.planName.sendKeys(name);
        driver.hideKeyboard();
        invest.fixedNext.click();
    }

    @Test
    public void fixedAmount() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        String amount = (String) envs.get("amount");
        Thread.sleep(1000);
        invest.investmentAmount.click();
        invest.investmentAmount.sendKeys(amount);
        driver.hideKeyboard();
    }

    @Test
    public void fixedDuration() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(1000);
        invest.investmentDuration.click();
        invest.chosenDuration.click();
        tapByCoordinates(1104,1123);
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
    public void goBackToInvestmentPage() throws InterruptedException {
        InvestmentPage invest = new InvestmentPage(driver);
        Thread.sleep(3000);
        invest.backToInvestmentPage.click();
    }

}
