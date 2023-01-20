package User_Module;

import java.util.Iterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.Obj_Repository.SigninPage;
import com.Obj_Repository.UserModulePage;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class WriteAndDeleteComment_with_ObjRep_Test {

	public static void main(String[] args) throws Throwable {
    
		 JavaUtility ju= new JavaUtility();
	        int ranno = ju.getRandomNo();
	       ExcelUtility eu = new ExcelUtility();

		WebdriverUtility wu = new WebdriverUtility();
		FileUtility fu=new FileUtility();
		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		String Imgpath2 = fu.readDataFromPropertyFile("Imgpath2");
		String COMMENT = fu.readDataFromPropertyFile("comment");
		
		//open application
		WebDriver driver = new ChromeDriver();
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(URL);

		//Login as user
		SigninPage sinp = new SigninPage(driver);
		sinp.getSignin().click();
		sinp.LogIntoApp(EMAIL, PASSWORD);
		// goto profile module
		HomePage hp = new HomePage(driver);
		hp.getProfilemodule().click();
		//update profile
		ProfileModulePage pmp = new ProfileModulePage(driver);
		pmp.getUpdateProfile().click();
		pmp.updatePicture(Imgpath2);
		//goto user module add a comment and delete comment
		hp.getUsermodule().click();
		UserModulePage ump = new UserModulePage(driver);
		ump.addComment(COMMENT);
		ump.deleteComments(wu,driver);
		hp.getHomemodule().click();
		hp.getLogout().click();
	}
}
