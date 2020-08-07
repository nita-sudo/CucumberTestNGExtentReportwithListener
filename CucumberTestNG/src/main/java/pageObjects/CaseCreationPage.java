package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CaseCreationPage {

	
	public By appLauncher = By.xpath("//div[@class='slds-icon-waffle']");
		
	
	public By searchBar =By.xpath("//input[ @placeholder='Search apps and items...']");
	public By serviceConsole =By.xpath("//button[text()='View All']/preceding::div//span/p/b");
	public By casesTab = By.xpath("//a[@title='Cases']");
	public By newButton =By.xpath("//div[@title='New']");
	public By description =By.xpath("//span[text()='Description']//..//following-sibling::textarea");
	public By saveButton =By.xpath("//button[@title='Save']");
	public By caseOrigin =By.xpath("//span[(text()='Case Origin')]//following::div[1]");
	public By CaseCreationMessage = By.xpath("//span[contains(@class,'toastMessage')]");
	
	
	
	public By selectDroptdownValue(String value)
	{
	 return	By.xpath("//div[@class='select-options']/ul/li/a[@title='"+value+"']");
	}
	
	public By selectfieldValue(String value)
	{
	 return	By.xpath("//span[text()='"+value+"']//..//following-sibling::input");
	}
	
	public By selectDropdown(String value)
	{
		return By.xpath("//span[(text()='"+value+"')]//following::div[1]");
	}
	
	
	
}
