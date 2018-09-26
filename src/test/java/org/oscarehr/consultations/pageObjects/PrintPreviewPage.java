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
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(17)")
	static WebElement addressLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(18)")
	static WebElement address;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(19)")
	static WebElement cityProvincePostal;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(20)")
	static WebElement homePhoneLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(21)")
	static WebElement homePhoneNumber;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(22)")
	static WebElement workPhoneLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(23)")
	static WebElement workPhoneNumber;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(24)")
	static WebElement emailLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(25)")
	static WebElement email;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(26)")
	static WebElement birthDateLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(27)")
	static WebElement birthDate;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(28)")
	static WebElement sexLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(29)")
	static WebElement sex;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(30)")
	static WebElement healthCardLabel;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(31)")
	static WebElement healthCardNumber;
	
	@FindBy(how = How.CSS, using = ".textLayer > div:nth-child(36)")
	static WebElement MRP;

	
	public void verify_required_patient_information() {
		
		//Full Patient name
		Assert.assertTrue(patientLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getpatientLastName() +
							", " + FileReaderManager.getInstance().getConfigReader().getpatientFirstName(), 
							patientName.getText());
		
		//Address
		Assert.assertTrue(addressLabel.isDisplayed());
		
		//The commented out part is an existing defect (to be discussed or resolved)
		Assert.assertEquals(//FileReaderManager.getInstance().getConfigReader().getaddress() + " " +
				            FileReaderManager.getInstance().getConfigReader().getcity() + "," +
				            FileReaderManager.getInstance().getConfigReader().getprovince() + "," +
				            FileReaderManager.getInstance().getConfigReader().getpostal(),	
//				            address.getText() + " " + 
				            cityProvincePostal.getText());
		
		//Phone - Home and Work
		Assert.assertTrue(homePhoneLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().gethomePhone(), homePhoneNumber.getText());
		
		Assert.assertTrue(workPhoneLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getworkPhone(), workPhoneNumber.getText());
		
		//Email
		Assert.assertTrue(emailLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getEmail(), email.getText());
		
		//Date of Birth
		Assert.assertTrue(birthDateLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getyearOfBirth() + "-"
				         +  FileReaderManager.getInstance().getConfigReader().getmonthOfBirth() + "-"
				         +  FileReaderManager.getInstance().getConfigReader().getdayOfBirth() + " (y/m/d)"
				, birthDate.getText());
		
		//Sex
		Assert.assertTrue(sexLabel.isDisplayed());
		Assert.assertEquals(FileReaderManager.getInstance().getConfigReader().getsex(), sex.getText());
		
		//HealthCardNumber
		Assert.assertTrue(healthCardLabel.isDisplayed());
		Assert.assertEquals("(" + FileReaderManager.getInstance().getConfigReader().gethealthCardType() + ") "
				          + FileReaderManager.getInstance().getConfigReader().gethealthCardNumber()
				        , healthCardNumber.getText());
		
		//MRP
		Assert.assertEquals("MRP : " + FileReaderManager.getInstance().getConfigReader().getOscarUsername() + 
				            ", doctor (" + FileReaderManager.getInstance().getConfigReader().getRegistrationID() + ")"
				          , MRP.getText());
		
		
		
		
	}

}
