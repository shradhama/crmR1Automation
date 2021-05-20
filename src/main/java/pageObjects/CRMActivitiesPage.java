package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMActivitiesPage {
	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By myactivitieslabel = By.xpath("//span[contains(text(),'My Activities')]"); //Locator for My Activities header label
	By appointmentoptninheader = By.xpath("//button[@aria-label='Appointment']"); //Locator for Appointment option in header
	By newappointmentformtitle = By.xpath("//h1[contains(text(),'New Appointment')]"); //Locator for New Appointment form title
	By requiredfieldtxtbox = By.xpath("//input[@aria-label='Required, Multiple Selection Lookup']"); //Locator for Required field text box
	By requiredfieldlabel = By.xpath("//label[contains(text(),'Required')]"); //Locator for Required field label
	By selectrecordinrequiredfield = By.xpath("//ul[@aria-label='Lookup recently used results']/li[1]"); //Locator to select a record in Required text field
	By subjecttextbox = By.xpath("//input[@aria-label='Subject']"); //Locator for Subject text box
	By savenclosebtnonapptform = By.xpath("//button[@aria-label='Save & Close']"); //Locator for Save & Close btn on Appt form
	By activitytypeddbtn = By.xpath("//div[@id='activityTypeFilterBoxwrapper']/button"); //Locator for Activity Type Drop-down btn
	By selectapptactivity = By.xpath("//div[@id='activityTypeFilterBox-list']/div[2]"); //Locator for Appointment checkbox
	By activitytypelabel = 	By.xpath("//span[text()='Activity Type']"); //Locator for Activity Type Label
	By activitysearchfield = By.xpath("//input[@aria-label='Search this view']"); //Locator for Activity Search field
	By validateapptname = By.xpath("//div[@data-id='cell-0-3']"); //Locator to validate new appointment name in Search results
	By openrequiredfieldtext = By.xpath("//div[@data-id='requiredattendees.fieldControl-LookupResultsDropdown_requiredattendees_selected_tag_text']"); //Locator to open the Required field text
	//By taskoptninheader = By.xpath("//button[@aria-label='Task']"); //Locator for Task option in header
	By taskoptninheader = By.xpath("//li[@title='Task']"); //Locator for Task option in header
	By newtaskformtitle = By.xpath("//h1[contains(text(),'New Task')]"); //Locator for New Task form title
	By regardingtextbox = By.xpath("//input[@aria-label='Regarding, Lookup']"); //Locator for Regarding text box
	By regardingfieldlabel = By.xpath("//label[contains(text(),'Regarding')]"); //Locator for Regarding field label
	By selectrecordinregardingfield = By.xpath("//ul[@aria-label='Lookup recently used results']/li[2]"); //Locator to select a record in Regarding text field
	By selecttaskactivity = By.xpath("//div[@id='activityTypeFilterBox-list']/div[20]"); //Locator for Task checkbox
	By validatetaskname = By.xpath("//div[@data-id='cell-0-3']"); //Locator to validate new task name in Search results
	By openregardingfieldtext = By.xpath("//div[@data-id='regardingobjectid.fieldControl-LookupResultsDropdown_regardingobjectid_selected_tag_text']"); //Locator to open the Regarding field text
	By phonecalloptninheader = By.xpath("//button[@aria-label='Phone Call']"); //Locator for Phone Call option in header
	By newphonecallformtitle = By.xpath("//h1[contains(text(),'New Phone Call')]"); //Locator for New Phone Call form title
	By calltotextbox = By.xpath("//input[@aria-label='Call To, Multiple Selection Lookup']"); //Locator for Call To Text box
	By selectrecordincalltofield = By.xpath("//ul[@aria-label='Lookup recently used results']/li[1]"); //Locator to select a record in Call to text field
	By calltofieldlabel = By.xpath("//label[contains(text(),'Call To')]"); //Locator for Call To field label
	By selectphonecallactivity = By.xpath("//div[@id='activityTypeFilterBox-list']/div[14]"); //Locator for Phone Call checkbox
	By validatephonecallname = By.xpath("//div[@data-id='cell-0-3']"); //Locator to validate new phone call name in Search results
	By emailoptninheader = By.xpath("//button[@aria-label='Email']"); //Locator for Email option in header
	By newemailformtitle = By.xpath("//h1[contains(text(),'New Email')]"); //Locator for New Email form title
	By subjectfieldlabel = By.xpath("//label[contains(text(),'Subject')]"); //Locator for Subject field label
	By emailbody = By.xpath("//body[@class='cke_editable cke_editable_themed cke_contents_ltr']"); //Locator for Email body
	By selectemailactivity = By.xpath("//div[@id='activityTypeFilterBox-list']/div[9]"); //Locator for Email checkbox
	By validateemailname = By.xpath("//div[@data-id='cell-0-3']"); //Locator to validate new email name in Search results
	By fonttext = By.xpath("//span[contains(text(),'Font')]"); //Locator for Font text
	By regardingvalue = By.xpath("//div[@data-id = 'regardingobjectid.fieldControl-LookupResultsDropdown_regardingobjectid_selected_tag_text']"); //Locator for Regarding field value
	By duedatetxtbox = By.xpath("//input[@data-id='scheduledend.fieldControl-date-time-input']"); //Locator for Due Date text field
	By starttimedatepicker= By.xpath("//input[@data-id='scheduledstart.fieldControl-date-time-input']"); //Locator to select Start Time date picker
	
	public CRMActivitiesPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getMyActivitiesLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(myactivitieslabel));
		return driver.findElement(myactivitieslabel);
	}
	public WebElement getAppointmentOptnInHeader() {
		return driver.findElement(appointmentoptninheader);
	}
	public WebElement getNewAppointmentFormTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newappointmentformtitle));
		return driver.findElement(newappointmentformtitle);		
	}
	public WebElement getRequiredFieldTxtBox() {
		return driver.findElement(requiredfieldtxtbox);
	}
	public WebElement getRequiredFieldLabel() {
		return driver.findElement(requiredfieldlabel);
	}
	public WebElement selectRecordInRequiredfField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectrecordinrequiredfield));
		return driver.findElement(selectrecordinrequiredfield);		
	}
	public WebElement getSubjectTextBox() {
		return driver.findElement(subjecttextbox);
	}
	public WebElement getSavenCloseBtnOnApptForm() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(savenclosebtnonapptform);
	}
	public WebElement getActivityTypeDDBtn() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(activitytypeddbtn);
	}
	public WebElement selectApptActivity() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(selectapptactivity);
	}
	public WebElement getActivityTypeLabel() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(activitytypelabel);
	}
	public WebElement getActivitySearchField() {
		return driver.findElement(activitysearchfield);
	}
	public WebElement getValidateApptName() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(validateapptname);
	}
	public WebElement openRequiredFieldText() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(openrequiredfieldtext));
		return driver.findElement(openrequiredfieldtext);
	}
	public WebElement getTaskOptnInHeader() {
		return driver.findElement(taskoptninheader);
	}
	public WebElement getNewTaskFormTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newtaskformtitle));
		return driver.findElement(newtaskformtitle);		
	}
	public WebElement getRegardingFieldTxtBox() {
		return driver.findElement(regardingtextbox);
	}
	public WebElement getRegardingFieldLabel() {
		return driver.findElement(regardingfieldlabel);
	}
	public WebElement selectRecordInRegardingField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectrecordinregardingfield));
		return driver.findElement(selectrecordinregardingfield);		
	}
	public WebElement selectTaskActivity() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(selecttaskactivity);
	}
	public WebElement getValidateTaskName() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(validatetaskname);
	}
	public WebElement openRegardingFieldText() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(openregardingfieldtext);
	}
	public WebElement getPhoneCallOptnInHeader() {
		return driver.findElement(phonecalloptninheader);
	}
	public WebElement getNewPhoneCallFormTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newphonecallformtitle));
		return driver.findElement(newphonecallformtitle);		
	}
	public WebElement getCallToFieldTxtBox() {
		return driver.findElement(calltotextbox);
	}
	public WebElement selectRecordInCallToField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectrecordincalltofield));
		return driver.findElement(selectrecordincalltofield);		
	}
	public WebElement getCallToFieldLabel() {
		return driver.findElement(calltofieldlabel);
	}
	public WebElement selectPhoneCallActivity() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(selectphonecallactivity);
	}
	public WebElement getValidatePhoneCallName() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(validatephonecallname);
	}
	public WebElement getEmailOptnInHeader() {
		return driver.findElement(emailoptninheader);
	}
	public WebElement getNewEmailFormTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newemailformtitle));
		return driver.findElement(newemailformtitle);		
	}
	public WebElement getSubjectFieldLabel() {
		return driver.findElement(subjectfieldlabel);
	}
	public WebElement getEmailBody() {
		return driver.findElement(emailbody);
	}
	public WebElement selectEmailActivity() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(selectemailactivity);
	}
	public WebElement getValidateEmailName() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(validateemailname);
	}
	public WebElement getFontText() throws InterruptedException {
		Thread.sleep(4000);
		return driver.findElement(fonttext);
	}
	public WebElement getregardingvalue() {
		return driver.findElement(regardingvalue);
	}
	public WebElement getDueDateTextBox() {
		return driver.findElement(duedatetxtbox);
	}
	public WebElement selectStartTime() {
		wait = new WebDriverWait (driver,25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(starttimedatepicker));
		return driver.findElement(starttimedatepicker);		
	}
}
