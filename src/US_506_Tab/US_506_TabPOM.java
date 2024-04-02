package US_506_Tab;

import Utility.BaseDriver;
import Utility.LoginMethod;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class US_506_TabPOM extends BaseDriver {

    @Test(groups = {"UITesting", "TAB Menu", "Order"}, priority = 6)
    public void tab(){

        driver.get("https://demo.nopcommerce.com/");
        US_506_TabElements tab= new US_506_TabElements();
        SoftAssert softAssert=new SoftAssert();

        LoginMethod.LoginTest();

        tab.giftcards.click();

        wait.until(ExpectedConditions.visibilityOfAllElements(tab.tabmenu));
        int randomSecim= Tools.randomGenerator(tab.tabmenu.size());
        wait.until(ExpectedConditions.visibilityOfAllElements(tab.addtocard));
        String add=tab.addtocard.get(randomSecim).getText();

        WebElement addToCartButton = tab.addtocard.get(randomSecim);
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOf(tab.recipientsName));
        tab.recipientsName.sendKeys("esma");
        tab.recipientsEmail.sendKeys("esma@gmail.com");
        //tab.name.sendKeys("Cilem Okkalı");
       // tab.email.sendKeys("javanator@gmail.com");
        tab.message.sendKeys("ürün güzel");
        tab.add.click();
        wait.until(ExpectedConditions.visibilityOf(tab.errormessage));
        softAssert.assertTrue(tab.errormessage.isDisplayed(), "Error message couldn't be displayed!");


        wait.until(ExpectedConditions.visibilityOf(tab.succes));
        softAssert.assertTrue(tab.succes.getText().contains("The product has been added to your"), "The addition to the cart process failed!");
        tab.close.click();


        wait.until(ExpectedConditions.visibilityOfAllElements(tab.cartItems));
        boolean isProductFoundInCart = false;
        for (WebElement cartItem : tab.cartItems) {
            if (cartItem.getText().contains("Gift Card")) { // Eklenen ürünün adı kontrol ediliyor
                isProductFoundInCart = true;
                break;
            }
        }
        softAssert.assertTrue(isProductFoundInCart, "The added gift card could not be displayed in the cart!");

        softAssert.assertAll();

    }
}
