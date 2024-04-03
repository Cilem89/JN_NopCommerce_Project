package US_503_PozitifNegativeLogin;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_503_PozitifNegativeLoginElements {



    public US_503_PozitifNegativeLoginElements() {
        PageFactory.initElements(BaseDriver.driver, this);

    }

    @FindBy (xpath = "//a[@class='ico-login']")
    public WebElement loginButton;

    @FindBy (xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginBtn;

    @FindBy(css = ".message-error.validation-summary-errors")
    public WebElement failedLogin;



    @FindBy(css = "[class='button-1 login-button']")
    public WebElement loginButton2;
    @FindBy(css = "#Email-error")
    public WebElement emailError;

    @FindBy(linkText = "Log out")
    public WebElement logoutButton;



}