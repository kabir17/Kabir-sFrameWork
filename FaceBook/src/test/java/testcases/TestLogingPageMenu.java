package testcases;

import org.testng.annotations.Test;
import pageobject.LoginPage;

public class TestLogingPageMenu extends LoginPage {
    @Test
    public void drop(){
       logIn();

    }
}
