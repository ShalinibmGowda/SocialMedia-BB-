package biobook.genericutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.generic.utility.DatabaseUtility;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class ScriptST01 {

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
		String  Imgpath= fu.readDataFromPropertyFile("Imgpath");

        
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
				
				//Click on profile photo, take photo from external Resources, Able to click on add button,
				driver.findElement(By.xpath("//label[.='Photos']")).click();
				driver.findElement(By.xpath("(//input[@name='image'])[1]")).sendKeys(Imgpath);
				driver.findElement(By.xpath("//button[@name='Submit']")).click();
				//Click on profile page
				driver.findElement(By.xpath("//label[.='Profile']")).click();
				//Click on home page,
				driver.findElement(By.xpath("//label[.='Home']")).click();
				//Click on user page
				driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();
				//Click on logout
				driver.findElement(By.xpath("//button[.='Log out']")).click();
				System.out.println("Test case pass");

	}

}
