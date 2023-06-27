//7. assignment in wikipedia.org
//a. go to wikipedia.org
//b. Click on English Link
//c. Type "Selenium" in search field
//d. Click on search button
//e. Verify whether the title is "Selenium - Wikipedia"
//f. Check if heading is "Selenium"

package assignmentJenkins;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class HW_Wikipedia {
	WebDriver driver;
	WebDriverWait wait;
	@Test
	public void wikipedia() throws InterruptedException {
		driver.get("https://www.wikipedia.org/");
		driver.manage().window().maximize();
		System.out.println("Current Url: "+driver.getCurrentUrl());
		System.out.println("Title of Url is: "+driver.getTitle());
		
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='js-link-box-en']")));
		WebElement english=driver.findElement(By.xpath("//a[@id='js-link-box-en']"));
		english.click();
		//Thread.sleep(2000);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='search']")));
		  WebElement Selenium=driver.findElement(By.xpath("//input[@name='search']"));
		  Selenium.sendKeys("Selenium"); 
		 Thread.sleep(2000);
		  
		 
		  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Search']")));
		  WebElement Search=driver.findElement(By.xpath("//button[text()='Search']"));
		  Search.click();
		 
			//Thread.sleep(2000); //button[contains(text()='Search')]//button[text()='Search']
		
		 
			String expectedPageTitle = "Selenium - Wikipedia";
			System.out.println("Expected Page Title is " + expectedPageTitle);
			//Thread.sleep(2000);
			wait.until(ExpectedConditions.titleIs(expectedPageTitle));
			String actualPageTitle = driver.getTitle();
			System.out.println("Actual Page Title is " + actualPageTitle);
			assertEquals(actualPageTitle,expectedPageTitle, "Expected Title not matching with actual");
		    
			String expectedHeading  = "Selenium";
			System.out.println("Expected Heading is " + expectedHeading);
			//Thread.sleep(2000);
			
			//WebElement Selenium1=driver.findElement(By.xpath("//span[text()='Selenium']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Selenium']")));
			String actualHeading = driver.findElement(By.xpath("//span[text()='Selenium']")).getText();
			System.out.println("Actual Heading is " + actualHeading);
			//Thread.sleep(2000);
			assertEquals(actualHeading,expectedHeading, "Expected Title not matching with actual");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
	@BeforeClass
	  public void beforeClass() {
		  System.out.println("I am inside the BeforeClass");
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("I am inside the afterClass");
	  }

}
