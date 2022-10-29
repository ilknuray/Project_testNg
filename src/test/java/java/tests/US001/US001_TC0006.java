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

public class US001_TC0006 extends TestBaseRapor {

    US01_US02Page page=new US01_US02Page();
    Actions actions = new Actions(Driver.getDriver());


    @Test
    public void tc006() {


        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.registerMethod();
        extentTest.info(" Kullanıcı https://spendinggood.com/  URL'e  gider,Register butonuna tiklar, Become a Vendor görür ve tiklar");


        page.regEmailBox.sendKeys(ConfigReader.getProperty("uniqueEmail"));
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Team123*").sendKeys(Keys.TAB).sendKeys("Team123*").sendKeys(Keys.TAB).click().perform();
        ReusableMethods.waitFor(3);
        extentTest.info(" Vendor \"unique e-mail\" girer\n" + "  \"Samepassword\" girer\n" + " Vendor \"Register\" tıklar");

        Assert.assertTrue(page.uniquePositiveMsg.isDisplayed());
        extentTest.info("Vendor Green Block'u e -mail girişinde görebilir");
        extentTest.pass("Unique e-mail-Positive" );



    }
}
