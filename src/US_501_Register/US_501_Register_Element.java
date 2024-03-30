package US_501_Register;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_501_Register_Element {
    public US_501_Register_Element() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(linkText = "Register")
    public WebElement register;

    @FindBy(id = "gender-female")
    public WebElement gender;

    @FindBy(id = "FirstName")
    public WebElement firstName;

    @FindBy(id = "LastName")
    public WebElement lastName;

    @FindBy(name = "DateOfBirthDay")
    public WebElement dayBirthday;

    @FindBy(name = "DateOfBirthMonth")
    public WebElement monthBirth;

    @FindBy(name = "DateOfBirthYear")
    public WebElement yearBirth;

    @FindBy(id = "Email")
    public WebElement email;

    @FindBy(id = "Password")
    public WebElement password;

    @FindBy(id = "ConfirmPassword")
    public WebElement confirmPassword;

    @FindBy(id = "register-button")
    public WebElement registerButton;


}
