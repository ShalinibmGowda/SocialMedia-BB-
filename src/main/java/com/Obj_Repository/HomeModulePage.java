package com.Obj_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeModulePage {
	
	     //declaration

	   @FindBy(xpath="//textarea[@name='content']")
	   private WebElement textarea;
	   
	   @FindBy(xpath="(//input[@name='image'])[1]")
	   private WebElement choosefile;
	   
	   @FindBy(xpath="//button[.='Share']")
	   private WebElement share;
	   
	   @FindBy(name="content_comment")
	   private WebElement commentarea;
	   
	   @FindBy(name="post_comment")
	   private WebElement enter;
	   
	   @FindBy(xpath="(//a[@title='Delete your post']/button[@class='btn-delete'])[1]")
	   private WebElement deletestatus;
	   
	   @FindBy(xpath="//a[@title='Delete your comment']/button")
	   private List<WebElement> deletecomment;
	   
	   //initialization
	   
	   public HomeModulePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
	   
	   //utilization

	public WebElement getTextarea() {
		return textarea;
	}

	public WebElement getChoosefile() {
		return choosefile;
	}

	public WebElement getShare() {
		return share;
	}

	public WebElement getCommentarea() {
		return commentarea;
	}

	public WebElement getEnter() {
		return enter;
	}

	public WebElement getDeletestatus() {
		return deletestatus;
	}

	public List<WebElement> getDeletecomment() {
		return deletecomment;
	}
	   
	//Business libraries	
	
	public void shareStatus(String text,String image) throws Throwable
	{
		textarea.sendKeys(text);
		choosefile.sendKeys(image);
		Thread.sleep(5000);
		share.click();
	}
	
}

