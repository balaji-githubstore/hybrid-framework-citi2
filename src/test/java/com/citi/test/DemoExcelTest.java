package com.citi.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoExcelTest {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file=new FileInputStream("test_data/orange_datA.xlsx");
		
		XSSFWorkbook book=new XSSFWorkbook(file);
		
		XSSFSheet sheet= book.getSheet("invalidCredentialTest");
		
		String value= sheet.getRow(0).getCell(0).getStringCellValue();
		
		System.out.println(value);
		
		

	}

}
