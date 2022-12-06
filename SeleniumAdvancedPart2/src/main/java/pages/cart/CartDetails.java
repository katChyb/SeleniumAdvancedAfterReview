package pages.cart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class CartDetails extends BasePage {
    public CartDetails(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "_desktop_cart")
  public  WebElement cartBtn;


}
