Feature: Regression testing for policybazaar site  
    
   @regression
   Scenario: Negative steps for Car Insurance 
    Given user navigates to car insurance page
    And directly clicks view price
    Then user capture error  
    
  #@regression
  #Scenario Outline: Filling the invalid contact details
  #	Given user is on please fill your details page 
    #When user entered the "<name>" name
    #And user entered the "<email>" email &  "<mobileNumber>" mobilenumber
    #Then user should able to capture the error message
    #
    #Examples:
    #| name       |    email     | mobileNumber |
    #| Rahul      |   abc@123    |   123448900  |
    #| Aman       | 788abc@.com  |   7857456644 |
   
   
   
   @regression
   Scenario: Negative steps for Health Insurance 
    Given user navigates to health insurance page
    And user selects only one child
    Then user should able to get error
    
  @regression
   Scenario: Negative steps for Two wheeler Insurance 
    Given user navigates to two wheeler insurance page
    And user enters invalid number
    Then user get error message & not able to proceed further
   
    
    
     
    
    
    
    
   