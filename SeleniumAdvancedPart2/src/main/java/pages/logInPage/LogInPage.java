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

    User registeredUser = UserFactory.getAlreadyRegisterUser();


    @FindBy(css = "div.col-md-6 input[name='email']")
    private WebElement emailInput;

    @FindBy(css = "div.col-md-6 input[name='password']")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement signInButton;


    public void fillInEmail(){
        sendKeys(emailInput, registeredUser.getEmail());
    }
    public void fillInPassword(){
        sendKeys(passwordInput, registeredUser.getPassword());
    }
    public void signIn(){
        click(signInButton);
    }

}
