package org.oscarehr.consultations.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
		
		//launch Firefox browser
		System.setProperty("webdriver.gecko.driver","/Users/hjain/code/geckodriver");
		WebDriver driver = new FirefoxDriver();
    	
        // launch Fire fox and direct it to the Base URL
        String baseUrl = "https://localhost:8442/oscar";
        driver.get(baseUrl);

        //Get web element for username, password and pin
        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement pin = driver.findElement(By.name("pin"));
        
        //Enter values for the web element and press enter
        username.sendKeys("oscardoc");
        password.sendKeys("LEADlab!");
        pin.sendKeys("1117");
        pin.sendKeys(Keys.RETURN);
        
        //Click on schedule tab to navigate to Appointment access page
	    try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    WebElement schedule = driver.findElement(By.xpath("//a[@class='ng-scope ng-binding'][contains(text(),'Schedule')]"));
	    schedule.click();
        
	}

	@Then("^Default letterhead selection should be for the current Oscar user logged-in$")
	public void default_letterhead_selection_should_be_for_the_current_Oscar_user_logged_in(){
		
	}
}
