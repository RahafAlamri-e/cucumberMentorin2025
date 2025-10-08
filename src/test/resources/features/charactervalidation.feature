Feature: Character Validation on Evil Tester
  Create a feature file called characterValidation.
  feature that tests the character validation functionality.
  * Test with 5 different valid data inputs
  * Test with 5 different invalid data inputs
  * Verify validation passes for valid inputs
  * Verify appropriate error messages are displayed for invalid inputs
  * Create appropriate step definitions
  * Add assertions to verify validation results
  * Run tests and verify all 10 test executions complete successfully

  @charValidation
  Scenario: the character validation functionality
    Given user goes to "https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html"
    When user enter five different valid and five diferent invalid data inputs
      | 12sdfgr    | Valid Value   |
      | A*sdfgr    | Valid Value   |
      | fgr4538    | Valid Value   |
      | 02345fe    | Valid Value   |
      | *sd4325    | Valid Value   |
      | sd4&325    | Invalid Value |
      | sd4t325)   | Invalid Value |
      | sd4t325wer | Invalid Value |
      | sd4t       | Invalid Value |
      | sd4t?**    | Invalid Value |
      | sd4t?**23  | Invalid Value |
      | sd4eaf3    | Valid Value   |
    Then user verifies verifies valid and invalid inputs
    And user closes driver

