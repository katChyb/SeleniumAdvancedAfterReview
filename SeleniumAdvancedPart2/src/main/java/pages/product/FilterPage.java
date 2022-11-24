package pages.product;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

import static org.openqa.selenium.By.cssSelector;

public class FilterPage extends BasePage {
    public FilterPage(WebDriver driver) {
        super(driver);

    }


    @FindBy(css = ".ui-slider-horizontal")
    public WebElement priceSliderArt;

    @FindBy(css = "a.ui-slider-handle:nth-child(2)")
    public WebElement leftSlider;

    @FindBy(css = "a.ui-slider-handle:nth-child(3)")
    public WebElement rightSlider;


    public void moveSlider()  {

        moveRightSlider();
        moveLeftSlider();

    }

    public void moveLeftSlider() {

        waitToBeVisible(priceSliderArt);

        Dimension sliderSize = priceSliderArt.getSize();
        int sliderWidth = sliderSize.getWidth();


        double A = Integer.parseInt(System.getProperty("minPrice"));
        double B = Integer.parseInt(System.getProperty("sliderStartingValue"));
        double C = Integer.parseInt(System.getProperty("percentFactor"));
        double increment = ((A - B) / C) * 10;

        int offsetPositionLeftSlider = (int) (((sliderWidth * Double.parseDouble(String.valueOf(increment))) / 10));


        Actions builder = new Actions(driver);
        builder.clickAndHold(leftSlider);
        builder.moveByOffset(offsetPositionLeftSlider, 0).perform();
        builder.release().perform();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(cssSelector(".spinner"))));
    }


    public void moveRightSlider()   {

        waitToBeVisible(priceSliderArt);

        Dimension sliderSize = priceSliderArt.getSize();
        int sliderWidth = sliderSize.getWidth();


        double A = Integer.parseInt(System.getProperty("maxPrice"));
        double B = Integer.parseInt(System.getProperty("sliderEndValue"));
        double C = Integer.parseInt(System.getProperty("percentFactor"));
        double decrement = -((B - A) / C) * 10;

        int offsetPositionRightSlider = (int) (((sliderWidth * Double.parseDouble(String.valueOf(decrement))) / 10));


        Actions builder = new Actions(driver);
        builder.clickAndHold(rightSlider);
        builder.moveByOffset(offsetPositionRightSlider, 0).perform();
        builder.release().perform();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(cssSelector(".spinner"))));

    }


}
