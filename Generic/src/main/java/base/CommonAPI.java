package base;

import com.aventstack.extentreports.ExtentReports;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CommonAPI {

    public static WebDriver driver = null;
    public String browserstack_username = "kajol2";
    public String browserstack_accesskey = "o7qWK8yhdA8dPSpHWn2n";
    public String saucelabs_username;
    public String saucelabs_accesskey;

    public static ExtentReports extent;

    @Parameters({"useCloudEnv","cloudEnvName","os","os_version","browser_name","browserVersion","url"})
    @BeforeMethod
    public void setUp(@Optional("false") boolean useCloudEnv, @Optional("false")String cloudEnvName,
                      @Optional("OS X") String os,@Optional("10") String os_version, @Optional("firefox") String browser_name, @Optional("34")
                              String browserVersion, @Optional("http://www.youtube.com") String url)throws IOException {
        if(useCloudEnv==true){getLocalDriver(os, browser_name);
            if(cloudEnvName.equalsIgnoreCase("browserstack")) {
                getCloudDriver(cloudEnvName,browserstack_username,browserstack_accesskey,os,os_version, browser_name , browserVersion);
            }else if (cloudEnvName.equalsIgnoreCase("saucelabs")){
                getCloudDriver(cloudEnvName,saucelabs_username, saucelabs_accesskey,os,os_version, browser_name, browserVersion);
            }
        }else{
            getLocalDriver(browser_name, os);
        }
        getLocalDriver(browser_name,os);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
    }
    public WebDriver getLocalDriver(String browserName, String os) {
        if (browserName.equalsIgnoreCase("chrome")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.chrome.driver","../Generic/driver/chromedriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mohammad Kabir\\IdeaProjects\\OrgProjectTeam1\\Generic\\driver\\chromedriver");
                driver = new ChromeDriver();
            }
        }
        if (browserName.equalsIgnoreCase("firefox")) {
            if (os.equalsIgnoreCase("windows")) {
                System.setProperty("webdriver.gecko.driver", "../Generic/driver/geckodriver.exe");
                driver = new ChromeDriver();
            } else if (os.equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\Mohammad Kabir\\IdeaProjects\\OrgProjectTeam1\\Generic\\driver\\geckodriver");
                driver = new ChromeDriver();
            }
        }return driver;
    }
    public WebDriver getCloudDriver(String envName,String envUsername, String envAccessKey,String os, String os_version,String browserName,
                                    String browserVersion)throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("browser",browserName);
        cap.setCapability("browser_version",browserVersion);
        cap.setCapability("os", os);
        cap.setCapability("os_version", os_version);
        if(envName.equalsIgnoreCase("Saucelabs")){
            //resolution for Saucelabs
            driver = new RemoteWebDriver(new URL("http://"+envUsername+":"+envAccessKey+
                    "@ondemand.saucelabs.com:80/wd/hub"), cap);
        }else if(envName.equalsIgnoreCase("Browserstack")) {
            cap.setCapability("resolution", "1024x768");
            driver = new RemoteWebDriver(new URL("http://" + envUsername + ":" + envAccessKey +
                    "@hub-cloud.browserstack.com/wd/hub"), cap);
        }
        return driver;
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    //to send keys by different element locators
    public void typeByxpath(String locator, String value) {
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeByID(String locator, String value) {
        driver.findElement(By.id(locator)).sendKeys(value);
    }
    public void typeByname(String locator, String value) {
        driver.findElement(By.name(locator)).sendKeys(value);
    }
    public void typeByClassName(String locator, String value) {
        driver.findElement(By.className(locator)).sendKeys(value);
    }
    public void typeByCssSlector(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }
    public void clickByXpath(String locator) {
        driver.findElement(By.xpath(locator)).click();
    }
    public void clickById(String locator) {
        driver.findElement(By.id(locator)).click();
    }
    public void clickByName(String locator) {
        driver.findElement(By.name(locator)).click();
    }
    public void clickByClassName(String locator) {
        driver.findElement(By.className(locator)).click();
    }
    public void clickByCssSlector(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }

    public void takeEnterKeysbyXpath(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }
    public void takeEnterKeysbyID(String locator) {
        driver.findElement(By.id(locator)).sendKeys(Keys.ENTER);
    }
    public void takeEnterKeysbyName(String locator) {
        driver.findElement(By.name(locator)).sendKeys(Keys.ENTER);
    }
    public void takeEnterKeysbycssSelector(String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.ENTER);
    }
    public void typeEnterKeybyClassName(String locator, String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(Keys.ENTER);
    }
    public void clearInputbyXpath(String locator){
        driver.findElement(By.xpath(locator)).clear();
    }
    public void clearInputbyID(String locator){
        driver.findElement(By.id(locator)).clear();
    }
    public void clearInputByCssSelector(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
    public void clearInputByName(String locator){
        driver.findElement(By.name(locator)).clear();
    }
    public void clearInputByClassName(String locator){
        driver.findElement(By.className(locator)).clear();
    }
    //to get the current page url
    public String getCurrentPageUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }
    //to navigate to the previous page
    public void navigateBack() {
        driver.navigate().back();
    }
    //to move to the next page
    public void navigateForward() {
        driver.navigate().forward();
    }
    public String getTextByXpath(String locator) {
        String st = driver.findElement(By.xpath(locator)).getText();
        return st;
    }
    public String getTextById(String locator) {
        return driver.findElement(By.id(locator)).getText();
    }

    public String getTextByName(String locator) {
        String st = driver.findElement(By.name(locator)).getText();
        return st;
    }
    public List<String> getTextFromWebElements(String locator){
        List<WebElement> element = new ArrayList<WebElement>();
        List<String> text = new ArrayList<String>();
        try {
            element = driver.findElements(By.cssSelector(locator));
        }catch(Exception ex){
            ex.printStackTrace();
            element = driver.findElements(By.xpath(locator));
        }
        for(WebElement web:element){
            text.add(web.getText());
        }
        return text;
    }
    //to get list of web elements by different locators
    public List<WebElement> getListOfWebElementsByCss(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.cssSelector(locator));
        return list;
    }
    public List<WebElement> getListOfWebElementsByXpath(String locator) {
        List<WebElement> list = new ArrayList<WebElement>();
        list = driver.findElements(By.xpath(locator));
        return list;
    }
    public void mouseHoverByXpath(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    public void mouseHoverByCSS(String locator) {
        try {
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            Actions hover = action.moveToElement(element);
        } catch (Exception ex) {
            System.out.println("First attempt has been done, This is second try");
            WebElement element = driver.findElement(By.cssSelector(locator));
            Actions action = new Actions(driver);
            action.moveToElement(element).perform();
        }
    }
    //iFrame Handle
    public void iFrameHandle(WebElement element){
        driver.switchTo().frame(element);
    }
    public void goBackToHomeWindow(){
        driver.switchTo().defaultContent();
    }
    //Taking Screen shots
    public void takeScreenShot()throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("screenShots.png"));
    }
    //Synchronization
    public void waitUntilClickAble(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public void waitUntilVisible(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void waitUntilSelectable(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean element = wait.until(ExpectedConditions.elementToBeSelected(locator));
    }
    public void upLoadFile(String locator,String path){
        driver.findElement(By.cssSelector(locator)).sendKeys(path);
        /* path example to upload a file/image
           path= "C:\\Users\\rrt\\Pictures\\ds1.png";
         */
    }
    public List<String> getListOfString(List<WebElement> list) {
        List<String> items = new ArrayList<String>();
        for (WebElement element : list) {
            items.add(element.getText());
        }
        return items;
    }
    public void selectOptionByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec * 1000);
    }
    public void clearInput(String locator){
        driver.findElement(By.cssSelector(locator)).clear();
    }
}
