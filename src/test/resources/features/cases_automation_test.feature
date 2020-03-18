@Cucumber
Feature: Creation of an user account


  Scenario: Show a required message when an input is not filled out
    Given The User open the Page
    When The User clicks an input and does not enter any value
    Then The user should see a required message

  Scenario: User can not create an account with empty values
    Given The User open the Page
    When The User have empty values
    Then The user can not create an account
