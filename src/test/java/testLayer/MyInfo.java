package testLayer;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMClass;
import pompackage.pomcontactdetails;
import pompackage.pomlogin;
import pompackage.pommyinfo;
import testData.ExcelSheet;

public class MyInfo extends BaseHRMClass{
	pomlogin log;
	pommyinfo myinfo;
	pomcontactdetails contactdetails;
	public MyInfo()
	{
		super();
	}
	@BeforeMethod
	public void before()
	{
		initiat();
		screenshots("MyInfo");
		log=new pomlogin();
		myinfo=new pommyinfo();
		contactdetails=new pomcontactdetails();
		
		log.typeUsername(prop.getProperty("username"));
		log.typepassword(prop.getProperty("password"));
		log.clickbtn();
	}
	
	@DataProvider
	public Object[][] Details()
	{
		Object resutl[][]=ExcelSheet.readdata("Sheet2");
		return resutl;
	}
	
	@Test(dataProvider="Details")
	public void myinfolinkclick(String Street1,String Street2,String City,String State,String Zipcode,String Country,String HomePhone,String Mobile,String Work,String Workemail,String Otheremail) throws InterruptedException
	{
		String actual=log.verifytitle();
		System.out.println(actual);
		Assert.assertEquals(actual,"OrangeHRM");
		Thread.sleep(3000);
		myinfo.clickonMyinfo();
		String actualmyinfotitle=myinfo.verifymyinfotitle();
		System.out.println("MyInfoTitle"+actualmyinfotitle);
		Thread.sleep(3000);
		contactdetails.ClikonContactDetailsLink();
		String actualContactDetailstitle=contactdetails.verifycontactdetailstitle();
		System.out.println("ContactDetailsTitle"+actualContactDetailstitle);
		
		contactdetails.TypeStreet1(Street1);
		contactdetails.TypeStreet2(Street2);
		contactdetails.Typecity(City);
		contactdetails.TypeState(State);
		
		contactdetails.TypeZipCode(Zipcode);
		Thread.sleep(3000);
		contactdetails.Selectfromdropdowncoutry(Country);
		
		Thread.sleep(3000);
		contactdetails.TypeHomephone(HomePhone);
		contactdetails.TypeMobilenumber(Mobile);
		contactdetails.TypeWorkPhone(Work);
		contactdetails.TypeWorkEmail(Workemail);
		Thread.sleep(3000);
		contactdetails.OtherEmail(Otheremail);
		Thread.sleep(3000);
		
	}
	@AfterMethod
	public void after()
	{
		driver.close();
	}

}
