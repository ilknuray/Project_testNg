package java.tests.US022;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US22_Page;
import utilities.ConfigReader;
import utilities.TestBaseRapor;

import java.util.List;

import static utilities.Driver.getDriver;

public class US022_TC01 extends TestBaseRapor {
    US22_Page page = new US22_Page();

    @Test
    public void TC01() {
        extentTest = extentReports.createTest("Us022 TC01", "Tumunu gor linki olmali ve tıklandiğinda o kategorinin ana sayfalarina girmel");

        extentTest.info("1.Kullanici https://spendinggood.com a gider");
        getDriver().get(ConfigReader.getProperty("spendUrl"));

        extentTest.info("User sign in kısmına tıklar");
        page.signIn.click();


        extentTest.info("3.User, acilan sayfada username or email address kısmına gecerli bir email girer");
        page.userName.sendKeys(ConfigReader.getProperty("userName"));
        extentTest.info("3.User, password kısmına gecerli bir sifre girer");
        page.passWord.sendKeys(ConfigReader.getProperty("password"));

        extentTest.info("5.User, email ve password girdikten sonra asagida bulunan sign in buttonuna tıklar ve giris apar");
        page.signInButton.click();

        extentTest.info("6.User acilan sayfada All Categories secenegini tıklar ve ortaya cikan tüm kategorileri gorur");
        page.allCategories.click();
        Select select = new Select(page.allCategories);
        List<WebElement> allCategoriesdropdown = select.getOptions();
        allCategoriesdropdown.forEach(t -> System.out.print(t.getText() + " "));
        String istenenMenu = "Best Seller";
        Assert.assertTrue(page.allCategories.getText().contains(istenenMenu));



    }
}
