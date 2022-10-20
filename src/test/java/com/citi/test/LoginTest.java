package com.citi.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends AutomationWrapper {
	
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
	
	@Test(dataProvider = "invalidCredentialData")
	public void invalidCredentialTest(String username,String password,String expectedError)
	{
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(@class,'alert-content')]")).getText();
		Assert.assertEquals(actualError, expectedError);
	}

	@Test
	public void validCredentialTest() {
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));

		String actualText = driver.findElement(By.xpath("//h5")).getText();
		Assert.assertEquals(actualText, "Employee Information");
	}

}
