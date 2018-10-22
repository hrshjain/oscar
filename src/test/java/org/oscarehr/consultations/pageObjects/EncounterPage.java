package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.oscarehr.consultations.managers.FileReaderManager;

public class EncounterPage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//div[@id='FamHistory']//div//a[@title='Add Item'][contains(text(),'+')]")
	static WebElement addFamilyHistoryButton;
	
	@FindBy(how = How.XPATH, using = "//div[@id='OMeds']//div//a[@title='Add Item'][contains(text(),'+')]")
	static WebElement addOtherMedsButton;
	
	@FindBy(how = How.XPATH, using = "//textarea[@id='noteEditTxt']")
	static WebElement notesToEdit;
	
	@FindBy(how = How.XPATH, using = "//form[@id='frmIssueNotes']//input[@title='Sign & Save']")
	static WebElement signAndSaveButton;
	
	@FindBy(how = How.XPATH, using = "//a[@title='Master Record']")
	static WebElement patientDetailInfoLink;
	
	public EncounterPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	public void add_cpp_notes_to_patient_echart() {
		
		//Accept Alert if it pops ups
		try {
		WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		} catch (TimeoutException ex) {
	        // Alert not present
	        ex.printStackTrace();
	    }

		//Wait for page load to complete
       try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

       //Add Family History CPP Note
		addFamilyHistoryButton.click();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		notesToEdit.sendKeys(FileReaderManager.getInstance().getConfigReader().getsampleChartData());
		signAndSaveButton.click();
		
		//Wait for page load to complete
	       try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		//Add Other Meds CPP Note
		addOtherMedsButton.click();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
		notesToEdit.sendKeys(FileReaderManager.getInstance().getConfigReader().getsampleChartData());
		signAndSaveButton.click();
	}
	
	public void navigate_to_patient_info_page() {
		patientDetailInfoLink.click();
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}	
}
