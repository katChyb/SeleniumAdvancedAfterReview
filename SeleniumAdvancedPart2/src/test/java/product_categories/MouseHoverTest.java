package product_categories;

import base.Pages;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MouseHoverTest extends Pages {


    @Test
    @DisplayName( "Hover Clothes Category Test")
    public void hoverClothesCategoryTest() {
        topMenuPage.moveMouseToClothes();
        topMenuPage.clickInMenCategory();
        String productListHeader = topMenuPage.getProductListHeader();
        assertThat(productListHeader).contains(System.getProperty("menCategoryText"));
    }

    @Test
    @DisplayName("Hover Accessories Category Test")
    public void hoverAccessoriesCategoryTest() {
        topMenuPage.moveMouseToAccessories();
        topMenuPage.clickInStationeryCategory();
        String productListHeader = topMenuPage.getProductListHeader();
        assertThat(productListHeader).contains(System.getProperty("stationeryCategoryText"));
    }

    @Test
    @DisplayName("Hover Art Category Test")
    public void hoverArtCategoryTest() {
        topMenuPage.moveMouseToArt();
        topMenuPage.click(topMenuPage.artCategory);
        String productListHeader = topMenuPage.getProductListHeader();
        assertThat(productListHeader).contains(System.getProperty("artCategoryText"));

    }
}
