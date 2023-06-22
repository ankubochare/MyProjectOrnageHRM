package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.pomlogin;
import testData.ExcelSheet;

public class LoginTest extends BaseHRMClass {
	pomlogin log;
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initsetup()
	{
		initiat();
		screenshots("login");
	log=new pomlogin();
	}
	
	@Test(priority=1)
	public void Title()
	{
		String actual=log.verifytitle();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
	}
	@DataProvider
	public Object[][] Details()
	{
		Object resutl[][]=ExcelSheet.readdata("Sheet1");
		return resutl;
	}
	
	@Test(priority=2, dataProvider="Details")
	public void login(String name,String password) throws InterruptedException
	{
		log.typeUsername(name);
		Thread.sleep(3000);
		log.typepassword(password);
		//log.clickbtn();
	}
	@AfterMethod
	public void close()
	{
		driver.close();
	}
}
