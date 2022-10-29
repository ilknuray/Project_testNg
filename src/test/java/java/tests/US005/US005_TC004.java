package java.tests.US005;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US005_TC004 extends TestBaseRapor {

    @Test
    public void US005_TC004() throws IOException {
        US005_006_007 us005_006_007 = new US005_006_007();

        extentTest = extentReports.createTest("Negatif test", "urun ismi,buyuk ve kucuk foto,kategori secilmeden urun eklenememeli");
        ReusableMethods.signIn();
        extentTest.info("Sayfaya basarili sekilde girildi");
        ReusableMethods.waitFor(3);
        us005_006_007.storeManager.click();
        extentTest.info("Store manager basligina tiklandi");
        ReusableMethods.waitFor(3);
        ReusableMethods.jsExecutorClick(us005_006_007.products);
        extentTest.info("Products basligina tiklandi");
        ReusableMethods.jsExecutorClick(us005_006_007.addNew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Add new butonuna tiklandi");
        //resim,baslik, kategori,fiyat girilmaden urun eklenememeli
        ReusableMethods.jsExecutorClick(us005_006_007.submitButon);
        extentTest.info("submit butonuna basildi");
        ReusableMethods.waitFor(3);
        ReusableMethods.waitForVisibility(us005_006_007.uyariYazisiNegatifTest, 15);
        Assert.assertTrue(us005_006_007.uyariYazisiNegatifTest.isDisplayed());
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.getScreenshot("Uyari yazilari");
        extentTest.pass("buyuk ve kucuk foto eklenmeli,urun ismi eklenmeli uyarilari goruntulendi");


    }
}
