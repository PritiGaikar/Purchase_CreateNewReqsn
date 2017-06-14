package Purchase;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentReports;

import common_Function.RW;

public class CreateNewRequisition extends RW{

	private static ExtentReports report;
	public synchronized static ExtentReports getReporter(String filePath) { 
	    if (report == null) {
	        report = new ExtentReports(path.concat("Report.html"));
	       // String path="C:\\Users\\Reshma\\workspace\\JibeAutomation\\" 
	        report
	            .addSystemInfo("Host Name", "Reshma") 
	            .addSystemInfo("Environment", "QA");
	    }
	    
	    return report;
	}
	
	//Purchase-->Create New Requisition 
	public String createnewreqM(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		driver.get("http://192.168.1.102/JIBE/purchase/InvertyItems.aspx");
		Thread.sleep(5000);

	//Verifying Expected page is open or not
		
		String actualTitle = driver.getTitle().trim();
		Thread.sleep(2000);
		
		String expectedTitle = "	Create New Requisition".trim();
		Thread.sleep(2000);
		assertEquals(expectedTitle,actualTitle);	
	
		if(actualTitle.equals(expectedTitle)){
	    	  System.out.println("Title match");
	    	
	    }
	        else {
	        	System.out.println("Title does not matches");
	        }
		return (expectedTitle);
		  
	}
	
	
	
	public void createnewreq(WebDriver driver1) throws Exception {

		WebDriver driver = driver1;

		// Select "PO Type" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlPOType']", "Agency");
		Thread.sleep(3000);

		// Select "Reqsn Type" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlReqsnType']", "Service");
		Thread.sleep(3000);

		// Select "Fleet" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_DDLFleet']", "Fleet-A");
		Thread.sleep(3000);

		
		// Select "Vessel" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlVessel']", "IMARA");
		Thread.sleep(3000);

		// Enter "Requisition Reason"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtReqnReason']", "abcd");
		Thread.sleep(3000);

		// Select "Department/Function" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlFunction']", "1 Service Function shail test");
		Thread.sleep(3000);

		// Select "Catalogue/System" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlCatalogue']", "Imara system for service shail");
		Thread.sleep(3000);

		// Select "Account Type" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlAccountType']", "Lay_up");
		Thread.sleep(3000);

		// Select "Urgency" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlUrgency']", "Urgent");
		Thread.sleep(3000);

		// Click on "Create New Requisition"
		click_element(driver, "id", "ctl00_MainContent_btnRequisition");
		Thread.sleep(3000);
	}
	
	public void EditRequisition(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
	
		// Select "Requisition" DropDown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_ddlRequisitionList']", "01-06-2017 / Shailesh / Immediate");
		Thread.sleep(5000);
		
		//click on "Edit Requisition"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnEdit']");
		Thread.sleep(3000);
		
	
	}
	public void RequisitionItems(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
	
		// Window handling Function

		for (String handle : driver.getWindowHandles()) {

			driver.switchTo().window(handle);
		}
		Thread.sleep(4000);
	
		// Select on "Sub-catalogues"-->All

		// clear Textbox
		clear_element(driver, "xpath", ".//*[@id='txtgrdItemReqstdQty']");
		Thread.sleep(3000);

		// Change Reqst Qty
		sendkeys(driver, "xpath", ".//*[@id='txtgrdItemReqstdQty']", "2");
		Thread.sleep(3000);
		
		//click on save button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnSave']");
		Thread.sleep(3000);
		
		// Alert of "items"
		Alert items = driver.switchTo().alert();
		// To read the text from alert
		String Alert = items.getText();
		System.out.println(" alert of save:" + Alert);
		Thread.sleep(2000);
		items.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		// Select on "Sub-catalogues"-->General
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rgdSubCatalog_ctl00__1']/td");
		Thread.sleep(3000);

	}
	
	public void AddItems(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		// Click on "Add Items" Button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnAdd']");
		Thread.sleep(3000);
		
		//Enter "Drawing Number"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtDrawingNumber']", "13");
		Thread.sleep(3000);
		
		
		//************************* Alert capturing ********************************//
		
		
		                                     // Alert of part number
		//click on save & close button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_DivItembtnSave']");
		Thread.sleep(3000);
		
		// Alert of "Part number"
		Alert Partnumber = driver.switchTo().alert();
		// To read the text from alert
		String Alertpub = Partnumber.getText();
		System.out.println(" alert of Part number:" + Alertpub);
		Thread.sleep(2000);
		Partnumber.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//Enter "Part number"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtPartnumber']", "13");
		Thread.sleep(3000);
		
		
		                           // Alert of "items" fields
		//click on save & close button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_DivItembtnSave']");
		Thread.sleep(3000);
		
		// Alert of "items"
		Alert items = driver.switchTo().alert();
		// To read the text from alert
		String Alert = items.getText();
		System.out.println(" alert of Items:" + Alert);
		Thread.sleep(2000);
		items.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		//Enter "Items"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtShortDescription']", "test");
		Thread.sleep(3000);

		                               // Alert of "units" fields
		// click on save & close button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_DivItembtnSave']");
		Thread.sleep(3000);

		// Alert of "Part number"
		Alert Unit   = driver.switchTo().alert();
		// To read the text from alert
		String Alert2 = Unit  .getText();
		System.out.println(" alert of Units:" + Alert2);
		Thread.sleep(2000);
		Unit  .accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);

		// Select "Unit" Dropdown
		dropdown(driver, "xpath", ".//*[@id='ctl00_MainContent_cmbUnitnPackage']", "BAG");
		Thread.sleep(1000);
				
