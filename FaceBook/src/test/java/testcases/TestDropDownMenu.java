package testcases;

import org.testng.annotations.Test;
import pageobject.DropDownMenu;

public class TestDropDownMenu extends DropDownMenu{
    @Test
    public void drop() throws InterruptedException {
        //DropDownMenu dropDownMenu = PageFactory.initElements(driver, DropDownMenu.class);
        getMenus();
    }
}
