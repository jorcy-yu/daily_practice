Feature: login and logout

Scenario: Successful Login with Valid Credentials
  Given User is on EmailTypeList Page
  When User Navigate to 126 Mail Login Page
  And User enter UserName and Password
  Then Message displayed Login Successfully

Scenario: Successful Logout
  When User Loginout from the Application
  Then Message displayed Logout Successfully