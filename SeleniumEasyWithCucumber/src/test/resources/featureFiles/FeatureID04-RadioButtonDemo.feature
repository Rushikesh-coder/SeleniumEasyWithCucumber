@DummyTest
Feature: Feature ID 004 : verify RadioButton functionality on Selenium Easy website

 
 Background:
 		Given user launch chrome browser and navigate to URL
    When  user close PopUp
    
  Scenario: Go to Radio button Demo page and verify
  
    Given user navigate to home page
    And click on DropDown TopUp of "Input Forms" and select "Radio Buttons Demo" 
    And header of radio button demo page is displayed
    When user click on radio button
    And user click on getCheckedValue button 
    And user verify Result of RadioButton
    And select Gender as "Male"
    And Select Age as "5 - 15"
    And click on get value button
    Then verify values that user entered
		And user Close the Browser
