package com.BioBook.sm;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class AutomationTestScriptIT02 {
	public static void main(String[] args) throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/BioBookcommondata.Properties");
		p.load(fis);
		String URL = p.getProperty("url");
		String EMAIL = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		
		//Open Application
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(URL);
		
		//Login as user
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.name("email")).sendKeys(EMAIL);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		//Click on profile page and  Edit  personal info 
		driver.findElement(By.xpath("//label[.='Profile']")).click();
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		
		
		String user = "Shalini Gowda"+random;
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(user);
		//Scroll page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(200,100)");
		//Click on save 
		driver.findElement(By.xpath("//button[@name='save']")).click();
		//Click on user page
		driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
		//to verify the same data should be display in user page 
		WebElement ele = driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a"));
		if (ele.isDisplayed()) {
			System.out.println("the same data "+user+" displayed in user page");
		}else {
			System.out.println("the same data "+user+" not displayed in user page");
		}
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[.='Log out']")).click();
	}
}
