Feature: Logout functionality
  As a user I want be able to login and logout from the platform.

  @complete
  Scenario: Login with user and logout
    Given user account login in jira
    When the user logout from jira
    Then the user successfully logout from jira

