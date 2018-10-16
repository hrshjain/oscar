package org.oscarehr.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.enums.Context;
import org.oscarehr.consultations.pageObjects.AppointmentAccessPage;
import org.oscarehr.consultations.pageObjects.LoginPage;
import org.oscarehr.consultations.pageObjects.OscarConsultationRequestPage;
import org.oscarehr.consultations.pageObjects.PatientDetailInfoPage;
import org.oscarehr.consultations.pageObjects.PatientSearchResultsPage;
import org.oscarehr.consultations.pageObjects.PrintPreviewPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	TestContext testContext;
	LoginPage loginPage;
	AppointmentAccessPage appointmentAccessPage;
	PatientSearchResultsPage patientSearchResultsPage;
	PatientDetailInfoPage patientDetailInfoPage;
	OscarConsultationRequestPage oscarConsultationRequestPage;
	ViewConsultationRequestsPage viewConsultationRequestsPage;
	PrintPreviewPage printPreviewPage;
	
	public ConsultationNoteScreenSteps(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().loginPage();
		appointmentAccessPage = testContext.getPageObjectManager().appointmentAccessPage();
		patientSearchResultsPage = testContext.getPageObjectManager().patientSearchResultsPage();
		patientDetailInfoPage = testContext.getPageObjectManager().patientDetailInfoPage();
		oscarConsultationRequestPage = testContext.getPageObjectManager().oscarConsultationRequestPage();
		viewConsultationRequestsPage = testContext.getPageObjectManager().viewConsultationRequestsPage();
		printPreviewPage = testContext.getPageObjectManager().printPreviewPage();
	}
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
		//Navigate from Appointment Access Page to PatientSearchResultsPage
		appointmentAccessPage.user_navigates_to_patient_search_results_page();
		
		//User selects Patient record and navigates to Patient Detail Info Page
		patientSearchResultsPage.user_searches_for_active_patients();
		patientSearchResultsPage.user_selects_Patient_Demographic_and_navigates_to_Patient_Details_Info_Page();

		//Navigate to Consultations Page
		patientDetailInfoPage.click_on_Consultations_and_navigate_to_ViewConsultationRequests_Page();
		
		//Get current window handle
		testContext.scenarioContext.setContext(Context.VIEW_CONSULTATION_REQUEST_PAGE_HANDLE, viewConsultationRequestsPage.get_current_window_handle());
        
        //Click on New Consultation to start new consultation
        viewConsultationRequestsPage.user_starts_new_consultation();
        
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
		oscarConsultationRequestPage.user_navigates_to_given_window_handle((String)testContext.scenarioContext.getContext(Context.VIEW_CONSULTATION_REQUEST_PAGE_HANDLE));
		viewConsultationRequestsPage.user_refreshes_the_page();
	}
	
	@When("^User clicks on Print Preview button and navigates to Print Preview screen$")
	public void user_selects_Print_Preview_button() {
		viewConsultationRequestsPage.user_selects_latest_consultation_record();
		oscarConsultationRequestPage.user_clicks_Print_Preview_button_and_navigates_to_print_preview();
	}

	@Then("^Selected Letterhead should populate in FROM section$")
	public void selected_Letterhead_should_populate_in_FROM_section() {
		printPreviewPage.selected_Letterhead_should_populate_in_FROM_section();
	}
	
	@When("^User navigates to Consultation Response/Request Screen$")
	public void user_navigates_to_Consultation_Response_Request_Patient_Details_Section() {
		oscarConsultationRequestPage.user_navigates_to_given_window_handle((String)testContext.scenarioContext.getContext(Context.VIEW_CONSULTATION_REQUEST_PAGE_HANDLE));
		viewConsultationRequestsPage.user_selects_latest_consultation_record();
	}

	@Then("^Consultation Response/ Request Patient Details section should show all required Patient Information$")
	public void consultation_Response_Request_Patient_Details_section_should_show_all_required_Patient_Information() {
		oscarConsultationRequestPage.verify_required_patient_information();
	}
	

	@Then("^Consult Response/ Request Patient Details Section display all required Patient Information$")
	public void consult_Response_Request_Patient_Details_Section_display_all_required_Patient_Information() {
		printPreviewPage.verify_required_patient_information();
	}
	
	@Then("^Appointment Notes field is available in Consultation Response/Request Screen$")
	public void appointment_Notes_field_is_available_in_Consultation_Response_Request_Screen() {
		oscarConsultationRequestPage.verify_Appointment_Notes_field_is_available();
	}

	@When("^User enters text in Appointment Notes field and click Update Consultation Request button$")
	public void user_enters_text_in_Appointment_Notes_field_and_click_Update_Consultation_Request_button() {
		oscarConsultationRequestPage.user_enters_text_in_Appointment_Notes_field();
		oscarConsultationRequestPage.user_clicks_on_Update_Consultation_Request();
	}

	@Then("^Appointment Notes field accepts text and Consultation Request is saved$")
	public void appointment_Notes_field_accepts_text_and_Consultation_Request_is_saved() {
		oscarConsultationRequestPage.consultation_request_is_saved();
	}
	
	@Then("^Text fields should appear in the Consultation Request/ Response Note section$")
	public void text_fields_should_appear_in_the_Consultation_Request_Response_Note_section() {
		oscarConsultationRequestPage.text_fields_information_present();
	}
	
	@When("^User verifies Pertinent Clinical Information functional buttons$")
	public void user_verifies_Pertinent_Clinical_Information_functional_buttons() {
	    // Write code here that turns the phrase above into concrete actions
	}
	
	@Then("^Pertinent Clinical Information functional buttons should be available$")
	public void pertinent_Clinical_Information_functional_buttons_should_be_available() {
		oscarConsultationRequestPage.pertinent_Clinical_Information_functional_buttons_available();
	}


}
