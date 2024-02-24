Feature: Insurance for students

  Scenario: Travel insurance plan 
    Given user navigate to policybazaar site
    When user click on travel insurance icon
    And user navigate to travelpolicybazaar webpage
    And user entered the noneuropean "<country>" name
    Then next button should be enabled
    When user select the start and end date of travelling
    And user selects the number of people along with their age and clicks on next button
    And user required to enter medical history and clicks on next button
    And user redirected to contact details page and required to enter "<mobilenumber>" mobilenumber       
    And user applies the filter to select student plan and select plan Type to fetch available policies
    Then lowest three travel insurance for students is captured.
    
    Examples:
    	|  country  |  mobilenumber |
    	| Thailand  |   6396527359  |
    
  Scenario: Car Insurance Plan
    When user click on policybazaar logo
    And user click on car insurance and redirected to cipolicybazaar webpage
    And user selects  car issued city & RTO 
    And user enters car company & car model 
    And user entered the invalid email & mobile number
    Then capture & display the error message
    
    
  Scenario:  Health Insurance Plan
    When user click on policybazaar logo
    And user click on Health insurance navigated to health page
    And user should select atleast one member for health insurance from available memebers
		And user navigated to select age of member & proceed with continue button
		And user should select the city name & proceed with continue button
		And user enters name & mobileNo & proceed with continue button
		And user should select any previous medical history
		And user selects health insurance is provided or not
		Then user should capture and display different health plans