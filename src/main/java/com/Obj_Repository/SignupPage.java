package com.Obj_Repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPage {
	
  //declaration
	
	@FindBy(xpath="//button[text()='Sign up']")
	private WebElement signup;
	
	@FindBy(name="firstname")
	private WebElement Firstnametxt;
	
	@FindBy(name="lastname")
	private WebElement Lastnametxt;
	
	@FindBy(name="username")
	private WebElement Usernametxt;
	
	@FindBy(name="username2")
     private WebElement	Usernametxt2;
	
	@FindBy(name="day")
	private WebElement dayDD;
	
	@FindBy(name="month")
	private WebElement monthDD;
	
	@FindBy(name="year")
	private WebElement yearDD;
	
	//@FindBy(xpath="//input[@name='email']")
	//private WebElement email;
	
	//Initialization
	
}

