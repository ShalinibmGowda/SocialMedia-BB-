package com.generic.utility;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.Obj_Repository.HomePage;
import com.Obj_Repository.SigninPage;
import com.aventstack.extentreports.Status;

public class BaseClass {
	
	public WebDriver driver=null;
	public static WebDriver sdriver;
	public FileUtility fu=new FileUtility();
	public ExcelUtility eu=new ExcelUtility();
	public JavaUtility ju=new JavaUtility();
	public  int ranno = ju.getRandomNo();
	public DatabaseUtility dbu=new DatabaseUtility();
	public WebdriverUtility wu=new WebdriverUtility();
	
	@BeforeSuite
	public void connectDataBase() throws Throwable
	{
		dbu.connectToDB();
		System.out.println("Connect to the Database");
	}
//	@Parameters("BROWSER")
	
	@BeforeClass(groups = {"smoke","regression"})
	public void launchBrowser()
	{
		
		driver=wu.openBrowser("Chrome");
		sdriver=driver;
		ListenerImplementationClass.test.log(Status.INFO, "-------Chrome Browser is open succesfully--");
		System.out.println("launch the browser");
		wu.maximizeWindow(driver);
    }
	
	@BeforeMethod(groups = {"smoke","regression"})
	public void logIntoApp() throws Throwable
	{
		
		String URL = fu.readDataFromPropertyFile("url");
		String EMAIL = fu.readDataFromPropertyFile("email");
		String PASSWORD = fu.readDataFromPropertyFile("password");
		driver.get(URL);
		wu.waitForPageLoad(driver);
		
		SigninPage sp = new SigninPage(driver);
		sp.getSignin().click();
		sp.LogIntoApp(EMAIL, PASSWORD);
		ListenerImplementationClass.test.log(Status.INFO, "----login biobook succesfully");
		System.out.println("login to the application");
		
	}
	
	@AfterMethod(groups = {"smoke","regression"})
	public void logOutApp()
	{
		HomePage hp = new HomePage(driver);
		hp.getLogout();
		System.out.println("logout the application");
		ListenerImplementationClass.test.log(Status.INFO, "-----logout from biobook successfully----");
	}
	
	@AfterClass(groups = {"smoke","regression"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("close the browser");
		ListenerImplementationClass.test.log(Status.INFO, "---chrome browser close successfully--");
	}
	
	@AfterSuite
	public void closeDB() throws Throwable
	{
		dbu.closeDataBase();
		System.out.println("close the Database");
	}
	
	
	
	
	

}
