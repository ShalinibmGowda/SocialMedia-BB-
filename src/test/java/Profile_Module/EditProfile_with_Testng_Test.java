package Profile_Module;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.generic.utility.BaseClass;

public class EditProfile_with_Testng_Test extends BaseClass {
	
	@Test(groups = {"smoke","regression"})
	public void editProfile() throws Throwable
	{
		//Click on profile page and  Edit  personal info
				HomePage hp = new HomePage(driver);
				hp.getProfilemodule().click();
				ProfileModulePage pmp = new ProfileModulePage(driver);
				pmp.getEditprofile().click();
				
				ArrayList<String> al = eu.getArrayList("PersonalInfo",1);
				pmp.editProfile(al,ranno);
				wu.scrollBarAction(driver);
				pmp.getSaveprofile().click();
				hp.getUsermodule().click();
				
				WebElement ele = hp.getUsermodule();
				if (ele.isDisplayed()) {
					System.out.println("the same data "+ele.getText()+" displayed in user page");
				}else {
					System.out.println("the same data "+ele.getText()+" not displayed in user page");
				}
				
				hp.getHomemodule().click();
	}
	
	

}
