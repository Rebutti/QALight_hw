package java_hw_19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private WebDriver driver;

    private WebDriverWait waiter;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    public void loginFieldSendKeys(String email) {
        By emailFieldXpath = By.xpath("//input[@inputmode]");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(emailFieldXpath));
        WebElement emailField = driver.findElement(emailFieldXpath);
        emailField.sendKeys(email);
    }

    public void passwordFieldSendKeys(String email) {
        By passwordFieldXpath = By.xpath("//input[@placeholder='Пароль']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldXpath));
        WebElement passwordField = driver.findElement(passwordFieldXpath);
        passwordField.sendKeys(email);
    }
}