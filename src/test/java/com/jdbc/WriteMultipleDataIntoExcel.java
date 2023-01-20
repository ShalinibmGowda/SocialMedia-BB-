package com.jdbc;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class WriteMultipleDataIntoExcel {
	static int count = 0;
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
	    Sheet sh = book.getSheet("Sheet3");
		WebDriver driver = new ChromeDriver(); //To open browser
		Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		Thread.sleep(10000);
		List<WebElement> link = driver.findElements(By.xpath("//a"));
		int linkcount = link.size();
		System.out.println("The total link in amazon are : "+linkcount);
		for( WebElement links:link) {
			Row ro = sh.createRow(count);
			System.out.println(count);
			Cell cel = ro.createCell(0);
			cel.setCellValue(links.getAttribute("href"));
			count=count+1;
		}
		Thread.sleep(2000);
	    FileOutputStream fout = new FileOutputStream("./src/test/resources/TestData1.xlsx");
	    book.write(fout); 
	    System.out.println("Completed");
	}
}
