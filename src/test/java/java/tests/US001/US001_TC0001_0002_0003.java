package java.tests.US001;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01_US02Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US001_TC0001_0002_0003 extends TestBaseRapor {

    US01_US02Page page = new US01_US02Page();
    Actions actions=new Actions(Driver.getDriver());


    @Test
    public void tc01() throws InterruptedException {
        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.registerMethod();
        extentTest.info(" Kullanıcı https://spendinggood.com/  URL'e  gider,Register butonuna tiklar, Become a Vendor görür ve tiklar");

    }

    @Test (dependsOnMethods = "tc01")
    public void tc02() {

        Assert.assertTrue(page.regEmailBox.isDisplayed()
                && page.regPasswordBox.isDisplayed()
                && page.regConfirmPwdBox.isDisplayed());
        extentTest.info(" Kullanici e-mail, password ve confirm password kutucugunu görür");
        extentTest.pass("Kullanıcı Vendor, hesabına giriş yaptığında  \"Orders, Downloads, addresses, \n" +
                "account details,whislist ve Logout\" buttonlarını görür." );

    }


    @Test (dependsOnMethods = "tc01")
    public void tc03() {

        page.regEmailBox.sendKeys("team13@com");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
                sendKeys("Team123*").sendKeys(Keys.TAB).sendKeys("Team123*").sendKeys(Keys.TAB).click().perform();
        ReusableMethods.waitFor(3);
        extentTest.info(" Kullanici e-mail kutusuna gecersiz bir e-mail girer, parola girer, kayit dugmesine tiklar");

        Assert.assertTrue(page.gecersizEmailUyari.isDisplayed());
        extentTest.info("Vendor kirmizi uyariyi görür");
        extentTest.pass("Kullanıcı vendor olarak kayıt olabilmek icin\n" +
                " Registration sayfasında \" Become a Vendor\"\n" + "gecersiz email ve uyari");

    }



}
