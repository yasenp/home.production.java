Feature: Jenkis functionality
  As a user I want be able to login and logout from the platform and create job.

  @one
  Scenario: Log in and log out from Jenkins
    Given user with access to Jenkins
    When login in Jenkins
    Then logout from Jenkins

  @two
  Scenario: Create a job in Jenkins
    Given user with access to Jenkins
    When login in Jenkins
    And create new build job and configure it
    Then make the build
