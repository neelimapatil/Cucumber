package EJ.MODULES;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import EJ.generic.HTMLReportGenerator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ManageCompany extends Config {

	
	@When("^user clicks on Financial Analysis link$")
	
	//clicks on financial analysis link
	public void ClickonFinAnaLink() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		try
		{
		// String strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath("//div[contains(text(),'Financial Analysis')]/parent::div"));
			String strVar = objLink.getAttribute("class");
			System.out.println(strVar);
			if (strVar.contains("selected"))
			{
				;
			}	
			else
			{
				objLink=ExplicitWait.WaitForObjectExist("//div[contains(text(),'Financial Analysis')]/following-sibling::div"); //("//div[contains(text(),'Financial Analysis')]/following-sibling::div");
				objLink.click();
			}
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickonFinAnaLink,Parmeters:=,Note:Clicked on Financial Analysis link successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonFinAnaLink");
			}
			HTMLReportGenerator.StepDetails("PASS", "ClickonFinAnaLink", "Clicked on Financial Analysis link successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=VerifyLogoutLink,Parmeters:=,Note:Unable to clicked on Financial Analysis link successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonFinAnaLink");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickonFinAnaLink", "Unable to clicked clicked on Financial Analysis link successfully", strScreenShotFileName);
		}
		
	}
	@And ("^user clicks on Company link$")
	
	//clicks on company
	public void ClickonCompanyLink() throws IOException
	{
		
		Login objLogin = new Login();
	    
	    try
		{
	    	String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
	    	WebElement objLink=ExplicitWait.WaitForObjectExist(strReadValue);
	    	String strVar = objLink.getAttribute("class");
	    	System.out.println(strVar);
	    	if (strVar.contains("expanded"))
	    	{
	    		;
	    	}	
	    	else
	    	{
	    		objLink=ExplicitWait.WaitForObjectExist(strReadValue);//("//*[@id='_easyui_tree_1']//child::span[1]");
	    		objLink.click();
	    	}
	    	strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickonCompanyLink,Parmeters:=,Note:Clicked on Company link successfully";
	    	logger.info(strOp);
	    	if(isCaptureScreenShotEnabled==true) {
	    		Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonCompanyLink");
	    	}
	    	HTMLReportGenerator.StepDetails("PASS", "ClickonCompanyLink", "Clicked on Company link successfully", strScreenShotFileName);	
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=ClickonCompanyLink,Parmeters:=,Note:Unable to clicked on Company link successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonCompanyLink");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickonCompanyLink", "Unable to clicked clicked on Company link successfully", strScreenShotFileName);
		}
		
	}
	@And("^user clicks on Manage Company link$")
	
	//clicks on manage company
	public void ClickonManageCompanyLink() throws IOException
	{
		Login objLogin = new Login();
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
			objLink.click();
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickonManageCompanyLink,Parmeters:=,Note:Clicked on Manage Company link successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonManageCompanyLink");
		}
			HTMLReportGenerator.StepDetails("PASS", "ClickonManageCompanyLink", "Clicked on Manage Company link successfully", strScreenShotFileName);	
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=ClickonManageCompanyLink,Parmeters:=,Note:Unable to clicked on Manage Company link successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonManageCompanyLink");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickonManageCompanyLink", "Unable to clicked clicked on Manage Company link successfully", strScreenShotFileName);
		}
	}
	@When("^user clicks on New button$")
	 //When user clicks on New button
	public void ClickonNewButton() throws InterruptedException, IOException
	{
		Login objLogin = new Login();

		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_NEW_BUTTON", "OR.properties");
			Thread.sleep(2000);
			Login.driver.switchTo().frame(0);
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
			objLink.click();
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickonNewButton,Parmeters:=,Note:Clicked on New Button successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonNewButton");
		}
			HTMLReportGenerator.StepDetails("PASS", "ClickonNewButton", "Clicked on New Button successfully", strScreenShotFileName);	
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=ClickonNewButton,Parmeters:=,Note:Unable to clicked on New Button successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickonNewButton");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickonNewButton", "Unable to clicked clicked on New Button successfully", strScreenShotFileName);
		}
	}
	
	@And("User enters Company name as \"(.*)\"$")
	//And User enters Company name as "Neelima"
	public void EnterComName(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(2000);
		Login objLogin = new Login();
		
	   /* String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_NAME", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
	    strReadValue=objLogin.GetParameterValue_again("COMPANY_NAME", "parameter.properties");
		//("//td[contains(text(), 'Company Name')]/following-sibling::td[1]//child::input");
		objLink.sendKeys(strName);*/

		try
		{
			UUID uuid = UUID.randomUUID();
			String uniqueID = uuid.toString();
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_NAME", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
		//WebElement objLink=ExplicitWait.WaitForObjectExist(OBJ_COMPANY_NAME);
			objLink.sendKeys(uniqueID);
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterComName,Parmeters:=,Note:Entered Company Name successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterComName");
		}
			HTMLReportGenerator.StepDetails("PASS", "EnterComName", "Entered Company Name successfully", strScreenShotFileName);	
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterComName,Parmeters:=,Note:Unable to Enter Company Name";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterComName");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterComName", "Unable to Enter Company Name", strScreenShotFileName);
		}
	}
	
	@And("^User selects Company type as \"(.*)\"$")
	//And User selects Company type as "IT"
	public void SelectComType(String strName) throws IOException
	{
		Login objLogin = new Login();
		
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_TYPE", "OR.properties");
			WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@id='companytype']");
			Select objDashBoard = new Select(objDropDown);
			strReadValue=objLogin.GetParameterValue_again("COMPANY_TYPE", "parameter.properties");
			objDashBoard.selectByVisibleText(strName);
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=SelectComType,Parmeters:=,Note:Entered Company type successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "SelectComType");
		}
			HTMLReportGenerator.StepDetails("PASS", "SelectComType", "Entered Company type successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectComType,Parmeters:=,Note:Unable to Enter Company type";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "SelectComType");
			}
			HTMLReportGenerator.StepDetails("FAIL", "SelectComType", "Unable to Enter Company type", strScreenShotFileName);
		}
	}
	@And("^User Company Subtype as \"(.*)\"$")
	//And User Company Subtype as "Support"
	public void SelectCComSubType(String strName) throws IOException, InterruptedException
	{
		Login objLogin = new Login();
		Thread.sleep(2000);
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_SUBTYPE", "OR.properties");
			WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='subtype']");
			Select objDashBoard = new Select(objDropDown);
			strReadValue=objLogin.GetParameterValue_again("COMPANY_SUBTYPE", "parameter.properties");
			objDashBoard.selectByVisibleText(strName);
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=SelectCComSubType,Parmeters:=,Note:Entered Company subtype successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCComSubType");
		}
			HTMLReportGenerator.StepDetails("PASS", "SelectCComSubType", "Entered Company subtype successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectCComSubType,Parmeters:=,Note:Unable to Enter Company subtype";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCComSubType");
			}
			HTMLReportGenerator.StepDetails("FAIL", "SelectCComSubType", "Unable to Enter Company subtype", strScreenShotFileName);
		}
	}	
	@And("^User enters Address as \"(.*)\"$")
	
	//And User enters Address as "Pune"
	public void EnterAddress(String strName) throws IOException
	{
		Login objLogin = new Login();
		try
		{
			String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_ADDRESS", "OR.properties");
			WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));
		//("//input[@textboxname='address']//following-sibling::span[1]//child::textarea");
			strReadValue=objLogin.GetParameterValue_again("COMPANY_ADDRESS", "parameter.properties");
			objLink.sendKeys(strName);
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterAddress,Parmeters:=,Note:Entered Address successfully";
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterAddress");
		}
			HTMLReportGenerator.StepDetails("PASS", "EnterAddress", "Entered Address successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectCComSubType,Parmeters:=,Note:Unable to Enter Address";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterAddress");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterAddress", "Unable to Enter Address", strScreenShotFileName);
		}
	}
	@And("^User enters Phone as \"(.*)\"$")
	//And User enters Phone as "0123456789"
	public void EnterPhone(String strName) throws IOException
	{
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_PHONE", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='phone']//following-sibling::span[1]//child::input");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PHONE", "parameter.properties");
		objLink.sendKeys(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterPhone,Parmeters:=,Note:Entered Phone successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPhone");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterPhone", "Entered Phone successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterPhone,Parmeters:=,Note:Unable to Enter Phone";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPhone");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterPhone", "Unable to Enter Phone", strScreenShotFileName);
		}	
	}
	@And("^User enters Email as \"(.*)\"$")
	//And User enters Email as "abcdef@gmail.com"
	public void EnterEmail(String strName) throws IOException
	{
		/*Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_EMAIL", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='email']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_EMAIL", "parameter.properties");
		objLink.sendKeys(strName);	*/
		try
		{
		String random = String.valueOf(3 < 1 ? 0 : new Random().nextInt((9 * (int) Math.pow(10, 3 - 1)) - 1)
	            + (int) Math.pow(10, 3 - 1));
		String email = "username" + random + "@mail.com";
		Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_EMAIL", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='email']");
		objLink.sendKeys(email);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterEmail,Parmeters:=,Note:Entered Email successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterEmail");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterEmail", "Entered Email successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterEmail,Parmeters:=,Note:Unable to Enter Email";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterEmail");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterEmail", "Unable to Enter Email", strScreenShotFileName);
		}	

	}
	@And("^User enters Pan Details as \"(.*)\"$")
	//And User enters Pan Details as "ARPPT3211265498"
	public void EnterPan(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_PAN", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='pan']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_PAN", "parameter.properties");
		objLink.sendKeys(strName);	
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterPan,Parmeters:=,Note:Entered Pan successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPan");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterPan", "Entered Pan successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterPan,Parmeters:=,Note:Unable to Enter Pan";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPan");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterPan", "Unable to Pan Email", strScreenShotFileName);
		}	
	}
	@And("^User enters Tin details as \"(.*)\"$")
	//And User enters Tin details as "32165432165487"
	public void EnterTin(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_TIN", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='tin']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_TIN", "parameter.properties");
		objLink.sendKeys(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterTin,Parmeters:=,Note:Entered Tin successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterTin");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterTin", "Entered Tin successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterTin,Parmeters:=,Note:Unable to Enter Tin";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterTin");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterTin", "Unable to enter Tin", strScreenShotFileName);
		}	
	}
	@And("^User enters Mobile Details as \"(.*)\"$")
	//And User enters Mobile Details as "8765567890"
	public void EnterMobile(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_MOBILE", "OR.properties");
		WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='mobile']//following-sibling::span[1]//child::input");
		 strReadValue=objLogin.GetParameterValue_again("COMPANY_MOBILE", "parameter.properties");
		objLink.sendKeys(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterMobile,Parmeters:=,Note:Entered Mobile successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterMobile");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterMobile", "Entered Mobile successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterMobile,Parmeters:=,Note:Unable to Enter Mobile";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterMobile");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterMobile", "Unable to enter Mobile", strScreenShotFileName);
		}
	}
	@And("^User enters Website details as \"(.*)\"$")
	//And User enters Website details as "testingt.com"
	public void EnterWebsite(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_WEBSITE", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@name='website']");
		strReadValue=objLogin.GetParameterValue_again("COMPANY_WEBSITE", "parameter.properties");
		objLink.sendKeys(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterWebsite,Parmeters:=,Note:Entered website successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterWebsite");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterWebsite", "Entered website successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterWebsite,Parmeters:=,Note:Unable to Enter website";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterWebsite");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterWebsite", "Unable to enter website", strScreenShotFileName);
		}
	}
	@And("^User enters Country as \"(.*)\"$")
	//And User enters Country as "INDIA"
	public void SelectCountry(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_COUNTRY", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='countryname']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("COUNTRY", "parameter.properties");
		objDashBoard.selectByVisibleText(strReadValue);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=SelectCountry,Parmeters:=,Note:Selected country successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCountry");
	}
		HTMLReportGenerator.StepDetails("PASS", "SelectCountry", "Selected country successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectCountry,Parmeters:=,Note:Unable to Select country";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCountry");
			}
			HTMLReportGenerator.StepDetails("FAIL", "SelectCountry", "Unable to Select country", strScreenShotFileName);
		}
	}
	@And("^User enters State as \"(.*)\"$")
	//And User enters State as "MAHARASHTRA"
	public void SelectState(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_STATE", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='state']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("STATE", "parameter.properties");
		objDashBoard.selectByVisibleText(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=SelectState,Parmeters:=,Note:Selected state successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "SelectState");
	}
		HTMLReportGenerator.StepDetails("PASS", "SelectState", "Selected state successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectState,Parmeters:=,Note:Unable to Select state";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "SelectState");
			}
			HTMLReportGenerator.StepDetails("FAIL", "SelectState", "Unable to Select state", strScreenShotFileName);
		}
	}
	@And("^User enters City name as \"(.*)\"$")
	
	public void SelectCity(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_CITY", "OR.properties");
	    WebElement objDropDown=Login.driver.findElement(By.xpath(strReadValue));//("//select[@name='city']");
		Select objDashBoard = new Select(objDropDown);
		strReadValue=objLogin.GetParameterValue_again("CITY", "parameter.properties");
		objDashBoard.selectByVisibleText(strName);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=SelectCity,Parmeters:=,Note:Selected city successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCity");
	}
		HTMLReportGenerator.StepDetails("PASS", "SelectCity", "Selected city successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=SelectCity,Parmeters:=,Note:Unable to Select city";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "SelectCity");
			}
			HTMLReportGenerator.StepDetails("FAIL", "SelectCity", "Unable to Select city", strScreenShotFileName);
		}
	}
	@And("^User enters Total Employee as \"(.*)\"$")
	//And User enters Total Employee as "1"
	public void EnterTotalEmp(String strName) throws IOException, InterruptedException
	{
		Thread.sleep(1000);
		Login objLogin = new Login();
		try
		{
		String strReadValue=objLogin.GetParameterValue_again("OBJ_TOTAL_EMPLOYEE", "OR.properties");
	    WebElement objLink=Login.driver.findElement(By.xpath(strReadValue));//("//input[@textboxname='totalemployee']//following-sibling::span[1]//child::input");
		strReadValue=objLogin.GetParameterValue_again("TOTAL_EMPLOYEE", "parameter.properties");
		objLink.sendKeys(strReadValue);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterTotalEmp,Parmeters:=,Note:Entered Total Emp No successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "EnterTotalEmp");
	}
		HTMLReportGenerator.StepDetails("PASS", "EnterTotalEmp", "Entered Total Emp No successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterTotalEmp,Parmeters:=,Note:Unable to enter Total Emp No";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterTotalEmp");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterTotalEmp", "Unable to Total enter Emp No", strScreenShotFileName);
		}
	}
	@Then("^User should get tooltip to enter mandatory field$")
	
	@And("^User clicks on Save button$")
	//And User clicks on Save button
	public void ClickOnSaveButton() throws IOException
	{
		Login objLogin = new Login();
		try
		{
	    String strReadValue=objLogin.GetParameterValue_again("OBJ_SAVE_BUTTON", "OR.properties");
		WebElement objButton=Login.driver.findElement(By.xpath(strReadValue));
		objButton.click();
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterTotalEmp,Parmeters:=,Note:Clicked Save button successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
		Config.CaptureScreenshot(strScreenShotFolderPath, "ClickOnSaveButton");
	}
		HTMLReportGenerator.StepDetails("PASS", "ClickOnSaveButton", "Clicked Save button successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=ClickOnSaveButton,Parmeters:=,Note:Unable to click Save button";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickOnSaveButton");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickOnSaveButton", "Unable to click Save button", strScreenShotFileName);
		}
	}
	public static void main(String[] args) throws Exception
	{
		Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("BROWSER_NAME", "parameter.properties");
		Login.OpenBrowser(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("APPLICATION_URL", "parameter.properties");
		objLogin.EnterURL(strReadValue);
	    strReadValue=objLogin.GetParameterValue_again("USERNAME", "parameter.properties");
		objLogin.EnterUserName(strReadValue);
	    strReadValue=objLogin.GetParameterValue_again("PASSWORD", "parameter.properties");
		objLogin.EnterPassword(strReadValue);
		strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
		objLogin.ClickLoginButton();
		ManageCompany objCom = new ManageCompany();
		
Thread.sleep(2000);		
		strReadValue=objLogin.GetParameterValue_again("OBJ_FINANCIAL_ANALYSIS_LINK", "OR.properties");
		objCom.ClickonFinAnaLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_COMPANY_LINK", "OR.properties");
		objCom.ClickonCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_MANAGE_COMPANY_LINK", "OR.properties");
		objCom.ClickonManageCompanyLink();
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_NEW_BUTTON", "OR.properties");
		objCom.ClickonNewButton();
		
		
		strReadValue=objLogin.GetParameterValue_again("OBJ_SAVE_BUTTON", "OR.properties");
		//objCom.ClickOnSaveButton();
	}
}
