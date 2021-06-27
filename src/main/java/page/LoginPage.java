package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage extends BasePage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(how = How.XPATH, using = "//input[@id='username']")
	WebElement USERNAME;
	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement PASSWORD;
	@FindBy(how = How.XPATH, using = "//button[@type='submit']")
	WebElement SIGN_IN_BUTTON;
	@FindBy (how = How.XPATH,using ="//h2[contains(text(),'Dashboard')]") WebElement Dashboard_page;
	public void validateusername(String username ) {
		USERNAME.sendKeys(username);
	}
	
	public void validatepassword(String password) {
		PASSWORD.sendKeys(password);
	}
	
	public void signingbuttoninloginpage() {
		SIGN_IN_BUTTON.click();
	}
	public void verifydashboardpage() {
		waitforelement(driver,60,Dashboard_page);
		Assert.assertEquals(Dashboard_page.getText(), "Dashboard", "wrong page landed");
	}

	

}
