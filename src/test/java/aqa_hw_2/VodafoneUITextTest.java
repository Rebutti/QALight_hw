package aqa_hw_2;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.String.format;
import static java.lang.Thread.sleep;


public class VodafoneUITextTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String checkedText = "Home internet";
        try {
            driver.get("https://www.vodafone.ua/");
            driver.manage().window().maximize();
            sleep(3000);
            WebElement engLanguageBtn = driver.findElement(By.xpath("//div[@class = 'language__item']"));
            engLanguageBtn.click();
            sleep(3000);
            String homeInternetText = driver.findElement(By.xpath("//div[contains(text(), 'Home internet')]")).getText();
            Assert.assertEquals(format("The button 'Home internet' has incorrect title <%s>", homeInternetText), checkedText, homeInternetText);
        } finally {
            driver.quit();
        }


    }
}
