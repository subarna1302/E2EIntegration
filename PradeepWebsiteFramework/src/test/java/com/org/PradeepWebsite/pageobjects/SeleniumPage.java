package com.org.PradeepWebsite.pageobjects;

import static com.org.testbase.TestBase.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SeleniumPage {

	private WebElement SeleniumPageTxt;

	

	public WebElement getSeleniumPageTxt() {
		// TODO Auto-generated method stub
		SeleniumPageTxt = driver.findElement(By.xpath("//u[text()='Subject:']"));
		
		return SeleniumPageTxt;
	}
	
}
