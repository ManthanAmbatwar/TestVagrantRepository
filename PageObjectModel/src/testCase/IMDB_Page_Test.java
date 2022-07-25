package testCase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import objectRepositry.IMDB_Page;
import objectRepositry.IMDB_Pushpa_The_Rise_Page;
import objectRepositry.Wikipedia_Page;
import objectRepositry.Wikipedia_Pushpa_The_Rise_Page;

public class IMDB_Page_Test {
	WebDriver driver;
	IMDB_Page ip;
	IMDB_Pushpa_The_Rise_Page ipp;
	Wikipedia_Page wp;
	Wikipedia_Pushpa_The_Rise_Page wpp;
	
	@BeforeClass
	public void LaunchIMDB_Page() {
		System.setProperty("webdriver.chrome.driver","C:\\\\\\\\\\Automation\\\\\\\\\\chromedriver_win32 (1)\\\\\\\\\\chromedriver.exe");
		driver = new ChromeDriver();
		ip =new IMDB_Page(driver);
		ipp= new IMDB_Pushpa_The_Rise_Page(driver);
		wp=new Wikipedia_Page(driver);
		wpp=new Wikipedia_Pushpa_The_Rise_Page(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.imdb.com/");
	}
		
   @Test
		public void IMDB_Page() {
			//1.Launch IMDB website and verify it launched successfully
				
			boolean isIMDBLogo = ip.getIMBDLogo().isDisplayed();
			Assert.assertTrue(isIMDBLogo, "StepFail: Not on IMDB page | ");
			System.out.println("StepPass:On IMDB Page");
			
			ip.getSearchBox().sendKeys("Pushpa: The Rise - Part 1");
			ip.getSearchButton().click();
			
			
			boolean isPushpaName = ipp.getPushpa_The_Rise_Page_Name().isDisplayed();
			Assert.assertTrue(isPushpaName,"not on PushpaMovie page");
			System.out.println("StepPass:On PushpaMovie Page");
			
			String PushpaRealeaseDateIMDB = ipp.getRealeaseDate().getText();
			 System.out.println("Releasedate:" + PushpaRealeaseDateIMDB.substring(10));
			 
			 String CountryNameIMDB = ipp.getCountryOfOrigin().getText();
			 System.out.println("Country:" + CountryNameIMDB.substring(10));
   }
			 
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		}
}
