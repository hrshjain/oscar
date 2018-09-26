package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.oscarehr.consultations.managers.FileReaderManager;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.NAME, using = "username")
	static WebElement username;
	
	@FindBy(how = How.NAME, using = "password")
	static WebElement password;
	
	@FindBy(how = How.NAME, using = "pin")
	static WebElement pin;
	
	@FindBy(how = How.XPATH, using = "//a[@class='ng-scope ng-binding'][contains(text(),'Schedule')]")
	static WebElement schedule;
	
	
	public void login_into_oscar_emr() {	
		// launch Fire fox and direct it to the Base URL
		String baseUrl = FileReaderManager.getInstance().getConfigReader().getApplicationUrl();
        driver.get(baseUrl);

        //Enter Username, password and Pin
        username.sendKeys(FileReaderManager.getInstance().getConfigReader().getOscarUsername());
        password.sendKeys(FileReaderManager.getInstance().getConfigReader().getOscarPassword());
        pin.sendKeys(FileReaderManager.getInstance().getConfigReader().getOscarPin());
        pin.sendKeys(Keys.RETURN);
	}
	
	public void click_on_schedule() {
		schedule.click();
	}

}
