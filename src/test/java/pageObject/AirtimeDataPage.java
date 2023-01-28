package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AirtimeDataPage {

    @AndroidFindBy(accessibility = "Buy Airtime")
    public WebElement buyAirtimeTab;

    @AndroidFindBy(accessibility = "Top-up your line for\n" +
            "calls and SMS\n" +
            "Buy airtime")
    public WebElement airtimeTab;

    @AndroidFindBy(accessibility = "Buy data to stay\n" +
            "connected\n" +
            "Buy data")
    public WebElement dataTab;

    @AndroidFindBy(accessibility = "Please select provider")
    public WebElement airtimeProvideTab;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Search')]")
    public WebElement searchForAirtime;

    @AndroidFindBy(accessibility = "Airtel Nigeria Airtime")
    public WebElement airtimeNetwork;

    @AndroidFindBy(accessibility = "MTN Nigeria Airtime")
    public WebElement dataNetwork;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Phone number\n" +
            "Choose from contact')]")
    public WebElement phoneNumberField;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'amount')]")
    public WebElement amountField;

    @AndroidFindBy(accessibility = "₦500")
    public WebElement amountOne;

    @AndroidFindBy(accessibility = "₦1,000")
    public WebElement amountTwo;

    @AndroidFindBy(accessibility = "₦2,000")
    public WebElement amountThree;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[3]/android.view.View")
    public WebElement next;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    public WebElement transactionPin;

    @AndroidFindBy(accessibility = "Return to Home")
    public WebElement returnToDashboard;

    @AndroidFindBy(accessibility = "Select Data Options")
    public WebElement dataOption;

    @AndroidFindBy(accessibility = "1.5GB for Monthly - Monthly - ₦1,000.00")
    public WebElement dataBundle;

   /* @AndroidFindBy(accessibility = "₦2,000")
    public WebElement amountThree;*/

    public AirtimeDataPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
