package org.oscarehr.consultations.pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.oscarehr.consultations.dataProviders.ConfigFileReader;

public class LoginPage {
	
	ConfigFileReader configFileReader;
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	    PageFactory.initElements(driver, this);
	    configFileReader= new ConfigFileReader();
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
		String baseUrl = configFileReader.getApplicationUrl();
        driver.get(baseUrl);

        //Enter Username, password and Pin
        username.sendKeys(configFileReader.getOscarUsername());
        password.sendKeys(configFileReader.getOscarPassword());
        pin.sendKeys(configFileReader.getOscarPin());
        pin.sendKeys(Keys.RETURN);
	}
	
	public void click_on_schedule() {
		schedule.click();
	}

}
