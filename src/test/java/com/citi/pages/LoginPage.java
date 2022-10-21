package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	
	public static void enterUsername(WebDriver driver,String username)
	{
		driver.findElement(By.name("username")).sendKeys(username);
	}
	
	public static void enterPassword(WebDriver driver,String password)
	{
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
	}
	
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public static String getInvalidErrorMessage(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[contains(@class,'alert-content')]")).getText();
	}
}
