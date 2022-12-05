package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CartPopup extends BasePage {
    public CartPopup(WebDriver driver) {
        super(driver);
    }


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


    public String getProductName() {
        return getTextOfWebElement(productName);
    }

    public Double getProductPrice() {
        return getPrice(productPrice);
    }

    public static Double getTotalPrice() {
        return getPrice(totalPrice);
    }

    public String getSummaryText() {
        return getTextOfWebElement(summaryText);
    }


    public void waitForPopupToBeVisible(){
        waitToBeVisible(popupLabel);
    }

    public void clickOnProceedToCheckoutButton(){
        waitForElementToBeClickable(proceedToCheckoutButton);
        click(proceedToCheckoutButton);
    }

}
