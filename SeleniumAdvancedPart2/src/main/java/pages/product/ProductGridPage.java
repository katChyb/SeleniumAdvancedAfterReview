package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
    private List<WebElement> productNamesFromGrid;

    @FindBy(css = ".total-products")
    private WebElement numberOfProductsFoundLabel;

    @FindBy(css = "span.price")
    private List<WebElement> listOfProductPriceFromGrid;

    @FindBy(id = "js-product-list")
    private List<WebElement> searchResultProductGrid;


    public String getRandomProductNameFromGrid() {

        int gridListSize = productNamesFromGrid.size();
        return productNamesFromGrid.get(new Random().nextInt(gridListSize)).getText();
    }



    public String getNumberProductsFromGrid() {
        log.info("number products from grid: " + productNamesFromGrid.size());
        return String.valueOf(productNamesFromGrid.size());
    }

    public int getSizeOfProductList() {
        return productNamesFromGrid.size();
    }


    public String getNumberOfFoundProductsLabel() {
        log.info("number products from label: " + numberOfProductsFoundLabel.getText());
        return numberOfProductsFoundLabel.getText();
    }

    public Double getProductPrice(int i) {
        return getPrice(listOfProductPriceFromGrid.get(i));
    }


    public String getNameOfFoundProduct() {
        String nameOfProduct = searchResultProductGrid.get(0).findElement(new By.ByCssSelector(".product-title")).getText();
        log.info("name of found product " + nameOfProduct);
        return nameOfProduct;
    }

    public void openSelectedProduct(String name) {
        clickProductByName(productNamesFromGrid, name);
    }

    public void clickProductByName(List<WebElement> list, String productName) {
        for (WebElement productNameOnList : list) {
            String name = productNameOnList.getText();
            if (name.equals(productName)) {
                click(productNameOnList);
                break;
            }
        }
    }
}
