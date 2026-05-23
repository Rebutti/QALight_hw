package aqa_hw_4;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.String.format;
import static java.lang.Thread.sleep;

public class LanguageCheck {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        String checkedText = "Home internet";
        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            WebElement engLanguageBtn = driver.findElement(By.xpath("//div[@class = 'language__item']"));
            engLanguageBtn.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            String homeInternetText = driver.findElement(By.xpath("//div[contains(text(), 'Home internet')]")).getText();
            Assert.assertEquals(format("The button 'Home internet' has incorrect title <%s>", homeInternetText), checkedText, homeInternetText);
        } finally {
            driver.quit();
        }
    }
}
