//package org.oscarehr.consultations.stepDefinitions;
//
//import org.oscarehr.consultations.cucumber.TestContext;
//import org.oscarehr.consultations.pageObjects.AppointmentAccessPage;
//import org.oscarehr.consultations.pageObjects.EncounterPage;
//import org.oscarehr.consultations.pageObjects.LoginPage;
//import org.oscarehr.consultations.pageObjects.PatientSearchResultsPage;
//
//import cucumber.api.java.Before;
//
//public class Hooks {
//	
//	TestContext testContext;
//	LoginPage loginPage;
//	AppointmentAccessPage appointmentAccessPage;
//	PatientSearchResultsPage patientSearchResultsPage;
//	EncounterPage encounterPage;
//	
//	public Hooks(TestContext context) {
//		testContext = context;
//		loginPage = testContext.getPageObjectManager().loginPage();
//		appointmentAccessPage = testContext.getPageObjectManager().appointmentAccessPage();
//		patientSearchResultsPage = testContext.getPageObjectManager().patientSearchResultsPage();
//		encounterPage = testContext.getPageObjectManager().encounterPage();
//	}
//	
//	@Before(order=0)
//	public void user_logs_into_oscar_emr() {
//        //Start Browser and enter Enter Login credentials
//        loginPage.login_into_oscar_emr();
//
//        //Other selenium methods to wait for page load  until visibility of elements
//        //did not work to resolve the unexpected pop-up after clicking Schedule option       
//        try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        
//        // Click on schedule Option
//        loginPage.click_on_schedule();
//	}
//	
//	@Before("@1.3TestFieldsInConsultationResponseNoteSection")
//	public void add_cpp_notes_to_patient_echart() {
//		appointmentAccessPage.user_navigates_to_patient_search_results_page();
//		patientSearchResultsPage.user_searches_for_active_patients();
//		patientSearchResultsPage.user_navigates_to_encounter_page();
//		encounterPage.add_cpp_notes_to_patient_echart();
//	}
//	
//	
////	@After
////	public void closeAllWindows() {
////		testContext.getWebDriverManager().closeDriver();
////	}
//}
//
