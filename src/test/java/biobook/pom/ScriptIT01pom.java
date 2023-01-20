package biobook.pom;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.ProfileModulePage;
import com.Obj_Repository.SigninPage;
import com.generic.utility.ExcelUtility;
import com.generic.utility.FileUtility;
import com.generic.utility.JavaUtility;
import com.generic.utility.WebdriverUtility;
public class ScriptIT01pom {
	public static void main(String[] args) throws Throwable {
        JavaUtility ju= new JavaUtility();
        int ranno = ju.getRandomNo();
		FileUtility fu=new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		WebdriverUtility wu = new WebdriverUtility();
		WebDriver driver = new ChromeDriver();
		wu.maximizeWindow(driver);
		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		driver.get(URL);
		SigninPage sp= new SigninPage(driver);
		sp.getSignin().click();
		sp.LogIntoApp(EMAIL,PASSWORD);
		//Click on profile page and  Edit  personal info
		HomePage hp = new HomePage(driver);
		hp.getProfilemodule().click();
		ProfileModulePage pmp = new ProfileModulePage(driver);
		pmp.getEditprofile().click();
//		Map<String, String> keyvalue = eu.getList("PersonalInfo", 0, 1);
//		for (Entry<String, String> entry : keyvalue.entrySet()) {
//			driver.findElement(By.name(entry.getKey())).clear();
//			driver.findElement(By.name(entry.getKey())).sendKeys(entry.getValue());
//		}
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
		hp.getLogout().click();
	}
}


