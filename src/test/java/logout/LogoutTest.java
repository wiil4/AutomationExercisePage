package logout;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends BaseTest {
    @Test(description = "TC4-Logout User")
    public void logoutUserTest(){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnLogin();

        //LOGIN PAGE - VERIFY 'LOGIN TO YOUR ACCOUNT' IS VISIBLE
        Assert.assertTrue(loginPage.isLoginAccountDisplayed(), "Expected control is not displayed");
        String user = "valid";
        String email = "valid@user.com";
        String password = "1234";
        loginPage.loginWithCredentials(email, password);

        //HOME PAGE - VERIFY THAT 'LOGGED IN AS 'USERNAME'' IS VISIBLE
        Assert.assertEquals(homePage.getLoggedInformation(), user, "Current username is not as expected");
        homePage.clickOnLogout();

        //LOGIN PAGE - VERIFY THAT USER IS NAVIGATED TO LOGIN PAGE
        Assert.assertTrue(loginPage.isLoginAccountDisplayed(), "Expected control is not displayed");
    }
}
