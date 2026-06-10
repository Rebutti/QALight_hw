package java_hw_19;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class RegistrationPage {

    private WebDriver driver;

    private WebDriverWait waiter;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        waiter = new WebDriverWait(this.driver, Duration.ofSeconds(5));
    }

    @Step("Fill <{email}> to the email field")
    public void loginFieldSendKeys(String email) {
        By emailFieldXpath = By.xpath("//input[@inputmode]");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(emailFieldXpath));
        WebElement emailField = driver.findElement(emailFieldXpath);
        emailField.sendKeys(email);
    }

    @Step("Fill <{pass}> to the password field")
    public void passwordFieldSendKeys(String pass) {
        By passwordFieldXpath = By.xpath("//input[@placeholder='Пароль']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(passwordFieldXpath));
        WebElement passwordField = driver.findElement(passwordFieldXpath);
        passwordField.sendKeys(pass);
    }

    @Step("Fill <{name}> to the password field")
    public void nameFieldSendKeys(String name) {
        By nameFieldXpath = By.xpath("//input[@id='name']");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(nameFieldXpath));
        WebElement passwordField = driver.findElement(nameFieldXpath);
        passwordField.sendKeys(name);
    }

}
