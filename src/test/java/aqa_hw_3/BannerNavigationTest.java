package aqa_hw_3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class BannerNavigationTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        String testUrl = "https://hotline.ua/";
        Actions actions = new Actions(driver);
        try {
            driver.get(testUrl);
            sleep(3000);
            driver.manage().window().maximize();
            List<WebElement> categoriesBtns = driver.findElements(By.xpath(" //div[@class = 'categories-section__inner'] //a"));
            int amountOfElements = categoriesBtns.size();
            for (int i = 0; i < amountOfElements; i++) {
                categoriesBtns = driver.findElements(By.xpath(" //div[@class = 'categories-section__inner'] //a"));
                categoriesBtns.get(i).click();
                sleep(1000);
                WebElement categoriesBtn = driver.findElement(By.xpath("//div[@class = 'flex middle-xs logo-container']//*[@alt='Hotline - порівняти ціни в інтернет-магазинах України']"));
                categoriesBtn.click();
                sleep(1000);
                String currentUrl = driver.getCurrentUrl();
                if (!currentUrl.equals(testUrl)) {
                    throw new IllegalArgumentException(
                            "Title links don`t equal "+currentUrl+" and "+testUrl
                    );
                }
            }
        } finally {
            driver.quit();
        }
    }
}
