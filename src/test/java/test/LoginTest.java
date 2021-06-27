package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.BasePage;
import page.LoginPage;
import util.BrowserFactory;
import util.Excel_Reader;

public class LoginTest  {
	WebDriver driver;
	
	@Test
	public void logintest() {
		Excel_Reader excel =new Excel_Reader("src\\main\\java\\util\\excelsheet  for ass.xlsx");
		String username = excel.getCellData("logininfo", "USERNAME", 2);
		String password = excel.getCellData("logininfo", "PASSWORD", 2);
		driver = BrowserFactory.init();
		
		LoginPage loginpage =PageFactory.initElements(driver, LoginPage.class);
		loginpage.validateusername(username);
		loginpage.validatepassword(password);
		loginpage.signingbuttoninloginpage();
		
		
		loginpage.verifydashboardpage();
		BrowserFactory.tearDown();
	}


}
