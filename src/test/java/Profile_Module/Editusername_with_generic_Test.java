package Profile_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.generic.utility.DatabaseUtility;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class Editusername_with_generic_Test {

	public static void main(String[] args) throws Throwable {
		
		JavaUtility ju = new JavaUtility();
		FileUtility fu = new FileUtility();
		DatabaseUtility dbu = new DatabaseUtility();
		ExcelUtility eu = new ExcelUtility();
		WebdriverUtility wdu = new WebdriverUtility();
       
		int random = ju.getRandomNo();

		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");

        
		//Open Application


		WebDriver driver = new ChromeDriver();
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
				driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
				
				String user = "Shalini Gowda"+random;
				driver.findElement(By.name("username")).clear();
				driver.findElement(By.name("username")).sendKeys(user);
				
				wdu.scrollBarAction(driver);
				
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


