package org.oscarehr.consultations.managers;

import org.openqa.selenium.WebDriver;
import org.oscarehr.consultations.pageObjects.LoginPage;
import org.oscarehr.consultations.pageObjects.NewConsultationPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

public class PageObjectManager {
 
	private WebDriver driver;
 
	private NewConsultationPage newConsultationPage;
	
	private LoginPage loginPage;
	
	private ViewConsultationRequestsPage viewConsultationRequestsPage;

	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
 
	}
	
	public NewConsultationPage newConsultationPage() {
 
		return (newConsultationPage == null) ? newConsultationPage = new NewConsultationPage(driver) : newConsultationPage;
 
	}
	
	public LoginPage loginPage() {
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
	}
	
	public ViewConsultationRequestsPage viewConsultationRequestsPage() {
		 
		return (viewConsultationRequestsPage == null) ? viewConsultationRequestsPage = new ViewConsultationRequestsPage(driver) : viewConsultationRequestsPage;
 
	}
}