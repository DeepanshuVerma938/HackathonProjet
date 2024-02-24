Feature: Different insurance policies

  Scenario: Navigating the url of policybazaar
    Given user navigate to the policybazaar site
    When user click on travel insurance icon
    And user should navigate to travelpolicybazaar webpage

  Scenario: Scrolling functionality
    Given user navigate to the policybazaar site
    When user scroll to bottom of webpage
    When click on contact us link
    Then contact us link should be clickable and navigated to my accoount

  Scenario: Log in functionality with invalid phonenumber
    Given user navigate to contact us page of policy bazaar
    Then user should navigated to policybazaar site & able to click on contact us
    When user click on login button
    Then user should navigated to my account webpage
    When enter invalid phone number
    Then User has entered wrong number & capture error message
    When click on log in button
    Then user should not able to log in

  Scenario: Log in functionality with valid phonenumber
    Given user navigate to contact us page of policy bazaar
    Then user should navigated to policybazaar site & able to click on contact us
    When user click on login button
    Then user should navigated to my account webpage
    When enter valid phone number
    Then User has entered valid number
    When click on log in button
    Then user should be able to log in with correct otp

  Scenario: Searching the non European Countries
    Given user selected the noneuropean country name from the given countries list
    Then next button should be enabled and user should navigated to trip date

  Scenario: Searching the non European Countries
    When user select the start date end date of travelling under trip date
    And user clicks on next button
    Then user should navigated to Travellers page

  Scenario: Selecting the number of travellers alog with their ages
    When user need to select the number of people travelling
    And user selects their ages
    Then user click on next button & should navigated to Medical History page

  Scenario Outline: Finding the traveller pre-existing medical condition
    When user click on either y/n  <value> to select medical history of traveller
    Then Next should be clickable & user navigated to contact details page

    Examples: 
      | name  | value |
      | name1 | Y     |
      | name2 | N     |

  Scenario: Entering the traveller contact details
    Given user entered the vaild phone
    When user should  uncheck the get updates on whatsapp button
    Then user should click on view plan button & should display various policies

  Scenario: Capturing the travel insurance policies
    When user applies the filter to select to student plan and click on plan Type
    And user select premium low to high under sortby filter
    Then lowest three travel insurance for students is captured.

  Scenario: Health Insurance Products
    Given user navigate to policybazaar site
    When user click on Insurance Product link
    Then user capture and display the all health insurance products

  Scenario: Getting car insurance page
    Given user navigate to policybazaar site
    When user click on car insurance icon and redirected to ci.policybazaar webpage
    When user click on a buy new car link
    Then user should navigated to select car issued city and RTO

  Scenario: Select the car issued city and RTO
    Given user need to select the issued car city and RTO Number
    When user click on next button
    Then user should redirected to select car brand

  Scenario: select the car brand
    Given user need to select only one of the car brand
    When user click on next button
    Then user should redirected to select car model

  Scenario: Getting car insurance quote
    Given user need to select only one of the car model
    When user click on next button
    Then user should redirected to select car model with fuel type and car variant there only

  Scenario: Getting car
    Given user need to select only one of the car model
    When user click on next button
    Then user should redirected to select car model with fuel type and car variant there only

  Scenario: Filling the invalid contact details
    Given user entered the vaild name
    When user entered the invalid email & invalid mobile number
    Then user should able to capture the error message
