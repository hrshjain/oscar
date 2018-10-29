package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PatientDetailInfoPage {
	
	WebDriver driver;
	@FindBy(how = How.LINK_TEXT, using = "Consultations")
	static WebElement consultationsLink;
	
	public PatientDetailInfoPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void click_on_Consultations_and_navigate_to_ViewConsultationRequests_Page() {
        consultationsLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
}
