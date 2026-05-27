package aqa_hw_4;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VfuMarket {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            By shopBtnXpath = By.xpath("//span[text()='Інтернет-магазин']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(shopBtnXpath));

            WebElement shopBtn = driver.findElement(shopBtnXpath);
            shopBtn.click();
            By purposeXpath = By.xpath("//ol[@class = 'product-items widget-product-grid owl-carousel owl-loaded owl-drag']");
            waiter.until(ExpectedConditions.presenceOfElementLocated(purposeXpath));
        }catch (TimeoutException e) {
            throw new RuntimeException("Store search field was not found within 10 seconds");
        }
        finally {
            driver.quit();
        }
    }
}
