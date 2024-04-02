package US_506_Tab;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_506_TabElements {

    public US_506_TabElements() {
        PageFactory.initElements(BaseDriver.driver,this);
    }

    @FindBy(css = "[class='top-menu notmobile']>:nth-child(7)")
    public WebElement giftcards;
    @FindBy(css = ".product-title>a")
    public List<WebElement> tabmenu;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    public List<WebElement> addtocard;

    @FindBy(id = "//div[@class='giftcard']//div")
    public WebElement recipientsName;
    @FindBy(id = "giftcard_43_RecipientEmail")
    public WebElement recipientsEmail;

    @FindBy(id = "//div[@class='giftcard']//div[2]")
    public WebElement sendername;

    @FindBy(id = "giftcard_44_RecipientName")
    public WebElement name2;

    @FindBy(id = "giftcard_43_SenderEmail")
    public WebElement email;

    @FindBy(id = "//div[@class='giftcard']//div[3]")
    public WebElement message;
    @FindBy(id = "add-to-cart-button-43")
    public WebElement add;

    @FindBy(className = "content")
    public WebElement errormessage;
    @FindBy(xpath = "//p[@class='content']")
    public WebElement succes;

    @FindBy(xpath = "//span[@class='close']")
    public WebElement close;
    @FindBy(css = ".cart-label")
    public WebElement cart;

    @FindBy(css = ".product-name")
    public List<WebElement> cartItems;
}
