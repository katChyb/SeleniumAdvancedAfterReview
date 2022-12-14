package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class CartPopupPage extends BasePage {
    public CartPopupPage(WebDriver driver) {
        super(driver);
    }
    private static Logger log = LoggerFactory.getLogger(CartPopupPage.class);

    @FindBy(css = ".product-name")
    private WebElement productName;
    @FindBy(css = "p.product-price")
    private WebElement productPrice;
    @FindBy(css = "p.product-total .value")
    private static WebElement totalPrice;
    @FindBy(css = "p.cart-products-count")
    private WebElement summaryText;
    @FindBy(css = "a.btn")
    private WebElement proceedToCheckoutButton;
    @FindBy(id= "myModalLabel")
    private WebElement popupLabel;

    @FindBy(css= ".cart-products-count")
    private WebElement cartProductCount;


    public String getProductName() {
        return getTextOfWebElement(productName);
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public static Double getTotalPrice() {
        log.info("total price is: " + getPrice(totalPrice));
        return getPrice(totalPrice);
    }

    public String getSummaryText() {
        return getTextOfWebElement(summaryText);
    }


    public void waitForPopupToBeVisible(){
        waitToBeVisible(popupLabel);
    }

    public String getCartProductCount(){
       log.info("cart product count: "+ cartProductCount.getText());
        return cartProductCount.getText();
    }

    public void clickOnProceedToCheckoutButton(){
        waitForElementToBeClickable(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
    }

}
