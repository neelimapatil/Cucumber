@CreateCompany
Feature: ManageCompany

Background:user is successfully launched the application
  When user opens the "FF32" browser
  And user enters the url "http://localhost:90/finsys"
  When user enters "dummyfm" as username
  And user enters "passw0rd" as password
  And user clicks on Login button
		
@SmokeTest
Scenario: Create New Company Successfully
	When user clicks on Financial Analysis link
	And user clicks on Company link
	And user clicks on Manage Company link
  When user clicks on New button
	And User enters Company name as "Tester12"
	And User selects Company type as "IT"
	And User Company Subtype as "Support"
	And User enters Address as "Pune"
	And User enters Phone as "0123456789"
	And User enters Email as "abcdef@gmail.com"
	And User enters Pan Details as "ARPPT3211265498"
	And User enters Tin details as "32165432165487"
	And User enters Country as "INDIA"
	And User enters State as "MAHARASHTRA"
	And User enters City name as "PUNE"
	And User enters Total Employee as "1"
	And User clicks on Save button
	