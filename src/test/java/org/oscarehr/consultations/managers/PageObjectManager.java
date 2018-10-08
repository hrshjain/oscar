package org.oscarehr.consultations.managers;

import org.openqa.selenium.WebDriver;
import org.oscarehr.consultations.pageObjects.LoginPage;

public class PageObjectManager {
 
	private WebDriver driver;
	
	private LoginPage loginPage;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage loginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}
}