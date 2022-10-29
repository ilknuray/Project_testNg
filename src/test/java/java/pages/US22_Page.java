package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class US22_Page {
    public US22_Page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    public WebElement signInButton;

    @FindBy(xpath = "//a[@class='login inline-type']")
    public WebElement signIn;

    @FindBy (xpath = "//*[@id='username']")
    public WebElement userName;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passWord;

    @FindBy(xpath = "//select[@name='product_cat']")
    public WebElement allCategories;

    @FindBy (xpath = "//*[text()='Daily Deals']")
    public WebElement dailyDeals;

    @FindBy (xpath = "//select[@name='orderby']")
    public WebElement dailyDealsDropDown;
}
