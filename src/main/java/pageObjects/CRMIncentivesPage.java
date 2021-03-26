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
	By selectmarketname = By.xpath("//span[@data-id = 'xxc_marketid.fieldControl-xxc_channelid1_0_0']"); //Locator of Market name from lookup list
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
		return driver.findElement(incentivetab);
	}

	public WebElement getNewIncentiveBtn() {
		return driver.findElement(addincentivebtn);
	}

	public WebElement getContactTextBox() {
		return driver.findElement(contacttxtbx);
	}

	public WebElement getContactSearchRecordsBtn() {
		return driver.findElement(contactsearchrecordsbtn);
	}

	public WebElement SelectContactName() {
		return driver.findElement(selectcontactname);
	}

	public WebElement getMarketTextBox () {
		return driver.findElement(marckettxtbx);
	}

	public WebElement getMarketSearchRecordsBtn() {	
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
	public WebElement selectIncentiveRecord(){
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
}

