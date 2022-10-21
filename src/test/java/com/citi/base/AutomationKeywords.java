package com.citi.base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

public class AutomationKeywords {

	private WebDriver driver1;
	private FluentWait<WebDriver> wait;

	public AutomationKeywords(WebDriver driver) {
		this.driver1 = driver;

		wait = new FluentWait<WebDriver>(driver);
		wait.pollingEvery(Duration.ofSeconds(1));
		wait.ignoring(NoSuchElementException.class, NoAlertPresentException.class);
		wait.withTimeout(Duration.ofSeconds(30));
	}

	public void enterTextUsingLocator(By locator, String text) {
		wait.until(x -> x.findElement(locator)).sendKeys(text);
	}

	public void clickUsingLocator(By locator) {
		wait.until(x -> x.findElement(locator)).click();
	}

	public String getTextUsingLocator(By locator) {
		return wait.until(x -> x.findElement(locator)).getText();
	}
}





