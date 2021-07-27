package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMAccountsPage {
	

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By accountnewbtn = By.xpath("//span[contains(text(),'New')]");
	By accountNametxtbx = By.xpath("//input[@id='id-276390f9-8bbf-4452-8f24-636b0ccaee2c-1-name8-name.fieldControl-text-box-text']");
	By accountnamesearchtable= By.xpath("(//div[@data-id='cell-0-2'])[position()=2]");
	By phn = By.xpath("//input[@aria-label='Phone']");		
	By address = By.xpath("//h2[contains(text(),'Address')]");
	By acctypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By acctypeexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
	By acctypebuyer = By.xpath("//div[contains(text(),'Buyer')]");
	By street1 = By.xpath("//input[@aria-label='Street 1']");
	By state = By.xpath("//input[@aria-label='State/Province']");
	By countrytxtbx = By.xpath("//input[@aria-label='Country']");
	By city = By.xpath("//input[@aria-label='City']");
	By zip = By.xpath("//input[@aria-label='ZIP/Postal Code']");
	By cntryexpandbtn = By.xpath("//button[@aria-label='Toggle Dropdown']");
	By countryname = By.xpath("//div[@id='_dropdown']/div[3]");
	By accsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	By cletterfilterlink = By.xpath("//a[@id='C_link']");
	By accountname = By.xpath("//div[@data-id='cell-2-2']");
	By addtimelinebtn = By.xpath("//button[@aria-label='Create a timeline record.']");
	By appointmentactivityoptn = By.xpath("//li[@aria-label='Appointment Activity']");
	By timelinesubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By timelinesavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	By successmsg = By.xpath("//span[@data-id='notification-message']");
	By accpagebackbtn = By.xpath("//button[@aria-label=\"Press Enter to go back.\"]");
	By relatedTab = By.xpath("//li[@title='Related']");
	By activitiesRelatedTab = By.xpath("//span[@id='navActivities_Related']"); // added xpath for activities option at Related Dropdown list
	By activityTab = By.xpath("//li[@title='Activities']");  // added xpath for activity tab
	By allfilterlink = By.xpath("//a[@id='All_link']");
	By deactivateaccname = By.xpath("//div[@data-id='cell-1-2']");
	By deactivatebtn = By.xpath("//button[@aria-label='Deactivate']");
	By deactivateokbtn = By.xpath("//button[@data-id='ok_id']");
	By activatebtn = By.xpath("//button[@aria-label='Activate']");
	By accdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']");
	By inactiveacctsoptn = By.xpath("//*[text()='Inactive Accounts']");
	By validateInactiveAcc = By.xpath("//div[@data-id='cell-0-2']");
	By accnaviagtebtn = By.xpath("//button[contains(@title, 'Navigate to') and contains(@class ,'cc-ds-rowbtn cc-gridcell-navigable wj-btn wj-btn-default cc-ds-rowbtn-nav')]");
	By parentacclabel = By.xpath("//label[contains(text(),'Parent Account')]");
	By parentacctxtbx = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.SimpleLookupControl|parentaccountid.fieldControl|account']");
	By parentaccsearchbtn = By.xpath("//button[@aria-label='Search records for Parent Account, Lookup field']");
	By selectparentacc = By.xpath("//ul[@aria-label='Lookup Search Results']/li[1]/div[2]/span[1]");
	By recentrecordslink = By.xpath("//button[contains(text(),'Recent records')]");
	By accsavebtn = By.xpath("//button[@aria-label='Save']");
	By activatepopupstatusfield = By.xpath("//select[@aria-label='Status']");
	By accstatusbuysatcorplevel = By.xpath("//option[contains(text(),'Buys at Corporate Level')]");
	By activatepopupactivatebtn = By.xpath("//button[@data-id='ok_id']");
	By accstatusreason = By.xpath("//div[@data-id = 'form-header']/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");
	By activeaccountslabel = By.xpath("//div[@aria-label='Active Accounts']");
	By inactiveaccountslabel = By.xpath("//li[@aria-label='Inactive Accounts']");
	By statusreasonbuysatcorplevelinheader = By.xpath("//div[@title='Buys at Corporate Level']");
	By pageno = By.xpath("//span[@title='Current page']");
	By accstatusoutofbusiness = By.xpath("//option[contains(text(),'Out of Business')]");
	By deactivatepopupdeactivatebtn = By.xpath("//button[@data-id='ok_id']");
	By statusreasonoutofbusinessinheader = By.xpath("//div[@title='Out of Business']");
	By backbtn = By.xpath("//button[@aria-label='Press Enter to go back.']");
	By acctypemedia = By.xpath("//div[contains(text(),'Media')]");
	By mediasegmentationfieldlabel = By.xpath("//label[contains(text(),'Media Segmentation')]");
	By mediatypefieldlabel = By.xpath("//label[contains(text(),'Media Type')]");
	By mediasegmentationdrpdown = By.xpath("//select[@aria-label='Media Segmentation']");
	By mediasegmentationname = By.xpath("//option[contains(text(),'Las Vegas Local')]");
	By mediatypedrpdown = By.xpath("//select[@aria-label='Media Type']");
	By mediatypename = By.xpath("//option[contains(text(),'Print - Magazine')]");
	By acctypeselectedvaluetxtbx = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|account']");
	By removeacctypemediabtn = By.xpath("//button[@aria-label='Remove Media']");
	By newaccountheader = By.xpath("//h1[@title='New Account']");
	By discardchangesbtn = By.xpath("//button[@aria-label='Discard changes']");
	By notetimelineoptn = By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_notes']");
	By notetitletimeline =By.xpath("//input[@id='create_note_medium_title']");
	By noteiframe = By.xpath("//body[@aria-label='Enter text...']");
	By notetextenter = By.xpath("//body[@aria-label='Enter text...']");		
	By addnotebutton = By.xpath("//button[@aria-label='Add note']");
	By cancelnotebutton = By.xpath("//button[@id='create_note_cancel_btn']");
	By notesubject = By.xpath("//div[@id='timeline_record_title_text520480cb-f222-56a8-9dcb-c78e97e2bce7']");
	By viewcreatednote = By.xpath("//div[@id='TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]"); //Locator for newly created Note name on timeline
	By posttimelineoptn =By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_post']");
	By posttextenter = By.xpath("//textarea[@id='create_post_postText']");
	By postAddButton = By.xpath("//button[@aria-label='Add post']");
	By postCancelButton = By.xpath("//button[@id='create_post_cancel_btn']");
	By viewCreatedPost = By.xpath("//div[@id = 'TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]"); //Locator for newly created Post name on timeline
	By auditHistoryRelatedTab = By.xpath("//span[@id='navAudit_Related']"); //xpath added for AuditHistory option from Related Dropdown list
	By auditHistoryTab = By.xpath("//li[@title='Audit History']"); // xpath for Activity History Tab
	By deleteNote = By.xpath("//div[@id = 'TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[1]/div[3]/button[2]"); //Locator for Delete Note button
	By timelineDetails = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]");
	By okConfirmBtn = By.xpath("//span[@id='confirmButtonText']");
	By deletePost = By.xpath("//div[@id = 'TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[1]/div[3]/button[3]"); //Locator for Delete Post button
	By validateaccnameinsearchresults = By.xpath("//div[@data-id='cell-0-2']");
	By applocation = By.xpath("//input[@data-id = 'location.fieldControl-text-box-text']");
	By phonecalloption = By.xpath("//li[@aria-label = 'Phone Call Activity']");
	By phonecallsubject = By.xpath("//input[@data-id='subject.fieldControl-text-box-text']");
	By clickphonecallduedatecalendor = By.xpath("//div [@class = 'ms-TextField-wrapper']/div/i");
	By phonecallduetimoption = By.xpath("//div[@id = 'scheduledend_fabric_comboboxwrapper']/button/span");
	By phonecallselectduetime = By.xpath("//button[@id = 'scheduledend_fabric_combobox-list47']");
	By clickregiongridfunnel = By.xpath("//div[@data-id = 'xxc_regionid']");
	By clickfunnelfilter = By.xpath("//button[@aria-label = 'Filter by']");
	By clickoperatordd = By.xpath("//div[@aria-label = 'Filter by operator']");
	By selectoperator = By.xpath("//button[@data-index = '0']");
	By clickvaluetextbox = By.xpath("//div[@class='ms-SelectionZone']");
	By selectregionvalue = By.xpath("//div[@id = 'sug-0']");
	By selectvalueregionactual = By.xpath("//div[@aria-label = 'Data']/div[6]");
	By clickapplybutton = By.xpath("//button[@type = 'submit']");
	By clickaddressgridfunnel = By.xpath("//div[@data-id = 'address1_stateorprovince']");
	By clickaddressvaluefield = By.xpath("//div[@class = 'ms-TextField-wrapper']/div/input");
	By clickdbanamegridfunnel = By.xpath("//div[@data-id = 'name']");
	By selectoperatorone = By.xpath("//button[@data-index = '2']");
	By clearfiltergrid = By.xpath("//button[@aria-label = 'Clear filter']");
	By clickdbaphonegridfunnel = By.xpath("//div[@data-id = 'telephone1']");
	By clickdbacitygridfunnel = By.xpath("//div[@data-id = 'address1_city']");
	By accdbanametxtbx = By.xpath("//input[@aria-label='Account DBA Name']");
	By duplicaterecordspopuptitle = By.xpath("//h1[@data-id='manageDuplicatesTitle']");
	By unsavedchangespopuptitle = By.xpath("//h1[@aria-label='Unsaved changes']");
	By phoneinsearchtable = By.xpath("(//div[@data-id='cell-0-3'])[position()=2]");
	By phonetxboxlabel = By.xpath("//label[contains(text(),'Phone')]");
	By hletterfilterlink = By.xpath("//li[@aria-label='Filter table by h']");
	By duplicaterecordspopupignorensavebtn = By.xpath("//button[@aria-label='Ignore and save']");
	By clickoverflowbutton = By.xpath("(//button[@data-id = 'OverflowButton'])");
	By clickexporttoexcelbutton = By.xpath("//button[@data-id = 'account|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.account.ExportToExcel.Menu$splitButtonId']");
	By saveexcelonline = By.xpath("//button[@data-id = 'export_to_excelonline_save']");
	By selectcheckbox1 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyaccountxxc_accountactivecontactcount']");
	By selectcheckbox2 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeyaccountaccountnumber']");
	By exportworksheetpopup = By.xpath("//button[@data-id = 'export_excel']");
	By contactssectionbusinessphonefield = By.xpath("//div[@data-id='cell-0-3']");
	By contactssectionlabel = By.xpath("//label[contains(text(),'Group By')]");
	By contactssectionemailfield = By.xpath("//div[@data-id='cell-0-6']");
	By contactssectionemailfieldlabel = By.xpath("//div[contains(text(),'Email')]");
	By contactssectioncontactname = By.xpath("//div[@data-id='cell-0-2']");
	By associatedlistslabel = By.xpath("//h2[contains(text(),'Associated Lists')]");
	By contactssectionmobilephonefield = By.xpath("//div[@data-id='cell-0-5']");
	By contactnavigatebtn = By.xpath("//button[@title='Navigate']");
	By activecontactslist = By.xpath("//div[@aria-label='Active Contacts Account Subgrid']");
	By bletterfilterlink = By.xpath("//li[@aria-label='Filter table by b']");
	By relatedtabcontactsitem = By.xpath("//span[@id='navContacts_Related']");
	By contactassociatedviewdropdownicon = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']");
	By contactassociatedviewlabel = By.xpath("//span[contains(text(),'Contact Associated View')]");
	By selectviewsallcontactsitem = By.xpath("//span[contains(text(),'All Contacts')]");
	By enteranotelabel = By.xpath("//span[contains(text(),'Enter a note...')]");
	By detailsTab = By.xpath("//li[@title='Details']"); // xpath for Detail tab at Account Details page.
	By originatingleadinput = By.xpath("//section[@id='DETAILS_TAB_section_2']//section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]");
	By notificationExpandIcon = By.xpath("//span[@id='notificationExpandIcon']");
	By notificationwrappermsg = By.xpath("//html[1]/body[1]/div[2]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span[2]");
	By phoneErrorMsg = By.xpath("//*[contains(text(),'Phone : Required fields must be filled in.')]");
	By typeNotificationWrapperMsg = By.xpath("//span[contains(text(),'Type : Required fields must be filled in.')]");
	By phoneRequiredIcon = By.xpath("/div[@data-id='telephone1-required-icon']");
	By searchaccounttextbox = By.xpath("//input[@aria-label = 'Search this view']");
	By clicksearchbutton = By.xpath("//button[@aria-label = 'Start search']");
	By updateaccountname = By.xpath("//input[@data-id = 'name.fieldControl-text-box-text']");
	By updateaccountlegalname = By.xpath("//input[@data-id = 'xxc_accountlegalname.fieldControl-text-box-text']");
	By movetoparentaccount = By.xpath("//span[@data-id = 'parentaccountid.fieldControl-crmSymbolFont_selectedRecords_entity-symbol']");
	By deleteselectedparentaccount = By.xpath("//section[@id= 'ACCOUNT_INFORMATION']/section[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]/span[1]");
	By clickparentaccountlookup = By.xpath("//input[@aria-label = 'Parent Account, Lookup']");
	By selectparentaccount = By.xpath("//ul[@aria-label = 'Lookup results']/li[1]/div[2]/span[1]");
	By clickextensiontextbox = By.xpath("//input[@data-id = 'xxc_phone1ext.fieldControl-text-box-text']");
	By clickfaxtextbox = By.xpath("//input[@aria-label = 'Fax']");
	By clickwebsiteurl = By.xpath("//input[@data-id = 'websiteurl.fieldControl-url-text-input']");
	By scrolltoaddress = By.xpath("//div[@data-id = 'telephone1-required-icon']");
	By movetomarketingrelationshipowner = By.xpath("//div[@data-id = 'xxc_marketingrelationshipownerid']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/div[2]/div[2]");
	By deletemarketingrelationshipowner = By.xpath("//div[@data-id = 'xxc_marketingrelationshipownerid']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");
	By clickmarketingrelationshipowner = By.xpath("//input[@aria-label = 'Marketing Relationship Owner, Lookup']");
	By selectmarketingrelationshipowner = By.xpath("//li[@data-id = 'xxc_marketingrelationshipownerid.fieldControl-LookupResultsDropdown_xxc_marketingrelationshipownerid_resultsContainer']/div[2]/span[1]");
	By movetotype = By.xpath("//div[@id = 'xxc_typecode_i']");
	By deletetype = By.xpath("//div[@id = 'xxc_typecode_i']/div[5]/ul[1]/li[1]/button[1]");
	By clicksearchddbutton = By.xpath("//button[@aria-label = 'Toggle menu']");
	By selecttype = By.xpath("//div[@data-id = 'xxc_typecode']/div[1]/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/div[1]/div[6]/div[2]/ul[1]/li[1]/label[1]");
	By updateaddressline1 = By.xpath("//input[@data-id = 'address1_line1.fieldControl-text-box-text']");
	By updateaddressline2 = By.xpath("//input[@data-id = 'address1_line2.fieldControl-text-box-text']");
	By updateaddressline3 = By.xpath("//input[@data-id = 'address1_line3.fieldControl-text-box-text']");
	By updatecity = By.xpath("//input[@data-id = 'address1_city.fieldControl-text-box-text']");
	By updatestate = By.xpath("//input[@data-id = 'address1_stateorprovince.fieldControl-text-box-text']");
	By updatepostalcode = By.xpath("//input[@data-id = 'address1_postalcode.fieldControl-text-box-text']");
	By clickcountrydropdown = By.xpath("//button[@aria-label = 'Toggle Dropdown']");
	By selectcountry = By.xpath("//div[@id = '_dropdown']/div[1]");
	By findupdatedaccount = By.xpath("//div[@data-id = 'data-set-quickFind-container']/button[1]");
	By scrolltocontacts = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_column_3_section_1']");
	By scrolltoassociatedlists = By.xpath("//section[@aria-label = 'Associated Lists']");
	By listgridcolumn1 = By.xpath("//div[@data-id = 'AssociatedLists_container']/div[1]/div[4]/div[1]/div[1]/div[5]/div[1]/div[1]/div[2]");
	By listgridcolumn2 = By.xpath("//div[@data-id = 'AssociatedLists_container']/div[1]/div[4]/div[1]/div[1]/div[5]/div[1]/div[1]/div[3]");
	By listgridcolumn3 = By.xpath("//div[@data-id = 'AssociatedLists_container']/div[1]/div[4]/div[1]/div[1]/div[5]/div[1]/div[1]/div[4]");
	By nolist = By.xpath("//div[@data-id = 'AssociatedLists_container']");
	By list = By.xpath("//div[@data-id = 'AssociatedLists-GridListContainer']");
	By listmember = By.xpath("//div[@aria-label = 'Active List Members']");
	By openexcelonline = By.xpath("//button[@aria-label = 'Open in Excel Online']");
	By exporttostaticworksheet = By.xpath("//button[@aria-label = 'Static Worksheet']");
	By exporttostaticworksheetpageonly = By.xpath("//button[@aria-label = 'Static Worksheet (Page only)']");
	By exporttodynamicworksheet = By.xpath("//button[@aria-label = 'Dynamic Worksheet']");
	By exporttodynamicpivottable = By.xpath("//button[@aria-label = 'Dynamic PivotTable']");
	By phoneCallTimelineSubject= By.xpath("//div[@id='TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[2]"); //Locator for newly created Phone call on Timeline
	By accrefreshbtn = By.xpath("//button[@aria-label='Refresh']");
	By duplicaterecordspopupcancelbtn = By.xpath("//button[@aria-label = 'Cancel']");
	By phonecallduedatecurrent = By.xpath("//div[@aria-label = 'Calendar']/div[1]/div[2]/div[2]/div[2]/table[1]/tbody[1]/tr[3]/td[3]/button[1]");
	By selectedlistname = By.xpath("//div[@data-id='xxc_list.fieldControl-LookupResultsDropdown_xxc_list_selected_tag_text']");
	By listmemremovedlabel = By.xpath("//span[@title='Last List Member Removed']");
	By memberslabel = By.xpath("//h2[contains(text(),'Members')]");
	By taskbtnontimeline = By.xpath("//div[text() = 'Task']");
	By tasksubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By tasksavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	By acctypelabel = By.xpath("//div[@data-id = 'xxc_typecode-FieldSectionItemContainer']/div[2]/div[1]/div[1]/span[1]/label[1]");
	By accstreet3label = By.xpath("//label[contains(text(),'Street 3')]");
	By verifyaccountppointment = By.xpath("//div[@id = 'TimelineGroupsMainContainer']/li[1]/div[1]/div[2]/div[2]/label[1]");//Locator for getting text of subject for an appointment
	//By trackprogressexportbtn = By.xpath("//div[@data-id = 'alertdialog']div[1]/div[3]/button[1]/span[1]"); //Locator for track progress for export online option for accounts
	By clickcountry = By.xpath("//div[@class = 'wj-listbox-item'][2]"); 
	By summarytab = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_column_3_section_1']");
	By accountinfosection = By.xpath("//h2[@data-id = 'form-sectionHeader-ACCOUNT_INFORMATION']");
	By countryautocompletelist = By.xpath("//div[@class='wj-listbox-item']");
	By originatinglead = By.xpath("//input[@aria-label = 'Originating Lead, Lookup']");//Locator for originating lead on details tab
	By contactpreferences = By.xpath("//section[@aria-label = 'Contact Preferences']");//Locator for Contact Preferences on details tab
	By conprefoptions = By.xpath("//section[@data-id = 'CONTACT_PREFERENCES']");//Locator for Contact Preferences
	By listsection = By.xpath("//section[@aria-label = 'Associated Lists']");//Locator for Lists section
	By descriptiontitle = By.xpath("//h2[@title = 'Description']"); //Locator for Description section title
	By selectedparentaccount = By.xpath("//div[@data-id = 'parentaccountid.fieldControl-entityIconContainer_selectedRecords']");//Locator for selected Parent Account
	By notearrow = By.xpath("//div[@id = 'TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[5]/span[1]");//Locator for arrow for note
	By postarrow = By.xpath("//div[@id = 'TimelineMainContainer']/div[1]/li[1]/div[1]/div[2]/div[4]/span[1]");//Locator for arrow for post
	
	//CAB-256
	By accountstatusmerged = By.xpath("//option[contains(text(),'Merged')]"); //Locator for selecting Account status as merged
	By verifyaccstatusmerged= By.xpath("//span[contains(text(),'Merged')]"); //Locator to verify Account status as merged
	By contactssectioncontactnamestatusactive= By.xpath("//label[contains(text(),'Active')]"); //Locator for Contact section Contact name status as active
	By contactstatusresonactive= By.xpath("//span[@title='Active']"); //Locator for Contact status as active
	By accountstatusnovalidinfoavailable = By.xpath("//option[contains(text(),'No Valid Info Available')]"); //Locator for Account status No Valid Info Available
	By verifyaccstatusnovalidinfoavailable= By.xpath("//span[contains(text(),'No Valid Info Available')]"); //Locator to verify Account status No Valid Info Available
	By contactssectioncontactnamestatusinactive= By.xpath("//label[contains(text(),'Inactive')]"); //Locator for Contact section Contact name status as inactive
	By contactstatusreasonnovalidaccinfo= By.xpath("//span[@title='No Valid Account Info']"); //Locator for Contact Status reason No Valid Account Info
	By accountstatusoutofbusiness = By.xpath("//option[contains(text(),'Out of Business')]"); //Locator for Account status Out of Business
	By verifyaccstatusoutofbusiness= By.xpath("//span[contains(text(),'Out of Business')]"); //Locator to verify Account status Out of Business
	By contactstatusreasonoutofbusiness= By.xpath("//span[@title='Out of Business']"); //Locator for Contact Status reason Out of Business
	By accountstatusnotvalidbuyingacc = By.xpath("//option[contains(text(),'Not valid Buying account')]"); //Locator for Account status Not valid Buying account
	By verifyaccstatusnotvalidbuyingacc= By.xpath("//span[contains(text(),'Not valid Buying account')]"); //Locator to verify Account status Not valid Buying account
	By contactstatusreasonnotvalidbuyingacc= By.xpath("//span[@title='Not a Valid Buying Account']"); //Locator for Contact Status reason Not valid Buying account
	 
	
	public CRMAccountsPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getPhoneCallTimelineSubject() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(phoneCallTimelineSubject);
	}

	public WebElement getAccountnametxtbx() {

		return driver.findElement(accountNametxtbx);
	}

	public WebElement getAccountNewbtn() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(accountnewbtn);
	}
	public WebElement getAccountNameSearchTable() throws InterruptedException
	{
		Thread.sleep(6000);
		return driver.findElement(accountnamesearchtable);
	}
	public WebElement getPhone()
	{
		return driver.findElement(phn);
	}

	public WebElement getAddress()
	{
		return driver.findElement(address);
	}

	public WebElement getAccTypetxtbx()
	{
		return driver.findElement(acctypetxtbx);
	}

	public WebElement getAcctypeExpandbtn()
	{
		return driver.findElement(acctypeexpandbtn);
	}

	public WebElement getAccTypeBuyer()
	{
		return driver.findElement(acctypebuyer);
	}

	public WebElement getStreet1()
	{
		return driver.findElement(street1);
	}

	public WebElement getState()
	{
		return driver.findElement(state);
	}

	public WebElement getCity()
	{
		return driver.findElement(city);
	}

	public WebElement getZipcode()
	{
		return driver.findElement(zip);
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
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryname));
		return driver.findElement(countryname);
	}

	public WebElement getAccSaveCloseBtn() throws InterruptedException
	{
		Thread.sleep(6000);
		return driver.findElement(accsavenclosebtn);
	}


	public WebElement getAccountName() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(accountname);
	}

	public WebElement getAddTimelineBtn()
	{
		return driver.findElement(addtimelinebtn);
	}

	public WebElement getApptmntActivityOptn()
	{
		return driver.findElement(appointmentactivityoptn);
	}

	public WebElement getTimelineSujecttxbx() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(timelinesubjecttxtbx));
		Thread.sleep(10000);
		return driver.findElement(timelinesubjecttxtbx);
	}

	public WebElement getTimelineSavenClosebtn()
	{
		return driver.findElement(timelinesavenclosebtn);
	}

	public WebElement getSuccessMsg()
	{
		return driver.findElement(successmsg);
	}

	public WebElement getAccPageBackBtn()
	{
		return driver.findElement(accpagebackbtn);
	}

	public WebElement getRelatedTab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(relatedTab));
		return driver.findElement(relatedTab);
	}

	public WebElement getSelectActivitiesRelated() {
		return driver.findElement(activitiesRelatedTab);
	}
	public WebElement getActivityTab() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(activityTab));
		return driver.findElement(activityTab);
	}

	public WebElement getAllFilterLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(allfilterlink));
		return driver.findElement(allfilterlink);
	}

	public WebElement getDeactivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivatebtn));
		return driver.findElement(deactivatebtn);
	}

	public WebElement getDeactivateOkBtn() {
		return driver.findElement(deactivateokbtn);
	}
	public WebElement getActivateBtn() {
		return driver.findElement(activatebtn);
	}

	public WebElement getDeactivateAccName() {
		return driver.findElement(deactivateaccname);
	}

	public WebElement getActiveAccDropDownBtn() {
		return driver.findElement(accdropdownbtn);
	}

	public WebElement getInactiveAccOptn() {
		return driver.findElement(inactiveacctsoptn);
	}

	public WebElement getValidateInactiveAccName() {
		return driver.findElement(validateInactiveAcc);
	}

	public WebElement getCLetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.elementToBeClickable(cletterfilterlink));
		return driver.findElement(cletterfilterlink);
	}

	public WebElement getAccNaviagteBtn() {
		return driver.findElement(accnaviagtebtn);
	}

	public WebElement getParentAccLabel() {
		return driver.findElement(parentacclabel);
	}

	public WebElement getParentAcctxbx() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(parentacctxtbx));
		return driver.findElement(parentacctxtbx);
	}

	public WebElement getParentAccSearchBtn() {
		return driver.findElement(parentaccsearchbtn);
	}

	public WebElement selectParentAccName() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectparentacc));
		return driver.findElement(selectparentacc);
	}

	public WebElement getRecentRecordsLink() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(recentrecordslink));
		return driver.findElement(recentrecordslink);
	}

	public WebElement getAccSaveBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(accsavebtn));
		return driver.findElement(accsavebtn);
	}

	public WebElement getActivatePopupStatusField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activatepopupstatusfield));
		return driver.findElement(activatepopupstatusfield);
	}

	public WebElement getAccStatusBuysatCorpLevel() {
		return driver.findElement(accstatusbuysatcorplevel);
	}

	public WebElement getActivatePopupActivatebtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(activatepopupactivatebtn)).click();
		return driver.findElement(activatepopupactivatebtn);
	}

	public WebElement getStatusReasonBuysatCorpLevelInHeader() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonbuysatcorplevelinheader));
		return driver.findElement(statusreasonbuysatcorplevelinheader);
	}

	public WebElement getAccStatusReson() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accstatusreason));
		return driver.findElement(accstatusreason);
	}

	public WebElement getActiveAccountsLabel() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeaccountslabel));
		return driver.findElement(activeaccountslabel);
	}

	public WebElement getInactiveAccountsLabel() {

		return driver.findElement(inactiveaccountslabel);
	}

	public WebElement getAccStatusOutofBusiness() {

		return driver.findElement(accstatusoutofbusiness);
	}

	public WebElement getDeactivatePopupDeactivatebtn() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(deactivatepopupdeactivatebtn)).click();
		return driver.findElement(deactivatepopupdeactivatebtn);
	}

	public WebElement getAccStatusResonForInactiveAcc() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accstatusreason));
		return driver.findElement(accstatusreason);
	}

	public WebElement getPageBackBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(backbtn);
	}

	public WebElement getAccTypeMedia()
	{
		return driver.findElement(acctypemedia);
	}

	public List<WebElement> getMediaSegmentationFieldLabel() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElements(mediasegmentationfieldlabel);
	}

	public List<WebElement> getMediaTypeFieldLabel()
	{
		return driver.findElements(mediatypefieldlabel);
	}

	public WebElement getMediaSegmentationDropdown()
	{
		return driver.findElement(mediasegmentationdrpdown);
	}

	public WebElement getMediaSegmentationName()
	{
		return driver.findElement(mediasegmentationname);
	}

	public WebElement getMediaTypeDropdown()
	{
		return driver.findElement(mediatypedrpdown);
	}

	public WebElement getMediaTypeName()
	{
		return driver.findElement(mediatypename);
	}

	public WebElement getAccTypeSelectedValueTxtbx()
	{
		return driver.findElement(acctypeselectedvaluetxtbx);
	}

	public WebElement getRemoveAccTypeMediaBtn()
	{
		return driver.findElement(removeacctypemediabtn);
	}

	public WebElement getNewAccountHeader()
	{
		return driver.findElement(newaccountheader);
	}

	public WebElement getDiscardChangesBtn()
	{
		return driver.findElement(discardchangesbtn);
	}

	public WebElement getNoteTimelineOptn()
	{
		return driver.findElement(notetimelineoptn);
	}
	public WebElement getNoteTitleTextbox()
	{
		return driver.findElement(notetitletimeline);	
	}
	public WebElement getNoteiframe()
	{
		return driver.findElement(noteiframe);
	}
	public WebElement getNoteTextEnter()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(notetextenter));
		return driver.findElement(notetextenter);
	}
	public WebElement getAddNoteButton()
	{
		return driver.findElement(addnotebutton);
	}
	public WebElement getCancelNoteButton()
	{
		return driver.findElement(cancelnotebutton);
	}
	public WebElement getNoteSubject()
	{
		return driver.findElement(notesubject);
	}
	public WebElement getViewCreatedNote() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(viewcreatednote);
	}
	public WebElement getPostTimelineOptn()
	{
		return driver.findElement(posttimelineoptn);
	}
	public WebElement getPostTextEnter()
	{
		return driver.findElement(posttextenter);
	}
	public WebElement getPostAddButton()
	{
		return driver.findElement(postAddButton);
	}
	public WebElement getPostCancelButton()
	{
		return driver.findElement(postCancelButton);
	}

	public WebElement getViewCreatedPost() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(viewCreatedPost);
	}
	public WebElement getAuditHistoryRelatedTab()
	{
		return driver.findElement(auditHistoryRelatedTab);
	}	
	public WebElement getAuditHistoryTab()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(auditHistoryTab));
		return driver.findElement(auditHistoryTab);
	}
	public WebElement getDeleteNote()
	{
		return driver.findElement(deleteNote);	
	}
	public WebElement getTimelineDetails()
	{
		return driver.findElement(timelineDetails);
	}
	public WebElement getOkConfirmBtn()
	{
		return driver.findElement(okConfirmBtn);
	}
	public WebElement getDeletePost()
	{
		return driver.findElement(deletePost);	
	}

	public WebElement getValidateAccnameInSearchResults() throws InterruptedException
	{
		Thread.sleep(20000);
		return driver.findElement(validateaccnameinsearchresults);
	}

	public WebElement getapplocation() {

		return driver.findElement(applocation);
	}

	public WebElement getphonecalloption() {

		return driver.findElement(phonecalloption);
	}

	public WebElement getphonecallsubject() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(phonecallsubject);
	}

	public WebElement getclickphonecallduedatecalendor() {

		return driver.findElement(clickphonecallduedatecalendor);
	}

	public WebElement getphonecallduedatecurrent() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallduedatecurrent));
		return driver.findElement(phonecallduedatecurrent);
	}


	public WebElement getphonecallduetimoptionn() {
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallduetimoption));
		return driver.findElement(phonecallduetimoption);
	}

	public WebElement getphonecallselectduetime() {

		return driver.findElement(phonecallselectduetime);
	}

	public WebElement getclickregiongridfunnel() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(clickregiongridfunnel);
	}

	public WebElement getclickfunnelfilter() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(clickfunnelfilter));
		Thread.sleep(5000);
		return driver.findElement(clickfunnelfilter);
	}

	public WebElement getclickoperatordd() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(clickoperatordd));
		return driver.findElement(clickoperatordd);
	}

	public WebElement getselectoperator() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectoperator));
		return driver.findElement(selectoperator);
	}

	public WebElement getsclickvaluetextbox() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickvaluetextbox));
		return driver.findElement(clickvaluetextbox);
	}

	public WebElement getselectregionvalue() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectregionvalue));
		return driver.findElement(selectregionvalue);
	}

	public WebElement getselectregionvalueactual() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectvalueregionactual));
		return driver.findElement(selectvalueregionactual);
	}

	public WebElement getclickapplybutton() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(clickapplybutton));
		return driver.findElement(clickapplybutton);
	}

	public WebElement getclickaddressgridfunnel() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(clickaddressgridfunnel);
	}

	public WebElement getclickaddressvaluefield() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickaddressvaluefield));
		return driver.findElement(clickaddressvaluefield);
	}

	public WebElement getclickdbanamegridfunnel() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(clickdbanamegridfunnel);
	}

	public WebElement getselectoperatorone()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectoperatorone));
		return driver.findElement(selectoperatorone);
	}

	public WebElement getclearfiltergrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clearfiltergrid));
		return driver.findElement(clearfiltergrid);
	}

	public WebElement getclickdbaphonegridfunnel() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(clickdbaphonegridfunnel);
	}

	public WebElement getclickdbacitygridfunnel() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(clickdbacitygridfunnel);
	}

	public WebElement getAccDBANametxbox()
	{
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(newaccountheader));
		return driver.findElement(accdbanametxtbx);
	}

	public WebElement getDuplicateRecordsPopupTitle() throws InterruptedException
	{
		Thread.sleep(5000);
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.visibilityOfElementLocated(duplicaterecordspopuptitle));
		return driver.findElement(duplicaterecordspopuptitle);
	}

	public WebElement getDuplicateRecordsPopupCancelbtn()
	{
		return driver.findElement(duplicaterecordspopupcancelbtn);
	}

	public WebElement getUnsavedChangesPopupTitle()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(unsavedchangespopuptitle));
		return driver.findElement(unsavedchangespopuptitle);
	}
	public WebElement getPhoneinSearchTable()
	{
		return driver.findElement(phoneinsearchtable);
	}

	public WebElement getPhoneTxtbxLabel() throws InterruptedException
	{
		Thread.sleep(2000);
		return driver.findElement(phonetxboxlabel);
	}

	public WebElement getHLetterFilterLink() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(hletterfilterlink));
		return driver.findElement(hletterfilterlink);
	}

	public WebElement getDuplicateRecordsPopupIgnorenSavebtn()
	{
		return driver.findElement(duplicaterecordspopupignorensavebtn);
	}

	public WebElement getclickoverflowbutton() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(clickoverflowbutton);
	}

	public WebElement getclickexporttoexcelbutton() {

		return driver.findElement(clickexporttoexcelbutton);
	}

	public WebElement getopenexcelonline() {

		return driver.findElement(openexcelonline);
	}

	public WebElement getsaveexcelonline() throws InterruptedException 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(saveexcelonline));
		Thread.sleep(20000);
		return driver.findElement(saveexcelonline);
	}
	public WebElement getexporttostaticworksheet() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttostaticworksheet));
		return driver.findElement(exporttostaticworksheet);
	}

	public WebElement getexporttostaticworksheetpageonly() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttostaticworksheetpageonly));
		return driver.findElement(exporttostaticworksheetpageonly);
	}

	public WebElement getexporttodynamicworksheet() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttodynamicworksheet));
		return driver.findElement(exporttodynamicworksheet);
	}

	public WebElement getselectcheckbox1() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox1));
		return driver.findElement(selectcheckbox1);
	}

	public WebElement getselectcheckbox2() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcheckbox2));
		return driver.findElement(selectcheckbox2);
	}

	public WebElement getexportworksheetpopup() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exportworksheetpopup));
		return driver.findElement(exportworksheetpopup);
	}

	public WebElement getexporttodynamicpivottable() 
	{
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(exporttodynamicpivottable));
		return driver.findElement(exporttodynamicpivottable);
	}
	public WebElement getContactsSectionLabel()
	{
		return driver.findElement(contactssectionlabel);
	}

	public WebElement getContactsSectionEmailField()
	{
		return driver.findElement(contactssectionemailfield);
	}

	public WebElement getContactsSectionBusinessPhoneField()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactssectionlabel));
		return driver.findElement(contactssectionbusinessphonefield);
	}

	public WebElement getContactsSectionEmailFieldLabel()
	{
		return driver.findElement(contactssectionemailfieldlabel);
	}

	public WebElement getContactsSectionContactName() throws InterruptedException
	{
		Thread.sleep(4000);
		return driver.findElement(contactssectioncontactname);
	}

	public WebElement getAssociatedListsLabel()
	{
		return driver.findElement(associatedlistslabel);
	}

	public WebElement getContactsSectionMobilePhoneField()
	{
		return driver.findElement(contactssectionmobilephonefield);
	}

	public WebElement getContactNavigateBtn()
	{
		return driver.findElement(contactnavigatebtn);
	}

	public WebElement getAccRefreshBtn() throws InterruptedException
	{
		//		wait = new WebDriverWait (driver,20);
		//		wait.until(ExpectedConditions.elementToBeClickable(accrefreshbtn));
		Thread.sleep(5000);
		return driver.findElement(accrefreshbtn);
	}

	public List<WebElement> getActiveContactsList() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElements(activecontactslist);
	}

	public WebElement getBLetterFilterLink() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(bletterfilterlink));
		return driver.findElement(bletterfilterlink);
	}

	public WebElement getRelatedTabContactsItem() {
		return driver.findElement(relatedtabcontactsitem);
	}

	public WebElement getContactAssociatedViewDropDownIcon()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactassociatedviewlabel));
		return driver.findElement(contactassociatedviewdropdownicon);
	}

	public WebElement getContactAssociatedViewLabel() {
		return driver.findElement(contactassociatedviewlabel);
	}

	public WebElement getSelectViewsAllContactsItem() {
		return driver.findElement(selectviewsallcontactsitem);
	}

	public WebElement getEnteraNoteLabel() {
		return driver.findElement(enteranotelabel);
	}
	public WebElement getNotificationWrapperMsg()
	{
		return driver.findElement(notificationwrappermsg);
	}
	public WebElement getNotificationExpandIcon()
	{
		return driver.findElement(notificationExpandIcon);
	}
	public WebElement getPhoneErrorMsg()
	{
		return driver.findElement(phoneErrorMsg);
	}
	public WebElement getTypeNotificationWrapperMsg() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(typeNotificationWrapperMsg);	
	}
	public WebElement getPhoneRequiredIcon()
	{
		return driver.findElement(phoneRequiredIcon);
	}

	public WebElement getsearchaccounttextbox() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(searchaccounttextbox);
	}
	public WebElement getclicksearchbutton()
	{
		wait = new WebDriverWait (driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clicksearchbutton));
		return driver.findElement(clicksearchbutton);
	}
	public WebElement getupdateaccountname()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaccountname));
		return driver.findElement(updateaccountname);
	}
	public WebElement getupdateaccountlegalname()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaccountlegalname));
		return driver.findElement(updateaccountlegalname);
	}
	public WebElement getmovetoparentaccount()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(movetoparentaccount));
		return driver.findElement(movetoparentaccount);
	}
	public WebElement getdeleteselectedparentaccount()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteselectedparentaccount));
		return driver.findElement(deleteselectedparentaccount);
	}
	public WebElement getclickparentaccountlookup()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickparentaccountlookup));
		return driver.findElement(clickparentaccountlookup);
	}
	public WebElement getselectparentaccount()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectparentaccount));
		return driver.findElement(selectparentaccount);
	}
	public WebElement getclickextensiontextbox()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickextensiontextbox));
		return driver.findElement(clickextensiontextbox);
	}
	public WebElement getclickfaxtextbox()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickfaxtextbox));
		return driver.findElement(clickfaxtextbox);
	}
	public WebElement getclickwebsiteurl()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickwebsiteurl));
		return driver.findElement(clickwebsiteurl);
	}
	public WebElement getscrolltoaddress()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltoaddress));
		return driver.findElement(scrolltoaddress);
	}
	public WebElement getmovetomarketingrelationshipowner()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(movetomarketingrelationshipowner));
		return driver.findElement(movetomarketingrelationshipowner);
	}
	public WebElement getdeletemarketingrelationshipowner()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deletemarketingrelationshipowner));
		return driver.findElement(deletemarketingrelationshipowner);
	}
	public WebElement getclickmarketingrelationshipowner()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickmarketingrelationshipowner));
		return driver.findElement(clickmarketingrelationshipowner);
	}
	public WebElement getselectmarketingrelationshipowner()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectmarketingrelationshipowner));
		return driver.findElement(selectmarketingrelationshipowner);
	}
	public WebElement getmovetotype()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(movetotype));
		return driver.findElement(movetotype);
	}
	public WebElement getdeletetype()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deletetype));
		return driver.findElement(deletetype);
	}
	public WebElement getclicksearchddbutton()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clicksearchddbutton));
		return driver.findElement(clicksearchddbutton);
	}
	public WebElement getselecttype()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selecttype));
		return driver.findElement(selecttype);
	}
	public WebElement getupdateaddressline1()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaddressline1));
		return driver.findElement(updateaddressline1);
	}
	public WebElement getupdateaddressline2()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaddressline2));
		return driver.findElement(updateaddressline2);
	}
	public WebElement getupdateaddressline3()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaddressline3));
		return driver.findElement(updateaddressline3);
	}
	public WebElement getupdatecity()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updatecity));
		return driver.findElement(updatecity);
	}
	public WebElement getupdatestate()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updatestate));
		return driver.findElement(updatestate);
	}
	public WebElement getupdatepostalcode()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updatepostalcode));
		return driver.findElement(updatepostalcode);
	}
	public WebElement getclickcountrydropdown()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickcountrydropdown));
		return driver.findElement(clickcountrydropdown);
	}
	public WebElement getselectcountry()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectcountry));
		return driver.findElement(selectcountry);
	}
	public WebElement getfindupdatedaccount()
	{
		wait = new WebDriverWait (driver,3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findupdatedaccount));
		return driver.findElement(findupdatedaccount);
	}

	public WebElement getscrolltocontacts()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltocontacts));
		return driver.findElement(scrolltocontacts);
	}
	public WebElement getscrolltoassociatedlists()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltoassociatedlists));
		return driver.findElement(scrolltoassociatedlists);
	}
	public WebElement getlistgridcolumn1()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listgridcolumn1));
		return driver.findElement(listgridcolumn1);
	}
	public WebElement getlistgridcolumn2()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listgridcolumn2));
		return driver.findElement(listgridcolumn2);
	}
	public WebElement getlistgridcolumn3()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listgridcolumn3));
		return driver.findElement(listgridcolumn3);
	}
	public WebElement getnolist()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nolist));
		return driver.findElement(nolist);
	}
	public WebElement getlist() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(list);
	}
	public WebElement getlistmember()
	{
		wait = new WebDriverWait (driver,5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmember));
		return driver.findElement(listmember);
	}

	public WebElement getSelectedListName()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedlistname));
		return driver.findElement(selectedlistname);
	}

	public WebElement getListMemRemovedLabel()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listmemremovedlabel));
		return driver.findElement(listmemremovedlabel);
	}

	public WebElement getMembersLabel()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(memberslabel));
		return driver.findElement(memberslabel);
	}

	public WebElement getTaskBtnOnTimeline()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(taskbtnontimeline));
		return driver.findElement(taskbtnontimeline);
	}

	public WebElement getTaskSujecttxbx() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(tasksubjecttxtbx);
	}

	public WebElement getTaskSavenClosebtn()
	{
		return driver.findElement(tasksavenclosebtn);
	}

	public WebElement getAccTypeLabel()
	{
		return driver.findElement(acctypelabel);
	}

	public WebElement getAccStreet3Label()
	{
		return driver.findElement(accstreet3label);
	}
	public WebElement getverifyaccountppointment() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyaccountppointment));
		Thread.sleep(10000);
		return driver.findElement(verifyaccountppointment);
	}
	/*public WebElement gettrackprogressexportbtn() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(trackprogressexportbtn));
		Thread.sleep(20000);
		return driver.findElement(trackprogressexportbtn);
	}*/

	public WebElement getclickcountry()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(clickcountry));
		return driver.findElement(clickcountry);
	}
	public WebElement getsummarytab()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(summarytab));
		return driver.findElement(summarytab);
	}
	public WebElement getaccountinfosection()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(accountinfosection));
		return driver.findElement(accountinfosection);
	}

	public List<WebElement> getCountryAutocompleteList()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryautocompletelist));
		return driver.findElements(countryautocompletelist);
	}


	public WebElement getoriginatinglead() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(detailsTab));
		Thread.sleep(5000);
		return driver.findElement(detailsTab);
	}
	public WebElement getcontactpreferences() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactpreferences));
		Thread.sleep(5000);
		return driver.findElement(contactpreferences);
	}
	public WebElement getconprefoptions() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conprefoptions));
		Thread.sleep(5000);
		return driver.findElement(conprefoptions);
	}
	public WebElement getdetailsTab() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(detailsTab));
		return driver.findElement(detailsTab);
	}
	public WebElement getlistsection() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(listsection));
		return driver.findElement(listsection);
	}
	public WebElement getAccountStatusMerged() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountstatusmerged));
		return driver.findElement(accountstatusmerged);
	}

	public WebElement getVerifyAccountStatusMerged() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyaccstatusmerged));
		return driver.findElement(verifyaccstatusmerged);
	}

	public WebElement getContactsSectionContactNameStatusAsActive() throws InterruptedException
	{
		Thread.sleep(4000);
		return driver.findElement(contactssectioncontactnamestatusactive);
	}

	public WebElement getContactStatusReasonActive() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatusresonactive));
		return driver.findElement(contactstatusresonactive);
	}

	public WebElement getAccountStatusNoValidInfoAvailable() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountstatusnovalidinfoavailable));
		return driver.findElement(accountstatusnovalidinfoavailable);
	}

	public WebElement getVerifyAccountStatusNoValidInfoAvailable() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyaccstatusnovalidinfoavailable));
		return driver.findElement(verifyaccstatusnovalidinfoavailable);
	}

	public WebElement getContactsSectionContactNameStatusAsInactive() throws InterruptedException
	{
		Thread.sleep(4000);
		return driver.findElement(contactssectioncontactnamestatusinactive);
	}

	public WebElement getContactStatusReasonNoValidAccInfo() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatusreasonnovalidaccinfo));
		return driver.findElement(contactstatusreasonnovalidaccinfo);
	}

	public WebElement getAccountStatusOutOfBusiness() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountstatusoutofbusiness));
		return driver.findElement(accountstatusoutofbusiness);
	}

	public WebElement getVerifyAccountStatusOutOfBusiness() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyaccstatusoutofbusiness));
		return driver.findElement(verifyaccstatusoutofbusiness);
	}

	public WebElement getContactStatusReasonOutOfBusiness() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatusreasonoutofbusiness));
		return driver.findElement(contactstatusreasonoutofbusiness);
	}

	public WebElement getAccountStatusNotValidBuyingAcc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountstatusnotvalidbuyingacc));
		return driver.findElement(accountstatusnotvalidbuyingacc);
	}

	public WebElement getVerifyAccountStatusNotValidBuyingAccount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(verifyaccstatusnotvalidbuyingacc));
		return driver.findElement(verifyaccstatusnotvalidbuyingacc);
	}

	public WebElement getContactStatusReasonNotValidBuyingAccount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatusreasonnotvalidbuyingacc));
		return driver.findElement(contactstatusreasonnotvalidbuyingacc);
	}
	public WebElement getdescriptiontitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(descriptiontitle));
		return driver.findElement(descriptiontitle);
	}
	public WebElement getselectedparentaccount() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectedparentaccount));
		return driver.findElement(selectedparentaccount);
	}
	public WebElement getnotearrow() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(notearrow));
		return driver.findElement(notearrow);
	}
	public WebElement getpostarrow() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(postarrow));
		return driver.findElement(postarrow);
	}
}

