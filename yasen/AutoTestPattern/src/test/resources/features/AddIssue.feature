Feature: Adding an issue in Jira

  @complete
  Scenario Outline: Add issue in jira
    Given user account login in jira
    When go to Add issue
    Then add issue with <tittle>, <env> and <description>
    And verify that the issue is created successfully
   Examples:
      | tittle  | env  | description |
      | Test    | test | test        |