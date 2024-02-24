Feature: Insurance for students

  Scenario: Exploring different insurance plan 
    Given user navigate to policybazaar site
    When user click on travel insurance icon
    Then user navigate to travel.policybazaar webpage
    Given user entered the noneuropean country name
    Then next button should be enabled
    Then user select the start and end date of travelling
    When user selects the number of people along with their age and clicks on next button
    And fill the pre-existing medical condition
    And user required to enter medical history and clicks on next button
    And user redirected to contact details page and required to enter mobile number
    And user enter mobile number then user navigated to available policies         
    And user applies the filter to select student plan and select plan Type
    Then lowest three travel insurance for students is captured.
    
  Scenario:
    When user click on policybazaar logo
    And user click on car insurance and redirected to cipolicybazaar webpage
    And user selects  car issued city & RTO 
    And user enters car company & car model 
    And  user reached to Please Fill Your Details page
    And user entered the invalid email & mobile number
    Then capture & display the error message
    
    
  Scenario:  
    When user click on policybazaar logo
    And user click on Health insurance navigated to health page
    And user should select atleast one member for health insurance from available memebers
		And user navigated to select age of member & proceed with continue button
		And user should select the city name & proceed with continue button
		And user enters name & mobileNo & proceed with continue button
		And user should select any previous medical history
		And user selects health insurance is provided or not
		Then user should capture and display different health plans
  
