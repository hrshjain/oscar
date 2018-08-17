package org.oscarehr.integration.consultations;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
//				   "src/test/resources/integration/LoginTest.feature",
				   "src/test/resources/integration/ConsultationTest.feature"}
		)

public class IntegrationTestRunner {

}