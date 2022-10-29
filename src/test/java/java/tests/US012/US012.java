package java.tests.US012;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US012_US013Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US012 extends TestBaseRapor {

    US012_US013Page spend = new US012_US013Page();
    Actions actions = new Actions(Driver.getDriver());

    @Test
    public void US012_TC1201() throws IOException {
        //------------------------- TC1201 --------------------------------//
        extentTest=extentReports.createTest("Pozitif Test","Vendor Store manager olarak hesabına gidince tum portal a access elde edebilmeli");
        ReusableMethods.signIn();
        extentTest.info("Spendinggood Sayfasina basarili bir sekilde giris yapilabildi");
        //"vendor hesabım sayfasında ""Orders"" butonuna tiklar Siparişler sayfasına gider.
        spend.orders.click();
        extentTest.info("Orders sayfasina gidildi");
        //vendor Siparişler sayfasında siparişlerin olduğunu dogrular

        for (int i = 1; i < spend.orderlist.size(); i++) {
            if (spend.orderlist.size() >=1) {
                Assert.assertTrue(spend.orderlist.get(i).isDisplayed());
            } else Assert.assertFalse(spend.orderlist.get(i).isDisplayed());
            System.out.println(spend.orderlist.get(i).getText());
        }
        System.out.println("OrderListteki siparis sayisi :" + spend.orderlist.size());
        extentTest.info("Orders sayfasindaki siparisler dogrulandi");
        //ReusableMethods.getScreenshot("OrdersPage");

        //---------------------------------     TC1202   --------------------------------------

        //"indirimler" butonuna tıklar. İndirimler sayfasına gider.
        spend.downloads.click();
        extentTest.info("indirimler sayfasina gidildi");
        // ReusableMethods.getScreenshot("DownloadPage");

        //vendor indirimler sayfasında varsa indirimli ürünleri listelendigini dogrular
        Assert.assertTrue(spend.downloadsPage.isDisplayed());
        String NoDownloadsAvailableYetText = "No downloads available yet.";
        if (spend.downloadsPage.isDisplayed()) {
            Assert.assertTrue(spend.downloadsPage.getText().contains(NoDownloadsAvailableYetText));
            System.out.println("Herhangi bir urun henuz yok");
            extentTest.info("indirimler sayfasinda henuz urunolmadigi dogrulandi");
        } else {
            Assert.assertFalse(spend.downloadsPage.isDisplayed());
            extentTest.info("indirimler sayfasindaki urunler dogrulandi");
        }

        // ------------------------------   TC1203   -------------------------------------------

        //vendor "ADRESLER"" butonuna tıklar. Adresler sayfasına gider.
        for (int i = 0; i < 3; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        spend.addressesButton.click();
        extentTest.info("Addresler sayfasina gidildi");
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.waitFor(1);


        //vendor Adresler sayfasında "Billing Address/ Shipping Address" başlıklarının altında Adres bilgilerinin listelendigini dogrular
        Assert.assertTrue(spend.addresses.isDisplayed());
        spend.addressesList.forEach(t -> System.out.println(t.getText())); //adresleri konsolda yazdirdim
        //   ReusableMethods.getScreenshotWebElement("addresses",spend.addresses);
        extentTest.info("Addresler sayfasindaki 'Billing Address/ Shipping Address' basliklari altindaki bilgilerin listelendigi goruldu");

        // ------------------------------   TC1204   -------------------------------------------
        //vendor "Account details" butonuna tıklar. Account Details sayfasına gider.
        spend.accountButton.click();
        extentTest.info("Account detail butonuna tiklandi");
        //vendor Account details sayfasında hesap bilgilerini ve eposta adresi oldugunu dogrular
        Assert.assertTrue(spend.accountDetail.isDisplayed());
        Assert.assertTrue(spend.accountEmail.isDisplayed());
        extentTest.info("Account details sayfasında hesap bilgilerini ve eposta adresi oldugunu dogrulandi");
        //vendor Account details sayfasındaki bilgileri doldurarak "Save Change"
        Faker faker = new Faker();
        spend.firstName.clear();
        actions.click(spend.firstName).sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB).sendKeys(faker.name().fullName()).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("validemail")).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("validsifre")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("validsifre")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("validsifre")).sendKeys(Keys.TAB).perform();

        ReusableMethods.waitFor(1);
        spend.saveChanges.click();
        //butonuna tiklar "Account details changed successfully." yazisini dogrular
        Assert.assertTrue(spend.accountUpdated.isDisplayed());
        extentTest.pass("Account details sayfasında hesap bilgilerini Update edilebildi");
    }
}
