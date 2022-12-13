package pages.checout;

import configuration.models.AddressForTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import providers.AddressFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    AddressForTest address = AddressFactory.newAddress();

    @FindBy(id = "use_same_address")
    private WebElement useSameAddressCheckbox;

    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;

    @FindBy(css = "input[name='postcode']")
    private WebElement postalInput;

    @FindBy(css = "input[name='city']")
    private WebElement cityInput;

    public void unmarkUseSameAddress() {
        click(useSameAddressCheckbox);
    }

    public void fillInAddress() {
        sendKeys(addressInput, address.getAddress());
        sendKeys(postalInput, address.getZipCode());
        sendKeys(cityInput, address.getCity());

    }
}
