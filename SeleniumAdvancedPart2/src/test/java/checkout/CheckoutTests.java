package checkout;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class CheckoutTests extends Pages {


    @RepeatedTest(1)
    @DisplayName("Checkout tests")
    public void checkoutTests() {

        topMenuPage.openLogInPage();
        logInPage.fillInEmail();
        logInPage.fillInPassword();
        logInPage.signIn();
//        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
//        productDetailsPage.addProductToCart();
//        cartPopupPage.clickOnProceedToCheckoutButton();


        topMenuPage.inputSearchProductByText(System.getProperty("BasketPopupTestWantedProduct"));
        topMenuPage.triggerSearchProduct();
        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
        productDetailsPage.addProductToCart();
        cartPopupPage.waitForPopupToBeVisible();
        cartPopupPage.clickOnProceedToCheckoutButton();
        cartDetailsPage.proceedToCheckout();
        checkoutPage.unmarkUseSameAddress();
        checkoutPage.fillInAddress();

    }
}
