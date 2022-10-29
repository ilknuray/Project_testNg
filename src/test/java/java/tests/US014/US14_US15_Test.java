package java.tests.US014;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US14_US15_SG_Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US14_US15_Test extends TestBaseRapor {

    US14_US15_SG_Page spend = new US14_US15_SG_Page();
    Actions actions = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    @Test
    public void testUS14() throws InterruptedException, IOException {
        extentTest=extentReports.createTest("Pozitif Test", "İndirim Kuponlarına Kısıtlamalar Başarıyla Tanımlandı.");

        //Vendor "https://www.spendgood.com/"  adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spendUrl"));

        //Vendor "Sign-in" butonuna tiklar
        spend.signInButton_click.click();

        //Vendor "Username or email address ”  inputuna gecerli Email girer
        //Vendor "Password" inputuna  gecerli parolayi girer
        //Vendor "SIGN-IN" butonuna tıklar
        spend.inputUserName.sendKeys(ConfigReader.getProperty("userName"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("password")).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(2);

        //Vendor "My Account" butonuna tiklar
        spend.myAccountLink.click();

        //Vendor "Store Manager" butonuna tıklar
        spend.storeManagerLink.click();
        Thread.sleep(1500);

        //Vendor "Coupons" sekmesinden "Add New" secenegini tiklar
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1500);
        actions.moveToElement(spend.couponsLink).moveToElement(spend.couponsAddNewButton).click().perform();

        //Vendor "Minimum spend" bolumune en az alma miktarini sayisal olarak girer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        spend.minSpendInput.sendKeys("1");

        // Vendor "Maximum spend" bolumune en cok alma miktarini sayisal olarak girer
        ReusableMethods.waitFor(1);
        spend.maxSpendInput.sendKeys("1");

        //Vendor "Indivisual use only" secenegini isaretler.
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        spend.indivUseCheckBox.click();


        //Vendor "Exclude sale items" secenegini isaretler
        ReusableMethods.waitFor(1);
        spend.exSaleItems.click();

        //Vendor "Exclude categories" dan bir kategori secer
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(1);
        actions.click(spend.excludeCatSelect).sendKeys("Electronics" + Keys.TAB).sendKeys(Keys.ENTER).perform();
        ReusableMethods.waitFor(1);
        actions.sendKeys("Food" + Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.PAGE_UP).perform();

    }

        @Test (dependsOnMethods = "testUS14")
        public void testUs15() {

            //Vendor "Limit" butonuna tiklar
            ReusableMethods.waitFor(2);
            spend.limitTabLink.click();
            ReusableMethods.waitFor(2);

            //Vendor "Usage limit per coupon" a kupon basina kullanım limiti icin deger girer
            spend.usageLimitPercoupon.sendKeys("1");
            ReusableMethods.waitFor(2);

            //Vendor "Limit usage to X items" a kupon kullanım limiti icin deger girer
            spend.limitUsageXitems.sendKeys("1");
            ReusableMethods.waitFor(2);

            //Vendor "Usage limit per user" a kupon kullanım limiti icin deger girer
            spend.perUserUsageLimit.sendKeys("1");
            ReusableMethods.waitFor(2);

            //Vendor "Code" satirina uniq bir deger girerek “SUBMIT”e tıklar
            String couponNameUnique = faker.number().digits(5);
            spend.codeInput.sendKeys("Coupon_" + couponNameUnique+Keys.ENTER);
            actions.sendKeys(Keys.PAGE_DOWN).perform();

            //Vendor "Coupon Successfully Published." yazisinin görünüyor oldugunu dogrular.
            Assert.assertTrue(spend.succededCoupon.isDisplayed());
        }
    }

