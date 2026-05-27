package java_hw_18;

import org.openqa.selenium.By;
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

    public String getProductPrice(int productID) {
        By productsPricesXpath = By.xpath("//div[contains(@class,'many__price')]//span[@style='font-size: 24px;']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(productsPricesXpath));
        List<WebElement> productPrice = driver.findElements(productsPricesXpath);
        String lowestPrice = productPrice.get(0).getText();
        String highestPrice = productPrice.get(1).getText();
        return lowestPrice + " - " + highestPrice;
    }
}
