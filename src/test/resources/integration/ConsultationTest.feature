#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag1
Feature: Consultation Note Screen functionality

  @PatientRecordAlreadyExists
  Scenario: Precondition - User already has an existing demographic patient in his account
    Given User is logged into oscar-emr
    When User clicks on Search tab 
    And User clicks on Search button
    Then Atleast one demograohic patient record is displayed
    
 # @tag3
 # Scenario: Consultation Response/ Request Letterhead Defaults to the Logged in User