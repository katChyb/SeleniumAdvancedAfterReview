package configuration.models;

import java.math.BigDecimal;
import java.util.List;

public class Cart {


    private List<Product> products;
    private BigDecimal totalOrderCost;

    public Cart(List<Product> products, BigDecimal totalOrderCost) {
        this.products = products;
        this.totalOrderCost = totalOrderCost;
    }

    public Cart() {

    }


    public void addProductToCart(Product product){

// TODO
        if (checkIfProductIsInCart(products, product.getProductName())) {
            increaseQuantity(product);
            recalculateTotalPrice(product);
        } else {
            products.add(product);
        }
        recalculateTotalOrderCost(product.getProductPrice(), product.getQuantity());

    }

    public boolean checkIfProductIsInCart(List<Product> productList, String name){
        return productList.stream().anyMatch(product -> product.getProductName().contains(name));
    }
}
