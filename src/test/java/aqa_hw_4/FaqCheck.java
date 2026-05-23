package aqa_hw_4;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class FaqCheck {
    public static void main(String[] args ) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        FluentWait<WebDriver> waiter = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            By faqXpath = By.xpath("//ul[@class='vf-menu-desktop-main__links links']//a[@href='/support']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(faqXpath));
            WebElement faqBtn = driver.findElement(faqXpath);
            faqBtn.click();
            By simXpath = By.xpath("//div[contains(text(), 'SIM-картка')]");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(simXpath));
            WebElement simBtn = driver.findElement(simXpath);
            simBtn.click();
            By simPageXpath = By.xpath("//h1[contains(text(), 'SIM-картка')]");
            waiter.until(ExpectedConditions.presenceOfElementLocated(simPageXpath));
        }catch (TimeoutException e) {
            throw new RuntimeException("Sim field was not found within 10 seconds");
        }
        finally {
            driver.quit();
        }
    }
}
