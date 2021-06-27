package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class AddCustomerPage extends BasePage {
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = ("//input[@name='account']"))
	WebElement FULL_NAME_FIELD;
	@FindBy(how = How.XPATH, using = ("//select[@id='cid']"))
	WebElement COMPANY_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@id='email']"))
	WebElement EMAIL_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@id='phone']"))
	WebElement PHONE_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@id='address']"))
	WebElement ADDRESS_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@id='city']"))
	WebElement CITY_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@name='state']"))
	WebElement STATE_FIELD;
	@FindBy(how = How.XPATH, using = ("//input[@id='zip']"))
	WebElement ZIP_FIELD;
	@FindBy(how = How.XPATH, using = ("//select[@id='country']"))
	WebElement COUNTRY_FIELD;
	@FindBy(how = How.XPATH, using = ("//button[@id='submit']"))
	WebElement SUBMIT_BUTTON_ON_ADDCONTACT;
	@FindBy(how = How.XPATH, using = ("//a[@id='summary']"))
	WebElement SUMMARY_PAGE;
	@FindBy(how = How.XPATH, using = ("// a[contains(text(),'List Customers')]"))
	WebElement LIST_CUSTOMER;
	@FindBy(how = How.XPATH, using = ("//input[@id='foo_filter']"))
	WebElement SEARCHBOX_LISTCUSTOMER;

	String name1;

	public void fullname(String name) {
		waitforelement(driver, 60, FULL_NAME_FIELD);
		name1 = randomnum(1000) + name;
		FULL_NAME_FIELD.sendKeys(name1);
	}

	public void companyname(String companyname) {

		dropdownvalue(COMPANY_FIELD, companyname);

	}

	public void emailfield(String emailid) {
		waitforelement(driver, 60, EMAIL_FIELD);
		EMAIL_FIELD.sendKeys(randomnum(200) + emailid);
	}

	public void phonefield(String phoneno) {
		PHONE_FIELD.sendKeys(randomnum(100) + phoneno);
	}

	public void addressfield(String address) {
		waitforelement(driver, 60, ADDRESS_FIELD);
		ADDRESS_FIELD.sendKeys(randomnum(100) + address);
	}

	public void Cityname(String cityname) {
		CITY_FIELD.sendKeys(cityname);
	}

	public void Statename(String statename) {
		waitforelement(driver, 60, STATE_FIELD);
		STATE_FIELD.sendKeys(statename);
	}

	public void ZIPname(String zipname) {

		ZIP_FIELD.sendKeys(zipname);
	}

	public void Countryname(String countryname) {

		dropdownvalue(COUNTRY_FIELD, countryname);
	}

	public void clickonsubmitbuttononaddcontact() {

		SUBMIT_BUTTON_ON_ADDCONTACT.click();
		;
	}

	public void verifysummarypage() {
		waitforelement(driver, 5, SUMMARY_PAGE);
		Assert.assertEquals(SUMMARY_PAGE.getText(), "Summary", "wrong page found");
	}

	public void clickonlistcustomer() {
		waitforelement(driver, 60, LIST_CUSTOMER);
		LIST_CUSTOMER.click();
	}

	public void searchboxonlistcustomer() {
		waitforelement(driver, 60, SEARCHBOX_LISTCUSTOMER);
		SEARCHBOX_LISTCUSTOMER.sendKeys(name1);
	}

	// table/tbody/tr[1]/td[3]/a
	public void nameexistanddeletethename() {
		String beforeXpath = "//tbody/tr[";
		String afterXpath = "]/td[3]";

		for (int i = 1; i <= 5; i++) {
			String nameXpath = driver.findElement(By.xpath(beforeXpath + i + afterXpath)).getText();

			if (nameXpath.contains(name1)) {

				String deletebutton = beforeXpath + i + "]/td[3]/following-sibling::td[4]/a[2]";

				driver.findElement(By.xpath(deletebutton)).click();
				break;
			}
			
		}
		driver.switchTo().alert().accept();
		//driver.findElement(By.xpath("//body/div[1]/div/div/div[2]/button[2][contains(text(),'OK')]")).click();

	}
	
}
