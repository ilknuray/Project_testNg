package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US003_US004Page {
    public US003_US004Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Sign In ']")
    public WebElement signInButton1;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signInButton2;

    @FindBy(xpath = "//a[text()='My Account']")
    public WebElement myAccountButton;

    @FindBy(xpath = "//a[text()='Orders']")
    public WebElement ordersButton;

    @FindBy(xpath = "//a[@class='woocommerce-Button button btn btn-link btn-underline btn-icon-right']")
    public WebElement browseProductsButton;

    @FindBy(xpath = "//a[normalize-space()='Go Shop']")
    public WebElement goShopButton;


    @FindBy (css = "[class=\"product-wrap\"]")
    public List<WebElement> orders;

    @FindBy (css = "[class=\"btn-product-icon product_type_simple add_to_cart_button ajax_add_to_cart\"]")
    public List<WebElement> addToCardButton;

    @FindBy (xpath = "//*[@class='w-icon-cart']")
    public WebElement cartButton;

    @FindBy (xpath = "//a[@class='button wc-forward']")
    public WebElement viewCartButton;

    @FindBy (xpath = "(//button[@title='Minus'])[1]")
    public WebElement minusButton;


    @FindBy (xpath = "(//button[@title='Plus'])[1]")
    public WebElement plusButton;


    @FindBy (xpath = "//*[.='Update cart']")
    public WebElement updateCartButton;

    @FindBy (xpath = "//div[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement cartUpdatedText;

    @FindBy (xpath = "//*[@class='woocommerce-shipping-destination']")
    public WebElement shippingInformationText;

    @FindBy (xpath = "//button[@name='apply_coupon']")
    public WebElement applyCouponButton;

    @FindBy (xpath = "//button[@name='clear_cart']")
    public WebElement clearCartButton;

    @FindBy (xpath = "//a[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckoutButton;

    @FindBy (xpath = "//input[@id='billing_first_name']")
    public WebElement firstNameTextBox;

    @FindBy (xpath = "//button[@class='button alt']")
    public WebElement placeOrderButton;

    @FindBy (xpath = "//*[.='Billing address']")
    public WebElement billingAdressText;





















}
