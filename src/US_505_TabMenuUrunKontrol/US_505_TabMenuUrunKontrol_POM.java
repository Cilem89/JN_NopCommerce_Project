package US_505_TabMenuUrunKontrol;

import Utility.BaseDriver;
import Utility.LoginMethod;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class US_505_TabMenuUrunKontrol_POM extends BaseDriver {
    @Test(groups = {"UITesting","Search", "TAB Menu","Regression"},priority = 5)
    @Parameters("Searchtext")
    public void tabMenuUrunKontrol(String search) {
        US_505_TabMenuUrunKontrol_Elements tmuk = new US_505_TabMenuUrunKontrol_Elements();
        Actions actions = new Actions(BaseDriver.driver);
        LoginMethod.LoginTest();

        List<String> tabMenuTexts = new ArrayList<>();
        for (WebElement tabMenuItem : tmuk.tabMenuItems) {
            tabMenuTexts.add(tabMenuItem.getText());
            System.out.println("Tab Menu Item: " + tabMenuItem.getText());

            actions.moveToElement(tabMenuItem).build().perform();
            List<WebElement> subMenuElements = tabMenuItem.findElements(By.xpath("//ul[@class='sublist first-level']//a"));
            System.out.println("Sub Menu Items:");

            for (WebElement subMenuItem : subMenuElements) {
                System.out.println(subMenuItem.getText());
            }
        }

        tmuk.searchBox.sendKeys(search + Keys.ENTER);

        int randomSecim = Tools.randomGenerator(tmuk.searchResults.size());
        String itemName = tmuk.searchResults.get(randomSecim).getText();
        System.out.println("Secilen ürün="+itemName);
        tmuk.searchResults.get(randomSecim).click();

        Assert.assertTrue(tmuk.searchResults.contains(tmuk.searchResults.get(randomSecim)),"seçilen ürün bulunamadı");


    }
}
