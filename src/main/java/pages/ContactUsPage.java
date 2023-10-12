package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactUsPage extends BasePage{
    private final By getinTouchLabel = By.xpath("//h2[text()='Get In Touch']");
    private final By nameInput = By.name("name");
    private final By emailInput = By.name("email");
    private final By subjectInput = By.name("subject");
    private final By messageInput = By.name("message");
    private final By fileUploadInput = By.name("upload_file");
    private final By submitButton = By.name("submit");
    private final By detailsSubmitedLabel = By.xpath("//div[@class='contact-form']/div[contains(text(),'Success!')]");
    //private final By homeButton = By.xpath("//a[@class='btn btn-success']");
    private final By homeButton = By.xpath("//div[@id='form-section']/a");

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    public Boolean isGetInTouchDisplayed(){
        return isControlDisplayed(getinTouchLabel);
    }

    public void submitContact(String name, String email, String subject, String message){
        setText(nameInput, name);
        setText(emailInput, email);
        setText(subjectInput, subject);
        setText(messageInput, message);
        clickOn(submitButton);
        acceptAlert();
    }
    public void uploadFile(String filePath){
        String fullPath = System.getProperty("user.dir")+"/"+filePath;
        setText(fileUploadInput, fullPath);
    }

    public Boolean isSubmitionSuccessDisplayed(){
        return isControlDisplayed(detailsSubmitedLabel);
    }
    public void returnHome(){
        clickOn(homeButton);
    }
}
