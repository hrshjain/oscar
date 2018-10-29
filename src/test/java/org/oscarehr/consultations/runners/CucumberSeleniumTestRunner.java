package org.oscarehr.consultations.runners;

import java.io.File;

import org.junit.AfterClass;


import org.junit.runner.RunWith;
import org.oscarehr.consultations.managers.FileReaderManager;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
			    features = "src/test/resources/cucumberSeleniumFramework/consultationNoteScreenTest.feature",
			    glue =  "org.oscarehr.consultations.stepDefinitions",
			    plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html" },
				monochrome = true
				)

public class CucumberSeleniumTestRunner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}

