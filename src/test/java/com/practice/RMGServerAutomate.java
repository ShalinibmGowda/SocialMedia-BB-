package com.practice;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RMGServerAutomate {
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {
		//Project created in App through automated
		System.setProperty("webdriver.gecko.driver", "./Softwares/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.get("http://rmgtestingserver:8084/dashboard/projects");
		Thread.sleep(5000);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		Thread.sleep(2000);
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("BioBook(SocialMedia)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mr Khan");
		Thread.sleep(2000);
		WebElement drop = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select s = new Select(drop);
		s.selectByValue("Created");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		Thread.sleep(2000);
		System.out.println("Project added successfully");

		//validating in database project created by Mr Khan

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		String url = "jdbc:mysql://rmgtestingserver:3333/projects";
		String user = "root@%";
		String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM project;");
			boolean flag = false;
			while (rs.next()) {
				String Expected_Created_By = "Mr Khan";
				String Actual_Created_By = rs.getString(2);
				System.out.println(Actual_Created_By);
				if (Expected_Created_By.equalsIgnoreCase(Actual_Created_By)) {
					System.out.println("My Test case is Pass");
					flag=true;
					break;
				}
			}
			if (flag==true) {
				System.out.println("Yes My Project is Found in RMG Database Server");
			}
			System.out.println("Creating new project through Database Query Executed Succesfully");

			//Creating new project through Database query

			//st.executeUpdate("insert into project values('TY_BioBook_006','Mr Khan 1','21-12-2022','BioBook','Created',5);");
			
			Thread.sleep(2000);
			WebElement MyProject = driver.findElement(By.xpath("//td[.='TY_BioBook_006']"));
			if (MyProject.isDisplayed()) {
				System.out.println("Yes My Project is Visible in Web Application");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				if (st != null) {
					st.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
