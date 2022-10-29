package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SignInPage

{
    public SignInPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="(//*[.='Sign In '])[2]")
    public WebElement signInButton1;

    @FindBy (xpath="//input[@id='username']")
    public WebElement signInemailBox;


    @FindBy (xpath="//input[@id='password']")
    public WebElement signInPasswordBox;


    @FindBy (xpath="//button[@name='login']")
    public WebElement signInButton2;

    @FindBy (xpath="(//*[text()='My Account'])[1]")
    public WebElement myAccountButton;

}
