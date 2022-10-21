package com.citi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.citi.base.AutomationWrapper;
import com.citi.pages.EmployeeListPage;
import com.citi.pages.LoginPage;
import com.citi.pages.MainPage;
import com.citi.utilities.DataUtils;
	
public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidCredentialTest(String username, String password, String expectedError) {
		
		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Entered username: "+username);
		
		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Entered password: "+password);
		
		LoginPage.clickOnLogin(driver);

		String actualError = LoginPage.getInvalidErrorMessage(driver);
		test.log(Status.INFO, "Actual Error Message: "+actualError);
		Assert.assertEquals(actualError, expectedError);
	}

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login","smoke"})
	public void validCredentialTest(String username,String password,String expectedValue) {
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		MainPage.waitForPresenceOfAdminMenu(driver);

		String actualText = EmployeeListPage.getEmployeeInformationHeader(driver);
		Assert.assertEquals(actualText, expectedValue);
	}

}
