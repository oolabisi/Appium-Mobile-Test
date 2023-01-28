package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.InvestmentPage;
import pageObject.LoanPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.*;

public class LoanTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public LoanTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("loan");
    }

    @Test
    public void navigateToLoanPage() throws InterruptedException, IOException, ParseException {
        LoanPage loan = new LoanPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to Loan page");
        wait.until(ExpectedConditions.visibilityOf(loan.loanIconBtn));
        Thread.sleep(4000);
        loan.loanIconBtn.click();
    }

    @Test
    public void businessLoan() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(1000);
        loan.businessApply.click();
    }

    @Test
    public void aboutRenMoney() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can share how they heard about RenMoney");
        Thread.sleep(2000);
        loan.heardRenMoney.click();
        loan.socialMedia.click();
        tapByCoordinates(679, 591);
        loan.confirmBtn.click();
    }

    @Test
    public void backToLoanPage() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate back to Loan page");
        Thread.sleep(2000);
        loan.backBtn.click();
    }

    @Test
    public void PersonalLoan() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(1000);
        loan.personalApply.click();
        loan.loanCheckbox.click();
        loan.next.click();
    }

    @Test
    public void locationCheck() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(1000);
        loan.accessLocation.click();
    }

    @Test
    public void amountToLoan() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        String amount = (String) envs.get("invalidAmount");
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(3000);
        loan.loanAmount.click();
        loan.loanAmount.sendKeys(amount);
        loan.loanPurpose.click();
        loan.loanPurposeChosen.click();
        tapByCoordinates(642,1274);
        loan.nextPage.click();
    }

    @Test
    public void basicDetails() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        String address = (String) envs.get("address");
        String nokPhoneNumber = (String) envs.get("nokPhoneNumber");
        String nokName = (String) envs.get("nokName");
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(3000);
        loan.homeAddress.click();
        loan.homeAddress.sendKeys(address);
        loan.maritalStatus.click();
        loan.chosenStatus.click();
        loan.state.click();
        swipeScreen();
        swipeScreen();
        swipeScreen();
        swipeScreen();
        loan.chosenState.click();
        Thread.sleep(2000);
        driver.hideKeyboard();
        loan.lga.click();
        swipeScreen();
        swipeScreen();
        swipeScreen();
        loan.chosenLGA.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.educationStatus.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.chosenEducation.click();
        driver.hideKeyboard();
        swipeScreen();
        Thread.sleep(2000);
        loan.nok.click();
        loan.nok.sendKeys(nokName);
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.nokRelationship.click();
        loan.chosenNOK.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.nokPhoneNumber.click();
        loan.nokPhoneNumber.sendKeys(nokPhoneNumber);
        Thread.sleep(2000);
        driver.hideKeyboard();
        loan.nokNext.click();
    }

    @Test
    public void employmentDetails() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        String companyName = (String) envs.get("companyName");
        String salary = (String) envs.get("salary");
        String companyAddress = (String) envs.get("companyAddress");
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(3000);
        loan.employmentStatus.click();
        loan.chosenEmployment.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.companyName.click();
        loan.companyName.sendKeys(companyName);
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.dateJoined.click();
        loan.dateOK.click();
        driver.hideKeyboard();
//        swipeScreen();
        Thread.sleep(2000);
        loan.sector.click();
        loan.chosenSector.click();
        driver.hideKeyboard();
        Thread.sleep(3000);
        loan.industry.click();
        Thread.sleep(4000);
        loan.chosenIndustry.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        swipeScreen();
        Thread.sleep(2000);
        loan.monthlySalary.click();
        loan.monthlySalary.sendKeys(salary);
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.companyAddress.click();
        loan.companyAddress.sendKeys(companyAddress);
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.companyState.click();
        loan.chosenCompanyState.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.companyLGA.click();
        loan.chosenCompanyLGA.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.nokNext.click();
    }

    @Test
    public void bankDetails() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        String bankUsed = (String) envs.get("bankUsed");
        String accountNumber = (String) envs.get("accountNumber");
        String nokPhoneNumber = (String) envs.get("nokPhoneNumber");
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(3000);
        loan.bank.click();
        loan.searchBank.click();
        loan.searchBank.sendKeys(bankUsed);
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.chosenBank.click();
        driver.hideKeyboard();
        Thread.sleep(2000);
        loan.accountNumber.click();
        loan.accountNumber.sendKeys(accountNumber);
        Thread.sleep(2000);
        loan.ok.click();
        tapByCoordinates(1154,1444);
        loan.linkedPhone.click();
        loan.linkedPhone.sendKeys(nokPhoneNumber);
        tapByCoordinates(1154,1444);
        loan.detailsNext.click();
    }

    @Test
    public void applicationReview() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(3000);
        swipeScreen();
        loan.submit.click();
    }

   /* @Test
    public void businessLoan() throws InterruptedException {
        LoanPage loan = new LoanPage(driver);
        testTitle("Verify User's can navigate to Business Loan");
        Thread.sleep(1000);
        loan.businessApply.click();
    }*/

}
