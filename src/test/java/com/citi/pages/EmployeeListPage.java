package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

	private WebDriver driver;

	public EmployeeListPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getEmployeeInformationHeader() {
		return driver.findElement(By.xpath("//h2")).getText();
	}

}
