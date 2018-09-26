package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EncounterPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//td[@class='MainTableRightColumn']/table/tbody/tr[2]/td[1]/table/tbody/tr[last()]/td[2]/a")
	static WebElement latestConsultationRequest;
	
	public EncounterPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void add_cpp_notes_to_patient_echart() {
		
	}

}
