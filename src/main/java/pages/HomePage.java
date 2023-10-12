package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    private final By loginButton = By.xpath("//a[contains(@href,'login')]");
    private final By loginInAsText = By.xpath("//b/preceding-sibling::text()");
    private final By usernameText = By.tagName("b");
    private final By deleteAccountButton = By.xpath("//a[text()=' Delete Account']");
    private final By logoutButton = By.xpath("//a[contains(@href,'logout')]");
    private final By contactUsButton = By.xpath("//a[contains(@href,'contact_us')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public void clickOnLogin(){
        clickOn(loginButton);
    }
    public String getLoggedInformation(){
        return getLabelText(usernameText);
    }
    public void clickOnDeleteAccount(){
        clickOn(deleteAccountButton);
    }
    public void clickOnLogout(){
        clickOn(logoutButton);
    }
    public void clickOnContactUs(){
        clickOn(contactUsButton);
    }
}
