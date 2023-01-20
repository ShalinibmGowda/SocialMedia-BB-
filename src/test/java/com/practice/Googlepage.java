package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class Googlepage {
	
	@Test
	public void title()
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		driver.manage().window().maximize();
		String eTitle = "Google";
		
		SoftAssert sa = new SoftAssert();
		String aTitle = driver.getTitle();
		String gt = driver.getTitle();
		System.out.println("actualTitle"+gt);
		sa.assertEquals(eTitle, aTitle);
		sa.assertAll();
		
		
	}

}
