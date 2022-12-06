package basekt;

import base.Pages;
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
}
