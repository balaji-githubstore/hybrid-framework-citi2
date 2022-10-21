package com.citi.pages;

import org.openqa.selenium.WebDriver;

import com.citi.base.AutomationKeywords;

public class PIMPage extends AutomationKeywords {

	private WebDriver driver;

	public PIMPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
}
