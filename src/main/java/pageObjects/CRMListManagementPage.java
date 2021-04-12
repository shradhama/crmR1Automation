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
	//By selectview = By.xpath("li[contain (text(),'Co-Op List Query for Un-contacted Accounts')");//Locator for view in drop down for 'Co-Op List Query for Un-contacted Accounts'
	By pagegrid = By.xpath("//div[@aria-label = 'Editable Grid']");//Locator for entity grid
	By pinuncontacted = By.xpath("//div[@aria-label = 'Pin Co-Op List Query for Un-contacted Accounts']");//Locator for pin button for 'Co-Op List Query for Un-contacted Accounts'
	By unpin = By.xpath("//div[@title = 'Default view for this list']");//Locator for unpining default view
	By listmembersremoved = By.xpath("//div[@aria-label = 'List Members Removed']");//Locator for LIst Members Removed view
	By openlist = By.xpath("//div[@data-id = 'xxc_list.fieldControl-LookupResultsDropdown_xxc_list_selected_tag_text']");//Locator for List at List Member page
	By selectview = By.xpath("li[contain (text(),'Co-Op List Query for Un-contacted Accounts')");//Locator for view in drop down for 'Co-Op List Query for Un-contacted Accounts'
	By pagegrid = By.xpath("//div[@aria-label = 'Editable Grid']");//Locator for entity grid
	By pinuncontacted = By.xpath("//div[@aria-label = 'Pin Co-Op List Query for Un-contacted Accounts']");//Locator for pin button for 'Co-Op List Query for Un-contacted Accounts'
	By unpin = By.xpath("//div[@title = 'Default view for this list']");//Locator for unpining default view
	By listname= By.xpath("//input[@id='id-7ff65c21-4d68-426f-8735-20aa96d791b0-1-xxc_name8-xxc_name.fieldControl-text-box-text']"); //Locator to enter the name
	By listtype= By.xpath("//select[@id='id-7ff65c21-4d68-426f-8735-20aa96d791b0-4-xxc_type8-xxc_type.fieldControl-option-set-select']"); //Locator to select list type
	By listtypeoption= By.xpath("//option[@value='272970001']"); //Locator to select list type option
	By listsaveclosebtn= By.xpath("//button[@aria-label='Save & Close']"); //Locator to click on save and close button
	By listnewbtn = By.xpath("//span[contains(text(),'New')]"); //Locator to click on list add new button
	By listnamesearchtable= By.xpath("//div[@data-id='cell-0-2']"); //Locator to validate list entry from search table
	By searchlistrecord= By.xpath("//input[@aria-label='Search this view']"); //Locator to search field for lists


	
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
	public WebElement getpagegrid() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(pagegrid));
		return driver.findElement(pagegrid);
	}
	public WebElement getpinuncontacted() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(pinuncontacted));
		return driver.findElement(pinuncontacted);
	}

	public WebElement getlistmembersremoved() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(listmembersremoved));
		return driver.findElement(listmembersremoved);
	}
	public WebElement getopenlist() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(openlist));
		return driver.findElement(openlist);
	}

	public WebElement getunpin() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(unpin));
		return driver.findElement(unpin);
	}

	public WebElement getunpin() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(unpin));
		return driver.findElement(unpin);
	}
	public WebElement getlistname() {

		return driver.findElement(listname);
	}
	public WebElement getlisttype() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(listtype));
		return driver.findElement(listtype);
	}
	public WebElement getlisttypeoption() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(listtypeoption));
		return driver.findElement(listtypeoption);
	}

	public WebElement getlistsaveclosebtn() {

		return driver.findElement(listsaveclosebtn);
	}

	public WebElement getlistnewbtn() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(listnewbtn);
	}

	public WebElement getlistnamesearchtable() throws InterruptedException
	{
		Thread.sleep(6000);
		return driver.findElement(listnamesearchtable);
	}
	
	public WebElement getsearchlistrecord() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(searchlistrecord);
	}


}
