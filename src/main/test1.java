package main;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test1 {
	WebDriver driver;

	@Parameters("browser")

	@BeforeClass(alwaysRun = true)
	public void setUp(String browser) {

		// If the browser is Firefox, then do this
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			// If browser is IE, then do this
		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", ".\\drivers\\MicrosoftWebDriver.exe");
			driver = new InternetExplorerDriver();
			// If browser is Chrome, then do this
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@BeforeMethod(alwaysRun = true)
	public void openHomePage() {

		//System.out.println(driver.getTitle());
		//Assert.assertEquals(driver.getTitle(), "Umbraco - www.uat.akdmc.com"); // Check is it right page
	}

	@AfterClass(alwaysRun = true)
	private void tearDown() {
		driver.quit();
		
	}

	@Test(enabled = true)
	public void searchTest() throws InterruptedException {

		driver.get("http://www.google.com");
		System.out.println(driver.getTitle());
		
		

		//
		// Wait for 5 Sec
		Thread.sleep(5000);

	}

}
