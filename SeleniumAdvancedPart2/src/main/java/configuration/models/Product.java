package configuration.models;

public class Product {

    public Product(String productName, Double productPrice, int quantity) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    private String productName;
    private Double productPrice;
    private int quantity;
}
