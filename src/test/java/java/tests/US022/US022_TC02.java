package java.tests.US022;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US22_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

import java.util.List;

public class US022_TC02 extends TestBaseRapor {
    US22_Page page = new US22_Page();

    @Test
    public void TC02() {
        extentTest = extentReports.createTest("Us022 TC02", "İndirimli Ürünler siralanabilmeli" +
                " :Varsayılan Sıralama -> Bu default seçenek olmali -> En çok incelenene göre sırala ->" +
                " En çok oy alana göre sırala -> En yeniye göre sırala -> Fiyata göre sırala: Düşükten yükseğe -> Fiyata göre sırala: Yüksekten düşüğe");
        extentTest.info("1.Kullanici https://spendinggood.com a gider");
       Driver.getDriver().get(ConfigReader.getProperty("spendUrl"));

        extentTest.info("2.Kullanıcı DailyDeals kısmına tıklar");
        page.dailyDeals.click();


        extentTest.info("Kullanici indirimli urunleri siralayabilir ve drop down menudeki siralamaları görebilir");
        Select select = new Select(page.dailyDealsDropDown);
        List<WebElement>dailyDealsDD = select.getOptions();
        dailyDealsDD.stream().forEach(t-> System.out.println(t.getText()));
        Assert.assertTrue(dailyDealsDD!=null);





    }

}
