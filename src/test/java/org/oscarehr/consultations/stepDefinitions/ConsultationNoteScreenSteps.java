package org.oscarehr.consultations.stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ConsultationNoteScreenSteps {
	
	WebDriver driver;
	
	@When("^New Consult Note is started$")
	public void new_Consult_Note_is_started() {
		
		//launch Firefox browser and add implicit wait
		System.setProperty("webdriver.gecko.driver","/Users/harshjain/code/geckodriver");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	
        //Navigate to firefox browser
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
		WebElement letterheadDefault = driver.findElement(By.xpath("//select[@id='letterheadName']//option[@selected='selected']"));
		Assert.assertEquals(letterheadDefault.getText(),"oscardoc, doctor");
	}
}
