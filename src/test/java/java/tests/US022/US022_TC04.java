package java.tests.US022;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US22_Page;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US022_TC04 extends TestBaseRapor {
    US22_Page page = new US22_Page();

    @Test
    public void TC04() {
        extentTest = extentReports.createTest("US022 TC04","Fiyata göre sırala: yüksekten düsüge seçildiğinde fiyatlar kucukten buyuge gore sıralanmalı");
        ReusableMethods.signIn();

        extentTest.info("Kullanici Daily Deals Secenegini tiklar");
        page.dailyDeals.click();


        extentTest.info("Kullanici sort by seceneğine gider ve high to low seceneğini goruldugunu dogrular");
        Select select = new Select(page.dailyDealsDropDown);
        select.selectByIndex(5);
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//*[text()='Sort by price: high to low']")).isDisplayed());

    }
}
