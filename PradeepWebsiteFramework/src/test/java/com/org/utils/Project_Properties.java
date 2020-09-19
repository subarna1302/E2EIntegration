package com.org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Project_Properties {

	static String configFilePath = "./config/project_properties.properties";
	public static Properties prop = new Properties();
	static {
		File f = new File(configFilePath);
		try {
		FileInputStream fis = new FileInputStream(f);
		prop.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static void main(String args[])
	{
		System.out.println(prop.getProperty("userName"));
	}
}
