package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DeleteAccountPage extends BasePage{

    private final By accountDeletedlabel = By.xpath("//b[text()='Account Deleted!']");
    private final By continueButton = By.xpath("//a[text()='Continue']");
    public DeleteAccountPage(WebDriver driver) {
        super(driver);
    }
    public Boolean isAccountDeletedDisplayed(){
        return isControlDisplayed(accountDeletedlabel);
    }
    public void clickContinue(){
        clickOn(continueButton);
    }
}
