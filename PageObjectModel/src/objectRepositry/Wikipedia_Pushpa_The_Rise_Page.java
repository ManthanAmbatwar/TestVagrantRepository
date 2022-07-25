package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wikipedia_Pushpa_The_Rise_Page {
  
WebDriver driver;
	
	public Wikipedia_Pushpa_The_Rise_Page(WebDriver driver) {
		this.driver = driver;
		}
	
	private By MovieHeading=By.xpath("//h1[@id='firstHeading']//i[contains(text(),'Pushpa: The Rise')]");
	private By WikiReleaseDate=By.xpath("//tbody/tr[12]/td[1]/div[1]/ul[1]/li[1]");
	private By Country=By.xpath("//td[normalize-space()='India']");

	public WebElement getMovieHeading() {
		return driver.findElement(MovieHeading);
	}
	public WebElement getWikiReleaseDate() {
		return driver.findElement(WikiReleaseDate);
	}
	public WebElement getCountry() {
		return driver.findElement(Country);
	}
}
