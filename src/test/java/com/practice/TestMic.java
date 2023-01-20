package com.practice;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;





public class TestMic {

	public static void main(String[] args) throws InterruptedException {
		 ChromeOptions option=new ChromeOptions();
		HashMap<String,Object> contentSetting = new HashMap<String, Object>();
		HashMap<String,Object> profile = new HashMap<String, Object>();
		HashMap<String,Object >prefs=new HashMap<String, Object>();
		contentSetting.put("media_stream", 1);
		profile.put("managed_default_content_settings", contentSetting);
		prefs.put("profile", profile);
 		 option.setExperimentalOption("prefs", prefs); 		

		WebDriver driver= new ChromeDriver(option);
		driver.get("https://mictests.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[.='Test my mic']")).click();
	      String exp = driver.getTitle();
		 String actual = driver.findElement(By.xpath("//li[contains(.,'Testing was completed')]")).getText();
		 Thread.sleep(5000);
		if(exp.contains(actual))
		{
			System.out.println("mic test is pass");
		}
		else
		{
			System.out.println("mic test is fail");
		}
		
	 

	}

}
