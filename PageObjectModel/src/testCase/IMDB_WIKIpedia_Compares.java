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

public class IMDB_WIKIpedia_Compares {
	WebDriver driver;
	IMDB_Page ip;
	IMDB_Pushpa_The_Rise_Page ipp;
	Wikipedia_Page wp;
	Wikipedia_Pushpa_The_Rise_Page wpp;
	

@BeforeClass
public void LaunchWIKI_Page() {
	System.setProperty("webdriver.chrome.driver","C:\\\\\\\\\\Automation\\\\\\\\\\chromedriver_win32 (1)\\\\\\\\\\chromedriver.exe");
	driver = new ChromeDriver();
	ip =new IMDB_Page(driver);
	ipp= new IMDB_Pushpa_The_Rise_Page(driver);
	wp=new Wikipedia_Page(driver);
	wpp=new Wikipedia_Pushpa_The_Rise_Page(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	driver.get("https://en.wikipedia.org/");
}

@Test
public void WIKI_Page() {
	boolean isWikiLogo = wp.getWikipediaLogo().isDisplayed();
	Assert.assertTrue(isWikiLogo, "StepFail: Not on IMDB page | ");
	System.out.println("StepPass:On IMDB Page");
	
	wp.getWikiSearchBox().sendKeys("Pushpa: The Rise - Part 1");
	wp.getSearchButton().click();
	
	boolean isWIKIPushpaName = wpp.getMovieHeading().isDisplayed();
	Assert.assertTrue(isWIKIPushpaName,"not on WIKIPushpaMovie page");
	System.out.println("StepPass:On WIKIPushpaMovie Page");
	
	String PushpaRealeaseDateIMDB = ipp.getRealeaseDate().getText();
	 System.out.println("Releasedate:" + PushpaRealeaseDateIMDB.substring(10));
	 
	 String CountryNameIMDB = ipp.getCountryOfOrigin().getText();
	 System.out.println("Country:" + CountryNameIMDB.substring(10));
	
	String PushpaRealeaseDateWIKI = wpp.getWikiReleaseDate().getText();
	 System.out.println("WikiReleasedate:" + PushpaRealeaseDateWIKI.substring(10));
	
	 String CountryNameWIKI = wpp.getCountry().getText();
	 System.out.println("Country:" + CountryNameWIKI.substring(10));
	 
	 
	 Assert.assertEquals(PushpaRealeaseDateIMDB, PushpaRealeaseDateWIKI,"IMDB And WIKIPEDIA Release date Are same ");
	 
	 Assert.assertNotEquals(PushpaRealeaseDateIMDB,  PushpaRealeaseDateWIKI,"IMDB And WIKIPEDIA Release date Are Not same");
	 
	 Assert.assertEquals(CountryNameIMDB, CountryNameWIKI,"IMDB And WIKIPEDIA CountryNames Are same ");
	 
	 Assert.assertNotEquals(CountryNameIMDB, CountryNameWIKI,"IMDB And WIKIPEDIA CountryNames Are Not same");
	 	 
}

@AfterClass
public void closeBrowser() {
	driver.quit();
	}
}

	