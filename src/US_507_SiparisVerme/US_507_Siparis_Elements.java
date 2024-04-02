package US_507_SiparisVerme;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_507_Siparis_Elements {

    public US_507_Siparis_Elements(){PageFactory.initElements(BaseDriver.driver,this);}
    @FindBy(linkText = "Computers")
    public WebElement computers;
    @FindBy(xpath = "//img[@title='Show products in category Desktops']")
    public WebElement desktops;

    @FindBy(xpath = "//img[@title='Show details for Build your own computer']")
    public WebElement owncomputer;

    @FindBy(id = "product_attribute_2")
    public WebElement ram;

    @FindBy(xpath = "//*[@id='product_attribute_2']/option[4]")
    public WebElement ram8gb;

    @FindBy(id = "product_attribute_3_7")
    public WebElement rom;

    @FindBy(xpath = "//button[@class='button-1 add-to-cart-button']")
    public WebElement cartbtn;

    @FindBy(xpath= "//p[@class='content'] ")
    public WebElement verify;


}
