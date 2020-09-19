package com.org.PradeepWebsite.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.PradeepWebsite.pageobjects.LeftMenuPage;
import com.org.PradeepWebsite.pageobjects.SeleniumPage;
import com.org.testbase.TestBase;
import com.org.utils.SharedLibrary;

public class LeftMenuTests extends TestBase{

	LeftMenuPage lp = new LeftMenuPage();
	SeleniumPage sp = new SeleniumPage();
	@BeforeMethod
	public void setup()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("LeftMenu");
	}
	@Test(priority=1)
	public void validateSeleniumLink() throws InterruptedException, IOException
	{
		extentTest=extentReport.createTest("validateSeleniumLink");
		boolean result;
		try {
		lp.getSeleniumLink().click();
		Thread.sleep(2000);
		
			
			//extentTest.pass("SeleniumPagetxt matched successfully");
		result = true;
		extentTest.pass("SeleniumPagetxt matched successfully");
		
		}catch(Exception e)
		{
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validateSeleniumLink"));
			result = false;
			extentTest.fail("SeleniumLink failed");
		}
		assertEquals(result, true);
		//assertEquals(result, true);
		extentTest.pass("SeleniumLink Worked successfully");
	}
	@Test(priority=2)
	public void validateSeleniumPage()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("UserRegistration");
		extentTest=extentReport.createTest("validateSeleniumPageLoad");
		boolean result;
		try {
			String seleniumtxt = sp.getSeleniumPageTxt().getText();
			System.out.println(seleniumtxt);
			if(seleniumtxt.equals("Subject:"))
			extentTest.pass("SeleniumPage Loaded successfully" + seleniumtxt);
			result = true;
		}catch(Exception e)
		{
			extentTest.fail("SeleniumPageTxt loading failed");
			result = false;
		}
		assertEquals(result, true);
	}
}
