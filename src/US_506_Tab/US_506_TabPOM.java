package US_506_Tab;


import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.LoginMethod;
import Utility.Tools;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static Utility.Tools.ListContainsString;

public class US_506_TabPOM extends BaseDriver {
    @Test(groups = {"UITesting", "TAB Menu", "Order"}, priority = 6)
    public void TC_506() {
        driver.get("https://demo.nopcommerce.com/");
        US_506_TabElements tab= new US_506_TabElements();
        LoginMethod.LoginTest();

        SoftAssert softAssert = new SoftAssert();

        tab.giftCardsButton.click();
        int random = Tools.randomGenerator(tab.giftCards.size() );
        String cardName = tab.giftCards.get(random).getText();
       tab.giftCards.get(random);
        Tools.Bekle(1);


        tab.addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(tab.recipientName));
        JavascriptExecutor js=(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,500)");

        wait.until(ExpectedConditions.visibilityOf(tab.giftError));
        softAssert.assertTrue(tab.giftError.isDisplayed(), "Error message couldn't displayed!");

        JavascriptExecutor js2=(JavascriptExecutor) driver;

        js.executeScript("window.scrollTo(0,500)");
        if (random == 0) {
            tab.yourName.sendKeys("Cilem Okkali");
            tab.yourEmail.sendKeys("javanator@gmail.com") ;
        }

        tab.recipientName.sendKeys("esma");
        tab.recipientEmail.sendKeys("esma@gmail.com");
        tab.yourName.sendKeys("esma dengeşik");
        tab.yourEmail.sendKeys("dengeşik@gmail.com");
        tab.message.sendKeys("From grief and groan, to a golden throne, beside the King of Heaven.");
        tab.addToCart.click();
        wait.until(ExpectedConditions.visibilityOf(tab.giftSuccess));
        softAssert.assertTrue(tab.giftSuccess.getText().contains("The product has been added to your"), "The addition to the cart process failed!");
        Tools.JSClick(tab.cart);
        softAssert.assertTrue(ListContainsString(tab.cartItems, cardName), "The added gift card could not be displayed in the cart!");
        softAssert.assertAll();
    }
}