package com.citi.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.citi.base.AutomationKeywords;

public class MainPage extends AutomationKeywords {
	
	private By adminLocator=By.xpath("//span[text()='Admin']");
	private By timeLocator=By.xpath("//span[text()='Time']");

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void waitForPresenceOfAdminMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(adminLocator));
	}
	
	public void clickOnTime()
	{
		clickUsingLocator(timeLocator);
	}
}
