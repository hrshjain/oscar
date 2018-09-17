package org.oscarehr.integration.consultations.stepDefinitions;

import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.pageObjects.LoginPage;

import cucumber.api.java.Before;

public class Hooks {
	
	TestContext testContext;
	LoginPage loginPage;
	
	public Hooks(TestContext context) {
		testContext = context;
		loginPage = testContext.getPageObjectManager().loginPage();
	}
	
	@Before
	public void user_logs_into_oscar_emr() {
        //Start Browser and enter Enter Login credentials
        loginPage.login_into_oscar_emr();

        //Other selenium methods to wait for page load  until visibility of elements
        //did not work to resolve the unexpected pop-up after clicking Schedule option       
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // Click on schedule Option
        loginPage.click_on_schedule();
	}
	
//	@After
//	public void closeAllWimndows() {
//		testContext.getWebDriverManager().closeDriver();
//	}
	
//	@After("@ConsultationResponseRequestScreenPresent")
//	public void user_quits_web_driver() {
//		driver.close();
//		driver.quit();
//	}
}

