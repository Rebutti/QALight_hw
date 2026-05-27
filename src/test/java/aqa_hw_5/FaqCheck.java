package aqa_hw_5;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class FaqCheck extends BaseTestVF{
    @Test
    public void checkFAQ() throws InterruptedException{
        FluentWait<WebDriver> waiter = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

        try {
            By faqXpath = By.xpath("//ul[@class='vf-menu-desktop-main__links links']//a[@href='/support']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(faqXpath));
            WebElement faqBtn = getDriver().findElement(faqXpath);
            faqBtn.click();
            By simXpath = By.xpath("//div[contains(text(), 'SIM-картка')]");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(simXpath));
            WebElement simBtn = getDriver().findElement(simXpath);
            simBtn.click();
            By simPageXpath = By.xpath("//h1[contains(text(), 'SIM-картка')]");
            waiter.until(ExpectedConditions.presenceOfElementLocated(simPageXpath));
        }catch (TimeoutException e) {
            throw new RuntimeException("Sim field was not found within 10 seconds");
        }
    }
}
