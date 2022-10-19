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
import org.testng.annotations.Test;

import com.citi.base.AutomationWrapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest extends AutomationWrapper {
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.name("username")).sendKeys("john");
		driver.findElement(By.cssSelector("[name='password']")).sendKeys("john123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(@class,'alert-content')]")).getText();
		Assert.assertEquals(actualError, "Invalid credentials");
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
