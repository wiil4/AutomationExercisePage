package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdFramePage extends BasePage{
    private final By baseFrame = By.tagName("iframe");
    private final By adFrame = By.id("ad_iframe");
    private final By dismissAdButton = By.id("dismiss-button");
    public AdFramePage(WebDriver driver) {
        super(driver);
    }
    public void closeAdFrame(){
        List<WebElement> iframes = getFrames(baseFrame);
        for (WebElement frame: iframes) {
            if(frame.isDisplayed()){
                switchToFrame(frame);
                try {
                    clickOn(dismissAdButton);
                }
                catch (WebDriverException e){
                    switchToFrame(adFrame);
                    clickOn(dismissAdButton);
                }
                finally {
                    switchToMainContent();
                }
            }
        }
    }
}
