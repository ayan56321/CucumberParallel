Feature: Searching on Google using Outline

Scenario Outline: Direct Login on Office chrome
Given launch Browser '<browserName>'
When user navigates to '<url>'
And clicks on SignIn Button
Examples:
|browserName|url|
|chrome|http://www.office.com|

Scenario Outline: Direct Login on Office chrome2
Given launch Browser '<browserName>'
When user navigates to '<url>'
And clicks on SignIn Button
Examples:
|browserName|url|
|chrome|http://www.office.com|