package java.tests.US001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01_US02Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US001_TC0004 extends TestBaseRapor {
    US01_US02Page page =new US01_US02Page();
    Actions actions=new Actions(Driver.getDriver());

    @Test
    public void tc0004() throws InterruptedException {

        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.registerMethod();
        extentTest.info(" Kullanıcı https://spendinggood.com/  URL'e  gider,Register butonuna tiklar, Become a Vendor görür ve tiklar");



        page.regEmailBox.click();
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Team123*").sendKeys(Keys.TAB).sendKeys("Team123*").sendKeys(Keys.TAB).click().perform();
        ReusableMethods.waitFor(3);
        extentTest.info(" Kullanici e-mail kutusunu bos birakir, parola girer, confirm password girer, kayit dugmesine tiklar");



        Assert.assertTrue(page.bosEmailUyari.isDisplayed());
        extentTest.info("Vendor kirmizi uyariyi görür");
        extentTest.pass("Kullanıcı vendor olarak kayıt olabilmek icin\n" +
                " Registration sayfasında \" Become a Vendor\"\n" + "bosEmailUyari");


    }
}



