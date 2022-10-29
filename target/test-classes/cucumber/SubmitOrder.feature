
@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce Page


  #@tag1
  #Scenario: Title of your scenario
    #Given I want to write a step with precondition
    #And some other precondition
    #When I complete action
    #And some other action
    #And yet another action
    #Then I validate the outcomes
    #And check more outcomes

  @Regression
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add product  <productName> to Cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayes on ConfirmationPage
    Examples: 
      | name                       | password         | productName |
      | santhoshsivan200@gmail.com | Thalas555        | ZARA COAT 3 |
      
