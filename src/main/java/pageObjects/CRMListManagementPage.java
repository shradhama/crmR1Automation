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
	By listname= By.xpath("//input[@id='id-7ff65c21-4d68-426f-8735-20aa96d791b0-1-xxc_name8-xxc_name.fieldControl-text-box-text']"); //Locator to enter the name
	By listtype= By.xpath("//select[@id='id-7ff65c21-4d68-426f-8735-20aa96d791b0-4-xxc_type8-xxc_type.fieldControl-option-set-select']"); //Locator to select list type
	By listtypeoption= By.xpath("//option[@value='272970001']"); //Locator to select list type option
	By listsaveclosebtn= By.xpath("//button[@aria-label='Save & Close']"); //Locator to click on save and close button
	By listnewbtn = By.xpath("//span[contains(text(),'New')]"); //Locator to click on list add new button
	By listnamesearchtable= By.xpath("//div[@data-id='cell-0-2']"); //Locator to validate list entry from search table
	By searchlistrecord= By.xpath("//input[@aria-label='Search this view']"); //Locator to search field for lists
	By scrollexpdate = By.xpath("//span[@title = 'Expiration Date']");//Locator for Expiration Date field title
	By lastmemadded = By.xpath("//input[@data-id = 'xxc_lastlistmemberadded.fieldControl-date-time-input']");//Locator for Last List Member Added field title
	By lastmemremoved = By.xpath("//input[@data-id = 'xxc_lastlistmemberremoved.fieldControl-date-time-input']");//Locator for Last List Member Removed field title
	By listlastupdated = By.xpath("//input[@data-id = 'xxc_listlastupdated.fieldControl-date-time-input']");//Locator for Last List Updated field title
	By lastupdatedmemberadded = By.xpath("//label[@data-id = 'xxc_lastlistmemberadded-calculatedDateLabel']");//Locator for Last Updated Member Added
	By lastupdatedmemberaremoved = By.xpath("//label[@data-id = 'xxc_lastlistmemberremoved-calculatedDateLabel']");//Locator for Last Updated Member Removed
	By listmembersgrid = By.xpath("//div[@aria-label = 'Active List Members']");//Locator for List Members grid
	By griddateadded = By.xpath("//div[@data-id='cell-0-5']");//Locator for Date Added column in List Members grid
	By griddateremoved = By.xpath("//div[@data-id = 'xxc_dateremoved']");//Locator for Date Removed column in List Members grid
	By sortnewtooldmemgrid = By.xpath("//button[@aria-label = 'Sort Newest to Oldest']");//Locator for sorting newest to oldest in member grid
	By datremovedonlistmember = By.xpath("//input[@data-id = 'xxc_dateremoved.fieldControl-date-time-input']");//Locator for date removed field at List Member form
	By selectdateremoved = By.xpath("//div[@aria-label = 'Calendar']/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[4]/td[5]/button[1]");//Locator for current date for date removed in calendor
	By newlistmember = By.xpath("//button[@aria-label = 'New List Member']");//Locator for New Member button on lists page
	By accountlistmember = By.xpath("//input[@data-id = 'xxc_account.fieldControl-LookupResultsDropdown_xxc_account_textInputBox_with_filter_new']");//Locator for Account search boc at List Members page
	By selectaccountlistmember = By.xpath("//span[@data-id='xxc_account.fieldControl-name0_0_0']");//Locator for account in search list
	By openlistmenmber = By.xpath("//div[@data-id = 'cell-0-1']");//Locator for header column for Members List grid
	By companyid = By.xpath("//input[@data-id = 'xxc_companymemberid.fieldControl-text-box-text']");//Locator for Company id field for List Members
	By listlastupdateddate = By.xpath("//input[@aria-label='Date of List Last Updated']"); //Locator for List Last Updated date'
	By listmemaddedfilterbtn = By.xpath("//div[@data-id='xxc_dateadded']/div/div/div/div[2]/i"); //Locator for filter button of Date Added column
	By listmemremovedfilterbtn = By.xpath("//div[@data-id='xxc_dateremoved']/div/div/div/div[2]/i"); //Locator for filter button of Date Removed column
	By newtooldfilter = By.xpath("//span[contains(text(),'Sort Newest to Oldest')]"); //Locator for 'Sort Newest to Oldest' filter option
	By listrefreshbtn = By.xpath("//button[@aria-label='Refresh']"); //Locator for Refresh button for List page
	By newaccountbtnonlistmemform = By.xpath("//button[@aria-label='New Account']"); //Locator for New Account btn on List Member form
	By unsavedchngssavencontbtn = By.xpath("//button[@aria-label='Save and continue']"); //Locator for Save and continue btn on Unsaved changes pop-up
	By exportlistmembers = By.xpath("//button[@data-id = 'xxc_listmember|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_listmember.ExportToExcel.Menu$splitButtonId']");//Locator for Export List Members button
	By listmembercreatedby = By.xpath("//input[@aria-label = 'Created By']");//Locator for check box Created By
	By listmembercreatedon = By.xpath("//input[@aria-label = 'Created On']");//Locator for check box Created On
	
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
	public WebElement getscrollexpdate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrollexpdate));
		return driver.findElement(scrollexpdate);	
	}
	public WebElement getlastmemadded() throws InterruptedException {
		Thread.sleep(6000);
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(lastmemadded));
		return driver.findElement(lastmemadded);	
	}
	public WebElement getlastmemremoved() throws InterruptedException {
		Thread.sleep(6000);
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(lastmemremoved));
		return driver.findElement(lastmemremoved);	
	}
	public WebElement getlistlastupdated() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listlastupdated));
		return driver.findElement(listlastupdated);	
	}
	public WebElement getlastupdatedmemberadded() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastupdatedmemberadded));
		return driver.findElement(lastupdatedmemberadded);	
	}
	public WebElement getlastupdatedmemberaremoved() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lastupdatedmemberaremoved));
		return driver.findElement(lastupdatedmemberaremoved);	
	}
	public WebElement getlistmembersgrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmembersgrid));
		return driver.findElement(listmembersgrid);	
	}
	public WebElement getgriddateadded() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(griddateadded));
		return driver.findElement(griddateadded);	
	}
	public WebElement getgriddateremoved() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(griddateremoved));
		return driver.findElement(griddateremoved);	
	}
	public WebElement getsortnewtooldmemgrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortnewtooldmemgrid));
		return driver.findElement(sortnewtooldmemgrid);
	}
	public WebElement getdatremovedonlistmember() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(datremovedonlistmember));
		return driver.findElement(datremovedonlistmember);
	}
	public WebElement getselectdateremoved() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectdateremoved));
		return driver.findElement(selectdateremoved);
	}
	public WebElement getnewlistmember() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newlistmember));
		return driver.findElement(newlistmember);
	}
	public WebElement getaccountlistmember() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountlistmember));
		return driver.findElement(accountlistmember);
	}

	public WebElement getselectaccountlistmember() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(selectaccountlistmember);
	}
	public WebElement getopenlistmenmber() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(openlistmenmber));
		return driver.findElement(openlistmenmber);
	}
	public WebElement getcompanyid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(companyid));
		return driver.findElement(companyid);
	}

	public WebElement getListMemAddedFilterBtn() {
		return driver.findElement(listmemaddedfilterbtn);
	}
	public WebElement getListMemRemovedFilterBtn() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(listmemremovedfilterbtn);
	}
	public WebElement getNewToOldFilterOptn() {
		return driver.findElement(newtooldfilter);
	}
	public WebElement getListRefreshBtn() {
		return driver.findElement(listrefreshbtn);
	}
	public WebElement getNewAccountBtnOnListMemForm() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newaccountbtnonlistmemform));
		return driver.findElement(newaccountbtnonlistmemform);
	}
	public WebElement getUnsavedChngsSavenContBtn() {
		return driver.findElement(unsavedchngssavencontbtn);
	}
	public WebElement getListLastUpdatedDate() {
		return driver.findElement(listlastupdateddate);
	}
	public WebElement getexportlistmembers() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exportlistmembers));
		return driver.findElement(exportlistmembers);
	}
	public WebElement getlistmembercreatedby() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmembercreatedby));
		return driver.findElement(listmembercreatedby);
	}
	public WebElement getlistmembercreatedon() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmembercreatedon));
		return driver.findElement(listmembercreatedon);
	}
}
