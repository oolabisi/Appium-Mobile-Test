package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class AddMoneyPage {

    @AndroidFindBy(accessibility = "Add money")
    public WebElement addMoneyBtn;

    @AndroidFindBy(accessibility = "Account number\n" +
            "3580017384")
    public WebElement copyAccount;

    @AndroidFindBy(accessibility = "Share")
    public WebElement shareAccount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    public WebElement backBtn;

    @AndroidFindBy(accessibility = "Card\n" +
            "Add money with a\n" +
            "debit card")
    public WebElement addMoneyWithCardBtn;

    @AndroidFindBy(accessibility = "Add new card")
    public WebElement addNewCardBtn;

    @AndroidFindBy(accessibility = "Bank Transfer\n" +
            "Add money from any bank account")
    public WebElement addMoneyWithTransfer;

//    @AndroidFindBy(xpath = "//android.widget.EditText[@text, '0000 0000 0000 0000']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[1]")
    public WebElement addCardNumber;

//    @AndroidFindBy(xpath = "//android.widget.EditText[@text, 'MM/YY']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[2]")
    public WebElement addCardDate;

//    @AndroidFindBy(xpath = "//android.widget.EditText[@text, '***']")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[3]")
    public WebElement addCardCVV;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    public WebElement next;

    @AndroidFindBy(accessibility = "//android.widget.EditText[@text, '₦10,000']")
    public WebElement addAmount;

    @AndroidFindBy(accessibility = "Change card")
    public WebElement addFromRenmoney;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public WebElement addPin;

    @AndroidFindBy(accessibility = "Return to Home")
    public WebElement returnBackHomeBtn;

    public AddMoneyPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
