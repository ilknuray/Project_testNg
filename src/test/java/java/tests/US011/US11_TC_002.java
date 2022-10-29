package java.tests.US011;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US11_TC_002 {
    @Test
    public void testUS11_tc02() throws InterruptedException {
        FatmaPage fatmaPage = new FatmaPage();
        Actions actions = new Actions(Driver.getDriver());

        //    ===============US11__TC02============

        //https://spendinggood.com/	1-Vendor spendinggood anasayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));
        //2-Vendor anasayfaya gittigini test eder
        String expectedUrl = "https://spendinggood.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

         //3- Vendor girisyap/uyeol butonunu tiklar
        fatmaPage.login.click();

        //4-Vendor gecerli emali adrsini girer
        //5-vendor gecerli sifre girer singn in yapar
        fatmaPage.userEmailBox.sendKeys(ConfigReader.getProperty("userEmail"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("userPassword"))
                .sendKeys(Keys.ENTER).perform();

        // Vendor singn in yapar
        fatmaPage.signIn.click();

        //6.Vendor My Account butonunu tiklar
        ReusableMethods.waitFor(5);
        fatmaPage.myAccount.click();

        //  ReusableMethods.waitFor(2);
        fatmaPage.storeManagerButton.click();

       //8-Vendor store manager sayfasina yonlendirildigini test eder
        String expectedUrl1 = "https://spendinggood.com/store-manager/";
        String actualUrl1 = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl1,(actualUrl1));

        //9-Vendor urunler butonunun ustune gelir ve yeni ekle'yi tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        actions.moveToElement(fatmaPage.productButonu).moveToElement(fatmaPage.addNew).click().perform();

       //10-vendor yeni urun ekleme sayfasina gittigini test eder
        String expectedUrl2="https://spendinggood.com/store-manager/products-manage/";
        String actualUrl2=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl2.contains(expectedUrl2));

        //11-Vendor Toptan Ürün Gösterme Ayarları butonunu tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        fatmaPage.toptanUrunGosterme.click();

        //12-Vendor Units per piece'den urunun birim miktarini belirler
        fatmaPage.unutPerPiece.click();

    }
}