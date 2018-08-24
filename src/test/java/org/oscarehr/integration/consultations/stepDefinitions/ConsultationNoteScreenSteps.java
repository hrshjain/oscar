package org.oscarehr.integration.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.NewConsultationPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	TestContext testContext;
	NewConsultationPage newConsultationPage;
	ViewConsultationRequestsPage viewConsultationRequestsPage;
	
	public ConsultationNoteScreenSteps(TestContext context) {
		testContext = context;
		newConsultationPage = testContext.getPageObjectManager().newConsultationPage();
		viewConsultationRequestsPage = testContext.getPageObjectManager().viewConsultationRequestsPage();
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
	
	@When("^User selects letterhead dropdown$")
	public void user_selects_letterhead_dropdown() {
		newConsultationPage.user_navigates_to_letterhead();
	}

	@Then("^User should be able to select other letterhead name$")
	public void user_should_be_able_to_select_other_letterhead_name() {
		newConsultationPage.user_selects_other_letterhead();
	}

	
	@When("^User selects Save button$")
	public void user_selects_Save_button() {
		newConsultationPage.user_submits_consultation_request();
	}

	@Then("^Save button is available and Consultation Request/ Response is saved$")
	public void save_button_is_available_and_Consultation_Request_Response_is_saved() {
		newConsultationPage.consultation_request_is_saved();
	    
	}
	
	@When("^User selects Print Preview button$")
	public void user_selects_Print_Preview_button() {
		viewConsultationRequestsPage.user_selects_latest_consultation_record();
		newConsultationPage.user_clicks_Print_Preview_button();
	}

	@Then("^Consultation Request/ Response Print preview window pops up$")
	public void consultation_Request_Response_Print_preview_window_pops_up() {
		newConsultationPage.user_navigates_to_print_preview();
	}

	@Then("^Selected Letterhead should populate in FROM section$")
	public void selected_Letterhead_should_populate_in_FROM_section() {
		newConsultationPage.selected_Letterhead_should_populate_in_FROM_section();
	}


}
