package com.org.utils;

import java.io.File;

import static com.org.testbase.TestBase.driver;
import static com.org.utils.Project_Properties.prop;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.io.Files;

public class SharedLibrary {
	public static String takeScreenshot(String imageName) {
		String basePath = System.getProperty("user.dir");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String imagePath = basePath + prop.getProperty("screenshotPath") + imageName + ".png";
		File tarFile = new File(imagePath);
		try {
			Files.copy(srcFile, tarFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagePath;
	}

}
