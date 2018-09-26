package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PatientSearchResultsPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//input[@title='Search active patients']")
	static WebElement searchButton;
	
	@FindBy(how = How.LINK_TEXT, using = "E")
	static WebElement encounterPageLink;

	
	public PatientSearchResultsPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void user_searches_for_active_patients() {
		searchButton.click();
	}
	
	public void user_navigates_to_encounter_page() {
		encounterPageLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
}
