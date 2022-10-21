package com.citi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EmployeeListPage {

	public static String getEmployeeInformationHeader(WebDriver driver) {
		return driver.findElement(By.xpath("//h2")).getText();
	}
	
}
