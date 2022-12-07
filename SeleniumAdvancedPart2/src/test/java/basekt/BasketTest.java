package basekt;

import base.Pages;
import configuration.models.Cart;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;

public class BasketTest extends Pages {


    @RepeatedTest(10)
    @Tag("Basket Popup Test")
    public void basketPopupTest() {
        topMenuPage.clickInArtCategory();
        productGridPage.openSelectedProduct(System.getProperty("BasketPopupTestWantedProduct"));
        productDetailsPage.setQuantity(System.getProperty("BasketPopupTestQuantity"));
        productDetailsPage.addProductToCart();
        Double productPrice = productDetailsPage.getPrice();
        cartPopupPage.waitForPopupToBeVisible();

        softly.assertThat(cartPopupPage.getProductName()).isEqualTo(System.getProperty("BasketPopupTestWantedProduct"));
        softly.assertThat(cartPopupPage.getCartProductCount()).contains(System.getProperty("BasketPopupTestQuantity"));
        softly.assertThat(cartPopupPage.getProductPrice()).isEqualTo(productPrice);
        softly.assertThat(cartPopupPage.getTotalPrice()).isEqualTo((productPrice) *
                Double.parseDouble(System.getProperty("BasketPopupTestQuantity")) +
                Double.parseDouble(System.getProperty("shippingPrice"))
        );
        softly.assertAll();

    }


    @RepeatedTest(1)
    @Tag("Basket calculations test")
    public void basketCalculationsTest() {

        Cart expectedCart = new Cart();

        for (int i = 0; i < Integer.valueOf(System.getProperty("RepetitionForBasketCalculations")); i++) {
            String productName = productGridPage.getRandomProductNameFromGrid();
            topMenuPage.inputSearchProductByText(productName);
            topMenuPage.triggerSearchProduct();
            productGridPage.openSelectedProduct(productName);
            productDetailsPage.setRandomQuantity();
            productDetailsPage.addProductToCart();
            cartPopupPage.clickOnProceedToCheckoutButton();
            topMenuPage.goToMainPage();
        }
        topMenuPage.goToCart();

        Cart actualCart = cartDetailsPage.toCartDetails();


    }
}
