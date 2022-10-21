package com.citi.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;

public class LoginUITest extends AutomationWrapper {
	
	@Test(groups = {"UI","smoke"})
	public void validateTitleTest()
	{
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
	}

	@Test
	public void validatePlaceholderTest()
	{
		String actualUsernamePlaceholder= driver.findElement(By.name("username")).getAttribute("placeholder");
		String actualPasswordPlaceholder= driver.findElement(By.name("password")).getAttribute("placeholder");
		
		Assert.assertEquals(actualUsernamePlaceholder, "Username");
		Assert.assertEquals(actualPasswordPlaceholder, "Password");
	}
}
