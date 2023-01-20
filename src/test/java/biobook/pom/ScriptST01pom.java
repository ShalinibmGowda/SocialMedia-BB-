package biobook.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.Obj_Repository.SigninPage;
import com.generic.utility.FileUtility;
import com.generic.utility.WebdriverUtility;

public class ScriptST01pom {
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

		//Click on profile page
		HomePage hp = new HomePage(driver);
		hp.getProfilemodule().click();

		//Click on profile photo, take photo from external Resources, Able to click on add button,
		ProfileModulePage pmp = new ProfileModulePage(driver);

		pmp.getUpdateProfile().click();
		pmp.updatePicture(Imgpath);

		//Click on home page,
		hp.getHomemodule().click();
		//Click on user page
		hp.getUsermodule().click();
		//Click on logout
		hp.getLogout().click();
		System.out.println("Test case pass");

	}
}
