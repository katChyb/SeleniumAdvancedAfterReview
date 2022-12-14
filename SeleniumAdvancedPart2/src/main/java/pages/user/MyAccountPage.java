package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#history-link span")
    private WebElement orderHistoryButton;

    public void openOrderHistoryDetails(){
        click(orderHistoryButton);
    }
}
