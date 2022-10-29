package java.tests.US006;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import static org.testng.Assert.*;

public class US006 extends TestBaseRapor {

    @Test
    public void US006() {
        US005_006_007 us005_006_007 = new US005_006_007();



        extentTest = extentReports.createTest("Pozitif Test", "store kategori belirleyebilmeli");
        ReusableMethods.signIn();
        extentTest.info("Sayfaya basari ile giris yapildi");

        //store manager basligina tiklar
        us005_006_007.storeManager.click();
        extentTest.info("Store manager basligina tiklandi");


        //products basligini tiklar
        ReusableMethods.waitFor(3);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsExecutorClick(us005_006_007.products);
        extentTest.info("Products basligina tiklandi");

        //Add new butonuna tiklar
         ReusableMethods.jsExecutorClick(us005_006_007.addNew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Add new butonuna tiklandi");

        //categories basliginin gorunurlugunu test eder
        assertTrue(us005_006_007.categoriesBasligi.isDisplayed());
        extentTest.info("Kategori basligi goruldu");
        ReusableMethods.waitFor(3);


        /*assertTrue(ilknurPage.healtAndBeatuyBasligi.isDisplayed());
        extentTest.info("healty and beauty basligi goruntulendi");
        ReusableMethods.jsExecutorClick(ilknurPage.maviButon1);
        // ilknurPage.maviButon1.sendKeys(Keys.ENTER);
        ReusableMethods.waitFor(3);
        assertTrue(ilknurPage.vitaminSupplements.isDisplayed());
        ilknurPage.vitaminCheckBox.click();
        assertTrue(ilknurPage.vitaminCheckBox.isSelected());
        extentTest.info("Vitamin supplements kutusu secildi");
        ReusableMethods.waitFor(3);*/


        assertTrue(us005_006_007.bestSeller.isDisplayed());
        extentTest.info("Best seller basligi goruntulendi");
        us005_006_007.bestSellerCheckBox.click();
        assertTrue(us005_006_007.bestSellerCheckBox.isSelected());
        extentTest.info("Best seller kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.elektrikElektronik.isDisplayed());
        extentTest.info("Elektrik basligi goruntulendi");
        us005_006_007.elektronicCheckbox.click();
        assertTrue(us005_006_007.elektronicCheckbox.isSelected());
        extentTest.info("Elektrik elektronik kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.evYasam.isDisplayed());
        extentTest.info("Ev ve yasam basligi goruntulendi");
        us005_006_007.evYasamCheckBox.click();
        assertTrue(us005_006_007.evYasamCheckBox.isSelected());
        extentTest.info("ev ve yasam kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.bookMusicFilm.isDisplayed());
        extentTest.info("Book musuc film basligi goruntulendi");
        us005_006_007.bookMusicFimCheckBox.click();
        assertTrue(us005_006_007.bookMusicFimCheckBox.isSelected());
        extentTest.info("kitap&film&muzik kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.fashion.isDisplayed());
        extentTest.info("Fashion basligi goruntulendi");
        us005_006_007.fashionCheckBox.click();
        extentTest.info("moda kutusu secildi ");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.clothing.isDisplayed());
        extentTest.info("Clothing basligi goruntulendi");
        us005_006_007.clothinCheckBox.click();
        assertTrue(us005_006_007.clothinCheckBox.isSelected());
        extentTest.info("giyim kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.accessoires.isDisplayed());
        extentTest.info("Aksesuar basligi goruntulendi");
        us005_006_007.accessoiresCheckBox.click();
        assertTrue(us005_006_007.accessoiresCheckBox.isSelected());
        extentTest.info("aksesuar kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.newArrivals.isDisplayed());
        extentTest.info("New arrivals basligi goruntulendi");
        us005_006_007.newArrivalsCheckBox.click();
        assertTrue(us005_006_007.newArrivalsCheckBox.isSelected());
        extentTest.info("new arrivals kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.toysGames.isDisplayed());
        extentTest.info("Toys and games basligi goruntulendi");
        us005_006_007.toysGamesCheckBox.click();
        assertTrue(us005_006_007.toysGamesCheckBox.isSelected());
        extentTest.info("toys and games kutusu secildi");
        ReusableMethods.waitFor(3);


        assertTrue(us005_006_007.cosmetic.isDisplayed());
        extentTest.info("Kozmetik basligi foruntulendi");
        ReusableMethods.jsExecutorClick(us005_006_007.cosmeticCheckBox);
        extentTest.info("cosmetik kutusu secildi ");
        ReusableMethods.waitFor(3);

        assertTrue(us005_006_007.indirimliUrunler.isDisplayed());
        extentTest.info("indirimli urunler basligi goruntulendi");
        ReusableMethods.jsExecutorClick(us005_006_007.indirimliUrunlerCheckbox);
        extentTest.info("indirimli urunler kutusu secildi");
        ReusableMethods.waitFor(3);
        extentTest.pass("Test basari ile gerceklestirildi");

    }

}
