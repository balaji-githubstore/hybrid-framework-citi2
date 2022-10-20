package com.citi.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//no need to create Demo1Test
public class Demo1Test {
	
	@DataProvider
	public Object[][] validData()
	{
		Object[][] main=new Object[3][2];
		//i- number of test case 
		//j - number of parameter
		
		main[0][0]="saul";
		main[0][1]="saul123";
		
		main[1][0]="kim";
		main[1][1]="kim123";
		
		main[2][0]="mark";
		main[2][1]="mark123";
		
		return main;
	}
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println("valid"+username+password);
	}

}
