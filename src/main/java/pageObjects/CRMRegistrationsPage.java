package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMRegistrationsPage {
	
	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By registrationname = By.xpath("//input[@aria-label = 'Name']");//Locator for Registration Name
	By readonlynotification = By.xpath("//div[@id = 'notificationMessageAndButtons']");//Locator for read only mesage
	By regexportexcel = By.xpath("//button[@data-id = 'xxc_registration|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_registration.ExportToExcel.Menu$splitButtonId']");//Locator for export to excel arrow
	By accountfieldonreggrid = By.xpath("//div[@data-id='cell-0-6']"); //Locator for Account field on Registration Grid

	public CRMRegistrationsPage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement getregistrationname() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(registrationname));
		return driver.findElement(registrationname);
	}
	public WebElement getreadonlynotification() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(readonlynotification));
		return driver.findElement(readonlynotification);
	}
	public WebElement getregexportexcel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(regexportexcel));
		return driver.findElement(regexportexcel);
	}
	public WebElement getAccountFieldOnRegGrid() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountfieldonreggrid));
		return driver.findElement(accountfieldonreggrid);
	}

}
