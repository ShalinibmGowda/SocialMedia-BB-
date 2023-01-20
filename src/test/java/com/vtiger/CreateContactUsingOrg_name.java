
package com.vtiger;

import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CreateContactUsingOrg_name {

	public static void main(String[] args) throws InterruptedException {
		
		Random ran= new Random();
		int random =ran.nextInt(500);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/mainSettings.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		driver.findElement(By.xpath("//a[text()='CRM Settings']")).click();
		  WebElement ele = driver.findElement(By.xpath("//a[contains(.,'Workflows')]"));
		  JavascriptExecutor js = (JavascriptExecutor)driver;
           js.executeScript("arguments[0].scrollIntoView();",ele);
           ele.click();
           
           driver.findElement(By.xpath("//input[@id='new_workflow']")).click();
           WebElement dropdown = driver.findElement(By.xpath("//select[@name='module_name']"));
           Select sel = new Select(dropdown);
           sel.selectByValue("Products");
           String pr="KZProducts"+random;
           driver.findElement(By.xpath("//input[@name='save']")).click();
           driver.findElement(By.xpath("//input[@name='description']")).sendKeys(pr);
           Thread.sleep(5000);
           driver.findElement(By.xpath("//input[@id='save_submit']")).click();
           
           js.executeScript("window.scrollBy(0,500)");
           
           driver.findElement(By.xpath("//a[contains(.,'Workflows')]")).click();
           js.executeScript("window.scrollBy(0,1500)");
           
           WebElement ele2 = driver.findElement(By.xpath("//td[contains(.,'"+pr+"')]"));
           String mypr = ele2.getText();
           if (ele2.isDisplayed()) {
			System.out.println("the same product "+mypr+"is displayed");
		     }
           else
           {
        	   System.out.println("the product"+mypr+"is not fisplayed");
           }
           

           
           driver.findElement(By.xpath("//td[contains(.,'KZProducts"+random+"')]/following::*/a[2]/img")).click();

           driver.switchTo().alert().accept();
           System.out.println("the product is deleted");
           
	}

}
