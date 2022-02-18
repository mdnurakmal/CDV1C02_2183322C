package webapp;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;		
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;	

public class webTest {		
	    private WebDriver driver;		
		@Test				
		public void testTitle() {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
	
			//Deleting all the cookies
			driver.manage().deleteAllCookies();
			
			//launching the specified URL
			driver.get("http://localhost:8080/TheMakanJourney/index.jsp");  
			String title = driver.getTitle();		
			  System.out.println(title+">>>>>"); 
			Assert.assertTrue(title.contains("The Makan Journey Version 3 Release 1.1")); 		
			
			String actualString = driver.findElement(By.xpath("//*[@id=\"cover-caption\"]/div/div/div/div/form/div[1]/h2")).getText();
			Assert.assertTrue(actualString.contains("Admin Login"));
		}	
		
		@Test
		public void testHeader() {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			//Deleting all the cookies
			driver.manage().deleteAllCookies();
			
			//launching the specified URL
			driver.get("http://localhost:8080/TheMakanJourney/index.jsp");  

			String actualString = driver.findElement(By.xpath("//*[@id=\"cover-caption\"]/div/div/div/div/form/div[1]/h2")).getText();
			Assert.assertTrue(actualString.contains("Admin Login"));
		}	
		
		@Test
		public void testAdminLogin() {	
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Downloads\\chromedriver_win32\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();

			//Deleting all the cookies
			driver.manage().deleteAllCookies();
			
			//launching the specified URL
			driver.get("http://localhost:8080/TheMakanJourney/index.jsp");  
		
	
			WebElement username_enter = driver.findElement(By.id("username_field"));
			WebElement password_enter = driver.findElement(By.id("password_field"));
			username_enter.sendKeys("123");
			password_enter.sendKeys("123");

			WebElement login = driver.findElement(By.id("login_button"));
			
			login.click(); 
			String title = driver.getTitle();	
			Assert.assertTrue(title.contains("Admin Dashboard"));
		}	
		
		@BeforeTest
		public void beforeTest() {	

		}		
		
		@AfterTest
		public void afterTest() {
			
		}		
}