package US_502_LoginTest;

import Utility.BaseDriver;
import Utility.LoginMethod;
import Utility.Tools;
import org.testng.annotations.Test;

public class US_502_Login_POM extends BaseDriver {

    @Test(groups = {"Smoke Test"},priority = 2)
    public void Login(){

        US_502_Login_Elements le=new US_502_Login_Elements();
        driver.get("https://demo.nopcommerce.com/");

        le.login.click();
        le.email.sendKeys("javanator@gmail.com");
        le.password.sendKeys("javanator123");
        le.loginBtn.click();


    }

}
