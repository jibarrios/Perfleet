Feature: Login with parameters


  Scenario: Login as store manager 101
    Given I am on the login page
    When I enter username "salesmanager101"
    And I enter password "UserUser123"
    And click the sign in button
    Then dashboard should be displayed


  Scenario: Login as store manager 51
    Given I am on the login page
    When I enter username "storemanager51"
    And I enter password "UserUser123"
    And click the sign in button
    Then dashboard should be displayed






