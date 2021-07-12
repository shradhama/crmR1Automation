package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRMContactPage {

	public WebDriver driver;
	public FluentWait<WebDriver> wait;

	By scrolltoaddcontact = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_column_3_section_1']");
	By clicknewcontactbutton = By.xpath("//button[@aria-label = 'New Contact']");
	By firstname = By.xpath("//input[@aria-label = 'First Name']");
	By lastname = By.xpath("//input[@aria-label = 'Last Name']");
	By email = By.xpath("//input[@aria-label = 'Email']");
	By mobile = By.xpath("//input[@aria-label = 'Mobile Phone']");
	By scrolltocontactaddress = By.xpath("//h2[@data-id = 'form-sectionHeader-SUMMARY_TAB_section_4']");
	By street1 = By.xpath("//input[@aria-label = 'Street 1']");
	By city = By.xpath("//input[@aria-label = 'City']");
	By stateorprovince = By.xpath("//input[@aria-label = 'State/Province']");
	By ziporpostalcode = By.xpath("//input[@aria-label = 'ZIP/Postal Code']");
	By country = By.xpath("//input[@aria-label = 'Country']");
	By clicklistbox = By.xpath("//div[@class = 'wj-listbox-item']");
	By savecontact = By.xpath("//button[@aria-label = 'Save']");
	By verifycontact = By.xpath("//h1[@data-id='header_title']");
	By contactformemailtxtfield = By.xpath("//input[@data-id='emailaddress1.fieldControl-mail-text-input']");
	By contactformbusinessphonetxtfield = By.xpath("//input[@aria-label='Business Phone']");
	By contactsectionmenubtn = By.xpath("//button[@aria-label='More commands for Contact']");
	By contactsavenclosebtn = By.xpath("//button[@aria-label='Save & Close']");
	By contactnameinheader = By.xpath("//h1[@data-id='header_title']");
	By activecontactslabel = By.xpath("//div[@aria-label='Active Contacts']");
	//By createnewcontactbtn = By.xpath("//button[@aria-label='New']");
	By createnewcontactbtn = By.xpath("//button[@data-lp-id='HomePageGrid:contact-contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.NewRecord']");
	By contactfirstnamelabel = By.xpath("//label[text()='First Name']");
	By contacttypetxtbx = By.xpath("//input[@id='xxc_typecode_ledit']");
	By contacttypeexpandbtn = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|contact']/div/div[6]/div[1]/div[2]/button[1]/span[1]");
	By contacttypebuyer = By.xpath("//div[contains(text(),'Buyer')]");
	By contactaccountnametxtbx = By.xpath("//input[@aria-label='Account Name, Lookup']");
	By searchrecordsbtn = By.xpath("//button[@aria-label='Search records for Account Name, Lookup field']");
	By accountnametitle = By.xpath("//span[@data-id='parentcustomerid.fieldControl-name0_0_0']");
	//By scrolltextoncontactform = By.xpath("//h2[@data-id = 'form-sectionHeader-CONTACT_INFORMATION']");
	By scrolltextoncontactform = By.xpath("//div[text()='Select Save to see your timeline.']");
	By accountincentivedetailslabel = By.xpath("//div[text()='Account Incentive Details']");
	By mobilephonelabel = By.xpath("//label[text()='Mobile Phone']");
	By citylabel = By.xpath("//label[text()='City']");
	By countrytxtbx = By.xpath("//input[@aria-label='Country']");
	By cntryexpandbtn = By.xpath("//button[@aria-label='Toggle Dropdown']");
	By countryname = By.xpath("//body/div[@id='_dropdown']/div[3]");
	By validateInactiveContact = By.xpath("//div[@data-id='cell-0-2']");
	By inactivecontactsoptn = By.xpath("//*[text()='Inactive Contacts']");
	By contactdropdownbtn = By.xpath("//span[@class='symbolFont ChevronDownMed-symbol  ']");
	By deactivatebtn = By.xpath("//button[@aria-label='Deactivate']");
	By deactivateokbtn = By.xpath("//button[@data-id='ok_id']");
	By qletterfilterlink = By.xpath("//a[@id='Q_link']");
	By contactstatusoutofbusiness = By.xpath("//option[contains(text(),'Out of Business')]");
	By statusreasonoutofbusinessinheader = By.xpath("//div[@title='Out of Business']");
	By contactstatusreason = By.xpath("//div[@data-lp-id='MscrmControls.FieldControls.PicklistStatusControl|header_statuscode.fieldControl|contact']");
	By opencontact = By.xpath("//div[@data-id = 'cell-0-2']");
	By calltophonecall = By.xpath("//input[@aria-label = 'Call To, Multiple Selection Lookup']");
	By searchcallto = By.xpath("//button[@aria-label = 'Search records for Call To, Multiple Selection Lookup field']");
	By selectcallto = By.xpath("//li[@data-id = 'to.fieldControl-LookupResultsDropdown_to_resultsContainer']");
	By clicktab = By.xpath("//li[@aria-label = 'Phone Call']");
	By selectexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div");
	By scrollrightongrid = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[4]/div[10]");
	By openexistingcontact = By.xpath("//div[@aria-label = 'Editable Grid']/div[1]/div[1]/div[1]/div[2]/div[10]/div[1]/button[1]");
	By contacttypemedia = By.xpath("//div[contains(text(),'Media')]");
	By jobfunctionfieldlabel = By.xpath("//label[contains(text(),'Job Function')]");
	By jobfunctionfieldtxtbox = By.xpath("//input[@aria-label='Job Function']");
	By jobfunctionfieldexpandbtn = By.xpath("//button[@aria-label='Toggle menu']");
	By jobfunctionvalueslist = By.xpath("//div[@id='xxc_jobrolecode_i']/div[6]/div[2]/ul/li");
	By jobfunctionvalue = By.xpath("//div[@id='xxc_jobrolecode_i']/div[6]/div[2]/ul/li[1]/label");
	By contactrefreshbtn = By.xpath("//button[@aria-label='Refresh']");
	By contacttypeselectedvaluetxtbx = By.xpath("//div[@data-lp-id='MscrmControls.MultiSelectPicklist.UpdMSPicklistControl|xxc_typecode.fieldControl|contact']");
	By removecontacttypemediabtn = By.xpath("//button[@aria-label='Remove Media']");
	By businessphonelabel = By.xpath("//label[text()='Business Phone']");
	By cletterfilterlink = By.xpath("//a[@id='C_link']"); //Locator for 'C' letter filter link
	By selectcontactname = By.xpath("//div[@data-id='cell-2-2']"); //Locator to select Contact name in Grid
	By contactnaviagtebtn = By.xpath("//button[contains(@title, 'Navigate to') and contains(@class ,'cc-ds-rowbtn cc-gridcell-navigable wj-btn wj-btn-default cc-ds-rowbtn-nav')]"); //Locator for Navigate button on Contact grid
	By contactactivatebtn = By.xpath("//button[@aria-label='Activate']"); //Locator for Activate button in Contact form header
	By contactactivatepopupstatusfield = By.xpath("//select[@aria-label='Status']"); //Locator for 'Status field on contact activation pop-up
	By contactstatusdonotcall = By.xpath("//option[contains(text(),'Do Not Call')]"); //Locator for 'Do Not Call' contact status in drop-down
	By activatepopupactivatebtn = By.xpath("//button[@data-id='ok_id']"); //Locator for Activate button on pop-up
	By statusreasondonotcallinheader = By.xpath("//div[@title='Do Not Call']"); //Locator for contact status reason in contact form header
	By verifycontactappointment = By.xpath("//div[@id = 'TimelineGroupsMainContainer']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/label[1]");//Locator for subject for appointment in time line section for a contact
	By contactaddtimelinebtn = By.xpath("//button[@aria-label='Create a timeline record.']"); //Locator for Add Timeline button for Contact
	By contacttaskbtnontimeline = By.xpath("//div[text() = 'Task']");
	By contacttasksubjecttxtbx = By.xpath("//input[@aria-label='Subject']");
	By contacttasksavenclosebtn = By.xpath("//button[@data-id='quickCreateSaveAndCloseBtn']");
	By exporttoexcelbtn = By.xpath("//button[@id ='contact|NoRelationship|HomePageGrid|Mscrm.HomepageGrid.contact.ExportToExcel.Menu$splitButtonId_button1$button']");//Locator for export to excel arrow for contacts
	By exportselectbox1 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeycontactaddress1_latitude']");//Locator for selecting columns to be included in dynamic sheet and dynamic pivot table for export to options
	By exportselectbox2 = By.xpath("//input[@data-id = 'entitySelector_id.fieldControl-selectAllCheckBoxElementKeycontactcallback']");//Locator for selecting columns to be included in dynamic sheet and dynamic pivot table for export to options
	By exporttrackprogressbtn = By.xpath("//button[@aria-label = 'Track Progress']");//Locator for track progress button for export excel online option for contacts
	By contactmarketprofilestab = By.xpath("//li[@aria-label='Contact Market Profiles']"); //Locator for Contact Market Profiles tab
	By nodataavailabletextformarketprofile =  By.xpath("//div[@data-lp-id='MscrmControls.Grid.ReadOnlyGrid|ContactMarketProfile|contact|3f6c1e66-6002-ea11-a811-000d3a36886f|xxc_contactmarketprofile|xxc_contact_xxc_contactmarketprofile_Contactid|cc-grid']/div/div/div/span[2]"); //Locator for No Data Available Text for Contact Market Profile
	By contactsummarytab = By.xpath("//li[@aria-label='Summary']"); //Locator for Summary tab on Contact form
	By phonecalloption = By.xpath("//li[@aria-label = 'Phone Call Activity']"); //Locator for Phone call option on Timeline pop-up
	By phonecalldescriptionlabel = By.xpath("//h2[contains(text(),'Description')]"); //Locator for Description label on Phone call page
	By newphonecallmarketoutcomebtn = By.xpath("//button[@aria-label='New Phone Call Market Outcome']"); //Locator for add New Phone Call Market Outcome button
	By phonecallmarketsubjecttxtbx = By.xpath("//input[@aria-label='Market, Lookup']"); //Locator for Market subject text box
	By marketsearchbtn = By.xpath("//button[@aria-label='Search records for Market, Lookup field']"); //Locator for Search records for Markets
	By selectmarketname = By.xpath("//span[@data-id='xxc_marketid.fieldControl-xxc_name0_0_0']"); //Locator for select market name
	By phonecalloutcometxtbx = By.xpath("//select[@aria-label='Call Outcome']"); //Locator for Call outcome text box
	By phonecalloutcomeoptn = By.xpath("//option[contains(text(),'Registered')]"); //Locator for 'Registered' outcome
	By phonecallmarketoutcomesavenclosebtn = By.xpath("//button[@id='quickCreateSaveAndCloseBtn']"); //Locator for Save & Close button on Phone call outcome pop-up
	By phonecallmarkcompletebtn = By.xpath("//button[@aria-label='Mark Complete']"); //Locator for Mark Complete button on 'Phone call' page
	By newlycreatedcontactmarketprofilefield = By.xpath("//div[@data-lp-id='MscrmControls.Grid.ReadOnlyGrid|ContactMarketProfile|contact|3f6c1e66-6002-ea11-a811-000d3a36886f|xxc_contactmarketprofile|xxc_contact_xxc_contactmarketprofile_Contactid|cc-grid|cc-grid-cell|cell-0-2']"); //Locator for newly created contact market profile field
	By validatenewlycreatedcontactmarketprofilename = By.xpath("//div[@data-id='cell-0-2']"); //Locator for validate newly created contact market profile name
	By contactmarketprofileisregisteredfield = By.xpath("//div[@data-id='cell-0-3']"); //Locator for Contact market profile 'IsRegistered' field value
	By clickgroupbydd = By.xpath("//div[@aria-label = 'Group By']/div[1]/div[1]/div[1]/span[1]/button[1]");//Locator for arrow for Group By drop down
	By fullnameddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[2]");//Locator for Full Name group by option
	By regionddopt = By.xpath("//div[@class = 'wj-content wj-dropdown-panel wj-control wj-listbox wj-state-focus wj-state-focused']/div[7]");//Locator for region group by option
	By groupbyverification = By.xpath("//button[@aria-label = 'Toggle Group']");//Locator for verification of grouping by options
	By phonecalloutcomedeclinedoptn = By.xpath("//option[contains(text(),'Declined')]"); //Locator for Phone Call Outcome 'Declined' option
	By declinedreasonselectdd = By.xpath("//select[@aria-label='Declined Reason']"); //Locator for Declined Reason drop down
	By selectdeclinedreasonname = By.xpath("//select[@aria-label='Declined Reason']/option[2]"); //Locator for Declined Reason value from Call reason field
	By contactmarketprofiledeclinedreasonfield = By.xpath("//div[@data-id='cell-0-4']"); //Locator for Declined reason value on Contact market profile tab
	By scrolltoaccountdetails = By.xpath("//h2[@data-id = 'form-sectionHeader-CUSTOMER_DETAILS_TAB']");//Locator for Account Details section on Contact page
	By scrolltoregdetails = By.xpath("//div[contains(text(),'Account Registrations')]");//Locator for Registration details section
	By scrolltolistdetails = By.xpath("//div[@data-id = 'contactquickform-QuickFormSectionContainer']");//Locator for Associated Lists
	By contactlistsgrid = By.xpath("//div[@data-id = 'contactquickform.AccountAssociatedLists_container']");//Locator for lists grid on contact form
	By clickcontactlist = By.xpath("//ul[@aria-label='Active Account Sub Grid']/li[1]");//Locator to click List Name
	By bletterfilterlink = By.xpath("//a[@id='B_link']"); //Locator for 'B' letter filter link for contacts
	By contactnotetimelineoptn = By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_notes']"); //Locator for 'Note' option on Timeline pop-up on Contact form
	By contactnotetitletxtbox = By.xpath("//input[@id='create_note_medium_title']"); //Locator for Nite Title text box
	By viewcreatednotetocontact = By.xpath("//div[@id='TimelineGroupsMainContainer']/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div"); //Locator to view newly created note for Contact
	By contactdeletenote = By.xpath("//div[@id='TimelineGroupsMainContainer']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[2]"); //Locator for Delete note btn
	By contacttimelinedetails = By.xpath("//div[@id='TL_Group_key_3']//div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/label[1]"); //Locator for Timeline details
	By okconfirmbtn = By.xpath("//span[@id='confirmButtonText']"); //Locator for OK btn on delete note confirmation pop-up
	By contactaddnotebutton = By.xpath("//button[@aria-label='Add note']"); //Locator for Add note btn
	By contactposttimelineoptn =By.xpath("//li[@data-id='notescontrol-createNewRecord_flyoutMenuItem_post']"); //Locator for Post option on Timeline pop-up
	By contactpostentertext = By.xpath("//textarea[@id='create_post_postText']"); //Locator Post text box
	By contactpostaddbtn = By.xpath("//button[@aria-label='Add post']"); //Locator for Add Post btn
	By contactpostcancelbtn = By.xpath("//button[@id='create_post_cancel_btn']"); //Locator for Post Cancel btn
	By contactviewcreatedpost = By.xpath("//div[@id='TimelineGroupsMainContainer']/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/div"); //Locator to view newly created post
	By contactdeletepost = By.xpath("//div[@id='TimelineGroupsMainContainer']/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/button[3]");  //Locator for Delete Post btn
	By requiredfieldfirstname = By.xpath("//div[@aria-label='Required field First Name']"); //Locator for required field icon of firstname
	By requiredfieldtype = By.xpath("//div[@aria-label='Required field Type']"); //Locator for required field icon of type
	By requiredfieldaccountname = By.xpath("//div[@aria-label='Required field Account Name']"); //Locator for required field icon of account name
	By requiredfieldemail = By.xpath("//div[@aria-label='Required field Email']"); ////Locator for required field icon of email
	By requiredfieldbusinessphone = By.xpath("//div[@aria-label='Required field Business Phone']"); //Locator for required field icon of Business phone
	By requiredfieldmobilephone = By.xpath("//div[@aria-label='Required field Mobile Phone']"); //Locator for required field icon of Mobile phone
	By requiredfieldstreet1 = By.xpath("//div[@aria-label='Required field Street 1']"); //Locator for required field icon of street1
	By requiredfieldcity = By.xpath("//div[@aria-label='Required field City']"); //Locator for required field icon of city
	By requiredfieldzipcode = By.xpath("//div[@aria-label='Required field ZIP/Postal Code']"); //Locator for required field icon of zip code
	By requiredfieldcountry = By.xpath("//div[@aria-label='Required field Country']"); //Locator for required field icon of country
	By requiredfieldstate = By.xpath("//div[@aria-label='Required field State/Province']"); //Locator for required field icon of state
	By countryautocompletelist = By.xpath("//div[@class='wj-listbox-item']"); //Locator for Country autocomplete list
	By selectcountry = By.xpath("//div[@class = 'wj-listbox-item'][2]"); //Locator of Country name from picklist
	By personalsection = By.xpath("//h2[@data-id = 'form-sectionHeader-PERSONAL_NOTES_SECTION']");//Locator for Personal section
	By conprefsection = By.xpath("//h2[@data-id = 'form-sectionHeader-CONTACT_PREFERENCES']");//Locator for Contact Preferences section
	By personalnotes = By.xpath("//textarea[@aria-label = 'Description']");//Locator for Notes under Personal section
	By personalownerid = By.xpath("//div[@data-id = 'header_ownerid-FieldSectionItemContainer']");//Locator for Owner Id under Personal section
	By personaloriginatinglead = By.xpath("//div[@data-id = 'originatingleadid-FieldSectionItemContainer']");//Locator for Originating Lead under Personal section
	By conprefoptions = By.xpath("//section[@data-id = 'CONTACT_PREFERENCES']/div[1]/div[1]/div[1]/div");//Locator for options under Contact Preferences section
	By clickcontactfullnamegrid = By.xpath("//div[@data-id = 'fullname']");//Locator for Full Name filter arrow on Contacts grid
	By clickcontactaccnamegrid = By.xpath("//div[@data-id = 'parentcustomerid']");//Locator for account name filter arrow in contact grid
	By clickcontactphonegrid = By.xpath("//div[@data-id = 'telephone1']");//Locator for business phone filter arrow in contact grid
	By clickcontactemailgrid = By.xpath("//div[@data-id = 'emailaddress1']");//Locator for email filter arrow in contact grid
	By clickcontactstategrid = By.xpath("//div[@data-id = 'address1_stateorprovince']");//Locator for state filter arrow in contact grid
	By clickcontactregiongrid = By.xpath("//div[@data-id = 'xxc_regionid']");//Locator for state filter arrow in contact grid
	By updateaccountname = By.xpath("//ul[@data-id = 'parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_SelectedRecordList']");//Locator for selected account name
	By deleteselectedaccname = By.xpath("//ul[@data-id = 'parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_SelectedRecordList']/li[1]/div[1]");//Locator for deleting selected account name
	By selectaccountname = By.xpath("//ul[@aria-label = 'Lookup recently used results']/li[1]");//Locator for selecting account name
	By accountnamelookup = By.xpath("//div[@data-id = 'parentcustomerid-FieldSectionItemContainer']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]");//Locator for account name lookup search
	By clickaccnamelookup = By.xpath("//input[@aria-label = 'Account Name, Lookup']");//Locator for Account Name field
	By clickrelatedtab = By.xpath("ul[@aria-label = 'Contact Form']/li[7]"); //Locator for Related tab
	By openaudithistory = By.xpath("//div[@id = 'navAudit']"); //Locator for Audit History tab
	By noaudithistory = By.xpath("//div[@title='No Audits found for this Contact. Select Add (+).']"); //Locator for No audits found text
	By dletterfilterlink = By.xpath("//a[@id='D_link']"); //Locator for D' letter filter link for contacts
	By audithistoryrecord = By.xpath("//table[@id='gridBodyTable']/tbody/tr[1]"); //Locator for Audit history record
	By newcontactheaderoncontactform = By.xpath("//h1[contains(text(),'New Contact')]"); //Locator for New contact header of create contact form
	By exporttoexcelmorecmndsbtn = By.xpath("//button[@aria-label='Export to Excel More Commands']"); //Locator for Export to excel more commands btn
	By duplicaterecordspopuptitle = By.xpath("//h1[@aria-label='Duplicate records found']"); //Locator for Duplicate Records found popup
	By duplicaterecordspopupignorensavebtn = By.xpath("//button[@aria-label='Ignore and save']"); //Locator for Ignore & Save btn on Duplicate records popup
	By duplicaterecordspopupcancelbtn = By.xpath("//button[@aria-label = 'Cancel']"); //Locator for Cancel btn on Duplicate records popup
	By selectbeginswithoptr = By.xpath("//button[@data-index = '4']"); //Locator for Begins With operator
	By selectbeginswithoptrforaccname = By.xpath("//button[@data-index = '6']"); //Locator for Begins With operator for Account name
	
	
	//CCAB-256
	By contactstatusnotavalidbuyingacc = By.xpath("//option[contains(text(),'Not a Valid Buying Account')]");
	By gletterfilterlink = By.xpath("//a[@id='G_link']");
	By statusreasonnotavalidbuyingaccinheader = By.xpath("//div[@title='Not a Valid Buying Account']");
	By contactstatusnovalidaccinfo = By.xpath("//option[contains(text(),'No Valid Account Info')]");
	By statusreasonnovalidaccinfoinheader = By.xpath("//div[@title='No Valid Account Info']");
	By readonlynotification = By.xpath("//span[@data-id = 'warningNotification']");//Locator for read only message
	By nolongeracc = By.xpath("//option[contains(text(),'No Longer with Account')]");//Locator for Deactivate Contact No Longer With Account option
	By mergedstatusreason = By.xpath("//div[@data-id = 'editFormRoot']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]");//Locator for Status reason at Contact form
	By badconinfo = By.xpath("//option[contains(text(),'Bad Contact Info')]");//Locator for Deactivate Contact No Longer With Account option
	By statusreasonmainpage = By.xpath("//span[@aria-label = 'Status Reason']");//Locator for status reason on main contact page
	By contactalternativeid = By.xpath("//div[@data-id = 'editFormRoot']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]");//Locator for altenative contact id
	By accountatcontact = By.xpath("//div[@data-id = 'parentcustomerid.fieldControl-LookupResultsDropdown_parentcustomerid_selected_tag_text']");//Locator for Account Name at Contact Page
	By jobtitle = By.xpath("//label[contains(text(),'Job Title')]");//Locator for Job Title
	
	//CAB-269
	By contactalternativeidfield = By.xpath("//div[contains(text(),'Contact Alternative Id')]"); //Locator for Contact Alternative Id field
	By contactalternativeidvalue = By.xpath("//div[@data-id='cell-0-8']"); //Locator for contact alternative id value
	By contactaltidfield = By.xpath("//div[@data-id='xxc_contact_alt_id']"); //Locator for contact alternative id field
	By allcontactsoptn = By.xpath("//*[text()='All Contacts']"); //Locator for All Contacts view option

	//CAB-231
	By contactstatus = By.xpath("//select[@aria-label = 'Contact Status']");//Locator for Contact Status
	By contactstatusoption = By.xpath("//*[contains (text(), 'Interested')]");//Locator for contact status 
	By marketoption = By.xpath("//ul[@aria-label = 'Lookup results']/li[1]");//Locator for market option
	By contactchannelprofilestab = By.xpath("//ul[@aria-label = 'Contact Form']/li[3]");//Locator for Contact Channel Profiles tab
	By morecommandsforccp = By.xpath("//div[@data-id = 'dataSetRoot_ContactChannelProfilestab']/div[1]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/button[1]");//Locator for more options for Contact Channel Profiles
	By deactivateccp = By.xpath("//div[@data-id = 'SetStateDialog']/div[1]/div[3]/button[1]");//Locator for Deactivate button for Contact Channel Profiles
	By deactivateinccpgrid = By.xpath("//button[@data-id = 'xxc_contactchannelprofile|NoRelationship|SubGridStandard|Mscrm.SubGrid.xxc_contactchannelprofile.Deactivate']");//Locator for Deactivate button for deactivating Contact Channel Profile in grid
	By newccp = By.xpath("//button[@aria-label = 'New Contact Channel Profile']");//Locator for new Contact Channel Profile button
	By ccpchannel = By.xpath("//input[@aria-label = 'Channel, Lookup']");//Locator for Channel 
	By channelid = By.xpath("//div[@data-id = 'xxc_channelid.fieldControl-LookupResultsDropdown_xxc_channelid_infoContainer']");//Locator for JuniperMarket Channel in dd
	
	public CRMContactPage(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement getscrolltoaddcontact() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltoaddcontact));
		return driver.findElement(scrolltoaddcontact);
	}

	public WebElement getclicknewcontactbutton() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicknewcontactbutton));
		return driver.findElement(clicknewcontactbutton);
	}

	public WebElement getfirstname() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(firstname));
		return driver.findElement(firstname);
	}

	public WebElement getlastname() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(lastname));
		return driver.findElement(lastname);
	}

	public WebElement getmobile() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(mobile));
		return driver.findElement(mobile);
	}

	public WebElement getscrolltocontactaddress() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(scrolltocontactaddress));
		return driver.findElement(scrolltocontactaddress);
	}

	public WebElement getemail() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(email));
		return driver.findElement(email);
	}

	public WebElement getstreet1() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(street1));
		return driver.findElement(street1);
	}

	public WebElement getcity() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(city));
		return driver.findElement(city);
	}

	public WebElement getstateorprovince() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(stateorprovince));
		return driver.findElement(stateorprovince);
	}

	public WebElement getziporpostalcode() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(ziporpostalcode));
		return driver.findElement(ziporpostalcode);
	}

	public WebElement getcountry() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(country));
		return driver.findElement(country);
	}

	public WebElement getclicklistbox() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicklistbox));
		return driver.findElement(clicklistbox);
	}

	public WebElement getsavecontact() {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(savecontact));
		return driver.findElement(savecontact);
	}

	public WebElement getverifycontact() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(verifycontact);
	}
	public WebElement getContactFormEmailField() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformemailtxtfield));
		return driver.findElement(contactformemailtxtfield);
	}

	public WebElement getContactFormBusinessPhoneField() throws InterruptedException {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactformbusinessphonetxtfield));
		return driver.findElement(contactformbusinessphonetxtfield);
	}

	public WebElement getContactSavenCloseBtn() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(contactsavenclosebtn);
	}

	public WebElement getContactNameinHeader() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(contactnameinheader);
	}

	public WebElement getActiveContactsLabel() {
		return driver.findElement(activecontactslabel);
	}

	public WebElement getCreateNewContactBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(createnewcontactbtn);
	}

	public WebElement getContactFirstNameLabel() {
		return driver.findElement(contactfirstnamelabel);
	}

	public WebElement getContactTypetxtbx()
	{
		return driver.findElement(contacttypetxtbx);
	}

	public WebElement getContactTypeExpandbtn()
	{
		return driver.findElement(contacttypeexpandbtn);
	}

	public WebElement getContactTypeBuyer() throws InterruptedException
	{
		Thread.sleep(6000);
		return driver.findElement(contacttypebuyer);
	}

	public WebElement getContactAccountNameTxtbx()
	{
		return driver.findElement(contactaccountnametxtbx);
	}

	public WebElement getSearchRecordsBtn()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(searchrecordsbtn));	
		return driver.findElement(searchrecordsbtn);
	}

	public WebElement getAccountNameTitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountnametitle));
		return driver.findElement(accountnametitle);
	}

	public WebElement getScrollTextOnContactForm() {

		return driver.findElement(scrolltextoncontactform);
	}

	public WebElement getMobilePhoneLabel() {

		return driver.findElement(mobilephonelabel);
	}
	public WebElement getCityLabel() {

		return driver.findElement(citylabel);
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
		return driver.findElement(countryname);
	}

	public WebElement getContactSectionMenuBtn()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactsectionmenubtn));
		return driver.findElement(contactsectionmenubtn);
	}

	public WebElement getValidateInactiveContactName() throws InterruptedException {
		Thread.sleep(6000);
		return driver.findElement(validateInactiveContact);
	}

	public WebElement getInactiveContactOptn() {
		return driver.findElement(inactivecontactsoptn);
	}

	public WebElement getActiveContactDropDownBtn() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(contactdropdownbtn);
	}

	public WebElement getDeactivateBtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivatebtn));
		return driver.findElement(deactivatebtn);
	}

	public WebElement getDeactivateOkBtn() {
		return driver.findElement(deactivateokbtn);
	}

	public WebElement getQLetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(qletterfilterlink);
	}

	public WebElement getContactStatusOutofBusiness() {

		return driver.findElement(contactstatusoutofbusiness);
	}

	public WebElement getContactStatusResonForInactiveAcc() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonoutofbusinessinheader));
		return driver.findElement(contactstatusreason);
	}

	public WebElement getopencontact() throws InterruptedException {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(opencontact));
		Thread.sleep(10000);
		return driver.findElement(opencontact);
	}

	public WebElement getcalltophonecall()  {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(calltophonecall));
		return driver.findElement(calltophonecall);
	}

	public WebElement getsearchcallto()  {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(searchcallto));
		return driver.findElement(searchcallto);
	}


	public WebElement getselectcallto() throws InterruptedException  {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(selectcallto));
		Thread.sleep(5000);
		return driver.findElement(selectcallto);
	}

	public WebElement getContactTypeMedia()
	{
		return driver.findElement(contacttypemedia);
	}

	public List<WebElement> getJobFunctionFieldLabel()
	{
		return driver.findElements(jobfunctionfieldlabel);
	}

	public WebElement getJobFunctionFieldTxtBox()
	{
		return driver.findElement(jobfunctionfieldtxtbox);
	}

	public WebElement getJobFunctionFieldExpandBtn()
	{
		return driver.findElement(jobfunctionfieldexpandbtn);
	}

	public List<WebElement> getJobFunctionvValuesList()
	{
		return driver.findElements(jobfunctionvalueslist);
	}

	public WebElement getJobFunctionValue()
	{
		return driver.findElement(jobfunctionvalue);
	}
	public WebElement getContactFormRefreshBtn() throws InterruptedException
	{
		Thread.sleep(5000);
		System.out.println("Clicked on Refresh button");
		return driver.findElement(contactrefreshbtn);
	}

	public WebElement getContactTypeSelectedValueTxtbx()
	{
		return driver.findElement(contacttypeselectedvaluetxtbx);
	}

	public WebElement getRemoveContactTypeMediaBtn()
	{
		return driver.findElement(removecontacttypemediabtn);
	}

	public WebElement getBusinessPhoneLabel() {

		return driver.findElement(businessphonelabel);

	}

	public WebElement getCLetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(cletterfilterlink);
	}

	public WebElement selectContactName() throws InterruptedException
	{
		Thread.sleep(10000);
		return driver.findElement(selectcontactname);
	}

	public WebElement getContactNaviagteBtn() {
		return driver.findElement(contactnaviagtebtn);
	}

	public WebElement getContactStatusDoNotCall() {
		return driver.findElement(contactstatusdonotcall);
	}

	public WebElement getContactActivateBtn() {
		return driver.findElement(contactactivatebtn);
	}

	public WebElement getContactActivatePopupStatusField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactactivatepopupstatusfield));
		return driver.findElement(contactactivatepopupstatusfield);
	}

	public WebElement getActivatePopupActivatebtn() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(activatepopupactivatebtn)).click();
		return driver.findElement(activatepopupactivatebtn);
	}

	public WebElement getContactStatusResonForActiveContact() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasondonotcallinheader));
		return driver.findElement(contactstatusreason);
	}

	public WebElement getclicktab() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(clicktab));
		return driver.findElement(clicktab);
	}
	public WebElement getverifycontactappointment() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.elementToBeClickable(verifycontactappointment));
		return driver.findElement(verifycontactappointment);
	}
	public WebElement getContactAddTimelineBtn()
	{
		return driver.findElement(contactaddtimelinebtn);
	}
	public WebElement getContactTaskBtnOnTimeline()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contacttaskbtnontimeline));
		return driver.findElement(contacttaskbtnontimeline);
	}

	public WebElement getContactTaskSujecttxbx() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(contacttasksubjecttxtbx);
	}

	public WebElement getContactTaskSavenClosebtn()
	{
		return driver.findElement(contacttasksavenclosebtn);
	}
	public WebElement getexporttoexcelbtn() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exporttoexcelbtn));
		Thread.sleep(3000);
		return driver.findElement(exporttoexcelbtn);
	}
	public WebElement getexportselectbox1() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exportselectbox1));
		Thread.sleep(3000);
		return driver.findElement(exportselectbox1);
	}
	public WebElement getexportselectbox2() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exportselectbox2));
		Thread.sleep(3000);
		return driver.findElement(exportselectbox2);
	}
	public WebElement getexporttrackprogressbtn() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(exporttrackprogressbtn));
		Thread.sleep(15000);
		return driver.findElement(exporttrackprogressbtn);
	}

	public WebElement getContactMarketProfilesTab() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactmarketprofilestab));
		return driver.findElement(contactmarketprofilestab);
	}

	public WebElement getNoDataAvailableTextForMarketProfile() {

		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nodataavailabletextformarketprofile));
		return driver.findElement(nodataavailabletextformarketprofile);
	}

	public WebElement getContactSummaryTab() {

		return driver.findElement(contactsummarytab);
	}

	public WebElement getphonecalloption() {

		return driver.findElement(phonecalloption);
	}

	public WebElement getNewPhoneCallMarketOutcomeBtn()  {

		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newphonecallmarketoutcomebtn));
		return driver.findElement(newphonecallmarketoutcomebtn);
	}

	public WebElement getPhoneCallMarketSubjectTxtBx() throws InterruptedException  {
		Thread.sleep(6000);
		return driver.findElement(phonecallmarketsubjecttxtbx);
	}

	public WebElement getMarketSearchBtn() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketsearchbtn));
		return driver.findElement(marketsearchbtn);
	}

	public WebElement selectMarketName() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectmarketname));
		return driver.findElement(selectmarketname);
	}

	public WebElement getPhoneCallOutcomeTxtBx() {

		return driver.findElement(phonecalloutcometxtbx);
	}

	public WebElement selectPhoneCallOutcomeOption() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecalloutcomeoptn));
		return driver.findElement(phonecalloutcomeoptn);
	}

	public WebElement getPhoneCallMarketOutcomeSavenCloseBtn() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecallmarketoutcomesavenclosebtn));
		return driver.findElement(phonecallmarketoutcomesavenclosebtn);
	}
	public WebElement getPhoneCallMarkCompleteBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(phonecallmarkcompletebtn);
	}

	public WebElement getNewlyCreatedContactMarketProfileField() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newlycreatedcontactmarketprofilefield));
		return driver.findElement(newlycreatedcontactmarketprofilefield);
	}

	public WebElement getValidateNewlyCreatedContactMarketProfileName() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(validatenewlycreatedcontactmarketprofilename));
		return driver.findElement(validatenewlycreatedcontactmarketprofilename);
	}

	public WebElement getPhoneCallDescriptionLabel()
	{
		return driver.findElement(phonecalldescriptionlabel);
	}

	public WebElement getContactMarketProfileIsRegisteredField()
	{
		return driver.findElement(contactmarketprofileisregisteredfield);
	}
	public WebElement getclickgroupbydd() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickgroupbydd));
		Thread.sleep(10000);
		return driver.findElement(clickgroupbydd);
	}
	public WebElement getfullnameddopt() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(fullnameddopt));
		return driver.findElement(fullnameddopt);
	}
	public WebElement getregionddopt() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(regionddopt));
		return driver.findElement(regionddopt);
	}
	public WebElement getgroupbyverification() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(groupbyverification));
		Thread.sleep(5000);
		return driver.findElement(groupbyverification);
	}
	public WebElement selectPhoneCallOutcomeDeclinedOption() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(phonecalloutcomedeclinedoptn));
		return driver.findElement(phonecalloutcomedeclinedoptn);
	}

	public WebElement getDeclinedReasonSelectDD() {

		return driver.findElement(declinedreasonselectdd);
	}

	public WebElement selectDeclinedReasonName() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(selectdeclinedreasonname);
	}

	public WebElement getContactMarketProfileDeclinedReasonField() {
		wait = new WebDriverWait (driver,15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactmarketprofiledeclinedreasonfield));
		return driver.findElement(contactmarketprofiledeclinedreasonfield);
	}
	public WebElement getscrolltoaccountdetails() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltoaccountdetails));
		Thread.sleep(5000);
		return driver.findElement(scrolltoaccountdetails);
	}
	public WebElement getscrolltoregdetails() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltoregdetails));
		Thread.sleep(5000);
		return driver.findElement(scrolltoregdetails);
	}
	public WebElement getscrolltolistdetails() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(scrolltolistdetails));
		Thread.sleep(5000);
		return driver.findElement(scrolltolistdetails);
	}
	public WebElement getcontactlistsgrid() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactlistsgrid));
		Thread.sleep(5000);
		return driver.findElement(contactlistsgrid);
	}
	public WebElement getclickcontactlist() throws InterruptedException
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickcontactlist));
		return driver.findElement(clickcontactlist);
	}

	public WebElement getBLetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(bletterfilterlink);
	}

	public WebElement getContactNoteTimelineOptn()
	{
		return driver.findElement(contactnotetimelineoptn);
	}

	public WebElement getContactNoteTitleTextbox()
	{
		return driver.findElement(contactnotetitletxtbox);	
	}

	public WebElement getViewCreatedNoteToContact() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(viewcreatednotetocontact);
	}

	public WebElement getContactDeleteNote()
	{
		return driver.findElement(contactdeletenote);	
	}
	public WebElement getContactTimelineDetails()
	{
		return driver.findElement(contacttimelinedetails);
	}

	public WebElement getOkConfirmBtn()
	{
		return driver.findElement(okconfirmbtn);
	}

	public WebElement getContactAddNoteButton()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactaddnotebutton));
		return driver.findElement(contactaddnotebutton);
	}

	public WebElement getContactPostTimelineOptn()
	{
		return driver.findElement(contactposttimelineoptn);
	}

	public WebElement getContactPostEnterText()
	{
		return driver.findElement(contactpostentertext);
	}
	public WebElement getContactPostAddButton()
	{
		return driver.findElement(contactpostaddbtn);
	}
	public WebElement getContactPostCancelButton()
	{
		return driver.findElement(contactpostcancelbtn);
	}

	public WebElement getContactViewCreatedPost() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(contactviewcreatedpost);
	}

	public WebElement getContactDeletePost()
	{
		return driver.findElement(contactdeletepost);	
	}

	public WebElement getRequiredFieldFirstName()
	{
		return driver.findElement(requiredfieldfirstname);	
	}

	public WebElement getRequiredFieldType()
	{
		return driver.findElement(requiredfieldtype);	
	}

	public WebElement getRequiredFieldAccountName()
	{
		return driver.findElement(requiredfieldaccountname);	
	}

	public WebElement getRequiredFieldEmail()
	{
		return driver.findElement(requiredfieldemail);	
	}

	public WebElement getRequiredFieldBusinessPhone()
	{
		return driver.findElement(requiredfieldbusinessphone);	
	}

	public WebElement getRequiredFieldMobilePhone()
	{
		return driver.findElement(requiredfieldmobilephone);	
	}

	public WebElement getRequiredFieldStreet1()
	{
		return driver.findElement(requiredfieldstreet1);	
	}

	public WebElement getRequiredFieldCity()
	{
		return driver.findElement(requiredfieldcity);	
	}

	public WebElement getRequiredFieldZipCode()
	{
		return driver.findElement(requiredfieldzipcode);	
	}

	public WebElement getRequiredFieldCountry()
	{
		return driver.findElement(requiredfieldcountry);	
	}

	public WebElement getRequiredFieldState()
	{
		return driver.findElement(requiredfieldstate);	
	}

	public List<WebElement> getNotRequiredFieldEmail()
	{
		return driver.findElements(requiredfieldemail);	
	}

	public List<WebElement> getNotRequiredFieldMobilePhone()
	{
		return driver.findElements(requiredfieldmobilephone);	
	}

	public List<WebElement> getNotRequiredFieldStreet1()
	{
		return driver.findElements(requiredfieldstreet1);	
	}

	public List<WebElement> getNotRequiredFieldCity()
	{
		return driver.findElements(requiredfieldcity);	
	}

	public List<WebElement> getNotRequiredFieldZipCode()
	{
		return driver.findElements(requiredfieldzipcode);	
	}

	public List<WebElement> getNotRequiredFieldCountry()
	{
		return driver.findElements(requiredfieldcountry);	
	}

	public List<WebElement> getNotRequiredFieldState()
	{
		return driver.findElements(requiredfieldstate);	
	}

	public List<WebElement> getNotRequiredFieldBusinessPhone()
	{
		return driver.findElements(requiredfieldbusinessphone);	
	}
	public List<WebElement> getCountryAutocompleteList()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(countryautocompletelist));
		return driver.findElements(countryautocompletelist);
	}

	public WebElement SelectCountry()
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(selectcountry));
		return driver.findElement(selectcountry);
	}

	public WebElement getpersonalsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personalsection));
		return driver.findElement(personalsection);
	}
	public WebElement getconprefsection() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conprefsection));
		return driver.findElement(conprefsection);
	}
	public WebElement getpersonalnotes() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personalnotes));
		return driver.findElement(personalnotes);
	}
	public WebElement getpersonalownerid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personalownerid));
		return driver.findElement(personalownerid);
	}
	public WebElement getpersonaloriginatinglead() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(personaloriginatinglead));
		return driver.findElement(personaloriginatinglead);
	}
	public WebElement getconprefoptions() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(conprefoptions));
		return driver.findElement(conprefoptions);
	}
	public WebElement getclickcontactfullnamegrid() throws InterruptedException
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactfullnamegrid);
	}
	public WebElement getclickcontactaccnamegrid() throws InterruptedException 
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactaccnamegrid);
	}
	public WebElement getclickcontactphonegrid() throws InterruptedException 
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactphonegrid);
	}
	public WebElement getclickcontactemailgrid() throws InterruptedException 
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactemailgrid);
	}
	public WebElement getclickcontactstategrid() throws InterruptedException 
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactstategrid);
	}
	public WebElement getclickcontactregiongrid() throws InterruptedException 
	{
		Thread.sleep(7000);
		return driver.findElement(clickcontactregiongrid);
	}
	public WebElement getupdateaccountname() throws InterruptedException 
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(updateaccountname));
		//Thread.sleep(5000);
		return driver.findElement(updateaccountname);
	}
	public WebElement getdeleteselectedaccname() throws InterruptedException 
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deleteselectedaccname));
		//Thread.sleep(5000);
		return driver.findElement(deleteselectedaccname);
	}
	public WebElement getaccountnamelookup() throws InterruptedException 
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountnamelookup));
		//Thread.sleep(5000);
		return driver.findElement(accountnamelookup);
	}
	public WebElement getselectaccountname() 
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(selectaccountname));
		return driver.findElement(selectaccountname);
	}
	public WebElement getclickaccnamelookup() 
	{
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(clickaccnamelookup));
		return driver.findElement(clickaccnamelookup);
	}

	public WebElement getnoaudithistory() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(noaudithistory));
		return driver.findElement(noaudithistory);
	}

	public WebElement getDLetterFilterLink() throws InterruptedException {

		Thread.sleep(10000);
		return driver.findElement(dletterfilterlink);
	}

	public WebElement getAuditHistoryRecord() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(audithistoryrecord);
	}
	public WebElement getNewContactHeaderOnContactForm() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newcontactheaderoncontactform));
		return driver.findElement(newcontactheaderoncontactform);
	}
	public WebElement getExportToExcelMoreCmndsBtn() throws InterruptedException {
		Thread.sleep(5000);
		return driver.findElement(exporttoexcelmorecmndsbtn);
	}
	public WebElement getDuplicateRecordsPopupTitle() throws InterruptedException
	{
		Thread.sleep(5000);
		return driver.findElement(duplicaterecordspopuptitle);
	}

	public WebElement getDuplicateRecordsPopupIgnorenSavebtn()
	{
		return driver.findElement(duplicaterecordspopupignorensavebtn);
	}

	public WebElement getDuplicateRecordsPopupCancelbtn()
	{
		return driver.findElement(duplicaterecordspopupcancelbtn);
	}
	public WebElement selectbBeginsWithOptr()
	{
		return driver.findElement(selectbeginswithoptr);
	}
	public WebElement selectbBeginsWithOptrForAccName()
	{
		return driver.findElement(selectbeginswithoptrforaccname);
	}
	
	//CAB-256
	public WebElement getContactStatusNotaValidBuyingAcc() {
		return driver.findElement(contactstatusnotavalidbuyingacc);
	}
	public WebElement getGLetterFilterLink() throws InterruptedException {
		Thread.sleep(10000);
		return driver.findElement(gletterfilterlink);
	}
	public WebElement getInactiveContactStatusNotAValidBuyingAcc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonnotavalidbuyingaccinheader));
		return driver.findElement(contactstatusreason);
	}
	public WebElement getContactStatusNoValidAccInfo() {
		return driver.findElement(contactstatusnovalidaccinfo);
	}
	public WebElement getInactiveContactStatusNoValidAccInfo() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonnovalidaccinfoinheader));
		return driver.findElement(contactstatusreason);
	}
	public WebElement getnolongeracc() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(nolongeracc));
		return driver.findElement(nolongeracc);
	}
	public WebElement getreadonlynotification() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(readonlynotification));
		return driver.findElement(readonlynotification);
	}
	public WebElement getmergedstatusreason() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(mergedstatusreason));
		return driver.findElement(mergedstatusreason);
	}
	public WebElement getbadconinfo() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(badconinfo));
		return driver.findElement(badconinfo);
	}
	public WebElement getstatusreasonmainpage() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(statusreasonmainpage));
		return driver.findElement(statusreasonmainpage);
	}
	public WebElement getcontactalternativeid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactalternativeid));
		return driver.findElement(contactalternativeid);
	}
	public WebElement getaccountatcontact() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(accountatcontact));
		return driver.findElement(accountatcontact);
	}
	public WebElement getjobtitle() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(jobtitle));
		return driver.findElement(jobtitle);
	}
	public WebElement getcontactstatus() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatus));
		return driver.findElement(contactstatus);
	}
	public WebElement getcontactstatusoption() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactstatusoption));
		return driver.findElement(contactstatusoption);
	}
	public WebElement getmarketoption() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(marketoption));
		return driver.findElement(marketoption);
	}
	public WebElement getcontactchannelprofilestab() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactchannelprofilestab));
		return driver.findElement(contactchannelprofilestab);
	}
	public WebElement getmorecommandsforccp() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(morecommandsforccp));
		return driver.findElement(morecommandsforccp);
	}
	public WebElement getdeactivateccp() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivateccp));
		return driver.findElement(deactivateccp);
	}
	public WebElement getdeactivateinccpgrid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(deactivateinccpgrid));
		return driver.findElement(deactivateinccpgrid);
	}
	public WebElement getnewccp() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(newccp));
		return driver.findElement(newccp);
	}
	public WebElement getccpchannel() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ccpchannel));
		return driver.findElement(ccpchannel);
	}
	public WebElement getchannelid() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(channelid));
		return driver.findElement(channelid);
	}
	
	public WebElement getContactAlternativeIdField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactalternativeidfield));
		return driver.findElement(contactalternativeidfield);
	}
	public WebElement getContactAlternativeIdValue() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactalternativeidvalue));
		return driver.findElement(contactalternativeidvalue);
	}
	public WebElement getContactAltIdField() {
		wait = new WebDriverWait (driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(contactaltidfield));
		return driver.findElement(contactaltidfield);
	}
	public WebElement getAllContactsOptn() {
		return driver.findElement(allcontactsoptn);
	}
	
}




