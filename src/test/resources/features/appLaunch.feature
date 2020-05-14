Feature: Login to Office.com and validate CRM

  Background: Navigate to Office.com in Chrome and perform login Instance2
    Given launch browser "chrome"
    When user navigates to the URL "https://www.office.com"
    Then user click on login
    And user provides UserName and clicks on Next Button
    And user provides password and clicks on Login Button
    
   Scenario: Excel Application Launch
   Given user clicks on Excel Icon
   And user then navigates and clicks on New Blank Workbook
   And user switches to "WebApplicationFrame" Frame
   And user clicks on Insert Button on workbook created
