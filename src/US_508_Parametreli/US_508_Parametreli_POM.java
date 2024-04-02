package US_508_Parametreli;

import Utility.BaseDriver;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class US_508_Parametreli_POM extends BaseDriver {

    @Test
    @Parameters("searchtext")
    public void _508_POM(String arananKelime){
    US_508_Parametreli_Elements e=new US_508_Parametreli_Elements();
        driver.get("https://demo.nopcommerce.com/");

        e.Search.sendKeys(arananKelime, Keys.ENTER);

        Assert.assertTrue(e.urunler.getText().toLowerCase().contains("adobe photoshop cs4"),"basarisiz");


    }

}
