package base;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.interactions.Actions;
import pages.TopMenuPage;
import pages.cart.CartDetailsPage;
import pages.cart.CartPopupPage;
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
    public CartDetailsPage cartDetailsPage;

    public CartPopupPage cartPopupPage;
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
        cartDetailsPage = new CartDetailsPage(driver);
        cartPopupPage = new CartPopupPage(driver);
        softly = new SoftAssertions();
        action = new Actions(driver);
    }
}
