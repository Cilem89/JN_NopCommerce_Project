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
    public WebElement giftCardsButton;
    @FindBy(css = ".product-title>a")
    public List<WebElement> giftCards;

    @FindBy(xpath= "//input[@class='recipient-name']")
    public WebElement recipientName;
    @FindBy(xpath= "//input[@class='recipient-email']")
    public WebElement recipientEmail;

    @FindBy(xpath = "//input[@class='sender-name']")
    public WebElement yourName;

    @FindBy(css = ".cart-label")
    public WebElement cart;

    @FindBy(css = ".sender-email")
    public WebElement yourEmail;

    @FindBy(css = ".product-name")
    public List<WebElement> cartItems;

    @FindBy(xpath = "//button[contains(text(),'Add to cart')]")
    public WebElement addToCart;

    @FindBy(css = "[class='bar-notification error']")
    public WebElement giftError;

    @FindBy(css = ".message")
    public WebElement message;

    @FindBy(css = "[class='bar-notification success']")
    public WebElement giftSuccess;
}
