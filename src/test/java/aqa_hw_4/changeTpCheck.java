package aqa_hw_4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.List;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class changeTpCheck {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);

        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            By tpXpath = By.xpath("//a[@href='/tariffs']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(tpXpath));
            WebElement tpBtn = driver.findElement(tpXpath);
            tpBtn.click();
            By flexxGoXpath = By.xpath("//span[text()='Змінити тариф']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(flexxGoXpath));
            List<WebElement> flexxGoBtn = driver.findElements(flexxGoXpath);
            waiter.until(ExpectedConditions.elementToBeClickable(flexxGoXpath));
            flexxGoBtn.get(1).click();
            By myVfWindow = By.xpath("//div[@class='vf-action-confirmation__content content']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(myVfWindow));
        } finally {
            driver.quit();
        }
    }
}
