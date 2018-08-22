package org.oscarehr.consultations.managers;

import org.openqa.selenium.WebDriver;
import org.oscarehr.consultations.pageObjects.LoginPage;
import org.oscarehr.consultations.pageObjects.NewConsultationPage;
 	
public class PageObjectManager {
 
	private WebDriver driver;
 
	private NewConsultationPage newConsultationPage;
	
	private LoginPage loginPage;

	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
 
	}
	
	public NewConsultationPage newConsultationPage() {
 
		return (newConsultationPage == null) ? newConsultationPage = new NewConsultationPage(driver) : newConsultationPage;
 
	}
	
	public LoginPage loginPage() {
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
	}
}