package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentiveTab {

	public WebDriver driver;
	public WebDriverWait wait;

	// Open incentive tab for existing account
	By inctab = By.xpath("//li[@data-id = 'tablist-tab_4']");
			
	// Add new incentive	
	By addinc =	By.xpath("//button[@aria-label = 'New Incentive']");
	
	// Select Contact at Add Incentive form
	By incconclick = By.xpath("//input[@aria-label = 'Contact, Lookup']");
	By incconsearch = By.xpath("//button[@aria-label = 'Search records for Contact, Lookup field']");
	By incconselect = By.xpath("//span[@data-id = 'xxc_contactid.fieldControl-emailaddress11_0_0']");
	
	// Select Market at Add Incentive form
	By incmarclick = By.xpath("//input[@aria-label = 'Market, Lookup']");
	By incmarsearch = By.xpath("//button[@aria-label = 'Search records for Market, Lookup field']");
	By incmarselect = By.xpath("//span[@data-id = 'xxc_marketid.fieldControl-xxc_channelid1_0_0']");
	
	// Select Referral Source at Add Incentive form
	By increfclick = By.xpath("//input[@aria-label = 'Referral Source, Lookup']");
	By increfsearch = By.xpath("//button[@aria-label = 'Search records for Referral Source, Lookup field']");
	By increfselect = By.xpath("//span[@data-id = 'xxc_referralsourceid.fieldControl-xxc_type1_0_0']");
	
	// Enter Other Incentive Source at Add Incentive form
	By incosclick = By.xpath("//input[@aria-label = 'Other Incentive Source']");
	By incosvalue = By.xpath("//input[@aria-label = 'Other Incentive Source']");
	
	// Save Incentive	
	By incsave = By.xpath("//button[@aria-label = 'Save & Close']");

	// Verification
	By incacc = By.xpath("//div[@title = 'Cyb_QATest']");
	By inccon = By.xpath("//div[@title = 'Cybage100']");
	By incmar = By.xpath("//div[@title = '2010 January 1 Daily']");

	//New Incentive Details
	By incdetails = By.xpath("//span[@aria-label='New Incentive Detail']");
	
	//Incentive text field
	By inctxtbox = By.xpath("//input[@aria-label='Incentive, Lookup']");
	
	By incchangeview = By.xpath("//button[@aria-label='Change View']");
	By activeincs = By.xpath("//li[@aria-label='Active Incentives']");
	
	//Incentive name
	By incname = By.xpath("//span[@data-id='xxc_incentiveid.fieldControl-xxc_accountid0_0_18']");
	
	//Incentive Category text field
	By inccattxtbox = By.xpath("//input[@aria-label='Incentive Category, Lookup']");
	By inccatsearch = By.xpath("//button[@aria-label='Search records for Incentive Category, Lookup field']");
	By inccatagname = By.xpath("//li[@aria-label='Atlanta Hotel']");
	
	//Incentive details Save & Close button
	By incdtlssavenclose = By.xpath("//button[@aria-label='Save and Close']");
			
	//Verification of Incentive details
	By validateincname = By.xpath("//div[@data-id='cell-0-4']");
	By incdtlssuccessmsg = By.xpath("//span[@data-id='notification-message']");

	public CRMIncentiveTab (WebDriver driver) {	
		this.driver = driver;
	}
	
	public WebElement getinctab() {
		return driver.findElement(inctab);
	}
	
	public WebElement getnewinc() {
		return driver.findElement(addinc);
	}
	
	public WebElement getconclick() {
		return driver.findElement(incconclick);
	}
	
	public WebElement getconsearch() {
		return driver.findElement(incconsearch);
	}
	
	public WebElement getconselect() {
		return driver.findElement(incconselect);
	}
	
	public WebElement getmarclick () {
		 return driver.findElement(incmarclick);
	}

	public WebElement getmarsearch() {	
		return driver.findElement(incmarsearch);
	}
	
	public WebElement getmarselect() {
		return driver.findElement(incmarselect);
	}
	
	public WebElement getrefclick () {
		 return driver.findElement(increfclick);
	}
	
	public WebElement getrefsearch() {
		return driver.findElement(increfsearch);
	}
	
	public WebElement getrefselect() {
		return driver.findElement(increfselect);
	}
	
	public WebElement getosclick() {
		return driver.findElement(incosclick);
	}
	
	public WebElement getosvalue() {
		return driver.findElement(incosvalue);
	}
	
	public WebElement getincsave() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(incsave));
		return driver.findElement(incsave);
	}
	
	public WebElement accname() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incacc));
		return driver.findElement(incacc);
	}
	
	public WebElement conname() {
		return driver.findElement(inccon);
	}
	
	public WebElement marname() {
		
		return driver.findElement(incmar);
	}

	public WebElement getIncDetaills() {
		return driver.findElement(incdetails);
	}
	
	public WebElement getInctxtbx(){
		return driver.findElement(inctxtbox);
	}
	
	public WebElement getIncChangeView() {
		return driver.findElement(incchangeview);
	}
	
	public WebElement getIncActiveIncs(){
		return driver.findElement(activeincs);
	}
	
	public WebElement getIncName(){
		return driver.findElement(incname);
	}
	
	public WebElement getIncCattxtbx(){
		return driver.findElement(inccattxtbox);
	}
	
	public WebElement getIncCatSearch(){
		return driver.findElement(inccatsearch);
	}
	
	public WebElement getIncCatName(){
		return driver.findElement(inccatagname);
	}
	
	public WebElement getIncDetailsSavenClose(){
		return driver.findElement(incdtlssavenclose);
	}
	
	public WebElement getValidateIncName(){
		return driver.findElement(validateincname);
	}
	
	public WebElement getIncdtlsSuccessMsg(){
		return driver.findElement(incdtlssuccessmsg);
	}
}

