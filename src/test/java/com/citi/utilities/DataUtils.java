package com.citi.utilities;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public Object[][] commonDataProvider(Method method) throws IOException
	{
		//give the current @Test method name which is the sheetname 
		String sheetName=method.getName();
		
		Object[][] main= ExcelUtils.getSheetIntoTwoDimensionalArray("test_data/orange_data.xlsx",sheetName);
		return main;
	}
	
	
	@DataProvider
	public Object[][] invalidCredentialData()
	{
		Object[][] main=new Object[2][3];
		
		main[0][0]="john";
		main[0][1]="john123";
		main[0][2]="Invalid credentials";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		main[1][2]="Invalid credentials";
		
		return main;
	}
	
	
	

}
