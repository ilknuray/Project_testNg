package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US01_US02Page {

    public US01_US02Page() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath=" //a[@class='register inline-type']")
    public WebElement registerButton;
    @FindBy (xpath="(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVonderButton;

    @FindBy (xpath="//input[@id='user_email']")
    public WebElement regEmailBox;

    @FindBy (xpath="//input[@id='passoword']")
    public WebElement regPasswordBox;

    @FindBy (xpath="//input[@id='confirm_pwd']")
    public WebElement regConfirmPwdBox;


    @FindBy (xpath="//input[@id='wcfm_membership_register_button']")
    public WebElement regRegisterButton;

    @FindBy (xpath="//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement gecersizEmailUyari;
    @FindBy (xpath="//div[@class='wcfm-message wcfm-error']")
    public WebElement bosEmailUyari;

    @FindBy (xpath="//*[@class='wcfm-message email_verification_message']")
    public WebElement uniqueNegativeMsg;
    @FindBy (xpath="//*[@class='wcfm-message wcfm-success']")
    public WebElement successRegisterText;

    @FindBy (xpath="//*[text()='Welcome to Spending Good!']")
    public WebElement finishIt;

    //--------------------------------------US002---------------------------------------------------------//



    @FindBy (xpath="(//*[text()='Orders'])[1]")
    public WebElement ordersButton;
    @FindBy (xpath="(//*[text()='Orders'])[1]")
    public List<WebElement> ordersButton1;

    @FindBy (xpath="(//*[text()='Downloads'])[1]")
    public WebElement downloadButton;

    @FindBy (xpath="(//*[text()='Addresses'])[1]")
    public WebElement AddressesButton;

    @FindBy (xpath="(//*[text()='Account details'])[1]")
    public WebElement AccountButton;

    @FindBy (xpath="(//*[text()='Wishlist'])[1]")
    public WebElement WishlistButton;

    @FindBy (xpath="(//*[text()='Logout'])[1]")
    public WebElement logOutButton;

    @FindBy (xpath="(//*[text()='Dashboard'])[1]")
    public WebElement DashboardButton;

    @FindBy (xpath="(//*[text()='Store Manager'])[1]")
    public WebElement StoreManagerButton;


    @FindBy (xpath="(//*[text()='Support Tickets'])[1]")
    public WebElement SupportTicetsButton;

    @FindBy (xpath="(//*[text()='Support Tickets'])[1]")
    public WebElement FallowingButton;

    @FindBy (xpath="(//*[@class='wcfm-message email_verification_message wcfm-success'])")
    public WebElement uniquePositiveMsg;


}
