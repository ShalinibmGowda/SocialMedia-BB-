package com.jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
	    Sheet sh = book.getSheet("Sheet3");
	    for (int i = 0; i<=sh.getLastRowNum(); i++) {
	    	Row row = sh.getRow(i);	
	    	String value = row.getCell(0).getStringCellValue();
		    System.out.println(value);
		}   
	}
}
