package US_502_LoginTest;

import Utility.BaseDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_502_Login_Elements {

    public US_502_Login_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy (xpath = "//a[@class='ico-login']")
    public WebElement login;

    @FindBy (xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[@class='button-1 login-button']")
    public WebElement loginBtn;






}
