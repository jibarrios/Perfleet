

Feature: Login
  As I user, I should be able to login
@wip
  Scenario: Login as a store manager51
    Given I am on the login page
    When I login as store manager51
    Then dashboard should be displayed

  Scenario: Login as a driver
    Given I am on the login page
    When I login as a driver
    Then dashboard should be displayed
