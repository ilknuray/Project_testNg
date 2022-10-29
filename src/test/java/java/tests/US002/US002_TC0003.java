package java.tests.US002;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.US01_US02Page;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US002_TC0003 extends TestBaseRapor {
    US01_US02Page spendingGoodPage = new US01_US02Page();

    @Test
    public void us02_TC003() throws IOException {

        extentTest=extentReports.createTest("tc01","Vendor olarak, güvenli bir registration yapmalıyım");
        ReusableMethods.signIn();
        ReusableMethods.getScreenshot("DashboardList ScreenShot");
        extentTest.info("Vendor olarak email ve şifre girilmeli ve sistemde My Accout görünmeli");



        spendingGoodPage.DashboardButton.click();
        List<WebElement> DashboardList=spendingGoodPage.ordersButton1;
        List<String> expectedList = new ArrayList<>(
                Arrays.asList("Store Manager", "Orders", "Downloads", "Addresses",
                        "Account details","appointments", "Wishlist", "Support tickets", "followings","log out"));
        for (int i = 0; i <spendingGoodPage.ordersButton1.size() ; i++) {
            Assert.assertNotEquals(DashboardList.get(i).getText(),expectedList.get(i));
            extentTest.info("Dashboard altında ise; Store manager, orders, downloads, \n" +
                    "addresses , account details, appointments, wishlist\n" +
                    " Support tickets, followings ve log out olmali");

            extentTest.pass( "Kullanici Dashboard altında  appointments butonunu göremedi");


        }

    }
}
