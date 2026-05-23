package aqa_hw_5;


import aqa_hw_5.dataprovider.ProvideData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class HotLineTests extends BaseTestHotLine  {
    @Test(dataProvider = "getSearchData", dataProviderClass = ProvideData.class)
    public void login(String email, String pass){
        WebElement loginBtn = getDriver().findElement(By.xpath("//div[@class='user-button__image flex middle-xs center-xs']"));
        loginBtn.click();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement emailField = getDriver().findElement(By.xpath("//input[@inputmode]"));
        emailField.sendKeys(email);
        WebElement passField = getDriver().findElement(By.xpath("//input[@placeholder='Пароль']"));
        passField.sendKeys(pass, Keys.ENTER);

    }

    @Test(expectedExceptions = TimeoutException.class)
    public void bannerCheck() {
        FluentWait<WebDriver> waiter = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        By categoryXpath = By.xpath(" //div[@class = 'categories-section__inner'] //a");
        WebElement categoriesBtn = getDriver().findElement(categoryXpath);
        categoriesBtn.click();
        By homeTitleXpath = By.xpath("//h1[contains(text(), 'Все для дому')]");
        waiter.until(ExpectedConditions.visibilityOfElementLocated(homeTitleXpath));
    }

}
