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

  @ConsultationResponseRequestScreenPresent
  Scenario: Consultation Response/ Request Letterhead should default to the logged-in user
    When New Consult Note is started  
    Then Default letterhead selection should be for the current Oscar user logged-in
    
  @AbilitytoSelectLetterheads
  Scenario: Ability to select other Letterheads selection
    When User selects letterhead dropdown
    Then User should be able to select other letterhead name
    
  @AbilitytoSaveConsultation
  Scenario: Ability to select other Letterheads selection
    When User selects Save button
    Then Save button is available and Consultation Request/ Response is saved
    
  @AbilitytoDisplayPrintPreview
  Scenario: Ability to display Consultation Response/ Request print preview screen
    When User selects Print Preview button
    Then Consultation Request/ Response Print preview window pops up
    And Selected Letterhead should populate in FROM section
    
 # @tag3
 # Scenario: Consultation Response/ Request Letterhead Defaults to the Logged in User