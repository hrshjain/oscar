package org.oscarehr.integration.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.OscarConsultationRequestPage;
import org.oscarehr.consultations.pageObjects.PrintPreviewPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	TestContext testContext;
	OscarConsultationRequestPage oscarConsultationRequestPage;
	ViewConsultationRequestsPage viewConsultationRequestsPage;
	PrintPreviewPage printPreviewPage;
	
	public ConsultationNoteScreenSteps(TestContext context) {
		testContext = context;
		oscarConsultationRequestPage = testContext.getPageObjectManager().oscarConsultationRequestPage();
		viewConsultationRequestsPage = testContext.getPageObjectManager().viewConsultationRequestsPage();
		printPreviewPage = testContext.getPageObjectManager().printPreviewPage();
	}
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
		//Navigate to Consultations Page
		oscarConsultationRequestPage.navigate_to_consultations_page();
		
		//Click on New Consultation link
        oscarConsultationRequestPage.start_new_consultation();
	}

	@Then("^Default letterhead selection should be for the current Oscar user logged-in$")
	public void default_letterhead_selection_should_be_for_the_current_Oscar_user_logged_in() {
	    // Verify letterhead value
		oscarConsultationRequestPage.verify_default_letterhead_selection();
	}
	
	@When("^User selects letterhead dropdown$")
	public void user_selects_letterhead_dropdown() {
		oscarConsultationRequestPage.user_navigates_to_letterhead();
	}

	@Then("^User should be able to select other letterhead name$")
	public void user_should_be_able_to_select_other_letterhead_name() {
		oscarConsultationRequestPage.user_selects_other_letterhead();
	}

	
	@When("^User selects Save button$")
	public void user_selects_Save_button() {
		oscarConsultationRequestPage.user_submits_consultation_request();
	}

	@Then("^Save button is available and Consultation Request/ Response is saved$")
	public void save_button_is_available_and_Consultation_Request_Response_is_saved() {
		oscarConsultationRequestPage.consultation_request_is_saved();
		oscarConsultationRequestPage.user_navigates_to_view_consultation_requests_page();
		viewConsultationRequestsPage.user_refreshes_the_page();
	}
	
	@When("^User selects Print Preview button$")
	public void user_selects_Print_Preview_button() {
		viewConsultationRequestsPage.user_selects_latest_consultation_record();
		oscarConsultationRequestPage.user_clicks_Print_Preview_button();
	}

	@Then("^Consultation Request/ Response Print preview window pops up$")
	public void consultation_Request_Response_Print_preview_window_pops_up() {
		oscarConsultationRequestPage.user_navigates_to_print_preview();
	}

	@Then("^Selected Letterhead should populate in FROM section$")
	public void selected_Letterhead_should_populate_in_FROM_section() {
		oscarConsultationRequestPage.selected_Letterhead_should_populate_in_FROM_section();
	}
	
	@When("^User navigates to Consultation Response/Request Patient Details Section$")
	public void user_navigates_to_Consultation_Response_Request_Patient_Details_Section() {
		oscarConsultationRequestPage.navigate_to_consultations_page();
		viewConsultationRequestsPage.user_selects_latest_consultation_record();
	}

	@Then("^Consultation Response/ Request Patient Details section should show all required Patient Information$")
	public void consultation_Response_Request_Patient_Details_section_should_show_all_required_Patient_Information() {
		oscarConsultationRequestPage.verify_required_patient_information();
	}
	
	@When("^User clicks on Print Preview button$")
	public void user_clicks_on_Print_Preview_button() {
		oscarConsultationRequestPage.user_clicks_Print_Preview_button();
	}

	@Then("^Consult Response/ Request Patient Details Section display all required Patient Information$")
	public void consult_Response_Request_Patient_Details_Section_display_all_required_Patient_Information() {
		printPreviewPage.verify_required_patient_information();
	}


}
