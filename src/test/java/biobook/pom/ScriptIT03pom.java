package biobook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Obj_Repository.HomeModulePage;
import com.Obj_Repository.HomePage;
import com.Obj_Repository.SigninPage;
import com.generic.utility.FileUtility;
import com.generic.utility.WebdriverUtility;

public class ScriptIT03pom {
   public static void main (String[] args) throws Throwable {
	     WebdriverUtility wu = new WebdriverUtility();
	     FileUtility fu=new FileUtility();
	     String URL = fu.readDataFromPropertyFile("url");
	     String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		String Imgpath = fu.readDataFromPropertyFile("Imgpath");
		//open application
		WebDriver driver = new ChromeDriver();
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(URL);
		
			//Login as user
		SigninPage sinp = new SigninPage(driver);
		sinp.getSignin().click();
		sinp.LogIntoApp(EMAIL, PASSWORD);
		//Click on home page,
           HomePage hp = new HomePage(driver);
           hp.getHomemodule().click();
   		//Write the comments,
             HomeModulePage hmp = new HomeModulePage(driver);
             hmp.shareStatus("Happy morning",Imgpath);
     		//Click on logout
           WebElement logout = hp.getLogout();
           logout.click();
   }
	
}
