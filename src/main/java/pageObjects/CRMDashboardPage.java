package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMDashboardPage {

	//  this page is created for to define all the webelements located on CRM Dashboard page to till Published App page. 

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By dashboard=By.xpath("//span[contains(text(), 'Dashboards')]"); //Locator to open Dashboard menu
	By dashboardexpandbutton= By.xpath("//div[@role='presentation']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h1[1]/div[1]/span[2]"); //Locator for dashboard expansion button
	By retailrelationsmanagerdashboard= By.xpath("//span[contains(text(),'Retail Relations Manager Dashboard')]"); //Locator to select Retail Relations Manager Dashboard option
	By completedcallslastweekmorecommands= By.xpath("//li[@id='OverflowButton_button70:Component2669287:phonecall_29fa94fa-93ef-e911-a983-000d3a37870e:Component2669287']"); //Locator to select Completed calls last week_More Commands
	By registrationsmorecommands= By.xpath("//li[@id='OverflowButton_button70:Component8697706:xxc_registration_29fa94fa-93ef-e911-a983-000d3a37870e:Component8697706']"); //Locator to select Registrations(3 months prior-3months next)_More Commands
	By completedcallslastweeklabel= By.xpath("//span[@aria-label='Completed Calls Last Week']"); //Locator for Completed Calls Last Week label
	By registrationslabel= By.xpath("//span[@aria-label='Registrations (3 Month Prior - Next 3 Months)']"); //Locator for Registrations(3 months prior-3months next) label
	By declinecallslabel= By.xpath("//span[@aria-label='Declined Calls']"); //Locator for Declined Calls label
	By incentivedetailscreatedlastweeklabel= By.xpath("//span[@aria-label='Incentive Details Created Last Week']"); //Locator for Incentive Details Created Last Week label
	By activeincentivedetails= By.xpath("//span[@aria-label='Active Incentive Details']");  //Locator for Active Incentive Details label
	By hotelincentives= By.xpath("//span[@aria-label='Hotels Incentives (Booked)']");  //Locator for Hotel Incentive label
	By retailrealtionmanagerdashboardlabel = By.xpath("//span[contains(text(), 'Retail Relations Manager Dashboard')]"); //Locator for Retail Relations Manager Dashboard label
			
	//Locators for X-Y axis labels
	By completedcallsXaxislabel= By.xpath("//span[contains(text(),'Count:All (Subject)')]"); //Locator for Completed calls last week_X axis label
	By completedcallsYaxislabel= By.xpath("//div[@class='customControl MscrmControls Chart.ChartControl MscrmControls.Chart.ChartControl general-container']/div[3]/div[2]/div[1]/span[1]"); //Locator for Completed calls last week_Y axis label 
	By registrationsXaxislabel= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-040ee5b8-a823-4071-9318-a21f87f6928b_0_1_1']/div[1]/div[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[2]/span[1]"); //Locator for Registrations(3 months prior-3months next)_X axis label 
	By registrationsYaxislabel= By.xpath("//span[contains(text(),'Count:All (Registration)')]"); //Locator for Registrations(3 months prior-3months next)_Y axis label 
	By declinecallsXaxislabel= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component428227']/div[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[2]/span[1]"); //Locator for Declined Calls_X axis label 
	By declinecallsYaxislabel= By.xpath("//span[contains(text(),'Count:All (Call Outcome)')]"); //Locator for Declined calls_Y axis label
	By incentivedetailsXaxislabel= By.xpath("//div[@data-id='Component1970579_container']/div[3]/div[2]/div[2]/span[1]"); //Locator for Incentive Details Created Last Week_X axis label
	By incentivedetailsYaxislabel= By.xpath("//span[contains(text(),'Count:All (Owner)')]"); //Locator for Incentive Details Created Last Week_Y axis label
	By activeincentivedetailsXaxislabel= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component5453290']/div[1]/div[2]/div[1]/div[3]/div[3]/div[2]/div[1]/span[1]"); //Locator for Active Incentive Details_X axis label
	By activeincentivedetailsYaxislabel= By.xpath("//span[contains(text(),'Sum (Estimated Value) ($)')]"); //Locator for Active Incentive Details_X axis label
	By hotelincentiveaccount= By.xpath("//div[contains(text(),'Account')]"); //Locator to locate Hotel Incentive-Account column
	By hotelincentivecount= By.xpath("//div[contains(text(),'Contact')]"); //Locator to locate Hotel Incentive-Contact column
	By hotelincentivemarket= By.xpath("//div[contains(text(),'Market')]"); //Locator to locate Hotel Incentive-Market column
	By nodataavailtext = By.xpath("//span[contains(text(),'No data available.')]"); //Locator for No Data Available text
	By phonecallsownerlabel = By.xpath("//span[contains(text(),'Owner')]"); //Locator for Owner label of Phone calls section
	By incbyownerbycatglabel = By.xpath("//h2[contains(text(),'Incentives by Owner by Category')]"); //Locator for Incentives by Owner by Category label of Incentive details section
			
	//Locators for X-Y axis values
	By completedcallsXaxisvalue= By.xpath("//div[@aria-label='bar chart for PHONE CALLS BY OWNER, Completed Calls Last Week has 1 bars']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]");//Locator for Completed calls last week_X axis value
	By completedcallsYaxisvalue= By.xpath("//div[@aria-label='bar chart for PHONE CALLS BY OWNER, Completed Calls Last Week has 1 bars']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Completed calls last week_Y axis value
	By registrationsXaxisvalue= By.xpath("//div[@aria-label='column chart for REGISTRATION BY OWNER AND MARKET, Registrations (3 Month Prior - Next 3 Months) has 21 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]");//Locator for Registrations(3 months prior-3months next)_X axis value
	By registrationsYaxisvalue= By.xpath("//div[@aria-label='column chart for REGISTRATION BY OWNER AND MARKET, Registrations (3 Month Prior - Next 3 Months) has 21 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]");//Locator for Registrations(3 months prior-3months next)_Y axis value
	By declinecallsXaxisvalue= By.xpath("//div[@aria-label='column chart for OUTCOME BY DECLINED REASON & MARKET, Declined Calls has 770 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Declined Calls_X axis value
	By declinecallsYaxisvalue= By.xpath("//div[@aria-label='column chart for OUTCOME BY DECLINED REASON & MARKET, Declined Calls has 770 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][30]"); //Locator for Declined Calls_Y axis value
	By incentivedetailsXaxisvalue= By.xpath("//div[@aria-label='column chart for INCENTIVES BY OWNER BY CATEGORY, Active Incentive Details has 600 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][31]"); //Locator for Incentive Details Created Last Week_X axis value
	By incentivedetailsYaxisvalue= By.xpath("//div[@aria-label='column chart for INCENTIVES BY OWNER BY CATEGORY, Active Incentive Details has 600 columns']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][32]"); //Locator for Incentive Details Created Last Week_Y axis value
	By activeincentivedetailsXaxisvalue= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component5453290']/div/div[2]/div/div[3]/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Active Incentive Details_X axis value
	By activeincentivedetailsYaxisvalue= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component5453290']/div/div[2]/div/div[3]/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]"); //Locator for Active Incentive Details_Y axis value
	By incentivedetailsnodataavailablemsg= By.xpath("//div[@data-id='Component1970579_container']/div[3]/div[1]/span[2]"); //Locator for No data available message for Incentive Details Created Last Week

	public CRMDashboardPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getDashboard () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
		return driver.findElement(dashboard);				
	}

	public WebElement selectdashboardExpandButton () {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardexpandbutton));
		return driver.findElement(dashboardexpandbutton);	
	}

	public WebElement selectRetailRelationsManagerDashboard () {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(retailrelationsmanagerdashboard));
		return driver.findElement(retailrelationsmanagerdashboard);				
	}

	public WebElement getCompletedCallsLastWeekMoreCommands() {
		//web element for the signin button
		return driver.findElement(completedcallslastweekmorecommands);
	}

	public WebElement getRegistrationsMoreCommands() {
		//web element for the signin button
		return driver.findElement(registrationsmorecommands);
	}

	public WebElement selectCompletedCallsLastWeekLabel () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(completedcallslastweeklabel));
		return driver.findElement(completedcallslastweeklabel);	
	}

	public WebElement selectRegistrationsLabel () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(registrationslabel));
		return driver.findElement(registrationslabel);		
	}

	public WebElement selectDeclineCallsLabel () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(declinecallslabel));
		return driver.findElement(declinecallslabel);	
	}

	public WebElement selectIncentiveDetailsCcreatedLastWeekLabel () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(incentivedetailscreatedlastweeklabel));
		return driver.findElement(incentivedetailscreatedlastweeklabel);		
	}

	public WebElement selectActiveIncentiveDetails () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeincentivedetails));
		return driver.findElement(activeincentivedetails);		
	}

	public WebElement selectHotelincentives () {
		// webelement for home title on CRM home page. 
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(hotelincentives));
		return driver.findElement(hotelincentives);	
	}

	public WebElement getCompletedCallsXaxisLabel () {
		return driver.findElement(completedcallsXaxislabel);	
	}

	public WebElement getCompletedCallsYaxisLabel () {
		return driver.findElement(completedcallsYaxislabel);	
	}

	public WebElement getRegistrationsXaxisLabel () {
		return driver.findElement(registrationsXaxislabel);	
	}

	public WebElement getRegistrationsYaxisLabel () {
		return driver.findElement(registrationsYaxislabel);	
	}

	public WebElement getDeclineCallsXaxisLabel () {
		return driver.findElement(declinecallsXaxislabel);	
	}

	public WebElement getDeclineCallsYaxisLabel () {
		return driver.findElement(declinecallsYaxislabel);	
	}

	public WebElement getIncentiveDetailsXaxislabel () {
		return driver.findElement(incentivedetailsXaxislabel);	
	}

	public WebElement getIncentiveDetailsYaxislabel () {
		return driver.findElement(incentivedetailsYaxislabel);	
	}

	public WebElement getActiveIncentiveDetailsXaxisLabel () {
		return driver.findElement(activeincentivedetailsXaxislabel);	
	}

	public WebElement getActiveIncentiveDetailsYaxisLabel () {
		return driver.findElement(activeincentivedetailsYaxislabel);	
	}

	public WebElement getHotelIncentiveAccount () {
		return driver.findElement(hotelincentiveaccount);	
	}

	public WebElement getHotelIncentiveCount() {
		return driver.findElement(hotelincentivecount);	
	}

	public WebElement getHotelIncentiveMarket() {
		return driver.findElement(hotelincentivemarket);	
	}

	public WebElement getCompletedCallsXaxisValue () {
		return driver.findElement(completedcallsXaxisvalue);	
	}

	public WebElement getCompletedCallsYaxisValue () {
		return driver.findElement(completedcallsYaxisvalue);	
	}

	public WebElement getRegistrationsXaxisValue () {
		return driver.findElement(registrationsXaxisvalue);	
	}

	public WebElement getRegistrationsYaxisValue () {
		return driver.findElement(registrationsYaxisvalue);	
	}

	public WebElement getDeclineCallsXaxisValue () {
		return driver.findElement(declinecallsXaxisvalue);	
	}

	public WebElement getDeclineCallsYaxisValue () {
		return driver.findElement(declinecallsYaxisvalue);	
	}

	public WebElement getIncentiveDetailsXaxisValue () {
		return driver.findElement(incentivedetailsXaxisvalue);	
	}

	public WebElement getIncentiveDetailsYaxisValue () {
		return driver.findElement(incentivedetailsYaxisvalue);	
	}

	public WebElement getActiveIncentiveDetailsXaxisValue () {
		return driver.findElement(activeincentivedetailsXaxisvalue);	
	}

	public WebElement getActiveIncentiveDetailsYaxisValue () {
		return driver.findElement(activeincentivedetailsYaxisvalue);	
	}

	public WebElement getIncentiveDetailsNoDataAvailableMsg () {
		return driver.findElement(incentivedetailsnodataavailablemsg);	
	}
	public WebElement getRetailRealtionManagerDashboardLabel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(retailrealtionmanagerdashboardlabel));
		return driver.findElement(retailrealtionmanagerdashboardlabel);	
	}
	public List<WebElement> getNoDataAvailText() {
		return driver.findElements(nodataavailtext);	
	}
	public WebElement getPhoneCallsOwnerLabel() {
		return driver.findElement(phonecallsownerlabel);	
	}
	public WebElement getIncByOwnerByCatgLabel() {
		return driver.findElement(incbyownerbycatglabel);	
	}
	
	
	
}
