package Photo_Module;

import org.testng.annotations.Test;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.generic.utility.BaseClass;

public class Addphoto_with_Testng_Test extends BaseClass{
     
	@Test(groups = "regression")
	public void addPhoto() throws Throwable
	{
		String Imgpath = fu.readDataFromPropertyFile("Imgpath");
		
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
		
	}
}
