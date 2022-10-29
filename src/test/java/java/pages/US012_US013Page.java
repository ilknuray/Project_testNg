package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US012_US013Page {
    public US012_US013Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //----------------------------US012 TC1201 ----------------------------------//

    @FindBy(xpath = "//*[text()='Sign In ']")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(name = "login")
    public WebElement singInLogin;

    @FindBy(xpath ="//*[@id='menu-item-1074']")
    public WebElement myAccount;

    @FindBy(xpath ="//a[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath ="//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--orders']")
    public WebElement orders;

    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> orderlist;

    //------------------------------   US012_TC1202      ----------------------------------//

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--downloads']")
    public WebElement downloads;


    @FindBy(xpath = "//*[text()='No downloads available yet.']")
    public WebElement downloadsPage;


    //------------------------------   US012_TC1203      ----------------------------------//

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-address']")
    public WebElement addressesButton;

    @FindBy(xpath = "//*[@class='col-lg-6 mb-4']")
    public List<WebElement> addressesList;

    @FindBy(xpath = "//*[@class=\"woocommerce-MyAccount-content col-md-9 pt-2\"]")
    public WebElement addresses;


    //-----------------------------------US013 locate kodlari-----------------------------------------//
    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--edit-account']")
    public WebElement accountButton;

    @FindBy(xpath = "//*[@class=\"icon-box-title text-normal\"]")
    public WebElement accountDetail;

    @FindBy(xpath = "//*[@id=\"account_first_name\"]")
    public WebElement firstName;

    @FindBy(xpath = "//*[@id=\"account_email\"]")
    public WebElement accountEmail;

    @FindBy(xpath = "//*[@name=\"save_account_details\"]")
    public WebElement saveChanges;

    @FindBy(xpath = "//*[text()='Account details changed successfully.']")
    public WebElement accountUpdated;


    //----------------------------------- US013 -----------------------------------------//

    //----------------------------------- TC1301 -----------------------------------------//

    @FindBy(xpath = "//*[@class=\"wcfm_menu_items wcfm_menu_wcfm-coupons\"]")
    public WebElement couponsButton;

    @FindBy(xpath = "//*[@class=\"wcfm_sub_menu_items wcfm_sub_menu_items_coupon_manage moz_class\"]")
    public WebElement couponsAdd;

    @FindBy(css = "[name=\"title\"]")
    public WebElement code;

    @FindBy(css ="[id=\"discount_type\"]")
    public WebElement discountType;

    @FindBy(css ="[id=\"wcfm_coupon_manager_submit_button\"]")
    public WebElement submitButton;

    @FindBy(xpath = "//*[text()='Coupon Successfully Published.']")
    public WebElement couponCreatedSuccessText;

    @FindBy(xpath = "//*[@class=\"wcfm-message wcfm-error\"]")
    public WebElement codeEmptyResultText;

    @FindBy(xpath = "//*[text()='Coupon code already exists - customers will use the latest coupon with this code.']")
    public WebElement codeAlreadyExistText;
}
