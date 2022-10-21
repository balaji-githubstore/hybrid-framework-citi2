package com.citi.test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DemoExtent {

	public static void main(String[] args) {

		// initial report config //run only once in the beginning 
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
		extent.attachReporter(spark);

		// before every @Test method - we need to create test // @BeforeMethod
		ExtentTest test = extent.createTest("MyFirstTest");

		// after every @Test method - we need to log whether pass or fail //@AfterMethod
		test.log(Status.FAIL, "This is a logging event for MyFirstTest, and it passed!");

		
		// publish the report //should run once at the end of all test cases 
		extent.flush();

	}

}
