package java_hw_19;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchResultPage {

    private WebDriver driver;

    private WebDriverWait waiter;

    public SearchResultPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void productHeartClick(int productID) {
        By productsHeartXpath = By.xpath("//div[@class='bookmark-button__icon-wrapper']");
        WebElement productHeart = driver.findElements(productsHeartXpath).get(productID - 1);
        productHeart.click();
    }

    public String getProductName(int productID) {
        By productsNamesXpath = By.xpath("//a[@class='item-title text-md link link--black']");
        WebElement productName = driver.findElements(productsNamesXpath).get(productID - 1);
        return productName.getText();
    }

    public void heartPopUpCancel() {
        By heartPopUpCancelBtnXpath = By.xpath("//button[@class='button-close modal__close-icon']");
        WebElement heartPopUpCancelBtn = driver.findElement(heartPopUpCancelBtnXpath);
        heartPopUpCancelBtn.click();
    }

    public void categoryHeartClick() {
        By categoryHeartBtnXpath = By.xpath("//div[@class='popover my-lists']//div[@class='button__icon flex']");
        WebElement categoryHeartBtn = driver.findElement(categoryHeartBtnXpath);
        categoryHeartBtn.click();
    }

    public void heartListClick() {
        By heartListBtnXpath = By.xpath("//div[@class='profile-sidebar__section-child-container']");
        WebElement heartList = driver.findElement(heartListBtnXpath);
        heartList.click();
        waiter.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public String getProductPrice(int productID) {
        By productsPricesXpath = By.xpath("//div[@class='text-md text-orange text-lh--1']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(productsPricesXpath));
        WebElement productPrice = driver.findElements(productsPricesXpath).get(productID - 1);
        return productPrice.getText()
                .replace("₴", "")
                .replace("–", "-")
                .trim();
    }

    public void productClick(int productID) {
        By productsXpath = By.xpath("//a[@class='item-title text-md link link--black']");
        WebElement product = driver.findElements(productsXpath).get(productID - 1);
        product.click();
    }
}
