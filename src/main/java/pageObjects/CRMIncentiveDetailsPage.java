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
	By selectinccat = By.xpath("//div[@aria-label = 'Incentive Category Lookup results']/ul[1]/li[1]");//Locator for incentive catrgory option in drop down list 
	By verifyincdet = By.xpath("//div[@data-id = 'IncentiveDetails_container']/div[1]/div[5]/div[1]/div[1]/div[1]/div[1]/div");//Locator for Incentive detail at General tab of incentive records
	By saveincdet = By.xpath("//button[@id = 'quickCreateSaveAndCloseBtn']");//Locator for Save & Close button
	By incentivedetailsexportdropdown= By.xpath("//button[@data-id = 'xxc_incentivedetail|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_incentivedetail.ExportToExcel.Menu$splitButtonId']");
	By selectcheckbox1 = By.xpath("//input[@data-id ='entitySelector_id-entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_incentivedetailcreatedby']");//Locator for checkbox
	By selectcheckbox2 = By.xpath("//input[@data-id ='entitySelector_id-entitySelector_id.fieldControl-displayNameLabelElementIdxxc_incentivedetailcreatedon']");//Locator for checkbox
	
	
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
	public WebElement getincentivedetailsexportdropdown() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incentivedetailsexportdropdown));
		return driver.findElement(incentivedetailsexportdropdown);
	}
	public WebElement getselectcheckbox1() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox1));
		return driver.findElement(selectcheckbox1);
	}
	public WebElement getselectcheckbox2() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox2));
		return driver.findElement(selectcheckbox2);
	}
	
}
