Feature: Auth
  As a user
  I want to access online shop
  So that I can buy some products

  Scenario: GET - As user I have be able to register
    Given I set POST api endpoint for register
    When I send POST HTTP request for register
    Then I receive valid data for new user


