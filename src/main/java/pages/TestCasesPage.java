package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestCasesPage extends BasePage{
    private final By testCasesLabel = By.xpath("//h2/b[text()='Test Cases']");
    public TestCasesPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isTestCasesLabelDisplayed(){
        return isControlDisplayed(testCasesLabel);
    }
}
