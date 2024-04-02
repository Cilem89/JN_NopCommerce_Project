package US_508_Parametreli;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_508_Parametreli_Elements {

    public US_508_Parametreli_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(xpath = "//input[@placeholder='Search store']")
    public WebElement Search;

    @FindBy(xpath = "//div[@class='master-column-wrapper']")
    public WebElement urunler;

















}
