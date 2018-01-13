package testcases;

import base.CommonAPI;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageobject.HomePage;
import pageobject.MemberLoginPage;
import pageobject.MemberSignUpPage;


public class TestMemberSignUpPage extends CommonAPI{
    @Test
    public void testMemberSignUp(){
        HomePage hp = PageFactory.initElements(driver,HomePage.class);
        hp.goToMemberLogin();
        MemberLoginPage mlp = PageFactory.initElements(driver, MemberLoginPage.class);
        mlp.newMemberSignUp();
        MemberSignUpPage msup = PageFactory.initElements(driver, MemberSignUpPage.class);
        msup.clickAgree();
        msup.fillUpForm();
    }
}


