package basePackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Timeutils;



public class BaseHRMClass {

	public static Properties prop=new Properties(); //create object of properties class
	public static WebDriver driver; //declare WebDriver as Global so we can use it globally 
	
	 
	public BaseHRMClass()  //Create Constructor of the class
	{
		try {
		FileInputStream file=new FileInputStream("E:\\Roicians\\Eclipse\\HRManagement\\src\\test\\java\\enviromentvariables\\Config.properties"); 
		prop.load(file);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException a)
		{
			a.printStackTrace();
		}
		
		}
	public static void initiat()
	{
	String browsername=	prop.getProperty("browser");
	if(browsername.equals("Firefox")) 
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Timeutils.implicitwait));
	driver.get(prop.getProperty("url")); //calling the url from config file
	
	}
	public static void screenshots(String Filename)
	{
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(file, new File("E:\\Roicians\\Eclipse\\HRManagement\\src\\test\\java\\screenshots\\screenshots" +Filename+".jpg"));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
}
