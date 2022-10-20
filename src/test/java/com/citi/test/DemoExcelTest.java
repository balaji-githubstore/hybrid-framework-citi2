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
		
		
		for(int r=1;r<5;r++)
		{
			for(int c=0;c<3;c++)
			{
				String value= sheet.getRow(r).getCell(c).getStringCellValue();
				System.out.println(value);
			}
		}
		
		

	}

}
