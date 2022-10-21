package com.citi.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;
import com.citi.pages.EmployeeListPage;
import com.citi.pages.LoginPage;
import com.citi.pages.MainPage;
import com.citi.utilities.DataUtils;
	//static page objects
public class LoginTest extends AutomationWrapper {

	@Test(dataProvider = "commonDataProvider",dataProviderClass = DataUtils.class,groups = {"login"})
	public void invalidCredentialTest(String username, String password, String expectedError) {
		
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);
		LoginPage.clickOnLogin(driver);

		String actualError = LoginPage.getInvalidErrorMessage(driver);
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
