package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMPeoplePage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By fullname = By.xpath("//div[@data-id = 'xxc_fullname']");//Locator to click Full Name column
	By eihmatchkey = By.xpath("//div[@data-id = 'xxc_eihmatchkey']");//Locator to click EIH Match Key column 
	By selectoperatoroption = By.xpath("//button[@data-index = '4']");//Locator for Begins With option
	By enterfullname = By.xpath("//input[@aria-label = 'Filter by value']");//Locator for enter full name text box
	By filterclick = By.xpath("//button[@aria-label = 'Filter by']");//Locator for filter by option
	By clickoperator = By.xpath("//div[@aria-label = 'Filter by operator']");//Locator for operator
	By clickapplybtn = By.xpath("//button[@type = 'submit']");//Locator for Apply button in filters
	
	public CRMPeoplePage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement getfullname() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(fullname));
		return driver.findElement(fullname);
	}
	public WebElement geteihmatchkey() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(eihmatchkey));
		return driver.findElement(eihmatchkey);
	}
	public WebElement getselectoperatoroption() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectoperatoroption));
		return driver.findElement(selectoperatoroption);
	}
	public WebElement getenterfullname() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(enterfullname));
		return driver.findElement(enterfullname);
	}
	public WebElement getfilterclick() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(filterclick));
		return driver.findElement(filterclick);
	}
	public WebElement getclickoperator() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickoperator));
		return driver.findElement(clickoperator);
	}
	public WebElement getclickapplybtn() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickapplybtn));
		return driver.findElement(clickapplybtn);
	}
}

