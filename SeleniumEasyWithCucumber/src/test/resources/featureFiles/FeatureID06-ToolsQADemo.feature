@ToolsQA
Feature: verify ToolsQA website input form functionality

  Scenario: verify textbox field
    Given go to "https://demoqa.com/text-box" website
    When user see Tex Box demo page
    Then Enter complet details of the user
      | UserName  | EmailID            | CurrentAddress | PermAddress |
      | Rushikesh | rushi@anything.com | CSN            | CSN         |
      | vikas     | vikas@anything.com | Mumbai         | Mumbai      |
      | Ajay      | ajay@any.com       | Dehli          | Dehli       |
