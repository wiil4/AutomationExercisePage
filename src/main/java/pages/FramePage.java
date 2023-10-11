package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.xml.xpath.XPath;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class FramePage extends BasePage{

    private final List<By> adFramesIds = Arrays.asList(By.xpath("//iframe[@id='aswift_1']"), By.xpath("//iframe[@id='aswift_2']"), By.xpath("//iframe[@id='aswift_3']"));
    private final By dismissAdButton = By.id("dismiss-button");
    public FramePage(WebDriver driver) {
        super(driver);
    }
    public void tryCloseAdFrame(){
        try {
            for(By iFrameId : adFramesIds){
                WebElement iframe = driver.findElement(iFrameId);
                if(iframe.isDisplayed()){
                    closeAdIFrame(iFrameId, dismissAdButton);
                    break;
                }
            }
        }
        catch (Exception e){

        }
    }
}
