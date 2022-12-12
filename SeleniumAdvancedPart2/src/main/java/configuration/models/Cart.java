package configuration.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.product.ProductDetailsPage;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Cart {
    private static Logger log = LoggerFactory.getLogger(Cart.class);

    private List<Product> products = new ArrayList<>();
    private BigDecimal totalOrderCost = new BigDecimal(0.00);


    public Cart(List<Product> products, BigDecimal totalOrderCost) {
        this.products = products;
        this.totalOrderCost = totalOrderCost;
    }


    public void addProductToCart(Product product) {
        if (checkIfProductIsInCart(products, product.getProductName())) {
            increaseQuantity(product);
            recalculateTotalPrice(product);
        } else {
            products.add(product);
        }
        recalculateTotalOrderCost(product.getProductPrice(), product.getQuantity());
    }


    private boolean checkIfProductIsInCart(List<Product> productList, String name) {
        for (Product products : productList) {
            if (productList.stream().anyMatch(product -> product.getProductName().equals(name))) ;
            return true;
        }
        return false;
    }

    private void increaseQuantity(Product product) {
        Product tempProduct = product;
        int quantity = tempProduct.getQuantity();
        tempProduct.setQuantity(quantity + tempProduct.getQuantity());
    }

    private void recalculateTotalPrice(Product product) {
        Product tempProduct = product;
        tempProduct.setTotalPrice(tempProduct.getProductPrice() * tempProduct.getQuantity());
    }


    private void recalculateTotalOrderCost(Double productPrice, int productQuantity) {

        totalOrderCost = totalOrderCost.add(new BigDecimal(productPrice * productQuantity));
        totalOrderCost = totalOrderCost.setScale(2, RoundingMode.HALF_UP);
        log.info("totalOrderCost: "+ totalOrderCost);
    }
}
