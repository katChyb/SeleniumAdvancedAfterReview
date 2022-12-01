package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Locale;

public class TopMenuPage extends BasePage {

    public TopMenuPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".ui-autocomplete-input")
    private WebElement searchInputBox;

    @FindBy(css = "button .search")
    private WebElement searchBoxButton;
    @FindBy(css = "ul.ui-autocomplete")
    private WebElement dropdownList;
    @FindBy(css = "span.product")
    private List<WebElement> searchedProductDropdown;
    @FindBy(xpath = "//a[@data-depth=0]")
    private List<WebElement> topMenuCategories;

    @FindBy(id = "category-9")
    public WebElement artCategory;

    @FindBy(id = "category-6")
    public WebElement accessoriesCategory;

    @FindBy(id = "category-3")
    public WebElement clothesCategory;

    @FindBy(id = "category-4")
    public WebElement menCategory;

    @FindBy(id = "js-product-list-header")
    public WebElement productListHeader;

    @FindBy(id = "category-7")
    public WebElement stationeryCategory;


    public void inputSearchProductByText(String text) {
        sendKeys(searchInputBox, text);
    }

    public void triggerSearchProduct() {
        searchBoxButton.click();
    }


    public void waitForDropdownToLoad() {
        waitToBeVisible(dropdownList);
    }


    public List<String> getProductNameList() {
        return getNames(searchedProductDropdown);
    }


    public int getSizeOfMenuCategories() {
        return topMenuCategories.size();
    }

    public String getMainCategoryName(int i) {
        return topMenuCategories.get(i).getText();
    }

    public void clickInMainCategory(int i) {
        click(topMenuCategories.get(i));
    }

    public String getCategoryTitle() {
        String title = driver.getTitle().toUpperCase(Locale.ROOT);
        return title;
    }


    public void clickInArtCategory() {
        artCategory.click();
    }


    public TopMenuPage moveMouseToClothes() {
        mouseHover(clothesCategory);
        return this;

    }


    public TopMenuPage moveMouseToArt() {
        mouseHover(artCategory);
        return this;
    }

    public TopMenuPage moveMouseToAccessories() {
        mouseHover(accessoriesCategory);
        return this;
    }


    public void clickInMenCategory() {
        menCategory.click();
    }

    public void clickInStationeryCategory() {
        stationeryCategory.click();
    }

    public String getProductListHeader() {
        return productListHeader.getText();
    }


}
