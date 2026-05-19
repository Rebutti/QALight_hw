package aqa_hw_4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.String.format;

public class vfuTPCheck {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String checkedText = "Передплата";
        WebDriverWait waiter = new WebDriverWait(driver, Duration.ofSeconds(5));

        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            By tpXpath = By.xpath("//a[@href='/tariffs']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(tpXpath));
            WebElement tpBtn = driver.findElement(tpXpath);
            tpBtn.click();
            By prpXpath = By.xpath("//div[text()='Передплата']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(prpXpath));
            String prp = driver.findElement(prpXpath).getText();
            Assert.assertEquals(format("The title 'Передплата' has incorrect text <%s>", prp), checkedText, prp);
        } finally {
            driver.quit();
        }
    }
}
