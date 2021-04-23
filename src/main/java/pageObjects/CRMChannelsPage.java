package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMChannelsPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By channelstab = By.xpath("//span[contains(text(),'Channels')]"); //Locator to open Channels tab
	By activechannelslabel= By.xpath("//span[contains(text(),'Active Channels')]"); //Locator for Active Channels label
	By namecolmnlabel = By.xpath("//div[@data-id='xxc_name']"); //Locator for name Column label
	By campuscolmnlabel = By.xpath("//div[@data-id='xxc_campusid']"); //Locator for Campus column label
	By selectchannel = By.xpath("//div[@data-id = 'cell-1-2']"); //Locator to select Channel name
	By generaltablabel = By.xpath("//li[@aria-label='General']"); //Locator for General tab Label
	By contactchannelprofilelabel = By.xpath("//li[@aria-label='Contact Channel Profiles']"); //Locator for Contact Channel Profiles tab Label
	By relatedtablabel = By.xpath("//li[@aria-label='Related']"); //Locator for Related tab Label
	By readonlymsg= By.xpath("//script[@id='errorPopup-template']"); //Locator for Read-only message
	By disablefield= By.xpath("//span[@data-id='warningNotification']"); //Locator to verify disable field
	By nametxtfieldlabel = By.xpath("//label[contains(text(),'Name')]"); //Locator for Name text field label (General tab)
	By campustxtfieldlabel = By.xpath("//label[contains(text(),'Campus')]"); //Locator for Campus text field label (General tab)
	By ownertxtfieldlabel = By.xpath("//label[contains(text(),'Owner')]"); //Locator for Owner text field label (General tab)
	By marketfieldlabel = By.xpath("//h2[@title='Markets']"); //Locator for Market field label (General tab)
	By marketfieldnamelabel = By.xpath("//div[contains(text(),'Name')]"); //Locator for Market field- Name label (General tab)
	By marketfieldchannellabel = By.xpath("//div[@data-id='xxc_channelid']"); //Locator for Market field- Channel label (General tab)
	By contactfieldlabel = By.xpath("//div[@data-id='xxc_contactid']/div[1]/div[1]/div[1]/div[1]"); //Locator for Contact field label (Contact Channel Profiles tab)
	By channelfieldlabel = By.xpath("//div[@data-id='xxc_channelid']/div[1]/div[1]/div[1]/div[1]"); //Locator for Channel field label (Contact Channel Profiles tab)
	By ddprodcatfieldlabel = By.xpath("//div[@data-id='xxc_demanddriverproductcategoryid']/div[1]/div[1]/div[1]/div[1]"); //Locator for Demand Driver Product Category field label (Contact Channel Profiles tab)
	By relatedcommonlabel = By.xpath("//span[@aria-label='Related - Common']"); //Locator for Related-Common label (Related tab)
	By audiohistorylabel= By.xpath("//div[@id='navAudit']"); //Locator for Audio History label (Related tab)
	By contactchannelprofileslabel= By.xpath("//div[@id='nav_xxc_ContactChannelProfile_Channelid_xxc_c']"); //Locator for Contact Channel Profiles label (Related tab)
	By marketslabel= By.xpath("//div[@id='nav_xxc_xxc_channel_xxc_market_ChannelId']"); //Locator for Markets label (Related tab)
	By backbutton= By.xpath("//button[@aria-label='Press Enter to go back.']"); //Locator for Back Button
	By activechanneldropdown= By.xpath("//div[@aria-label='Active Channels']/h1[1]/div[1]/span[2]/span[1]"); //Locator for Active Channel dropdown
	By inactivechanneloption= By.xpath("//span[contains(text(),'Inactive Channels')]"); //Locator for Inactive Channel option
	By nodatamsg= By.xpath("//div[@title='No data available.']"); //Locator for No data available message from Inactive records
	
	By searchchannelfield= By.xpath("//input[@aria-label='Search this view']"); //Locator for search channel field 
	By startsearch= By.xpath("//div[@data-id='data-set-quickFind-container']/button[1]/span[1]"); //Locator for start search
	By channelsearchresult = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for channel name in search result
	By clearsearch= By.xpath("//button[@aria-label='Clear search']"); //Locator to clear search
	
	public CRMChannelsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getChannelsTab() {
		// web element for the Channels tab at left find side pane.
		return driver.findElement(channelstab);
	}
	
	public WebElement getActiveChannelsLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activechannelslabel));
		return driver.findElement(activechannelslabel);
	}
	
	public WebElement getNameColumnLabel() {
		return driver.findElement(namecolmnlabel);
	}
	
	public WebElement getCampusColumnLabel() {
		return driver.findElement(campuscolmnlabel);
	}
	
	public WebElement selectChannel() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(selectchannel);
	}
	
	public WebElement getGeneralTabLabel() {
		return driver.findElement(generaltablabel);
	}
	
	public WebElement getContactChannelProfileLabel() {
		return driver.findElement(contactchannelprofilelabel);
	}
	
	public WebElement getRelatedTabLabel() {
		return driver.findElement(relatedtablabel);
	}
	
	public WebElement getReadOnlyMsg() {
		return driver.findElement(readonlymsg);
	}
	
	public WebElement verifyDisableField() {
		return driver.findElement(disablefield);
	}
	
	public WebElement getNameTxtFieldLabel() {
		return driver.findElement(nametxtfieldlabel);
	}
	
	public WebElement getCampusTxtFieldLabel() {
		return driver.findElement(campustxtfieldlabel);
	}
	
	public WebElement getOwnerTxtFieldLabel() {
		return driver.findElement(ownertxtfieldlabel);
	}
	
	public WebElement getMarketFieldLabel() {
		return driver.findElement(marketfieldlabel);
	}
	
	public WebElement getMarketFieldNameLabel() {
		return driver.findElement(marketfieldnamelabel);
	}
	
	public WebElement getMarketFieldChannelLabel() {
		return driver.findElement(marketfieldchannellabel);
	}
	
	public WebElement getContactFieldLabel() {
		return driver.findElement(contactfieldlabel);
	}
	
	public WebElement getChannelFieldLabel() {
		return driver.findElement(channelfieldlabel);
	}
	
	public WebElement getDemardDriverProductCategoryFieldLabel() {
		return driver.findElement(ddprodcatfieldlabel);
	}
	
	public WebElement getRelatedCommonLabel() {
		return driver.findElement(relatedcommonlabel);
	}
	
	public WebElement getAudioHistoryLabel() {
		return driver.findElement(audiohistorylabel);
	}
	
	public WebElement getContactChannelProfilesLabel() {
		return driver.findElement(contactchannelprofileslabel);
	}
	
	public WebElement getMarketsLabel() {
		return driver.findElement(marketslabel);
	}
	
	public WebElement getBackButton() {
		return driver.findElement(backbutton);
	}
	
	public WebElement sletectActiveChannelDropdown() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(activechanneldropdown);
	}
	
	public WebElement selectInactiveChannelOption() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(inactivechanneloption);
	}
	
	public WebElement getNoDataMsg() {
		return driver.findElement(nodatamsg);
	}
	
	public WebElement getSearchChannelField() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(searchchannelfield);
	}
	
	public WebElement getStartSearch() {
		return driver.findElement(startsearch);
	}
	
	public WebElement getChannelSearchResult() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(channelsearchresult);
	}
	
	public WebElement getClearSearch() {
		return driver.findElement(clearsearch);
	}


}