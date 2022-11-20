package configuration.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.BasePage;

public class WebListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WebListener.class);
    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        logger.info("*************  Eventlistner before click: " +element.getText());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("*************  Eventlistner after click: " +element.getText());
    }
}
