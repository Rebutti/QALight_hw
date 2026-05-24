package aqa_hw_3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static java.lang.Thread.sleep;

public class openProductInNewTabTest {

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
            String phoneName = firstPhone.getText();
            actions.keyDown(Keys.CONTROL).click(firstPhone).keyDown(Keys.CONTROL).perform();
            String lastTabId = driver.getWindowHandles().stream().toList().get(1);
            driver.switchTo().window(lastTabId);
            WebElement phoneTitle = driver.findElement(By.xpath(" //h1"));
            String phoneTitleName = phoneTitle.getText().replace("Смартфон ", "");
            if (!phoneTitleName.equals(phoneName)) {
                System.out.println(phoneName + " not equals " + phoneTitleName);
            }
        } finally {
            driver.quit();
        }
    }

}
