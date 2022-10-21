package com.citi.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;

public class EmployeeTest extends AutomationWrapper {
	
	@Test
	public void addEmployeeTest()
	{
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
