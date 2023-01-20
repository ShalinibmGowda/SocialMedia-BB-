package com.jdbc;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RmgserverLogpage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   //System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		 driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		 
		 driver.findElement(By.name("password")).sendKeys("rmgy@9999");
		
		
	}

}
