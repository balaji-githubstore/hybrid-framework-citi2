package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {
		driver.findElement(By.name("username")).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(By.cssSelector("[name='password']")).sendKeys(password);
	}

	public void clickOnLogin() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(By.xpath("//div[contains(@class,'alert-content')]")).getText();
	}

}
