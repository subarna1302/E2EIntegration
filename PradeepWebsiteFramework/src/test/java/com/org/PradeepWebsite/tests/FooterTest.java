package com.org.PradeepWebsite.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.PradeepWebsite.pageobjects.FooterPage;
import com.org.testbase.TestBase;
import com.org.utils.SharedLibrary;

public class FooterTest extends TestBase {
	FooterPage fp= new FooterPage();
	@BeforeMethod
	public void setup()
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("Footer");
	}
	
	@Test
	public void validatefootertxt() throws IOException
	{
		extentTest=extentReport.createTest("validatefootertxt");
		boolean result;
		try {
			String FooterTxt = fp.getFooterTxt().getText();
			if(FooterTxt.contains("This website is only for Learning"));
			result=true;
			extentTest.pass("validatefootertxt captured successfully");
		}catch(Exception e)
		{
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validatefootertxt"));

			result=false;
			extentTest.fail("validateMarquee failed");
			
		}
		assertEquals(result, true);
		extentTest.pass("validatefootertxt Worked successfully");
	}

}
