package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MorePage {

    @AndroidFindBy(accessibility = "More")
    public WebElement moreIconPage;

    /*     Profile     */
    @AndroidFindBy(accessibility = "My Profile\n" +
            "Manage your personal details")
    public WebElement myProfileTab;

    @AndroidFindBy(accessibility = "Copy")
    public WebElement copyBtn;

    @AndroidFindBy(accessibility = "Share")
    public WebElement shareBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.ImageView")
    public WebElement backBtn;

    @AndroidFindBy(accessibility = "Linked cards\n" +
            "View your Linked cards")
    public WebElement linkCardTab;

    /*     FAQ    */
    @AndroidFindBy(accessibility = "FAQs\n" +
            "Got a question? We’ve got it covered")
    public WebElement faqTab;

    @AndroidFindBy(accessibility = "How do I apply for a loan?")
    public WebElement generalQuestionTab;

    @AndroidFindBy(accessibility = "Do I need to provide collateral to request a Renmoney loan?")
    public WebElement generalQuestionTab2;

    @AndroidFindBy(accessibility = "Savings")
    public WebElement savingsTab;

    @AndroidFindBy(accessibility = "Can I increase my savings whenever I want?")
    public WebElement savingsQuestionTab;

    @AndroidFindBy(accessibility = "How long does it take to get my money when I liquidate my Savings?")
    public WebElement savingsQuestionTab2;

    @AndroidFindBy(accessibility = "Loans")
    public WebElement loansTab;

    @AndroidFindBy(accessibility = "What Document do I need to apply for a loan?")
    public WebElement loanQuestionTab;

    @AndroidFindBy(accessibility = "Am I eligible for a Renmoney Loan?")
    public WebElement loanQuestionTab2;

    @AndroidFindBy(accessibility = "General")
    public WebElement generalTab;

    /*     Rate Renmoney   */

    @AndroidFindBy(accessibility = "Rate Renmoney")
    public WebElement rateRenmoney;

    @AndroidFindBy(accessibility = "No")
    public WebElement noBtn;

    @AndroidFindBy(accessibility = "Security\n" +
            "Protect your account")
    public WebElement securityTab;

    /*     Change Password   */

    @AndroidFindBy(accessibility = "Change Password")
    public WebElement changePasswordBtn;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Old Password')]")
    public WebElement oldPasswordField;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'New Password')]")
    public WebElement newPassword;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]/android.widget.Button")
    public WebElement showPasswordNew;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]/android.widget.Button")
    public WebElement showPasswordOld;

    @AndroidFindBy(accessibility = "Save")
    public WebElement save;

    /*     Security Question   */

    @AndroidFindBy(accessibility = "Security\n" +
            "Protect your account")
    public WebElement g;

    @AndroidFindBy(accessibility = "Security Question")
    public WebElement securityQuestionBtn;

    @AndroidFindBy(accessibility = "Your Security question")
    public WebElement securityQuestionDropdown;

    @AndroidFindBy(accessibility = "What is your favorite food?")
    public WebElement securityQuestion;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Your security answer')]")
    public WebElement answerField;

//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View")
    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View")
    public WebElement next;

    @AndroidFindBy(accessibility = "Return to Home")
    public WebElement returnToMorePage;

                            /*     Referral     */

    @AndroidFindBy(accessibility = "Referrals\n" +
            "Earn N500 for each successful loan referral")
    public WebElement referralTab;

    @AndroidFindBy(accessibility="https://renmoney.page.link/gbrz")
    public WebElement shareLink;

    @AndroidFindBy(accessibility = "Share referral link")
    public WebElement createShareBtn;

    @AndroidFindBy(id = "android:id/chooser_copy_button")
    public WebElement copyShareBtn;

    /*     Change Pin      */

    @AndroidFindBy(accessibility = "Change Pin")
    public WebElement changePinBtn;

    @AndroidFindBy(accessibility = "Share referral link")
    public WebElement currentPin;

    @AndroidFindBy(accessibility = "Share referral link")
    public WebElement newPin;

    @AndroidFindBy(accessibility = "Share referral link")
    public WebElement confirmPin;

    public MorePage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
