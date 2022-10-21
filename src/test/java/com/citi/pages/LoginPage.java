package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citi.base.AutomationKeywords;

public class LoginPage extends AutomationKeywords {
	
	private By usernameLocator=By.name("username");
	private By passwordLocator=By.cssSelector("[name='password']");
	private By loginLocator=By.xpath("//button[@type='submit']");
	private By errorLocator=By.xpath("//div[contains(@class,'alert-content')]");

	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterUsername(String username) {
		enterTextUsingLocator(usernameLocator, username);
	}

	public void enterPassword(String password) {
		enterTextUsingLocator(passwordLocator, password);
	}

	public void clickOnLogin() {
		clickUsingLocator(loginLocator);
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText();
	}

}
