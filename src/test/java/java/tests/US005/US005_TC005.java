package java.tests.US005;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005_TC005 extends TestBaseRapor {
    @Test
    public void US005() {
        US005_006_007 us005_006_007 = new US005_006_007();
        extentTest = extentReports.createTest("Pozitif test", "kisa ve genis tanimlama yapilmali");
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

        //shortdescription basligi gorundu tiklandi
        Assert.assertTrue(us005_006_007.shortDescriptionBaslik.isDisplayed());
        extentTest.info("Short description basligi goruntulendi");
        Driver.getDriver().switchTo().frame(us005_006_007.iframeShort);
        us005_006_007.shortDescriptoinKutusu.sendKeys("ilknur");
        extentTest.info("Kutuya aciklama yazisi gonderildi");
        String actualShortDescriptionKutusu = us005_006_007.shortDescriptoinKutusu.getText();
        String expectedShortDescriptionKutusu = "ilknur";
        Assert.assertTrue(actualShortDescriptionKutusu.contains(expectedShortDescriptionKutusu));
        extentTest.info("Aciklama yazisi goruntulendi");
        Driver.getDriver().switchTo().defaultContent();
        //description basligi gorundu tiklandi
        Assert.assertTrue(us005_006_007.shortDescriptionBaslik.isDisplayed());
        extentTest.info("Description basligi goruntulendi");
        Driver.getDriver().switchTo().frame(us005_006_007.iframeDescription);
        us005_006_007.descriptionKutusu.sendKeys("Yilmaz");
        extentTest.info("Description kutusuna yazi gonderildi");
        String actualDescriptionKutusu = us005_006_007.descriptionKutusu.getText();
        String expectedDescriptionKutusu = "Yilmaz";
        Assert.assertTrue(actualDescriptionKutusu.contains(expectedDescriptionKutusu));
        extentTest.info("Aciklama yazisi goruntulendi");
        Driver.getDriver().switchTo().defaultContent();
        extentTest.pass("Test basari ile tamamlandi");

    }
}