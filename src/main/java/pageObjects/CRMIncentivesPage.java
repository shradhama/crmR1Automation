package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentivesPage {
	
	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By clickexportoptionarrow = By.xpath("//button[@data-id = 'xxc_incentive|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_incentive.ExportToExcel.Menu$splitButtonId']");//Locator for export to excel arrow
	By selectcheckbox1 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_incentivecreatedby']");//Locator for checkbox
	By selectcheckbox2 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_incentivecreatedon']");//Locator for checkbox
	
	public CRMIncentivesPage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement getclickexportoptionarrow() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickexportoptionarrow));
		return driver.findElement(clickexportoptionarrow);
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

