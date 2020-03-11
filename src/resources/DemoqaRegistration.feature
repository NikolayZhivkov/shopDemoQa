Feature:User Registration SCENARIO - POSITIVE
As a user I want successfully to register a user in Demoqa.com

Scenario Outline: Successful registration
Given the user is on the user homepage
  Given the user navigate to My Account and Register platform
When the user enter username "<username>" , "<emailAddress>" and "<password>"
  #the password should be at least 12 characters big and small letters, special symbols and numbers
  And the user enter valid information from registration "<username>" and "<password>"
  Then the user should successfully made an account

  Examples:
  |username     |emailAddress        |password     |
  |polyyss123   |polysssy123y@abv.bg |A1B2C3!ASDFER|