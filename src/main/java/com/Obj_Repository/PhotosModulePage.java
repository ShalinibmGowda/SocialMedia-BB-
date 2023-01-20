package com.Obj_Repository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhotosModulePage {
    
	//declaration
	
	@FindBy(xpath="//input[@type='file']")
	private WebElement coosefilephoto;
	
	@FindBy(xpath="//button[text()='Add Photos']")
	private WebElement addphotos;
	
	@FindBy(xpath="//div[@class='photo-select']//a[@class='btn-delete-photos']")
	private List<WebElement> deletePhoto;
	
	//initialization
	
	public PhotosModulePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getCoosefilephoto() {
		return coosefilephoto;
	}

	public WebElement getAddphotos() {
		return addphotos;
	}

	public List<WebElement> getDeletePhotos() {
		return deletePhoto;
	}
	
	
	//Business libraries
	
	public void addPhotoModule(String Image)
	{
		coosefilephoto.sendKeys(Image);
		addphotos.click();
	}
	public void deletePhotos()
	{
		List<WebElement> del=deletePhoto;
		del.get(0);
	}
}
