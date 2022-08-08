package practice.qa.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import practice.qa.base.TestBase;
import practice.qa.util.TestUtil;

public class TC1_GoogleSearchPage extends TestBase {

	@FindBy(linkText = "Store")
	public WebElement store;
	
	@FindBy(xpath = "//div[@aria-label='Search the Google store']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//input[@placeholder='Search Google Store']")
	public WebElement search;
	
	@FindBy(className = "search-results-header")
	public WebElement searchResult;
	
	public void openGooglePage() {
		PageFactory.initElements(driver, this);
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_TIMEOUT));
	}
	
	public void clickStoreLink() {
		store.click();
		System.out.println(driver.getTitle()+" : "+driver.getCurrentUrl());
	}
	
	public void search(String a) {
		searchButton.click();
		search.sendKeys(a);
		search.sendKeys(Keys.ENTER);
	}
	
	public String searchResult() {
		String result = searchResult.getText();
		System.out.println("Search Results :"+result);
		return result;
	}
}
