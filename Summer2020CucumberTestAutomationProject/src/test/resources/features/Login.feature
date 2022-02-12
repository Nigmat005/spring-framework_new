@Login
Feature:Feature to test login functionality
  Agile Story:
  As a user, I should be able to login in to home page of Vytrack
  using valid credential

  # Background_test pre_condition
  # will be excuted before every scenario in the particular feature file
  # Background must be all common in all of the scenarios
  Background: common steps
   Given user is on the login page

  Scenario: Check login is successfully done using valid credential
  When user logs in
  Then user should see dashboard page

  @Parameterized_test
  Scenario: Parameterized login
    When user logs in as a "sales manager"
    Then user should see dashboard page




  @negative_login
  Scenario:

      When  user logs in with "stormanager85" username and "invalid" password
#      Then  verifies that "Invalid user name or password." message is displayed