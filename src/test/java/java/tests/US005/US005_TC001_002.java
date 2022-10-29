package java.tests.US005;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US005_006_007;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005_TC001_002 extends TestBaseRapor {

    @Test
    public void US005_TC001_002() {
        US005_006_007 us005_006_007 = new US005_006_007();
        extentTest=extentReports.createTest("pozitiftest","Stock,date,status,price,Virtual ve downloadable basliklari gorulebilmeli");

       ReusableMethods.signIn();
       extentTest.info("Sayfaya basari ile girildi");

        //store manager basligina tiklar
        us005_006_007.storeManager.click();
        extentTest.info("Store manager basligina tiklandi");


        //products basligini tiklar
        ReusableMethods.waitFor(3);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsExecutorClick(us005_006_007.products);
        extentTest.info("Products basligina tiklandi");

        //Status,stock,price,date basliklarinin gorundugunu test eder

        Assert.assertTrue(us005_006_007.status.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.info("Status basligi goruntulendi");
        Assert.assertTrue(us005_006_007.stock.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.info("stock basligi goruntulendi");
        Assert.assertTrue(us005_006_007.price.isDisplayed());
        extentTest.info("price basligi goruntulendi");
        ReusableMethods.waitFor(3);
        Assert.assertTrue(us005_006_007.date.isDisplayed());
        extentTest.info("date basligi goruntulendi");


        //Add new butonuna tiklar
        ReusableMethods.jsExecutorClick(us005_006_007.addNew);
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("Add new butonuna tiklandi");
        //virtual ve downloadable basliklarinin gorunur ve tiklanir oldugunu test eder
        String actualVirtual=us005_006_007.virtual.getText();
        Assert.assertTrue(actualVirtual.contains("Virtual"));
        extentTest.info("Virtual basligi goruntulendi");
        us005_006_007.virtualCheckbox.click();
        Assert.assertTrue(us005_006_007.virtualCheckbox.isSelected());
        extentTest.info("Virtual checkboxu tiklandi");

        String actualDownloadable=us005_006_007.downloadable.getText();
        Assert.assertTrue(actualDownloadable.contains("Downloadable"));
        extentTest.info("Downloadable basligi goruntulendi");
        us005_006_007.downloadableCheckbox.click();
        Assert.assertTrue(us005_006_007.downloadableCheckbox.isSelected());
        extentTest.info("Downloadable checkboxuna tiklandi");
        extentTest.pass("test basari ile gerceklesti");


    }


}
