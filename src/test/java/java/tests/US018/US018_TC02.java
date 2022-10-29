package java.tests.US018;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US18_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US018_TC02 {
    US18_19_Page page = new US18_19_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void TC02() throws IOException {

     //   1-vendor "https://tradylinn.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spendUrl"));
     //   2-vendor "Giriş yap" Butonuna tıklar
        page.signIn.click();
     //   "3-vendor ""vendor adı veya e-posta adresi""
        page.email.sendKeys(ConfigReader.getProperty("userName"));

     //   4-vendor "Parola" inputtuna gecerli parolayı girer
        page.password.sendKeys(ConfigReader.getProperty("password"));
     //   5-vendor "GİRİŞ YAP" butonuna tıklar
        page.signIn2.click();
        ReusableMethods.waitFor(5);
     //   6-Vendor "Hesabım" butonuna tiklar
        page.myAccount.click();
     //   7-vendor pano dan "Store Manager" butonunu tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        page.storeManager.click();

        //   8-vendor "Geri Ödeme " butonunu tıklar

        ReusableMethods.jsExecutorClick(page.refund);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

     //   9-vendor ödeme listesinde "Order ID" bilgisinin oldugunu test eder
        Assert.assertTrue(page.orderId.isDisplayed());
        ReusableMethods.getScreenshot("isim,OrderId");

    }

}
