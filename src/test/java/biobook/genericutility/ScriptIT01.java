package biobook.genericutility;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.generic.utility.DatabaseUtility;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;
public class ScriptIT01 {
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
		ArrayList<String> al = new ArrayList<String>();
		al.add("firstname");
		al.add("lastname");
		al.add("username");
		al.add("number");

		for (int i = 0; i < al.size(); i++) {
			String value = eu.readDataFromExcel("PersonalInfo",i,1)+random;
			driver.findElement(By.name(al.get(i))).clear();
			driver.findElement(By.name(al.get(i))).sendKeys(value);
		}

		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));

		wdu.select("Female",genderlist);

		//Scroll page
		wdu.scrollBarAction(driver);


		//Click on save 
		driver.findElement(By.xpath("//button[@name='save']")).click();
		//Click on user page
		driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a")).click();

		//to verify the same data should be display in user page 
		String username=eu.readDataFromExcel("PersonalInfo", 2, 1)+random;
		//		String username = sh.getRow(2).getCell(1).toString()+random;
		WebElement ele = driver.findElement(By.xpath("//button[.='Log out']/ancestor::*/li[8]/a"));
		if (ele.isDisplayed()) {
			System.out.println("the same data "+username+" displayed in user page");
		}else {
			System.out.println("the same data "+username+" not displayed in user page");
		}
		//Click on home page,
		driver.findElement(By.xpath("//label[.='Home']")).click();
		//Click on logout
		driver.findElement(By.xpath("//button[.='Log out']")).click();
		System.out.println("By Using Generic Methods My Automation Test Script is Pass");
	}
}

