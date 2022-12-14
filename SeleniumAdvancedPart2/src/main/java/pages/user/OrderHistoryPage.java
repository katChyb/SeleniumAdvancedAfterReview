package pages.user;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

import java.util.List;

public class OrderHistoryPage extends BasePage {
    public OrderHistoryPage(WebDriver driver) {
        super(driver);
    }

    private static Logger log = LoggerFactory.getLogger(OrderHistoryPage.class);

    @FindBy(css = "tbody tr")
    private List<WebElement> orders;

    public void openDetailsByName(String orderNumber){
        for (WebElement order : orders) {
            if(order.findElement(By.cssSelector("th")).getText().equals(orderNumber)){
                click(order.findElement(By.xpath("td[@class='text-sm-center order-actions']/a[1]")));
            }  //css  td.text-sm-center.order-actions
            break;
        }
    }
}
