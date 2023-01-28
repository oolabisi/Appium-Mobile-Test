package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.MorePage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.*;

public class MoreTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public MoreTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("login");
    }

    @Test
    public void navigateToMorePage() throws IOException, ParseException, InterruptedException {
        MorePage more = new MorePage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to More page");
        wait.until(ExpectedConditions.visibilityOf(more.moreIconPage));
        Thread.sleep(4000);
        more.moreIconPage.click();
        Thread.sleep(4000);
        swipeScreen();
    }

    @Test
    public void myProfile() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can click and view its Profile page");
        Thread.sleep(4000);
        more.myProfileTab.click();
        Thread.sleep(4000);
       /* scrollIntoText("");
        more.copyBtn.click();
        Thread.sleep(4000);
        more.shareBtn.click();
        Thread.sleep(4000);
        tapByCoordinates();*/
        more.backBtn.click();
    }

    @Test
    public void linkedCards() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can navigate and view cards linked to his account");
        Thread.sleep(4000);
        more.linkCardTab.click();
        Thread.sleep(4000);
        more.backBtn.click();
    }

    @Test
    public void faq() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can navigate and check through the FAQs");
        Thread.sleep(4000);
        more.faqTab.click();
    }

    @Test
    public void generalFAQ() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can view questions on the General tab");
        Thread.sleep(4000);
        more.generalQuestionTab.click();
        Thread.sleep(7000);
        more.generalQuestionTab.click();
        Thread.sleep(4000);
        more.generalQuestionTab2.click();
        Thread.sleep(7000);
        more.generalQuestionTab2.click();
    }

    @Test
    public void savingsFAQ() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can view questions on the Savings tab");
        Thread.sleep(4000);
        more.savingsTab.click();
        Thread.sleep(4000);
        more.savingsQuestionTab.click();
        Thread.sleep(7000);
        more.savingsQuestionTab.click();
        Thread.sleep(4000);
        more.savingsQuestionTab2.click();
        Thread.sleep(7000);
        more.savingsQuestionTab2.click();
    }

    @Test
    public void loanFAQ() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can view questions on the Loan tab");
        Thread.sleep(4000);
        more.loansTab.click();
        Thread.sleep(4000);
        more.loanQuestionTab.click();
        Thread.sleep(7000);
        more.loanQuestionTab.click();
        Thread.sleep(4000);
        more.loanQuestionTab2.click();
        Thread.sleep(7000);
        more.loanQuestionTab2.click();
        Thread.sleep(4000);
        more.generalTab.click();
        Thread.sleep(4000);
        more.backBtn.click();
    }

    @Test
    public void rateRenmoney() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can rate Renmoney app");
        Thread.sleep(4000);
        more.rateRenmoney.click();
        Thread.sleep(4000);
        more.noBtn.click();
        Thread.sleep(4000);
        more.backBtn.click();

    }

    @Test
    public void referrals() throws InterruptedException {
        MorePage more = new MorePage(driver);
        testTitle("Verify User's can refer friend");
        Thread.sleep(4000);
        more.referralTab.click();
        Thread.sleep(1000);
        more.shareLink.click();
        Thread.sleep(2500);
        more.createShareBtn.click();
        Thread.sleep(1300);
        more.copyShareBtn.click();
        more.backBtn.click();
    }

    @Test
    public void securityQuestion() throws InterruptedException {
        MorePage more = new MorePage(driver);
        String food = (String) envs.get("food");
        testTitle("Verify User's can refer friend");
        Thread.sleep(4000);
        more.securityTab.click();
        Thread.sleep(1000);
        more.securityQuestionBtn.click();
        Thread.sleep(1000);
        more.securityQuestionDropdown.click();
        Thread.sleep(1500);
        more.securityQuestion.click();
        Thread.sleep(1700);
        more.answerField.click();
        more.answerField.sendKeys(food);
        driver.hideKeyboard();
        more.next.click();
        Thread.sleep(1600);
        more.returnToMorePage.click();
    }
    @Test
    public void changePin() throws InterruptedException {
        MorePage more = new MorePage(driver);
        String pin = (String) envs.get("pin");
        String newPin = (String) envs.get("newPin");
        String confirmPin = (String) envs.get("confirmPin");
        testTitle("Verify User's can successfully Pin");
        Thread.sleep(4000);
        more.securityTab.click();
        Thread.sleep(1000);
        more.changePinBtn.click();
        Thread.sleep(1000);
        more.currentPin.sendKeys(pin);
        Thread.sleep(1000);
        more.newPin.sendKeys(newPin);
        Thread.sleep(1000);
        more.confirmPin.sendKeys(confirmPin);
        Thread.sleep(2000);
        more.returnToMorePage.click();
    }

}
