package search;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class SearchTests extends Pages {

    private static Logger log = LoggerFactory.getLogger(SearchTests.class);

    @Test
    @RepeatedTest(10)
    @DisplayName("Random Product Search Test")
    public void RandomProductSearchTest() {

        String productName = productGridPage.getRandomProductNameFromGrid();
        System.out.println("productName " + productName);
        topMenuPage.inputSearchProductByText(productName);
        topMenuPage.triggerSearchProduct();
        String numberOfProductsFound = productGridPage.getNumberProductsFromGrid();
        softly.assertThat(numberOfProductsFound).isEqualTo(System.getProperty("amountOfExpectedSearchResultsList"));
        String nameOfFoundProduct = productGridPage.getNameOfFoundProduct();
        softly.assertThat(nameOfFoundProduct).isEqualTo(productName);
        softly.assertAll();

    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Dropdown Search Test")
    public void dropdownSearchTest() {
        topMenuPage.inputSearchProductByText(System.getProperty("wantedProduct"));
        topMenuPage.waitForDropdownToLoad();
        for (String productName : topMenuPage.getProductNameList()) {
            softly.assertThat(productName).contains(System.getProperty("wantedProduct"));
        }
        softly.assertAll();

    }

}
