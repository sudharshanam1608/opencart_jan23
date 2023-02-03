package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends BasePage
{
public Loginpage(WebDriver driver) 
{
		super(driver);

}

//Elements

@FindBy(xpath="//input[@id='input-email']")
WebElement txtEmailAddress;

@FindBy(xpath="//input[@id='input-password']")
WebElement txtPassword;

@FindBy(xpath="//button[text()='Login']")
WebElement btnLogin;

public void setEmail(String email)
{
	txtEmailAddress.sendKeys(email);
}

public void setPassword(String pwd)
{
	txtEmailAddress.sendKeys(pwd);
}

public void clickLogin ( )
{
	btnLogin.click();
}


}
