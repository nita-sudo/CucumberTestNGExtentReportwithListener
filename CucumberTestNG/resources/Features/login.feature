@CompleteFeatureRun
Feature: Sfdc Login Feature

  #Background:
    #Given user is on the login page
    #When user enters username and password
    #And user clicks on login button

    @chrome
    Scenario: Login to salesforce application
    Given user is on the login page
    When user enters username and password
    And user clicks on login button
    Then page title should be "Home | Salesforce1"
    
    
    
    #@chrome
    Scenario: Create new case from service console
    Given user is on the login page
    When user enters username and password
    And user clicks on login button
    And user selects "service console" from app launcher
    And user clicks on new case create button
    And user enters all the mandatory fields
    And user clicks on save button
    Then new case should be created
    
    
  
    
