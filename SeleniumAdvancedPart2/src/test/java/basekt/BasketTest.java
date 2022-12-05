package basekt;

import base.Pages;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.cart.CartPopup;

public class BasketTest extends Pages {
    private static Logger log = LoggerFactory.getLogger(BasketTest.class);


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
        softly.assertThat(cartPopup.getProductPrice()).isEqualTo(productPrice);
        softly.assertThat(cartPopup.getTotalPrice()).isEqualTo((productPrice) *
                Double.parseDouble(System.getProperty("BasketPopupTestQuantity")) +
                Double.parseDouble(System.getProperty("shippingPrice"))
        );
        log.info("Total price is: " + CartPopup.getTotalPrice());
        softly.assertAll();

    }
}
