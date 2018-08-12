package org.oscarehr.integration.consultations;

import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;

public class LoginTest {

	static WebDriver driver;
	static WebElement username;
	static WebElement password;
	static WebElement pin;
	ConfigFileReader configFileReader;
	
	@Given("^User starts the browser$")
	public void user_starts_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		configFileReader= new ConfigFileReader();
		System.setProperty("webdriver.gecko.driver",configFileReader.getDriverPath());
		driver = new FirefoxDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Chrome
		//System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();	}
	}

	@When("^User Navigate to Login Page$")
	public void user_Navigate_to_Login_Page() {
	    // Write code here that turns the phrase above into concrete actions
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
        
	}
	
	@When("^User enters username password and pin$")
	public void user_enters_Username_Password_and_Pin() {
	    // Write code here that turns the phrase above into concrete actions
        //Get web element for username, password and pin
    	PageFactory.initElements(driver, LoginTest.class);
        //Enter values for the web element
        username.sendKeys(configFileReader.getOscarUsername());
        password.sendKeys(configFileReader.getOscarPassword());
        pin.sendKeys(configFileReader.getOscarPin());
        
        //Click on login button
//        WebElement submit = driver.findElement(By.name("commit"));
//        submit.click();
        pin.sendKeys(Keys.RETURN);
	}

	@Then("^User can now view the HomePage$")
	public void user_can_now_view_the_HomePage() {
	    // Write code here that turns the phrase above into concrete actions
		
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until((Function) ExpectedConditions.visibilityOfElementLocated((By.id("demographicQuickSearch"))));		
		WebElement consultationUrl = driver.findElement(By.id("demographicQuickSearch"));
		
        if(consultationUrl.isDisplayed()==true){
            System.out.println("Test2 Passed!");
        } else {
            System.out.println("Test Failed");
        
        }
        
        driver.quit();
	}


}
