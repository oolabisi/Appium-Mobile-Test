package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.TransactionPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static util.Utilities.testTitle;

public class TransactionTestPage extends TestBase {

    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public TransactionTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("transfer");
    }

    @Test
    public void goToSendMoneyPage() throws IOException, ParseException, InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        JSONObject login = (JSONObject) config.get("login");
        String validEmail = (String) login.get("validEmail");
        String validPassword = (String) login.get("validPassword");

        login(validEmail, validPassword);
        testTitle("Verify User's can login and navigate to Invest page");
        wait.until(ExpectedConditions.visibilityOf(transact.sendMoneyBtn));
        Thread.sleep(4000);
        transact.sendMoneyBtn.click();
    }

    @Test
    public void sendMoneyPage() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
        transact.newBeneficiary.click();
        Thread.sleep(2000);
        transact.chooseBank.click();
        Thread.sleep(2000);
    }

    @Test
    public void chooseBank() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String bankName = (String) envs.get("bank");
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
        transact.searchField.click();
        Thread.sleep(2000);
        transact.searchField.sendKeys(bankName);
        driver.hideKeyboard();
        Thread.sleep(2000);
        transact.bankName.click();
    }

    @Test
    public void negativeMoney() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String negativeAmount = (String) envs.get("negativeAmount");
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
        transact.amountField.click();
        Thread.sleep(2000);
        transact.amountField.sendKeys(negativeAmount);
        Thread.sleep(2000);
        transact.amountField.clear();
    }

    @Test
    public void amountExceedingBalance() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String amountExceed = (String) envs.get("amountExceeding");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(2000);
        transact.amountField.click();
        transact.amountField.sendKeys(amountExceed);
        Thread.sleep(2000);
        transact.amountField.clear();
    }

    @Test
    public void validAmount() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String amount = (String) envs.get("amount");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.amountField.click();
        transact.amountField.sendKeys(amount);
    }

    @Test
    public void wrongRecipientNumber() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String wrongAccount = (String) envs.get("negativeAccount");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.recipientAccount.click();
        transact.recipientAccount.sendKeys(wrongAccount);
        driver.hideKeyboard();
        Thread.sleep(5000);
        transact.recipientAccount.clear();
    }

    @Test
    public void recipientAccount() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String account = (String) envs.get("account");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.recipientAccount.click();
        transact.recipientAccount.sendKeys(account);
        driver.hideKeyboard();
        Thread.sleep(3000);
        driver.hideKeyboard();
        transact.send.click();
    }

    @Test
    public void wrongTransactionPin() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String transactionPin = (String) envs.get("pin1");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(1000);
        transact.transactionPin.click();
        transact.transactionPin.sendKeys(transactionPin);
        Thread.sleep(1000);
        transact.transactionPin.click();
        transact.transactionPin.clear();
    }

    @Test
    public void transactionPin() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String transactionPin = (String) envs.get("pin");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.transactionPin.click();
        transact.transactionPin.sendKeys(transactionPin);
        driver.hideKeyboard();
    }

    @Test
    public void returnToSendMoneyPage() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(7000);
        transact.backToInvestmentPage.click();
    }

    @Test
    public void sendMoneyToRenmoneyPage() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        testTitle("Verify User can navigate to Send money page again");
        Thread.sleep(2000);
        transact.sendMoneyBtn.click();
        Thread.sleep(1000);
        transact.newBeneficiary.click();
        Thread.sleep(2000);
        transact.chooseBank.click();
        Thread.sleep(2000);
    }

    @Test
    public void chooseRenmoney() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String bankName = (String) envs.get("renBank");
        testTitle("Verify User can search and find Renmoney");
        Thread.sleep(2000);
        transact.searchField.click();
        Thread.sleep(2000);
        transact.searchField.sendKeys(bankName);
        driver.hideKeyboard();
        Thread.sleep(2000);
        transact.renmoney.click();
    }

    @Test
    public void negativeMoneyToRenmoney() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String negativeAmount = (String) envs.get("negativeAmount");
        testTitle("Verify User cannot send a negative amount");
        Thread.sleep(2000);
        transact.amountField.click();
        Thread.sleep(2000);
        transact.amountField.sendKeys(negativeAmount);
        Thread.sleep(2000);
        transact.amountField.clear();
    }

    @Test
    public void amountExceedingOwnerBalance() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String amountExceed = (String) envs.get("amountExceeding");
        testTitle("Verify User cannot add amount beyond what exist in his Account");
        Thread.sleep(2000);
        transact.amountField.click();
        transact.amountField.sendKeys(amountExceed);
        Thread.sleep(2000);
        transact.amountField.clear();
    }

    @Test
    public void validAmountToRenmoney() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String amount = (String) envs.get("amount");
        testTitle("Verify User can add amount within his account balance");
        Thread.sleep(3000);
        transact.amountField.click();
        transact.amountField.sendKeys(amount);
    }

    @Test
    public void wrongRenmoneyRecipientNumber() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String wrongAccount = (String) envs.get("account");
        testTitle("Verify User cannot add negative to recipient number");
        Thread.sleep(3000);
        transact.recipientAccount.click();
        transact.recipientAccount.sendKeys(wrongAccount);
        driver.hideKeyboard();
        Thread.sleep(5000);
        transact.recipientAccount.clear();
    }

    @Test
    public void renmoneyRecipientAccount() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String account = (String) envs.get("ren_account");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.recipientAccount.click();
        transact.recipientAccount.sendKeys(account);
        driver.hideKeyboard();
        Thread.sleep(3000);
        driver.hideKeyboard();
        transact.send.click();
    }

    @Test
    public void transactionPinForTransfer() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String transactionPin = (String) envs.get("pin");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.transactionPin.click();
        transact.transactionPin.sendKeys(transactionPin);
        driver.hideKeyboard();
    }

    @Test
    public void returnToSendMoneyPageAgain() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(7000);
        transact.backToInvestmentPage.click();
    }

    @Test
    public void sendMoneyToBeneficiary() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String beneficiary = (String) envs.get("beneficiary");
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
        transact.sendMoneyBtn.click();
        Thread.sleep(2000);
      transact.searchBeneficiary.click();
        transact.searchBeneficiary.sendKeys(beneficiary);
        Thread.sleep(2000);
        }

    @Test
    public void searchBeneficiary() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String beneficiary = (String) envs.get("beneficiary");
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
//        transact.searchBeneficiary.click();
//        transact.searchBeneficiary.sendKeys(beneficiary);
        transact.searchedBeneficiary.click();
        Thread.sleep(2000);
    }

    @Test
    public void beneficiaryAmount() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String amount = (String) envs.get("amount");
        String narration = (String) envs.get("narration");
        testTitle("Verify User can navigate to Send money page");
        Thread.sleep(2000);
        transact.amountField.click();
        Thread.sleep(1000);
        transact.amountField.sendKeys(amount);
        driver.hideKeyboard();
        Thread.sleep(2000);
        transact.narration.click();
        transact.narration.sendKeys(narration);
        driver.hideKeyboard();
        Thread.sleep(1300);
        transact.send.click();
    }

    @Test
    public void transactionPinForBeneficiary() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        String transactionPin = (String) envs.get("pin");
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(3000);
        transact.transactionPin.click();
        transact.transactionPin.sendKeys(transactionPin);
        driver.hideKeyboard();
    }

    @Test
    public void returnToDashboard() throws InterruptedException {
        TransactionPage transact = new TransactionPage(driver);
        testTitle("Verify User cannot add Amount beyond what exist in his Account");
        Thread.sleep(7000);
        transact.backToInvestmentPage.click();
        Thread.sleep(1500);
        transact.homeIconBtn.click();
    }
}



/*
Voters 90F5B0438F295808303
        Driver  DRZ0607AA
        passport  B01193974  OLD- A03443902


        Old passport Passed but Error message
        Driver  - Failed
        Voters -
*/
