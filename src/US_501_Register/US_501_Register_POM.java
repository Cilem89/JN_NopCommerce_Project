package US_501_Register;

import Utility.BaseDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class US_501_Register_POM extends BaseDriver {

    @Test()

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
}
