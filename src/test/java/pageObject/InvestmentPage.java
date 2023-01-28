package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class InvestmentPage {

    @AndroidFindBy(accessibility = "Invest")
    public WebElement investIconBtn;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\" Start new \"])[1]")
    public WebElement newPlan;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter Plan Name')]")
    public WebElement planName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.view.View")
    public WebElement fixedNext;
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.view.View")
    public WebElement smartNext;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
    public WebElement investmentAmount;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"How long do you want to invest for?\"]")
    public WebElement investmentDuration;

    @AndroidFindBy(accessibility = "1 month(s)  (12.5%)")
    public WebElement chosenDuration;

    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ScrollView/android.widget.CheckBox")
    public WebElement checkBox;

    @AndroidFindBy(accessibility = "Continue")
    public WebElement continueBtn;

    @AndroidFindBy(accessibility = "1")
    public WebElement transactionPin1;

    @AndroidFindBy(accessibility = "2")
    public WebElement transactionPin2;

    @AndroidFindBy(accessibility = "3")
    public WebElement transactionPin3;

    @AndroidFindBy(accessibility = "4")
    public WebElement transactionPin4;

    @AndroidFindBy(accessibility = "Return to Home")
    public WebElement backToInvestmentPage;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"History\"]")
    public WebElement history;

    @AndroidFindBy(accessibility = "  Withdraw ")
    public WebElement withdrawal;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"  Withdraw \"])[1]")
    public WebElement smartWithdrawal;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.widget.ImageView")
    public WebElement cancelBtn;

    @AndroidFindBy(accessibility = "How long do you want to save for?")
    public WebElement smartTenure;

    @AndroidFindBy(accessibility = "3 month(s)")
    public WebElement chosenTenure;

    @AndroidFindBy(accessibility = "How often do you want to save?")
    public WebElement smartDuration;

    @AndroidFindBy(accessibility = "Daily")
    public WebElement smartChose;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\" Start new \"])[2]")
    public WebElement addRenFlex;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='7']")
    public WebElement renFlexAmount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[8]/android.view.View")
    public WebElement renFlexNext;

    @AndroidFindBy(xpath = "(//android.view.View[@content-desc=\"  Withdraw \"])[2]")
    public WebElement withdrawRenFlex;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter amount')]")
    public WebElement renFlexWithdrawAmount;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View")
    public WebElement withdrawalContinue;

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc=\"Save\"]")
    public WebElement saveIconBtn;

    public InvestmentPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
