package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public void waitforelement(WebDriver driver, int waitingtimeinseconds, WebElement element) {
		WebDriverWait wait =new WebDriverWait(driver,60);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
	
	public void dropdownvalue(WebElement element,String value) {
		Select sel = new Select(element);
		sel.selectByVisibleText(value);
	}
	
	public int randomnum(int value) {
		Random rnd =new Random();
		int generatednum = rnd.nextInt(value);
		return generatednum;
	}
	

}
