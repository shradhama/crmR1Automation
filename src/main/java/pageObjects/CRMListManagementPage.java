package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMListManagementPage {
	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	
	By listsexportdropdown= By.xpath("//button[@data-id = 'xxc_list|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_list.ExportToExcel.Menu$splitButtonId']");//Locator for export to excel dropdown
	By selectcheckbox1 = By.xpath("//input[@id='id-3a9ef5c2-02f2-49fc-b79e-5bb37b19ac68-1-entitySelector_id3-entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_listcreatedby']");//Locator for checkbox
	By selectcheckbox2 = By.xpath("//input[@id='id-3a9ef5c2-02f2-49fc-b79e-5bb37b19ac68-1-entitySelector_id3-entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_listcreatedon']");//Locator for checkbox
	
	
	public CRMListManagementPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getlistsexportdropdown() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(listsexportdropdown));
		return driver.findElement(listsexportdropdown);
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
