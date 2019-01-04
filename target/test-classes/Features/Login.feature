#StyoryType=WEB
#Owner=ejagruti
#CreationDate=24-12-2017 Sunday
@Login
Feature: LoginFeature

  Background:user is successfully launched the application
  When user opens the "FF32" browser
  And user enters the url "http://localhost:90/finsys"

  @SmokeTest
  Scenario Outline: Login Functionality for valid username and valid password
  When user enters "<username>" as username
  And user enters "<password>" as password
  And user clicks on Login button
  Then user verifies the link on home page
  Then user logs out
  And Close the Broswer

    
  Examples:
  |username|password|
  |dummyfm|passw0rd|
  |dummyfm|passw0rd|
  |dummyfm|passw0rd|
  |dummyfm|passw0rd|
  |dummyfm|passw0rd|

