package pages.logInPage;

import configuration.models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;
import providers.UserFactory;

public class LogInPage extends BasePage {
    public LogInPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "div.col-md-6 input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "div.col-md-6 input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement signInButton;


    public void fillInEmailForAlredyExistingUser(){
        sendKeys(emailInput, System.getProperty("email"));
    }
    public void fillInPasswordForAlredyExistingUser(){
        sendKeys(passwordInput, System.getProperty("password"));
    }
    public void signIn(){
        click(signInButton);
    }

}
