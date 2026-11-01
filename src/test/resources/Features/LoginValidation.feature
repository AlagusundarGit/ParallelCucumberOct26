@sanity @Regression
Feature: Login

  Background:
    Given Launch the application
    And User clicks on Accept Cookies
    And User clicks on account

  @sanity @smoke
  Scenario: Login the application
    When User enters valid username and password
    And User clicks Login
    Then User should be redirected to the home page

  @ignore @smoke
  Scenario: Login the application one dim list
    When User enters valid username and password by one dim list
      | as@as.com |
      | Test$1234 |
    And User clicks Login
    Then User should be redirected to the home page

  @ignore @sanity
  Scenario: Login the application one dim map
    When User enters valid username and password by one dim map
      | usernames | new@new.com |
      | passwords | Test$1234   |
    And User clicks Login
    Then User should be redirected to the home page

  Scenario Outline: Login the application outline
    When User enters valid username and password "<username>" "<password>"
    And User clicks Login
    Then User should be redirected to the home page

    Examples:
      | username                             | password  |
      | alagusundar.sundar@lnitwellgroup.com | Test$1234 |
      | as@as.com                            | Test$1234 |
      | new@new.com                          | Test$1234 |
