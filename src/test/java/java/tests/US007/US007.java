package java.tests.US007;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US007 extends TestBaseRapor {
    @Test
    public void US006(){
        US005_006_007 us005_006_007=new US005_006_007();

        extentTest = extentReports.createTest("Pozitif Test", "store manager  marka belirleyebilmeli");
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

        //markalar basliginin gorundugunu test eder
        String actualTitle = us005_006_007.markalar.getText();
        Assert.assertTrue(actualTitle.contains("Product brands"));
        Assert.assertTrue(us005_006_007.markalar.isDisplayed());
        extentTest.info("basliklar yazisi gorundu");

        //elegant,green grass,node js,ns8,red,sky suite,sterling baslikliarini test eder
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();

        String actualElegan = us005_006_007.elegantAuto.getText();
        Assert.assertTrue(actualElegan.contains("Elegant Auto Group"));
        Assert.assertTrue(us005_006_007.elegantAuto.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.elegantAutoCheckbox);
        ReusableMethods.waitFor(3);
        extentTest.info("elegant auto basligina tiklandi");

        // Assert.assertTrue(spendingGoodPage.elegantAutoCheckbox.isSelected());
        String actualGreen = us005_006_007.greenGrass.getText();
        Assert.assertTrue(actualGreen.contains("Green Grass"));
        Assert.assertTrue(us005_006_007.greenGrass.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.greenGrassCheckbox);
        ReusableMethods.waitFor(3);
        extentTest.info("greengrass basligina tiklandi");

        String actualNodeJS = us005_006_007.nodeJS.getText();
        Assert.assertTrue(actualNodeJS.contains("Node Js"));
        Assert.assertTrue(us005_006_007.nodeJS.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.nodeJScheckbox);
        ReusableMethods.waitFor(3);
        extentTest.info("node JS basligina tiklandi");

        String actualNs8 = us005_006_007.ns8.getText();
        Assert.assertTrue(actualNs8.contains("NS8"));
        Assert.assertTrue(us005_006_007.ns8.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.ns8checkbox);
        ReusableMethods.waitFor(3);
        extentTest.info("ns 8 basligina tiklandi");

        String actualRed = us005_006_007.red.getText();
        Assert.assertTrue(actualRed.contains("RED"));
        Assert.assertTrue(us005_006_007.red.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.redCheckbox);
        ReusableMethods.waitFor(3);
        extentTest.info("red basligina tiklandi");

        String actualSkysuite = us005_006_007.skySuite.getText();
        Assert.assertTrue(actualSkysuite.contains("Skysuite Tech"));
        Assert.assertTrue(us005_006_007.skySuite.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.skysuiteCheckbox);
        ReusableMethods.waitFor(3);
        extentTest.info("sky suite basligina tiklandi");

        String actualSterling = us005_006_007.sterling.getText();
        Assert.assertTrue(actualSterling.contains("Sterling"));
        Assert.assertTrue(us005_006_007.sterling.isDisplayed());
        ReusableMethods.jsExecutorClick(us005_006_007.sterlingCheckbox);
        extentTest.info("sterling basligina tiklandi");
        extentTest.pass("test basari ile sonuclandi");

    }
}
