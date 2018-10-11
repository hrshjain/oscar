package org.oscarehr.consultations.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/cucumberSeleniumFramework/consultationNoteScreenTest.feature",
		    glue =  "org.oscarehr.consultations.stepDefinitions"
		)

public class CucumberSeleniumTestRunner {

}
