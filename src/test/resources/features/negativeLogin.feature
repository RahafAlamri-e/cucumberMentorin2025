@negativeLogin
Feature: Negative Login Scenarios
  As a user
  I want to verify invalid login attempts
  So that proper error messages are displayed
  @ScenarioOutline

  @EmptyEmailSignin
  Scenario: Empty username
    Given user goes to "https://claruswaysda.github.io/signIn.html"
    When user enters "" as username
    And user enters "123" as password
    And user clicks the Sign Up button
    Then user should see "Please Fill Out This Field" error message on username
    And user closes driver

  @EmptyPasswordSignin
  Scenario: Empty username
    Given user goes to "https://claruswaysda.github.io/signIn.html"
    When user enters "admin" as username
    And user enters "" as password
    And user clicks the Sign Up button
    Then user should see "Please Fill Out This Field" error message on password
    And user closes driver

  Scenario Outline: Login with invalid credentials
    Given user goes to "https://claruswaysda.github.io/signIn.html"
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user clicks the Sign Up button
    Then user should see "<message>" displayed
    And user closes driver

    Examples:
      | username   | password     | message                        |
      | wrongUser  | 123          | Incorrect username or password |
      | admin      | wrongPass123 | Incorrect username or password |
      | wrongUser  | wrongPass123 | Incorrect username or password |
      | user@name! | pass123      | Incorrect username or password |
      | admin      | sfgf         | Incorrect username or password |