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
	By saveandcloseincdet = By.xpath("//button[@id = 'quickCreateSaveAndCloseBtn']");//Locator for Save & Close button
	By contactddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[4]");//Locator for Contact group by option
	By marketddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[5]");//Locator for Market group by option
	By accountddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[9]");//Locator for Account group by option
	By inccatddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[6]");//Locator for Incentive Category group by option
	By estvalddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[7]");//Locator for Estimated Value group by option
	By statusddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[8]");//Locator for Incentive Detail Status group by option
	By filterop = By.xpath("//button[@data-index = '6']");//Locator for Begins With operator
	By inccat = By.xpath("//div[@data-id = 'xxc_incentivecategory']");//Locator for Incentive Category column in grid
	By incestval = By.xpath("//div[@data-id = 'xxc_estimatedvalue']");//Locator for estimated value column in grid
	By incstatus = By.xpath("//div[@data-id = 'xxc_incentivedetailstatuscode']");//Locator for Incentive Details Status column in grid
	By filtervalue = By.xpath("//div[@class = 'ms-TextField-wrapper']/div[1]/input[1]");//Locator for filter by value text box
	By clickarrowforactiveincentive = By.xpath("//div[@data-id = 'GridRoot']/div[1]/div[2]/div[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/h1[1]/div[1]");//Locator for incentive type drop down list
	By selectactivetype = By.xpath("//li[@aria-label = 'Active Incentive Details']");//Locator for Active Incentive Details in drop down
	By clearbtn = By.xpath("//button[@type = 'button']");//Locator for Clear button
	By selectedincentive = By.xpath("//div[@data-id = 'xxc_incentiveid.fieldControl-LookupResultsDropdown_xxc_incentiveid_selected_tag']");//Locator for selected incentive 
	By deleteinc = By.xpath("//button[@data-id = 'xxc_incentiveid.fieldControl-LookupResultsDropdown_xxc_incentiveid_selected_tag_delete']");//Locator for X buttonn for incentive
	By searchinc = By.xpath("//button[@data-id = 'xxc_incentiveid.fieldControl-LookupResultsDropdown_xxc_incentiveid_search']");//Locator for search button
	By selectinc = By.xpath("//li[@data-id = 'xxc_incentiveid.fieldControl-LookupResultsDropdown_xxc_incentiveid_resultsContainer']");//Locator for incentive option
	By selectedinccat = By.xpath("//div[@data-id = 'xxc_incentivecategory.fieldControl-LookupResultsDropdown_xxc_incentivecategory_selected_tag']");//Locator for selected incentive category
	By deleteinccat = By.xpath("//button[@data-id = 'xxc_incentivecategory.fieldControl-LookupResultsDropdown_xxc_incentivecategory_selected_tag_delete']");//Locator for delete button for incentive category
	By searchinccat = By.xpath("//button[@data-id = 'xxc_incentivecategory.fieldControl-LookupResultsDropdown_xxc_incentivecategory_search']");//Locator for search incentive category button 
	By selinccat = By.xpath("//li[@data-id = 'xxc_incentivecategory.fieldControl-LookupResultsDropdown_xxc_incentivecategory_resultsContainer']");//Locator incentive category option
	By saveincdet = By.xpath("//button[@data-id = 'quickCreateSaveAndCloseBtn']");//Locator for Save button in incentive details page
	By refincdet = By.xpath("//button[@data-id = 'xxc_incentivedetail|NoRelationship|Form|Mscrm.Form.xxc_incentivedetail.RefreshModernButton']");//Locator for Refresh button
	By incentivedetailsexportdropdown= By.xpath("//button[@data-id = 'xxc_incentivedetail|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_incentivedetail.ExportToExcel.Menu$splitButtonId']");//Locator for export to excel dropdown
	By selectcheckbox1 = By.xpath("//input[@data-id='entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_incentivedetailcreatedby']");//Locator for checkbox
	By selectcheckbox2 = By.xpath("//input[@data-id='entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_incentivedetailcreatedon']");//Locator for checkbox
	By deactivateincdet = By.xpath("//button[@data-id = 'xxc_incentivedetail|NoRelationship|Form|Mscrm.Form.xxc_incentivedetail.Deactivate']");//Locator for deactivate button for incentive details
	By activateincdet = By.xpath("//button[@data-id = 'xxc_incentivedetail|NoRelationship|Form|Mscrm.Form.xxc_incentivedetail.Activate']");//Locator for Activate button for inactive incentive details
	By incdetreadonlytext = By.xpath("//div[@data-id = 'form-header']/div[1]/div[1]/div[1]/span[2]");//Locator for Read Only title when incentive details are deactivated
	By gridmarket = By.xpath("//div[@data-id = 'cell-0-7']");//Locator for Market column in the grid
	By incetivecategory = By.xpath("//ul[@data-id = 'xxc_incentivecategory.fieldControl-LookupResultsDropdown_xxc_incentivecategory_SelectedRecordList']");//Locator for incentive category when incentive details record is opened
	By openincentive = By.xpath("//div[@data-id = 'xxc_incentiveid.fieldControl-LookupResultsDropdown_xxc_incentiveid_selected_tag_text']");//Locator for incentive at incentive details page
	By contact = By.xpath("//ul[@data-id = 'xxc_contactid.fieldControl-LookupResultsDropdown_xxc_contactid_SelectedRecordList']");//Locator for contact at incentives form
	By market = By.xpath("//ul[@data-id = 'xxc_marketid.fieldControl-LookupResultsDropdown_xxc_marketid_SelectedRecordList']");//Locator for market at incentives form
	By account = By.xpath("//ul[@data-id = 'xxc_accountid.fieldControl-LookupResultsDropdown_xxc_accountid_SelectedRecordList']");//Locator for Account at incentives form
	By accountnameindetgrid = By.xpath("//div[@aria-label = 'Active Incentive Details Account Subgrid']");//Locator for Contact in incentive details grid at account page
	By contactnameindetgrid = By.xpath("//div[@aria-label = 'Active Incentive Details Contact Subgrid']");//Locator for Market in incentive details grid at account page
	By inccatindetgrid = By.xpath("//div[@aria-label = 'Active Incentive Details Account Subgrid']/div[2]/div[4]");//Locator for Incentive Category in incentive details grid at account page
	By inactiveincdetgrid = By.xpath("//div[@aria-label = 'Inactive Incentive Details']");//Locator for inactive Incentive Details grid
	By verifygridacc = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div[5]");//Locator for Grid Market data
	By inactiveincentivedetails= By.xpath("//li[@aria-label= 'Inactive Incentive Details']"); //Locator to select Inactive Incentive Details option for Activate button
	By verifygridaccname = By.xpath("//div[@data-id='cell-0-7']");//Locator for Grid account name data
	By clickincentivetab = By.xpath("//ul[@aria-label = 'Account Form']/li[3]");//Locator for Incentives tab on Account form
	By incdetgrid = By.xpath("//button[@data-id = 'dataSetRoot_IncentivesDetailTab']/div[1]/div[1]/h3[1]");//Locator for incentive details section on Account and COntact incentives tab
	
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
	public WebElement getsaveandcloseincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(saveandcloseincdet));
		return driver.findElement(saveandcloseincdet);
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
	public WebElement getfilterop() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(filterop));
		return driver.findElement(filterop);
	}
	public WebElement getinccat() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inccat));
		return driver.findElement(inccat);
	}
	public WebElement getincestval() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incestval));
		return driver.findElement(incestval);
	}
	public WebElement getincstatus() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incstatus));
		return driver.findElement(incstatus);
	}
	public WebElement getfiltervalue() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(filtervalue));
		return driver.findElement(filtervalue);
	}
	public WebElement getclickarrowforactiveincentive() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickarrowforactiveincentive));
		return driver.findElement(clickarrowforactiveincentive);
	}
	public WebElement getselectactivetype() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectactivetype));
		return driver.findElement(selectactivetype);
	}
	public WebElement getclearbtn() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clearbtn));
		return driver.findElement(clearbtn);
	}
	public WebElement getselectedincentive() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectedincentive));
		return driver.findElement(selectedincentive);
	}
	public WebElement getdeleteinc() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(deleteinc));
		return driver.findElement(deleteinc);
	}
	public WebElement getsearchinc() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(searchinc));
		return driver.findElement(searchinc);
	}
	public WebElement getselectinc() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectinc));
		return driver.findElement(selectinc);
	}
	public WebElement getselectedinccat() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectedinccat));
		return driver.findElement(selectedinccat);
	}
	public WebElement getdeleteinccat() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(deleteinccat));
		return driver.findElement(deleteinccat);
	}
	public WebElement getsearchinccat() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(searchinccat));
		return driver.findElement(searchinccat);
	}
	public WebElement getselinccat() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selinccat));
		return driver.findElement(selinccat);
	}
	public WebElement getsaveincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(saveincdet));
		return driver.findElement(saveincdet);
	}
	public WebElement getrefincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(refincdet));
		return driver.findElement(refincdet);
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
	public WebElement getincetivecategory() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incetivecategory));
		return driver.findElement(incetivecategory);
	}
	public WebElement getdeactivateincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(deactivateincdet));
		return driver.findElement(deactivateincdet);
	}
	public WebElement getactivateincdet() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(activateincdet));
		return driver.findElement(activateincdet);
	}
	public WebElement getincdetreadonlytext() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incdetreadonlytext));
		return driver.findElement(incdetreadonlytext);
	}
	public WebElement getgridmarket() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(gridmarket));
		return driver.findElement(gridmarket);
	}
	public WebElement getopenincentive() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(openincentive));
		return driver.findElement(openincentive);
	}
	public WebElement getcontact() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(contact));
		return driver.findElement(contact);
	}
	public WebElement getmarket() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(market));
		return driver.findElement(market);
	}
	public WebElement getaccount() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(account));
		return driver.findElement(account);
	}
	public WebElement getaccountnameindetgrid() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(accountnameindetgrid));
		return driver.findElement(accountnameindetgrid);
	}
	public WebElement getcontactnameindetgrid() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(contactnameindetgrid));
		return driver.findElement(contactnameindetgrid);
	}
	public WebElement getinccatindetgrid() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inccatindetgrid));
		return driver.findElement(inccatindetgrid);
	}
	public WebElement getinactiveincdetgrid() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inactiveincdetgrid));
		return driver.findElement(inactiveincdetgrid);
	}
	public WebElement getverifygridacc() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifygridacc));
		return driver.findElement(verifygridacc);
	}
	public WebElement getinactiveincentivedetails() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(inactiveincentivedetails));
		return driver.findElement(inactiveincentivedetails);
	}

	public WebElement getverifygridaccname() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifygridaccname));
		return driver.findElement(verifygridaccname);
	}
	public WebElement getclickincentivetab() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickincentivetab));
		return driver.findElement(clickincentivetab);
	}
	public WebElement getincdetgrid() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incdetgrid));
		return driver.findElement(incdetgrid);
	}
}
