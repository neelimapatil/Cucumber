package EJ.MODULES;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.xpath.XPathExpressionException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import EJ.CONFIG.CONFIGURATION;
import EJ.GENRICFUNCTIONS.ExcelOperations;
import EJ.GENRICFUNCTIONS.GenericFunctions;
import EJ.GENRICFUNCTIONS.HTMLReportGenerator;
import EJ.GENRICFUNCTIONS.ScreenshotCapture;
import EJ.GENRICFUNCTIONS.XMLOperations;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@SuppressWarnings("unused")
public class MANAGECOMPANY extends CONFIGURATION{
	
	LOGIN login = new LOGIN();	
	
	
	public JSONArray CompList = null;
	public JSONObject jasonobj = null;
	public int recordCounter  = 0;
	public int jasonCounter = 0;
	public XSSFSheet sheet = null;

	@When("^user click on Manage Company link$")
	public void ClickOnMangeCompanyLink() throws InterruptedException, XPathExpressionException, IOException
	{
		//"//span/a[contains(text(),'Manage Company')]"
		Thread.sleep(2000);
		//xmlxpath.xpathfile.read();
		try
		{
			String path = CONFIGURATION.xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='managecomp_lnk']/text()",0);
			//String path = "//a[contains(text(),'Manage Company')]";
			WebElement btn = driver.findElement(By.xpath(path));
			btn.click();
			Thread.sleep(2000);
			
			 if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOnMangeCompanyLink", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ClickOnMangeCompanyLink User click on Manage Company link";
			 }
			HTMLReportGenerator.StepDetails("PASS", "Click On Manage Company Link", "User click on Manage Company link",login.screen_loc);				
		}
		catch(Exception e)
		{
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ClickOnMangeCompanyLink Exception occured"+e.getMessage();	
				 logger.info(output);	
			 }
			 HTMLReportGenerator.StepDetails("FAIL", "Click On Manage Company Link", "User is not able to click on Manage Company link",login.screen_loc);
		}
		}
	@And("^user click on New button$")
		public void ClickOnNewButton() throws Exception
		{
		try
		{
			//"//span/a[contains(text(),'Manage Company')]"
			//Thread.sleep(2000);
				String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='new_btn']/text()",0);
				WebElement btn = driver.findElement(By.xpath(path));
				btn.click();
				Thread.sleep(2000);
				
				 if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOnNewButton", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ClickOnNewButton User click on new button";
				 }
				HTMLReportGenerator.StepDetails("PASS", "Click On New Button", "User click on new button",login.screen_loc);
		}
			catch(Exception e)
			{
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOnNewButton", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ClickOnNewButton Exception occured"+e.getMessage();	
					 logger.info(output);	
				 }
				 HTMLReportGenerator.StepDetails("FAIL", "Click On New Button", "User was not able to click on new button",login.screen_loc);
			}
		}
		@And("^user enter company name as \"(.*)\"$")
	public void EnterCompanyNameValueInTextbox(String value) throws Exception
	{
		try
		{
		//WebDriver driver =null;
		String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_name_txt']/text()",0);
		if(value.equals("[random]")){
			value = GenericFunctions.GenearteUniqueString(15);
		}
		else if(value.equals("JSON.CompanyName"))
		{
			String[] str = value.split("\\.");
			System.out.println(str[0]);
			System.out.println("wait");
			value = parseCompNameObject(CompList,str[1]);
		}
		
		driver.findElement(By.xpath(path)).sendKeys(value);
		Thread.sleep(2000);
		
		if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
			 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterCompanyNameValueInTextbox", screenshotfoldername);}
		 if(((IS_LOG_ENABLED).trim()).equals(yes))
		 {
			 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterCompanyNameValueInTextbox User enters value in Company Name Textbox";
			 logger.info(output);	
		 }
		HTMLReportGenerator.StepDetails("PASS", "Click On New Button", "User click on new button",login.screen_loc);
		
		}
		catch(Exception e)
		{
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterCompanyNameValueInTextbox", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterCompanyNameValueInTextbox Exception occured"+e.getMessage();	
				 logger.info(output);	
			 }
			 HTMLReportGenerator.StepDetails("FAIL", "Enter Company Name Value In Textbox", "User was not able add value in Company Name Textbox",login.screen_loc);
		}
	}
	
	
	@And("^user  select company type as \"(.*)\"$")	
		public void SelectCompanyTypeValueFromDropdown(String selectval) throws Exception
		{
		try
		{
			
			if(selectval.equals("JSON.CompanyType"))
			{
				String[] str = selectval.split("\\.");
				System.out.println(str[0]);
				System.out.println("wait");
				selectval = parseCompNameObject(CompList,str[1]);
			}
			
			String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_type_lst']/text()",0);
			Select drpCountry = new Select(driver.findElement(By.xpath(path)));
			drpCountry.selectByVisibleText(selectval);
			Thread.sleep(5000);
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCompanyTypeValueFromDropdown", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SelectCompanyTypeValueFromDropdown User selects Company type as "+selectval;
				 logger.info(output);	
			 }
			HTMLReportGenerator.StepDetails("PASS", "Select Company Type Value From Dropdown", "User selects Company type as "+selectval,login.screen_loc);
			
			}
			catch(Exception e)
			{
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCompanyTypeValueFromDropdown", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectCompanyTypeValueFromDropdown Exception occured"+e.getMessage();	
					 logger.info(output);	
				 }
				 HTMLReportGenerator.StepDetails("FAIL","Select Company Type Value From Dropdown", "User couldnot select Company type as "+selectval,login.screen_loc);
			}
		}
		@And("^user  select company subtype as \"(.*)\"$")
				public void SelectSubTypeValueFromDropdown(String selectval) throws Exception
				{
					try
					{
						if(selectval.equals("JSON.CompanySubType"))
						{
							String[] str = selectval.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							selectval = parseCompNameObject(CompList,str[1]);
						}
						
					String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_subtype_lst']/text()",0);
					Select drpCountry = new Select(driver.findElement(By.xpath(path)));
					drpCountry.selectByVisibleText(selectval);
					Thread.sleep(2000);
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectSubTypeValueFromDropdown", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SelectSubTypeValueFromDropdown User  select company subtype as "+selectval;
						 logger.info(output);	
					 }
					HTMLReportGenerator.StepDetails("PASS", "Select Sub Type Value From Dropdown", "User  select company subtype as "+selectval,login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectSubTypeValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectSubTypeValueFromDropdown Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Select Sub Type Value From Dropdown", "User couldnot select Company type as "+selectval,login.screen_loc);
					}
				}
		
				@And("^user  enter phone number as \"(.*)\"$")
				public void EnterPhoneValueInTextbox( String value) throws Exception
				{
					try
					{				
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_phone_txt']/text()",0);
						if(value.equals("[random]")){
							value = GenericFunctions.GenerateRandomNumber(10);
						}
						else if(value.equals("JSON.PhoneNo"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterPhoneValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterPhoneValueInTextbox User  enter phone number as "+value;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Enter Phone Value In Textbox", "User  enter phone number as "+value,login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterPhoneValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterPhoneValueInTextbox Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Enter Phone Value In Textbox", "User cannot enter phone number as "+value,login.screen_loc);
					}
					
				}
				
				@And("^user  enter address as \"(.*)\"$")
				public void EnterAddressValueInTextbox(String value) throws Exception
				{
					try
					{
					//WebDriver driver =null;
					String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_address_txtarea']/text()",0);
					if(value.equals("[random]")){
						value = GenericFunctions.GenearteUniqueString(20);
					}
					else if(value.equals("JSON.Address"))
					{
						String[] str = value.split("\\.");
						System.out.println(str[0]);
						System.out.println("wait");
						value = parseCompNameObject(CompList,str[1]);
					}
					
					driver.findElement(By.xpath(path)).sendKeys(value);		
					Thread.sleep(2000);
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterAddressValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterAddressValueInTextbox User  enter address as "+value;
						 logger.info(output);	
					 }
					HTMLReportGenerator.StepDetails("PASS", "Enter Address Value In Textbox",  "User enter address as "+value,login.screen_loc);
				
				}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterAddressValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterAddressValueInTextbox Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Address Value In Textbox",  "User couldnot enter address as "+value,login.screen_loc);
				}
				}
				@And("^user  enter email as \"(.*)\"$")
				public void EnterEmailValueInTextbox( String value) throws Exception
				{
					try
					{
						//WebDriver driver =null;
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_email_txt']/text()",0);
						if(value.equals("[random]")){
							value = GenericFunctions.GenearteUniqueString(10)+"@gmail.com";
						}
						else if(value.equals("JSON.Email"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterEmailValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterEmailValueInTextbox User  enter email as "+value;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Enter Email Value In Textbox",  "User  enter email as "+value,login.screen_loc);
					
				}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterEmailValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterEmailValueInTextbox Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Email Value In Textbox",  "User  enter email as "+value,login.screen_loc);
				}
				}
				
				@And("^user  enter pan details as \"(.*)\"$")
				public void EnterPanValueInTextbox( String value) throws Exception
				{
					try
					{
						if(value.equals("JSON.PAN"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						
					//WebDriver driver =null;
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_pan_txt']/text()",0);
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterPanValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterPanValueInTextbox User  enter pan details as "+value;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Enter Pan Value In Textbox",  "User  enter pan details as "+value,login.screen_loc);
					
					}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterPanValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterPanValueInTextbox Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Pan Value In Textbox",  "User  enter pan details as "+value,login.screen_loc);
				}
			}
				
				@And("^user  enter tin details as \"(.*)\"$")
				public void EnterTinValueInTextbox(String value) throws Exception
				{
					try
					{
						
					//WebDriver driver =null;
						if(value.equals("JSON.TIN"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_tin_txt']/text()",0);
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterTinValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterTinValueInTextbox User  enter tin details as "+value;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Enter Tin Value In Textbox",  "User  enter tin details as "+value,login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterTinValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterTinValueInTextbox Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Enter Tin Value In Textbox",  "User  enter tin details as "+value,login.screen_loc);
					}
				}
				
				@And("^user  enter mobile as \"(.*)\"$")
				public void EnterMobileValueInTextbox( String value) throws Exception
				{
					
					//WebDriver driver =null;
					try
					{
						if(value.equals("JSON.MobileMo"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_mobile_txt']/text()",0);
					driver.findElement(By.xpath(path)).sendKeys(value);		
					Thread.sleep(2000);
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterMobileValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterMobileValueInTextbox User  enter mobile as "+value;
						 logger.info(output);	
					 }
					HTMLReportGenerator.StepDetails("PASS", "Enter Mobile Value In Textbox",  "User  enter mobile as "+value,login.screen_loc);
				
				}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterMobileValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterMobileValueInTextbox Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Mobile Value In Textbox",  "User  enter mobile as "+value,login.screen_loc);
				}
				}
				
				@And("^user  enter website as \"(.*)\"$")
				public void EnterWebsiteValueInTextbox( String value) throws Exception
				{
					try
					{
					//WebDriver driver =null;
						if(value.equals("JSON.Website"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_website_txt']/text()",0);
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterWebsiteValueInTextbox", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterWebsiteValueInTextbox User  enter website as "+value;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Enter Website Value In Textbox",  "User  enter website as "+value,login.screen_loc);
					
				}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterWebsiteValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=EnterWebsiteValueInTextbox Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Website Value In Textbox",  "User  enter website as "+value,login.screen_loc);
				}
				}
								
				@And("^user  select country as \"(.*)\"$")
				public void SelectCountryValueFromDropdown(String selectval) throws Exception
				{
					try
					{
						if(selectval.equals("JSON.Country"))
						{
							String[] str = selectval.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							selectval = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_country_lst']/text()",0);
						Select drpCountry = new Select(driver.findElement(By.xpath(path)));
						drpCountry.selectByVisibleText(selectval);
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCountryValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SelectCountryValueFromDropdown User  select country as "+selectval;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Select Country Value From Dropdown",  "User  select country as "+selectval,login.screen_loc);
					
			}
			catch(Exception e)
			{
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCountryValueFromDropdown", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectCountryValueFromDropdown Exception occured"+e.getMessage();	
					 logger.info(output);	
				 }
				 HTMLReportGenerator.StepDetails("FAIL","Select Country Value From Dropdown",  "User  select country as "+selectval,login.screen_loc);
			}
				}
				
				@And("^user  select state as \"(.*)\"$")
				public void SelectStateValueFromDropdown(String selectval) throws Exception
				{
					try
					{
						if(selectval.equals("JSON.State"))
						{
							String[] str = selectval.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							selectval = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_state_lst']/text()",0);
						boolean isPresent = driver.findElements(By.xpath(path)).size()>0;					
						
						if(isPresent==false){
							path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_state_txt']/text()",0);
							driver.findElement(By.xpath(path)).sendKeys(selectval);
						}
						else{
							Select drpCountry = new Select(driver.findElement(By.xpath(path)));
							drpCountry.selectByVisibleText(selectval);
						}
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectStateValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SelectStateValueFromDropdown User  select state as "+selectval;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Select State Value From Dropdown",  "User  select state as "+selectval,login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectStateValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectStateValueFromDropdown Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Select State Value From Dropdown",  "User  select state as "+selectval,login.screen_loc);
					}
				}
				@And("^user  select city as \"(.*)\"$")
				public void SelectCityValueFromDropdown(String selectval) throws Exception
				{
					try
					{
						if(selectval.equals("JSON.City"))
						{
							String[] str = selectval.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							selectval = parseCompNameObject(CompList,str[1]);
						}
						
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_city_lst']/text()",0);
						boolean isPresent = driver.findElements(By.xpath(path)).size()>0;
						
						if(isPresent==false){
							path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_city_txt']/text()",0);
							driver.findElement(By.xpath(path)).sendKeys(selectval);}
						else
						{
							Select drpCountry = new Select(driver.findElement(By.xpath(path)));
							drpCountry.selectByVisibleText(selectval);
						}	
						Thread.sleep(2000);
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCityValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SelectCityValueFromDropdown User  select city as "+selectval;
							 logger.info(output);	
						 }
						HTMLReportGenerator.StepDetails("PASS", "Select City Value From Dropdown",  "User  select city as "+selectval,login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("SelectCityValueFromDropdown", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectCityValueFromDropdown Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Select City Value From Dropdown",  "User  select city as "+selectval,login.screen_loc);
					}
				}
				
				@And("^user  enter total employee as \"(.*)\"$")
				public void EnterTotalEmpValueInTextbox( String value) throws Exception
				{
					try
					{
					//WebDriver driver =null;
						
						if(value.equals("JSON.TotalEmp"))
						{
							String[] str = value.split("\\.");
							System.out.println(str[0]);
							System.out.println("wait");
							value = parseCompNameObject(CompList,str[1]);
						}
					String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_totalemp_txt']/text()",0);
					boolean isPresent = driver.findElements(By.xpath(path)).size()>0;
					
					if(isPresent==true){
						driver.findElement(By.xpath(path)).sendKeys(value);		
						Thread.sleep(2000);}
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterTotalEmpValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=EnterTotalEmpValueInTextbox User  enter total employee as"+value;
						 logger.info(output);	
					 }
					HTMLReportGenerator.StepDetails("PASS", "Enter Total Employee Value In Textbox",  "User  enter total employee as"+value,login.screen_loc);
				
				}
				catch(Exception e)
				{
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("EnterTotalEmpValueInTextbox", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SelectCityValueFromDropdown Exception occured"+e.getMessage();	
						 logger.info(output);	
					 }
					 HTMLReportGenerator.StepDetails("FAIL","Enter Total Employee Value In Textbox",  "User  enter total employee as"+value,login.screen_loc);
				}
				}
				
				@And("^user  click on Save button$")
				public void ClickOnSaveButton() throws Exception
				{
					try
					{
						String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_save_btn']/text()",0);
						WebElement btn = driver.findElement(By.xpath(path));
						
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOnSaveButton", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ClickOnSaveButton User  click on Save button";
							 logger.info(output);	
						 }
						btn.click();
						Thread.sleep(5000);
						
						HTMLReportGenerator.StepDetails("PASS", "Click On Save Button",  "User  click on Save button",login.screen_loc);
					
					}
					catch(Exception e)
					{
						if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
							 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOnSaveButton", screenshotfoldername);}
						 if(((IS_LOG_ENABLED).trim()).equals(yes))
						 {
							 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ClickOnSaveButton Exception occured"+e.getMessage();	
							 logger.info(output);	
						 }
						 HTMLReportGenerator.StepDetails("FAIL","Click On Save Button",  "User  click on Save button",login.screen_loc);
					}
				}
				
				@Then("^user  should see saved company name \"(.*)\" in the first row of table$") 
		public boolean ValidateManageCompany(String msg) throws Exception
		{
					boolean tcval =false;
			try
			{
				if(msg.equals("JSON.Validate"))
				{
					String[] str = msg.split("\\.");
					System.out.println(str[0]);
					System.out.println("wait");
					msg = parseCompNameObject(CompList,str[1]);
				}
				
			
				Thread.sleep(5000);
				String path = xmlxpath.getXpathTxt("//XMLREPOSITORY/CREATECOMPANY/XMLXPATH[@XPATHNAME='comp_validate']/text()",0);
				WebElement actualstr = driver.findElement(By.xpath(path));
				if (actualstr.getText().equals(msg)){tcval = true;}
				
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateManageCompany", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ValidateManageCompany User  should see saved company name "+msg+" in the first row of table";
					 logger.info(output);	
				 }
				HTMLReportGenerator.StepDetails("PASS", "Validate Manage Company",  "User  should see saved company name "+msg+" in the first row of table",login.screen_loc);
			
		}
		catch(Exception e)
		{
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateManageCompany", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ValidateManageCompany Exception occured"+e.getMessage();	
				 logger.info(output);	
			 }
			 HTMLReportGenerator.StepDetails("FAIL","Validate Manage Company",  "User  should see saved company name "+msg+" in the first row of table",login.screen_loc);
		}
			
			return tcval;
		}		
		
		public void MaximizeBrowser()
		{
			driver.manage().window().maximize();
		}	
		
				
		@And("^user switch to Manage Company frame$")
		public void SwitchFrame() throws Exception
		{
			try
			{
				driver.switchTo().frame(0); 
				Thread.sleep(2000);
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("SwitchFrame", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=SwitchFrame User  should Switch Frame";
					 logger.info(output);	
				 }
				HTMLReportGenerator.StepDetails("PASS", "Switch Frame",  "User  should Switch Frame",login.screen_loc);			
			}
			catch(Exception e)
			{
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("SwitchFrame", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=SwitchFrame Exception occured"+e.getMessage();	
					 logger.info(output);	
				 }
				 HTMLReportGenerator.StepDetails("FAIL","Switch Frame",  "Switch Frame",login.screen_loc);
			}
		}		
		@Then("^user  should see error message as \"(.*)\"$")
		public boolean ValidateAlertMsg(String msg) throws Exception
		{
			boolean tcval =false;
			try
			{
				Thread.sleep(5000);
				String actualstr = driver.switchTo().alert().getText();		
				if (actualstr.equals(msg)){
					
					if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
						 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateAlertMsg", screenshotfoldername);}
					 if(((IS_LOG_ENABLED).trim()).equals(yes))
					 {
						 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ValidateAlertMsg User  should see error message as "+msg;
						 logger.info(output);	
					 }	
					
					tcval = true;					
					HTMLReportGenerator.StepDetails("PASS", "Validate Alert Msg",  "User  should see error message as "+msg,login.screen_loc);
				}
							 
								
					if (actualstr.equals(msg)){
						tcval = true;					
						HTMLReportGenerator.StepDetails("PASS", "Validate Alert Msg",  "User  should see error message as "+msg,login.screen_loc);
					}
		}
		catch(Exception e)
		{
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateAlertMsg", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ValidateAlertMsg Exception occured"+e.getMessage();	
				 logger.info(output);	
			 }
			 HTMLReportGenerator.StepDetails("FAIL","Validate Alert Msg", "User couldnot see error message as "+msg,login.screen_loc);
		}		
			return tcval;
		}		
		@And("^user clicks on OK button$")
		public void ClickOkButton() throws Exception
		{
			try
			{
				Thread.sleep(5000);
				driver.switchTo().alert().accept();
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOkButton", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ClickOkButton User clicks on OK button";
					 logger.info(output);	
				 }
				HTMLReportGenerator.StepDetails("PASS", "Click Ok Button",  "User clicks on OK button",login.screen_loc);
			
			}
			catch(Exception e)
			{
				if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
					 login.screen_loc = ScreenshotCapture.TakeSnapShot("ClickOkButton", screenshotfoldername);}
				 if(((IS_LOG_ENABLED).trim()).equals(yes))
				 {
					 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ClickOkButton Exception occured"+e.getMessage();	
					 logger.info(output);	
				 }
				 HTMLReportGenerator.StepDetails("FAIL","Click Ok Button", "User could not click on OK button",login.screen_loc);
			}
		}
		
		@Then("^user should see error message as \"(.*)\"$")
		public boolean ValidateBannerMsg(String msg) throws Exception
		{
			boolean tcval =false;
			try
			{
			Thread.sleep(5000);
			String actualstr = driver.switchTo().alert().getText();
			
			if (actualstr.equals(msg)){tcval = true;}
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateBannerMsg", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=PASS,METHOD NAME=ValidateBannerMsg User should see error message as "+msg;
				 logger.info(output);	
			 }
			HTMLReportGenerator.StepDetails("PASS", "Validate Banner Msg",  "User should see error message as "+msg,login.screen_loc);
		
		}
		catch(Exception e)
		{
			if(((IS_SCREEN_CAPTURE_ENABLED).trim()).equals(yes)){
				 login.screen_loc = ScreenshotCapture.TakeSnapShot("ValidateBannerMsg", screenshotfoldername);}
			 if(((IS_LOG_ENABLED).trim()).equals(yes))
			 {
				 output = "Step no="+(stepcounter++)+"Status=FAIL,METHOD NAME=ValidateBannerMsg Exception occured"+e.getMessage();	
				 logger.info(output);	
			 }
			 HTMLReportGenerator.StepDetails("FAIL","Validate Banner Msg", "User could not see error message as "+msg,login.screen_loc);
		}		
			return tcval;
		}
		
		@And("^user loads data via \"(.*)\"$")		
		public void LoadDataType(String value) throws Exception
		{
			try
			{
				if(value.equalsIgnoreCase("EXCEL"))
				 {					
					 loadtype = "EXCEL";
					String Comp_file_path = EXCEL_LOCATION + "\\CREATE_COMP.xlsx";
					GetCompanyData(Comp_file_path,loadtype);					
					 }
				else if(value.equalsIgnoreCase("JSON"))
					 {
						loadtype = "JSON";
						String Comp_file_path = JSON_LOCATION + "\\CREATE_COMP.json";
						GetCompanyData(Comp_file_path,loadtype);
						}
				else {loadtype = "Hardcoded";} 
				 
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		@SuppressWarnings("unchecked")
		public void GetCompanyData(String path, String loadtype) throws FileNotFoundException, IOException, ParseException
		{
			
			System.out.println("I am in GetCompanyData");
			try
	        {
				if(loadtype.equalsIgnoreCase("JSON"))
				{
					JSONParser jsonParser = new JSONParser();			
					Object obj = jsonParser.parse(new FileReader(path));
				//	JSONArray jsonObject = (JSONArray) obj;
					jasonobj =  (JSONObject) obj;
			        CompList = (JSONArray) jasonobj.get("CompDetails");
					
					//CompList =  (JSONArray) obj;
			        System.out.println("Company List = " +CompList);
		            recordCounter = CompList.size();
		            System.out.println(recordCounter);
				}
				else
				{
					sheet = ExcelOperations.GetSheetHandle(path);
					recordCounter = ExcelOperations.GetTotalRowCount();
					
				}
	            
	        }       
	        catch(Exception e)
	        {
	        	e.printStackTrace();
	        }
		}
		
		private  String parseCompNameObject(JSONArray CompList,String tagname)
	    {
	        //Get employee object within list
	      //  JSONObject compObject = (JSONObject) jasonobj.get("CompDetails");
	        //System.out.println(compObject); 
	        jasonobj = (JSONObject)CompList.get(jasonCounter);
	        String compName = (String) jasonobj.get(tagname); 
	        System.out.println(compName); 
	        return compName;
	      }
	//	@Given("^Company are created successfully$")
		@Given("^Company are created successfully via \"(.*)\"$")
		public void getDataFromJSON(String loadtype) throws Exception
		{	
			ClickOnMangeCompanyLink();
			SwitchFrame();			
			LoadDataType(loadtype);
			for (int i=0;i<recordCounter;i++)
			{
				ClickOnNewButton();
				if(loadtype.equalsIgnoreCase("JSON"))
				{
					EnterCompanyNameValueInTextbox(loadtype+".CompanyName");
					SelectCompanyTypeValueFromDropdown(loadtype+".CompanyType");
					SelectSubTypeValueFromDropdown(loadtype+".CompanySubType");
					EnterAddressValueInTextbox(loadtype+".Address");
					EnterPhoneValueInTextbox(loadtype+".PhoneNo");
					EnterEmailValueInTextbox(loadtype+".Email");
					EnterPanValueInTextbox(loadtype+".PAN");
					EnterTinValueInTextbox(loadtype+".TIN");
					EnterMobileValueInTextbox(loadtype+".MobileNo");
					EnterWebsiteValueInTextbox(loadtype+".Website");
					SelectCountryValueFromDropdown(loadtype+".Country");
					SelectStateValueFromDropdown(loadtype+".State");
					SelectCityValueFromDropdown(loadtype+".City");
					EnterTotalEmpValueInTextbox(loadtype+".TotalEmp");
					ClickOnSaveButton();
					ValidateManageCompany(loadtype+".Validate");	
					jasonCounter++;
				}
				else
				{
				//	int colnum = ExcelOperations.GetTotalColumnCount(0);
					for(int x=1;x<=recordCounter;x++)
					{
						int y=0;	
						int data =0;
							ClickOnNewButton();
							EnterCompanyNameValueInTextbox((sheet.getRow(x).getCell(y)).getStringCellValue());
							SelectCompanyTypeValueFromDropdown((sheet.getRow(x).getCell(y+1)).getStringCellValue());
							SelectSubTypeValueFromDropdown((sheet.getRow(x).getCell(y+2)).getStringCellValue());
							EnterAddressValueInTextbox((sheet.getRow(x).getCell(y+3)).getStringCellValue());
							System.out.println((sheet.getRow(x).getCell(y+4)));
							 data =(int) (sheet.getRow(x).getCell(y+4)).getNumericCellValue();
							EnterPhoneValueInTextbox(String.valueOf(data));
							EnterEmailValueInTextbox((sheet.getRow(x).getCell(y+5)).getStringCellValue());
							EnterPanValueInTextbox((sheet.getRow(x).getCell(y+6)).getStringCellValue());
							data =(int) (sheet.getRow(x).getCell(y+7)).getNumericCellValue();
							EnterTinValueInTextbox(String.valueOf(data));
							data =(int) (sheet.getRow(x).getCell(y+8)).getNumericCellValue();
							EnterMobileValueInTextbox(String.valueOf(data));
							EnterWebsiteValueInTextbox((sheet.getRow(x).getCell(y+9)).getStringCellValue());
							SelectCountryValueFromDropdown((sheet.getRow(x).getCell(y+10)).getStringCellValue());
							SelectStateValueFromDropdown((sheet.getRow(x).getCell(y+11)).getStringCellValue());
							SelectCityValueFromDropdown((sheet.getRow(x).getCell(y+12)).getStringCellValue());
							data =(int) (sheet.getRow(x).getCell(y+13)).getNumericCellValue();
							EnterTotalEmpValueInTextbox(String.valueOf(data));
							ClickOnSaveButton();
							//ValidateManageCompany((sheet.getRow(x).getCell(y+14)).getStringCellValue());
							System.out.println("X="+x+" Y="+y+" recordCounter="+recordCounter);
					
					}
				}
			}
			login.CloseBrowser();
		}
}

	
	
