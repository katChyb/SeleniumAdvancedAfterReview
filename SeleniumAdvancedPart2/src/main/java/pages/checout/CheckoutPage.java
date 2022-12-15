package pages.checout;

import configuration.models.AddressForTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;
import providers.AddressFactory;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    AddressForTest address = AddressFactory.newAddress();

    private static Logger log = LoggerFactory.getLogger(CheckoutPage.class);

    @FindBy(id = "use_same_address")
    private WebElement useSameAddressCheckbox;

    @FindBy(css = ".js-country")
    private WebElement countryDropdown;

    @FindBy(css = "input[name='address1']")
    private WebElement addressInput;

    @FindBy(css = "input[name='postcode']")
    private WebElement postalInput;

    @FindBy(css = "input[name='city']")
    private WebElement cityInput;

    @FindBy(css = "button[name='confirm-addresses']")
    private WebElement confirmAddressBtn;

    @FindBy(css = "#checkout-addresses-step")
    private WebElement addressTab;

    @FindBy(css = "button[name='confirmDeliveryOption']")
    private WebElement confirmDeliveryOptionBtn;

    @FindBy(css = "#payment-option-1")
    private WebElement payByCheckRadioButton;

    @FindBy(css = ".custom-checkbox")
    private WebElement approveTermsCheckbox;

    @FindBy(css = "#payment-confirmation button")
    private WebElement placeOrderButton;


    @FindBy(css = "#delivery-addresses .selected .address")
    private WebElement selectedDeliveryAddress;

    @FindBy(css = "a[data-link-action='different-invoice-address']")
    private WebElement linkDifferentAddress;

    @FindBy(css = "p:nth-child(8) > a")
    private WebElement addNewInvoiceAddress;

    @FindBy(css = "#invoice-addresses .selected .address")
    private WebElement invoiceAddress;


    @FindBy(css = "#payment-confirmation button")
    private WebElement placeOrderBtn;

    @FindBy(css = "#order-details > ul > li:nth-child(1)")
    private WebElement orderReference;

    public void unmarkUseSameAddress() {
        click(useSameAddressCheckbox);
    }

    public void fillInDeliveryAddress() {
        selectPoland();
        unmarkUseSameAddress();

        sendKeys(addressInput, address.getAddress());
        sendKeys(postalInput, address.getZipCode());
        sendKeys(cityInput, address.getCity());

        click(confirmAddressBtn);
    }


    public void fillInInvoiceAddress() {
        click(addNewInvoiceAddress);

        sendKeys(addressInput, address.getAddress());
        sendKeys(postalInput, address.getZipCode());
        sendKeys(cityInput, address.getCity());

        click(confirmAddressBtn);

        click(addressTab);
    }


    public void openShippingMethodForm(){
        waitForElementToBeClickable(confirmAddressBtn);
        click(confirmAddressBtn);

    }
    public String getDeliveryAddress() {
        return getTextOfWebElement(selectedDeliveryAddress);
    }

    public void selectPoland() {
        Select country = new Select(countryDropdown);
        country.selectByIndex(1);
    }


    public void confirmDeliveryOption() {
        click(confirmDeliveryOptionBtn);
    }


    public void differentInvoiceAddress() {
        click(linkDifferentAddress);
    }

    public String getInvoiceAddress() {
        log.info("Invoice Address:" + getTextOfWebElement(invoiceAddress));
        waitToBeVisible(invoiceAddress);
        return getTextOfWebElement(invoiceAddress);
    }

    public void payByCheckMethod() {
        click(payByCheckRadioButton);

    }

    public void acceptTermsOfService() {
        click(approveTermsCheckbox);
    }

    public void placeOrder() {
        click(placeOrderBtn);
    }

    public String getOrderReference() {
        String reference = getTextOfWebElement(orderReference).replace("Order reference: ", "");
        log.info("reference: " + reference);
        return reference;
    }
}
