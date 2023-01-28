package test;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.LoginPage;
import util.TestBase;

import java.io.FileReader;
import java.io.IOException;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static util.Utilities.*;
import static util.Utilities.testTitle;

public class LoginTestPage extends TestBase {
    JSONParser parser = new JSONParser();
    JSONObject config, envs;

    @Parameters({"dataEnv"})
    public LoginTestPage(String dataEnv) throws IOException, ParseException {
        config = (JSONObject) parser.parse(new FileReader("src/test/java/testData/" + dataEnv + ".json"));
        envs = (JSONObject) config.get("login");
    }

    @Test
    public void navigateToSignIn(){
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that User can click on Get Started tab");
        wait.until(ExpectedConditions.visibilityOf(loginPage.getStarted));
        loginPage.getStarted.click();
        checkIfVisible(loginPage.emailAddressField);

    }

    @Test
    public void unregisteredEmail() throws InterruptedException {
        String newEmail = (String) envs.get("newEmail");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that User gets an error when invalid email is entered");
        wait.until(ExpectedConditions.visibilityOf(loginPage.welcomeTxt));
//        assertFalse(loginPage.nextBtn.isEnabled());
        loginPage.emailAddressField.click();
        loginPage.emailAddressField.sendKeys(newEmail);
        driver.hideKeyboard();
        Thread.sleep(700);
        loginPage.nextBtn.click();
        Thread.sleep(1400);
        loginPage.backBtn.click();

    }

    @Test
    public void incompleteEmail() throws InterruptedException {
        String incompleteEmail = (String) envs.get("incompleteEmail");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that next button is disabled when incomplete email is entered");
        wait.until(ExpectedConditions.visibilityOf(loginPage.welcomeTxt));
//        assertFalse(loginPage.nextBtn.isEnabled());
        loginPage.emailAddressField.click();
        loginPage.emailAddressField.sendKeys(incompleteEmail);
        driver.hideKeyboard();
        Thread.sleep(500);
        loginPage.emailAddressField.clear();

    }

    @Test
    public void validEmail() throws InterruptedException {
        String validEmail = (String) envs.get("validEmail");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify the Password page is displayed after valid email is verified");
        wait.until(ExpectedConditions.visibilityOf(loginPage.welcomeTxt));
//        assertFalse(loginPage.nextBtn.isEnabled());
        loginPage.emailAddressField.click();
        loginPage.emailAddressField.sendKeys(validEmail);
        driver.hideKeyboard();
        Thread.sleep(900);
        loginPage.nextBtn.click();

    }

    @Test
    public void profileImage() throws InterruptedException {
        String firstname = (String) envs.get("firstname");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that profile image is visible");
        wait.until(ExpectedConditions.visibilityOf(loginPage.welcomeBackTxt));
        assertFalse(loginPage.submitBtn.isEnabled());
        checkIfVisible(loginPage.profileImage);
        assertText(loginPage.welcomeBackTxt, "Welcome back, "+firstname.toUpperCase());
    }

    @Test
    public void invalidPassword() throws InterruptedException {
        String invalidPassword = (String) envs.get("invalidPassword");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that invalid password returns an error");
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys(invalidPassword);
        driver.hideKeyboard();
        Thread.sleep(700);
        loginPage.submitBtn.click();
        loginPage.passwordField.clear();

    }

    @Test
    public void showPassword() throws InterruptedException {
        String invalidPassword = (String) envs.get("invalidPassword");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that show password icon can be toggled");
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys(invalidPassword);
        driver.hideKeyboard();
        Thread.sleep(900);
//        assertFalse(Boolean.parseBoolean(loginPage.showPassword.getAttribute("checked")));
        loginPage.showPassword.click();
        Thread.sleep(700);
        loginPage.passwordField.clear();
    }

    @Test
    public void validPassword() throws InterruptedException {
        String validPassword = (String) envs.get("validPassword");
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verified that Dashboard page is log on to when valid password is verified");
//        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordField));
        loginPage.passwordField.click();
        loginPage.passwordField.sendKeys(validPassword);
        /*tapByCoordinates(964, 1003);
        Thread.sleep(500);
        tapByCoordinates(964, 1003);*/
        driver.hideKeyboard();
        Thread.sleep(500);
        loginPage.submitBtn.click();
        wait.until(ExpectedConditions.visibilityOf(loginPage.homeBtn));
        Thread.sleep(1500);

    }

    @Test
    public void signOut() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        testTitle("Verify that Sign out button takes you back to Enter email page");
        loginPage.moreIconPage.click();
        scrollByContentDesc("v3.0.3 [104]");
        checkIfVisible(loginPage.logOutBtn);
        loginPage.logOutBtn.click();
        Thread.sleep(200);
       /* wait.until(ExpectedConditions.visibilityOf(loginPage.emailAddressField));
        checkIfVisible(loginPage.emailAddressField);
        Thread.sleep(1000);
        driver.hideKeyboard();
        Thread.sleep(1000); */

    }


}
