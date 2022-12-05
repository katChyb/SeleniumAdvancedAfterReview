package base;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import pages.TopMenuPage;
import pages.cart.CartDetails;
import pages.cart.CartPopup;
import pages.user.MyAccountPage;
import pages.user.RegistrationPage;
import pages.user.SignInPage;
import pages.product.FilterPage;
import pages.product.ProductDetailsPage;
import pages.product.ProductGridPage;

public class Pages extends BaseTest {

    public ProductDetailsPage productDetailsPage;
    public ProductGridPage productGridPage;
    public TopMenuPage topMenuPage;
    public RegistrationPage registrationPage;
    public SignInPage signInPage;
    public MyAccountPage myAccountPage;
    public FilterPage filterPage;
    public CartDetails cartDetails;

    public CartPopup cartPopup;
    public SoftAssertions softly;
    public Actions action;


    @BeforeEach
    public void setupPages() {
        productDetailsPage = new ProductDetailsPage(driver);
        productGridPage = new ProductGridPage(driver);
        topMenuPage = new TopMenuPage(driver);
        registrationPage = new RegistrationPage(driver);
        signInPage = new SignInPage(driver);
        myAccountPage = new MyAccountPage(driver);
        filterPage = new FilterPage(driver);
        cartDetails = new CartDetails(driver);
        cartPopup = new CartPopup(driver);
        softly = new SoftAssertions();
        action = new Actions(driver);
    }
}
