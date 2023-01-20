package Home_Module;


import static org.testng.Assert.*;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Obj_Repository.HomeModulePage;
import com.Obj_Repository.HomePage;
import com.generic.utility.BaseClass;

@Listeners(com.generic.utility.ListenerImplementationClass.class) 
public class ShareStatus_with_Testng_Test extends BaseClass {
	
	@Test(retryAnalyzer = com.generic.utility.RetryImplementationClass.class)
	public void shareStatus() throws Throwable
	{
		//Click on home page,
        HomePage hp = new HomePage(driver);
        hp.getHomemodule().click();
		//Write the comments,
          HomeModulePage hmp = new HomeModulePage(driver);
          String Imgpath = fu.readDataFromPropertyFile("Imgpath");
          fail();
          hmp.shareStatus("Happy morning",Imgpath);
         
          
  		//Click on logout
       hp.getLogout().click();
	}

}
