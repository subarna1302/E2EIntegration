package com.org.PradeepWebsite.tests;

import static com.org.utils.Project_Properties.prop;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.org.DataGenerators.DataGenerator;
import com.org.PradeepWebsite.pageobjects.RegistrationPage;
import com.org.testbase.TestBase;
import com.org.utils.SharedLibrary;

public class RegistrationTests extends TestBase {

	RegistrationPage rp = new RegistrationPage();

	@BeforeMethod
	public void setup() {
		driver.switchTo().defaultContent();
		driver.switchTo().frame("UserRegistration");
	}

	@Test(dataProvider = "testData", dataProviderClass = DataGenerator.class,priority=1)
	public void TextBoxfields(String fname, String mname, String lname, String ages) throws IOException {
		extentTest = extentReport.createTest("validateTextBoxfields");
		boolean results;
		try {
			rp.getFnamebox().sendKeys(fname);
			String fval = rp.getFnamebox().getAttribute("value");

			if (fval.equals(fname)) {
				// extentTest = extentReport.createTest("ValidateFname");
				extentTest.pass("FirstName Matched successfully=" + fval);
			}
			rp.getMnamebox().sendKeys(mname);
			String mval = rp.getMnamebox().getAttribute("value");
			if (mval.equals(mname)) {
				// extentTest = extentReport.createTest("ValidateMname");
				extentTest.pass("MiddleName Matched successfully=" + mval);
			}
			rp.getLnamebox().sendKeys(lname);
			String lval = rp.getLnamebox().getAttribute("value");
			if (lval.equals(lname)) {
				// extentTest = extentReport.createTest("ValidateLastName");
				extentTest.pass("LastName Matched successfully=" + lval);
			}
			// extentTest = extentReport.createTest("ValidateAge");
			try {
				rp.getAgebox().sendKeys(ages);

				String ageval = rp.getAgebox().getAttribute("value");
				if (ageval.equals(ages)) {

					extentTest.pass("Agevalue Matched successfully=" + ageval);
				}

			} catch (Exception e) {
				extentTest.fail("AgeVal failed to enter");
			}
			/*Select dropdown = new Select(rp.getMaritalDropdown());
			dropdown.selectByVisibleText("Unmarried");
			rp.getGenderRadio().click();
			rp.getSubjectscheckbox().click();
			rp.getUploadImage().sendKeys(prop.getProperty("imgPath"));
			rp.getRegisterButton().click();*/
		

			results = true;
			extentTest.pass("Textfields entered  successfully");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("Element did'nt Locate properly");
			// take screenshot
			// String screenshotPath = SharedLibrary.takeScreenshot("validateRegistration");
			// extentTest.addScreenCaptureFromPath(screenshotPath);
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("VReg"));
			results = false;
			extentTest.fail("Textfield validation failed");
		}

		assertEquals(results, true);
		extentTest.pass("Text Validation was successfull");
	}
	
	@Test(enabled = true,priority=2)
	public void validateMStatus() throws InterruptedException, IOException
	{
		extentTest = extentReport.createTest("validateMStatus");
		boolean result;
		try {
		Select dropdown = new Select(rp.getMaritalDropdown());
		dropdown.selectByVisibleText("Unmarried");
		result=true;
		extentTest.pass("validateMStatus was successfull");
		Thread.sleep(2000);
		}catch(Exception e)
		{
			System.out.println("Element did'nt Locate or Text did'nt entered properly");
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("VMStatus"));
			result= false;
			extentTest.fail("validateMStatus failed");
		}
		assertEquals(result,true);
		extentTest.pass("validateMStatus was successfull");
	}
	@Test(enabled = true,priority=3)
	public void validategender() throws InterruptedException, IOException
	{
		extentTest = extentReport.createTest("validategender");
		boolean result;
		try {
		rp.getGenderRadio().click();
		Thread.sleep(2000);
		result = true;
		extentTest.pass("validategender was successfull");
		}catch(Exception e)
		{
			System.out.println("Element did'nt Locate or Text did'nt entered properly");
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("VGender"));
			result= false;
			extentTest.fail("validategender failed");
		}
		assertEquals(result,true);
		extentTest.pass("validategender was successfull");
	}
	@Test(enabled = true,priority=4)
	public void validatecheckbox() throws InterruptedException, IOException
	{
		extentTest = extentReport.createTest("validatecheckbox");
		
		boolean result;
		try {
			extentTest.pass("validatecheckbox was successfull");
		rp.getSubjectscheckbox().click();
		Thread.sleep(1000);
		
		result= true;
		}catch(Exception e)
		{
			System.out.println("Element did'nt Locate or Text did'nt entered properly");
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("VCheckBox"));
			result= false;
			extentTest.fail("validatecheckbox failed");
		}
		assertEquals(result,true);
		extentTest.pass("validatecheckbox was successfull");
	}
	@Test(enabled=true,priority=5)
	public void validateuploadImage() throws InterruptedException, IOException
	{
		extentTest = extentReport.createTest("validateuploadImage");
		boolean result;
		try {
			rp.getUploadImage().sendKeys(prop.getProperty("imgPath"));
		Thread.sleep(1000);
		result= true;
		extentTest.pass("validateuploadImage was successfull");
		}catch(Exception e)
		{
			System.out.println("Element did'nt Locate or Text did'nt entered properly");
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("VUploadImage"));
			result= false;
			extentTest.fail("validateuploadImage failed");
		}
		assertEquals(result,true);
		extentTest.pass("validateuploadImage was successfull");
	}
	@Test(enabled = true,priority=6)
	public void validateRegisterButton() throws InterruptedException, IOException
	{
		extentTest = extentReport.createTest("validateRegisterButton");
		boolean result;
		try {
		rp.getRegisterButton().click();
		
		result=true;
		extentTest.pass("validateRegisterButton was successfull");
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		}catch(Exception e)
		{
			System.out.println("Element did'nt Locate or Text did'nt entered properly");
			extentTest.addScreenCaptureFromPath(SharedLibrary.takeScreenshot("validateRegisterButton"));
			result= false;
			extentTest.fail("validateRegisterButton failed");
		}
		assertEquals(result,true);
		extentTest.pass("validateRegisterButton was successfull");

	}


}
