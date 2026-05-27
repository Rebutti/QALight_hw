package java_hw_19;

import io.qameta.allure.Step;
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

    @Step("Click on the <{productID}> heart button on SRP")
    public void productHeartClick(int productID) {
        By productsHeartXpath = By.xpath("//div[@class='bookmark-button__icon-wrapper']");
        WebElement productHeart = driver.findElements(productsHeartXpath).get(productID - 1);
        productHeart.click();
    }

    @Step("Get <{productID}> product name on SRP")
    public String getProductName(int productID) {
        By productsNamesXpath = By.xpath("//a[@class='item-title text-md link link--black']");
        WebElement productName = driver.findElements(productsNamesXpath).get(productID - 1);
        return productName.getText();
    }

    @Step("Cancel Heart Pop Up on SRP")
    public void heartPopUpCancel() {
        By heartPopUpCancelBtnXpath = By.xpath("//button[@class='button-close modal__close-icon']");
        WebElement heartPopUpCancelBtn = driver.findElement(heartPopUpCancelBtnXpath);
        heartPopUpCancelBtn.click();
    }

    @Step("Click on the category heart button")
    public void categoryHeartClick() {
        By categoryHeartBtnXpath = By.xpath("//div[@class='popover my-lists']//div[@class='button__icon flex']");
        WebElement categoryHeartBtn = driver.findElement(categoryHeartBtnXpath);
        categoryHeartBtn.click();
    }

    @Step("Click on the heart list and move to the WLP")
    public void heartListClick() {
        By heartListBtnXpath = By.xpath("//div[@class='profile-sidebar__section-child-container']");
        WebElement heartList = driver.findElement(heartListBtnXpath);
        heartList.click();
        waiter.until(webDriver ->
                ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    @Step("Get <{productID}> product price on SRP")
    public String getProductPrice(int productID) {
        By productsPricesXpath = By.xpath("//div[@class='text-md text-orange text-lh--1']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(productsPricesXpath));
        WebElement productPrice = driver.findElements(productsPricesXpath).get(productID - 1);
        return productPrice.getText()
                .replace("₴", "")
                .replace("–", "-")
                .trim();
    }

    @Step("Click on the <{productID}> product and move to the Product page")
    public void productClick(int productID) {
        By productsXpath = By.xpath("//a[@class='item-title text-md link link--black']");
        WebElement product = driver.findElements(productsXpath).get(productID - 1);
        product.click();
    }
}
