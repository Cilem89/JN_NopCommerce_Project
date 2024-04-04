package Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseDriver {
    public static Logger logTutma = LogManager.getLogger();
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass(groups = {"UITesting","Search", "TAB Menu","Regression"})
    public void BaslangicIslemleri() {
        System.out.println("başlangıç işlemleri yapılıyor");

        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }


    public void myClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        scrollToElement(element);
        element.click();

    }

    public void mySendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        scrollToElement(element);
        element.clear();
        element.sendKeys(text);
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) BaseDriver.driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    @AfterClass(groups = {"UITesting","Search", "TAB Menu","Regression"})
    public void KapanisIslemleri() {
        // System.out.println("kapanış işlemleri yapılıyor"); //BekleKapat

        Tools.Bekle(3);
        driver.quit();

        logTutma.info("Driver kapatıldı");

    }

    @BeforeMethod
    public void BeforeMetod() {
        logTutma.info("Metod başladı");

        logTutma.warn("WARN : Metod başladı, hata oluşmuş olsa idi");
    }

    @AfterMethod
    public void AfterMetod(ITestResult sonuc) {
        logTutma.info(sonuc.getName() + " Metod bitti " + (sonuc.getStatus() == 1 ? "Passed" : "failed"));

        logTutma.warn("WARN : Metod bitti, hata oluşmuş olsa idi");
    }

}
