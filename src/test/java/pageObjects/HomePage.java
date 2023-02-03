package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


@SuppressWarnings("unused")
public class HomePage extends BasePage
{

public HomePage (WebDriver driver)
{
	super(driver);
}

//Elements

@FindBy(xpath ="//span[text()='My Account']")
WebElement lnkMyaccount;

@FindBy (linkText = "Register")
WebElement lnkRegister;

@FindBy (linkText = "Login")
WebElement lnklogin;

//Action Methods

public void clickMycount()
{
	lnkMyaccount.click();
}

public void clickRegisterAcc()
{
	lnkRegister.click();
}

public void clicklogin()
{
	lnklogin.click();
}


	   
}





