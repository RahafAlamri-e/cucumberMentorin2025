package stepsdefinitions.claruswaysda;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.claruswaysda.SignInPage;
import utilities.Driver;

public class SignInStepDefs {
    SignInPage signInPage = new SignInPage();
    @Given("user goes to {string}")
    public void user_goes_to(String url) {
        Driver.getDriver().get(url);
    }
    @When("user enters {string} as username")
    public void user_enters_as_username(String username) {
        signInPage.enterName(username);
    }
    @When("user enters {string} as password")
    public void user_enters_as_password(String pass) {
        signInPage.enterPassword(pass);
    }
    @When("user clicks the Sign Up button")
    public void user_clicks_the_sign_up_button() {
        signInPage.clickSubmit();
    }
    @Then("user should see {string} displayed")
    public void user_should_see_displayed(String error){
        Assert.assertTrue(signInPage.invalidUserAlertMessage().contains(error));
    }

    @Then("user should see {string} error message on username")
    public void userShouldSeeErrorMessageOnUsername(String err) {
        System.out.println("signInPage.passwordNameEmptyErrorMessage() = " + signInPage.passwordNameEmptyErrorMessage());
        Assert.assertTrue(signInPage.userNameEmptyErrorMessage().toLowerCase().contains(err.toLowerCase()));
    }

    @Then("user should see {string} error message on password")
    public void userShouldSeeErrorMessageOnPassword(String err) {
        Assert.assertTrue(signInPage.passwordNameEmptyErrorMessage().toLowerCase().contains(err.toLowerCase()));
    }
}