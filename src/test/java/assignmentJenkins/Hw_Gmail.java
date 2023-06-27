//6. Yahoo assignment, do the compose functionality and send an email to  
 // ketan@paratussystems.com, with subject " Hi Ketan, I am <your name>.
//  Body of the mail - "I have done my assignment."
//  a. goto www.gmail.com
//  b. enter your id
//  c. click next
 // c. enter your password.
//  d. click login
//  e. Verify that login was successful.

package assignmentJenkins;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
public class Hw_Gmail {
	WebDriver driver;
	WebDriverWait wait;
	Logger log;
 @Test
  public void gmail()  {
	 
	 log = Logger.getLogger(Hw_Gmail.class.getName());
	 PropertyConfigurator.configure("");
	//b. Click on English Link
	  driver.get("https://accounts.google.com/v3/signin/identifier?dsh=S-1123392764%3A1677151326273956&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&ifkv=AWnogHfOpjY0duUO2ikPKR_jjNlyMrG3lSSN5BACMX8j2CR1ZgKNPH8t2I0-_cWK9PUxdMdWOTgtSg");
	  driver.manage().window().maximize(); //maximize the screen	  
	 // Thread.sleep(5000); 
	  
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
	  driver.findElement(By.id("identifierId")).sendKeys("pchaudhari102@gmail.com");
	 // Thread.sleep(5000); 
	  
	  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Next')]")));
	  driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click(); 
	 String getNewUrl = driver.getCurrentUrl();
	  //Thread.sleep(5000); 
	assertEquals(getNewUrl,"https://accounts.google.com/v3/signin/challenge/pwd?TL=ALbfvL1W8Q4jTZR5mD7rDdC70h5k7MwrU5qzFFlUBwz-GBiQPL-myCsloM2DbaIY&checkConnection=youtube%3A264%3A0&checkedDomains=youtube&cid=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&dsh=S1006965977%3A1677152006597667&emr=1&flowEntry=ServiceLogin&flowName=GlifWebSignIn&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F%3Ftab%3Drm%26ogbl&ifkv=AWnogHewVfaX9v9nMH_TRR_zw1BCzW1gtBJHmrmu5JAXkjXDucBW9un1l3DRFwewRl7Bu23RqnaWkg&osid=1&pstMsg=1&service=mail"); 
	 // Thread.sleep(5000); 

  }
  
  @BeforeMethod
  public void beforeMethod() {
	  ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	 driver.get("https://www.google.com"); 
	 wait = new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  @AfterMethod
  public void afterMethod() {
  driver.quit();
  }

}
