package org.oscarehr.integration.consultations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import cucumber.api.java.Before;

public class Hooks {
	
	static WebDriver driver;
	
	@FindBy(how = How.NAME, using = "username")
	static WebElement username;
	
	@FindBy(how = How.NAME, using = "password")
	static WebElement password;
	
	@FindBy(how = How.NAME, using = "pin")
	static WebElement pin;
	
//	@FindBy(how = How.XPATH, using = ".//html/body/div[1]/div/div[2]/ul[1]/li[4]/a[text() = 'Schedule']")
//	static WebElement Schedule;
	ConfigFileReader configFileReader;
	
	@Before("@PatientRecordAlreadyExists")
	public void user_logs_into_oscar_emr() throws InterruptedException {
		configFileReader= new ConfigFileReader();
		System.setProperty("webdriver.gecko.driver",configFileReader.getDriverPath());
		driver = new FirefoxDriver();
		
		 driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		String baseUrl = configFileReader.getApplicationUrl();
        String expectedTitle = "Juno EMR Services Client Login";
        String actualTitle = "";
        
        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test1 Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
    	PageFactory.initElements(driver, Hooks.class);
        //Enter values for the web element
        username.sendKeys(configFileReader.getOscarUsername());
        password.sendKeys(configFileReader.getOscarPassword());
        pin.sendKeys(configFileReader.getOscarPin());
        
        //Click on login button
//        WebElement submit = driver.findElement(By.name("commit"));
//        submit.click();
        pin.sendKeys(Keys.RETURN);
        
        TimeUnit.SECONDS.sleep(15);
      
		
		driver.findElement(By.xpath("//a[@class='ng-scope ng-binding'][contains(text(),'Schedule')]")).click();
		
        	
	}

}
