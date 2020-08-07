package stepDefinitions;




import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Baseclass.Testbase;

import cucumber.api.Scenario;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CaseCreationPage;

public class CaseCreationStepDefinition extends Testbase {
	WebDriver driver;
	Scenario scn;
	public CaseCreationStepDefinition(SharedClass obj) {
		
		driver = obj.chromeSetup(scn);
	}

	
	 


	CaseCreationPage casePage = new CaseCreationPage();
	Logger logger;
	
	@When("^user selects \"([^\"]*)\" from app launcher$")
	public void user_selects_from_app_launcher(String value) {
		logger=setProperty();
		click(casePage.appLauncher,driver);
		//clickElementByJS(casePage.appLauncher);
		logger.info("app launcher is clicked");
		enterText(casePage.searchBar, value,driver);
		logger.info("entered value "+value);
		click(casePage.serviceConsole,driver);
		logger.info("service console is selected");
	    
	}

	@When("^user clicks on new case create button$")
	public void user_clicks_on_new_case_create_button() {
	   
		click(casePage.casesTab,driver);
		logger.info("cases tab clicked");
		click(casePage.newButton,driver);
		logger.info("new button clicked");
		
	    
	}

	@When("^user enters all the mandatory fields$")
	public void user_enters_all_the_mandatory_fields() {
		
		click(casePage.selectDropdown("Case Origin"),driver);
		click(casePage.selectDroptdownValue("Phone"),driver);
		logger.info("selected Case Origin");
		click(casePage.selectDropdown("Type"),driver);
		click(casePage.selectDroptdownValue("Structural"),driver);
		logger.info("selected Type");
		click(casePage.selectDropdown("Case Reason"),driver);
		click(casePage.selectDroptdownValue("Performance"),driver);
		logger.info("selected Case Reason");
		click(casePage.selectDropdown("Product"),driver);
		click(casePage.selectDroptdownValue("GC1060"),driver);
		logger.info("selected Product");
		enterText(casePage.selectfieldValue("Subject"), "Laptop software issue",driver);
		logger.info("enetered subject");
		enterText(casePage.description, "some softwares are not working",driver);
		logger.info("enetered description");
		
	   
	    
	}

	@When("^user clicks on save button$")
	public void user_clicks_on_save_button() {
	   
		click(casePage.saveButton,driver);
	    logger.info("Saved");
	       
	    
	}

	@Then("^new case should be created$")
	public void new_case_should_be_created() {
		checkForElementVisibility(casePage.CaseCreationMessage,driver);
		
		String actualMessage=driver.findElement(casePage.CaseCreationMessage).getText();
		Assert.assertTrue(actualMessage.contains("was created"), "new case is not created");
		logger.info("verifies "+actualMessage);
		
		
	    
	}
	
	
	

}
