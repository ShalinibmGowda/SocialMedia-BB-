package com.Obj_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.utility.WebdriverUtility;

public class UserModulePage {
   //declaration
	
	 @FindBy(name="content_comment")
	   private WebElement commentarea;
	   
	   @FindBy(name="post_comment")
	   private WebElement enter;
	   
	   @FindBy(xpath="//a[@title='Delete your comment']/button")
	   private List<WebElement> deletecomment;
	   
	   //initialization
	   
	   public UserModulePage(WebDriver driver) {
				PageFactory.initElements(driver, this);
			}
	   
	   //utilization

	public WebElement getCommentarea() {
		return commentarea;
	}

	public WebElement getEnter() {
		return enter;
	}

	public List<WebElement> getDeletecomment() {
		return deletecomment;
	}
	
	//Business libraries
	public void addComment(String comment)
	{
		commentarea.sendKeys(comment);
		enter.click();
	}
	public void deleteComments(WebdriverUtility wu,WebDriver driver)
	{
		List<WebElement> dc = deletecomment;
		wu.scrollBarAction(driver);
		dc.get(0).click();
     }
	   
	   
}
