package com.Demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.utility.ExcelUtility;

public class DataProvider_Excel_Testng {
	
	@Test(dataProvider="getData")
	public void readData(String from, String to)
	{
		System.out.println(from+"---->"+to);
	}

	
	@DataProvider
	public Object[][] getData() throws Throwable
	{
		ExcelUtility eu = new ExcelUtility();
		Object[][] value = eu.readMultipleSetOfData("DataProvider");
		return value;
	}
}
