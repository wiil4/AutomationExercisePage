package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatePage extends BasePage{

    private final By accountCreatedLabel = By.xpath("//b[text()='Account Created!']");
    //private final By continueButton = By.xpath("//a[text()='Continue']");
    private final By continueButton = By.xpath("//a[contains(text(),'Continue')]");
    private final By adIframe = By.xpath("//iframe[@id='aswift_1']");
    private final By dismissAdButton = By.id("dismiss-button");
    public AccountCreatePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isAccountCreatedDisplayed(){
        return isControlDisplayed(accountCreatedLabel);
    }

    public void closeAdFrame(){
        closeAdIFrame(adIframe, dismissAdButton);
    }
    public void clickContinue(){
        clickOn(continueButton);
    }
}
