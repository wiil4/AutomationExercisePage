package contactUs;

import baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdFramePage;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends BaseTest {

    @Test(description = "Verify contact Us")
    public void testContactUs(){
        HomePage homePage = new HomePage(driver);
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        AdFramePage adFramePage = new AdFramePage(driver);

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
        homePage.clickOnContactUs();

        //CONTACTUS PAGE - VERIFY 'GET IN TOUCH VISIBLE'
        Assert.assertTrue(contactUsPage.isGetInTouchDisplayed(), "");
        String name = "Wil";
        String email = "valid@user.com";
        String subject = "Email Subject";
        String message = "This is the new message for test";
        contactUsPage.uploadFile("archives/jsondata.txt");
        contactUsPage.submitContact(name, email, subject, message);

        //CONTACT US PAGE - VERIFY THAT 'SUCCESS! YOUR DETAILS HAVE BEEN SUBMITED...' IS VISIBLE
        Assert.assertTrue(contactUsPage.isSubmitionSuccessDisplayed(),"The contact information was not submited correctly");
        contactUsPage.returnHome();
        adFramePage.closeAdFrame();

        //HOME PAGE - VERIFY HOME PAGE IS VISIBLE SUCCESFULLY
        Assert.assertEquals(homePage.getPageTitle(), "Automation Exercise", "Title not equal as expected");
    }
}
