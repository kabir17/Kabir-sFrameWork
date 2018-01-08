package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class HomePage {

    @FindBy(id ="email")
    WebElement emailno;

    @FindBy(name = "pass")
    WebElement passwd;

    @FindBy(xpath = "//*[@id=\"u_0_2\"]")
    WebElement logIn;

    @FindBy(name = "email")
    WebElement emailagain;

    @FindBy(name="pass")
    WebElement passwdagain;

    @FindBy(id = "loginbutton")
    WebElement loginbtn;

    @FindBy(xpath = "//*[@id=\"login_link\"]/div[1]/a")
    WebElement recovery;

    @FindBy(id = "identify_email")
    WebElement identify_email;

    @FindBy(name = "firstname")
    WebElement firstname;

    @FindBy(name = "lastname")
    WebElement lastname;

    @FindBy(name = "reg_email__")
    WebElement Email;

    public void LogIn(){
        emailno.sendKeys("kajol@gmail.com");
    }
    public void LogInagain(){
        emailagain.sendKeys("kajol@gmail.com");
    }
    public void createaccount(){
        firstname.sendKeys("Sami");
        lastname.sendKeys("Sani");
        Email.sendKeys("sami11@gmail.com");

    }

}

