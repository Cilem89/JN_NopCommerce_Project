package US_505_TabMenuUrunKontrol;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US_505_TabMenuUrunKontrol_Elements {

    public US_505_TabMenuUrunKontrol_Elements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li") //ul[@class='top-menu notmobile']//a
    public List<WebElement> tabMenuItems;

    @FindBy(id = "small-searchterms")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='item-grid']/div")
    public List<WebElement> searchResults;



}
