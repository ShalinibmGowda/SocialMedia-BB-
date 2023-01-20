package Profile_Module;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.generic.utility.BaseClass;

public class EditUsername_with_Testng_Test  extends BaseClass{
	
	@Test(groups = "regression")
	public void editUsername() throws Throwable
	{
		//Click on profile page and  Edit  personal info
				HomePage hp = new HomePage(driver);
				hp.getProfilemodule().click();
				ProfileModulePage pmp = new ProfileModulePage(driver);
				pmp.getEditprofile().click();
				String newuser = eu.readDataFromExcel("PersonalInfo",2,1);
				pmp.getUserName().clear();
				pmp.getUserName().sendKeys(newuser);
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
	
	@Test
	public void canaraBank()
	{
		System.out.println("Register to the canara bank");
	}
	
	@Test
	public void hdfcBank()
	{
		System.out.println("Register to the HDFC bank");
	}
	
	

}
