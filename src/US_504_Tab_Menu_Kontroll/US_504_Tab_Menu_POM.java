package US_504_Tab_Menu_Kontroll;

import Utility.BaseDriver;
import Utility.LoginMethod;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_504_Tab_Menu_POM extends BaseDriver {

    @Test(groups = {"UITesting","TAB Menu"},priority = 4)
    @Parameters("Text")
    public void TabMenu(String searchTxt) {
        US_504_Tab_Menu_Elements tm = new US_504_Tab_Menu_Elements();


        driver.get("https://demo.nopcommerce.com/");
        Tools.Bekle(2);


        Actions actions = new Actions(BaseDriver.driver);
        List<String> butunUrunler= new ArrayList<>();
        List<String> tabMenuListesi = new ArrayList<>();
        Collections.addAll(tabMenuListesi, "Computers", "Electronics", "Apparel", "Digital downloads", "Books", "Jewelry", "Gift Cards");
        List<String> subMenuListTexti = new ArrayList<>();
        Collections.addAll(subMenuListTexti, "Desktops", "Notebooks", "Software", "Camera & photo", "Cell phones", "Others", "Shoes", "Clothing", "Accessories");
        int index = 0;
        for (int i = 0; i < 13; i++) {
            if (index <= 2) {
                WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuListesi.get(index)));
                Action action = actions.moveToElement(tabMenuClick).build();
                action.perform();
                WebElement subMenuClick = driver.findElement(By.linkText(subMenuListTexti.get(i)));
                subMenuClick.click();
            } else {
                WebElement tabMenuClick = driver.findElement(By.linkText(tabMenuListesi.get(index)));
                tabMenuClick.click();
            }
            for (WebElement name : tm.productNameList) {
                String productText = name.getText();
                butunUrunler.add(productText);
            }
            if (i == 2 || i == 5 || i >= 8) {
                index++;
            }
        }
        driver.navigate().to("https://demo.nopcommerce.com/");
        wait.until(ExpectedConditions.visibilityOf(tm.searchBox));
        tm.searchBox.sendKeys(searchTxt + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOf(tm.productName));
        Assert.assertTrue(butunUrunler.contains(tm.productName.getText()));
    }
}
