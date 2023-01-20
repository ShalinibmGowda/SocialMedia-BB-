package com.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggession {

	public static void main(String[] args) {

		
			WebDriver driver =new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys("Shalini");
		List<WebElement> autosug = driver.findElements(By.xpath("//span[contains(text(),'Shalini')]"));
		int count=autosug.size();
		System.out.println(count);
		try {
		for(int i=0;i<count;i++)
		{
			String data=autosug.get(i).getText();
			System.out.println(data);
			//autosug.get(3).click();
			
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		finally
		{
			autosug.get(3).click();
		}
		
		}
	}


