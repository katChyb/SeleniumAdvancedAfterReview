package pages.product;

import configuration.models.Cart;
import configuration.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import pages.cart.CartPopupPage;

import java.util.Random;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    private static Logger log = LoggerFactory.getLogger(ProductDetailsPage.class);

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".current-price")
    private WebElement price;

    @FindBy(css = "h1[itemprop='name']")
    private WebElement productName;


    public void addProductToCart() {
        click(addToCartBtn);
    }

    public CartPopupPage addToCart(Cart cart) {

        Product product = new Product(getProductName(), getPrice(), getPrice()*getQuantity(), getQuantity());
        cart.addProductToCart(product);
        click(addToCartBtn);
        return new CartPopupPage(driver);
    }


    public void setQuantity(String quantity) {
        waitForElementToBeClickable(quantityInput);
        clearAndSendKeys(quantityInput, quantity);
    }

    public String setRandomQuantity() {
        Random random = new Random();
        int randd = random.nextInt(Integer.valueOf(System.getProperty("RepetitionForBasketCalculations"))) + 1;
        log.info("Random quantity from 1-5: " + randd);
        return String.valueOf(randd);
    }

    public double getPrice() {
        return getPrice(price);
    }

    public String getProductName(){
        return getTextOfWebElement(productName);
    }

    public Integer getQuantity(){
        return Integer.parseInt(getValue(quantityInput));
    }
}



