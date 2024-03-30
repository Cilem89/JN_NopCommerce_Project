package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginMethod extends BaseDriver {
    public static void LoginTest() {
        System.out.println("Login Test başladı");

        driver.get("https://demo.nopcommerce.com/");

        WebElement login = driver.findElement(By.xpath("//a[@class='ico-login']"));
        login.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("javanator@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("javanator123");

        WebElement lgnBtn = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        lgnBtn.click();
    }
}