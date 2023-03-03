Feature: Login feature
  Background:
    Given User is on the login page

  # The first example has two steps
  @Sanity
  Scenario: User can't be logging using invalid password
    Given User enter valid username "01777808463"
    When User enter invalid password "pass"
    And User click on the login button
    Then User should see the error massage "Incorrect username or password."
    And User should be in the login page

    @test
  Scenario: User can't be logging using invalid username
    Given User enter invalid username "01777777777"
    When User enter valid password "pass1234#"
    And User click on the login button
    Then User should see the error massage "please enter a valid phone number ."
    And User should be in the login page

      @login
  Scenario Outline:  User can't be logging using invalid credentials
    When User enter username <username>
    And User enter password <password>
    And user click on the log in button
    Then User should see the error message <error_message>
    And User should be in the login page
    Examples:
      | username       |password|error_message                       |
      |"01811111111"   |"pass1"  |"Incorrect username or password."   |
      |"01888888888888"|"pass12"  |"Please enter a valid phone number."|
      |"018666"        |"pass31"  |"Please enter a valid phone number."|
      |"0189999999999" |"pass14"  |"Please enter a valid phone number."|


