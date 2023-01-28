package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeIconBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    public WebElement backBtn;

    @AndroidFindBy(accessibility = "Navigate up")
    public WebElement navigateUp;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='0']")
    public WebElement chatRenmoney;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@index='1']")
    public WebElement notification;

    @AndroidFindBy(accessibility = "Invest and Earn\n" +
            "Invest for the future, earn up to 16% interest p.a.")
    public WebElement investAndEarnBtn;

    @AndroidFindBy(accessibility = "History")
    public WebElement historyBtn;

    @AndroidFindBy(accessibility = "Refer a friend to earn N500")
    public WebElement referAFriend;

    @AndroidFindBy(accessibility = "Add money")
    public WebElement addMoneyBtn;

    @AndroidFindBy(accessibility = "Send money")
    public WebElement sendMoneyBtn;

    @AndroidFindBy(accessibility = "Buy Airtime")
    public WebElement buyAirtimeBtn;

    @AndroidFindBy(accessibility = "Pay Bills")
    public WebElement payBillsBtn;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Save\"]")
    public WebElement saveBtn;

    @AndroidFindBy(accessibility = "Apply")
    public WebElement loanApplyBtn;

    @AndroidFindBy(accessibility = "Airtime, Data & Bills\n" +
            "Pay bills, buy airtime - whenever, wherever")
    public WebElement purchaseAirtimeBtn;

    @AndroidFindBy(accessibility = "Debit Cards\n" +
            "Coming soon")
    public WebElement debitCardBtn;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Save\"]")
    public WebElement saveIconBtn;

    @AndroidFindBy(accessibility = "Loan")
    public WebElement loanIconBtn;

    @AndroidFindBy(accessibility = "Invest")
    public WebElement investIconBtn;

    @AndroidFindBy(accessibility = "More")
    public WebElement moreIconBtn;

    @AndroidFindBy(accessibility = "Cable TV\n" +
            "Pay your DSTV, GoTV & other cable subscriptions")
    public WebElement cableTab;

    @AndroidFindBy(accessibility = "choose agent")
    public WebElement chooseAgent;

    @AndroidFindBy(accessibility = "GOTv (MultiChoice) Subscription Payment")
    public WebElement chosenAgent;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Smart Card Number')]")
    public WebElement cardNumber;

    @AndroidFindBy(accessibility = "Select cable")
    public WebElement selectCable;

    @AndroidFindBy(accessibility = "GOtv Max")
    public WebElement chosenCable;

    @AndroidFindBy(accessibility = "Select plan")
    public WebElement planAmount;

    @AndroidFindBy(accessibility = "3 months at ₦12,450")
    public WebElement chosenAmount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[7]/android.view.View")
    public WebElement next;

    @AndroidFindBy(accessibility = "1")
    public WebElement transaction1;

    @AndroidFindBy(accessibility = "2")
    public WebElement transaction2;

    @AndroidFindBy(accessibility = "3")
    public WebElement transaction3;

    @AndroidFindBy(accessibility = "4")
    public WebElement transaction4;

    public DashboardPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
