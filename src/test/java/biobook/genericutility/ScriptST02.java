package biobook.genericutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.generic.utility.DatabaseUtility;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class ScriptST02 {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		JavaUtility ju = new JavaUtility();
		FileUtility fu = new FileUtility();
		DatabaseUtility dbu = new DatabaseUtility();
		ExcelUtility eu = new ExcelUtility();
		WebdriverUtility wdu = new WebdriverUtility();
       

		String Browser = fu.readDataFromPropertyFile("browser");
		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		String  Imgpath= fu.readDataFromPropertyFile("Imgpath");


        
		//Open Application


		WebDriver driver = null;
		if(Browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(Browser.equals("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("there is no browser");
		}
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver);
		driver.get(URL);
		
		//Login as user
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
        driver.findElement(By.name("email")).sendKeys(EMAIL);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		//Click on profile page and  Edit  personal info 
				driver.findElement(By.xpath("//label[.='Profile']")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
				Thread.sleep(2000);
			// using hashmap	
	     eu.list(driver,"PersonalInfo");		
	    
	    WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));

		wdu.select("Female",genderlist);
		
		//scrollpage
		wdu.scrollBarAction(driver);
		//Click on save 
				driver.findElement(By.xpath("//button[@name='save']")).click();
				//Update picture and save it
				driver.findElement(By.xpath("//button[.='Update Picture']")).click();
				driver.findElement(By.xpath("//input[@type='file']")).sendKeys(Imgpath);
				driver.findElement(By.xpath("//input[@value='save']")).click();
				//Click on photos module 
				driver.findElement(By.xpath("//label[.='Photos']")).click();
				//click on choose file and select one photo from desktop  
				driver.findElement(By.xpath("(//input[@name='image'])[1]")).sendKeys("D:\\BioBook\\pinky2.jpg");
				//Click on add photos
				driver.findElement(By.xpath("//button[@name='Submit']")).click();
				//Click on logout
				driver.findElement(By.xpath("//button[@class='btn-sign-in']")).click();
			}

	}


