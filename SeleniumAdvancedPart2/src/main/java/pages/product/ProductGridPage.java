package pages.product;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;
import java.util.Random;

public class ProductGridPage extends BasePage {
    public ProductGridPage(WebDriver driver) {
        super(driver);
    }

    private static Logger log = LoggerFactory.getLogger(ProductGridPage.class);
    @FindBy(css = ".product-title")
    private List<WebElement> productGrid;

    public String getRandomProductNameFromGrid() {
        int gridListSize = productGrid.size();
        return productGrid.get(new Random().nextInt(gridListSize)).getText();

    }

    public String getNumberProductsFromGrid() {
        log.info("number products from grid: " + productGrid.size());
        return String.valueOf(productGrid.size());
    }


    public int getSizeOfProductList() {
        return productGrid.size();
    }

    @FindBy(css = ".total-products")
    private WebElement numberOfProductsFoundLabel;

    public String getNumberOfFoundProductsLabel() {
        log.info("number products from label: " + numberOfProductsFoundLabel.getText());
        return numberOfProductsFoundLabel.getText();
    }

    @FindBy(css = "span.price")
    private List <WebElement> listOfProductPriceFromGrid;


    public Double getProductPrice(int i){
        return getPrice(listOfProductPriceFromGrid.get(i));
    }


}
