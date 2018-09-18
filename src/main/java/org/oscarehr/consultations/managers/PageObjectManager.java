package org.oscarehr.consultations.managers;

import org.openqa.selenium.WebDriver;
import org.oscarehr.consultations.pageObjects.LoginPage;
import org.oscarehr.consultations.pageObjects.OscarConsultationRequestPage;
import org.oscarehr.consultations.pageObjects.PrintPreviewPage;
import org.oscarehr.consultations.pageObjects.ViewConsultationRequestsPage;

public class PageObjectManager {
 
	private WebDriver driver;
 
	private OscarConsultationRequestPage oscarConsultationRequestPage;
	
	private LoginPage loginPage;
	
	private ViewConsultationRequestsPage viewConsultationRequestsPage;
	
	private PrintPreviewPage printPreviewPage;

	public PageObjectManager(WebDriver driver) {
 
		this.driver = driver;
 
	}
	
	public OscarConsultationRequestPage oscarConsultationRequestPage() {
 
		return (oscarConsultationRequestPage == null) ? oscarConsultationRequestPage = new OscarConsultationRequestPage(driver) : oscarConsultationRequestPage;
 
	}
	
	public LoginPage loginPage() {
		 
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
 
	}
	
	public ViewConsultationRequestsPage viewConsultationRequestsPage() {
		 
		return (viewConsultationRequestsPage == null) ? viewConsultationRequestsPage = new ViewConsultationRequestsPage(driver) : viewConsultationRequestsPage;
 
	}
	
	public PrintPreviewPage printPreviewPage() {
		 
		return (printPreviewPage == null) ? printPreviewPage = new PrintPreviewPage(driver) : printPreviewPage;
 
	}
}