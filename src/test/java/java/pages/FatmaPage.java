package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FatmaPage {
    public FatmaPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//*[@class='w-icon-account']")
    public WebElement login;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement userEmailBox;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='menu-item-1074']")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@class='woocommerce-MyAccount-navigation-link woocommerce-MyAccount-navigation-link--wcfm-store-manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement storeManageGorunur;


    @FindBy(xpath = "//span[normalize-space()='Products']")
    public WebElement productButonu;

    @FindBy(xpath = " //a[@class='wcfm_menu_item active']")
    public WebElement productButon1;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;


    @FindBy(xpath = "//*[@class='wcfm_sub_menu_items wcfm_sub_menu_items_product_manage moz_class']")
    public WebElement addNew;

    @FindBy(xpath = "//div[contains(text(),'Inventory')]")
    public WebElement inventory;

    @FindBy(xpath = "//*[text()='Add Product']")
    public WebElement addNewText;

    @FindBy(xpath = "//*[@id='manage_stock']")
    public WebElement manageStockButon;


    @FindBy(xpath = "//*[@id='stock_qty']")
    public WebElement stockQty;

    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement backOrdersbutton;

    @FindBy(xpath = "//*[@value='notify']")
    public WebElement allowButNotifyCustomer;

    @FindBy(xpath = "//div[contains(text(),'Shipping')]")
    public WebElement shipping;

    @FindBy(xpath = "//*[@name='weight']\n")
    public WebElement weightBox;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[2]")
    public WebElement length;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[3]")
    public WebElement width;

    @FindBy(xpath = "(//*[@class='wcfm-text wcfm_ele simple variable booking'])[4]")
    public WebElement height;

    @FindBy(xpath = "//*[@id='shipping_class']")
    public WebElement shippingClass;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement atributes;

    @FindBy(xpath = " //*[@id='attributes_is_active_1']")
    public WebElement color;

    @FindBy(xpath = "//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes']")
    public WebElement colorAllSelect;


    @FindBy(xpath = "//*[@name='attributes[2][is_active]']")
    public WebElement size;

    @FindBy(xpath = "(//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes'])[2]")
    public WebElement sizeAllSelect;

    @FindBy(xpath = "//*[@class='page_collapsible wcfm_acf_products_manage_3116_collapsible simple variable external grouped booking collapse-close']")
    public WebElement toptanUrunGosterme;

    @FindBy(xpath = "(//a[@class=\"wcfm_product_title\"])[1]")
    public WebElement cocukElbise;

    @FindBy(xpath = "//*[@id='piecetype']")
    public WebElement peaceType;

    @FindBy(xpath = "//*[@id='unitpercart']")
    public WebElement unutPerPiece;

    @FindBy(xpath = "//*[@id='minorderqtytr']")
    public WebElement minOrderQ;


}
