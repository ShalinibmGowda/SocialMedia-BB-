package Home_Module;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class ShareStatus_with_Hardcode_Test {
	public static void main(String[]args) throws Throwable{
		
		FileInputStream fis = new FileInputStream("./src/test/resources/BioBookcommondata.Properties");
		Properties p = new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String EMAIL = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		String Imgpath = p.getProperty("Imgpath");
		
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
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//share status
		driver.findElement(By.xpath("//textarea[@name='content']")).sendKeys("Happy Sunday");
		driver.findElement(By.xpath("//input[@name='image']")).sendKeys(Imgpath);
		driver.findElement(By.xpath("//div[@id='right-nav']/div/form/button")).click();
		//click on user module
		driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[@value='Log out']")).click();		
	}
}
