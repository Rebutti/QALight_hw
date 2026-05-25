package aqa_hw_19;


import aqa_hw_19.dataprovider.ProvideData;
import io.qameta.allure.*;
import java_hw_19.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotlineTests extends BaseTestHotLine {

    @Test
    @Description("product comparison test on the the search result page and the wish list page")
    @Epic("Comparison test")
    @Story("Wish List Page")
    @Feature("Product name on wish list page")
    public void comparizedProductTest() {
        String searchedProduct = "Apple watch";
        int productIndex = 2;

        HomePage homePage = new HomePage(getDriver());

        homePage.searchProduct(searchedProduct);

        SearchResultPage productHeart = new SearchResultPage(getDriver());

        String productName = productHeart.getProductName(productIndex);
        productHeart.productHeartClick(productIndex);
        productHeart.heartPopUpCancel();
        productHeart.categoryHeartClick();
        productHeart.heartListClick();

        WishListPage wishListProductName = new WishListPage(getDriver());
        String wishListProductNameText = wishListProductName.getProductName();

        Assert.assertTrue(wishListProductNameText.contains(productName), "The title on the wish list page '" + wishListProductNameText + "' doesn`t equals the title on the search result page '" + productName + "'");
    }

    @Test
    @Description("product`s price comparison test on the the search result page and the PDP")
    @Epic("Comparison test")
    @Story("Product Page")
    @Issue("Jira-123456")
    @Link(name = "Requirements", url = "https://hotline.ua/")
    public void comparizedPriceProductTest() {
        String searchedProduct = "Mac";
        int productIndex = 2;

        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct(searchedProduct);
        SearchResultPage product = new SearchResultPage(getDriver());
        String productPriceValue = product.getProductPrice(productIndex);
        product.productClick(productIndex);
        ProductPage productOnPage = new ProductPage(getDriver());
        String productOnPagePrice = productOnPage.getProductPrice(productIndex);


        Assert.assertEquals(productOnPagePrice, productPriceValue, "The price on the PDP '" + productOnPagePrice + "' doesn`t equals the price on the search result page '" + productPriceValue + "'");
    }

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

    @Test
    @Description("product title comparison  test on the the product description page and the wish list page")
    @Epic("Comparison test")
    @Story("Wish List Page")
    public void checkHeartBtnOnPDP() {
        String searchedProduct = "Samsung";
        int productIndex = 4;

        HomePage homePage = new HomePage(getDriver());
        homePage.searchProduct(searchedProduct);

        SearchResultPage productHeart = new SearchResultPage(getDriver());
        String productName = productHeart.getProductName(productIndex);
        productHeart.productClick(productIndex);

        ProductPage product = new ProductPage(getDriver());
        product.productHeartClick();
        product.heartPopUpCancel();
        product.categoryHeartClick();
        product.heartListClick();

        WishListPage productOnWishListPage = new WishListPage(getDriver());
        String productNameOnWishListPage = productOnWishListPage.getProductName();

        Assert.assertTrue(productNameOnWishListPage.contains(productName), "The title on the wish list page '" + productNameOnWishListPage + "' doesn`t equals the title on the PDP '" + productName + "'");
    }


}
