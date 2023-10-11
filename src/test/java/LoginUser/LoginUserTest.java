package LoginUser;

import BaseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DeleteAccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginUserTest extends BaseTest {

    @Test(description = "Verify login successful with valid credentials")
    public void loginWithValidCredentials(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        DeleteAccountPage deleteAccountPage = new DeleteAccountPage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();

        Assert.assertTrue(loginPage.isLoginAccountDisplayed(), "Expected control is not displayed");
        String email = "wil@credential.com";
        String password = "1234";
        loginPage.loginWithCredentials(email, password);

        String expectedUserName = "wil";
        Assert.assertEquals(homePage.getLoggedInformation(), expectedUserName, "Expected user logged information is not equal as current");
        homePage.clickOnDeleteAccount();

        Assert.assertTrue(deleteAccountPage.isAccountDeletedDisplayed());
    }
}
