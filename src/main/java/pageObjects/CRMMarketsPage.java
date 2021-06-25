package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMMarketsPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By marketpagetitle = By.xpath("//h1[@data-id='header_title']"); //Locator for Market page title
	By selectedchannelname = By.xpath("//div[@data-id='xxc_channelid.fieldControl-LookupResultsDropdown_xxc_channelid_selected_tag_text']"); //Locator for Channel name on Market details page
	By channelpagetitle = By.xpath("//h1[@data-id='header_title']"); //Locator for Channel page title
	By selectedcampusname = By.xpath("//div[@data-id='xxc_campusid.fieldControl-LookupResultsDropdown_xxc_campusid_selected_tag_text']"); //Locator for Campus name
	By marketstartdate = By.xpath("//input[@aria-label='Date of Start Date']"); //Locator for Start Date of Market
	By marketenddate = By.xpath("//input[@aria-label='Date of End Date']"); //Locator for End Date of Market
	
	public CRMMarketsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getMarketPageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketpagetitle));
		return driver.findElement(marketpagetitle);
	}
	public WebElement getSelectedChannelName() {
		return driver.findElement(selectedchannelname);
	}
	public WebElement getChannelPageTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(channelpagetitle));
		return driver.findElement(channelpagetitle);
	}
	public WebElement getSelectedCampusName() {
		return driver.findElement(selectedcampusname);
	}
	public WebElement getMarketStartDate() {
		return driver.findElement(marketstartdate);
	}
	public WebElement getMarketEndDate() {
		return driver.findElement(marketenddate);
	}
}

