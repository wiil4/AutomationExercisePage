package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.xpath.XPath;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FramePage extends BasePage{

    private final List<By> mainAdFrames = new ArrayList<>(Arrays.asList(
            By.xpath("//iframe[@id='aswift_0']"),
            By.xpath("//iframe[@id='aswift_1']"),
            By.xpath("//iframe[@id='aswift_2']"),
            By.xpath("//iframe[@id='aswift_3']")
    ));
    private final By adFrame = By.xpath("//iframe[@id='ad_iframe']");
    private final By dismissAdButton = By.xpath("//div[@id='dismiss-button']");
    public FramePage(WebDriver driver) {
        super(driver);
    }
    public void closeAdFrame(){
        for(By mainAdFrame : mainAdFrames){
            if(isControlDisplayed(mainAdFrame)){
                switchToFrame(mainAdFrame);
                try {
                    clickOn(dismissAdButton);
                }
                catch (Exception e){
                    switchToFrame(adFrame);
                    clickOn(dismissAdButton);
                }
                switchToMainContent();
                break;
            }
        }
    }
}
