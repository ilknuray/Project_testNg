package java.tests.US013;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US012_US013Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US013 extends TestBaseRapor {
    US012_US013Page spend = new US012_US013Page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void TC1301() throws IOException {
        extentTest = extentReports.createTest("Pozitif Test", "Vendor Store manager olarak, kuponları olusturabilmeli");
        ReusableMethods.signIn();
        extentTest.info("Spendinggood Sayfasina basarili bir sekilde giris yapilabildi");

        //vendor hesabım sayfasında "Store Manager" butonuna tıklar.
        spend.storeManager.click();
        extentTest.info("Store Manager sayfasina basarili bir sekil gidildi");

        //Vendor "Coupons" sekmesinin uzerine gelir ve "Add New" secenegine tiklar.
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.waitFor(1);
        actions.moveToElement(spend.couponsButton).click(spend.couponsAdd).perform();
        extentTest.info("Coupons Sayfasina basarili bir sekilde gidildi");
        //"Manage Coupon" sayfasi acilir Vendor "Code" satirini "uniq" bir deger girer.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        spend.code.sendKeys(faker.number().digits(5));
        extentTest.info("Kupon Kodu girilebildi");

        //Vendor "Description" satirina bir tanimlama girer
        actions.sendKeys(Keys.TAB).sendKeys("This is a Coupon description")
                .sendKeys(Keys.TAB).perform();
        extentTest.info("Description yazisi yazilabildi");

        //Vendor "Discount Type" ta bir Dropdown secer
        Select options = new Select(spend.discountType);
        options.selectByIndex(1);
        extentTest.info("\"Discount Type\" secilebildi");
        //Vendor "Coupon Amount" satirina bir kupon tutari girer
        actions.sendKeys(Keys.TAB).sendKeys(faker.number().digits(2)).sendKeys(Keys.TAB).perform();
        extentTest.info("\"Coupon Amount\" satirina kupon tutari girilebildi");

        //Vendor "Coupon expiry date" satirina YYYY-MM-DD olacak sekilde gecerli bir tarih girer
        // Vendor "Allow free shipping" secenegini isaretler
        //Vendor "Show on store" secenegini isaretler
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formater = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String tarih = date.format(formater);
        actions.sendKeys(tarih).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).perform();
        extentTest.info("\"Coupon expiry date\" satirina YYYY-MM-DD olacak sekilde gecerli bir tarih girilebildi");

        //vendor "SIGN IN" butonuna tıklar
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.waitFor(1);
        spend.submitButton.click();
        extentTest.info("\"Submit\" butonuna tiklanabildi");

        //Vendor "Coupon Successfully Published." yazisinin gorunuyor oldugunu dogrular
        Assert.assertTrue(spend.couponCreatedSuccessText.isDisplayed());
        ReusableMethods.getScreenshotWebElement("Coupon Successfully Published",spend.couponCreatedSuccessText);
        extentTest.pass("\"Coupon Successfully Published.\" kuponun basarili bir sekilde olusturuldugu dogrulandi");


    }
    @Test
    public void Coupon_Code_Bos_Input() throws IOException {
        extentTest = extentReports.createTest("Negatif Test", "Vendor Store manager olarak, kuponları olusturabilmeli");
        ReusableMethods.signIn();
        extentTest.info("Spendinggood Sayfasina basarili bir sekilde giris yapilabildi");
        //vendor hesabım sayfasında "Store Manager" butonuna tıklar.
        extentTest.info("Store Manager sayfasina basarili bir sekil gidildi");
        spend.storeManager.click();
        //Vendor "Coupons" sekmesinin uzerine gelir ve "Add New" secenegine tiklar.
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.waitFor(1);
        actions.moveToElement(spend.couponsButton).click(spend.couponsAdd).perform();
        extentTest.info("Coupons Sayfasina basarili bir sekilde gidildi");
        //"Manage Coupon" sayfasi acilir Vendor "Code" satirini "uniq" bir deger girer.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshot("Coupons_Code_inputunun_bos_birakildi");
        extentTest.info("Kod satiri inputbox bos birakildi");
        ReusableMethods.waitFor(1);
       ReusableMethods.jsScrollClick(spend.submitButton);
        extentTest.info("\"Submit\" butonuna tiklanabildi");
       ReusableMethods.waitFor(1);
        Assert.assertTrue(spend.codeEmptyResultText.isDisplayed());
        ReusableMethods.getScreenshotWebElement("Kupon_Kod_satirinin_bos_birakilmasi_SonucYazisi",spend.codeEmptyResultText);
        extentTest.pass("\"Please insert atleast Coupon Title before submit.\"uyari yazisi dogrulandi");
    }

    @Test
    public void CouponCode_AlreadyExists() throws IOException {
        extentTest = extentReports.createTest("Negatif Test", "Vendor Store manager olarak, kuponları olusturabilmeli");
        ReusableMethods.signIn();
        extentTest.info("Spendinggood Sayfasina basarili bir sekilde giris yapilabildi");
        //vendor hesabım sayfasında "Store Manager" butonuna tıklar.
        extentTest.info("Store Manager sayfasina basarili bir sekil gidildi");
        spend.storeManager.click();
        //Vendor "Coupons" sekmesinin uzerine gelir ve "Add New" secenegine tiklar.
        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }
        ReusableMethods.waitFor(1);
        actions.moveToElement(spend.couponsButton).click(spend.couponsAdd).perform();
        extentTest.info("Coupons Sayfasina basarili bir sekilde gidildi");
        //"Manage Coupon" sayfasi acilir Vendor "Code" satirini "uniq" bir deger girer.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        spend.code.sendKeys("1");
        extentTest.info("Daha onceden olusturulmus Kod girildi");
        ReusableMethods.waitFor(1);
        ReusableMethods.jsScrollClick(spend.submitButton);
        extentTest.info("\"Submit\" butonuna tiklanabildi");
        Assert.assertTrue(spend.codeAlreadyExistText.isDisplayed());
        ReusableMethods.waitFor(1);
        ReusableMethods.getScreenshotWebElement("Kupon_Kodunun_Kullanildigini_Gosteren_SonucYazisi",spend.codeAlreadyExistText);
        extentTest.pass("\"Coupon code already exists - customers will use the latest coupon with this code.\" uyari yazisi dogrulandi");

    }
}
