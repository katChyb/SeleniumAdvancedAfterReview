package filters;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class FiltersTest extends Pages {

    @Test
    @RepeatedTest(10)
    @DisplayName("Filters test-slider")
    public void filtersTestSlider() throws InterruptedException {
        topMenuPage.clickInArtCategory();
        filterPage.moveLeftSlider();
        filterPage.moveRightSlider();

        for (int i = 0; i < productGridPage.getSizeOfProductList(); i++) {

            softly.assertThat(productGridPage.getPriceFromProductGrid(i)).isBetween((Double.valueOf(System.getProperty("minPrice"))),
                    Double.valueOf(System.getProperty("maxPrice")));
        }
        softly.assertAll();
    }
}
