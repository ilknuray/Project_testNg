package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class US18_19_Page {
    public US18_19_Page() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
@FindBy(xpath = "//*[text()='Sign In ']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement email;

    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@value='Sign In']")
    public WebElement signIn2;


@FindBy(xpath = "(//*[text()='My Account'])[1]")
    public WebElement myAccount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='wcfm_menu_item '])[7]")
    public WebElement refund;

    @FindBy(xpath = "//*[text()='Request ID']")
    public WebElement requestId;

    @FindBy(xpath = "//*[text()='Order ID']")
    public WebElement orderId;

    @FindBy(xpath = "//*[text()='Amount']")
    public WebElement amount;


   @FindBy(xpath = "(//*[text()='Type'])[1]")
    public WebElement type;

    @FindBy(xpath = "(//*[text()='Reason'])[1]")
   public WebElement  reason;
    @FindBy(xpath = "//*[@class='sorting_disabled']")
    public List<WebElement> basliklar;

@FindBy(xpath = "(//*[@class='text'])[11]")
    public WebElement followers;

    @FindBy(xpath = "(//*[text()='Name'])[1]")
    public WebElement name;

    @FindBy(xpath = "(//*[text()='Email'])[1]")
    public WebElement  email2;

    @FindBy(xpath = "(//*[text()='Actions'])[1]")
    public WebElement actions ;







}
