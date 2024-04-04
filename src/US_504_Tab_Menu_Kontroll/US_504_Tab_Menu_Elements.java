package US_504_Tab_Menu_Kontroll;

import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class US_504_Tab_Menu_Elements {

    public US_504_Tab_Menu_Elements(){
        PageFactory.initElements(BaseDriver.driver,this);
    }
    @FindBy(css = "div[class='details'] a")
    public List<WebElement> productNameList;

    @FindBy (id = "small-searchterms")
    public WebElement searchBox;

    @FindBy(css = "h2[class='product-title'] a")
    public WebElement productName;


}
