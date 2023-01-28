package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import util.TestBase;

public class TransactionPage {

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeIconBtn;

    @AndroidFindBy(accessibility = "Send money")
    public WebElement sendMoneyBtn;

    @AndroidFindBy(accessibility = "Send Money\n" +
            "Move money around easily")
    public WebElement sendMoneyTab;

    @AndroidFindBy(accessibility = "Send to a new person")
    public WebElement newBeneficiary;

    @AndroidFindBy(accessibility = "Please select bank")
    public WebElement chooseBank;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Search')]")
    public WebElement searchField;

    @AndroidFindBy(accessibility = "GT Bank")
    public WebElement bankName;

    @AndroidFindBy(accessibility = "Renmoney MFB")
    public WebElement renmoney;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, '₦10,000.00')]")
//    /hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.widget.EditText[1]
    public WebElement amountField;

    @AndroidFindBy(xpath="//android.widget.EditText[@index='7']")
    public WebElement recipientAccount;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='11']")
    public WebElement narration;

    @AndroidFindBy(className = "android.widget.CheckBox")
    public WebElement saveBeneficiary;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    public WebElement send;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='9']")
    public WebElement transactionPin;

    @AndroidFindBy(accessibility = "OE\n" +
              "OGHENEKPAROBOR  EMINOKANJU\n" +
              "ACCESS BANK 1558299665")
    public WebElement savedBeneficiary;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Send money\n" +
            "Your saved beneficiaries\"]/android.widget.ImageView[2]")
    public WebElement searchBeneficiary;

    @AndroidFindBy(accessibility = "OJ\n" +
            "OGUNSANYA JOHN\n" +
            "Renmoney Microfinance Bank 3580021961")
    public WebElement searchedBeneficiary;

    @AndroidFindBy(accessibility = "Return to Home")
    public WebElement backToInvestmentPage;

    @AndroidFindBy(accessibility = "Get started")
    public WebElement welcomeTxt;

    public TransactionPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
