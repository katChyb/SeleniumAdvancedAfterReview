package filters;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;


public class FiltersTest extends Pages {

    @Test
 //   @RepeatedTest(10)
    @DisplayName("Filters test-slider")
    public void filtersTestSlider() {
        topMenuPage.clickInArtCategory();
        filterPage.moveLeftSliderToGivenPrice();
        filterPage.moveRightSliderToGivenPrice();

        for (int i = 0; i < productGridPage.getSizeOfProductList(); i++) {
            softly.assertThat(productGridPage.getProductPrice(i)).isBetween(
                    (Double.valueOf(System.getProperty("minPrice"))),
                    Double.valueOf(System.getProperty("maxPrice")));
        }
        softly.assertAll();
    }
}
