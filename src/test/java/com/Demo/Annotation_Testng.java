package com.Demo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Annotation_Testng {
	
	@BeforeSuite
	public void connectDB()
	{
		System.out.println("connect to the database"+"----->"+"@BeforeSuite");
	}
	
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("launch the Browser"+"----->"+"@BeforeClass");
	}
	
	@BeforeMethod
	public void loginToApp()
	{
		System.out.println("login to application"+"----->"+"@BeforeMethod");
	}
	
	@Test(priority = -1)
	public void updateProfile()
	{
		System.out.println("profile updated successfully");
	}
	
	@Test
	public void commentStatus()
	{
		System.out.println("comment the status"+"---->"+"@Test");
	}
	
	
	@AfterSuite
	public void closeDB()
	{
		System.out.println("close the database"+"---->"+"@AfterSuite");
	}
	
	@AfterClass
	public void closeBrowser()
	{
		System.out.println("close the Browser"+"---->"+"@AfterClass");
	}
	
	@AfterMethod
	public void logout()
	{
		System.out.println("logout the application"+"----->"+"@AfterMethod");
	}

}
