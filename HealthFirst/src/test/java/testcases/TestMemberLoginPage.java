package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MemberLoginPage;

public class TestMemberLoginPage extends CommonAPI {
    @Test
    public void testMemberLogIn(){
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.goToMemberLogin();
        MemberLoginPage mlp = PageFactory.initElements(driver, MemberLoginPage.class);
        mlp.memberLogin();
    }
    @Test
    public void testForgetPassword(){
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.goToMemberLogin();
        MemberLoginPage mlp = PageFactory.initElements(driver, MemberLoginPage.class);
        mlp.memberLogin();
        mlp.forgetPassword();
    }
}


