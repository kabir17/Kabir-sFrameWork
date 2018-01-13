package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.DropDownMenu;

public class TestDropDownMenu extends DropDownMenu {
        @BeforeMethod
        public void initializeElements(){

        }
        @Test
    public void TestDropDownMenu() throws InterruptedException {
        DropDownMenu dropDownMenu = PageFactory.initElements(driver,DropDownMenu.class);
        Thread.sleep(3000);
        dropDownMenu.dropDown();
    }
    @Test
    public void testMouseHover(){
         DropDownMenu dropDownMenu = PageFactory.initElements(driver,DropDownMenu.class);
         dropDownMenu.mouseHover();
    }
}
