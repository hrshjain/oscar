package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewConsultationPage {
	
	WebDriver driver;
	
	public NewConsultationPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "New Consultation")
	static WebElement newConsultationLink;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Search for patient records']")
	static WebElement searchTab;
	
	@FindBy(how = How.XPATH, using = "//input[@title='Search active patients']")
	static WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Master Demographic File']")
	static WebElement demographicLink;
	
	@FindBy(how = How.LINK_TEXT, using = "Consultations")
	static WebElement consultationsLink;
	
	public void navigate_to_consultations_page() {
		//Click on search tab and navigate to new window
		WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.visibilityOf(searchTab));		
        searchTab.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        
        //Click on search button
        searchButton.click();
        
        //Click on Patient Demographic Record Id and navigate to new window
        demographicLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        
        //Click on Consultations link and navigate to new window
        consultationsLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void start_new_consultation() {
		newConsultationLink.click();
	}

}
