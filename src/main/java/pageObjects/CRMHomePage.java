package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMHomePage {

	// this page is created for all the web elements available on CRM home page.
	public WebDriver driver;
	public WebDriverWait wait;
	
	By hometitle = By.xpath("//span[contains(text(),'Home')]");
	By searchaccount = By.xpath("//input[@aria-label='Search this view']");
	By startsearch = By.xpath("//button[@aria-label='Start search']");
	By accountTab = By.xpath("//span[contains(text(),'Accounts')]");
	By clearsearch = By.xpath("//button[@title='Clear search']");
	By searchresultaccname = By.xpath("//div[@data-id = 'cell-0-2']");
	By activeaccountstitle = By.xpath("//div[@aria-label='Active Accounts']/h1[1]");
	By contacttab = By.xpath("//span[contains(text(),'Contacts')]");
	By activecontactstitle = By.xpath("//span[contains(text(),'Active Contacts')]");
	By searchresultcontactbusinessphone = By.xpath("//div[@data-id = 'cell-0-4']");
	//By inactiveaccountstitle = By.xpath("//h1[@aria-label='Inactive Accounts']");
	By inactiveaccountstitle= By.xpath("//span[contains(text(),'Inactive Account')]");
	By searchresultcontactfullname = By.xpath("//div[@data-id = 'cell-0-2']");
	By inactivecontactstitle = By.xpath("//span[contains(text(),'Inactive Contacts')]");
	By searchresultcontactemail = By.xpath("//div[@data-id = 'cell-0-4']");
	By peopletab = By.xpath("//span[contains(text(),'People')]");//Locator to open People tab
	By incentivestab = By.xpath("//span[contains(text(),'Incentives')]");//Locator to open Incentives tab
	By inactiveincentivestitle = By.xpath("//span[contains(text(),'Inactive Incentives')]"); //Locator for Inactive Incentives title
	By activeincentivestitle = By.xpath("//span[contains(text(),'Active Incentives')]"); //Locator for Active Incentives title
	By incentivedetailstab = By.xpath("//span[contains(text(),'Incentive Details')]");//Locator for incentive details
	By liststab= By.xpath("//span[contains(text(),'Lists')]"); //Locator for Lists tab
	By incentivecategoriestab = By.xpath("//span[contains(text(),'Incentive Categories')]");//Locator to open Incentive Categories tab
	By transactionalsectnlabel = By.xpath("//li[@aria-label='Transactional']"); //Locator for Transactional section label on left menu
	By activeinccategorieslabel = By.xpath("//h1[@aria-label='Active Incentive Categories']"); //Locator for Active Incentive Categories Label
	By searchresultinccatname = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for incentive category name in search result
	By listmemberstab= By.xpath("//span[contains(text(),'List Members')]"); //Locator for List Members tab
	By dashboardstab= By.xpath("//span[contains(text(),'Dashboards')]"); //Locator for Dashboards tab
	By activitiestab= By.xpath("//span[contains(text(),'Activities')]"); //Locator for Activities tab
	By campusestab = By.xpath("//span[contains(text(),'Campuses')]"); //Locator for Campuses tab
	By campusinsearchresult = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for Campus name in search result
	By ddproductcatgtab = By.xpath("//span[contains(text(),'Demand Driver Product Categories')]"); //Locator for Demand Driver Product Categories tab
	By ddprodcatginsearchresult = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for DD Product Catg name in search result
	By phonecallmarketoutcometab = By.xpath("//span[contains(text(),'Phone Call Market Outcomes')]"); //Locator for Phone Call Market Outcomes tab
	By registrationstab = By.xpath("//span[contains(text(),'Registrations')]"); //Locator for Registrations tab
	By marketstab = By.xpath("//span[contains(text(),'Markets')]"); //Locator for Markets tab
	By marketsinsearchresult = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for Market name in search result
	By regionstab = By.xpath("//span[contains(text(),'Regions')]");//Locator for Regions tab
	
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
	By startsearchbutton= By.xpath("//div[@data-id='data-set-quickFind-container']/button[1]/span[1]"); //Locator for start search
	By channelsearchresult = By.xpath("//div[@data-id = 'cell-0-2']"); //Locator for channel name in search result
	By campaignstab = By.xpath("//span[contains(text(),'Campaigns')]"); //Locator for Campaigns tab
	
	public CRMHomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement getHometitle () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hometitle));
		return driver.findElement(hometitle);	
		
	}
	public WebElement getSearchAccountField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeaccountstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getstartsearch() {
		//web element for the click on search icon
		return driver.findElement(startsearch);		
	}
	
	public WebElement getAccountTab() throws InterruptedException {
		// web element for the Account tab at left find side pane.
		Thread.sleep(5000);
		return driver.findElement(accountTab);
	}
	
	public WebElement getClearSearch() {
		return driver.findElement(clearsearch);
	}
	
	public WebElement getSearchResultAcc() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultaccname);
	}
	
	public WebElement getActiveAccountsTitle() {
		return driver.findElement(activeaccountstitle);
	}
	public WebElement getContactsTab() {
		// web element for the Account tab at left find side pane.
		return driver.findElement(contacttab);
	}
	
	public WebElement getActiveContactsTitle() {
		return driver.findElement(activecontactstitle);
	}
	
	public WebElement getSearchContactField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activecontactstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getSearchResultContactBusinessPhone() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultcontactbusinessphone);
	}
	
	public WebElement getSearchInactiveAccountField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactiveaccountstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getSearchResultContactFullName() throws InterruptedException {
		Thread.sleep(8000);
		return driver.findElement(searchresultcontactfullname);	
	}
	
	public WebElement getSearchInactiveContactField() {
		//web element for the search account field
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactivecontactstitle));
		return driver.findElement(searchaccount);	
	}
	
	public WebElement getSearchResultContactEmail() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultcontactemail);	
	}
	public WebElement getPeopleTab() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(peopletab));
		return driver.findElement(peopletab);
	}
	public WebElement getincentivestab() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(incentivestab));
		return driver.findElement(incentivestab);
	}
	public WebElement getSearchInactiveIncField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(inactiveincentivestitle));
		return driver.findElement(searchaccount);	
	}
	public WebElement getSearchActiveIncField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeincentivestitle));
		return driver.findElement(searchaccount);	
	}
	public WebElement getincentivedetailstab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incentivedetailstab));
		return driver.findElement(incentivedetailstab);	
	}
	public WebElement getliststab() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(liststab));
		return driver.findElement(liststab);
	}
	public WebElement getIncCategoriesTab() {
		// web element for the Incentive Categories tab at left find side pane.
		return driver.findElement(incentivecategoriestab);
	}
	public WebElement getTransactionalSectnLabel() {
		
		return driver.findElement(transactionalsectnlabel);
	}
	public WebElement getSearchIncCategoriesField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeinccategorieslabel));
		return driver.findElement(searchaccount);	
	}
	public WebElement getActiveIncCategoriesLabel() {
		return driver.findElement(activeinccategorieslabel);
	}
	public WebElement getSearchResultIncCatName() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(searchresultinccatname);
	}
	public WebElement getlistmemberstab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmemberstab));
		return driver.findElement(listmemberstab);	
	}
	public WebElement getdashboardstab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardstab));
		return driver.findElement(dashboardstab);	
	}
	
	public WebElement getActivitiesTab() {
		
		return driver.findElement(activitiestab);
	}
	
	public WebElement getCampusesTab() {
		return driver.findElement(campusestab);
	}
	public WebElement getSearchCampusField() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(searchaccount);	
	}
	public WebElement getCampusInSearchResult() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(campusinsearchresult);
	}
	public WebElement getDDProductCatgTab() {
		return driver.findElement(ddproductcatgtab);
	}
	public WebElement getSearchDDProdCatgField() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(searchaccount);	
	}
	public WebElement getDDProdCatgInSearchResult() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(ddprodcatginsearchresult);
	}
	public WebElement getPhoneCallMarketOutcomeTab() {
		return driver.findElement(phonecallmarketoutcometab);
	}
	public WebElement getregistrationstab() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(registrationstab);
	}
	public WebElement getMarketsTab() {
		return driver.findElement(marketstab);
	}
	public WebElement getSearchMarketField() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(searchaccount);	
	}
	public WebElement getMarketsInSearchResult() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(marketsinsearchresult);
	}
	public WebElement getregionstab() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(regionstab);
	}
	public WebElement getstartsearchbutton() {
		//web element for the click on search icon
		return driver.findElement(startsearchbutton);		
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
	
	public WebElement getChannelSearchResult() throws InterruptedException {
		Thread.sleep(3000);
		return driver.findElement(channelsearchresult);
	}
	
	public WebElement getCampaignsTab() {
		// web element for the Campaigns tab at left find side pane
		return driver.findElement(campaignstab);
	}
	
}