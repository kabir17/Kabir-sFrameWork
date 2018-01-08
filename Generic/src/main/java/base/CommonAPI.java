package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class CommonAPI {

    //declare driver;
    public static WebDriver driver = null;


    //runs before each test method

    @Parameters({"browser_name", "operating_system", "URL"})
    @BeforeMethod
    public void setUp(String browserName, String os, String url) {
        getLocalDriver(browserName, os);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);

    }

    //runs after each test method
    @AfterMethod
    public static void cleanUp() {
        driver.close();
    }

    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver", "Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("mac")) {
            System.setProperty("webdriver.chrome.driver", "Generic/driver/chromedriver");
            driver = new ChromeDriver();
        }
    }else if(browserName.equalsIgnoreCase("firefox")){
        if (os.equalsIgnoreCase("windows")) {
            System.setProperty("webdriver.gecko.driver", "/Generic/driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }else if (os.equalsIgnoreCase("mac")){
            System.setProperty("webdriver.gecko.driver.","Generic/driver/gecodriver");
            driver = new FirefoxDriver();
        }
    }return driver;
  }
}




