package US_503_PozitifNegativeLogin;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_503_PozitifNegativeLoginPOM extends BaseDriver {
    @Test(dataProvider="datalarim")
    public void US_503(String username, String password) {
        US_503_PozitifNegativeLoginElements pnl = new US_503_PozitifNegativeLoginElements();
        driver.get("https://demo.nopcommerce.com/");

        SoftAssert softAssert = new SoftAssert();

        pnl.loginButton.click();
        softAssert.assertNotNull(pnl.loginButton2, "Login page couldn't displayed!");
        wait.until(ExpectedConditions.visibilityOf(pnl.email));
        pnl.email.sendKeys(username);
        pnl.password.sendKeys(password);
        pnl.loginButton2.click();
        if (pnl.email.isEnabled()) {
            softAssert.assertTrue(pnl.emailError.isDisplayed(), "Email warning couldn't displayed!");
        } else if (pnl.email.equals("javanator@gmail.com") && password.equals("javanator123")) {
            softAssert.assertTrue(pnl.logoutButton.isDisplayed(), "Login failed!");
        } else {
            softAssert.assertTrue(pnl.failedLogin.isDisplayed(), "Failed login warning couldn't displayed!");
        }
       // softAssert.assertAll();
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
}
