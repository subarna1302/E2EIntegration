package com.org.PradeepWebsite.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.PradeepWebsite.pageobjects.HeaderPage;
import com.org.testbase.TestBase;
import com.org.utils.SharedLibrary;

public class HeaderTests extends TestBase{
	HeaderPage hp = new HeaderPage();
	
	@BeforeMethod
	public void setup()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Header");
	}

	@Test(priority =3)
	public void validateFAQLink() throws IOException
	{
		extentTest=extentReport.createTest("validateFAQLink");
		boolean result;
		try {
		hp.getFAQ().click();
		Thread.sleep(1000);
		result = true;
		extentTest.pass("validateFAQLink worked successfully");
		}catch(Exception e)
		{
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validateFAQLink"));
			result = false;
			extentTest.fail("validateFAQLink failed");
			
		}
		assertEquals(result, true);
		//assertEquals(result, true);
		extentTest.pass("validateFAQLink Worked successfully");
		
	}
	@Test(priority=2)
	public void validateBannerImage() throws IOException
	{
		extentTest=extentReport.createTest("validateBannerImage");
		Boolean result;
		WebElement ImageFile= hp.getBannerImg();
		 Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
        if (!ImagePresent)
        {
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validateBannerImage"));
			result = false;
        	extentTest.fail("validateBannerImage failed");
        }
        else
        {
        	result = true;
        	extentTest.pass("validateBannerImage Worked successfully");
        }
	
	}
	
	@Test(priority=1)
	public void validateMarquee() throws IOException
	{
		extentTest=extentReport.createTest("validateMarquee");
		boolean result;
		try {
		String CaptureMarqeeTxt = hp.getMarqueeText().getText();
		if(CaptureMarqeeTxt.contains("Please Pay"));
		extentTest.pass("validateMarquee Worked successfully");
		result=true;
		}catch(Exception e)
		{
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validateMarquee"));

			result=false;
			extentTest.fail("validateMarquee failed");
		}
		assertEquals(result, true);
	}
}
