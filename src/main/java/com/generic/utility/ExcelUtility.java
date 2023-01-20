package com.generic.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility extends JavaUtility implements IPathConstants{



	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param ColumnNo
	 * @return
	 * @throws Throwable
	 */

	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(ColumnNo);
		String value = cel.getStringCellValue();
		return value;
	}

	/**
	 * 
	 * @param sheetName
	 * @param keycell
	 * @param valuecell
	 * @return
	 * @throws Throwable
	 */

	public Map<String, String>getList(String sheetName, int keycell, int valuecell) throws Throwable{
		JavaUtility jLib = new JavaUtility();
		int random = jLib.getRandomNo();
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		Map<String, String>map=new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key = sh.getRow(i).getCell(keycell).getStringCellValue();
			String value = sh.getRow(i).getCell(valuecell).toString();
			map.put(key, value);
		}

		return map;
	}
	/**
	 * 
	 * @param sheetName
	 * @param keycell
	 * @param valuecell
	 * @return 
	 * @return
	 * @throws Throwable
	 */
	public  ArrayList<String> getArrayList(String sheetName,int valuecell) throws Throwable{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int count = sh.getLastRowNum();
		ArrayList<String> al = new ArrayList<String>();
		for(int i=0;i<=count;i++)
		{
			String value = sh.getRow(i).getCell(valuecell).toString();
			al.add(value);
		}
		return al;
	}

	/**
	 * 
	 * @param SheetName
	 * @param RowNo
	 * @param Column
	 * @param data
	 * @throws Throwable
	 */


	public void writeDataIntoExcel(String SheetName, int RowNo, int Column,String data) throws Throwable{

		FileInputStream fis = new FileInputStream(ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row ro = sh.getRow(RowNo);
		Cell cel = ro.getCell(Column);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(IPathConstants.ExelPath);
		wb.write(fos);


	}

	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getLastRowNo(String SheetName) throws EncryptedDocumentException, IOException 
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int count = sh.getLastRowNum();
		return count;
	}
	
	/**
	 * 
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	
	public  Object[][] readMultipleSetOfData(String SheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum()+1;
		int lastCell = sh.getRow(0).getLastCellNum();
		
		Object[][] obj = new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)//row
		{
			for(int j=0;j<lastCell;j++)
			{
				obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
	
	/**
	 * 
	 * @param driver
	 * @param SheetName
	 * @return
	 * @throws Throwable
	 */
	public void list(WebDriver driver,String SheetName) throws Throwable 
	{
		JavaUtility ju = new JavaUtility();
		int random = ju.getRandomNo();
		HashMap<String, String> map=new HashMap<String, String>();
		FileInputStream fis = new FileInputStream(IPathConstants.ExelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int rowCount = sh.getLastRowNum();
		for(int i=0;i<=rowCount;i++)
		{
			String key = wb.getSheet(SheetName).getRow(i).getCell(0).getStringCellValue();
			String value = wb.getSheet(SheetName).getRow(i).getCell(1).getStringCellValue()+random;
			map.put(key, value);

		}
		for(Entry<String, String>set:map.entrySet())
		{
			driver.findElement(By.name(set.getKey())).clear();
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}

	}

}
