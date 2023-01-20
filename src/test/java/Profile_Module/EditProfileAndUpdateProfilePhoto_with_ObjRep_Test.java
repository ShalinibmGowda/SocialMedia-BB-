package Profile_Module;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.PhotosModulePage;
import com.Obj_Repository.ProfileModulePage;
import com.Obj_Repository.SigninPage;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;

public class EditProfileAndUpdateProfilePhoto_with_ObjRep_Test {

	public static void main(String[] args) throws Throwable {
		 JavaUtility ju= new JavaUtility();
	        int ranno = ju.getRandomNo();
	       ExcelUtility eu = new ExcelUtility();

		WebdriverUtility wu = new WebdriverUtility();
		FileUtility fu=new FileUtility();
		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		String Imgpath = fu.readDataFromPropertyFile("Imgpath");
		String Excelpath = fu.readDataFromPropertyFile("Excelpath");
		String Imgpath2 = fu.readDataFromPropertyFile("Imgpath2");
		
		
		//open application
		WebDriver driver = new ChromeDriver();
		wu.maximizeWindow(driver);
		wu.waitForPageLoad(driver);
		driver.get(URL);

		//Login as user
		SigninPage sinp = new SigninPage(driver);
		sinp.getSignin().click();
		sinp.LogIntoApp(EMAIL, PASSWORD);
		
		HomePage hp = new HomePage(driver);
		hp.getProfilemodule().click();
		
		ProfileModulePage pmp = new ProfileModulePage(driver);
		pmp.getEditprofile().click();
		ArrayList<String> al = eu.getArrayList("PersonalInfo",1);
		pmp.editProfile(al, ranno);
		wu.scrollBarAction(driver);
		pmp.getSaveprofile().click();
		//Update picture and save it
		pmp.getUpdateProfile().click();
		pmp.updatePicture(Imgpath);
		//click on photo module
		PhotosModulePage pp = new PhotosModulePage(driver);
		hp.getPhotosmodule().click();
		pp.addPhotoModule(Imgpath2);
		//Click on logout
		hp.getLogout().click();
	}

}
