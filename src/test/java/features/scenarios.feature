#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Addproducts
Feature: adding products and purchasing
As a user I want to be able to add two or more products to the cart and proceed with the purchase by placing the order.
  

  @tag1
    Scenario: buy two or more products
    Given I am on the home page and I have two o more products 
    And I click on cart page
    And I click on button place order
    And I fill the fields with user information
    When I click on button purchase
    Then I made the purchase successful