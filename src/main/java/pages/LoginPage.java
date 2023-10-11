package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By newUserLabel = By.xpath("//h2[text()='New User Signup!']");
    private final By nameInput = By.name("name");
    private final By emailSignUpInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");

    //LOGIN
    private final By loginLabel = By.xpath("//h2[text()='Login to your account']");
    private final By emailLoginInput = By.xpath("//input[@data-qa='login-email']");
    private final By passwordInput = By.name("password");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");

    private final By incorrectLoginLabel = By.xpath("//p[contains(text(),'incorrect!')]");
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isNewUserSignUpDisplayed(){
        return isControlDisplayed(newUserLabel);
    }

    public void signUpWithCredentials(String name, String email){
        setText(nameInput, name);
        setText(emailSignUpInput, email);
        clickOn(signUpButton);
    }

    public Boolean isLoginAccountDisplayed(){
        return isControlDisplayed(loginLabel);
    }

    public void loginWithCredentials(String email, String password){
        setText(emailLoginInput, email);
        setText(passwordInput, password);
        clickOn(loginButton);
    }
    public Boolean isErrorLoginDisplayed(){
        return isControlDisplayed(incorrectLoginLabel);
    }
}
