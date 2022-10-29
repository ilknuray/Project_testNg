package java.tests.US001;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailPage;
import pages.US01_US02Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class US001_TC0005_TC0008 extends TestBaseRapor {
    US01_US02Page page = new US01_US02Page();
    EmailPage EmailPage =new EmailPage();
    String mailHandle;
    Actions action=new Actions(Driver.getDriver());
    String code;



    @Test
    public void tc05()  throws InterruptedException  {

        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.registerMethod();
        extentTest.info(" Kullanıcı https://spendinggood.com/  URL'e  gider,Register butonuna tiklar, Become a Vendor görür ve tiklar");
        String spendingHandle=Driver.getDriver().getWindowHandle();
        ReusableMethods.waitFor(2);


        Driver.getDriver().switchTo().newWindow(WindowType.TAB).get(ConfigReader.getProperty("mailSitesi"));
        mailHandle=Driver.getDriver().getWindowHandle();
        action.moveToElement(EmailPage.mailCopy).click().perform();
        Driver.getDriver().switchTo().window(spendingHandle);
        action.moveToElement(page.regEmailBox).click().perform();
        page.regEmailBox.sendKeys(Keys.CONTROL+"v");
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().window(mailHandle);
        ReusableMethods.waitFor(5);
        Driver.getDriver().navigate().refresh();
        action.moveToElement(EmailPage.mailCodeButton).click().perform();
        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().frame(EmailPage.iframe);
        ReusableMethods.waitFor(3);
        code= EmailPage.verifyCode.getText();
        Driver.getDriver().switchTo().window(spendingHandle);
        action.sendKeys(Keys.TAB).sendKeys(code).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("Team123*").sendKeys(Keys.TAB).sendKeys("Team123*" +Keys.ENTER).perform();
        Assert.assertTrue(page.successRegisterText.isDisplayed());
        ReusableMethods.waitFor(5);
        extentTest.info("Geçerli E -posta\" girer\n" + " Vendor \"Geçerli Parola\" girdisi girer\n" +
                "Vendor \"Kayıt\" düğmesine tıklar\n" + "  Vendor Green Block'u  görür");



        }


    @Test (dependsOnMethods = "tc05")
    public void tc08() {
        Assert.assertTrue(page.finishIt.isDisplayed());

        extentTest.info("Vendor Email'e gelen onay mailini onaylar");
        extentTest.pass("\"Registration succesfully complated\" ");
}
}