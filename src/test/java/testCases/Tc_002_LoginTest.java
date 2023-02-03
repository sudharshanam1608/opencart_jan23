package testCases;

import org.testng.Assert;
import org.testng.annotations.*;

import pageObjects.HomePage;
import pageObjects.Loginpage;
import pageObjects.MyAccountPage;
import testBase.Base_Class;

public class Tc_002_LoginTest extends Base_Class

{
@Test(groups={"Sanity","Master"})
public void test_login()
{
	try {
	logger.info("***Start the Tc_002****");
	
	HomePage hp = new HomePage(driver);
	hp.clickMycount();
	hp.clicklogin();
	
	logger.info("loginpage openned");
	Loginpage lp = new Loginpage (driver);
	
	lp.setEmail(rb.getString("email"));
	lp.setEmail(rb.getString("password"));
	lp.clickLogin();
	
	logger .info("click on login");
	MyAccountPage map = new MyAccountPage(driver);
	boolean targetpage = map.isMyAccountPageExist();
	Assert.assertEquals(targetpage, true,"invalid login data");}
	catch(Exception e) {
		Assert.fail();
}
	logger.info("*** Finished Tc_002***");
	
	
	
	
}
}
