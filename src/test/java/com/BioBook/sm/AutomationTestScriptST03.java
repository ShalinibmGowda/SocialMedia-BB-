package com.BioBook.sm;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AutomationTestScriptST03 {
	public static void main(String[] args) throws IOException {
		Random ran = new Random();
		int random = ran.nextInt(500);
		// Step 1 get common data
		FileInputStream fis = new FileInputStream("./src/test/resources/BioBookcommondata.Properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String EMAIL = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		String Imgpath = p.getProperty("Imgpath");
		
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Signing to BioBook
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.className("btn-sign-in")).click();
		driver.findElement(By.name("email")).sendKeys(EMAIL);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@name='submit']")).click();

		// goto profile module
		driver.findElement(By.xpath("//label[text()='Profile']")).click();
		//click on update profile
		driver.findElement(By.xpath("//button[text()='Update Picture']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Imgpath);
		driver.findElement(By.xpath("(//input[@name='image'])[2]")).click();
		//goto user module write a comment and delete comment
		driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
		String comment = "Hi Good Afternoon"+random;
		driver.findElement(By.name("content_comment")).sendKeys(comment);
		driver.findElement(By.className("btn-comment")).click();
		WebElement ele = driver.findElement(By.xpath("//body[1]/div[2]/div[5]/div[3]/div[1]/a[1]/button[1]"));
		for (;;) {
			try {
				wait.until(ExpectedConditions.visibilityOf(ele)).click();
				break;
			}
			catch (Exception e) {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,50);");
			}
		}
		System.out.println("Deleted the comment successfully");
		driver.findElement(By.xpath("//label[text()='Home']")).click();
		//click on profile module
		driver.findElement(By.xpath("//label[text()='Profile']")).click();
		//click on logout
		driver.findElement(By.xpath("//button[text()='Log out']")).click();
	}
}


