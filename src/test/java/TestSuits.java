import org.example.*;
import org.testng.annotations.Test;

public class TestSuits extends TestBase {
    HomePage homePage = new HomePage();
    RegistrationDetails registrationDEtails = new RegistrationDetails();

    // RegistredUserCanVote registredUserCanVote = new RegistredUserCanVote();
    ElectronicPage electronicPage = new ElectronicPage();
    CompareList compareList = new CompareList();
    MailPageofBuildComp mailPageofBuildComp = new MailPageofBuildComp();


    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();

    @Test
    public void c_verifyRegisterShouldBeSuccessfullydone() {
        //  verifyUserShouldRegisterSuccessful();
        homePage.clickOnRegisterButton();
        registrationDEtails.EnterRegistrationDetails();
    }

    @Test
    public void d_verifyRegistredUserCanRefferedProductToFriend() {
        homePage.logIn();
        homePage.clickOnBuldComputer();
        buildYourOwnComputerPage.buildOwnComputer();
        mailPageofBuildComp.clickOnMail();
    }

    @Test
    public void e_verifyOnlyRegistredUserCanVote() {
        homePage.logIn();
        homePage.clickOnVoteforUser();
    }

    @Test
    public void a_verifyNonRegistredCanNotVote() {

        homePage.clickonCommunityVote();

    }

    @Test
    public void f_verifyUserShouldBeableToCompareTwoProducts() {
        homePage.clickOnAddToCompareList();
        compareList.clickOnCart();
    }

    @Test
    public void g_verifySameProductAddedInCart() {
        homePage.electronicClick();
        electronicPage.addToCart();
    }

    @Test
    public void b_verifyNonRegistredUserCanNotDoMail() {
        homePage.clickOnBuldComputer();
        buildYourOwnComputerPage.buildOwnComputer();
    }
}