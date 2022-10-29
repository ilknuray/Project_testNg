package java.tests.US019;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US18_19_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class US019_TC02 {

    US18_19_Page page = new US18_19_Page();
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public void testCase02() throws IOException {

        // 1 vendor url ye gider
        Driver.getDriver().get(ConfigReader.getProperty("spendUrl"));
        // 2 vendor sayfadan Giriş Yap`a tıklar

        page.signIn.click();
        // 3.vendor unique bir email girer

        page.email.sendKeys(ConfigReader.getProperty("userName"));

        // 4. vendor Password girer
        page.password.sendKeys(ConfigReader.getProperty("password"));
        // 5.vendor giriş yap a tıklar
        page.signIn2.click();
        ReusableMethods.waitFor(5);

        // 6. vendor hesabım a tıklar
        page.myAccount.click();
        // 7. vendor store manager a tıklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        page.storeManager.click();
        // 8. takipçiler e tıklar
       ReusableMethods.waitFor(5);


       ReusableMethods.jsExecutorClick(page.followers);
       actions.sendKeys(Keys.PAGE_DOWN).perform();

        //9. isim, e posta tanimlanmali(gorunmeli)
            Assert.assertTrue(page.name.isDisplayed());
            Assert.assertTrue(page.email2.isDisplayed());

            // 10.işlemleri tanimlanmali(gorunmeli)
        Assert.assertTrue(page.actions.isDisplayed());
        ReusableMethods.getScreenshot("isim,e posta") ;


        }
    }
