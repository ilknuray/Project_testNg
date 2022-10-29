package java.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EmailPage {

    public EmailPage() {
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath="//*[@class='email']")
    public WebElement mailCopy;

    @FindBy(xpath="(//*[@class='unseen'])[1]")
    public WebElement mailCodeButton;


    @FindBy(xpath="//div[@class='body']//iframe")
    public WebElement iframe;

    @FindBy(xpath="//b")
    public WebElement verifyCode;
}

