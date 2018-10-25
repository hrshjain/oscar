package org.oscarehr.consultations.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.oscarehr.consultations.cucumber.TestContext;
import org.oscarehr.consultations.managers.FileReaderManager;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	TestContext testContext;
	WebDriver driver;
	
	public ConsultationNoteScreenSteps(TestContext context) {
		testContext = context;
		driver = testContext.getWebDriverManager().getDriver();
	}
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
	    //Click on search tab and navigate to Patient Search Results page
	    driver.findElement(By.xpath("//a[@title='Search for patient records']")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	    
	    //Click on search button to list demographic patient records
	    driver.findElement(By.xpath("//input[@title='Search active patients']")).click();
	    
	    //Click on Patient Demographic Record Id and navigate to new window
	    WebElement demographicLink = driver.findElement(By.xpath("//a[@title='Master Demographic File']"));
        demographicLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        
	    //Click on Consultations and navigate to new window
        WebElement consultationsLink = driver.findElement(By.linkText("Consultations"));
        consultationsLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        
	    //Click on New Consultation link and navigate to new window
        WebElement newConsultationLink = driver.findElement(By.partialLinkText("New Consultation"));
        newConsultationLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		
        
	}

	@Then("^Default letterhead selection should be for the current Oscar user logged-in$")
	public void default_letterhead_selection_should_be_for_the_current_Oscar_user_logged_in(){
		//Verify letterhead is equal to current logged in user
		WebElement letterheadDefault = driver.findElement(By.xpath("//select[@id='letterheadName']//option[@selected='selected']"));
		Assert.assertEquals(letterheadDefault.getText(),FileReaderManager.getInstance().getConfigReader().getOscarUsername() + ", doctor");
	}
}
