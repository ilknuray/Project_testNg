package java.tests.US002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01_US02Page;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US002_TC0001_TC0002 extends TestBaseRapor {

    US01_US02Page spendingGoodPage=new US01_US02Page();

    @Test
    public void us02_TC001() {
        extentTest=extentReports.createTest("tc02","Vendor sign in, Vendor olarak Sign in yapılabilmeli");
      ReusableMethods.signIn();
        extentTest.info("Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli");



        Assert.assertTrue(spendingGoodPage.ordersButton.isDisplayed()
        && spendingGoodPage.downloadButton.isDisplayed()
        && spendingGoodPage.AddressesButton.isDisplayed()
        && spendingGoodPage.AccountButton.isDisplayed()
        && spendingGoodPage.WishlistButton.isDisplayed()
        && spendingGoodPage.logOutButton.isDisplayed());
        extentTest.info("Vendor  My Account sayfasinda \"Orders, Downloads,\n" +
                " addresses, account details, whislist ve Logout\" butonlarini görür");
        extentTest.pass("kullanici ilgili My Account sayfasinda belirtilen butonlari görür" );



    }
}
