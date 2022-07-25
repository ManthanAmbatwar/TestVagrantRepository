package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDB_Pushpa_The_Rise_Page {
WebDriver driver;
	
	public IMDB_Pushpa_The_Rise_Page(WebDriver driver) {
		this.driver = driver;
		}
	private By Pushpa_The_Rise_Page_Name=By.xpath("//h1[normalize-space()='Pushpa: The Rise - Part 1']");
	private By RealeaseDate=By.xpath("//a[normalize-space()='January 7, 2022 (United States)']");
	private By CountryOfOrigin=By.xpath("//a[normalize-space()='India']");
	
	public WebElement getPushpa_The_Rise_Page_Name() {
		return driver.findElement(Pushpa_The_Rise_Page_Name);
	}

	public WebElement getRealeaseDate() {
		return driver.findElement(RealeaseDate);
	}
	
	public WebElement getCountryOfOrigin() {
		return driver.findElement(CountryOfOrigin);
		
	}
	
}
