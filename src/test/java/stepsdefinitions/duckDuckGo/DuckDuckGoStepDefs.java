package stepsdefinitions.duckDuckGo;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utilities.Driver;

public class DuckDuckGoStepDefs{

    @Given("i visit {string}")
    public void i_visit(String url) {
        Driver.getDriver().get(url);
    }

    @Then("i close driver")
    public void i_close_driver() {
       Driver.quitDriver();
    }

}