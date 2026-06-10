package aqa_hw_22;


import aqa_hw_22.dataprovider.ProvideData;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Story;
import java_hw_19.HomePage;
import java_hw_19.LoginPage;
import java_hw_19.RegistrationPage;
import org.testng.annotations.Test;
import aqa_hw_19.BaseTestHotLine;

public class HotlineLoginTest extends BaseTestHotLine{

    @Test(dataProvider = "getSearchData", dataProviderClass = ProvideData.class)
    @Description("checking login and password input fields test")
    @Epic("Login tests")
    @Story("Login Page")
    public void login(String email, String pass) {
        HomePage login = new HomePage(getDriver());
        login.loginBtnClick();
        LoginPage loginSend = new LoginPage(getDriver());
        loginSend.loginFieldSendKeys(email);
        loginSend.passwordFieldSendKeys(pass);
    }

    @Test(dataProvider = "getSearchData", dataProviderClass = ProvideData.class)
    @Description("checking login, name and password input fields test")
    @Epic("Registration tests")
    @Story("Registration Page")
    public void registration(String email, String pass) {
        String name = "Oleg";
        HomePage login = new HomePage(getDriver());
        login.loginBtnClick();
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.registrationBtnClick();
        RegistrationPage registration = new RegistrationPage(getDriver());
        registration.loginFieldSendKeys(email);
        registration.passwordFieldSendKeys(pass);
        registration.nameFieldSendKeys(name);
    }
}
