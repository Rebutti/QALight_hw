package aqa_hw_5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTestHotLine {
    private WebDriver driver;

    public WebDriver getDriver() {
        return this.driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void driverInit() {
        this.driver = new ChromeDriver();
        this.driver.get("https://hotline.ua/");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void driverQuit() {
        this.driver.quit();
    }
}
