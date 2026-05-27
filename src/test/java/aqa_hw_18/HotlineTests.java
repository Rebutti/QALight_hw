package aqa_hw_18;


import aqa_hw_18.dataprovider.ProvideData;
import java_hw_18.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotlineTests extends BaseTestHotLine {

    @Test
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


        Assert.assertEquals(productOnPagePrice, productPriceValue);
    }

    @Test(dataProvider = "getSearchData", dataProviderClass = ProvideData.class)
    public void login(String email, String pass) {

        HomePage login = new HomePage(getDriver());
        login.loginBtnClick();
        LoginPage loginSend = new LoginPage(getDriver());
        loginSend.loginFieldSendKeys(email);
        loginSend.passwordFieldSendKeys(pass);
    }


}
