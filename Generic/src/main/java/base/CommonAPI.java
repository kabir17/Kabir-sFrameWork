package base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    //declare driver;
    public static WebDriver driver = null;


    //runs before each test method
    @Parameters({"url"})
    @BeforeMethod
    public static void setUp(String url) {
        System.setProperty("webdriver.chrome.driver", "../Generic/driver/chromedriver.exe");
        driver = new ChromeDriver();  //Generic/driver/chromedriver.exe
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.facebook.com");
        driver.manage().window().maximize();
    }


    //runs after each test method
    @AfterMethod
    public static void cleanUp() {
        driver.close();
    }
}




