package US_505_TabMenuUrunKontrol;

import US_502_LoginTest.US_502_Login_Elements;
import US_502_LoginTest.US_502_Login_POM;
import Utility.BaseDriver;
import Utility.LoginMethod;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class US_505_TabMenuUrunKontrol_POM extends BaseDriver {

    @Test
    public void tabMenuUrunKontrol() {

        US_505_TabMenuUrunKontrol_Elements tabMnu = new US_505_TabMenuUrunKontrol_Elements();
        US_502_Login_Elements le=new US_502_Login_Elements();

        driver.get("https://demo.nopcommerce.com/");

        le.login.click();
        le.email.sendKeys("javanator@gmail.com");
        le.password.sendKeys("javanator123");
        le.loginBtn.click();

        for (WebElement e: tabMnu.tobList){
            System.out.println("produkte:"+e.getText());
        }












    }
}