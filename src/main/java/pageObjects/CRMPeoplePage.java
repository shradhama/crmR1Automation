package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMPeoplePage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By fullname = By.xpath("//div[@data-id = 'xxc_fullname']");//Locator to click Full Name column
	By eihmatchkey = By.xpath("//div[@data-id = 'xxc_eihmatchkey']");//Locator to click EIH Match Key column 
	By selectoperatoroption = By.xpath("//button[@data-index = '4']");//Locator for Begins With option
	By enterfullname = By.xpath("//input[@aria-label = 'Filter by value']");//Locator for enter full name text box
	By filterclick = By.xpath("//button[@aria-label = 'Filter by']");//Locator for filter by option
	By clickoperator = By.xpath("//div[@aria-label = 'Filter by operator']");//Locator for operator
	By clickapplybtn = By.xpath("//button[@type = 'submit']");//Locator for Apply button in filters
	By moreheaderfieldsbtn = By.xpath("//button[@data-id = 'header_overflowButton']"); //Locator for More Header field button
	By personfieldlabel = By.xpath("//label[contains(text(),'Person')]"); //Locator for Person field label
	By personnameinheader = By.xpath("//div[@data-id='header_xxc_personid.fieldControl-LookupResultsDropdown_xxc_personid_selected_tag_text']"); //Locator for Person name in header
	By personformtitle = By.xpath("//h1[@data-id='header_title']"); //Locator for Person form title
	By contactssectionlabelonpersonform = By.xpath("//h2[@title='Contacts']"); //Locator for Contacts section label on Person form
	By contactfullnameincontactssection = By.xpath("//div[@data-id='cell-0-2']"); //Locator for Contact's full name field in Contacts section on Person form
	By exporttoexcel = By.xpath("//button[@data-id = 'xxc_person|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.xxc_person.ExportToExcel.Menu$splitButtonId']");//Locator for Export to Excel options arrow
	By selectdynamicexportoptionschk1 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_personstatecode']");//Locator for Status checkbox
	By selectdynamicexportoptionschk2 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyxxc_personstatuscode']");//Locator for Status Reason checkbox
	By onlineexportverification = By.xpath("//div[@data-id = 'cell-0-3']");//Locator for Status for Export to Excel online
	By aletterfilterlink = By.xpath("//a[@id='A_link']"); //Locator for 'A' letter filter link for People
	By selectpersonname = By.xpath("//div[@data-id='cell-2-2']"); //Locator to select person name in Grid
	By fullnamecolmntextincontactssectn = By.xpath("//div[contains(text(),'Full Name')]"); //Locator for Full name column in Contact section on Person form
	By emailcolmntextincontactssectn = By.xpath("//div[contains(text(),'Email')]"); //Locator for Email column in Contact section on Person form
	By accountnamecolmntextincontactssectn = By.xpath("//div[contains(text(),'Account Name')]"); //Locator for Account name column in Contact section on Person form
	By businessphonecolmntextincontactssectn = By.xpath("//div[contains(text(),'Business Phone')]"); //Locator for Business Phone column in Contact section on Person form
	By statuscolmntextincontactssectn = By.xpath("//div[contains(text(),'Status')]"); //Locator for Status column in Contacts section on Person form
	By newcontactbtnincontactssectn = By.xpath("//button[@aria-label='New Contact']"); //Locator for 'New Contact'button in Contacts section on Person form
	By fullnamesortztoafilter = By.xpath("//span[contains(text(),'Sort Z to A')]"); //Locator for Z to A filter option of Full name
	
	public CRMPeoplePage(WebDriver driver) {

		this.driver = driver;
	}
	public WebElement getfullname() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(fullname));
		return driver.findElement(fullname);
	}
	public WebElement geteihmatchkey() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(eihmatchkey));
		return driver.findElement(eihmatchkey);
	}
	public WebElement getselectoperatoroption() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectoperatoroption));
		return driver.findElement(selectoperatoroption);
	}
	public WebElement getenterfullname() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(enterfullname));
		return driver.findElement(enterfullname);
	}
	public WebElement getfilterclick() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(filterclick));
		return driver.findElement(filterclick);
	}
	public WebElement getclickoperator() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickoperator));
		return driver.findElement(clickoperator);
	}
	public WebElement getclickapplybtn() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clickapplybtn));
		return driver.findElement(clickapplybtn);
	}
	public WebElement getMoreHeaderFieldsBtn() {

		return driver.findElement(moreheaderfieldsbtn);
	}

	public WebElement getPersonFieldLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personfieldlabel));
		return driver.findElement(personfieldlabel);
	}

	public WebElement getPersonNameInHeader() {

		return driver.findElement(personnameinheader);
	}

	public WebElement getPersonFormTitle() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(personformtitle);
	}

	public WebElement getContactsSectionLabelOnPersonForm() {

		return driver.findElement(contactssectionlabelonpersonform);
	}

	public WebElement getContactFullNameInContactsSection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactssectionlabelonpersonform));
		return driver.findElement(contactfullnameincontactssection);
	}
	public WebElement getexporttoexcel() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttoexcel));
		return driver.findElement(exporttoexcel);
	}
	public WebElement getselectdynamicexportoptionschk1() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectdynamicexportoptionschk1));
		return driver.findElement(selectdynamicexportoptionschk1);
	}
	public WebElement getselectdynamicexportoptionschk2() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectdynamicexportoptionschk2));
		return driver.findElement(selectdynamicexportoptionschk2);
	}
	public WebElement getonlineexportverification() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(onlineexportverification));
		return driver.findElement(onlineexportverification);
	}
	
	public WebElement getALetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(aletterfilterlink);
	}
	public WebElement selectPersonName() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(selectpersonname);
	}
	public WebElement getFullNameColmnTextInContactsSectn()
	{
		return driver.findElement(fullnamecolmntextincontactssectn);
	}
	public WebElement getEmailColmnTextInContactsSectn()
	{
		return driver.findElement(emailcolmntextincontactssectn);
	}
	public WebElement getAccountNameColmnTextInContactsSectn()
	{
		return driver.findElement(accountnamecolmntextincontactssectn);
	}
	public WebElement getBusinessPhoneColmnTextInContactsSectn()
	{
		return driver.findElement(businessphonecolmntextincontactssectn);
	}
	public WebElement getStatusColmnTextInContactsSectn()
	{
		return driver.findElement(statuscolmntextincontactssectn);
	}
	public WebElement getNewContactBtnInContactsSectn()
	{
		return driver.findElement(newcontactbtnincontactssectn);
	}
	public WebElement getFullNameSortZtoAFilter()
	{
		return driver.findElement(fullnamesortztoafilter);
	}
}

