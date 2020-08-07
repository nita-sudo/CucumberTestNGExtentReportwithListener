package stepDefinitions;

import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;


import Baseclass.Testbase;
import Listeners.ExtentReportListener;

import cucumber.api.Scenario;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;

public class LoginStepDefinition extends Testbase {

	WebDriver driver;
	Logger logger;
	LoginPage loginpage = new LoginPage();
    Scenario scn;
    
	// dependancy injection using pico container so that we can share objects in
	// multiple stepdefinitions file without making it static
	public LoginStepDefinition(SharedClass obj) {
		driver = obj.chromeSetup(scn);
	}

	@Given("^user is on the login page$")
	public void user_login_page() throws Throwable {
		logger = setProperty();
		ExtentTest logInfo=null;
//		try {
//			ExtentReportListener.extent=ExtentReportListener.setUp();
//			ExtentReportListener.test = ExtentReportListener.extent.createTest(Feature.class, "User is on login page validation");							
//			ExtentReportListener.test=ExtentReportListener.test.createNode("User is on login page validation");						
//			logInfo=ExtentReportListener.test.createNode(new GherkinKeyword("Given"), "user is on the login page");
//			launchBrowser(driver);
//			logInfo.pass("Opened chrome browser and entered url");
//			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));			
//			
//		} catch (AssertionError | Exception e) {
//			ExtentReportListener.testStepHandle("FAIL",driver,logInfo,e);			
//		}	
		
		try {
		
		logInfo= scenarioDef.createNode(new GherkinKeyword("Given"), "I should see the login page");
		launchBrowser(driver);
		logger.info("browser is launched");
		logInfo.pass("browser is launched");
		//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));	}
		//ExtentReportScreenshot(driver);
		}
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}	
		
		

	}

	@When("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {

		
		ExtentTest logInfo=null;
//		try {
//			ExtentReportListener.extent=ExtentReportListener.setUp();					
//			logInfo=ExtentReportListener.test.createNode(new GherkinKeyword("When"), "enter username and password");
//			enterText(loginpage.username, username, driver);
//			logger.info("username is entered");
//			enterText(loginpage.password,password, driver);
//			logger.info("password is entered");
//
//			logInfo.pass("Entered credentials");
//			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
//			
//		} catch (AssertionError | Exception e) {
//			ExtentReportListener.testStepHandle("FAIL",driver,logInfo,e);			
//		}
		try {
			logInfo=scenarioDef.createNode(new GherkinKeyword("When"), "user enters username and password");
		enterText(loginpage.username, username, driver);
		logger.info("username is entered");
		enterText(loginpage.password,password, driver);
		logger.info("password is entered");
		//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));}
		//ExtentReportScreenshot(driver);
		}
		catch (AssertionError | Exception e) {
			testStepHandle("FAIL",driver,logInfo,e);			
		}
	}

	@When("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable {

		ExtentTest logInfo=null;
//		try {
//			ExtentReportListener.extent=ExtentReportListener.setUp();					
//			logInfo=ExtentReportListener.test.createNode(new GherkinKeyword("When"), "user clicks on login button");
//			click(loginpage.loginButton, driver);
//			logger.info("login  button is clicked");
//
//			logInfo.pass("Login button clicked");
//			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
//			
//		} catch (AssertionError | Exception e) {
//			ExtentReportListener.testStepHandle("FAIL",driver,logInfo,e);			
//		}
		try {
		logInfo=scenarioDef.createNode(new GherkinKeyword("When"), "User click login button");
		click(loginpage.loginButton, driver);
		logger.info("login  button is clicked");
		//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));}
		//ExtentReportScreenshot(driver);
		}
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}
	}

	@Then("^page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String ltitle) throws Throwable {


		ExtentTest logInfo=null;
//		try {
//			ExtentReportListener.extent=ExtentReportListener.setUp();					
//			logInfo=ExtentReportListener.test.createNode(new GherkinKeyword("When"), "validation of home page");
//			checkForElementVisibility(loginpage.createMenu, driver);
//			String title = driver.getTitle();
//			Assert.assertEquals(title, ltitle);
//			logger.info("verified the title of homepage");
//
//			logInfo.pass("Verified user is on home page.");
//			//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
//			
//		} catch (AssertionError | Exception e) {
//			ExtentReportListener.testStepHandle("FAIL",driver,logInfo,e);			
//		}
		try {
		
		logInfo=	scenarioDef.createNode(new GherkinKeyword("Then"), "User should be on home page");
		
		checkForElementVisibility(loginpage.createMenu, driver);
		String title = driver.getTitle();
		Assert.assertEquals(title, ltitle);
		logger.info("verified the title of homepage");
		//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));}
		//ExtentReportScreenshot(driver);
		}
		
	catch (AssertionError | Exception e) {
		testStepHandle("FAIL",driver,logInfo,e);			
	}}
}	
	

	

