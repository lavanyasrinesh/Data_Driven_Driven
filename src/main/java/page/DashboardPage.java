package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;



public class DashboardPage extends BasePage {
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how = How.XPATH, using = ("//span[contains(text(),'Customers')]"))
	WebElement CUSTOMER_CLICK;
	@FindBy(how = How.XPATH, using = ("//a[contains(text(),'Add Customer')]"))
	WebElement ADD_CUSTOMER_CLICK;
	@FindBy(how = How.XPATH, using = ("//section/div/div[1]/div[3]/div/div/div/div/div[1]/h5[contains(text(),'Add Contact')]"))
	WebElement ADD_CONTACT;

	public void clickoncustomer() {
		CUSTOMER_CLICK.click();
	}
	
	public void clickonaddcustomer() {
		ADD_CUSTOMER_CLICK.click();
	}
	public void verifyaddcontact() {
		waitforelement(driver,60,ADD_CONTACT);
		Assert.assertEquals(ADD_CONTACT.getText(), "Add Contact", "landed on wrong page");
	}
}
