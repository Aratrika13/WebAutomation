package ECommerce;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import Setup.Setup;

public class Flipkart extends Setup{
	
	//public static Properties prop;
	List<WebElement> Productname;
	List<WebElement> price;
	
	
	public void openUrl()
	{
		
		 driver.get(prop.getProperty("url"));
	}
	public void searchItem() throws IOException
	{
		
		driver.findElement(By.xpath(prop.getProperty("Product_name"))).sendKeys("Geysers");
		driver.findElement(By.xpath(prop.getProperty("Product_search"))).sendKeys(Keys.ENTER);
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		//Call getScreenshotAs method to create image file
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File des=new File(prop.getProperty("screenshot")+"sc1.png");
		
		FileUtils.copyFile(SrcFile, des);
	}
	public void filterPrice() throws IOException
	{
		
		//Select objSelect = new Select(driver.findElement(By.xpath((//select[@class='_2YxCDZ'])[1])));
		WebElement Pricedropdown1 = driver.findElement(By.xpath(prop.getProperty("Pricedropdown1")));
		Select obj1 = new Select(Pricedropdown1);
		obj1.selectByValue("1000");
		 
		
		WebElement Pricedropdown2 = driver.findElement(By.xpath(prop.getProperty("Pricedropdown2")));
		Select obj2 = new Select(Pricedropdown2);
		obj2.selectByValue("5000");
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		File des=new File(prop.getProperty("screenshot")+"sc2.png");
		
		FileUtils.copyFile(SrcFile, des);
	}
	public void sortItem() throws  IOException, InterruptedException
	{
		
		WebElement sort = driver.findElement(By.xpath(prop.getProperty("sorting")));
		sort.click();
	    Thread.sleep(2000);
	    TakesScreenshot scrShot =((TakesScreenshot)driver);
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
		//Move image file to new destination
		
		File des=new File(prop.getProperty("screenshot")+"sc3.png");
		FileUtils.copyFile(SrcFile, des);
	}
	public void getProductName()
	{
		 Productname=driver.findElements(By.className(prop.getProperty("productname")));
	}
	public void getProductPrice()
	{
	price=driver.findElements(By.xpath(prop.getProperty("productprice")));
	}
	public void display()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println((i+1)+" "+Productname.get(i).getText());
			System.out.println(price.get(i).getText());
			System.out.println();
		}
	}
	public static void main(String[] args) throws InterruptedException, IOException{
		Flipkart ha= new Flipkart();
		ha.driverSetup();
		ha.openUrl();
		ha.searchItem();
		ha.filterPrice();
		ha.sortItem();
		ha.getProductName();
		ha.getProductPrice();
		ha.display();
		ha.closeBrowser();
	}
}
