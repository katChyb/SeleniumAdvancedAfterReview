package configuration.models;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

@Data
public class Product {

    public String productName;
    private Double productPrice;
    private Double totalPrice;
    private int quantity;

    public Product(String productName, Double productPrice, Double totalPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public Product(WebElement cartItem) {
        this.productName = cartItem.findElement(By.cssSelector(".product-line-info a")).getText();
        this.productPrice = Double.parseDouble(cartItem.findElement(By.cssSelector(".current-price")).getText().
                replace(System.getProperty("currencySymbolToReplace"),""));
        this.quantity = Integer.parseInt(cartItem.findElement(By.cssSelector(".js-cart-line-product-quantity")).
                getAttribute("value"));
        this.totalPrice = Double.parseDouble(cartItem.findElement(By.cssSelector(".product-price strong")).getText().
                replace(System.getProperty("currency"),""));

    }

}
