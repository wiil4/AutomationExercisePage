package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
    protected final WebDriver driver;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    protected void clickOn(By locator){
        driver.findElement(locator).click();
    }

    protected void setText(By locator, String keys){
        driver.findElement(locator).sendKeys(keys);
    }
    protected void clearInputText(By locator){
        driver.findElement(locator).clear();
    }

    protected String getLabelText(By locator){
        return driver.findElement(locator).getText();
    }

    protected Boolean isControlDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }

    protected void setDropdownByValue(By locator, String value){
        Select drpControl = new Select(driver.findElement(locator));
        drpControl.selectByValue(value);
    }

    protected void switchToFrame(By locator){
        driver.switchTo().frame(driver.findElement(locator));
    }

    protected void switchToMainContent(){
        driver.switchTo().defaultContent();
    }

    protected void acceptAlert(){
        driver.switchTo().alert().accept();
    }
}
