package com.Obj_Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
     
	//declaration
	@FindBy(xpath="//label[text()='Home']")
	private WebElement Homemodule;
	
	@FindBy(xpath="//label[text()='Profile']")
	private WebElement Profilemodule;
	
	@FindBy(xpath="//label[text()='Photos']")
	private WebElement Photosmodule;
	
	@FindBy(xpath="//button[@value='Log out']")
	private WebElement logout;
	
	@FindBy(xpath="//button[text()='Log out']/ancestor::*/li[8]")
	private WebElement Usermodule;
	
	//Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization

	public WebElement getHomemodule() {
		return Homemodule;
	}

	public WebElement getProfilemodule() {
		return Profilemodule;
	}

	public WebElement getPhotosmodule() {
		return Photosmodule;
	}

	public WebElement getLogout() {
		return logout;
	}

	public WebElement getUsermodule() {
		return Usermodule;
	}
	
	
	
	
	
	
}
