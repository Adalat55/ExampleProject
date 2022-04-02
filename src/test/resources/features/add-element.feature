
Feature: Adding element verification

  Scenario: User add elements and verifying it

    Given User is on The Internet home page
    When  User clicks on add element button "4" times
    Then  "4" times elements exists on page

