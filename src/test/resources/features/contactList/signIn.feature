@Contactlist @Signup
Feature: Contact list Sign In Features

  Background:
    Given user navigate to the "https://thinking-tester-contact-list.herokuapp.com"
    When user clicks on Sign Up button

  Scenario: Sign Up valid credentials
    And User fills sign up form
    Then user verifies user is signed up
    And user should see add contact button
    And user closes driver

  Scenario: Sign Up invalid credentials - empty name field
    And User fills sign up form with missing name
    Then user verifies user is not signed up
    And user should see error message
    And user closes driver