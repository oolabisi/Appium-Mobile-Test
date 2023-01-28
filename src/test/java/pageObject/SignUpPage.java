package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get started")
    public WebElement welcomeTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter password']")
    public WebElement enterPassword;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Repeat password']")
    public WebElement repeatPassword;

    @AndroidFindBy(xpath = "//android.widget.CheckBox")
    public WebElement checkbox;

/*    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;*/

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter email address')]")
    public WebElement emailAddressField;

    public SignUpPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
