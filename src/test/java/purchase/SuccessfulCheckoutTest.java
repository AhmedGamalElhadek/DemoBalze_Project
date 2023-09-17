package purchase;

import Pages.CartPage;
import Pages.ProductPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SuccessfulCheckoutTest extends BaseTest {
    private String userName = "AhmedKamelAbde@gmail.net";
    private String passwod = "1234";
    public SuccessfulCheckoutTest(){
    }
    @Test
    public void signUpTest(){
        homePage.signUp(userName , passwod);
        String SignUpMessage = homePage.signUpAlertMessage();
        String successfulSignUpMessage = "Sign up successful.";
        Assert.assertTrue(SignUpMessage.contains(successfulSignUpMessage));
    }
    @Test(dependsOnMethods = "signUpTest")
    public void logInTest(){
        homePage.logIn(userName , passwod);
        String loginMessage = homePage.logInMessage();
        Assert.assertTrue(loginMessage.contains(userName));
    }
    @Test(dependsOnMethods = "logInTest")
    public void categoriesTest(){
        if (homePage.categoryCheck().isEmpty())
            System.out.println("No items found");
        else
            System.out.println("Category contain items");
    }
    public void addItemTest(){
        ProductPage productPage = homePage.addItem();
        productPage.addToCart();
        String addedMessage = "Product added.";
        Assert.assertTrue(productPage.getaddedMessage().contains(addedMessage));
    }
    @Test(dependsOnMethods = "logInTest")
    public void checkoutTest(){
        addItemTest();
        CartPage cartPage1 = productPage.goToCart();
        cartPage1.checkOut("Ahmed","Egypt","Cairo","123456789","02","2020");
        cartPage1.confirmPurchase();
    }
}
