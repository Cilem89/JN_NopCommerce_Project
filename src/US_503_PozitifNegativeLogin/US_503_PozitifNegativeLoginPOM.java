package US_503_PozitifNegativeLogin;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_503_PozitifNegativeLoginPOM extends BaseDriver {
    @Test(groups = {"LoginTest", "Smoke"}, dataProvider = "credentials", priority = 3)
    public void US_503(String username, String password) {
        driver.get("https://demo.nopcommerce.com/");
        US_503_PozitifNegativeLoginElements pnl = new US_503_PozitifNegativeLoginElements();
        SoftAssert softAssert = new SoftAssert();


        pnl.login.click();
        pnl.email.sendKeys(username);
        pnl.password.sendKeys(password);
        pnl.loginBtn.click();

//        String email = null;
//        if (pnl.email.isEnabled()) {
//            softAssert.assertTrue(pnl.errorMessage.isDisplayed(), "Email warning couldn't displayed!");
//        } else if (email.equals("javanator@gmail.com") && password.equals("javanator123")) {
//            softAssert.assertTrue(pnl.message.isDisplayed(), "Login failed!");
//        } else {
//            softAssert.assertTrue(pnl.failedLogin.isDisplayed(), "Failed login warning couldn't displayed!");
//        }
//        softAssert.assertAll();


//        softAssert.assertTrue(pnl.logout.isDisplayed());

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
