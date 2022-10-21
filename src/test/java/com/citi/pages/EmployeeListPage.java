package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.citi.base.AutomationKeywords;

public class EmployeeListPage extends AutomationKeywords {

	private WebDriver driver;

	public EmployeeListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getEmployeeInformationHeader() {
		return driver.findElement(By.xpath("//h2")).getText();
	}

}
