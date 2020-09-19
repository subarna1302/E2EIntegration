package com.org.DataGenerators;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataGenerator {
	@DataProvider(name="testData")
	public static Object[][] TestDataGenerator() throws IOException
	{
		XSSFWorkbook wk = new XSSFWorkbook("./TestsData/TestData.xlsx");
		XSSFSheet s1 = wk.getSheet("TestSheet");
		int rows = s1.getPhysicalNumberOfRows();
		
		
		Object [][]data= new Object[rows][4];
		for(int i=0;i<rows;i++)
		{
			XSSFRow row = s1.getRow(i);
			
			Object fname = row.getCell(0).getStringCellValue();
			Object mname = row.getCell(1).getStringCellValue();
			Object lname= row.getCell(2).getStringCellValue();
			Object age = row.getCell(3).getStringCellValue();
		
		data[i][0]=fname;
		data[i][1]=mname;
		data[i][2]=lname;
		data[i][3]=age;
		
		}
		wk.close();
		return data;
	}

}
