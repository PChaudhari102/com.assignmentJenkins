//10. Customized Tours 
//1. Go to - https://nichethyself.com/tourism/customised.html
//2. Enter Full Name and Email Address
//3. Select Radio button "Maybe" or No
//4. Select Preferred Stay "Home Stay"
//5. Click on "France" Checkbox
//6. Click on "Submit" button

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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class Hw_CustomizedTours {
	WebDriver driver;
	WebDriverWait wait;

	@Test
	public void webElementMethods() {
		driver.get("https://nichethyself.com/tourism/customised.html");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
		WebElement fullname = driver.findElement(By.name("name"));
		fullname.sendKeys("Priyanka Chaudhari");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		WebElement email = driver.findElement(By.name("email"));
		email.sendKeys("pchaudhari102@gmail.com");

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='optradio' and @Disabled]")));
		WebElement Maybe = driver.findElement(By.xpath("//input[@name='optradio' and @Disabled]"));
		// Select Diesel radio button
		// Thread.sleep(3000);
		if (!Maybe.isSelected()) {
			Maybe.click();
		}

		// How to check if the element is visible
		if (Maybe.isDisplayed()) {
			System.out.println("Maybe Element is visible.");
		}
		// Thread.sleep(7000);
		if (Maybe.isEnabled()) {
			System.out.println("Maybe Element is Enabled.");
		} else {
			System.out.println("Maybe Element is Disabled.");
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form/label[8]/input")));
		WebElement No = driver.findElement(By.xpath("//form/label[8]/input"));
		// Select Diesel radio button
		// Thread.sleep(3000);
		if (!No.isSelected()) {
			No.click();
		}

		// How to check if the element is visible
		if (No.isDisplayed()) {
			System.out.println("No Element is visible.");
		}
		// Thread.sleep(7000);
		if (No.isEnabled()) {
			System.out.println("No Element is Enabled.");
		} else {
			System.out.println("No Element is Disabled.");
		}

		// Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("days")));
		WebElement daysDropDown = driver.findElement(By.id("days"));
		Select days = new Select(daysDropDown);// WebElement should have tag select
		days.selectByVisibleText("Home Stay");
		// Thread.sleep(3000);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='France']/input")));
		WebElement France = driver.findElement(By.xpath("//label[text()='France']/input"));
		// Select Diesel radio button
		// Thread.sleep(3000);
		if (!France.isSelected()) {
			France.click();
		}

		// How to check if the element is visible
		if (France.isDisplayed()) {
			System.out.println("No Element is visible.");
		}
		// Thread.sleep(5000);
		if (France.isEnabled()) {
			System.out.println("No Element is Enabled.");
		} else {
			System.out.println("No Element is Disabled.");
		}
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		// Thread.sleep(5000);
	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		System.out.println("I am inside the BeforeMethod of HW_CustomizedTours");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("I am inside the AfterMethod of HW_CustomizedTours");
		driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("I am inside the BeforeClass of HW_CustomizedTours");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("I am inside the AfterClass of HW_CustomizedTours");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("I am inside the BeforeSuite of HW_CustomizedTours");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("I am inside the AfterSuite of HW_CustomizedTours");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("I am inside the BeforeTest of HW_CustomizedTours");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("I am inside the AfterTest of HW_CustomizedTours");
	}
}
