package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class ProductDetailsPage extends BasePage {
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".current-price")
    private WebElement price;


    public void addProductToCart() {
        click(addToCartBtn);
    }

    public void setQuantity(String quantity) {
         waitForElementToBeClickable(quantityInput);
        clearAndSendKeys(quantityInput, quantity);
    }

    public double getPrice() {
        return getPrice(price);
    }
}
