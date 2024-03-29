@REGRESSION @LOGIN
Feature: User login for Music Streaming App
  As a user, I want to be able to login to my account
  so that I can access the feature of the application

  Background:
    Given the user is on the login page


  @valid @smoke
  Scenario: Successful login wih a valid username and password

    When the user enters valid username and password
    Then the user should be directed to the personal dashboard

  @unsuccessful @flaky
  Scenario: Unsuccessful login wih a invalid username and password

    When the user enters invalid username and password
    Then the user should not be directed to the personal dashboard


  @unsuccessful
  Scenario: Unsuccessful login wih no username and password

    When the user enters no username and password
    Then the user should not be directed to the personal dashboard

    @parametrized
  Scenario: Successful login wih a valid username and password 1
    When the user enters valid username as "duotech2023" and password as "duotech"
    Then the user should be directed to the personal dashboard

  @parametrized
  Scenario: Successful login wih a valid username and password 2
    When the user enters valid username as "duotech2050" and password as "duotech123"
    Then the user should be directed to the personal dashboard



