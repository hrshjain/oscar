package org.oscarehr.consultations.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OscarConsultationRequestPage {
	
	WebDriver driver;
	static String viewConsultationnRequestsWindow;
	
	public OscarConsultationRequestPage(WebDriver driver) {
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
	
	@FindBy(how = How.XPATH, using = "//select[@id='letterheadName']//option[@selected='selected']")
	static WebElement letterheadDefault;
	
	@FindBy(how = How.NAME, using = "letterheadName")
	static WebElement letterhead;
	
	@FindBy(how = How.NAME, using = "service")
	static WebElement service;
	
	@FindBy(how = How.NAME, using = "submitSaveOnly")
	static WebElement submitButton;
	
	@FindBy(how = How.NAME, using = "printPreview")
	static WebElement printPreview;
	
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Close")
	static WebElement closeConsultationWindow;
	
	@FindBy(how = How.XPATH, using = "//div[@class='textLayer']//div[1]")
	static WebElement fromSectionLetterhead;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Patient:')]")
	static WebElement patientLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[1]//td[2]")
	static WebElement patientName;
	
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
        
        
        
        
        consultationsLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void start_new_consultation() {
		//Save window handle to navigate back after submitting consultation
		viewConsultationnRequestsWindow = driver.getWindowHandle();
				
		//Start new consultation and navigate to new window
		newConsultationLink.click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void verify_default_letterhead_selection() {
		Assert.assertEquals(letterheadDefault.getText(),"oscardoc, doctor");
	}
	
	public void user_navigates_to_letterhead() {
		
	}
	
	public void user_selects_other_letterhead() {
		Select drpLetterhead = new Select(letterhead);
		drpLetterhead.selectByIndex(0);
	}
	
	public void user_submits_consultation_request() {
		//user selects a service
		Select drpService = new Select(service);
		drpService.selectByIndex(1);
		
		//user click on submit button
		submitButton.click();
	}
	
	public void consultation_request_is_saved() {
		Assert.assertTrue(driver.getTitle().contains("Confirm Consultation"));
		
		//user now closes the window
		closeConsultationWindow.click();
	}
	
	public void user_navigates_to_view_consultation_requests_page() {
		driver.switchTo().window(viewConsultationnRequestsWindow);
	}
	
	public void user_clicks_Print_Preview_button() {
		//click on print preview
		printPreview.click();
	}
	
	public void user_navigates_to_print_preview() {
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void selected_Letterhead_should_populate_in_FROM_section() {
		Assert.assertEquals("McMaster Hospital",fromSectionLetterhead.getText());
	}
	
	public void verify_required_patient_information() {
		
		//Full Patient name
		Assert.assertTrue(patientLabel.isDisplayed());
		Assert.assertEquals(patientName.getText(),"");
		
		

//		• Date of birth
//		• Sex
//		• Health card number 
//		• Address
//		• Home Phone (s)
//		• Work Phone (s)		
//		• email
		
	}

}
