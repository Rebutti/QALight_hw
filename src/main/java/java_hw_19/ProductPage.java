package java_hw_19;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {

    private WebDriver driver;

    private WebDriverWait waiter;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    @Step("Get <{productID}> product price on PP")
    public String getProductPrice(int productID) {
        By productsPricesXpath = By.xpath("//div[contains(@class,'many__price')]//span[@style='font-size: 24px;']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(productsPricesXpath));
        List<WebElement> productPrice = driver.findElements(productsPricesXpath);
        String lowestPrice = productPrice.get(0).getText();
        String highestPrice = productPrice.get(1).getText();
        return lowestPrice + " - " + highestPrice;
    }

    @Step("Click on the heart button on PP")
    public void productHeartClick() {
        By productHeartXpath = By.xpath("//div[@class='action-button flex action-button--bookmark']");
        WebElement productHeart = driver.findElement(productHeartXpath);
        productHeart.click();
    }

    @Step("Cancel Heart Pop Up on PP")
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
}
