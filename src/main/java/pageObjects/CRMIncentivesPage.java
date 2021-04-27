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
	By incentivetab = By.xpath("//li[@data-id = 'tablist-tab_4']"); //Locator for incentives tab for existing account	
	By addincentivebtn =	By.xpath("//button[@aria-label = 'New Incentive']"); //Locator for Add new incentive button
	By contacttxtbx = By.xpath("//input[@aria-label = 'Contact, Lookup']"); //Locator for Contact text field on incentive form
	By contactsearchrecordsbtn = By.xpath("//button[@aria-label = 'Search records for Contact, Lookup field']"); //Locator for Search records button of Contact field
	By selectcontactname = By.xpath("//span[@data-id = 'xxc_contactid.fieldControl-emailaddress11_0_0']"); //Locator of Contact name from lookup list
	By marckettxtbx = By.xpath("//input[@aria-label = 'Market, Lookup']"); //Locator for Market text field on incentive form
	By marketssearchrecordsbtn = By.xpath("//button[@aria-label = 'Search records for Market, Lookup field']"); //Locator for Search records button of Market field
	By selectmarketname = By.xpath("//span[@data-id='xxc_marketid.fieldControl-xxc_name0_0_0']"); //Locator of Market name from lookup list
	By referralsourcetxtbx = By.xpath("//input[@aria-label = 'Referral Source, Lookup']"); //Locator for Referral source text field on incentive form
	By referralsourcesearchrecordsbtn = By.xpath("//button[@aria-label = 'Search records for Referral Source, Lookup field']"); //Locator for Search records button of Referral Source field
	By selectreferralsourcename = By.xpath("//span[@data-id = 'xxc_referralsourceid.fieldControl-xxc_type1_0_0']"); //Locator of Referral source name from lookup list
	By savenclosebtn = By.xpath("//button[@aria-label = 'Save & Close']"); //Locator for Save & Close button for Incentive
	By accnameinincentivestab = By.xpath("//div[@data-id='cell-0-2']"); //Locator for Account name in Incentives tab
	By contactnameinincentivestab  = By.xpath("//div[@data-id='cell-0-3']"); //Locator for Contact name in Incentives tab
	By marketnameinincentivestab  = By.xpath("//div[@data-id='cell-0-4']"); //Locator for Market name in Incentives tab
	By selectedcontactnamefield = By.xpath("//div[@data-id='xxc_contactid.fieldControl-LookupResultsDropdown_xxc_contactid_selected_tag_text']"); //Locator for Selected contact field on incentive form
	By selectedmarketnamefield = By.xpath("//div[@data-id='xxc_marketid.fieldControl-LookupResultsDropdown_xxc_marketid_selected_tag_text']"); //Locator for Selected market field on incentive form
	By selectedreferralsourcenamefield = By.xpath("//div[@data-id='xxc_referralsourceid.fieldControl-LookupResultsDropdown_xxc_referralsourceid_selected_tag_text']"); //Locator for Selected referral source field on incentive form
	By contactfieldlabel = By.xpath("//label[contains(text(),'Contact')]"); //Locator for Contact field label
	By marketfieldlabel = By.xpath("//label[contains(text(),'Market')]"); //Locator for Market field label
	By referralsourcefieldlabel = By.xpath("//label[contains(text(),'Referral Source')]"); //Locator for Referral Source field label
	By selectincentiverecord = By.xpath("//div[@data-id='cell-0-1']"); //Locator to select an incentive record
	By incdeactivatebtn = By.xpath("//button[@data-id='xxc_incentive|NoRelationship|SubGridStandard|Mscrm.SubGrid.xxc_incentive.Deactivate']"); //Locator for Deactivate button for incentive record
	By deactivationpopupdeactivatebtn = By.xpath("//button[@data-id='ok_id']"); //Locator for Deactivate button on confirmation popup
	By selectedaccountnamefield = By.xpath("//div[@data-id='xxc_accountid.fieldControl-LookupResultsDropdown_xxc_accountid_selected_tag_text']"); //Locator for selected Account name on incentive form
	By marketnameinincentivestabofcontact  = By.xpath("//div[@data-id='cell-0-3']"); //Locator for Market name in Incentives tab for a contact
	By incentiveeditbtn = By.xpath("//button[@data-id='xxc_incentive|NoRelationship|SubGridStandard|Mscrm.SubGrid.xxc_incentive.Edit']"); //Locator for Edit button for a selected Incentive
	By deactivatebtnonincentiveform = By.xpath("//button[@data-id='xxc_incentive|NoRelationship|Form|Mscrm.Form.xxc_incentive.Deactivate']"); //Locator for Deactivate button on Incentive form
	By increadonlytext = By.xpath("//span[contains(text(),'Read-only  This record’s status: Inactive')]"); //Locator for Read Only text for inactive incentive
	By activeincdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']"); //Locator for drop down button for Active incentives
	By inactiveincoptn = By.xpath("//*[text()='Inactive Incentives']"); //Locator for 'Inactive Incentives' item
	By validateincinsearchresults = By.xpath("//div[@data-id='cell-0-2']"); //Locator to validate inactive incentive in search results
	By accountcolumn = By.xpath("//div[@data-id = 'xxc_accountid']");//Locator for Account column
	By contactcolumn = By.xpath("//div[@data-id = 'xxc_contactid']");//Locator for Contact column		
	By marketcolumn = By.xpath("//div[@data-id = 'xxc_marketid']");//Locator for Market column
	By gridoperator = By.xpath("//button[@data-index = '6']");//Locator for operator
	By selectactiveincentive = By.xpath("//div[@data-id='cell-0-2']"); //Locator to select an active incentive from grid
	By activatebtnonincform = By.xpath("//button[@data-id='xxc_incentive|NoRelationship|Form|Mscrm.Form.xxc_incentive.Activate']"); //Locator for Activate button on Incentive form
	By incentivenameonincform = By.xpath("//h1[@data-id='header_title']"); //Locator for Incentive name on Incentive form
	By nodataavailabletxt = By.xpath("//span[contains(text(),'No data available.')]"); //Locator for No data available text
	By activationpopupactivatebtn = By.xpath("//button[@data-id='ok_id']"); //Locator for Activate button on confirmation popup
	By activeincoptn = By.xpath("//*[text()='Active Incentives']"); //Locator for 'Active Incentives' item
	By clearsearch = By.xpath("//button[@aria-label = 'Clear search']");//Locator for clear search in the grid
	By selectedmarketnametxtbx = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|xxc_marketid.fieldControl|xxc_incentive']"); //Locator for Selected Market name text box
	By selectedmarketnamedeletebtn = By.xpath("//button[@data-id='xxc_marketid.fieldControl-LookupResultsDropdown_xxc_marketid_selected_tag_delete']"); //Locator for Delete button for Selected Market name text box
	By updatemarketname = By.xpath("//span[@data-id='xxc_marketid.fieldControl-xxc_name0_0_1']"); //Locator of 2nd Market name from lookup list
	By selectedaccountnametxtbx = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|xxc_accountid.fieldControl|xxc_incentive']"); //Locator for Selected Account name text box
	By selectedaccountnamedeletebtn = By.xpath("//button[@data-id='xxc_accountid.fieldControl-LookupResultsDropdown_xxc_accountid_selected_tag_delete']"); //Locator for Delete button for Selected Account name text box
	By updateaccountname = By.xpath("//span[@data-id='xxc_accountid.fieldControl-name0_0_1']"); //Locator for 2nd Account name
	By accountsearchrecordsbtn = By.xpath("//button[@aria-label = 'Search records for Account, Lookup field']"); //Locator for Search records button of Account field
	By accountfieldlabel = By.xpath("//label[contains(text(),'Account')]"); //Locator for Account field label
	By selectedcontacttxtbx = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|xxc_contactid.fieldControl|xxc_incentive']"); //Locator for Selected Contact text box
	By selectedcontactdeletebtn = By.xpath("//button[@data-id='xxc_contactid.fieldControl-LookupResultsDropdown_xxc_contactid_selected_tag_delete']"); //Locator for Delete button for Selected Contact name text box
	By updatecontactname = By.xpath("//span[@data-id='xxc_contactid.fieldControl-fullname0_0_2']"); //Locator for 2nd Contact name
	By accountlinkinincentivestab = By.xpath("//a[@href='https://imcqa.crm.dynamics.com/main.aspx?appid=9a772693-4e17-4119-97de-fede005ac172&pagetype=entityrecord&etn=account&id=18237dad-9781-ea11-a811-000d3a1bb158']"); //Locator for Account name in Incentives tab
	By selectincentiverecordonaccform = By.xpath("//div[@aria-label='Readonly Grid']/div/div/div/div[2]/div[1]"); //Locator for select incentive record on account form
	
	
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
	public WebElement getIncentiveTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incentivetab));
		return driver.findElement(incentivetab);
	}

	public WebElement getNewIncentiveBtn() {
		return driver.findElement(addincentivebtn);
	}

	public WebElement getContactTextBox() {
		return driver.findElement(contacttxtbx);
	}

	public WebElement getContactSearchRecordsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactsearchrecordsbtn));
		return driver.findElement(contactsearchrecordsbtn);
	}

	public WebElement SelectContactName() {
		return driver.findElement(selectcontactname);
	}

	public WebElement getMarketTextBox () {
		return driver.findElement(marckettxtbx);
	}

	public WebElement getMarketSearchRecordsBtn() {	
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketssearchrecordsbtn));
		return driver.findElement(marketssearchrecordsbtn);
	}

	public WebElement SelectMarketName() {
		return driver.findElement(selectmarketname);
	}

	public WebElement getReferralSourceTxtBx () {
		return driver.findElement(referralsourcetxtbx);
	}

	public WebElement getReferralSourceSearchRecordsBtn() {
		return driver.findElement(referralsourcesearchrecordsbtn);
	}

	public WebElement SelectReferralSourceName() {
		return driver.findElement(selectreferralsourcename);
	}

	public WebElement getSavenCloseBtn() {
		wait = new WebDriverWait (driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(savenclosebtn));
		return driver.findElement(savenclosebtn);
	}
	public WebElement getAccNameInIncentivesTab(){
		return driver.findElement(accnameinincentivestab);
	}
	public WebElement getContactNameInIncentivesTab(){
		return driver.findElement(contactnameinincentivestab);
	}
	public WebElement getMarketNameInIncentivesTab(){
		return driver.findElement(marketnameinincentivestab);
	}
	public WebElement getSelectedContactNameField(){
		return driver.findElement(selectedcontactnamefield);
	}
	public WebElement getSelectedMarketNameField(){
		return driver.findElement(selectedmarketnamefield);
	}
	public WebElement getSelectedReferralSourceNameField(){
		return driver.findElement(selectedreferralsourcenamefield);
	}
	public WebElement getContactFieldLabel(){
		return driver.findElement(contactfieldlabel);
	}
	public WebElement getMarketFieldLabel(){
		return driver.findElement(marketfieldlabel);
	}
	public WebElement getReferralSourceFieldLabel(){
		return driver.findElement(referralsourcefieldlabel);
	}
	public WebElement selectIncentiveRecord() throws InterruptedException{
		Thread.sleep(4000);
		return driver.findElement(selectincentiverecord);
	}
	public WebElement getIncDeactivateBtn(){
		return driver.findElement(incdeactivatebtn);
	}
	public WebElement getDeactivationPopupDeactivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(deactivationpopupdeactivatebtn));
		return driver.findElement(deactivationpopupdeactivatebtn);
	}
	public WebElement getSelectedAccountNameField(){
		return driver.findElement(selectedaccountnamefield);
	}
	public WebElement getMarketNameInIncentivesTabOfContact(){
		return driver.findElement(marketnameinincentivestabofcontact);
	}
	public WebElement getIncentiveEditButton(){
		return driver.findElement(incentiveeditbtn);
	}
	public WebElement getDeactivateBtnOnIncentiveForm(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivatebtnonincentiveform));
		return driver.findElement(deactivatebtnonincentiveform);
	}
	public WebElement getIncentiveReadOnlyText(){
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(increadonlytext));
		return driver.findElement(increadonlytext);
	}
	public WebElement getActiveIncDropDownBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeincdropdownbtn));
		return driver.findElement(activeincdropdownbtn);
	}
	public WebElement getInactiveIncOptn() {
		return driver.findElement(inactiveincoptn);
	}
	public WebElement getValidateIncInSearchResults() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validateincinsearchresults));
		return driver.findElement(validateincinsearchresults);
	}
	public WebElement getaccountcolumn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(accountcolumn));
		return driver.findElement(accountcolumn);
	}
	public WebElement getcontactcolumn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(contactcolumn));
		Thread.sleep(3000);
		return driver.findElement(contactcolumn);
	}
	public WebElement getmarketcolumn() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(marketcolumn));
		Thread.sleep(3000);
		return driver.findElement(marketcolumn);
	}
	public WebElement getgridoperator() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(gridoperator));
		Thread.sleep(3000);
		return driver.findElement(gridoperator);
	}
	public WebElement selectActiveIncentive() throws InterruptedException
	{
		Thread.sleep(7000);
		return driver.findElement(selectactiveincentive);
	}
	public WebElement getActivateBtnOnIncentiveForm() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activatebtnonincform));
		return driver.findElement(activatebtnonincform);
	}
	public WebElement getIncentiveNameOnIncForm() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incentivenameonincform));
		return driver.findElement(incentivenameonincform);
	}
	public WebElement getNoDataAvailableText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nodataavailabletxt));
		return driver.findElement(nodataavailabletxt);
	}
	public WebElement getActivationPopupActivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(activationpopupactivatebtn));
		return driver.findElement(activationpopupactivatebtn);
	}
	public WebElement getActiveIncOptn() {
		return driver.findElement(activeincoptn);
	}
	public WebElement getclearsearch() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(clearsearch));
		return driver.findElement(clearsearch);
	}
	public WebElement getSelectedMarketNameTxtbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedmarketnametxtbx));
		return driver.findElement(selectedmarketnametxtbx);
	}
	public WebElement getSelectedMarketNameDeleteBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedmarketnamedeletebtn));
		return driver.findElement(selectedmarketnamedeletebtn);
	}
	
	public WebElement UpdateMarketName() {
		return driver.findElement(updatemarketname);
	}
	
	public WebElement getSelectedAccountNameTxtbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedaccountnametxtbx));
		return driver.findElement(selectedaccountnametxtbx);
	}
	public WebElement getSelectedAccountNameDeleteBtn() {
		return driver.findElement(selectedaccountnamedeletebtn);
	}
	public WebElement UpdateAccountName() {
		return driver.findElement(updateaccountname);
	}
	public WebElement getAccountSearchRecordsBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountsearchrecordsbtn));
		return driver.findElement(accountsearchrecordsbtn);
	}
	public WebElement getAccountFieldLabel(){
		return driver.findElement(accountfieldlabel);
	}
	public WebElement getSelectedContactNameTxtbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedcontacttxtbx));
		return driver.findElement(selectedcontacttxtbx);
	}
	public WebElement getSelectedContactNameDeleteBtn() {
		return driver.findElement(selectedcontactdeletebtn);
	}
	
	public WebElement UpdateContactName() {
		return driver.findElement(updatecontactname);
	}
	public WebElement getAccountLinkInIncentivesTab() {
		return driver.findElement(accountlinkinincentivestab);
	}
	
	public WebElement selectIncentiveRecordonAccForm() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(selectincentiverecordonaccform);
	}
}

