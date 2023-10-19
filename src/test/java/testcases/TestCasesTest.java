package testcases;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdFramePage;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest {
    @Test(description = "Verify test cases page")
    public void testCasesPageDisplayed(){
        HomePage homePage = new HomePage(driver);
        TestCasesPage testCasesPage = new TestCasesPage(driver);
        AdFramePage adFramePage = new AdFramePage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnTestCases();
        adFramePage.closeAdFrame();

        //TEST CASE PAGE - VERIFY NAVIGATION SUCCESSFULLY
        Assert.assertTrue(testCasesPage.isTestCasesLabelDisplayed(), "Test cases page not successfully displayed");
    }
}
