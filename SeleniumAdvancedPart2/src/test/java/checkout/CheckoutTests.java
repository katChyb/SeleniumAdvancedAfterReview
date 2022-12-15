package checkout;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CheckoutTests extends Pages {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    String currentDate = LocalDate.now().format(formatter);

    @RepeatedTest(10)
    @DisplayName("Checkout tests")
    public void checkoutTests() {

        topMenuPage.openLogInPage();
        logInPage.fillInEmailForAlredyExistingUser();
        logInPage.fillInPasswordForAlredyExistingUser();
        logInPage.signIn();
        topMenuPage.inputSearchProductByText(System.getProperty("BasketPopupTestWantedProduct"));
        topMenuPage.triggerSearchProduct();
        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
        Double productPrice = productDetailsPage.getPrice();
        productDetailsPage.addProductToCart();
        cartPopupPage.waitForPopupToBeVisible();
        cartPopupPage.clickOnProceedToCheckoutButton();
        cartDetailsPage.proceedToCheckout();
        String deliveryAddress = checkoutPage.getDeliveryAddress();

        checkoutPage.differentInvoiceAddress();
        checkoutPage.fillInInvoiceAddress();
        String invoiceAddress = checkoutPage.getInvoiceAddress();
        checkoutPage.openShippingMethodForm();
        checkoutPage.confirmDeliveryOption();
        checkoutPage.payByCheckMethod();
        checkoutPage.acceptTermsOfService();
        checkoutPage.placeOrder();
        String orderReference = checkoutPage.getOrderReference();
        topMenuPage.openMyAccountMenu();
        myAccountPage.openOrderHistoryDetails();
        orderHistoryPage.openDetailsByName(orderReference);

        softly.assertThat(orderDetailsPage.getDate().equals(currentDate));
        softly.assertThat(productPrice).isEqualTo(orderDetailsPage.getTotalPrice());
        softly.assertThat(orderDetailsPage.getDeliveryAddress()).isEqualTo(deliveryAddress);
        softly.assertThat(orderDetailsPage.getInvoiceAddress()).isEqualTo(invoiceAddress);
        softly.assertThat(orderDetailsPage.getPaymentStatusText()).isEqualTo(System.getProperty("paymentStatus"));

        softly.assertAll();

    }
}
