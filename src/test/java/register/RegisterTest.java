package register;


import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class RegisterTest extends BaseTest {

    @Test(description = "Verify succesful user register")
    public void registerUserTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SignUpPage signUpPage = new SignUpPage(driver);
        AccountCreatePage accountCreatePage = new AccountCreatePage(driver);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);
        AdFramePage adFramePage = new AdFramePage(driver);
        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();
        //LOGIN PAGE - VERIFY 'NEW USER SIGNUP!' IS VISIBLE
        Assert.assertTrue(loginPage.isNewUserSignUpDisplayed(), "Expected control not visible");
        loginPage.signUpWithCredentials("Wil", "wilfor@credential.com");
        //SIGNUP PAGE - VERIFY THAT 'ENTER ACCOUNT INFORMATION' IS VISIBLE
        Assert.assertTrue(signUpPage.isEnterAccountInformationVisible(), "Expected control not visible");
        signUpPage.selectGender("Mr");
        String username = "Wil";
        String password = "1234";
        signUpPage.setUsernameAndPassword(username, password);
        signUpPage.setBirthDate("17", "7", "1996");
        signUpPage.checkNewsLetter();
        signUpPage.checkOffersBox();
        signUpPage.setPersonalDataWith("Wilfor", "Ibanez", "none", "none", "none");
        signUpPage.selectCountry("Canada");
        signUpPage.setLocationInfoWith("Toronto", "none", "12345", "1234567");
        signUpPage.createAccount();
        //ACCOUNTCREATE PAGE - VERIFY THAT 'ACCOUNT CREATED' IS VISIBLE
        Assert.assertTrue(accountCreatePage.isAccountCreatedDisplayed(), "Expected control is not visible");
        accountCreatePage.clickContinue();

        adFramePage.closeAdFrame();
        //HOME PAGE - VERIFY THAT 'LOGGED IN AS 'USERNAME'' IS VISIBLE
        Assert.assertEquals(homePage.getLoggedInformation(), username, "The text is not as the expected");
        homePage.clickOnDeleteAccount();
        //DELETEACCOUNT PAGE - VERIFY THAT 'ACCOUNT DELETED!' IS VISIBLE
        Assert.assertTrue(deleteAccountPage.isAccountDeletedDisplayed(), "Expected control is not visible");
        deleteAccountPage.clickContinue();
    }

    @Test(description = "Verify register user with existing mail")
    public void registerWithExistingMail(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();

        //LOGIN PAGE - VERIFY 'NEW USER SIGNUP!' IS VISIBLE
        Assert.assertTrue(loginPage.isNewUserSignUpDisplayed(), "Expected control is not displayed");
        String username = "valid";
        String email = "valid@user.com";
        loginPage.signUpWithCredentials(username, email);

        //LOGIN PAGE - VERIFY 'EMAIL ADDRESS ALREADY EXISTS!' IS VISIBLE
        Assert.assertTrue(loginPage.isErrorSigningUpDisplayed());
    }
}
