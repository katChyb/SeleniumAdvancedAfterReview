package pages.product;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class FilterPage extends BasePage {
    public FilterPage(WebDriver driver) {
        super(driver);

    }

    private static Logger log = LoggerFactory.getLogger(FilterPage.class);
    @FindBy(css = ".ui-slider-horizontal")
    public WebElement priceSliderArt;

    @FindBy(css = "a.ui-slider-handle:nth-child(2)")
    public WebElement leftSlider;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    public WebElement rightSlider;

    @FindBy(css = ".spinner")
    public WebElement spinner;

    @FindBy(css = "[data-slider-label] p")
    public WebElement sliderPriceRangeLabel;


    public double getMinMaxPriceFromSlider(WebElement element, int i) {
        return Double.parseDouble(element.getText().replace(System.getProperty("currencySymbolToReplace"), "").split("-")[i]);
    }

    public double getMinimumPriceRange() {
        return getMinMaxPriceFromSlider(sliderPriceRangeLabel, Integer.parseInt(System.getProperty("sliderStartingValue")));
    }

    public double getMaximumPriceRange() {
        return getMinMaxPriceFromSlider(sliderPriceRangeLabel, Integer.parseInt(System.getProperty("sliderEndValue")));

    }

    public void moveSlider(WebElement element, double price, double minMaxPrice) {

        waitToBeVisible(priceSliderArt);

        while (price != minMaxPrice) {
            if (price > minMaxPrice) {
                actions.clickAndHold(element).sendKeys(Keys.ARROW_RIGHT).perform();
                minMaxPrice++;
            } else {
                actions.clickAndHold(element).sendKeys(Keys.ARROW_LEFT).perform();
                minMaxPrice--;
            }
        }

        waitUntilDisappear(spinner);
    }


    public void moveLeftSliderToGivenPrice() {
        moveSlider(leftSlider, Double.parseDouble(System.getProperty("minPrice")), getMinimumPriceRange());
    }

    public void moveRightSliderToGivenPrice() {
        moveSlider(rightSlider, Double.parseDouble(System.getProperty("maxPrice")), getMaximumPriceRange());
    }

}
