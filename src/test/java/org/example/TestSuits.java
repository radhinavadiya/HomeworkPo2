package org.example;

import org.example.*;
import org.testng.annotations.Test;

public class TestSuits extends TestBase {
    HomePage homePage = new HomePage();
    RegistrationDetails registrationDEtails = new RegistrationDetails();

    //RegistredUserCanVote registredUserCanVote = new RegistredUserCanVote();
    ElectronicPage electronicPage = new ElectronicPage();
    ShoppingCart shoppingCart = new ShoppingCart();
    MailPageofBuildComp mailPageofBuildComp = new MailPageofBuildComp();
    BillingOfBuildComputer billingOfBuildComputer = new BillingOfBuildComputer();

    FacebookConnect facebookConnect = new FacebookConnect();
    ShippingCopm shippingCopm = new ShippingCopm();
    PaymentOfComputer paymentOfComputer = new PaymentOfComputer();
RegisterResult registerResult =new RegisterResult();
    BuildYourOwnComputerPage buildYourOwnComputerPage = new BuildYourOwnComputerPage();
    NewReleaseProducts newReleaseProducts = new NewReleaseProducts();

    @Test
    public void c_verifyRegisterShouldBeSuccessfullydone() {
        //  verifyUserShouldRegisterSuccessful();
        homePage.clickOnRegisterButton();
        registrationDEtails.EnterRegistrationDetails();
        registerResult.registerSuccess();
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
        shoppingCart.clickOnCart();
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

    @Test
    public void printProductList() {
        homePage.printOutProductNames();
    }

    @Test
    public void verifySearchAlertMessage() {
        homePage.printelert();
    }

    @Test
    public void verifynonRegistredVoteAlert() {
        homePage.voteWithoutSelecting();

    }

    @Test
    public void verifyFacebookConnection() {
        homePage.connectFacebook();
        facebookConnect.facebookClick();
    }

    @Test
    public void verifyCheckoutSuccessfulyAsAGuest() {
        homePage.clickOnBuldComputer();

        buildYourOwnComputerPage.chekoutAsGuest();
        shoppingCart.cartOfBuildCopmuter();
        billingOfBuildComputer.billingProcess();
        shippingCopm.shiiping();
        paymentOfComputer.payment();
    }

    @Test
    public void verifyNewReleaseCommentComesAtLast() {
        homePage.newRelease();
        newReleaseProducts.newReleaseProductComment();


    }

    @Test
    public void verifyCurrency() {
        homePage.currencySelect();
    }

    @Test
    public void verifySearchFunction() {

        homePage.clickOnSearchButton("Nike");
    }
}
