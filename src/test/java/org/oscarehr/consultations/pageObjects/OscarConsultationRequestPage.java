package org.oscarehr.consultations.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.oscarehr.consultations.managers.FileReaderManager;

public class OscarConsultationRequestPage {
	
	WebDriver driver;
	
	public OscarConsultationRequestPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[@title='Search for patient records']")
	static WebElement searchTab;
	
	@FindBy(how = How.XPATH, using = "//input[@title='Search active patients']")
	static WebElement searchButton;
	
	@FindBy(how = How.XPATH, using = "//select[@id='letterheadName']//option[@selected='selected']")
	static WebElement letterheadSelected;
	
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
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Patient:')]")
	static WebElement patientLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[1]//td[2]")
	static WebElement patientName;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Birthdate:')]")
	static WebElement birthDateLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[6]//td[2]")
	static WebElement birthDate;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Sex:')]")
	static WebElement sexLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[7]//td[2]")
	static WebElement sex;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Health Card No.:')]")
	static WebElement healthCardLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[8]//td[2]")
	static WebElement healthCardNumber;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Tel.No.:')]")
	static WebElement homePhoneLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[3]//td[2]")
	static WebElement homePhoneNumber;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Work No.:')]")
	static WebElement workPhoneLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[4]//td[2]")
	static WebElement workPhoneNumber;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Address:')]")
	static WebElement addressLabel;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='consultDemographicData']//td[@class='tite4']//tbody//tr[2]//td[2]")
	static WebElement address;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Appointment Notes:')]")
	static WebElement appointmentNotesLabel;
	
	@FindBy(how = How.XPATH, using = "//textarea[@name='appointmentNotes']")
    static WebElement appointmentNotes;
	
	@FindBy(how = How.CSS, using = "input[value='Update Consultation Request']")
    static WebElement updateConsultationRequestButton;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Reason for Consultation')]")
    static WebElement reasonforConsultationLabel;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Pertinent clinical information:')]")
    static WebElement pertinentCilinicalInformationLabel;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Significant concurrent problems:')]")
    static WebElement significantConcurrentPropblemsLabel;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Current Medications:')]")
    static WebElement currentMedicationsLabel;
	
	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Allergies:')]")
    static WebElement allergiesLabel;
	
	@FindBy(how = How.ID, using = "clinicalInformation")
    static WebElement clinicalInformationTextArea;
	
	@FindBy(how = How.XPATH, using = "//td[@id='clinicalInfoButtonBar']//input[@value='Family History']")
    static WebElement clinicalInfoFamilyHistoryButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='clinicalInfoButtonBar']//input[@value='Medical History']")
    static WebElement clinicalInfoMedicalHistoryButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='clinicalInfoButtonBar']//input[@value='Ongoing Concerns']")
    static WebElement clinicalInfoOngoingConcernsButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='clinicalInfoButtonBar']//input[@value='Other Meds']")
    static WebElement clinicalInfoOtherMedsButton;
	
	@FindBy(how = How.CSS, using = "#btnReminders")
    static WebElement clinicalInfoRemindersButton;
	
	@FindBy(how = How.CSS, using = "#fetchRiskFactors_clinicalInformation")
    static WebElement clinicalInfoRiskFactorsButton;
	
	@FindBy(how = How.CSS, using = "#fetchMedications_clinicalInformation")
    static WebElement clinicalInfoMedicationsButton;
	
	@FindBy(how = How.CSS, using = "#fetchLongTermMedications_clinicalInformation")
    static WebElement clinicalInfoLongTermMedicationsButton;
	
	@FindBy(how = How.ID, using = "currentMedications")
    static WebElement currentMedicationsTextArea;
	
	@FindBy(how = How.XPATH, using = "//td[@id='medsButtonBar']//input[@value='Other Meds']")
    static WebElement currentMedicationsOtherMeds;
	
	@FindBy(how = How.ID, using = "concurrentProblems")
    static WebElement concurrentProblemsTextArea;
	
	@FindBy(how = How.XPATH, using = "//td[@id='concurrentProblemsButtonBar']//input[@value='Family History']")
    static WebElement concurrentProblemsFamilyHistoryButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='concurrentProblemsButtonBar']//input[@value='Medical History']")
    static WebElement concurrentProblemsMedicalHistoryButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='concurrentProblemsButtonBar']//input[@value='Ongoing Concerns']")
    static WebElement concurrentProblemsOngoingConcernsButton;
	
	@FindBy(how = How.XPATH, using = "//td[@id='concurrentProblemsButtonBar']//input[@value='Other Meds']")
    static WebElement concurrentProblemsOtherMedsButton;
	
	@FindBy(how = How.CSS, using = "#btnReminders2")
    static WebElement concurrentProblemsRemindersButton;
	
	@FindBy(how = How.CSS, using = "#fetchRiskFactors_concurrentProblems")
    static WebElement concurrentProblemsRiskFactorsButton;
	
	@FindBy(how = How.CSS, using = "#fetchMedications_concurrentProblems")
    static WebElement concurrentProblemsMedicationsButton;
	
	@FindBy(how = How.CSS, using = "#fetchLongTermMedications_concurrentProblems")
    static WebElement concurrentProblemsLongTermMedicationsButton;
	
	
	public void verify_default_letterhead_selection() {
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getOscarUsername() + ", doctor", letterheadSelected.getText());
	}
	
	public void user_navigates_to_letterhead() {
		
	}
	
	public void user_selects_other_letterhead() {
		Select drpLetterhead = new Select(letterhead);
		drpLetterhead.selectByIndex(0);
	}
	
	public String get_value_of_selected_letterhead() {
		return letterheadSelected.getText();
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
	
	public void user_navigates_to_given_window_handle(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	public void user_clicks_Print_Preview_button_and_navigates_to_print_preview() {
		//click on print preview
		printPreview.click();
		
		for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
	}
	
	public void verify_required_patient_information() {
		
		//Full Patient name
		Assert.assertTrue(patientLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getpatientLastName() +
							", " + FileReaderManager.getInstance().getConfigReader().getpatientFirstName(), 
							patientName.getText());
		//Date of Birth
		Assert.assertTrue(birthDateLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getyearOfBirth() + "-"
				         +  FileReaderManager.getInstance().getConfigReader().getmonthOfBirth() + "-"
				         +  FileReaderManager.getInstance().getConfigReader().getdayOfBirth()
				, birthDate.getText());
		
		//Sex
		Assert.assertTrue(sexLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getsex(), sex.getText());
		
		//HealthCardNumber
		Assert.assertTrue(healthCardLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethealthCardNumber() + "  "
				          + FileReaderManager.getInstance().getConfigReader().gethealthCardType()
				        , healthCardNumber.getText());
		
		//Address
		Assert.assertTrue(healthCardLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethealthCardNumber() + "  "
				          + FileReaderManager.getInstance().getConfigReader().gethealthCardType()
				        , healthCardNumber.getText());
		
		//Phone - Home and Work
		Assert.assertTrue(homePhoneLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethomePhone(), homePhoneNumber.getText());
		
		Assert.assertTrue(workPhoneLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getworkPhone(), workPhoneNumber.getText());
		
		//Address
		Assert.assertTrue(addressLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getaddress(), address.getText());
	}
	
	public void verify_Appointment_Notes_field_is_available() {
		Assert.assertTrue(appointmentNotesLabel.isDisplayed());
	}
	
	public void user_enters_text_in_Appointment_Notes_field() {
		appointmentNotes.sendKeys("Sample Appointment Note for QA Purpose");
	}
	
	public void user_clicks_on_Update_Consultation_Request() {
		updateConsultationRequestButton.click();
	}
	
	public void text_fields_information_present() {
		Assert.assertTrue(reasonforConsultationLabel.isDisplayed());
		Assert.assertTrue(pertinentCilinicalInformationLabel.isDisplayed());
		Assert.assertTrue(significantConcurrentPropblemsLabel.isDisplayed());
		Assert.assertTrue(currentMedicationsLabel.isDisplayed());
		Assert.assertTrue(allergiesLabel.isDisplayed());
	}
	
	public void pertinent_Clinical_Information_functional_buttons_available() {
		Assert.assertTrue(clinicalInfoFamilyHistoryButton.isDisplayed());
		Assert.assertTrue(clinicalInfoMedicalHistoryButton.isDisplayed());
		Assert.assertTrue(clinicalInfoOngoingConcernsButton.isDisplayed());
		Assert.assertTrue(clinicalInfoOtherMedsButton.isDisplayed());
		Assert.assertTrue(clinicalInfoRemindersButton.isDisplayed());
		Assert.assertTrue(clinicalInfoRiskFactorsButton.isDisplayed());
		Assert.assertTrue(clinicalInfoMedicationsButton.isDisplayed());
		Assert.assertTrue(clinicalInfoLongTermMedicationsButton.isDisplayed());
	}
	
	public void user_selects_clinicalInfoFamilyHistory_button() {
		clinicalInfoFamilyHistoryButton.click();
	}
	
	public void user_validates_patient_chart_data_added_in_clinicalInformation_textarea() {
		Assert.assertTrue(clinicalInformationTextArea.getAttribute("value").contains(FileReaderManager.getInstance().getConfigReader().getsampleChartData()));
	}
	
	public void user_is_able_to_edit_clinicalInformation_text() {
		clinicalInformationTextArea.clear();
		clinicalInformationTextArea.sendKeys(FileReaderManager.getInstance().getConfigReader().getsampleChartData());
	}
	
	public void other_meds_button_available_in_current_medications() {
		Assert.assertTrue(currentMedicationsOtherMeds.isDisplayed());
	}
	
	public void user_selects_current_medications_other_meds_button() {
		currentMedicationsOtherMeds.click();
	}
	
	public void user_validates_patient_chart_data_added_in_current_medications_textarea() {
		Assert.assertTrue(currentMedicationsTextArea.getAttribute("value").contains(FileReaderManager.getInstance().getConfigReader().getsampleChartData()));
	}
	
	public void user_is_able_to_edit_current_medications_text() {
		currentMedicationsTextArea.clear();
		currentMedicationsTextArea.sendKeys(FileReaderManager.getInstance().getConfigReader().getsampleChartData());
	}
	
	public void significant_concurrent_problems_functional_buttons_available() {
		Assert.assertTrue(concurrentProblemsFamilyHistoryButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsMedicalHistoryButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsOngoingConcernsButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsOtherMedsButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsRemindersButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsRiskFactorsButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsMedicationsButton.isDisplayed());
		Assert.assertTrue(concurrentProblemsLongTermMedicationsButton.isDisplayed());
	}
	
	public void user_selects_significant_concurrent_problems_family_history_button() {
		concurrentProblemsFamilyHistoryButton.click();
	}
	
	public void user_validates_patient_chart_data_added_in_significant_concurrent_problems_textarea() {
		Assert.assertTrue(concurrentProblemsTextArea.getAttribute("value").contains(FileReaderManager.getInstance().getConfigReader().getsampleChartData()));
	}
	
	public void user_is_able_to_edit_significant_concurrent_problems_text() {
		concurrentProblemsTextArea.clear();
		concurrentProblemsTextArea.sendKeys(FileReaderManager.getInstance().getConfigReader().getsampleChartData());
	}
	
}
