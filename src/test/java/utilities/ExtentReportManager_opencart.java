package utilities;



import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.Base_Class;

public class ExtentReportManager_opencart  implements ITestListener  
{
	public ExtentSparkReporter sparkReporter;  // UI of the report
	public ExtentReports extent;  //populate common info on the report
	public ExtentTest test; // creating test case entries in the report and update status of the test methods
	
	String repName;

	public void onStart(ITestContext testcontext)
	{
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());  //timestamp
		repName="Test-Report-"+timeStamp+".html";
			
		sparkReporter=new ExtentSparkReporter( ".\\reports\\"+ repName);//specify location of the report
		sparkReporter.config().setDocumentTitle("opencart Automation Report"); // TiTle of report
		sparkReporter.config().setReportName("opencart Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("application","opencart");
		extent.setSystemInfo("Module","admin");
		extent.setSystemInfo("SubModule","Customers");
		extent.setSystemInfo("Operating system",System.getProperty("os.name"));
		extent.setSystemInfo("User Name",System.getProperty("user.name"));
		extent.setSystemInfo("environment", "QA");
					
	}


	public void onTestSuccess(ITestResult result) {
		
		test = extent.createTest(result.getName());    // create a new entry in the report
		test.log(Status.PASS, "Test case PASSED is:" + result.getName());   // update status p/f/s
		
	}

	public void onTestFailure(ITestResult result)  
	{
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case FAILED is:" + result.getName());
		test.log(Status.FAIL, result.getThrowable().getMessage()); 
		try
		{
			String imgpath = new Base_Class().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgpath);
		}
	catch(Exception e1)
		{
		e1.printStackTrace();
		}
	}
	
	
public void onTestSkipped(ITestResult result)
	
	{
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case SKIPPED is:" + result.getName());
		test.log(Status.SKIP, result.getThrowable().getMessage());	
	}


	public void onFinish(ITestContext testcontext) 
	{
		extent.flush();
	
	
	/*  try{
		  URL url = new
	      
	  URL("file:///"+System.getProperty("user.dir")+"\\reports\\"+repName);
	  
	  //create the email message
	   ImageHtmlEmail email = new ImageHtmlEmail();
	   email.setDataSourceResolver(new DataSourceResolver(url));
	   email.setHostName("smtp.googlemail.com");
	   email.setSmtpPort (465) ;
	   email.setAuthenticator (new DefaultAuthenticator ("pavanoltraining@gmail.com", "password")); 
	   email.setSSLOnConnect (true) ;
	   email.setFrom("pavanoltraining@gmail.com"); //Sender
	   email.setSubject ("Test Results");
	   email.setMsg("Please find Attached Report.... ");
	   email. addTo("pavankumar. busya@gmail.com"); //Receiver 
	   email.attach(url,"extent report", "please check report..."); 
	   
	   email.send();  // send the email
	   		 }
	  catch (Exception e) 
	  { 
		  e.printStackTrace ();
	  }
	  */
	  
	}
}
		

	



