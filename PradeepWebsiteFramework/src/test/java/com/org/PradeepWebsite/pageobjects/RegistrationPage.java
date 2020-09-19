package com.org.PradeepWebsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.org.testbase.TestBase.driver;

public class RegistrationPage {
	private WebElement Fnamebox;
	private WebElement Mnamebox;
	private WebElement Lnamebox;
	private WebElement Agebox;
	private WebElement MaritalDropdown;
	private WebElement GenderRadio;
	private WebElement Subjectscheckbox;
	private WebElement UploadImage;
	private WebElement RegisterButton;
	public WebElement getFnamebox() {
		Fnamebox = driver.findElement(By.id("fname"));
		return Fnamebox;
	}
	public WebElement getMnamebox() {
		Mnamebox = driver.findElement(By.id("mname"));
		return Mnamebox;
	}
	public WebElement getAgebox() {
		Agebox = driver.findElement(By.id("age"));
		return Agebox;
	}
	public WebElement getLnamebox() {
		Lnamebox = driver.findElement(By.id("lname"));
		return Lnamebox;
	}
	public WebElement getMaritalDropdown() {
		MaritalDropdown = driver.findElement(By.id("marital"));
		return MaritalDropdown;
	}
	public WebElement getGenderRadio() {
		GenderRadio = driver.findElement(By.xpath("//input[@name='gender' and @value='Female']"));
		return GenderRadio;
	}
	public WebElement getSubjectscheckbox() {
		Subjectscheckbox = driver.findElement(By.xpath("//input[@name='selenium' and @value='Selenium']"));

		return Subjectscheckbox;
	}
	public WebElement getUploadImage() {
		UploadImage = driver.findElement(By.id("file"));
	
		return UploadImage;
	}
	public WebElement getRegisterButton() {
		RegisterButton = driver.findElement(By.id("Register"));

		return RegisterButton;
	}


}
