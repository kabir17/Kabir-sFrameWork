package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    @FindBy(css = "#nav-logo > a.nav-logo-link > span.nav-logo-base.nav-sprite")
    WebElement logo;

    @FindBy(id = "twoTabSearchTextBox")
    WebElement searchBox;

    @FindBy(xpath = "//*[@id=\"nav-search\"]/form/div[2]/div/input")
    WebElement searchButton;

    @FindBy(css = "#nav-xShop> a:nth-child(3)")
    WebElement toDaysDeals;

    @FindBy(css = "#nav-xShop > a:nth-child(4)")
    WebElement giftCards;

    @FindBy(css = "#nav-xShop > a:nth-child(5)")
    WebElement registry;

    @FindBy(css = "#nav-xShop >a:nth-child(6)")
    WebElement sell;

    @FindBy(css = "#nav-xShop >a:nth-child(7)")
    WebElement help;

    @FindBy(css = "#nav-orders > span,nav-line2")
    WebElement orders;

    @FindBy(css = "#nav-link-prime > span.nav-line-2")
    WebElement linkPrime;

    @FindBy(css = "#nav-cart > span.nav-line-2")
    WebElement cart;

    @FindBy(css = "#navSwmHoliday > a")
    WebElement newYear;

    public void gotoHomePage() {
        logo.click();
    }
    public void searching() {
        searchBox.sendKeys("pents");
        searchButton.click();
    }
    public void gotoToDaysDeals() {
        toDaysDeals.click();
    }
    public void gotoGiftCards() {
        giftCards.click();
    }
    public void gotoRegistry() {
        registry.click();
    }
    public void gotoSell() {
        sell.click();
    }
    public void gotoHelp() {
        help.click();
    }
    public void gotoOrders() {
        orders.click();
    }
    public void gotoLinkPrime() {
        linkPrime.click();
    }
    public void gotoCart() {
        cart.click();
    }
    public void gotoNewYear() {
        newYear.click();
    }
}
