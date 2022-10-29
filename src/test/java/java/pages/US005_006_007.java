package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US005_006_007 {
    public US005_006_007(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[text()='Sign In ']")
    public WebElement signin;

    @FindBy(xpath = "//input[@id='username']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Sign In']")
    public WebElement signin2;

    @FindBy(xpath = "//*[@id='menu-item-1074']")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//span[@class='wcfmfa fa-cube'])[1]")
    public WebElement products;

    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNew;

    @FindBy(xpath = "//strong[text()='Categories']")
    public WebElement categoriesBasligi;

    @FindBy(xpath = "//span[text()='Health & Beauty']")
    public WebElement healtAndBeatuyBasligi;

    @FindBy(xpath = "//ul[@id=\"product_cats_checklist\"]//*[@data-item=\"235\"]")
    public WebElement maviButon1;

    @FindBy(xpath = "//span[text()='Vitamin Supplements']")
    public WebElement vitaminSupplements;

    @FindBy(xpath = "//*[@id='product_cats_checklist']//li[15]/ul/li[6]/input")
    public WebElement vitaminCheckBox;

    @FindBy(xpath = "//span[text()='Best Seller']")
    public WebElement bestSeller;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[3]/input")
    public WebElement bestSellerCheckBox;

    @FindBy(xpath = "//span[text()='Electronics']")
    public WebElement elektrikElektronik;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[8]/input")
    public WebElement elektronicCheckbox;


    @FindBy(xpath = "//span[text()='Home & Garden']")
    public WebElement evYasam;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[16]/input")
    public WebElement evYasamCheckBox;

    @FindBy(xpath = "//span[text()='Books & Music & Film']")
    public WebElement bookMusicFilm;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[4]/input")
    public WebElement bookMusicFimCheckBox;



    @FindBy(xpath = "(//span[text()='Cosmetic'])[1]")
    public WebElement cosmetic;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_cat '])[16]")
    public WebElement cosmeticCheckBox;

    @FindBy(xpath = "(//span[text()='Fashion'])[1]")
    public WebElement fashion;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[9]/input")
    public WebElement fashionCheckBox;

    @FindBy(xpath = "//span[text()='Clothing']")
    public WebElement clothing;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[5]/input")
    public WebElement clothinCheckBox;

    @FindBy(xpath = "(//span[text()='Toys & Games'])[2]")
    public WebElement toysGames;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[25]/input")
    public WebElement toysGamesCheckBox;

    @FindBy(xpath = "//span[text()='Accessories']")
    public WebElement accessoires;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[1]/input")
    public WebElement accessoiresCheckBox;

    @FindBy(xpath = "//span[text()='New Arrivals']")
    public WebElement newArrivals;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[20]/input")
    public WebElement newArrivalsCheckBox;

    @FindBy(xpath = "//*[@id='product_cats_checklist']//li")
    public List<WebElement> kategoriList;

    @FindBy(xpath = "//*[@id='product_cats_checklist']/li[17]/input")
    public WebElement indirimliUrunlerCheckbox;

    @FindBy(xpath = "//span[text()='Indirimli Urunler']")
    public WebElement indirimliUrunler;

    //-----US007------//

    @FindBy(xpath = "//strong[text()='Product brands']")
    public WebElement markalar;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_35']")
    public WebElement elegantAuto;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[7]")
    public WebElement elegantAutoCheckbox;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_41']")
    public WebElement greenGrass;

    @FindBy(xpath = "//*[@id=\"product_brand\"]/li[10]/input")
    public WebElement greenGrassCheckbox;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_46']")
    public WebElement nodeJS;

    @FindBy(xpath = "//*[@id='product_brand']//li[17]/input")
    public WebElement nodeJScheckbox;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_47']")
    public WebElement ns8;

    @FindBy(xpath = "//*[@id='product_brand']//li[18]/input")
    public WebElement ns8checkbox;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_50']")
    public WebElement red;

    @FindBy(xpath = "//*[@id='product_brand']//li[23]/input")
    public WebElement redCheckbox;

    @FindBy(xpath = "//li[@class='product_cats_checklist_item checklist_item_52']")
    public WebElement skySuite;

    @FindBy(xpath = "//*[@id='product_brand']//li[26]/input")
    public WebElement skysuiteCheckbox;

    @FindBy(xpath = "//*[@class='product_cats_checklist_item checklist_item_55']")
    public WebElement sterling;

    @FindBy(xpath = "//*[@id='product_brand']//li[28]/input")
    public WebElement sterlingCheckbox;

    //------US005 01-----//
    @FindBy(xpath = "//thead/tr//th[5]")
    public WebElement status;

    @FindBy(xpath = "//thead/tr//th[6]")
    public WebElement stock;

    @FindBy(xpath = "//thead/tr//th[7]")
    public WebElement price;

    @FindBy(xpath = "//thead/tr//th[11]")
    public WebElement date;

    //------US005 02 -------//
    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_general_expander']/div[1]/p[1]")
    public WebElement virtual;

    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualCheckbox;

    @FindBy(xpath = "//*[@id='wcfm_products_manage_form_general_expander']/div[1]/p[2]")
    public WebElement downloadable;

    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadableCheckbox;

    //----- US005 TC005-----//

    @FindBy(xpath = "//strong[text()='Short Description']")
    public WebElement shortDescriptionBaslik;

    @FindBy(xpath = "//iframe[@id='excerpt_ifr']")
    public WebElement iframeShort;

    @FindBy(xpath = "(//*[@id='tinymce'])[1]")
    public WebElement shortDescriptoinKutusu;

    @FindBy(xpath = "(//strong[text()='Description'])[1]")
    public WebElement descriptionBaslik;

    @FindBy(xpath = "//iframe[@id='description_ifr']")
    public WebElement iframeDescription;

    @FindBy(xpath = "//*[@class='mce-content-body description post-type-page post-status-publish page-template-default locale-en-us mceContentBody webkit wp-editor html5-captions']")
    public WebElement descriptionKutusu;

    //-----US005 TC003----//
    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement titleKutusu;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement buyukFoto;

    @FindBy(xpath = "//*[@id='menu-item-browse']")
    public WebElement mediaLibrary;

    @FindBy(xpath = "//div[@class='attachment-preview js--select-attachment type-image subtype-png portrait']")
    public WebElement buyukFotoEkle;

    @FindBy(xpath = "//button[@class='button media-button button-primary button-large media-button-select']")
    public WebElement selectButonu;

    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement kucukFoto;

    @FindBy(xpath = "(//div[@class='thumbnail'])[2]")
    public WebElement kucukFotoEkle;

    @FindBy(xpath = "(//button[text()='Add to Gallery'])[2]")
    public WebElement addGalleryButon;

    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement fiyatKutusu;

    @FindBy(xpath = "//input[@id=\"sale_price\"]")
    public WebElement indirimliFiyatKutusu;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submitButon;


    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement tamamYazisi;

    @FindBy(xpath = "//*[text()='Featured img: This field is required.']")
    public WebElement uyariYazisiNegatifTest;













}
