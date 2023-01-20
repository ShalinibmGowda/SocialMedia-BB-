package Profile_Module;

import java.util.ArrayList;

import org.testng.annotations.Test;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.PhotosModulePage;
import com.Obj_Repository.ProfileModulePage;
import com.generic.utility.BaseClass;

public class EditProfileAndUPdateprofilePhoto_with_Testng extends BaseClass{
	
	@Test(groups = "smoke")
	public void editProfileandUpdateProfile() throws Throwable
	{
		String Imgpath = fu.readDataFromPropertyFile("Imgpath");
		String Imgpath2 = fu.readDataFromPropertyFile("Imgpath2");
		
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
	}

}
