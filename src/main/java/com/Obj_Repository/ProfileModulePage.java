package com.Obj_Repository;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utility.JavaUtility;

public class ProfileModulePage {
    
	//declaration
	@FindBy(xpath="//button[text()='Edit Profile']")
	private WebElement editprofile;
	
	@FindBy(name="firstname")
	private WebElement FirstName;
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(name="username")
	private WebElement UserName;
	
	@FindBy(name="birthday")
	private WebElement BirthDay;
	
	@FindBy(xpath="//select[@name='gender']/child::option[3]")
	private WebElement Gender;
	
	@FindBy(name="number")
	private WebElement PhoneNumber;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveprofile;
	
	@FindBy(xpath="//button[text()='Update Picture']")
	private WebElement updateProfile;
	
	@FindBy(xpath="(//input[@name='image'])[1]")
	private WebElement choosefileProfile;
	
	@FindBy(xpath="//input[@value='save']")
	private WebElement saveprofilePhoto;
   
	 //initialization
	   
	   public ProfileModulePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	   
	   //utilization
	   
	public WebElement getEditprofile() {
		return editprofile;
	}

	public WebElement getFirstName() {
		return FirstName;
	}

	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getUserName() {
		return UserName;
	}

	public WebElement getBirthDay() {
		return BirthDay;
	}

	public WebElement getGender() {
		return Gender;
	}

	public WebElement getNumber() {
		return PhoneNumber;
	}

	public WebElement getSaveprofile() {
		return saveprofile;
	}

	public WebElement getUpdateProfile() {
		return updateProfile;
	}

	public WebElement getChoosefileProfile() {
		return choosefileProfile;
	}

	public WebElement getSaveprofilePhoto() {
		return saveprofilePhoto;
	}
	
	//Business libraries
	
	public void editProfile(ArrayList<String> al,int a)
	{
		FirstName.clear();
		FirstName.sendKeys(al.get(0));
		LastName.clear();
		LastName.sendKeys(al.get(1));
		UserName.clear();
		UserName.sendKeys(al.get(2)+a);
		BirthDay.clear();
		BirthDay.sendKeys(al.get(3));
		Gender.click();
		PhoneNumber.clear();
		PhoneNumber.sendKeys(al.get(4));
	}
	
	public void updatePicture(String img)
	{
		
		choosefileProfile.sendKeys(img);
		saveprofilePhoto.click();
	}

	
}