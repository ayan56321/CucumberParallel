Feature: Login to Office.com

  Scenario: Navigate to Office.com in Chrome and perform login
    Given launch browser "chrome"
    When user navigates to the URL "https://www.office.com"
    Then user click on login
    
