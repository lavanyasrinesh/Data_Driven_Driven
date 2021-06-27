package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;
import util.Excel_Reader;

public class AddCustomerTest {
	WebDriver driver;
	Excel_Reader excel = new Excel_Reader("src\\main\\java\\util\\excelsheet  for ass.xlsx");
	String username = excel.getCellData("logininfo", "USERNAME", 2);
	String password = excel.getCellData("logininfo", "PASSWORD", 2);
	String fullname = excel.getCellData("1addcustomerinfo", "Full Name", 2);
	String companyname = excel.getCellData("1addcustomerinfo", "Company", 2);
	String emailid = excel.getCellData("1addcustomerinfo", "Email", 2);
	String phoneno = excel.getCellData("1addcustomerinfo", "Phone", 2);
	String address = excel.getCellData("1addcustomerinfo", "Address", 2);
	String city = excel.getCellData("1addcustomerinfo", "City", 2);
	String state = excel.getCellData("1addcustomerinfo", "State/Region", 2);
	String zip = excel.getCellData("1addcustomerinfo", "ZIP/Postal Code", 2);
	String Country = excel.getCellData("1addcustomerinfo", "Country", 2);
	
	@Test
	public void addingcustomerdetails() {
		driver=BrowserFactory.init();
		
		LoginPage loginpage =PageFactory.initElements(driver, LoginPage.class);
		loginpage.validateusername(username);
		loginpage.validatepassword(password);
		loginpage.signingbuttoninloginpage();
		
		loginpage.verifydashboardpage();
		
		DashboardPage dashboardpage= PageFactory.initElements(driver, DashboardPage.class);
		dashboardpage.clickoncustomer();
		dashboardpage.clickonaddcustomer();
		
		dashboardpage.verifyaddcontact();
		
		AddCustomerPage addcustomerpage = PageFactory.initElements(driver, AddCustomerPage.class);
		addcustomerpage.fullname(fullname);
		addcustomerpage.companyname(companyname);
		addcustomerpage.emailfield(emailid);
		addcustomerpage.phonefield(phoneno);
		addcustomerpage.addressfield(address);
		addcustomerpage.Cityname(city);
		addcustomerpage.Statename(state);
		addcustomerpage.ZIPname(zip);
		addcustomerpage.Countryname(Country);
		addcustomerpage.clickonsubmitbuttononaddcontact();
		
		addcustomerpage.verifysummarypage();
		addcustomerpage.clickonlistcustomer();
		addcustomerpage.searchboxonlistcustomer();
		addcustomerpage.nameexistanddeletethename();
		
		BrowserFactory.tearDown();
		
	} 

}
