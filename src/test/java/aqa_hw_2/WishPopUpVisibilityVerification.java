package aqa_hw_2;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.String.format;
import static java.lang.Thread.sleep;


public class WishPopUpVisibilityVerification {
    public static void main(String[] args) throws InterruptedException {
        String searchWord = "apple watch";
        WebDriver driver = new ChromeDriver();
        try {

            driver.get("https://hotline.ua");
            sleep(3000);
            driver.manage().window().maximize();

            WebElement wishListButton = driver.findElement(By.xpath("//div[@class = 'hidden-below-xl'] //div[@class = 'button__icon flex']"));
            wishListButton.click();


            WebElement wishListPopUp = driver.findElement(By.xpath("//div[contains(@class, 'my-lists__section')]"));
            Assert.assertTrue("Wish list popup isn`t displayed ",wishListPopUp.isDisplayed());

            sleep(3000);
        } finally {
            driver.quit();
        }


    }
}
