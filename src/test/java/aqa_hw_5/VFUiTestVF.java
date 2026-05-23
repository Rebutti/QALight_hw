package aqa_hw_5;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.String.format;

public class VFUiTestVF extends BaseTestVF {
    @Test
    public void vfuLanguage() {
        String checkedText = "Home internet";
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement engLanguageBtn = getDriver().findElement(By.xpath("//div[@class = 'language__item']"));
        engLanguageBtn.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String homeInternetText = getDriver().findElement(By.xpath("//div[contains(text(), 'Home internet')]")).getText();
        Assert.assertEquals(format("The button 'Home internet' has incorrect title <%s>", homeInternetText), checkedText, homeInternetText);
    }
    @Test
    public void checkMrk() {
        WebDriverWait waiter = new WebDriverWait(getDriver(), Duration.ofSeconds(5));
        try {
            By shopBtnXpath = By.xpath("//span[text()='Інтернет-магазин']");
            waiter.until(ExpectedConditions.visibilityOfElementLocated(shopBtnXpath));

            WebElement shopBtn = getDriver().findElement(shopBtnXpath);
            shopBtn.click();
            By purposeXpath = By.xpath("//ol[@class = 'product-items widget-product-grid owl-carousel owl-loaded owl-drag']");
            waiter.until(ExpectedConditions.presenceOfElementLocated(purposeXpath));
        }catch (TimeoutException e) {
            throw new RuntimeException("Store search field was not found within 10 seconds");
        }
    }
}
