package com.Obj_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	
	//declaration

	@FindBy(xpath="//button[text()='Sign in']")
	private WebElement signin;
	
	@FindBy(xpath="//button[text()='Sign up']")
	private WebElement signup;
	
	//Initialization
	public void SigninPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
  //utilization
	public WebElement getSignin() {
		return signin;
	}

	public WebElement getSignup() {
		return signup;
	}
	
	
}
