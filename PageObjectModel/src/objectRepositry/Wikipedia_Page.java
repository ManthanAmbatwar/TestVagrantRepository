package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Wikipedia_Page {
WebDriver driver;
	
	public Wikipedia_Page(WebDriver driver) {
		this.driver = driver;
		}
	
	private By WikipediaLogo=By.xpath("//a[@title='Visit the main page']");
	private By WikiSearchBox=By.xpath("//input[@id='searchInput']");
	private By SearchButton=By.xpath("//input[@id='searchButton']");

	public WebElement getWikipediaLogo() {
		return driver.findElement(WikipediaLogo);
	}
	public WebElement getWikiSearchBox() {
		return driver.findElement(WikiSearchBox);
	}
	public WebElement getSearchButton() {
		return driver.findElement(SearchButton);
	}
	
}
