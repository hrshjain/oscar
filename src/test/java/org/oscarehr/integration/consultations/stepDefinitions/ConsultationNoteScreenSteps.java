package org.oscarehr.integration.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.NewConsultationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	TestContext testContext;
	NewConsultationPage newConsultationPage;
	
	public ConsultationNoteScreenSteps(TestContext context) {
		testContext = context;
		newConsultationPage = testContext.getPageObjectManager().newConsultationPage();
	}
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
		//Navigate to Consultations Page
		newConsultationPage.navigate_to_consultations_page();
		
		//Click on New Consultation link
        newConsultationPage.start_new_consultation();
	}

	@Then("^Default letterhead selection should be for the current Oscar user logged-in$")
	public void default_letterhead_selection_should_be_for_the_current_Oscar_user_logged_in() {
	    // Verify letterhead value
		newConsultationPage.verify_default_letterhead_selection();
	}
	
	@When("^User selects Save button$")
	public void user_selects_Save_button() {
	    // Write code here that turns the phrase above into concrete actions
		newConsultationPage.user_submits_consultation_request();
	}

	@Then("^Save button is available and Consultation Request/ Response is saved$")
	public void save_button_is_available_and_Consultation_Request_Response_is_saved() {
	    // Write code here that turns the phrase above into concrete actions
	    
	}


}
