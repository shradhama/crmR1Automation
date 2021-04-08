package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMIncentiveCategoriesPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By activeinccategorieslabel = By.xpath("//h1[@aria-label='Active Incentive Categories']"); //Locator for Active Incentive Categories Label
	By namecolmnlabel = By.xpath("//div[contains(text(),'Name')]"); //Locator for name column label
	By estimatedvaluecolmnlabel = By.xpath("//div[contains(text(),'Estimated Value')]"); //Locator for Estimated Value column label
	By selectinccategory = By.xpath("//div[@data-id = 'cell-3-2']"); //Locator to select Incentive Category name
	By generaltablabel = By.xpath("//li[@aria-label='General']"); //Locator for General Tab Label
	By relatedtablabel = By.xpath("//li[@aria-label='Related']"); //Locator for Related Tab Label
	By nametxtfieldlabel = By.xpath("//label[contains(text(),'Name')]"); //Locator for Name text field label
	By typeddlabel = By.xpath("//label[contains(text(),'Type')]"); //Locator for Type drop down field label
	By estimatedvaluetxtfieldlabel = By.xpath("//label[contains(text(),'Estimated Value')]"); //Locator for estimated value text field label
	By currencytxtfieldlabel = By.xpath("//label[contains(text(),'Currency')]"); //Locator for currency text field label
	By relatedaudithistoryitem = By.xpath("//div[@aria-label='Audit History Related - Common']"); //Locator for Audit History Related-Common item
	By relatedincdetailsitem = By.xpath("//div[@aria-label='Incentive Details Related - Common']"); //Locator for Incentive Details Related-Common item
	By inccatformheadertitle = By.xpath("//h1[@data-id='header_title']"); //Locator for Incentive Category form Header title
	By inccategoryowner = By.xpath("//a[@aria-label='Demand Driver Ownership Team']"); //Locator for Incentive Category Owner in header
	By moreheaderfieldsbtn = By.xpath("//button[@aria-label='More Header Fields']"); //Locator for More Header fields button
	By inccatownernameindd = By.xpath("//div[@data-id='header_ownerid.fieldControl-LookupResultsDropdown_ownerid_selected_tag_text']"); //Locator for Incentive Category Owner in drop down
	By activeinccatdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']"); //Locator for drop down button for Active incentive Categories
	By inactiveinccatoptn = By.xpath("//*[text()='Inactive Incentive Categories']"); //Locator for 'Inactive Incentive Categories' item
	By inactiveinccategorieslabel = By.xpath("//h1[@aria-label='Inactive Incentive Categories']"); //Locator for 'Inactive Incentive Categories' label
	By inccatnewbtn = By.xpath("//span[contains(text(),'New')]"); //Locator for New button to create new incentive category
	By inccatformheader = By.xpath("//h1[contains(text(),'New Incentive Category')]"); //Locator for 'New Incentive Category' page title
	By nametextbox = By.xpath("//input[@aria-label='Name']"); //Locator for Name Text field
	By typetextbox = By.xpath("//select[@aria-label='Type']"); //Locator for Type text field
	By typenamefmdd = By.xpath("//option[contains(text(),'Airfare')]"); //Locator for Type name
	By inccatsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']"); //Locator for Save n Close button on inc category form


	public CRMIncentiveCategoriesPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getActiveIncCategoriesLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeinccategorieslabel));
		return driver.findElement(activeinccategorieslabel);
	}

	public WebElement getNameColumnLabel() {

		return driver.findElement(namecolmnlabel);
	}

	public WebElement getEstimatedValueColmnLabel() {

		return driver.findElement(estimatedvaluecolmnlabel);
	}

	public WebElement selectIncCategory() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(selectinccategory);
	}

	public WebElement getGeneralTabLabel() {

		return driver.findElement(generaltablabel);
	}
	public WebElement getRelatedTabLabel() {

		return driver.findElement(relatedtablabel);
	}
	public WebElement getNameTxtFieldLabel() {

		return driver.findElement(nametxtfieldlabel);
	}
	public WebElement getTypefieldLabel() {

		return driver.findElement(typeddlabel);
	}
	public WebElement getEstimatedValueTxtFieldLabel() {

		return driver.findElement(estimatedvaluetxtfieldlabel);
	}
	public WebElement getCurrencyTxtFieldLabel() {

		return driver.findElement(currencytxtfieldlabel);
	}
	public WebElement getRelatedAuditHistoryItem() {

		return driver.findElement(relatedaudithistoryitem);
	}
	public WebElement getRelatedIncDetailsItem() {

		return driver.findElement(relatedincdetailsitem);
	}
	public WebElement getIncCatFormHeaderTitle() throws InterruptedException {

		Thread.sleep(6000);
		return driver.findElement(inccatformheadertitle);
	}
	public WebElement getIncCategoryOwner() {

		return driver.findElement(inccategoryowner);
	}
	public WebElement getMoreHeaderFieldsBtn() {

		return driver.findElement(moreheaderfieldsbtn);
	}
	public WebElement getIncCatOwnerNameIndd() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inccatownernameindd));
		return driver.findElement(inccatownernameindd);
	}
	public WebElement getActiveIncCatDropDownBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeinccatdropdownbtn));
		return driver.findElement(activeinccatdropdownbtn);
	}
	public WebElement getInactiveIncCatOptn() {
		return driver.findElement(inactiveinccatoptn);
	}
	public WebElement getInactiveIncCatLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactiveinccategorieslabel));
		return driver.findElement(inactiveinccategorieslabel);
	}
	public WebElement getIncCategoryNewbtn() throws InterruptedException
	{
		Thread.sleep(7000);
		return driver.findElement(inccatnewbtn);
	}
	public WebElement getIncCatFormHeader() throws InterruptedException
	{
		Thread.sleep(7000);
		return driver.findElement(inccatformheader);
	}
	public WebElement getNameTextBox()
	{
		return driver.findElement(nametextbox);
	}
	public WebElement getTypeTextBox()
	{
		return driver.findElement(typetextbox);
	}
	public WebElement getTypeNameFmdd()
	{
		return driver.findElement(typenamefmdd);
	}
	public WebElement getIncCatSavenCloseBtn()
	{
		return driver.findElement(inccatsavenclosebtn);
	}
}