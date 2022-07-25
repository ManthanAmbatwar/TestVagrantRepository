package objectRepositry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IMDB_Page {
	WebDriver driver;
	
	public IMDB_Page(WebDriver driver) {
		this.driver = driver;
		}
	private By IMBDLogo =By.xpath("//a[@id='home_img_holder']");
	private By SearchBox  = By.id("suggestion-search");
	private By SearchButton = By.xpath("//button[@id='suggestion-search-button']//*[name()='svg']");
	
	
	public WebElement getIMBDLogo() {
		return driver.findElement(IMBDLogo);
	}
	public WebElement getSearchBox() {
		return driver.findElement(SearchBox);
	}
	public WebElement getSearchButton() {
		return driver.findElement(SearchButton);
	}


}
