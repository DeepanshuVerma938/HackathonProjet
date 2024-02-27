Feature: categorizing the features as smoke

  @smoke
  Scenario: Navigating the url of policybazaar
    Given user navigates to policybazaar site
    When user clicked on travel icon
    Then user should navigate to travelpolicybazaar webpage

  @smoke
  Scenario: Navigating to health insurance page
    Given user navigates to policybazaar site
    When user clicked on heart logo icon
    Then user  navigate to healthInsurance webpage

  @smoke
  Scenario: Navigating to CarInsurance page
    Given user navigates to policybazaar site
    When user clicked on CarImage present on homepage
    Then user  navigates to carInsurance webpage

  @smoke
  Scenario: Navigating to HomeInsurance page
    Given user navigates to policybazaar site
    When user clicked on HouseImage available on homepage
    Then user should navigate to houseInsurance webpage

  @smoke
  Scenario: Navigating to TermLifeInsurance page
    Given user navigates to policybazaar site
    When user clicked on UmbrellaImage available on homepage
    Then user should navigate to TermLifeInsurance webpage

  @smoke
  Scenario: Navigating to Retirement Plan
    Given user navigates to policybazaar site
    When user clicked on RetirementPlans present on homepage
    Then user should navigate to RetirementPlans webpage

  @smoke
  Scenario: Navigating to child savings plan
    Given user navigates to policybazaar site
    When user clicked on ChildImage available on homepage
    Then user should navigate to child savings plan webpage

  @smoke
  Scenario: Navigating to FamilyInsurance Plan
    Given user navigates to policybazaar site
    When user clicked on FamilyImage present on homepage
    Then user should navigate to FamilyHealthInsurance webpage

  @smoke
  Scenario: Scrolling functionality
    Given user navigates to policybazaar site
    When user scroll to bottom of webpage
    And click on contact us link
    Then contact us link should be clickable and navigated to my accoount

  @smoke
  Scenario Outline: Log in functionality with invalid phonenumber
    Given user navigate to contact us page of policy bazaar
    When user click on login button
    And enter "<mobile>" phone number
    And click on log in button
    Then capture error message if entered mobile number is invalid otherwise user should login

    Examples: 
      | mobile     |
      |   97896876 |
      | 9876543209 |
