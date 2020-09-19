package com.org.PradeepWebsite.pageobjects;
import static com.org.testbase.TestBase.driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HeaderPage {

	public WebElement MarqueeText;
	public WebElement FAQ;
	public WebElement BannerImg;

	public WebElement getBannerImg() {
		BannerImg= driver.findElement(By.xpath("//img[@src='Banner.jpg']"));
		return BannerImg;
	}

	public WebElement getFAQ() {
		FAQ=driver.findElement(By.xpath("//a[contains(text(),'FAQ')]"));
		return FAQ;
	}

	public WebElement getMarqueeText() {
		MarqueeText= driver.findElement(By.xpath("//marquee/b/font[contains(text(),'Please pay')]"));
		return MarqueeText;
	}
	
	
	
	
}
