package User_Module;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.generic.utility.DatabaseUtility;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class WriteandDeleteComment_with_generic_Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
       
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wdu.maximizeWindow(driver);
		wdu.waitForPageLoad(driver);
		driver.get(URL);
		
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
						wdu.scrollBarAction(driver);					}
				}
				System.out.println("Deleted the comment successfully");
				driver.findElement(By.xpath("//label[text()='Home']")).click();
				driver.findElement(By.xpath("//button[text()='Log out']")).click();
			
		



	}

}
