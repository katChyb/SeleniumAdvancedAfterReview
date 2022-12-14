package checkout;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class CheckoutTests extends Pages {


    @RepeatedTest(1)
    @DisplayName("Checkout tests")
    public void checkoutTests() {

        topMenuPage.openLogInPage();
        logInPage.fillInEmailForAlredyExistingUser();
        logInPage.fillInPasswordForAlredyExistingUser();
        logInPage.signIn();
        topMenuPage.inputSearchProductByText(System.getProperty("BasketPopupTestWantedProduct"));
        topMenuPage.triggerSearchProduct();
        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
        String procuctPrice = String.valueOf(productDetailsPage.getPrice());
        productDetailsPage.addProductToCart();
        cartPopupPage.waitForPopupToBeVisible();
        cartPopupPage.clickOnProceedToCheckoutButton();
        cartDetailsPage.proceedToCheckout();
        String deliveryAddress = checkoutPage.getDeliveryAddress();

        checkoutPage.differentInvoiceAddress();
        checkoutPage.fillInInvoiceAddress();
        String invoiceAddress = checkoutPage.getInvoiceAddress();

        checkoutPage.confirmDeliveryOption();
        checkoutPage.payByCheckMethod();
        checkoutPage.acceptTermsOfService();
        checkoutPage.placeOrder();
        String orderReference = checkoutPage.getOrderReference();
        topMenuPage.openMyAccountMenu();
        myAccountPage.openOrderHistoryDetails();
        orderHistoryPage.openDetailsByName(orderReference);


    }
}
