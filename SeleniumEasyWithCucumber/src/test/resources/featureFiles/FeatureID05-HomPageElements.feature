@DropdownTest
Feature: Verify Selnium easy Home page topup is clickable

  Background: 
    Given user launch chrome browser and navigate to URL
    When user close PopUp

  Scenario: Verify Dropdown Workings
    Given user navigate to home page
    And click on all dropdown on the home page
      | DropDownName    |
      | Input Forms     |
      | Date pickers    |
      | Table           |
      | Progress Bars   |
      | Alerts & Modals |
      | List Box        |
      | Others          |
    And user Close the Browser

  Scenario: Verify Table filter functionality
    Given user click on the DropDown "Table" and select "Table Filter "
    When user is on the Table filter page
    And user can click the buttons to use filter
      | FilterButtons |
      | Green         |
      | Orange        |
      | Red           |
      | All           |
    And user Close the Browser
