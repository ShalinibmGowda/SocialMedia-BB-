package com.Demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_Testng {
	
	@Test(dataProvider = "data")
	public void trip(String src,String dst,int price)
	{
		System.out.println("from "+src+"------>"+"To "+dst+"price "+"----->"+price);
	}
	
	@DataProvider
	public Object[][]data()
	{
		Object[][] objArr = new Object[3][3];
		
		objArr[0][0]="Banglore";
		objArr[0][1]="Mysore";
		objArr[0][2]=500;
		
		objArr[1][0]="Mysore";
		objArr[1][1]="Kerala";
		objArr[1][2]=2500;
		
		objArr[2][0]="Kerala";
		objArr[2][1]="Dehli";
		objArr[2][2]=5000;
		
		return objArr;
	}
	

}
