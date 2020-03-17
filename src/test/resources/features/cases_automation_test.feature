@Cucumber
Feature: Search Automation Test


  Scenario: search relative results
    Given The User open the Page
    When The User does a search: rock nacional
    Then The user would can see results with the word: rock

