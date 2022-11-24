package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.List;
import java.util.Optional;

public class SearchProductResultPage extends BasePage {
    public SearchProductResultPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "js-product-list")
    private List<WebElement> searchResultProductGrid;


    public String getNumberOfProductsFound() {
        int productsFoundSize = searchResultProductGrid.size();
        return Integer.toString(productsFoundSize);
    }

    public String getNameOfFoundProduct() {
        String nameOfProduct = searchResultProductGrid.get(0).findElement(new By.ByCssSelector(".product-title")).getText();
        return nameOfProduct;
    }
}
