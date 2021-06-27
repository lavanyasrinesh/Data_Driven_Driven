package util;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {
	static WebDriver driver;
	String browser;

	public static WebDriver init() {
		System.out.println("Choose the browser actions need to perform.. ");
		System.out.println("1.chrome");
		System.out.println("2.MS Edge");
		Scanner scanner = new Scanner(System.in);
		String userbrowser = scanner.next();

		if (userbrowser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver_new1.exe");
			driver = new ChromeDriver();
		} else if (userbrowser.equalsIgnoreCase("MS Edge")) {
			System.setProperty("webdriver.edge.driver", "Drivers\\msedgedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.out.println("invalid browser option");
		}

		driver.get("https://techfios.com/billing/?ng=admin/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void tearDown() {
		driver.close();
		driver.quit();
	}

}
