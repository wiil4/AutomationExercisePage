package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private final By newUserLabel = By.xpath("//h2[text()='New User Signup!']");
    private final By nameInput = By.name("name");
    private final By emailSignUpInput = By.xpath("//input[@data-qa='signup-email']");
    private final By signUpButton = By.xpath("//button[@data-qa='signup-button']");
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
}
