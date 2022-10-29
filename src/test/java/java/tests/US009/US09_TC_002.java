package java.tests.US009;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FatmaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_TC_002 {

    @Test
    public void testUS09_tc02() throws InterruptedException {
        FatmaPage fatmaPage =new FatmaPage();
        Actions actions = new Actions(Driver.getDriver());

        //    ===============US09__TC02============

       // https://spendinggood.com/	1-Vendor spendinggood anasayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("spendingGoodUrl"));

        //2-Vendor anasayfaya gittigini test eder
        String expectedUrl = "https://spendinggood.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // 3- Vendor girisyap/uyeol butonunu tiklar
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

        //7-Vendor Store Manager butununa tiklar
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

        //11-Vendor shipping butonunu tiklar
        ReusableMethods.jsScrollClick(fatmaPage.shipping);

        //12-vendor urunun Dimensions (cm) boyutlarini (lengh , width,heigth) girer
        fatmaPage.length.click();
        actions.sendKeys("20")
                .sendKeys(Keys.TAB).
                sendKeys("30").
                sendKeys(Keys.TAB).
                sendKeys("13").perform();

        //13-vendor Shipping class da urunun teslimat suresini secer
        Select select=new Select(fatmaPage.shippingClass);
        select.selectByVisibleText("No shipping class");

    }
}