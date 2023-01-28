package pageObject;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoanPage {

    @AndroidFindBy(accessibility = "Loan")
    public WebElement loanIconBtn;

    @AndroidFindBy(xpath = "//android.widget.CheckBox[@index='9']")
    public WebElement loanCheckbox;

    @AndroidFindBy(accessibility = "Continue")
    public WebElement next;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_one_time_button")
    public WebElement accessLocation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='3']")
    public WebElement loanAmount;

    @AndroidFindBy(accessibility = "Select loan purpose")
    public WebElement loanPurpose;

    @AndroidFindBy(accessibility = "Emergency")
    public WebElement loanPurposeChosen;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Apply now\"])[1]")
    public WebElement personalApply;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[6]/android.view.View")
    public WebElement nextPage;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='2']")
    public WebElement homeAddress;

    @AndroidFindBy(accessibility = "Single")
    public WebElement maritalStatus;

    @AndroidFindBy(accessibility = "Married")
    public WebElement chosenStatus;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='6']")
    public WebElement state;

    @AndroidFindBy(accessibility = "Sokoto")
    public WebElement chosenState;

    @AndroidFindBy(accessibility = "Select LGA")
    public WebElement lga;

    @AndroidFindBy(accessibility = "Wamako")
    public WebElement chosenLGA;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='10']")
    public WebElement educationStatus;

    @AndroidFindBy(accessibility = "Graduate")
    public WebElement chosenEducation;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    public WebElement nok;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    public WebElement nokRelationship;

    @AndroidFindBy(accessibility = "Sibling")
    public WebElement chosenNOK;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='10']")
    public WebElement nokPhoneNumber;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.widget.ScrollView/android.view.View[7]/android.view.View")
    public WebElement nokNext;

    @AndroidFindBy(accessibility = "Self-Employed")
    public WebElement employmentStatus;

    @AndroidFindBy(accessibility = "Employed\n" +
            "I earn a salary every month")
    public WebElement chosenEmployment;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    public WebElement companyName;

    @AndroidFindBy(xpath = "//android.view.View[@index='6']")
    public WebElement dateJoined;

    @AndroidFindBy(accessibility = "OK")
    public WebElement dateOK;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    public WebElement sector;

    @AndroidFindBy(accessibility = "Financial Services")
    public WebElement chosenSector;

    @AndroidFindBy(accessibility = "Select Industry")
    public WebElement industry;

    @AndroidFindBy(accessibility = "Asset management")
    public WebElement chosenIndustry;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='4']")
    public WebElement monthlySalary;

    @AndroidFindBy(xpath = "//android.widget.EditText[@index='6']")
    public WebElement companyAddress;

    @AndroidFindBy(xpath = "//android.widget.Button[@index='8']")
    public WebElement companyState;

    @AndroidFindBy(accessibility = "Bayelsa")
    public WebElement chosenCompanyState;

    @AndroidFindBy(accessibility = "Select LGA")
    public WebElement companyLGA;

    @AndroidFindBy(accessibility = "Southern Ijaw")
    public WebElement chosenCompanyLGA;

    @AndroidFindBy(xpath = "//android.view.View[contains(@text, 'Select bank')]")
    public WebElement bank;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Search')]")
    public WebElement searchBank;

    @AndroidFindBy(accessibility = "GT Bank")
    public WebElement chosenBank;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text, 'Account number')]")
    public WebElement accountNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@text,'Phone number')]")
    public WebElement linkedPhone;

    @AndroidFindBy(accessibility = "Ok")
    public WebElement ok;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[11]/android.view.View")
    public WebElement detailsNext;

    @AndroidFindBy(accessibility = "Submit")
    public WebElement submit;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc=\"Apply now\"])[2]")
    public WebElement businessApply;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc=\"How did you hear about us?\"]")
    public WebElement heardRenMoney;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc=\"Social media\"]/android.widget.CheckBox")
    public WebElement socialMedia;
    @AndroidFindBy(accessibility = "Confirm")
    public WebElement confirmBtn;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.widget.ImageView")
    public WebElement backBtn;

    /*  Loan Offer   */

    @AndroidFindBy(accessibility = " \uD83C\uDF89 Hey, your loan offers are ready!")
    public WebElement loanOfferBtn;

    @AndroidFindBy(accessibility = "Select amount")
    public WebElement offerAmount;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    public WebElement offerSelected;

    @AndroidFindBy(accessibility = "Select tenure")
    public WebElement offeredTenure;

    @AndroidFindBy(xpath = "//android.view.View[@index='0']")
    public WebElement chosenOffer;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[19]/android.view.View")
    public WebElement offerAccepted;

    public LoanPage(AndroidDriver<AndroidElement> driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
