package pageObjects;

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
	By contactformbusinessphonetxtfield = By.xpath("//input[@aria-describedby='id-fd46b725-b6a7-47e9-b1d0-6f99bbc77f32-10-telephone16-telephone1.fieldControl-InputMaskControl-description']");
	By contactsectionmenubtn = By.xpath("//button[@data-lp-id='SubGridStandard:contact-OverflowButton']");
	By contactsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	By contactnameinheader = By.xpath("//h1[@data-id='header_title']");
	By activecontactslabel = By.xpath("//h1[@aria-label='Active Contacts']");
	By createnewcontactbtn = By.xpath("//button[@aria-label='New']");
	By contactfirstnamelabel = By.xpath("//label[text()='First Name']");
	By contacttypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By contacttypeexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
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
	
	By selectexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div");
	By scrollrightongrid = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[4]/div[10]");
	By openexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div[10]/div[1]/button[1]");
	
	
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
	
public WebElement getContactSavenCloseBtn() {
		
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
	
	public WebElement getscrollrightongrid() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrollrightongrid));
		return driver.findElement(scrollrightongrid);
	}
	
	public WebElement getselectexistingcontact() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectexistingcontact));
		return driver.findElement(selectexistingcontact);
	}
	
	public WebElement getopenexistingcontact() {
		
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(openexistingcontact));
		return driver.findElement(openexistingcontact);
	}
	
	
}
