package checkout;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class CheckoutTests extends Pages {


    @RepeatedTest(10)
    @DisplayName("Checkout tests")
    public void checkoutTests() {

        topMenuPage.signIn();

    }
}
