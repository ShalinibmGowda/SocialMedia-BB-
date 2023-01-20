package com.practice;
import javax.swing.JOptionPane;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
public class SpiceJet {

	@Test
	public static void bookFlight() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get("https://www.spicejet.com/");
		Thread.sleep(5000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String City = JOptionPane.showInputDialog(null,"Please Enter From"); //To create window
//		String fromCity = "HYD";
		WebElement from = driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[1]"));
		from.sendKeys(City);
		Thread.sleep(2000);
		String City1 = JOptionPane.showInputDialog(null,"Please Enter To");
//		String toCity = "DXB";
		WebElement to = driver.findElement(By.xpath("(//input[@autocapitalize='sentences'])[2]"));
		to.sendKeys(City1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-19h5ruw r-136ojw6']//div[4]//div[1]//div[3]//div[2]//div[5]//div[1]//div[1]")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveByOffset(10, 10).perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//body/div[@id='react-root']/div[@id='main-container']/div[@class='css-1dbjc4n r-1niwhzg r-1jgb5lz r-r0h9e2 r-13qz1uu']/div[@class='css-1dbjc4n r-14lw9ot']/div[@class='css-1dbjc4n r-14lw9ot r-z2wwpe r-vgw6uq r-156q2ks r-urutk0 r-8uuktl r-136ojw6']/div[@class='css-1dbjc4n r-1pcd2l5 r-1uwte3a r-m611by r-bnwqim']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-1d09ksm r-1inuy60 r-m611by']/div[@class='css-1dbjc4n']/div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[3]/div[1]/div[1]/div[1]//*[name()='svg']//*[name()='circle' and contains(@cx,'9')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-1g94qm0 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[name()='rect' and contains(@width,'100%')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-z2wwpe r-1loqt21 r-18u37iz r-1777fci r-d9fdf6 r-1w50u8q r-ah5dr5 r-1otgn73']")).click();
	}
}
