Feature: Logout functionality
    As a user I want be able to login and logout from the platform.




        @login-example
        Scenario: Login with user and logout
        Given user account login in jira <name> and <pass>
        When the user logaout from jira
        Then the user successfully jira



    Scenario: Login with user and logout
        Given user account login in jira <name> and <pass>
        When the user logaout from jira
        Then the user successfully jira

        | name      | pass         |
        | yzpeychev | Limonada!234 |
