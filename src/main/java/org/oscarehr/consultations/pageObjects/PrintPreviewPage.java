package org.oscarehr.consultations.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.oscarehr.consultations.managers.FileReaderManager;


public class PrintPreviewPage {
	
	WebDriver driver;
	static String viewConsultationnRequestsWindow;
	
	public PrintPreviewPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(15)")
	static WebElement patientLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(16)")
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
	
	
	public void verify_required_patient_information() {
		
		//Full Patient name
		Assert.assertTrue(patientLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getpatientLastName() +
							", " + FileReaderManager.getInstance().getConfigReader().getpatientFirstName(), 
							patientName.getText());
//		//Date of Birth
//		Assert.assertTrue(birthDateLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getyearOfBirth() + "-"
//				         +  FileReaderManager.getInstance().getConfigReader().getmonthOfBirth() + "-"
//				         +  FileReaderManager.getInstance().getConfigReader().getdayOfBirth()
//				, birthDate.getText());
//		
//		//Sex
//		Assert.assertTrue(sexLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getsex(), sex.getText());
//		
//		//HealthCardNumber
//		Assert.assertTrue(healthCardLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethealthCardNumber() + "  "
//				          + FileReaderManager.getInstance().getConfigReader().gethealthCardType()
//				        , healthCardNumber.getText());
//		
//		//Address
//		Assert.assertTrue(healthCardLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethealthCardNumber() + "  "
//				          + FileReaderManager.getInstance().getConfigReader().gethealthCardType()
//				        , healthCardNumber.getText());
//		
//		//Phone - Home and Work
//		Assert.assertTrue(homePhoneLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethomePhone(), homePhoneNumber.getText());
//		
//		Assert.assertTrue(workPhoneLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getworkPhone(), workPhoneNumber.getText());
//		
//		//Address
//		Assert.assertTrue(addressLabel.isDisplayed());
//		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getaddress(), address.getText());
		

		
	}

}
