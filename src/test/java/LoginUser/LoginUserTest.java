package LoginUser;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginUserTest extends BaseTest {

    @Test(description = "TC2-Verify login successful with valid credentials")
    public void loginWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();
        //LOGIN PAGE - VERIFY 'LOGIN TO YOUR ACCOUNT' IS VISIBLE
        Assert.assertTrue(loginPage.isLoginAccountDisplayed(), "Expected control is not displayed");
        String email = "valid@user.com";
        String password = "1234";
        loginPage.loginWithCredentials(email, password);

        String expectedUserName = "valid";
        //HOME PAGE - VERIFY 'LOGGED IN AS 'USERNAME'' IS VISIBLE
        Assert.assertEquals(homePage.getLoggedInformation(), expectedUserName, "Expected user logged information is not equal as current");
        /*homePage.clickOnDeleteAccount();
        //DELETEACCOUNT PAGE - VERIFY THAT 'ACCOUNT DELETED!' IS VISIBLE
        Assert.assertTrue(deleteAccountPage.isAccountDeletedDisplayed());*/
    }

    @Test(description = "TC3-Verify login successful with valid credentials")
    public void loginWithInvalidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();

        //LOGIN PAGE - VERIFY 'LOGIN TO YOUR ACCOUNT' IS VISIBLE
        Assert.assertTrue(loginPage.isLoginAccountDisplayed(), "Expected control is not displayed");
        String email = "wil@crrrr.com";
        String password = "00001111";
        loginPage.loginWithCredentials(email, password);

        //LOGIN PAGE - VERIFY ERROR 'YOUR EMAIL OR PASSWORD IS INCORRECT!' IS VISIBLE
        Assert.assertTrue(loginPage.isErrorLoginDisplayed(), "Expected message wasn't correctly displayed");
    }

}
