package pompackage;

import java.awt.Desktop.Action;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePackage.BaseHRMClass;

public class pomcontactdetails extends BaseHRMClass{

	@FindBy(partialLinkText="Contact Details")WebElement ContactDetailsLink;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/input") WebElement Street1;
	
	@FindBy(css="#app > div.oxd-layout > div.oxd-layout-container > div.oxd-layout-context > div > div > div > div.orangehrm-edit-employee-content > div.orangehrm-horizontal-padding.orangehrm-vertical-padding > form > div:nth-child(3) > div > div:nth-child(2) > div > div:nth-child(2) > input")WebElement Street2;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[3]/div/div[2]/input")WebElement City;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[4]/div/div[2]/input")WebElement State;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[5]/div/div[2]/input")WebElement ZipCode;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[6]/div/div[2]/div/div")WebElement countrydropdown;
	@FindBy(xpath="//div[contains(@class,'oxd-select-text-input')]")WebElement conuntryname;
	
	@FindBy(className="oxd-select-text-input")WebElement text;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[1]/div/div[2]/input")WebElement Homephone;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[2]/div/div[2]/input")WebElement Mobile;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div/div[3]/div/div[2]/input")WebElement Workphone;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[1]/div/div[2]/input")WebElement WorkEmail;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div/div[2]/div/div[2]/input")WebElement OtherEmail;
	
	@FindBy(xpath="//button[@type=\"submit\"]")WebElement submit;
	
	
	
	
	public pomcontactdetails() {
		PageFactory.initElements(driver, this);
	}
	
	public void ClikonContactDetailsLink()
	{
		ContactDetailsLink.click();
	}
	public void TypeStreet1(String street1name)
	{
		Street1.sendKeys(street1name);
	}
	public void TypeStreet2(String street2name)
	{
		Street2.sendKeys(street2name);
	}
	public void Typecity(String cityname)
	{
		City.sendKeys(cityname);
	}
	
	public void TypeZipCode(String zipcode)
	{
		ZipCode.clear();
		ZipCode.sendKeys(zipcode);
	}
	public void Selectfromdropdowncoutry(String name) throws InterruptedException 
	{
		countrydropdown.click();
		
		List<WebElement> drop=driver.findElements(By.xpath("//div[contains(@class,'oxd-select-text-input')]"));
		for(WebElement countrys: drop)
		{
			String z="Zimababwe";
			String value=countrys.getText();
			System.out.println(value);
			boolean Swift=false;
			
			while(Swift=false) {
				List<WebElement> drop1=driver.findElements(By.xpath("//div[contains(@class,'oxd-select-text-input')]"));
			Actions a=new Actions(driver);
			a.keyDown(name);
			System.out.println();
			if(drop1.equals(name)||drop1.equals(z)) {
				Swift=true;
				break;
			}
		}
		
			
			
		
		}
		      
		

	}
	public void TypeState(String statename)
	{
		State.sendKeys(statename);
	}
	public void TypeHomephone(String homephone)
	{
		Homephone.clear();
		Homephone.sendKeys(homephone);
	}
	public void TypeMobilenumber(String mobile)
	{
		Mobile.clear();
		Mobile.sendKeys(mobile);
	}
	public void TypeWorkPhone(String workphone)
	{
		Workphone.clear();
		Workphone.sendKeys(workphone);
	}
	public void TypeWorkEmail(String workemail)
	{
		WorkEmail.clear();
		WorkEmail.sendKeys(workemail);
	}
	public void OtherEmail(String otheremail)
	{
		OtherEmail.clear();
		OtherEmail.sendKeys(otheremail);
	}
	
	public String verifycontactdetailstitle()
	{
		return driver.getTitle();
	}
	
}
