package java.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.SignInPage;
import pages.US01_US02Page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReusableMethods {
    //========ScreenShot(Sayfanın resmini alma)=====//
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    //========ScreenShot Web Element(Bir webelementin resmini alma)=====//
    public static String getScreenshotWebElement(String name,WebElement element) throws IOException {
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        File source = element.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String wElementSS = System.getProperty("user.dir") + "/target/WElementScreenshots/" + name + date + ".png";
        File finalDestination = new File(wElementSS);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return  wElementSS;
    }

    //========Switching Window(Pencereler arası geçiş)=====//
    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //========Hover Over(Elementin üzerinde beklemek)=====//
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    //==========Return a list of string given a list of Web Element====////
    public static List<String> getElementsText(List<WebElement> list) {
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : list) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //========Returns the Text of the element given an element locator==//
    public static List<String> getElementsText(By locator) {
        List<WebElement> elems = Driver.getDriver().findElements(locator);
        List<String> elemTexts = new ArrayList<>();
        for (WebElement el : elems) {
            if (!el.getText().isEmpty()) {
                elemTexts.add(el.getText());
            }
        }
        return elemTexts;
    }

    //   HARD WAIT WITH THREAD.SLEEP
//   waitFor(5);  => waits for 5 second
    public static void waitFor(int sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //===============Explicit Wait==============//
    public static WebElement waitForVisibility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void clickWithTimeOut(WebElement element, int timeout) {
        for (int i = 0; i < timeout; i++) {
            try {
                element.click();
                return;
            } catch (WebDriverException e) {
                waitFor(1);
            }
        }
    }

    public static void waitForPageToLoad(long timeout, Object webElement) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            System.out.println("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
            wait.until(expectation);
        } catch (Throwable error) {
            System.out.println(
                    "Timeout waiting for Page Load Request to complete after " + timeout + " seconds");
        }
    }


    //////jsExecuter Kodu////
    public static void jsExecutorClick(WebElement webElement){

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        // Belirli butonuna js ile click yapalim
        js.executeScript("arguments[0].click();",webElement);
    }
    public static void jsScrollClick(WebElement webElement) {  //kaydir ve tikla
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        try {
            webElement.click();
        } catch (Exception e) {
            js.executeScript("arguments[0].scrollIntoView(true);", webElement);
            js.executeScript("arguments[0].click()", webElement);
        }
    }


    //------------------------------PROJE SIGN IN-----------------------------------//

    public static void signIn() {
        SignInPage signIn = new SignInPage();
        Actions actions = new Actions(Driver.getDriver());
        //Vendor https://spendinggood.com/ URL'e gider
        Driver.getDriver().get(ConfigReader.getProperty("spUrl"));
        //Vendor  "Sign in" düğmesine tıklar
        signIn.signInButton1.click();

        //Vendor " email" girer
        //Vendor "password" a geçerli parola girer
        //Vendor "Sign in" butonuna tiklar
        signIn.signInemailBox.click();

        actions.sendKeys(ConfigReader.getProperty("validemail")).sendKeys(Keys.TAB).
                sendKeys(ConfigReader.getProperty("validsifre")).perform();
        signIn.signInButton2.click();
        ReusableMethods.waitFor(5);

        //Vendor "My Account" butonunu görür
        Assert.assertTrue(signIn.myAccountButton.isDisplayed());
        ReusableMethods.waitFor(2);
        //Vendor "My Account" 'a tiklar
        signIn.myAccountButton.click();
    }

    //--------------------------REGISTER----------------------------------//
    public static void registerMethod() {

        US01_US02Page spendingGoodPage = new US01_US02Page();
        Actions actions = new Actions(Driver.getDriver());
        // Kullanıcı https://spendinggood.com/  URL'e  gider
        Driver.getDriver().get(ConfigReader.getProperty("spUrl"));

        // Kullanıcı "Register" düğmesine tıklar
        spendingGoodPage.registerButton.click();
        ReusableMethods.waitFor(2);

        // Kullanıcı "Become a Vendor" düğmesini görür ve tiklar
        Assert.assertTrue(spendingGoodPage.becomeAVonderButton.isDisplayed());
        ReusableMethods.waitFor(2);
        spendingGoodPage.becomeAVonderButton.click();
    }
    static Actions actions;
    public static Actions getActions() { //getActions method

        return actions = new Actions(Driver.getDriver());

    }
}


