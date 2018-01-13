package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.HomePage;

public class TestHomePage extends HomePage{
    @BeforeMethod
    public void initializeElements(){
        PageFactory.initElements(driver,HomePage.class);
    }
    @Test
    public void testSearch(){
        search();
    }
    @Test
    public void testLangChangeEnglishToChinese(){
        langChangeEnglishToChinese();
    }
}


