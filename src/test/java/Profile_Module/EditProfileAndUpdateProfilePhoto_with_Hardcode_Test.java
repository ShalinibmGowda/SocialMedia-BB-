
package Profile_Module;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
public class EditProfileAndUpdateProfilePhoto_with_Hardcode_Test {
	public static void main(String[] args) throws Throwable {
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		Properties p = new Properties();
		FileInputStream fis = new FileInputStream("./src/test/resources/BioBookcommondata.Properties");
		p.load(fis);
		String URL = p.getProperty("url");
		String EMAIL = p.getProperty("email");
		String PASSWORD = p.getProperty("password");
		String Excelpath = p.getProperty("Excelpath");
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
		
		//Click on profile page and  Edit  personal info 
		driver.findElement(By.xpath("//label[.='Profile']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Edit Profile']")).click();
		Thread.sleep(2000);
		ArrayList<String> al = new ArrayList<String>();
		al.add("firstname");
		al.add("lastname");
		al.add("username");
		al.add("number");
		//Getting data from excel file
		FileInputStream fi = new FileInputStream(Excelpath);
		Workbook book = WorkbookFactory.create(fi);
		Sheet sh = book.getSheet("PersonalInfo");
		for (int i = 0; i < al.size(); i++) {
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name(al.get(i))).clear();
			driver.findElement(By.name(al.get(i))).sendKeys(value);
			Thread.sleep(2000);
		}
		WebElement genderlist = driver.findElement(By.xpath("//select[@name='gender']"));
		Select s=new Select(genderlist);
		s.selectByVisibleText("Female");
		//Scroll page
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(200,100)");
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
