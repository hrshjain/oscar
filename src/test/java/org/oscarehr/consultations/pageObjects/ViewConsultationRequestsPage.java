package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ViewConsultationRequestsPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//td[@class='MainTableRightColumn']/table/tbody/tr[2]/td[1]/table/tbody/tr[last()]/td[2]/a")
	static WebElement latestConsultationRequest;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "New Consultation")
	static WebElement newConsultationLink;
	
	public ViewConsultationRequestsPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void user_refreshes_the_page() {
		driver.navigate().refresh();
	}

	public void user_selects_latest_consultation_record() {
		latestConsultationRequest.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void user_starts_new_consultation() {		
		//Start new consultation and navigate to new window
		newConsultationLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public String get_current_window_handle() {
		return driver.getWindowHandle();
	}

}
