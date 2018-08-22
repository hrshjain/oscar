package org.oscarehr.integration.consultations.stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {
				   "src/test/resources/integration/ConsultationTest.feature"}
		)

public class IntegrationTestRunner {

}