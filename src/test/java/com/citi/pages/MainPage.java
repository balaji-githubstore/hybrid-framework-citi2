package com.citi.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

	private WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForPresenceOfAdminMenu() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Admin']")));
	}
	
	public void clickOnTime()
	{
		driver.findElement(By.xpath("//span[text()='Time']")).click();
	}
}
