package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMContactPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;
	
	By scrolltoaddcontact = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_column_3_section_1']");
	By clicknewcontactbutton = By.xpath("//button[@aria-label = 'New Contact']");
	By firstname = By.xpath("//input[@aria-label = 'First Name']");
	By lastname = By.xpath("//input[@aria-label = 'Last Name']");
	By email = By.xpath("//input[@aria-label = 'Email']");
	By mobile = By.xpath("//input[@aria-label = 'Mobile Phone']");
	By scrolltocontactaddress = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_section_4']");
	By street1 = By.xpath("//input[@aria-label = 'Street 1']");
	By city = By.xpath("//input[@aria-label = 'City']");
	By stateorprovince = By.xpath("//input[@aria-label = 'State/Province']");
	By ziporpostalcode = By.xpath("//input[@aria-label = 'ZIP/Postal Code']");
	By country = By.xpath("//input[@aria-label = 'Country']");
	By clicklistbox = By.xpath("//div[@class = 'wj-listbox-item']");
	By savecontact = By.xpath("//button[@aria-label = 'Save']");
	By verifycontact = By.xpath("//h1[@data-id='header_title']");
	By contactformemailtxtfield = By.xpath("//input[@data-id='emailaddress1.fieldControl-mail-text-input']");
	By contactformbusinessphonetxtfield = By.xpath("//input[@aria-label='Business Phone']");
	By contactsectionmenubtn = By.xpath("//button[@data-lp-id='SubGridStandard:contact-OverflowButton']");
	By contactsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	By contactnameinheader = By.xpath("//h1[@data-id='header_title']");
	By activecontactslabel = By.xpath("//h1[@aria-label='Active Contacts']");
	By createnewcontactbtn = By.xpath("//button[@aria-label='New']");
	By contactfirstnamelabel = By.xpath("//label[text()='First Name']");
	By contacttypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By contacttypeexpandbtn = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|contact']/div/div[6]/div[1]/div[2]/button[1]/span[1]");
	By contacttypebuyer = By.xpath("//div[contains(text(),'Buyer')]");
	By contactaccountnametxtbx = By.xpath("//input[@aria-label='Account Name, Lookup']");
	By searchrecordsbtn = By.xpath("//button[@aria-label='Search records for Account Name, Lookup field']");
	By accountnametitle = By.xpath("//span[@data-id='parentcustomerid.fieldControl-name0_0_0']");
	By scrolltextoncontactform = By.xpath("//div[text()='Select Save to see your timeline.']");
	By accountincentivedetailslabel = By.xpath("//div[text()='Account Incentive Details']");
	By mobilephonelabel = By.xpath("//label[text()='Mobile Phone']");
	By citylabel = By.xpath("//label[text()='City']");
	By countrytxtbx = By.xpath("//input[@aria-label='Country']");
	By cntryexpandbtn = By.xpath("//button[@aria-label='Toggle Dropdown']");
	By countryname = By.xpath("//body/div[@id='_dropdown']/div[3]");
	By validateInactiveContact = By.xpath("//div[@data-id='cell-0-2']");
	By inactivecontactsoptn = By.xpath("//*[text()='Inactive Contacts']");
	By contactdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']");
	By deactivatebtn = By.xpath("//button[@aria-label='Deactivate']");
	By deactivateokbtn = By.xpath("//button[@data-id='ok_id']");
	By qletterfilterlink = By.xpath("//a[@id='Q_link']");
	By contactstatusoutofbusiness = By.xpath("//option[contains(text(),'Out of Business')]");
	By statusreasonoutofbusinessinheader = By.xpath("//div[@title='Out of Business']");
	By contactstatusreason = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.PicklistStatusControl|header_statuscode.fieldControl|contact']");
	By opencontact = By.xpath("//div[@data-id = 'cell-0-2']");
	By calltophonecall = By.xpath("//input[@aria-label = 'Call To, Multiple Selection Lookup']");
	By searchcallto = By.xpath("//button[@aria-label = 'Search records for Call To, Multiple Selection Lookup field']");
	By selectcallto = By.xpath("//li[@data-id = 'to.fieldControl-LookupResultsDropdown_to_resultsContainer']");
	By clicktab = By.xpath("//li[@aria-label = 'Phone Call']");
	By selectexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div");
	By scrollrightongrid = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[4]/div[10]");
	By openexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div[10]/div[1]/button[1]");
	By contacttypemedia = By.xpath("//div[contains(text(),'Media')]");
	By jobfunctionfieldlabel = By.xpath("//label[contains(text(),'Job Function')]");
	By jobfunctionfieldtxtbox = By.xpath("//input[@aria-label='Job Function']");
	By jobfunctionfieldexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
	By jobfunctionvalueslist = By.xpath("//div[@id='xxc_jobrolecode_i']/div[6]/div[2]/ul/li");
	By jobfunctionvalue = By.xpath("//div[@id='xxc_jobrolecode_i']/div[6]/div[2]/ul/li[1]/label");
	By contactrefreshbtn = By.xpath("//button[@aria-label='Refresh']");
	By contacttypeselectedvaluetxtbx = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|contact']");
	By removecontacttypemediabtn = By.xpath("//button[@aria-label='Remove Media']");
	By businessphonelabel = By.xpath("//label[text()='Business Phone']");
	By cletterfilterlink = By.xpath("//a[@id='C_link']"); //Locator for 'C' letter filter link
	By selectcontactname = By.xpath("//div[@data-id='cell-2-2']"); //Locator to select Contact name in Grid
	By contactnaviagtebtn = By.xpath("//button[contains(@title, 'Navigate to') and contains(@class ,'cc-ds-rowbtn cc-gridcell-navigable wj-btn wj-btn-default cc-ds-rowbtn-nav')]"); //Locator for Navigate button on Contact grid
	By contactactivatebtn = By.xpath("//button[@aria-label='Activate']"); //Locator for Activate button in Contact form header
	By contactactivatepopupstatusfield = By.xpath("//select[@aria-label='Status']"); //Locator for 'Status field on contact activation pop-up
	By contactstatusdonotcall = By.xpath("//option[contains(text(),'Do Not Call')]"); //Locator for 'Do Not Call' contact status in drop-down
	By activatepopupactivatebtn = By.xpath("//button[@data-id='ok_id']"); //Locator for Activate button on pop-up
	By statusreasondonotcallinheader = By.xpath("//div[@title='Do Not Call']"); //Locator for contact status reason in contact form header
	By verifycontactappointment = By.xpath("//div[@id = 'TimelineGroupsMainContainer']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/label[1]");//Locator for subject for appointment in time line section for a contact
	By contactaddtimelinebtn = By.xpath("//button[@aria-label='Create a timeline record.']"); //Locator for Add Timeline button for Contact
	By contacttaskbtnontimeline = By.xpath("//div[text() = 'Task']");
	By contacttasksubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By contacttasksavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	
	public CRMContactPage(WebDriver driver) {

		this.driver = driver;
	}
	
	public WebElement getscrolltoaddcontact() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltoaddcontact));
		return driver.findElement(scrolltoaddcontact);
	}
	
	public WebElement getclicknewcontactbutton() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicknewcontactbutton));
		return driver.findElement(clicknewcontactbutton);
	}

	public WebElement getfirstname() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(firstname));
	return driver.findElement(firstname);
	}

	public WebElement getlastname() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(lastname));
	return driver.findElement(lastname);
	}

	public WebElement getmobile() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(mobile));
	return driver.findElement(mobile);
	}
	
	public WebElement getscrolltocontactaddress() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltocontactaddress));
		return driver.findElement(scrolltocontactaddress);
	}
	
	public WebElement getemail() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(email));
		return driver.findElement(email);
	}
	
	public WebElement getstreet1() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(street1));
		return driver.findElement(street1);
	}
	
	public WebElement getcity() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(city));
		return driver.findElement(city);
	}
	
	public WebElement getstateorprovince() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(stateorprovince));
		return driver.findElement(stateorprovince);
	}

	public WebElement getziporpostalcode() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(ziporpostalcode));
	return driver.findElement(ziporpostalcode);
	}

	public WebElement getcountry() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(country));
	return driver.findElement(country);
	}

	public WebElement getclicklistbox() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(clicklistbox));
	return driver.findElement(clicklistbox);
	}

	public WebElement getsavecontact() {
	
	wait = new WebDriverWait (driver,15);
	wait.until(ExpectedConditions.elementToBeClickable(savecontact));
	return driver.findElement(savecontact);
	}
	
	public WebElement getverifycontact() throws InterruptedException {
		
		Thread.sleep(7000);
		return driver.findElement(verifycontact);
		}
	public WebElement getContactFormEmailField() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformemailtxtfield));
		return driver.findElement(contactformemailtxtfield);
	}

	public WebElement getContactFormBusinessPhoneField() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformbusinessphonetxtfield));
		return driver.findElement(contactformbusinessphonetxtfield);
	}
	
	public WebElement getContactSavenCloseBtn() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(contactsavenclosebtn);
	}
	
	public WebElement getContactNameinHeader() throws InterruptedException {
		
		Thread.sleep(7000);
		return driver.findElement(contactnameinheader);
	}
	
	public WebElement getActiveContactsLabel() {
		return driver.findElement(activecontactslabel);
	}
	
	public WebElement getCreateNewContactBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(createnewcontactbtn);
	}
	
	public WebElement getContactFirstNameLabel() {
		return driver.findElement(contactfirstnamelabel);
	}
	
	public WebElement getContactTypetxtbx()
	{
		return driver.findElement(contacttypetxtbx);
	}

	public WebElement getContactTypeExpandbtn()
	{
		return driver.findElement(contacttypeexpandbtn);
	}

	public WebElement getContactTypeBuyer()
	{
		return driver.findElement(contacttypebuyer);
	}
	
	public WebElement getContactAccountNameTxtbx()
	{
		return driver.findElement(contactaccountnametxtbx);
	}
	
	public WebElement getSearchRecordsBtn()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchrecordsbtn));	
		return driver.findElement(searchrecordsbtn);
	}
	
	public WebElement getAccountNameTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountnametitle));
		return driver.findElement(accountnametitle);
	}
	
	public WebElement getScrollTextOnContactForm() {
		
		return driver.findElement(scrolltextoncontactform);
	}
		
	public WebElement getMobilePhoneLabel() {
		
		return driver.findElement(mobilephonelabel);
	}
	public WebElement getCityLabel() {
		
		return driver.findElement(citylabel);
	}
	public WebElement getCountrytxbx()
	{
		return driver.findElement(countrytxtbx);
	}

	public WebElement getCountrydrpbtn()
	{
		return driver.findElement(cntryexpandbtn);
	}

	public WebElement getCountryName()
	{
		return driver.findElement(countryname);
	}
	
	public WebElement getContactSectionMenuBtn()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactsectionmenubtn));
		return driver.findElement(contactsectionmenubtn);
	}
	
	public WebElement getValidateInactiveContactName() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(validateInactiveContact);
	}
	
	public WebElement getInactiveContactOptn() {
		return driver.findElement(inactivecontactsoptn);
	}
	
	public WebElement getActiveContactDropDownBtn() {
		return driver.findElement(contactdropdownbtn);
	}
	
	public WebElement getDeactivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivatebtn));
		return driver.findElement(deactivatebtn);
	}
	
	public WebElement getDeactivateOkBtn() {
		return driver.findElement(deactivateokbtn);
	}
	
	public WebElement getQLetterFilterLink() throws InterruptedException {
		
		Thread.sleep(10000);
		return driver.findElement(qletterfilterlink);
	}
	
	public WebElement getContactStatusOutofBusiness() {

		return driver.findElement(contactstatusoutofbusiness);
	}
	
	public WebElement getContactStatusResonForInactiveAcc() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonoutofbusinessinheader));
		return driver.findElement(contactstatusreason);
	}
	
	public WebElement getopencontact() throws InterruptedException {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(opencontact));
		Thread.sleep(10000);
		return driver.findElement(opencontact);
	}
	
	public WebElement getcalltophonecall()  {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(calltophonecall));
		return driver.findElement(calltophonecall);
	}
	
	public WebElement getsearchcallto()  {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(searchcallto));
		return driver.findElement(searchcallto);
	}
	

	public WebElement getselectcallto() throws InterruptedException  {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcallto));
		Thread.sleep(5000);
		return driver.findElement(selectcallto);
	}

	public WebElement getContactTypeMedia()
	{
		return driver.findElement(contacttypemedia);
	}
	
	public List<WebElement> getJobFunctionFieldLabel()
	{
		return driver.findElements(jobfunctionfieldlabel);
	}
	
	public WebElement getJobFunctionFieldTxtBox()
	{
		return driver.findElement(jobfunctionfieldtxtbox);
	}
	
	public WebElement getJobFunctionFieldExpandBtn()
	{
		return driver.findElement(jobfunctionfieldexpandbtn);
	}
	
	public List<WebElement> getJobFunctionvValuesList()
	{
		return driver.findElements(jobfunctionvalueslist);
	}
	
	public WebElement getJobFunctionValue()
	{
		return driver.findElement(jobfunctionvalue);
	}
	public WebElement getContactFormRefreshBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(contactrefreshbtn);
	}
	
	public WebElement getContactTypeSelectedValueTxtbx()
	{
		return driver.findElement(contacttypeselectedvaluetxtbx);
	}
	
	public WebElement getRemoveContactTypeMediaBtn()
	{
		return driver.findElement(removecontacttypemediabtn);
	}

	public WebElement getBusinessPhoneLabel() {
		
		return driver.findElement(businessphonelabel);

	}
	
	public WebElement getCLetterFilterLink() throws InterruptedException {
		
		Thread.sleep(10000);
		return driver.findElement(cletterfilterlink);
	}
	
	public WebElement selectContactName() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(selectcontactname);
	}
	
	public WebElement getContactNaviagteBtn() {
		return driver.findElement(contactnaviagtebtn);
	}
	
	public WebElement getContactStatusDoNotCall() {
		return driver.findElement(contactstatusdonotcall);
	}
	
	public WebElement getContactActivateBtn() {
		return driver.findElement(contactactivatebtn);
	}
	
	public WebElement getContactActivatePopupStatusField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactactivatepopupstatusfield));
		return driver.findElement(contactactivatepopupstatusfield);
	}
	
	public WebElement getActivatePopupActivatebtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(activatepopupactivatebtn)).click();
		return driver.findElement(activatepopupactivatebtn);
	}
	
	public WebElement getContactStatusResonForActiveContact() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasondonotcallinheader));
		return driver.findElement(contactstatusreason);
	}
                                   
	public WebElement getclicktab() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicktab));
		return driver.findElement(clicktab);
	}
	public WebElement getverifycontactappointment() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifycontactappointment));
		return driver.findElement(verifycontactappointment);
	}
	public WebElement getContactAddTimelineBtn()
	{
		return driver.findElement(contactaddtimelinebtn);
	}
	public WebElement getContactTaskBtnOnTimeline()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contacttaskbtnontimeline));
		return driver.findElement(contacttaskbtnontimeline);
	}
	
	public WebElement getContactTaskSujecttxbx() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(contacttasksubjecttxtbx);
	}
	
	public WebElement getContactTaskSavenClosebtn()
	{
		return driver.findElement(contacttasksavenclosebtn);
	}
	
}
