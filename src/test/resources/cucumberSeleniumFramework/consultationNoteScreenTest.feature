#Author: Harsh Jain
#Email: harshjain@uvic.ca
@ConsultationNoteScreenFunctionality
Feature: Consultation Note Screen functionality

  @1.0TestConsultationResponseRequestLetterhead
  Scenario: 1.0 Test Consultation Response/ Request Letterhead Defaults to the Logged in User
    When New Consult Note is started  
    Then Default letterhead selection should be for the current Oscar user logged-in
    When User selects letterhead dropdown
    Then User should be able to select other letterhead name
    When User selects Save button
    Then Save button is available and Consultation Request/ Response is saved
    When User selects Print Preview button and navigates to Print Preview screen - after saving consultation request
    Then Selected Letterhead should populate in FROM section
    
  @1.1ConsultationPatientDetailsSection
  Scenario: 1.1 Consultation Response/ Request Patient Details Section
  	When User navigates to Consultation Response/Request Screen
  	Then Consultation Response/ Request Patient Details section should show all required Patient Information
  	When User clicks on Print Preview button and navigates to Print Preview screen	
  	And Consult Response/ Request Patient Details Section display all required Patient Information
    
  @1.2TestFieldsInConsultationResponseNoteSection
  Scenario: 1.2 Test Fields to Appear in Consultation Response Note Section
  	When User navigates to Consultation Response/Request Screen
#  	Examination, Impression and Plan are not available - hence only checking Appointment Notes
  	Then Appointment Notes field is available in Consultation Response/Request Screen
  	When User enters text in Appointment Notes field and click Update Consultation Request button
  	Then Appointment Notes field accepts text and Consultation Request is saved
  	
  @1.3TestFieldsInConsultationResponseNoteSection
  Scenario: 1.3 Test Fields to Appear in Consultation Request/ Response Note Section
  	When User navigates to Consultation Response/Request Screen from Encounter page
  	Then Text fields should appear in the Consultation Request/ Response Note section
  	When User verifies Pertinent Clinical Information functional buttons
    Then Pertinent Clinical Information functional buttons should be available
    When User selects  Pertinent Clinical Information functional buttons
    Then Patient chart data should be added to the Pertinent Clinical Information Consult Note text field
    And User should be able to edit Pertinent Clinical Information text before saving Consultation Note
    When User verifies that Other Meds button is available in Current Medications Section
    Then Other Meds button should be available in Current Medications Section
    When User selects  Current Medications functional buttons
    Then Patient chart data should be added to the Current Medications Consult Note text field
    And User should be able to edit Current Medication text before saving Consultation Note
  	When User verifies Significant Concurrent Problems functional buttons
    Then Significant Concurrent Problems functional buttons should be available
    When User selects  Significant Concurrent Problems functional buttons
    Then Patient chart data should be added to the Significant Concurrent Problems Consult Note text field
    And User should be able to edit Significant Concurrent Problems text before saving Consultation Note
    When User selects Save button
    Then Save button is available and Consultation Request/ Response is saved
    When User selects Print Preview button and navigates to Print Preview screen - after saving consultation request
    Then Consultation Request/ Response Note sections display saved records
    
    
    
    
    
  	
  	

  