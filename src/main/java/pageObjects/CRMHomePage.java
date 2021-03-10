package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMHomePage {

	// this page is created for all the web elements available on CRM home page.
	public WebDriver driver;
	public WebDriverWait wait;
	
	By hometitle = By.xpath("//span[contains(text(),'Home')]");
	By searchaccount = By.xpath("//input[@aria-label='Search this view']");
	By startsearch = By.xpath("//button[@aria-label='Start search']");
	By accountTab = By.xpath("//span[contains(text(),'Accounts')]");
	By clearsearch = By.xpath("//button[@title='Clear search']");
	By searchresultaccname = By.xpath("//div[@data-id = 'cell-0-2']");
	By activeaccountstitle = By.xpath("//h1[@aria-label='Active Accounts']");
	By contacttab = By.xpath("//span[contains(text(),'Contacts')]");
	By activecontactstitle = By.xpath("//h1[@aria-label='Active Contacts']");
	By searchresultcontactbusinessphone = By.xpath("//div[@data-id = 'cell-0-4']");
	By inactiveaccountstitle = By.xpath("//h1[@aria-label='Inactive Accounts']");
	By searchresultcontactfullname = By.xpath("//div[@data-id = 'cell-0-2']");
	By inactivecontactstitle = By.xpath("//h1[@aria-label='Inactive Contacts']");
	
	public CRMHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getHometitle () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hometitle));
		return driver.findElement(hometitle);	
		
	}
	public WebElement getSearchAccountField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeaccountstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getstartsearch() {
		//web element for the click on search icon
		return driver.findElement(startsearch);		
	}
	
	public WebElement getAccountTab() {
		// web element for the Account tab at left find side pane.
		return driver.findElement(accountTab);
	}
	
	public WebElement getClearSearch() {
		return driver.findElement(clearsearch);
	}
	
	public WebElement getSearchResultAcc() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultaccname);
	}
	
	public WebElement getActiveAccountsTitle() {
		return driver.findElement(activeaccountstitle);
	}
	public WebElement getContactsTab() {
		// web element for the Account tab at left find side pane.
		return driver.findElement(contacttab);
	}
	
	public WebElement getActiveContactsTitle() {
		return driver.findElement(activecontactstitle);
	}
	
	public WebElement getSearchContactField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activecontactstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getSearchResultContactBusinessPhone() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultcontactbusinessphone);
	}
	
	public WebElement getSearchInactiveAccountField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactiveaccountstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getSearchResultContactFullName() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(searchresultcontactfullname);	
	}
	
	public WebElement getSearchInactiveContactField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactivecontactstitle));
		return driver.findElement(searchaccount);	
	}
}