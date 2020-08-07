package stepDefinitions;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Baseclass.Testbase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SharedClass extends Testbase{
	WebDriver driver;
	
	 private Testbase base;

	    public SharedClass(Testbase base) {
	        this.base = base;
	    }
	
	
	
	@Before("@chrome")
	public WebDriver chromeSetup(Scenario scenario) {
		if (driver == null) {
			
			base.scenarioDef = base.features.createNode(scenario.getName());
			System.out.println("started execution for the scenario : " + scenario.getName());
			scenario.write("started execution for the scenario : " + scenario.getName());
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			// driver.get(url);

		}
		return driver;
	}
	
	
	
//	@BeforeStep("@chrome")
//	public void CaptureScreenshotAfterEachStep(Scenario scenario)
//	{
//		TakesScreenshot screenshot =(TakesScreenshot) driver;
//		byte[] data=screenshot.getScreenshotAs(OutputType.BYTES);
//		scenario.embed(data, "image/png");
//	}
	
	
	@After("@chrome")
	public void CleanUp(Scenario scenario)
	{
//		TakesScreenshot screenshot =(TakesScreenshot) driver;
//		byte[] data=screenshot.getScreenshotAs(OutputType.BYTES);
//		scenario.embed(data, "image/png");
//		 if (scenario.isFailed()) {
//			 TakesScreenshot screenshot1 =(TakesScreenshot) driver;
//				byte[] data1=screenshot.getScreenshotAs(OutputType.BYTES);
//				scenario.embed(data1, "image/png");
//		    }
		driver.close();
		System.out.println("completed execution for the scenario : " + scenario.getName());
		scenario.write("completed execution for the scenario : " + scenario.getName());
	}

}

// public static WebDriver OpenBrowser(WebDriver driver,String
// browserName,String url)
// {
// if(driver==null)
//
// { if(browserName.equals("Chrome"))
// {
// ChromeOptions options = new ChromeOptions();
// options.addArguments("--disable-notifications");
// WebDriverManager.chromedriver().setup();
// driver = new ChromeDriver(options);
// //driver.get(url);
//
// return driver;
//
// } else if(browserName.equals("IE"))
// {
//// InternetExplorerOptions options = new InternetExplorerOptions();
//// options.addArguments("--disable-notifications");
//// WebDriverManager.iedriver().setup();
//// driver = new InternetExplorerDriver(options);
//// driver.get(url);
//// return driver;
//
// } else
// if(browserName.equals("Firefox"))
// {FirefoxOptions options = new FirefoxOptions();
// options.addArguments("--disable-notifications");
// WebDriverManager.firefoxdriver().setup();
// driver = new FirefoxDriver(options);
// driver.get(url);
// return driver;
// }
// }
// return driver;
// }
//
// }
