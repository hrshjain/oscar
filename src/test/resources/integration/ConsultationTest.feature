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
@ConsultationNoteScreenFunctionality
Feature: Consultation Note Screen functionality

  @TestConsultationResponseRequestLetterhead
  Scenario: Test Consultation Response/ Request Letterhead Defaults to the Logged in User
    When New Consult Note is started  
    Then Default letterhead selection should be for the current Oscar user logged-in
    When User selects letterhead dropdown
    Then User should be able to select other letterhead name
    When User selects Save button
    Then Save button is available and Consultation Request/ Response is saved
    When User selects Print Preview button
    Then Consultation Request/ Response Print preview window pops up
    And Selected Letterhead should populate in FROM section
    
  @ConsultationPatientDetailsSection
  Scenario: Consultation Response/ Request Patient Details Section
  	When User navigates to Consultation Response/Request Patient Details Section
  	Then Consultation Response/ Request Patient Details section should show all required Patient Information
  	When User selects Print Preview button
  	Then Consultation Request/ Response Print preview window pops up
  	And Consult Response/ Request Patient Details Section display all required Patient Information
    

  	
  