package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @AndroidFindBy(xpath = "(//android.widget.ImageView)[1]")
    public WebElement renmoneyLogo;

    @AndroidFindBy(accessibility = "Get Started")
    public WebElement getStarted;

    @AndroidFindBy(accessibility = "Get started")
    public WebElement welcomeTxt;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter email address')]")
    public WebElement emailAddressField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[4]")
    public WebElement nextBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    public WebElement backBtn;

    @AndroidFindBy(xpath = "//android.widget.Toast[1]")
    public WebElement alert;

    @AndroidFindBy(id = "com.renmoney.android:id/profile_image")
    public WebElement profileImage;

    @AndroidFindBy(accessibility = "Welcome back, OGHENEKPAROBOR")
    public WebElement welcomeBackTxt;

    @AndroidFindBy(accessibility = "Log out")
    public WebElement logOutBtn;

    /*@AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Password')]")
    public WebElement passwordField;
*/
    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Enter password')]")
    public WebElement passwordField;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText/android.widget.Button")
    public WebElement showPassword;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[5]/android.view.View")
    public WebElement submitBtn;

    @AndroidFindBy(accessibility = "Home")
    public WebElement homeBtn;

    @AndroidFindBy(accessibility = "More")
    public WebElement moreIconPage;

    public LoginPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