		//Enter "Long Description"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtLongDescription']", "Automation Tester1");
		Thread.sleep(3000);
		
		//click on save& close  button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_DivItembtnSave']");
		Thread.sleep(3000);
		
		
	}
	
		public void Search(WebDriver driver1) throws Exception {  

			WebDriver driver = driver1;	
	
			
		// click on "Sub-catalogue--->All"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rgdSubCatalog_ctl00__0']/td");
		Thread.sleep(3000);
		
		// Enter "Description"
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtSrchDesc']", "test");
		Thread.sleep(3000);
		
		//Enter "Part No."
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_txtSrchPartNo']", "13");
		Thread.sleep(3000);
		
		//click on "Search"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnItemSearch']");
		Thread.sleep(3000);
		
		// clear Textbox
		clear_element(driver, "xpath", ".//*[@id='txtgrdItemReqstdQty']");
		Thread.sleep(3000);

		// Change Reqst Qty
		sendkeys(driver, "xpath", ".//*[@id='txtgrdItemReqstdQty']", "2");
		Thread.sleep(3000);
				
	
		//Click on "Preview and finalize"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnPreview']");
		Thread.sleep(3000);
			
	}
		
	public void Edititems(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		// Click on "Edit"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rptMain_ctl01_rptChild_ctl01_ImgUpdate']");
		Thread.sleep(3000);
		
		//Clear "Requested Qty" Textbox
		clear_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rptMain_ctl01_rptChild_ctl01_txtQnty']");
		Thread.sleep(3000);
		
		//Enter "Requested Qty" 
		sendkeys(driver, "xpath", ".//*[@id='ctl00_MainContent_rptMain_ctl01_rptChild_ctl01_txtQnty']", "2");
		Thread.sleep(3000);
		
		//click on "save" button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rptMain_ctl01_rptChild_ctl01_btnUpdate']");
		Thread.sleep(3000);
		
		//click on Delete Button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_rptMain_ctl01_rptChild_ctl01_ImgDelete']");
		Thread.sleep(3000);
		
		// Alert of "Delete Actions"
		Alert DeleteActions = driver.switchTo().alert();
		// To read the text from alert
		String Alert2 = DeleteActions.getText();
		System.out.println(" alert :" + Alert2);
		Thread.sleep(2000);
		DeleteActions.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
		

		// Alert of "Delete Actions"
		Alert DeleteActions1 = driver.switchTo().alert();
		// To read the text from alert
		String Alert3 = DeleteActions1.getText();
		System.out.println(" alert :" + Alert3);
		Thread.sleep(2000);
		DeleteActions1.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(2000);
	}
	
	public void PurchaseQuestionnaire(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
		
		// Select "Item Quality last time purchased?"
		dropdown(driver, "name", "ctl00$MainContent$grdQuestion$ctl02$ddlAnswers", "Average");
		Thread.sleep(2000);

		// Select "Test Repair Type"
		dropdown(driver, "name", "ctl00$MainContent$grdQuestion$ctl04$ddlAnswers", "Y");
		Thread.sleep(3000);

		// Enter "Port Query for Repair"
		sendkeys(driver, "xpath", ".//*[@id='txtDescriptive']", "test");
		Thread.sleep(5000);
		
	
	}
	
	public void WorklistJobs(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;
	
	// click on "Worklist Jobs"
	click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_BtnJob']");
	Thread.sleep(3000);
	
	// switch to "Add attachment frame"
	WebElement iframe = driver.findElement(By.id("Assign_Worklist"));
	driver.switchTo().frame(iframe);
	Thread.sleep(3000);
	
	// Enter "Search (Worklist ID,Job Description)"
	sendkeys(driver, "xpath", ".//*[@id='txtSearch']", "test");
	Thread.sleep(3000);
	
	//Select "O-53" Worklist ID
	click_element(driver, "xpath", ".//*[@id='grdAddWorklistInvolved_ctl04_checkRow']");
	Thread.sleep(3000);
	
	//Select "O-40" Worklist ID
	click_element(driver, "xpath", ".//*[@id='grdAddWorklistInvolved_ctl04_checkRow']");
	Thread.sleep(3000);
	
	//Click on "Add selected" button
	click_element(driver, "xpath", ".//*[@id='btnAdd']");
	Thread.sleep(3000);
	
	//Click on "Close Popup" button
	click_element(driver, "xpath", ".//*[@id='btnAdd']");
	Thread.sleep(3000);
	}
	
	public void Attachement(WebDriver driver1) throws Exception {  

		WebDriver driver = driver1;

		//Click on "AddAttachment"
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnid']");
		Thread.sleep(3000);

	
		// upload button
		driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_AjaxFileUpload2_Html5InputFile']")).sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Penguins.jpg");
		Thread.sleep(3000);
		
		//click on upload button
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_AjaxFileUpload2_UploadOrCancelButton']");
		Thread.sleep(3000);
		
		//Click on "Close popup"
		click_element(driver, "xpath", ".//*[@id='closePopupbutton']");
		Thread.sleep(3000);
		
		//Click on "Finalize" Button	
		click_element(driver, "xpath", ".//*[@id='ctl00_MainContent_btnFinalize']");
		Thread.sleep(3000);	
			
		// Alert of "RequisitionSave"
		Alert RequisitionSave = driver.switchTo().alert();
		// To read the text from alert
		String Alert2 = RequisitionSave.getText();
		System.out.println(" alert :" + Alert2);
		Thread.sleep(2000);
		RequisitionSave.accept();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(6000);
	}
	
	
		
		
		}
		
		
					
		

