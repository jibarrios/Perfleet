

Feature: Login
  As I user, I should be able to login
  @LoginFunc
  Scenario: Login as a driver
    Given I am on the login page
    When I login as driver
    Then dashboard should be displayed

