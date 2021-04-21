package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMReferenceDataPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By activecampuseslabel = By.xpath("//span[contains(text(),'Active Campuses')]"); //Locator for Active Campuses label
	By atlantacampuscell = By.xpath("//div[@data-id='cell-0-2']"); //Locator for Atlanta Campus cell
	By digitalcampuscell = By.xpath("//div[@data-id='cell-1-2']"); //Locator for Digital Campus cell
	By highpointcampuscell = By.xpath("//div[@data-id='cell-2-2']"); //Locator for High Point Campus cell
	By lasvegascampuscell = By.xpath("//div[@data-id='cell-2-2']"); //Locator for Las Vegas Campus cell
	By campuspageheadertitle = By.xpath("//h1[@data-id='header_title']"); //Locator for Campus page header title
	By readonlytxtoncampuspage = By.xpath("//span[@data-id='warningNotification']"); //Locator for Read Only Text on Campus page
	By nametextbox = By.xpath("//input[@aria-label='Name']"); //Locator for Name text box
	By nodataavailtxt = By.xpath("//span[contains(text(),'No data available.')]"); //Locator for No Data Available text
	By listssectnnamecolmn = By.xpath("//span[contains(text(),'Name')]"); //Locator for Name column of Lists section
	By listssectntypecolmn = By.xpath("//span[contains(text(),'Type')]"); //Locator for Type column of Lists section
	By listssectnbuyergroupcolmn = By.xpath("//span[contains(text(),'Buyer Group')]"); //Locator for Buyer Group column of Lists section
	By listssectnexpirationdatecolmn = By.xpath("//span[contains(text(),'Expiration Date')]"); //Locator for Expiration Date column of Lists section
	By listssectnrefreshbtn = By.xpath("//button[@data-id='xxc_list|NoRelationship|SubGridStandard|Mscrm.SubGrid.xxc_list.RefreshButton']"); //Locator for Refresh btn of Lists section
	By listsscetnaddexistinglistbtn = By.xpath("//button[@aria-label='Add Existing List']"); //Locator for Add Existing list btn for Lists section
	By morecmndsforlistsbtn = By.xpath("//button[@aria-label='More commands for List']"); //Locator for More Commands lists btn
	By relatedtab = By.xpath("//li[@aria-label='Related']"); //Locator for Related tab
	By audithistoryoptn = By.xpath("//div[@aria-label='Audit History Related - Common']"); //Locator for Audit History optn
	By channelsoptn = By.xpath("//div[@aria-label='Channels Related - Common']"); //Locator for Channels optn
	By accountcampusprofileoptn = By.xpath("//div[@aria-label='Account Campus Profiles Related - Common']"); //Locator for Account Campus Profile optn
	By ownername = By.xpath("//a[@aria-label='imcenters']"); //Locator for IMCCenters owner
	By moreheaderfieldsbtn = By.xpath("//button[@aria-label='More Header Fields']"); //Locator for More Header fields btn
	By ownerinheader = By.xpath("//div[@data-id='header_ownerid.fieldControl-LookupResultsDropdown_ownerid_selected_tag_text']"); //Locator for Owner in Header
	By activecampusesddbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']"); //Locator for Active Campuses dropdown btn
	By inactivecampusesoptn = By.xpath("//span[contains(text(),'Inactive Campuses')]"); //Locator for Inactive Campuses optn
	By inactivecampuseslabel = By.xpath("//span[contains(text(),'Inactive Campuses')]"); //Locator for Inactive Campuses label
	By nodataavailmsg = By.xpath("//span[contains(text(),'No data available.')]"); //Locator for No Data Available msg

	public CRMReferenceDataPage(WebDriver driver) {
		this.driver = driver;
	}
	public WebElement getActiveCampusesLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activecampuseslabel));
		return driver.findElement(activecampuseslabel);	
	}
	public WebElement getAtlantaCampusCell() {
		return driver.findElement(atlantacampuscell);		
	}
	public WebElement getDigitalCampusCell() {
		return driver.findElement(digitalcampuscell);		
	}
	public WebElement getHighPointCampusCell() {
		return driver.findElement(highpointcampuscell);		
	}
	public WebElement getLasVegasCampusCell() {
		return driver.findElement(lasvegascampuscell);		
	}
	public WebElement getCampusPageHeaderTitle() throws InterruptedException {
		Thread.sleep(7000);
		return driver.findElement(campuspageheadertitle);		
	}
	public WebElement getReadOnlyTxtOnCampusPage() {
		return driver.findElement(readonlytxtoncampuspage);		
	}
	public WebElement getNameTextBox() {
		return driver.findElement(nametextbox);		
	}
	public List<WebElement> getNoDataAvailTxt() {
		return driver.findElements(nodataavailtxt);		
	}
	public WebElement getListsSectnNameColmn() {
		return driver.findElement(listssectnnamecolmn);		
	}
	public WebElement getListsSectnTypeColmn() {
		return driver.findElement(listssectntypecolmn);		
	}
	public WebElement getListsSectnBuyerGroupColmn() {
		return driver.findElement(listssectnbuyergroupcolmn);		
	}
	public WebElement getListsSectnExpirationDateColmn() {
		return driver.findElement(listssectnexpirationdatecolmn);		
	}
	public WebElement getListsSectnRefreshBtn() {
		return driver.findElement(listssectnrefreshbtn);		
	}
	public WebElement getListsSectnExistingListsBtn() {
		return driver.findElement(listsscetnaddexistinglistbtn);		
	}
	public WebElement getMoreCmndsForListsBtn() {
		return driver.findElement(morecmndsforlistsbtn);		
	}
	public WebElement getRelatedTab() {
		return driver.findElement(relatedtab);		
	}
	public WebElement getAuditHistoryOptn() {
		return driver.findElement(audithistoryoptn);		
	}
	public WebElement getChannelsOptn() {
		return driver.findElement(channelsoptn);		
	}
	public WebElement getAccountCampusProfileOptn() {
		return driver.findElement(accountcampusprofileoptn);		
	}
	public WebElement getOwnerName() {
		return driver.findElement(ownername);		
	}
	public WebElement getMoreHeaderFieldsBtn() {
		return driver.findElement(moreheaderfieldsbtn);		
	}
	public WebElement getOwnerInHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ownerinheader));
		return driver.findElement(ownerinheader);	
	}
	public WebElement getActiveCampusesDDBtn() {
		return driver.findElement(activecampusesddbtn);		
	}
	public WebElement getInactiveCampusesOptn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactivecampusesoptn));
		return driver.findElement(inactivecampusesoptn);	
	}
	public WebElement getInactiveCampusesLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactivecampuseslabel));
		return driver.findElement(inactivecampuseslabel);	
	}
	public WebElement getNoDataAvailMsg() {
		return driver.findElement(nodataavailmsg);		
	}

}

