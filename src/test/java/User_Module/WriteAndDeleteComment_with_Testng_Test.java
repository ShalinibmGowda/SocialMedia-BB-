package User_Module;

import org.testng.annotations.Test;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.Obj_Repository.UserModulePage;
import com.generic.utility.BaseClass;

public class WriteAndDeleteComment_with_Testng_Test extends BaseClass {
	
	@Test(groups = {"smoke","regression"})
	public void deleteComment() throws Throwable
	{
		String Imgpath2 = fu.readDataFromPropertyFile("Imgpath2");
		String COMMENT = fu.readDataFromPropertyFile("comment");
		
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
	}

}
