package pages.cart;

import configuration.models.Cart;
import configuration.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;

public class CartDetailsPage extends BasePage {
    public CartDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id= "_desktop_cart")
  public  WebElement cartBtn;

    @FindBy(css = ".cart-item")
    private List<WebElement> cartProductsList;



    public Cart toCartDetails(){
        Cart cart =new Cart();

        for (WebElement cartProducts: cartProductsList){
            cart.addProductToCart(new Product(cartProducts));
        }
            return cart;
    }

//TODO

    public void checkIfProductIsInCart(){
      {
            String nameOfProduct = cartProductsList.get(0).findElement(new By.ByCssSelector(".product-title")).getText();
            log.info("name of found product " + nameOfProduct);
            return nameOfProduct;
        }
    }




}
