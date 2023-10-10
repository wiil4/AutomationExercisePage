package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage extends BasePage{
    private final By accountInfomationLabel = By.xpath("//b[text()='Enter Account Information']");
    private final By radioGenderMr = By.id("id_gender1");
    private final By radioGenderMrs = By.id("id_gender2");
    private final By nameInput = By.id("name");
    private final By passwordInput = By.id("password");
    private final By dayDropdown = By.id("days");
    private final By monthDropdown = By.id("months");
    private final By yearDropdown = By.id("years");
    private final By newsletterCheckbox = By.id("newsletter");
    private final By offersCheckbox = By.id("optin");
    private final By firstNameInput = By. id("first_name");
    private final By lastNameInput = By.id("last_name");
    private final By companyInput = By.id("company");
    private final By address1Input = By.id("address1");
    private final By address2Input = By.id("address2");
    private final By countryDropdown = By.id("country");
    private final By stateInput = By.id("state");
    private final By cityInput = By.id("city");
    private final By zipCodeInput = By.id("zipcode");
    private final By mobileNumberInput = By.id("mobile_number");
    private final By createAccountButton = By.xpath("//button[text()='Create Account']");


    public SignUpPage(WebDriver driver) {
        super(driver);
    }

    public Boolean isEnterAccountInformationVisible(){
        return isControlDisplayed(accountInfomationLabel);
    }
    public void selectGender(String gender){
        if(gender=="Mr"){
            clickOn(radioGenderMr);
        }
        else if(gender=="Mrs"){
            clickOn(radioGenderMrs);
        }
    }

    public void setUsernameAndPassword(String username, String password){
        clearInputText(nameInput);
        setText(nameInput, username);
        setText(passwordInput, password);
    }

    public void setBirthDate(String day, String month, String year){
        setDropdownByValue(dayDropdown, day);
        setDropdownByValue(monthDropdown, month);
        setDropdownByValue(yearDropdown, year);
    }

    public void checkNewsLetter(){
        clickOn(newsletterCheckbox);
    }
    public void checkOffersBox(){
        clickOn(offersCheckbox);
    }
    public void setPersonalDataWith(String firstname, String lastname, String company, String address1, String address2){
        setText(firstNameInput, firstname);
        setText(lastNameInput, lastname);
        setText(companyInput, company);
        setText(address1Input, address1);
        setText(address2Input, address2);
    }
    public void selectCountry(String countryName){
        setDropdownByValue(countryDropdown, countryName);
    }
    public void setLocationInfoWith(String state, String city, String zipcode, String mobileNumber){
        setText(stateInput, state);
        setText(cityInput, city);
        setText(zipCodeInput, zipcode);
        setText(mobileNumberInput, mobileNumber);
    }

    public void createAccount(){
        clickOn(createAccountButton);
    }

}
