package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//this page created for to create web elements from Published App Page. 
public class CRMAdvanceFindPage {

	public WebDriver driver;

	// defined demand driver management webelement
	By advancefilterbutton = By.id("advancedFindLauncher-button"); // Locator for advance filter button
	By lookfordropdown= By.id("slctPrimaryEntity"); //Locator for Look For dropdown
    By contactchannelprofileopt= By.xpath("//option[contains(text(),'Contact Channel Profiles')]"); //Locator to select Contact CHannel Profile option
    By clickbleoptionbtn=By.xpath("//div[@title='Select']/div/span");  //Locator to click on Select Clickable option
    By junuipersourceopt= By.xpath("//option[@value='xxc_junipersource']"); //Locator to select Juniper Source option
    By multipicklistbtn= By.xpath("//div[@id='advFindEFGRP0FFLD0CCVALLBL']"); // Locator to select Multi Pick List button
    By multipicklistbtn1= By.xpath("//button[@title='Select or change the values for this field']"); // Locator of th button to select the values
    By junipersourceregistrationvalue= By.xpath("//div[@id='objList']/table/tbody/tr[8]"); //Locator for Juniper Source Registration Value		
    By moverightbtn = By.xpath("//button[@aria-label='Move Right']");// Locator for Move to right button	
    By okbtntosave= By.xpath("//button[@title='OK']"); //Locator to select OK button
    By resultbtn= By.xpath("//div[@id='ribbonContainer0']/div/div[2]/ul/li/span/span/span/span/span/a[3]"); //Locator for Result Button
    By selectcontactfrmtable= By.xpath("//table[@id='gridBodyTable' and @class='ms-crm-List-Data']/tbody/tr[5]/td[2]"); //Locator to select COntact from table
    
	public CRMAdvanceFindPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getAdvanceFilterBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(advancefilterbutton));
		return driver.findElement(advancefilterbutton);
	}
	
	public WebElement selectLookForDropDown() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(lookfordropdown));
		return driver.findElement(lookfordropdown);
	}
	
	public WebElement selectContactChannelProfile() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactchannelprofileopt));
		return driver.findElement(contactchannelprofileopt);
	}
	
	public WebElement getSelectClickbleOption() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickbleoptionbtn));
		return driver.findElement(clickbleoptionbtn);
	}
	
	public WebElement getJuniperSourceOption() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(junuipersourceopt));
		return driver.findElement(junuipersourceopt);
	}
	
	public WebElement selectMultiPickListButton() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(multipicklistbtn));
		return driver.findElement(multipicklistbtn);
	}
	
	public WebElement selectMultiPickListButton1() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(multipicklistbtn1));
		return driver.findElement(multipicklistbtn1);
	}
	
	public WebElement selectJuniperSourceRegistrationValue() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(junipersourceregistrationvalue));
		return driver.findElement(junipersourceregistrationvalue);
	}
	
	public WebElement selectMoveRightBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(moverightbtn));
		return driver.findElement(moverightbtn);
	}
	
	public WebElement selectOKBtntoSelectValue() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(okbtntosave));
		return driver.findElement(okbtntosave);
	}
	
	public WebElement selectResultsBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(resultbtn));
		return driver.findElement(resultbtn);
	}
	
	public WebElement selectContactFromTable() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectcontactfrmtable));
		return driver.findElement(selectcontactfrmtable);
	}
}
