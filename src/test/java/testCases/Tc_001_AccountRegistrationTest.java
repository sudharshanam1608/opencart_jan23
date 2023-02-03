package testCases;


import java.util.ResourceBundle;

import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.Base_Class;

public class Tc_001_AccountRegistrationTest extends Base_Class

{
	
	public ResourceBundle rb;

@Test(groups = {"Regression","Master"})
public void test_Account_Registration()

{
	rb=ResourceBundle.getBundle("config");
	logger.info("*** Starting Tc_001_AccountRegistrationTest ***");
	
	
try {
	
	HomePage hp = new HomePage(driver);
	hp.clickMycount();
	logger.info("Clicked on my accouny link");
	hp.clickRegisterAcc();
	logger.info("Clicked on regiister link");
	AccountRegistrationPage rp = new AccountRegistrationPage(driver);
 
	logger.info("providing customer data");

	rp.setFirstName(randomString().toUpperCase());
	rp.setLastName(randomString().toUpperCase());
    rp.setEmail(randomAlphanumeric()+"@gmail.com");
    rp.setPassword(rb.getString("password"));
    rp.setPrivacyPolicy();
    rp.clickContinue();
    logger.info("clicked on continue");
    String  confirmmsg= rp.getConfirmationMsg();
	logger.info("validating the data");
    
    Assert.assertEquals(confirmmsg, "Your Account Has Been Created");

}
catch (Exception e)
{	logger.info("test failed");
	Assert.fail();
}
logger.info("test finished");
	
}
	

}
