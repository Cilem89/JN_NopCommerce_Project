package US_507_SiparisVerme;

import Utility.BaseDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US_507_Siparis_POM extends BaseDriver {

    @Test
    public void _507_POM(){

        US_507_Siparis_Elements e=new US_507_Siparis_Elements();

        driver.get("https://demo.nopcommerce.com/");

        e.computers.click();
        e.desktops.click();
        e.owncomputer.click();
        e.ram.click();
        e.ram8gb.click();
        e.rom.click();
        e.cartbtn.click();

        Assert.assertTrue(e.verify.getText().toLowerCase().contains("the product has been added to your"),"basarisiz");



    }

}
