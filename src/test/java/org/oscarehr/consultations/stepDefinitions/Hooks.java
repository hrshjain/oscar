package org.oscarehr.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.LoginPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public Hooks(){
		loginPage = testContext.getPageObjectManager().loginPage();
	}
	
	
	@Before(order=0)
	public void user_logs_into_oscar_emr() {
		//launch Firefox browser and add implicit wait
		loginPage.login_into_oscar_emr();
		loginPage.click_on_schedule();
	}
	
	
	@After
	public void closeAllWindows() {
		//Close all browser instances
		testContext.getWebDriverManager().closeDriver();
	}
}

