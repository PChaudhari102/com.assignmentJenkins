//8. Go to https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//a. Enter your username ("Admin")
//b. Enter your password ("admin123")
//c. Click on Submit button 
//d. Verify that the login was successful

package assignmentJenkins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Hw_OrangeHRMLogin {

	WebDriver driver;
	WebDriverWait wait;

	@Test // (groups="Regression")
	// This means, Test Hw_OrangeHRMLogin belongs to Regression group
	public void OrangeHRMLoginTestNGTest() {
		// Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		WebElement username = driver.findElement(By.name("username"));

		username.sendKeys("Admin");
		// Thread.sleep(5000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("admin123");
		// Thread.sleep(5000);

		// c. Click on Submit button

		// driver.findElement(By.xpath("//form/br/following-sibling::button")).click();
		username.submit();
		// Thread.sleep(5000);

		// d. Verify that the login was successful

		String expectPageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		wait.until(ExpectedConditions.urlToBe(expectPageUrl));
		// wait.until(ExpectedConditions.urlContains(expectPageUrl));
		// wait.until(ExpectedConditions.urlMatches(expectPageUrl));
		String actualPageUrl = driver.getCurrentUrl();

		assertEquals(actualPageUrl, expectPageUrl, "Test Case Failed! as page Url is not as expected.");

	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("I am inside the BeforeMethod of Hw_OrangeHRMLogin");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am inside the AfterMethod of Hw_OrangeHRMLogin");
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am inside the BeforeClass of Hw_OrangeHRMLogin");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am inside the AfterClass of Hw_OrangeHRMLogin");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am inside the BeforeSuite of Hw_OrangeHRMLogin");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am inside the AfterSuite of Hw_OrangeHRMLogin");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am inside the BeforeTest of Hw_OrangeHRMLogin");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am inside the AfterTest of Hw_OrangeHRMLogin");
	}
}
