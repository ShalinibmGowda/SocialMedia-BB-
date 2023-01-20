package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazonpage {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		WebElement facebook = driver.findElement(By.xpath("//a[text()='Facebook']"));
		
		 JavascriptExecutor jse = (JavascriptExecutor)driver;
		 int y = facebook.getLocation().getY();
		  jse.executeScript("window.scrollBy(0,"+y+")", facebook);
		  Thread.sleep(3000);
		// jse.executeScript("argument[0].scrollIntoView()", facebook);
		 facebook.click();

	}

}
