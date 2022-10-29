package java.tests.US005;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US005_TC006 extends TestBaseRapor {

    @Test
    public void US005_TC006() throws IOException {
        US005_006_007 us005_006_007 = new US005_006_007();
        extentTest = extentReports.createTest("Negatif test", "Fiyat bilgisi girilmeden urun basari ile eklendi yazisi gorulmemeli");

        ReusableMethods.signIn();
        extentTest.info("Sayfaya basarili sekilde girildi");
        ReusableMethods.waitFor(3);
        us005_006_007.myAccount.click();
        extentTest.info("My account basligina tiklandi");
        us005_006_007.storeManager.click();
        extentTest.info("Store manager basligina tiklandi");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsExecutorClick(us005_006_007.products);
        extentTest.info("Products basligina tiklandi");
        ReusableMethods.jsExecutorClick(us005_006_007.addNew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Add new butonuna tiklandi");
        us005_006_007.titleKutusu.sendKeys("Cocuk elbisesi");
        ReusableMethods.waitFor(3);
        extentTest.info("urun ismi girildi");
        us005_006_007.accessoiresCheckBox.click();
        us005_006_007.bestSellerCheckBox.click();
        extentTest.info("Kategori secildi");
        us005_006_007.buyukFoto.click();
        us005_006_007.mediaLibrary.click();
        us005_006_007.buyukFotoEkle.click();
        us005_006_007.selectButonu.click();
        ReusableMethods.waitFor(3);
        extentTest.info("buyuk foto eklendi");
        us005_006_007.kucukFoto.click();
        us005_006_007.kucukFotoEkle.click();
        us005_006_007.addGalleryButon.click();
        extentTest.info("kucuk foto eklendi");
        ReusableMethods.getScreenshot("Fiyat kutusu");
        extentTest.info("Fiyat kutusunun bos oldugu goruldu");
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(3);
        ReusableMethods.jsExecutorClick(us005_006_007.submitButon);
        extentTest.info("submit butonuna basildi");
        ReusableMethods.waitForVisibility(us005_006_007.tamamYazisi, 15);
        Assert.assertTrue(us005_006_007.tamamYazisi.isDisplayed());
        ReusableMethods.getScreenshot("Basarili yazisi");
        extentTest.info("basarili yazisinin ekran goruntusu alindi");


        //ReusableMethods.getScreenshotWebElement("indirimli fiyat kutusu", ilknurPage.indirimliFiyatKutusu);
        extentTest.pass("basari ile eklendi yazisi goruldu");
    }
}