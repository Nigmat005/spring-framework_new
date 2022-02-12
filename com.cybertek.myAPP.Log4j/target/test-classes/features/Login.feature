Feature: As a user, I should be able to login

  Scenario: Login valid
    Given user is on login-in page
    When user uses  username "storemanager85" and password "UserUser123"
    Then  user should be login into home page successfully

