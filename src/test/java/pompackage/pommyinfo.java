package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMClass;

public class pommyinfo extends BaseHRMClass{
	
	@FindBy(partialLinkText="My")WebElement Myinfolink;
	
	public pommyinfo()
	{
		PageFactory.initElements(driver, this);
	}

	public void clickonMyinfo()
	{
		Myinfolink.click();
	}
	public String verifymyinfotitle()
	{
		return driver.getTitle();
	}
	
}
