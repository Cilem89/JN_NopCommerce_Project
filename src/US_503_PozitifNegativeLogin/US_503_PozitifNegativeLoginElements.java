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
    public WebElement login;

    @FindBy (xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginBtn;
    @FindBy(xpath = "//span[@id='Email-error']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@class='ico-logout']")
    public WebElement message;

    @FindBy(css = ".message-error.validation-summary-errors")
    public WebElement failedLogin;

    @FindBy(linkText = "Log out")
    public WebElement logout;




}