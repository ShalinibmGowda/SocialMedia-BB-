package com.Obj_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {
	
       //declaration
	
	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signin;
	
	@FindBy(name="email")
	private WebElement emailtxt;
	
	@FindBy(name="password")
	private WebElement passwordtxt;
	
	@FindBy(xpath="//input[@title='Log in']")
	private WebElement loginbtn;
	
	
	//Initialization
	public SigninPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getSignin() {
		return signin;
	}

	public WebElement getEmailtxt() {
		return emailtxt;
	}

	public WebElement getPasswordtxt() {
		return passwordtxt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Business libraries
	 public void LogIntoApp(String email,String password)
	 {
		 emailtxt.sendKeys(email); 
		 passwordtxt.sendKeys(password);
		 loginbtn.click();
	 }

	
	
	
	
}
