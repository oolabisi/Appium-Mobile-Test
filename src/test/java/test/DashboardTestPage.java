package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.DashboardPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.*;

public class DashboardTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public DashboardTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("login");
    }

    @Test
    public void dashboard() throws IOException, ParseException, InterruptedException {
        DashboardPage page = new DashboardPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's dashboard is visible");
        wait.until(ExpectedConditions.visibilityOf(page.homeIconBtn));
        Thread.sleep(4000);
    }

    @Test
    public void historyTab() throws InterruptedException {
        DashboardPage history = new DashboardPage(driver);
        testTitle("Verify User can click and scroll through History page");
        history.historyBtn.click();
//        scrollIntoText("");
        Thread.sleep(2000);
        history.backBtn.click();
    }

    @Test
    public void chatRenmoney() throws InterruptedException {
        DashboardPage chat = new DashboardPage(driver);
        testTitle("Verify User can click to view the chat Page");
        Thread.sleep(2000);
        chat.chatRenmoney.click();
        Thread.sleep(1700);
        chat.navigateUp.click();
    }

    @Test
    public void notification() throws InterruptedException {
        DashboardPage chat = new DashboardPage(driver);
        testTitle("Verify User can click to view the chat Page");
        Thread.sleep(2000);
        chat.notification.click();
        Thread.sleep(1700);
        chat.backBtn.click();
    }

    @Test
    public void hideAndShowTransaction() throws InterruptedException {
        DashboardPage chat = new DashboardPage(driver);
        testTitle("Verify User can click eye-icon either to hide or reveal balance");
        Thread.sleep(2000);
        tapByCoordinates(620, 463);
    }

    @Test
    public void addMoneyTab() throws InterruptedException {
        DashboardPage addMoney = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Add-money page");
        Thread.sleep(2000);
        addMoney.addMoneyBtn.click();
        Thread.sleep(1700);
        addMoney.backBtn.click();
    }

    @Test
    public void sendMoneyTab() throws InterruptedException {
        DashboardPage send = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Send-money page");
        Thread.sleep(2000);
        send.sendMoneyBtn.click();
        Thread.sleep(1700);
        send.backBtn.click();
    }

    @Test
    public void buyAirtimeTab() throws InterruptedException {
        DashboardPage airtime = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Airtime page");
        Thread.sleep(2000);
        airtime.buyAirtimeBtn.click();
        Thread.sleep(1700);
        airtime.backBtn.click();
    }

    @Test
    public void payBillsTab() throws InterruptedException {
        DashboardPage bills = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Pay-bills page");
        Thread.sleep(2000);
        bills.payBillsBtn.click();
        Thread.sleep(1700);
        bills.backBtn.click();
    }

    @Test
    public void investAndEarn() throws InterruptedException {
        DashboardPage earn = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Invest&Earn page");
        Thread.sleep(2000);
        earn.investAndEarnBtn.click();
        Thread.sleep(2700);
        earn.homeIconBtn.click();
    }

    @Test
    public void loanTab() throws InterruptedException {
        DashboardPage loan = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Loan page");
        Thread.sleep(2000);
        loan.loanApplyBtn.click();
        Thread.sleep(2700);
        loan.homeIconBtn.click();
    }

    @Test
    public void purchaseAirtime() throws InterruptedException {
        DashboardPage purchase = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Airtime page");
        Thread.sleep(2000);
        purchase.purchaseAirtimeBtn.click();
        Thread.sleep(1700);
        purchase.backBtn.click();
    }

    @Test
    public void debitCardTab() throws InterruptedException {
        DashboardPage debit = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to DebitCard page");
        Thread.sleep(2000);
        debit.debitCardBtn.click();
        Thread.sleep(1700);
        debit.backBtn.click();
    }

    @Test
    public void saveIconTab() throws InterruptedException {
        DashboardPage save = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Deposit page");
        Thread.sleep(2000);
        save.saveIconBtn.click();
        Thread.sleep(1700);
        save.homeIconBtn.click();
    }

    @Test
    public void loanIconTab() throws InterruptedException {
        DashboardPage loan = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to Loan page");
        Thread.sleep(2000);
        loan.loanIconBtn.click();
        Thread.sleep(1700);
        loan.homeIconBtn.click();
    }

    @Test
    public void investTab() throws InterruptedException {
        DashboardPage invest = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to the Invest page");
        Thread.sleep(2000);
        invest.investIconBtn.click();
        Thread.sleep(1700);
        invest.homeIconBtn.click();
    }

    @Test
    public void moreIconTab() throws InterruptedException {
        DashboardPage more = new DashboardPage(driver);
        testTitle("Verify User can click and navigate to More page");
        Thread.sleep(2000);
        more.moreIconBtn.click();
        Thread.sleep(1700);
        more.homeIconBtn.click();
    }

}
