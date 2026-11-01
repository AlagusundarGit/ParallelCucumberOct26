@sanity @Regression
Feature: Add To Cart

  Background:
    Given Launch the application
    And User clicks on Accept Cookies
    And User clicks on account
    And User enters valid username and password
    And User clicks Login
    And User should be redirected to the home page

@Regression
  Scenario: Add the product to the cart
    When Hover on the Clothing
    And Click on the Tops
    And Click on the product
    And Select the size
    And Click on the add to bag
    And Click on the view bag
    Then verify the product added in cart
    And verify the cart quantity
    And verify the estimated total
    

 