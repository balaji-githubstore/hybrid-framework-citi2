package com.citi.test;

import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.LoginPage;

public class EmployeeTest extends AutomationWrapper {
	
	@Test
	public void addEmployeeTest()
	{
		LoginPage.enterUsername(driver, "Admin");
		LoginPage.enterPassword(driver, "admin123");
		LoginPage.clickOnLogin(driver);
	}

}
