package basekt;

import base.Pages;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class BasketTest extends Pages {


    @RepeatedTest(10)
    @Tag("Basket Popup Test")
    public void basketPopupTest() {
        topMenuPage.clickInArtCategory();
        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
        productDetailsPage.setQuantity(System.getProperty("BasketPopupTestQuantity"));
        productDetailsPage.addProductToCart();
        Double productPrice = productDetailsPage.getPrice();
        cartPopup.waitForPopupToBeVisible();

        softly.assertThat(cartPopup.getProductName()).isEqualTo(System.getProperty("BasketPopupTestWantedProduct"));
        softly.assertThat(cartPopup.getCartProductCount()).contains(System.getProperty("BasketPopupTestQuantity"));
        softly.assertThat(cartPopup.getProductPrice()).isEqualTo(productPrice);
        softly.assertThat(cartPopup.getTotalPrice()).isEqualTo((productPrice) *
                Double.parseDouble(System.getProperty("BasketPopupTestQuantity")) +
                Double.parseDouble(System.getProperty("shippingPrice"))
        );
        softly.assertAll();

    }


    @RepeatedTest(1)
    @Tag("Basket calculations test")
    public void basketCalculationsTest() {

        for (int i = 0; i < Integer.valueOf(System.getProperty("RepetitionForBasketCalculations")); i++) {
            String productName = productGridPage.getRandomProductNameFromGrid();
            topMenuPage.inputSearchProductByText(productName);
            topMenuPage.triggerSearchProduct();
            productGridPage.openSelectedProduct(productName);
            productDetailsPage.setRandomQuantity();
            productDetailsPage.addProductToCart();
            cartPopup.clickOnProceedToCheckoutButton();
            topMenuPage.goToMainPage();
        }
        topMenuPage.goToCart();


    }
}
