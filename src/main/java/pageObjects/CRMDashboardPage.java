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
	By selectdashbaord = By.xpath("//div[@title = 'Dashboard Selector']");//Locator arrow for system dashboard options
	By selectcallcenrepdashbaord = By.xpath("//ul[@title = 'Select a view.']/div[1]/div[1]/li[2]");//Locator for dashboard options
	By clickdropdownfirstsection = By.xpath("//span[@title = 'Select a view']");//Locator for drop down list for first section 
	By selectoption = By.xpath("//li[@title = 'My Scheduled Calls next 7 days']");//Locator for My Scheduled Phone Call Next 7 days option in drop down
	By verifyphonecallfirtsection = By.xpath("//div[@data-type = 'List']/div[1]/ul[1]/li[1]/div[1]");//Locator for phone call verification in first section
	By clickdropdownsecondection = By.xpath("//div[@class = 'chartheader-cell-leftfloat suiter-chart']");//Locator for drop down list for second section
	By nodataavailable = By.xpath("//span[contains(text(),'No data available.')]");//Locator for No Data Available
	By chartspace = By.xpath("//div[@class = 'highcharts-container ']");//Locator for graph available in second section
	By readonlygrid = By.xpath("//div[@aria-label = 'Readonly Grid']");//Locator for grid first section
	By nodatasymbolfirstsection = By.xpath("//span[@class = 'symbolFont InsertKbArticle-symbol pa-jd pa-ce pa-xw pa-mq ']");//Locator for no data available image
	By phcallsubject = By.xpath("//div[@data-id = 'MscrmControls.Containers.DashboardControl-DashboardContainer']/div[2]/div[1]");//Locator for phone call subject
	By phcallregarding = By.xpath("//ul[@aria-label = 'My Scheduled Calls next 7 days']/li[1]/div[1]/div[1]/label[2]");//Locator for phone call regarding
	By nodatasymbolsecondsection = By.xpath("//span[@class = 'symbolFont InsertKbArticle-symbol pa-jd pa-ce pa-xw pa-mq ']");//Locator for no data available image
	By viewrecordsbtn = By.xpath("//button[@data-id = 'ViewRecordButton']");//Locator for View Records button
	By grid = By.xpath("//div[@aria-label = 'Readonly Grid']");//Locator for grid 
	By calltocol = By.xpath("//div[@data-id = 'to']");//Locator for call to column in grid
	By phnocol = By.xpath("//div[@data-id = 'phonenumber']");//Locator for phone number column in grid
	By subcol = By.xpath("//div[@data-id = 'subject']");//Locator for subject column in grid
	By regardingcol = By.xpath("//div[@data-id = 'regardingobjectid']");//Locator for regarding column in grid
	By prioritycol = By.xpath("//div[@data-id = 'prioritycode']");//Locator for priority column in grid
	By duecol = By.xpath("//div[@data-id = 'scheduledend']");//Locator for due column in grid
	By sortatozbtn = By.xpath("//button[@aria-label = 'Sort A to Z']");//Locator for sort A to Z button
	By sortztoabtn = By.xpath("//button[@aria-label = 'Sort Z to A']");//Locator for sort Z to A button
	By gridsorting = By.xpath("//div[@data-id = 'grid-cell-container']");//Locator for grid sorting
	By headeroverflow = By.xpath("//button[@data-id = 'header_overflowButton']");//Locator for arrow button in header
	By activitydashboard = By.xpath("//li[@title = 'My Activity Dashboard']");//Locator for My Activity Dashborad view
	By mytaskview = By.xpath("//*[contains (text(),'My Open Tasks Next 7 Days']");//Locator for My open tasks section under My Activities Dashboard 
	By mytasktitleforchart = By.xpath("//h2[@title = 'My Open Tasks Next 7 Days']");//Locator for My Open task title for chart
	By taskdesc = By.xpath("//textarea[@aria-label = 'Description']");//Locator for Description field for tasks
	By taskduedate = By.xpath("//div[@data-id = 'form-header']/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]");//Locator for Due Date for task
	By duedateinchartfortask = By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component85d0e9a']/div/div[2]/div/div[3]/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]//*[ text() ]");//Locator for My Open Tasks chart
	By taskregardingsearch = By.xpath("//button[@aria-label = 'Search records for Regarding, Lookup field']");//Locator for serach Regarding for task
	By selectregardingfortask = By.xpath("//ul[@aria-label = 'Lookup Search Results']");//Locator for regarding option
	By selecttaskdudate = By.xpath("//button[@aria-label = 'April 24, 2021']");//Locator for due date for task
	By searchfieldopenttasks = By.xpath("(//input[@aria-label = 'Search this view'])[position()=2]"); //Locator for Search field of My Open Tasks
	By opentasksstartsearchbtn = By.xpath("(//button[@aria-label = 'Start search'])[position()=2]"); //Locator for Start Search btn of My Open Tasks
	By validateopentaskinsearchrslts = By.xpath("//div[@data-id='cell-0-4']"); //Locator to validate Open task
	By opentasksnext7dayslabel = By.xpath("//span[contains(text(),'My Open Tasks Next 7 Days')]"); //Locator for My Open Tasks next 7 days label
	
	By countalltasklabel = By.xpath("//span[contains(text(),'Count:All (Task)')]"); //Locator for Count All(Task) label
	
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
	By completedcallsXaxisvalue= By.xpath("//div[@data-id='Component2669287_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]");//Locator for Completed calls last week_X axis value
	By completedcallsYaxisvalue= By.xpath("//div[@data-id='Component2669287_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Completed calls last week_Y axis value
	By registrationsXaxisvalue= By.xpath("//div[@data-id='Component8697706_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]");//Locator for Registrations(3 months prior-3months next)_X axis value
	By registrationsYaxisvalue= By.xpath("//div[@data-id='Component8697706_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]");//Locator for Registrations(3 months prior-3months next)_Y axis value
	By declinecallsXaxisvalue= By.xpath("//div[@data-id='Component428227_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Declined Calls_X axis value
	By declinecallsYaxisvalue= By.xpath("//div[@data-id='Component428227_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][30]"); //Locator for Declined Calls_Y axis value
	By incentivedetailsXaxisvalue= By.xpath("//div[@data-id='Component1970579_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]"); //Locator for Incentive Details Created Last Week_X axis value
	By incentivedetailsYaxisvalue= By.xpath("//div[@data-id='Component1970579_container']/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][9]"); //Locator for Incentive Details Created Last Week_Y axis value
	By activeincentivedetailsXaxisvalue= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component5453290']/div/div[2]/div/div[3]/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][7]"); //Locator for Active Incentive Details_X axis value
	By activeincentivedetailsYaxisvalue= By.xpath("//div[@data-id='MscrmControls.Containers.DashboardControl-Component5453290']/div/div[2]/div/div[3]/div[3]/div[2]/*[name()='svg']/*[local-name() = 'g'][8]"); //Locator for Active Incentive Details_Y axis value
	By incentivedetailsnodataavailablemsg= By.xpath("//div[@data-id='Component1970579_container']/div[3]/div[1]/span[2]"); //Locator for No data available message for Incentive Details Created Last Week
    By incentivedetailsvaluecheck= By.xpath("//div[@data-id='Component1970579_container']"); //Locator to check Incentive Details

	
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
	
	public WebElement getselectdashbaord() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectdashbaord));
		return driver.findElement(selectdashbaord);
	}
	public WebElement getselectcallcenrepdashbaord() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectcallcenrepdashbaord));
		return driver.findElement(selectcallcenrepdashbaord);
	}
	public WebElement getselectoption() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectoption));
		return driver.findElement(selectoption);
	}
	public WebElement getverifyphonecallfirtsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyphonecallfirtsection));
		return driver.findElement(verifyphonecallfirtsection);
	}
	public WebElement getclickdropdownfirstsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickdropdownfirstsection));
		return driver.findElement(clickdropdownfirstsection);
	}
	public WebElement getclickdropdownsecondection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickdropdownsecondection));
		return driver.findElement(clickdropdownsecondection);
	}
	public WebElement getnodataavailable() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nodataavailable));
		return driver.findElement(nodataavailable);
	}
	public WebElement getchartspace() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(chartspace));
		return driver.findElement(chartspace);
	}
	public WebElement getreadonlygrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(readonlygrid));
		return driver.findElement(readonlygrid);
	}
	public WebElement getphcallsubject() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phcallsubject));
		return driver.findElement(phcallsubject);
	}
	
	public WebElement getphcallregarding() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phcallregarding));
		return driver.findElement(phcallregarding);
	}
	public WebElement getnodatasymbolfirstsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nodatasymbolfirstsection));
		return driver.findElement(nodatasymbolfirstsection);
	}
	public WebElement getnodatasymbolsecondsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nodatasymbolsecondsection));
		return driver.findElement(nodatasymbolsecondsection);
	}
	public WebElement getviewrecordsbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(viewrecordsbtn));
		return driver.findElement(viewrecordsbtn);
	}
	public WebElement getgrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(grid));
		return driver.findElement(grid);
	}
	public WebElement getcalltocol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(calltocol));
		return driver.findElement(calltocol);
	}
	public WebElement getphnocol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phnocol));
		return driver.findElement(phnocol);
	}
	public WebElement getsubcol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(subcol));
		return driver.findElement(subcol);
	}
	public WebElement getregardingcol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(regardingcol));
		return driver.findElement(regardingcol);
	}
	public WebElement getprioritycol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(prioritycol));
		return driver.findElement(prioritycol);
	}
	public WebElement getduecol() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(duecol));
		return driver.findElement(duecol);
	}
	public WebElement getsortatozbtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortatozbtn));
		return driver.findElement(sortatozbtn);
	}
	public WebElement getsortztoabtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(sortztoabtn));
		return driver.findElement(sortztoabtn);
	}
	public WebElement getgridsorting() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(gridsorting));
		return driver.findElement(gridsorting);
	}
	public WebElement getheaderoverflow() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(headeroverflow));
		return driver.findElement(headeroverflow);
	}
	public WebElement getactivitydashboard() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activitydashboard));
		return driver.findElement(activitydashboard);
	}
	public WebElement getmytaskview() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mytaskview));
		return driver.findElement(mytaskview);
	}
	public WebElement getmytasktitleforchart() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mytasktitleforchart));
		return driver.findElement(mytasktitleforchart);
	}
	public WebElement gettaskdesc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskdesc));
		return driver.findElement(taskdesc);
	}
	public WebElement gettaskduedate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskduedate));
		return driver.findElement(taskduedate);
	}
	public WebElement getduedateinchartfortask() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(duedateinchartfortask));
		return driver.findElement(duedateinchartfortask);
	}
	public WebElement gettaskregardingsearch() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskregardingsearch));
		return driver.findElement(taskregardingsearch);
	}
	public WebElement getselectregardingfortask() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectregardingfortask));
		return driver.findElement(selectregardingfortask);
	}
	public WebElement getselecttaskdudate() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selecttaskdudate));
		return driver.findElement(selecttaskdudate);
	}
	public WebElement getSearchFieldOpentTasks() {
		return driver.findElement(searchfieldopenttasks);
	}
	public WebElement getOpenTasksStartSearchBtn() {
		return driver.findElement(opentasksstartsearchbtn);
	}
	public WebElement getValidateOpenTaskInSearchRslts() {
		return driver.findElement(validateopentaskinsearchrslts);
	}
	public WebElement getOpenTasksNext7DaysLabel() {
		return driver.findElement(opentasksnext7dayslabel);
	}
	public WebElement getCountAllTaskLabel() {
		return driver.findElement(countalltasklabel);
	}
	public WebElement getIncentiveDetailsValueCheck() {
		return driver.findElement(incentivedetailsvaluecheck);	
	}
	
	
	
	
}
