Feature: User Registration Scenario - Negative
  Аs a user I want to register a user with a different name but with the same email

  Scenario Outline: User want to make registration whit used username or email address-"<reason>"
    Given the user is on the user homepage and navigate to My Account button
    When user enter "<username>","<emailAddress>" and "<password>"
    Then error message should be located with text "<error>"

    Examples:
    |reason       |username|emailAddress|    password|error                                                                      |
    |used email   |ppp123   |ppp@ajaj.com|ppp123ppp456| An account is already registered with your email address. Please log in.	|
    |used username|ppp12   |ppp21@ajaj.com|ppp1234ertty| An account is already registered with that username. Please choose another.	|
