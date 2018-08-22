package org.oscarehr.integration.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.NewConsultationPage;

import cucumber.api.PendingException;
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

	@When("^The default letterhead selection displays for the current Oscar user logged-in$")
	public void the_default_letterhead_selection_displays_for_the_current_Oscar_user_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Default letterhead selection should be for the current Oscar user logged-in$")
	public void default_letterhead_selection_should_be_for_the_current_Oscar_user_logged_in() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
