Feature: register
  @register
  Scenario: Aa user, I should able to register successuflly
  So that, I can use all user features
    Given I am on registration page
    When I enter required registraion details
    Then I should able to register successfully