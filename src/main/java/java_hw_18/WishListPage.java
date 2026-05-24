package java_hw_18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WishListPage {
    private WebDriver driver;

    private WebDriverWait waiter;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public String getProductName() {
        By productNameXpath = By.xpath("//div[@class='list-item list-item--row list-item--row--profile']//div[@class='list-item__info']//a[@class='item-title text-md link link--black']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(productNameXpath));
        WebElement productName = driver.findElement(productNameXpath);
        return productName.getText();
    }
}