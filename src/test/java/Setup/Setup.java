package Setup;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {
	public  static WebDriver driver;
	public static Properties prop;
	
	public void driverSetup()
	{
	prop=new Properties();
	try 
	{
		prop.load(new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\TestAutomation\\src\\test\\resources\\config.properties"));
	}	
	 catch (Exception e) 
	{
		e.printStackTrace();
	}
	if(prop.getProperty("browserName").matches("chrome"))
	{
		
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\eclipse-workspace\\gadget automation\\driver\\chromedriver.exe");
		//driver=new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		
	}
	if(prop.getProperty("browserName").matches("firefox"))
	{
		// System.setProperty("webdriver.gecko.driver", driverPath);
	       
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\gadget automation\\driver\\geckodriver.exe");
		 //driver = new FirefoxDriver();
		WebDriverManager.firefoxdriver().setup();
		 driver = new ChromeDriver();
		
	}
	/*driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);*/
}
	public void closeBrowser()
	{
		driver.quit();
	}

}
