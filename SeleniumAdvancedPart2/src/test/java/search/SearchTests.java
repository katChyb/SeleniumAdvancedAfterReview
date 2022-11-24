package search;

import base.Pages;
import org.assertj.core.api.Assert;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.containsString;


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
        String numberOfProductsFound = searchProductResultPage.getNumberOfProductsFound();
        System.out.println("numberOfProductsFound " + numberOfProductsFound);
        softly.assertThat(numberOfProductsFound).isEqualTo(System.getProperty("amountOfExpectedSearchResultsList"));
        String nameOfFoundProduct = searchProductResultPage.getNameOfFoundProduct();
        System.out.println("nameOfFoundProduct " + nameOfFoundProduct);
        softly.assertThat(nameOfFoundProduct).isEqualTo(productName);
        softly.assertAll();

    }

    @Test
    @RepeatedTest(10)
    @DisplayName("Dropdown Search Test")
    public void dropdownSearchTest() {
        topMenuPage.inputSearchProductByText(System.getProperty("wantedProduct"));
        topMenuPage.waitForDropdownToLoad();
        boolean isProductOnDropdown = topMenuPage.isDropdownContainingText(System.getProperty("wantedProduct"));
        assertThat(isProductOnDropdown).isEqualTo(true);

    }

}
