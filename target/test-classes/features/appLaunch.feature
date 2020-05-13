Feature: Login to Office.com and validate CRM

  Scenario: Navigate to Office.com in Chrome and perform login Instance2
    Given launch browser "chrome"
    When user navigates to the URL "https://www.office.com"
    Then user click on login
    And user provides UserName and clicks on Next Button
