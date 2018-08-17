package org.oscarehr.integration.consultations;

import org.openqa.selenium.WebDriver;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class ConsultationNoteScreenTest {

	static WebDriver driver;
	ConfigFileReader configFileReader;
	
	@Given("^User is logged into oscar-emr$")
	public void user_is_logged_into_oscar_emr() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User clicks on Search tab$")
	public void user_clicks_on_Search_tab() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^User clicks on Search button$")
	public void user_clicks_on_Search_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Atleast one demograohic patient record is displayed$")
	public void atleast_one_demograohic_patient_record_is_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
