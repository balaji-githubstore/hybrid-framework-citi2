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

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class, groups = { "login" })
	public void invalidCredentialTest(String username, String password, String expectedError) {

		LoginPage login = new LoginPage(driver);

		login.enterUsername(username);
		test.log(Status.INFO, "Entered username: " + username);

		login.enterPassword(password);
		test.log(Status.INFO, "Entered password: " + password);

		login.clickOnLogin();

		String actualError = login.getInvalidErrorMessage();
		test.log(Status.INFO, "Actual Error Message: " + actualError);
		Assert.assertEquals(actualError, expectedError);
	}

	@Test(dataProvider = "commonDataProvider", dataProviderClass = DataUtils.class, groups = { "login", "smoke" })
	public void validCredentialTest(String username, String password, String expectedValue) {
		LoginPage login = new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword(password);
		login.clickOnLogin();

		MainPage main=new MainPage(driver);
		main.waitForPresenceOfAdminMenu();

		EmployeeListPage empListPage=new EmployeeListPage(driver);
		String actualText = empListPage.getEmployeeInformationHeader();
		Assert.assertEquals(actualText, expectedValue);
	}

}
