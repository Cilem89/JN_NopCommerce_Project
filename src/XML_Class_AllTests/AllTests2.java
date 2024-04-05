package XML_Class_AllTests;

import US_501_Register.US_501_Register_Element;
import US_503_PozitifNegativeLogin.US_503_PozitifNegativeLoginElements;
import US_504_Tab_Menu_Kontroll.US_504_Tab_Menu_Elements;
import US_505_TabMenuUrunKontrol.US_505_TabMenuUrunKontrol_Elements;
import US_506_Tab.US_506_TabElements;
import US_507_SiparisVerme.US_507_Siparis_Elements;
import US_508_Parametreli.US_508_Parametreli_Elements;
import Utility.BaseDriver;
import Utility.LoginMethod;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static Utility.Tools.ListContainsString;

public class AllTests2 extends BaseDriver {
    @Test(groups = {"Registration","Smoke"},priority = 1)
    public void  _501_POM(){
        US_501_Register_Element re=new US_501_Register_Element();
        driver.get("https://demo.nopcommerce.com/");

        re.register.click();
        re.gender.click();
        re.firstName.sendKeys("Cilem");
        re.lastName.sendKeys("Okkalı");

        Select day=new Select(re.dayBirthday);
        day.selectByVisibleText("7");


        Select month=new Select(re.monthBirth);
        month.selectByVisibleText("July");

        Select year=new Select(re.yearBirth);
        year.selectByVisibleText("1989");

        re.email.sendKeys("javanator@gmail.com");
        re.password.sendKeys("javanator123");
        re.confirmPassword.sendKeys("javanator123");
        re.registerButton.click();
    }
    @Test(dataProvider = "datalarim",groups = {"LoginTest","Smoke"},priority = 2)
    public void _503_POM(String username, String password){

        US_503_PozitifNegativeLoginElements pnl = new US_503_PozitifNegativeLoginElements();
        driver.get("https://demo.nopcommerce.com/");

        SoftAssert softAssert = new SoftAssert();

        pnl.login.click();
        softAssert.assertNotNull(pnl.loginButton2, "Login page couldn't displayed!");
        wait.until(ExpectedConditions.visibilityOf(pnl.email));
        pnl.email.sendKeys(username);
        pnl.password.sendKeys(password);
        pnl.loginButton2.click();
    }
    @DataProvider
    Object[][] datalarim(){
        Object[][] usernameAndPassword =
                {
                        {"User", "12345"},
                        {"Esma", "4444"},
                        {"Mutalip", "6666"},
                        {"Salih", "999"},
                        {"Akman", "ddddd"},
                        {"Ayşe", "777"},
                        {"javanator@gmail.com", "javanator123"}

                };
        return usernameAndPassword;
    }

    @Test(groups = {"LoginTest","Smoke"},priority = 3)
    public void _502_POM(){
        US_503_PozitifNegativeLoginElements pnl=new US_503_PozitifNegativeLoginElements();
        pnl.logoutButton.click();
        LoginMethod.LoginTest();
    }

    @Test(groups = {"UITesting","TAB Menu"},priority = 4)
    @Parameters("Text")
    public void _504_POM(String searchTxt) {
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

    @Test(groups = {"UITesting","Search", "TAB Menu","Regression"},priority = 5)
    @Parameters("Searchtext")
    public void _505_POM(String search) {
        US_505_TabMenuUrunKontrol_Elements tmuk = new US_505_TabMenuUrunKontrol_Elements();
        Actions actions = new Actions(BaseDriver.driver);


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

    @Test(groups = {"UITesting", "TAB Menu", "Order"}, priority = 6)
    public void TC_506_POM() {
            driver.get("https://demo.nopcommerce.com/");
            US_506_TabElements tab= new US_506_TabElements();

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


            tab.recipientName.sendKeys("esma");
            tab.recipientEmail.sendKeys("esma@gmail.com");
            tab.yourName.clear();
            tab.yourEmail.clear();
            tab.yourName.sendKeys("esma dengeşik");
            tab.yourEmail.sendKeys("dengeşik@gmail.com");
            tab.addToCart.click();
            wait.until(ExpectedConditions.visibilityOf(tab.giftSuccess));
            softAssert.assertTrue(tab.giftSuccess.getText().contains("The product has been added to your"), "The addition to the cart process failed!");
            Tools.JSClick(tab.cart);
            softAssert.assertTrue(ListContainsString(tab.cartItems, cardName), "The added gift card could not be displayed in the cart!");
        }

    @Test(groups = {"UITesting","Tab Menu","Order"},priority = 7)
    public void _507_POM(){

        US_507_Siparis_Elements e=new US_507_Siparis_Elements();

        driver.get("https://demo.nopcommerce.com/");

        e.computers.click();
        e.desktops.click();
        Tools.JSClick(e.owncomputer);
        Tools.JSClick(e.ram);
        Tools.JSClick(e.ram8gb);
        Tools.JSClick(e.rom);
        Tools.JSClick(e.cartbtn);

        Assert.assertTrue(e.verify.getText().toLowerCase().contains("the product has been added to your"),"basarisiz");

    }

    @Test(groups = {"UITesting","Search","Smoke","Regression"},priority = 8)
    @Parameters("searchtext")
    public void _508_POM(String arananKelime){
        US_508_Parametreli_Elements e=new US_508_Parametreli_Elements();

        driver.get("https://demo.nopcommerce.com/");

        e.Search.sendKeys(arananKelime, Keys.ENTER);

        Assert.assertTrue(e.urunler.getText().toLowerCase().contains("adobe photoshop cs4"),"basarisiz");

    }


}
