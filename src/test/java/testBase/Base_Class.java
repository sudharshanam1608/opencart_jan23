
package testBase;

import java.io.File;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class Base_Class

{

	public static WebDriver driver;
	public Logger logger; // for logging
	public ResourceBundle rb; // f
	
	@BeforeClass(groups= {"Master","sanity","Regression"})
	@Parameters("browser")
	
	public void setup(String br)
	
	{
		
		rb=ResourceBundle.getBundle("config");// load config data
		logger =LogManager.getLogger(this.getClass());
	//WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		driver = new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
			
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(rb.getString("appURL2"));
		
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		String GenString = RandomStringUtils.randomAlphabetic(12);
		return (GenString);
	}
    public String randomNumber()
    {
	String GenNumber = RandomStringUtils.randomNumeric(10);
	return (GenNumber); 
    }
    public String randomAlphanumeric()
   {
	   String st =RandomStringUtils.randomAlphanumeric(6);
	   String num = RandomStringUtils.randomAlphanumeric(4);
	   return(st+num);
   }
    
    public String  captureScreen(String tname) 
    {
    	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());  //times tamp
    	
    	TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
    	File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
    	String destination =System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
    	
    	try
    	{
    		FileUtils.copyFile(source, new File(destination));
    	}
    	catch(Exception e)
    	{
    		e.getMessage();
    	}
    	return destination;
    	
    	
    }
}
