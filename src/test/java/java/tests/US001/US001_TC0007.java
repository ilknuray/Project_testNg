package java.tests.US001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01_US02Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US001_TC0007 extends TestBaseRapor {
    US01_US02Page page=new US01_US02Page();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void tc07() {
        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.registerMethod();
        extentTest.info(" Kullanıcı https://spendinggood.com/  URL'e  gider,Register butonuna tiklar, Become a Vendor görür ve tiklar");


        page.regEmailBox.sendKeys(ConfigReader.getProperty("uniqueEmail"));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).click().perform();
        page.regRegisterButton.click();
        extentTest.info(" Vendor \"unique e-mail\" girer\n" + "  \"password bos birakir\" \n" + " Vendor \"Register\" tıklar");


        Assert.assertTrue(page.uniqueNegativeMsg.isDisplayed());
        extentTest.info(" \"Email: This field is required.\"\n" +
                " error message'ını görür");
        extentTest.pass("Unique e-mail-Negative" );

    }
}
