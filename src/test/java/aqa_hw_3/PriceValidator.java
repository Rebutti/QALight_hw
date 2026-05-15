package aqa_hw_3;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static java.lang.Thread.sleep;

public class PriceValidator {

    public static void main(String[] args) throws InterruptedException {
        String searchWord = "Samsung Galaxy S24";
        WebDriver driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        try {
            driver.get("https://hotline.ua");
            sleep(3000);
            driver.manage().window().maximize();
            WebElement inputField = driver.findElement(By.xpath("//input"));
            inputField.click();
            inputField.sendKeys(searchWord, Keys.ENTER);
            sleep(10000);
            WebElement firstPhone = driver.findElement(By.xpath(" //a[@class = 'item-title text-md link link--black']"));
            firstPhone.click();
            sleep(10000);
            List<WebElement> phonePrices = driver.findElements(By.xpath("//div[@class = 'many__price']//span[@style]"));
            WebElement phonePrice = driver.findElement(By.xpath("//div[@class = 'many__price']//span[@style]"));
            long lowPrice = Long.parseLong(phonePrices.get(0).getText().replace(" ", ""));
            long highPrice = Long.parseLong(phonePrices.get(1).getText().replace(" ", ""));
            if (lowPrice > highPrice) {
                throw new IllegalArgumentException(
                        "Low price cannot be greater than high price."
                );
            }
            sleep(3000);
        } finally {
            driver.quit();
        }
    }
}
