package com.org.testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import static com.org.utils.Project_Properties.prop;

public class TestBase {
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReport;
	public static ExtentTest extentTest;
	
	@BeforeSuite
	public void StartReport()
	{
		htmlReporter = new ExtentHtmlReporter(prop.getProperty("reportPath"));
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}
	@AfterSuite
	public void SaveReport()
	{
		extentReport.flush();
		
	}
	
	@BeforeClass
	public void OpenBrowser() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeExePath"));
		driver= new ChromeDriver();
		driver.get(prop.getProperty("appUrl"));
		driver.manage().window().maximize();
	}
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
	}
}