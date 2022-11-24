package product_categories;

import base.Pages;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

public class ProductAndCategories extends Pages {

    private static Logger log = LoggerFactory.getLogger(ProductAndCategories.class);
    SoftAssertions softly = new SoftAssertions();

    @Test
  //  @RepeatedTest(10)
    @DisplayName("Categories Test")
    public void categoriesTest() {
        topMenuPage.getSizeOfMenuCategories();
        for (int i = 0; i < topMenuPage.getSizeOfMenuCategories(); i++) {
            topMenuPage.getMainCategoryName(i);
            topMenuPage.clickInMainCategory(i);
            softly.assertThat(topMenuPage.getMainCategoryName(i)).isEqualTo(topMenuPage.getCategoryTitle());
            softly.assertThat(productGridPage.getNumberOfFoundProductsLabel()).contains(productGridPage.getNumberProductsFromGrid());
        }
        softly.assertAll();
    }


}
