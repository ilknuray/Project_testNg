package java.tests.US003_004;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US003_US004Page;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US003_004 {
    Actions action = new Actions(Driver.getDriver());
    Faker faker = new Faker();

    /*
    vendor "https://spendinggood.com/" adresine gider
    vendor "Giriş yap" Butonuna tıklar
    "vendor ""vendor adı veya e-posta adresi""
     inputuna gecerli Email girer"
    vendor "Parola" inputtuna  gecerli parolayı girer
    vendor "SIGN IN" butonuna tıklar
    vendor "Orders" a butonuna tıklar
    vendor "BROWSE PRODUCTS" a butonuna tıklar
     */

    @Test
    public void test01() throws InterruptedException {
        US003_US004Page spend = new US003_US004Page();


        //vendor "https://spendinggood.com/" adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("spendUrl"));

        //vendor "Giriş yap" Butonuna tıklar
        spend.signInButton1.click();

        //"vendor ""vendor adı veya e-posta adresi""
        //inputuna gecerli Email girer"
        //vendor "Parola" inputtuna  gecerli parolayı girer
        spend.emailBox.sendKeys(ConfigReader.getProperty("userName"));
        spend.passwordBox.sendKeys(ConfigReader.getProperty("password"));

        // vendor "SIGN IN" butonuna tıklar
        spend.signInButton2.click();
        Thread.sleep(3000);

        //vendor "Hesabım" butonuna basar.
        spend.myAccountButton.click();

        //vendor "Orders" a butonuna tıklar
        spend.ordersButton.click();

        // vendor "BROWSE PRODUCTS" a yada "go shop" butonuna tıklar
        //ReusableMethods.jsScrollClick(spend.goShopButton);
        if (spend.goShopButton.isDisplayed()) {
            ReusableMethods.jsScrollClick(spend.goShopButton);
        } else {

            spend.browseProductsButton.click();
        }



        //Vendor 5 ürün seçer ve sepete aktarır

        for (int i = 0; i <spend.addToCardButton.size(); i++) {
            ReusableMethods.jsScrollClick(spend.addToCardButton.get(i));
        }

        //Vendor "Cart" a tıklar
        action.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).perform();
        ReusableMethods.waitFor(2);
        spend.cartButton.click();

        // Vendor "View Cart" butonuna tıklar
        spend.viewCartButton.click();
        ReusableMethods.waitFor(2);

        // '+' ile urun rakami artirilabilmeli ve '-' ile rakamlar dusurulebilmelili"
        spend.plusButton.click();
        ReusableMethods.waitFor(2);
        spend.minusButton.click();
        ReusableMethods.waitFor(2);
        /*ReusableMethods.waitFor(2);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        spend.clearCartButton.click();

         */

        //Vendor artı ile ürün ekler
        //Vendor "Update cart button" tıklar
        //Vendor sepetiniz güncellendi yazısını görür
        spend.plusButton.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.jsScrollClick(spend.updateCartButton);
        Assert.assertTrue(spend.cartUpdatedText.isDisplayed());

        //Vendor "Apply Coupon" butonunu gorur
        Assert.assertTrue(spend.applyCouponButton.isDisplayed());

        //Vendor  shipping bilgilerini sag tarafta gorur
        Assert.assertTrue(spend.shippingInformationText.isDisplayed());

        //Vendor "Clear Cart" butonunu gorur
        Assert.assertTrue(spend.clearCartButton.isDisplayed());

        //Vendor "Proceed to Checkout" butonunu  tiklar ve odeme bilgilirine yonlendirilebilmeli
        spend.proceedToCheckoutButton.click();

        // Vendor  tum adres bilgilerini girer
        spend.firstNameTextBox.sendKeys(faker.name().firstName());
        action.sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().streetAddress())
                .sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(faker.address().city()).sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB).sendKeys("10019").sendKeys(Keys.TAB).sendKeys("+1 212-969-1782").perform();

        //  Vendor  Place Order'a tiklar
        ReusableMethods.jsScrollClick(spend.placeOrderButton);

        //Vendor  Billing bilgilerini gorur
        Assert.assertTrue(spend.billingAdressText.isDisplayed());









    }
}
