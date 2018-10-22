package org.oscarehr.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.AppointmentAccessPage;
import org.oscarehr.consultations.pageObjects.EncounterPage;
import org.oscarehr.consultations.pageObjects.LoginPage;
import org.oscarehr.consultations.pageObjects.PatientDetailInfoPage;
import org.oscarehr.consultations.pageObjects.PatientSearchResultsPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

//import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	TestContext testContext;
	LoginPage loginPage;
	AppointmentAccessPage appointmentAccessPage;
	PatientSearchResultsPage patientSearchResultsPage;
	EncounterPage encounterPage;
	PatientDetailInfoPage patientDetailInfoPage;
	ViewConsultationRequestsPage viewConsultationRequestsPage;
	
	public Hooks(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().loginPage();
		appointmentAccessPage = testContext.getPageObjectManager().appointmentAccessPage();
		patientSearchResultsPage = testContext.getPageObjectManager().patientSearchResultsPage();
		encounterPage = testContext.getPageObjectManager().encounterPage();
	}
	
	@Before(order=0)
	public void user_logs_into_oscar_emr() {
        //Start Browser and enter Enter Login credentials
        loginPage.login_into_oscar_emr();
        
        // Click on schedule Option
        loginPage.click_on_schedule();
	}
	
	@Before("@1.3TestFieldsInConsultationResponseNoteSection")
	public void add_cpp_notes_to_patient_echart() {
		
		//Add CPP notes and close webdriver manager
		appointmentAccessPage.user_navigates_to_patient_search_results_page();
		patientSearchResultsPage.user_searches_for_active_patients();
		patientSearchResultsPage.user_navigates_to_encounter_page();
		encounterPage.add_cpp_notes_to_patient_echart();
	}
	
	
//	@After
//	public void closeAllWindows() {
//		testContext.getWebDriverManager().closeDriver();
//	}
}

