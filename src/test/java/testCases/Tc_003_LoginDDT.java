package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.Base_Class;
import utilities.DataProviders;

public class Tc_003_LoginDDT extends Base_Class
{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
 public void test_loginDDT(String email, String password,String exp)
 {
	try {
		logger.info("***Starting TC_003_Logintest******");
		HomePage hp = new HomePage(driver);
		hp.clickMycount();
		logger.info("clicked on my account");
		hp.clicklogin();
		logger.info("open login page");
		
		Loginpage lp = new Loginpage (driver);
		
		logger.info("provide login credentials");
		
		lp.setEmail((email));
		lp.setPassword((password));
		lp.clickLogin();
	    
		logger.info("clicked on login btn");
		
		MyAccountPage map =new MyAccountPage(driver);
		boolean tragetpage = map.isMyAccountPageExist();
		
		if (exp.equals("Valid"))
		{
			if(tragetpage == true)
			{
				map.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
        if(exp.equals("Invalid"))
		{
			if(tragetpage == true)
			{
				map.logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}
 
	catch(Exception e)
	{
		Assert.fail();
	}
 }
}
