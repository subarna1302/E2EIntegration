package com.org.PradeepWebsite.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static com.org.testbase.TestBase.driver;
public class FooterPage {
	public WebElement FooterTxt;

	public WebElement getFooterTxt() {
		FooterTxt= driver.findElement(By.xpath("//td[contains(text(),'This website is only for Learning')]"));
		return FooterTxt;
	}
	
	

}
