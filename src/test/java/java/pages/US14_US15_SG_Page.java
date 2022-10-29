package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US14_US15_SG_Page {
    public US14_US15_SG_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (xpath = "//*[text()='Sign In ']")
    public WebElement signInButton_click;
    @FindBy (xpath = "//*[@id='username']")
    public WebElement inputUserName;
    @FindBy (xpath = "//*[@id='password']")
    public WebElement inputPassword;
    @FindBy (xpath = "//*[@value='Sign In']")
    public WebElement submitSigninButton;
    @FindBy (xpath = "(//*[text()='My Account'])[1]")
    public WebElement myAccountLink;
    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerLink;
    @FindBy (xpath = "//*[@class='wcfmfa fa-gift']")
    public WebElement couponsLink;
    @FindBy (xpath = "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class']")
    public WebElement couponsAddNewButton;
    @FindBy (xpath = "//*[@id='minimum_amount']")
    public WebElement minSpendInput;
    @FindBy (xpath = "//*[@id='title']")
    public WebElement codeInput;
    @FindBy (xpath = "//input[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submitCouponButton;
    @FindBy (xpath = "//*[text()='Coupon Successfully Published.']")
    public WebElement succededCoupon;
    @FindBy (xpath = "//*[@id='maximum_amount']")
    public WebElement maxSpendInput;
    @FindBy (xpath = "//input[@id='individual_use']")
    public WebElement indivUseCheckBox;
    @FindBy (xpath = "//input[@id='exclude_sale_items']")
    public WebElement exSaleItems;
    @FindBy (xpath = "(//*[@class='select2-selection__rendered'])[4]")
    public WebElement excludeCatSelect;
    @FindBy (xpath = "//*[@id='coupons_manage_limit']")
    public WebElement limitTabLink;
    @FindBy (xpath = "//*[@id='usage_limit']")
    public WebElement usageLimitPercoupon;
    @FindBy (xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement limitUsageXitems;
    @FindBy (xpath = "//*[@id='usage_limit_per_user']")
    public WebElement perUserUsageLimit;







    @FindBy (xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-reviews']")
    public WebElement reviewButton;
}
