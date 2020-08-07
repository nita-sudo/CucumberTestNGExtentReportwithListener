package Baseclass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import commonUtilities.PropertiesFileReader;;

public class Testbase {
	public ExtentReports extent;

	public static ExtentTest scenarioDef;

	public static ExtentTest features;

	public static String reportLocation = "C:\\Users\\Sumit\\Desktop\\waters\\Cucumber-TestNG-master\\Reports\\";

	PropertiesFileReader readprop = new PropertiesFileReader();
	Properties properties = readprop.getProperty();
	public String username = properties.getProperty("username");
	public String password = properties.getProperty("password");
	public String baseurl = properties.getProperty("url");
	public String browser = properties.getProperty("browsername");
	public Logger logger;

	public Logger setProperty() {
		logger = Logger.getLogger("SFDC");
		PropertyConfigurator.configure("Log4j.properties");
		return logger;
	}

	public void launchBrowser(WebDriver driver) {

		driver.get(baseurl);
		driver.manage().window().maximize();

	}

	// protected WebDriver getDriver()
	// {
	// return driver = BrowserUtility.OpenBrowser(driver, browser, baseurl);
	// }
	// public void launchBrowser()
	// {
	//
	// driver.get(baseurl);
	// }

	// public void handleWindowPopup()
	// {
	//
	//
	// Set<String> windowhandles =driver.getWindowHandles();
	//
	// Iterator<String> it =windowhandles.iterator();
	// String parentId = it.next();
	// System.out.println("parentId :"+parentId);
	// String childId = it.next();
	// System.out.println("childId :"+childId);
	// driver.switchTo().window(childId);
	// System.out.println("switched to child window popup");
	// System.out.println("Child window popup title :"+driver.getTitle());
	// driver.close();
	// driver.switchTo().window(parentId);
	// System.out.println("switched to parent window popup");
	// System.out.println("parent window title :"+driver.getTitle());
	//
	// }

	public void enterText(By locator, String value, WebDriver driver) {
		checkForElementVisibility(locator, driver);
		driver.findElement(locator).sendKeys(value);

	}

	public Boolean checkForElementVisibility(By locator, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return true;

	}

	public Boolean checkForElementClickability(By locator, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
		return true;

	}

	public void click(By locator, WebDriver driver) {

		checkForElementClickability(locator, driver);
		driver.findElement(locator).click();

	}

	public void clickElementByJS(By locator, WebDriver driver) {
		checkForElementClickability(locator, driver);
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", driver.findElement(locator));

	}

	public void selectFromDropDown(By locator, String value, WebDriver driver) throws TimeoutException {
		Select select = new Select(driver.findElement(locator));
		select.selectByVisibleText(value);
		// logger.info("Selected:" + value + " from drop-down");
	}

	 public static String captureScreenShot(WebDriver driver) throws IOException {
	 TakesScreenshot screen = (TakesScreenshot) driver;
	 File src = screen.getScreenshotAs(OutputType.FILE);
	 String dest = ".\\screenshots\\" + getcurrentdateandtime() + ".png";
	 File target = new File(dest);
	 FileUtils.copyFile(src, target);
	 return dest;
	 }

	    public static void ExtentReportScreenshot(WebDriver driver) throws IOException {
	    	 TakesScreenshot screen = (TakesScreenshot) driver;
	    	 File src = screen.getScreenshotAs(OutputType.FILE);
	    	 String dest = reportLocation + getcurrentdateandtime() + ".png";
	    	 File target = new File(dest);
	    	 FileUtils.copyFile(src, target);
	        scenarioDef.fail("details").addScreenCaptureFromPath(dest);
	    }
	    

	 public static void testStepHandle(String teststatus,WebDriver driver,ExtentTest extenttest,Throwable throwable) {
			switch (teststatus) {
			case "FAIL":		
				extenttest.fail(MarkupHelper.createLabel("Test Case is Failed : ", ExtentColor.RED));			
				extenttest.error(throwable.fillInStackTrace());
				
				try {
					ExtentReportScreenshot(driver);
					} catch (IOException e) {
					e.printStackTrace();
					}
//				
//				if (driver != null) {
//					driver.quit();
//				}		
			break;
			
			case "PASS":			
				extenttest.pass(MarkupHelper.createLabel("Test Case is Passed : ", ExtentColor.GREEN));
				break;
				
			default:
				break;
			}
		}
	 
	private static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {
		}
		return str;
	}

}
