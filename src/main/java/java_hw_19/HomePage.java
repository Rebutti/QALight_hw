package java_hw_19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    private WebDriverWait waiter;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void searchProduct(String searchProductName) {
        By inputFieldXpath = By.xpath("//input");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(inputFieldXpath));
        WebElement searchField = driver.findElement(inputFieldXpath);
        searchField.sendKeys(searchProductName, Keys.ENTER);
    }

    public void loginBtnClick() {
        By loginBtnXpath = By.xpath("//div[@class='user-button__image flex middle-xs center-xs']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(loginBtnXpath));
        WebElement loginBtn = driver.findElement(loginBtnXpath);
        loginBtn.click();
    }
}