package com.org.PradeepWebsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.org.testbase.TestBase.driver;


public class LeftMenuPage {
	
	private WebElement seleniumLink;
	private WebElement soapUILink;
	private WebElement registrationILink;
	private WebElement CoreJavaLink;
	private WebElement ManualTestingLink;
	
	public WebElement getSeleniumLink() {
		seleniumLink = driver.findElement(By.xpath("//a[text()='Selenium']"));
		return seleniumLink;
	}
	
	public WebElement getSoapUILink() {
		soapUILink = driver.findElement(By.xpath("//a[text()='Soap UI']"));
		return soapUILink;
	}
	
	public WebElement getRegistrationILink() {
		registrationILink = driver.findElement(By.xpath("//a[text()='Register User']"));
		return registrationILink;
	}
	public WebElement getCoreJavaLink() {
		CoreJavaLink = driver.findElement(By.xpath("//a[text()='Core Java']"));
		return CoreJavaLink;
	}
	public WebElement getManualTestingLink() {
		ManualTestingLink = driver.findElement(By.xpath("//a[text()='Manual Testing']"));
		return ManualTestingLink;
	}

}