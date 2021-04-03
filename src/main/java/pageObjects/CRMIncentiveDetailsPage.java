package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentiveDetailsPage {
	
	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By openincdetoptions = By.xpath("//button[@aria-label = 'More commands for Incentive Detail']");//Locator for three dots for Incentive Details section
	By clicknewincdet = By.xpath("//button[@aria-label = 'New Incentive Detail']");//Locator for new incentive detail
	By inccatdd = By.xpath("//input[@aria-label = 'Incentive Category, Lookup']");//Locator for incentive category drop down list
	By inccatsearch = By.xpath("//button[@aria-label = 'Search records for Incentive Category, Lookup field']");//Locator for Search button for incentive category drop down
	By selectinccat = By.xpath("//div[@aria-label = 'Incentive Category Lookup results']/ul[1]/li[1]");//Locator for incentive category option in drop down list 
	By verifyincdet = By.xpath("//div[@data-id = 'IncentiveDetails_container']/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div[2]");//Locator for Incentive detail at General tab of incentive records
	By saveincdet = By.xpath("//button[@id = 'quickCreateSaveAndCloseBtn']");//Locator for Save & Close button
	By contactddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[4]");//Locator for Contact group by option
	By marketddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[5]");//Locator for Market group by option
	By accountddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[9]");//Locator for Account group by option
	By inccatddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[6]");//Locator for Incentive Category group by option
	By estvalddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[7]");//Locator for Estimated Value group by option
	By statusddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[8]");//Locator for Incentive Detail Status group by option
	
	public CRMIncentiveDetailsPage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement getopenincdetoptions() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(openincdetoptions));
		return driver.findElement(openincdetoptions);
	}
	public WebElement getclicknewincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicknewincdet));
		return driver.findElement(clicknewincdet);
	}
	public WebElement getinccatdd() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inccatdd));
		return driver.findElement(inccatdd);
	}
	public WebElement getinccatsearch() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inccatsearch));
		return driver.findElement(inccatsearch);
	}
	public WebElement getselectinccat() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectinccat));
		return driver.findElement(selectinccat);
	}
	public WebElement getverifyincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifyincdet));
		return driver.findElement(verifyincdet);
	}
	public WebElement getsaveincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(saveincdet));
		return driver.findElement(saveincdet);
	}
	public WebElement getcontactddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(contactddopt));
		return driver.findElement(contactddopt);
	}
	public WebElement getmarketddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(marketddopt));
		return driver.findElement(marketddopt);
	}
	public WebElement getaccountddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(accountddopt));
		return driver.findElement(accountddopt);
	}
	public WebElement getinccatddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inccatddopt));
		return driver.findElement(inccatddopt);
	}
	public WebElement getestvalddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(estvalddopt));
		return driver.findElement(estvalddopt);
	}
	public WebElement getstatusddopt() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(statusddopt));
		return driver.findElement(statusddopt);
	}
}
