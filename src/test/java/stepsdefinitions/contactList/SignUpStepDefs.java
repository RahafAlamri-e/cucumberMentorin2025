package stepsdefinitions.contactList;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.contactlist.ContactListPage;
import pages.contactlist.HomePage;
import pages.contactlist.SignUpPage;
import utilities.Driver;

public class SignUpStepDefs {
    HomePage homePage = new HomePage();
    ContactListPage contactListPage = new ContactListPage();
    SignUpPage signUpPage = new SignUpPage();

    @Given("user navigate to the {string}")
    public void user_navigate_to_the(String url) {
        Driver.getDriver().get(url);
    }
    @When("user clicks on Sign Up button")
    public void user_clicks_on_sign_up_button() {
    homePage.clickSignUp();
    }
    @When("User fills sign up form")
    public void user_fills_sign_up_form() {

    signUpPage.signUp("John12"
            ,"Doe12"
            ,"Johndoe12@new.com"
            ,"123asd?");
    }
    @Then("user verifies user is signed up")
    public void user_verifies_user_is_signed_up() {
        Assert.assertTrue(contactListPage.logout.isDisplayed());
    }
    @Then("user should see add contact button")
    public void user_should_see_add_contact_button() {
        Assert.assertTrue(contactListPage.isAddContactDisplayed());
    }

    @And("user closes driver")
    public void userClosesDriver() {
        Driver.quitDriver();
    }

    @And("User fills sign up form with missing name")
    public void userFillsSignUpFormWithMissingName() {
        signUpPage.signUp(""
                ,"Doe12"
                ,"Johndoe12@new.com"
                ,"123asd?");
    }

    @Then("user verifies user is not signed up")
    public void userVerifiesUserIsNotSignedUp() {
        //Assert.assertFalse(contactListPage.logout.isDisplayed());
    }

    @And("user should see error message")
    public void userShouldSeeErrorMessage() {
        Assert.assertTrue(signUpPage.errorMesage.isDisplayed());
    }
}
