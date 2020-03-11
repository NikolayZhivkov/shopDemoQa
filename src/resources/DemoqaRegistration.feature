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
  |pullwaven    |pullwavem@abv.bg    |A1B2C3!ASDFER|
  |vassmanen    |vassmanen@bbb.bg    |!2B3C5!BSEWQQ|
  |pullwavan    |possan@gmail.com    |123WER45TREWQ|
  |vassmanane   |vassmanane@bbb.bg   |1234WER43YTRE|
