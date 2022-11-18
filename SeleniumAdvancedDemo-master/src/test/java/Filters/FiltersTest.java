package Filters;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class FiltersTest extends Pages {

    @Test
    @RepeatedTest(5)
    @DisplayName("Filters test-slider")
    public void filtersTestSlider() throws InterruptedException {
        topMenuPage.clickInArtCategory();
        filterPage.moveSlider();

        for (int i = 0; i < productGridPage.getSizeOfProductList(); i++) {

            softly.assertThat(productGridPage.getPriceFromProductGrid(i)).isBetween((Double.valueOf(System.getProperty("minPrice"))),
                    Double.valueOf(System.getProperty("maxPrice")));
        }
        softly.assertAll();
    }
}
