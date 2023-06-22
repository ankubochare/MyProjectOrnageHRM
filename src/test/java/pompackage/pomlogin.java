package pompackage;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class pomlogin extends BaseHRMClass{

	public pomlogin()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Object repository
	@FindBy(xpath="//input[@name='username']") WebElement Username;
	
	@FindBy(xpath="//input[@name=\"password\"]")WebElement Password;
	
	@FindBy(xpath="//button[@type='submit']") WebElement login;
	
	public void typeUsername(String name)
	{
		Username.sendKeys(name);
	}
	public void typepassword(String pass)
	{
		Password.sendKeys(pass);
	}
	public void clickbtn()
	{
		login.click();
	}
	
	public String verifytitle()
	{
		return driver.getTitle();
	}
	
}
