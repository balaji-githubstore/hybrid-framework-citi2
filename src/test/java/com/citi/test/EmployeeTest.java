package com.citi.test;

import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.LoginPage;

public class EmployeeTest extends AutomationWrapper {

	@Test
	public void addEmployeeTest() 
	{
		LoginPage login = new LoginPage(driver);
		login.enterUsername("Admin");
		login.enterPassword("admin123");
		login.clickOnLogin();
	}

}
