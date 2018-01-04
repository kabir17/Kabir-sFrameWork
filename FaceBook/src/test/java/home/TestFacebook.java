package home;

import base.CommonAPI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestFacebook extends CommonAPI {
   @Test
    public void Fblogin() throws InterruptedException {
       driver.findElement(By.id("email")).sendKeys("kajol@gamail.com");
       Thread.sleep(3000);
   }
   @Test
    public void pass() throws InterruptedException {
       driver.findElement(By.id("pass")).sendKeys("123456");
       Thread.sleep(3000);
   }
}
