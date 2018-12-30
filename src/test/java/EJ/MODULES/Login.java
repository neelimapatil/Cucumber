package EJ.MODULES;

import EJ.generic.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Config{

	//public static WebDriver driver=null;
	public static WebDriverWait objWaitDriver = null;
	public static int intStepCounter=0;
	public static String strOp = null;
	public static String heelo=null;
	public static String hello_again=null;
	public static String milan = null;
	public static String milan_added = "New string";
		
	final static Logger logger=Logger.getLogger(Login.class);
	
	@When("^user opens the \"(.*)\" browser$")
	public static void OpenBrowser(String strBrowserName) throws Exception
	{
		try
		{
			if(strBrowserName.equalsIgnoreCase("FF32")){
				driver = new FirefoxDriver();
			}
			if(strBrowserName.equalsIgnoreCase("FF64")){
				driver = new FirefoxDriver();
			}
			objWaitDriver=new WebDriverWait(driver, 40);
			strOp= "StepNumber:="+(intStepCounter++)+",STATUS:=PASS,OpenBrowser,Parameters:=strBrowserName="+strBrowserName+",Note:Open Browser Successful"; 
			logger.info(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "OpenBrowser");
			}
			HTMLReportGenerator.StepDetails("PASS", "OpenBrowser", "Open Browser Successful", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=OpenBrowser,Parameters:=BrowserName="+strBrowserName+",Note: Failed to Open Browser,Exception:="+e.getLocalizedMessage();
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true)
			{
				Config.CaptureScreenshot(strScreenShotFolderPath, "OpenBrowser");
			}
			HTMLReportGenerator.StepDetails("FAIL", "OpenBrowser", "Unable to open Browser", strScreenShotFileName);
		}
		
		}
	@And("^user enters the url \"(.*)\"$")
	public void EnterURL(String strUrl) throws Exception
	{
		try
		{
		driver.get(strUrl);
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterURl,Parameters:=BrowUrlserName="+strUrl+",Note:Url opened Successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterURL");
		}
		HTMLReportGenerator.StepDetails("PASS", "EnterURL", "Url opened Successfully", strScreenShotFileName);
		}
		catch (Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterURl,Parameters:=EnterURl="+strUrl+",Note: Failed to Open URL,Exception:="+e.getLocalizedMessage();
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterURL");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterURL", "Failed to Open URL", strScreenShotFileName);
		}
	}
	@When("^user enters \"(.*)\" as username$")
	public void EnterUserName(String strUserName) throws Exception
	{
		Thread.sleep(2000);
		try
		{
		WebElement To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Username']");
		To.sendKeys(strUserName);
		strOp= "Status:=PASS,Method:=EnterUserName,Parameter:=strUserName"+strUserName+",Note:Username is entered successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserName");
		}
		HTMLReportGenerator.StepDetails("PASS", "user enters "+strUserName+" as username", "Username:"+strUserName+" is entered successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "Status:=ERROR,Method:=EnterUserName,Parameter:=strUserName"+strUserName+",Note:Username is not entered successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserName");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterUserName", "Username is not entered successfully", strScreenShotFileName);
		}
	}
	@And("^user enters \"(.*)\" as password$")
	public void EnterPassword(String strPassword) throws Exception
	{
		Thread.sleep(2000);
		try
		{
		WebElement To=ExplicitWait.WaitForObjectExist("//input[@placeholder='Password']");
		To.sendKeys(strPassword);
		strOp= "Status:=PASS,Method:=EnterPassword,Parameter:=strUserName"+strPassword+",Note:Password is entered successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPassword");
		}
		HTMLReportGenerator.StepDetails("PASS", "EnterPassword", "Password is entered successfully", strScreenShotFileName);
		}
		catch(Exception e)
		{
			strOp= "Status:=ERROR,Method:=EnterPassword,Parameter:=strUserName"+strPassword+",Note:Password is not entered successfully";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterPassword");
			}
			HTMLReportGenerator.StepDetails("FAIL", "EnterPassword", "Password is not entered successfully", strScreenShotFileName);
			}
		}
	
	
//	@And("^user clicks on \"(.*)\" button$")
    @And("^user clicks on Login button$")
	public void ClickLoginButton() throws Exception
	{
    	Thread.sleep(2000);
    	try
    	{
    	Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
		WebElement To=ExplicitWait.WaitForObjectExist(strReadValue);
		To.click();
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickLoginButton,Parmeters:=,Note:Login button is clicked successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "ClickLoginButton");
		}
		HTMLReportGenerator.StepDetails("PASS", "ClickLoginButton", "Login button is clicked successfully", strScreenShotFileName);	
    	}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",STATUS:=ERROR,Method:=ClickLoginButton,Parameters:=,Note:Note:Login button is not clicked successfully,Exception:="+e.getLocalizedMessage();
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickLoginButton");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickLoginButton", "Login button is not clicked successfully", strScreenShotFileName);	
		}
    	
	}
  @And("^user again clicks on Login button$")
	public void ClickLoginButton1() throws IOException
	{
    	try
    	{
    	Login objLogin = new Login();
		String strReadValue=objLogin.GetParameterValue_again("OBJ_LOGIN_BUTTON", "OR.properties");
		WebElement To=ExplicitWait.WaitForObjectExist(strReadValue);
		To.click();
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=ClickLoginButton,Parmeters:=,Note:Login button is clicked successfully";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "ClickLoginButton1");
		}
		HTMLReportGenerator.StepDetails("PASS", "ClickLoginButton1", "Login button is clicked successfully", strScreenShotFileName);	
    	}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",STATUS:=ERROR,Method:=ClickLoginButton,Parameters:=,Note:Note:Login button is not clicked successfully,Exception:="+e.getLocalizedMessage();
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "ClickLoginButton1");
			}
			HTMLReportGenerator.StepDetails("FAIL", "ClickLoginButton1", "Login button is not clicked successfully", strScreenShotFileName);
		}
    	
	}
	
    @Then("^user verifies the link on home page$")
    public static void VerifyLogoutLink() throws Exception {
    	Thread.sleep(2000);
		try
		{
			WebElement objTemp=ExplicitWait.WaitForObjectExist("//a[contains(text(),'LOGOUT')]");
			String strVal = objTemp.getText();
			String strTemp = "LOGOUT";
			if (strVal.matches(strTemp))
			{
				strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=VerifyLogoutLink,Parmeters:=,Note:User is able to logged in the application";
				logger.info(strOp);
				if(isCaptureScreenShotEnabled==true) {
					Config.CaptureScreenshot(strScreenShotFolderPath, "VerifyLogoutLink");
				}
				HTMLReportGenerator.StepDetails("PASS", "VerifyLogoutLink", "User is able to logged in the application", strScreenShotFileName);
			}
			else
			{
				strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=VerifyLogoutLink,Parmeters:=,Note:User is unable to logged in the application";
				logger.error(strOp);
				if(isCaptureScreenShotEnabled==true) {
					Config.CaptureScreenshot(strScreenShotFolderPath, "VerifyLogoutLink");
				}
				HTMLReportGenerator.StepDetails("FAIL", "VerifyLogoutLink", "User is unable to logged in the application", strScreenShotFileName);
			}
		}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=VerifyLogoutLink,Parmeters:=,Note:User is unable to logged in the application";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "VerifyLogoutLink");
			}
			HTMLReportGenerator.StepDetails("FAIL", "VerifyLogoutLink", "User is unable to logged in the application", strScreenShotFileName);
		}
    }
    @And("^Close the Broswer$")
    
    public static void CloseBrowser() throws Exception
    {
    	Thread.sleep(5000);
    	driver.close();
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=CloseBrowser,Parmeters:=,Note:Browser is closed";
		logger.info(strOp);
    }
    @Then("^user logs out$")
    public static void ClickLogoutLink() throws Exception {
    	Thread.sleep(4000);
    	try
    	{
    	WebElement objTemp=ExplicitWait.WaitForObjectExist("//a[contains(text(),'LOGOUT')]");
    	objTemp.click();
    	}
    	catch(Exception e)
		{
    		System.out.println(e);
		}
    }
    
    @When("^user enters username and password$")
    public void EnterUserAndPassword(DataTable credentials) throws Exception
    {
    	//Column names names we are not passing when it is list object
    	try
		{
		List<List<String>> data=credentials.raw();
    	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(data.get(0).get(0));
    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.get(0).get(1));
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterUserAndPassword,Parmeters:=,Note:Username and Password is entered successfully through datatable";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserAndPassword");
		}
		HTMLReportGenerator.StepDetails("PASS", "EnterUserAndPassword", "Username and Password is entered successfully through datatable", strScreenShotFileName);	
    	}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterUserAndPassword,Parmeters:=,Note:Username and Password is not entered successfully through datatable";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserAndPassword");
			}
			HTMLReportGenerator.StepDetails("PASS", "EnterUserAndPassword", "Username and Password is not entered successfully through datatable", strScreenShotFileName);
		}
    }
    @When("^user enters username and password that has column names$")
    public void EnterUserAndPasswordhasheader(DataTable credentials) throws Exception
    {
    	try
    	{
    	//Column names names we are not passing when it is list object
    	for(Map<String, String> data :credentials.asMaps(String.class, String.class))
    	{
    	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(data.get("username"));
    	driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(data.get("password"));
		strOp= "StepNumber:="+(intStepCounter++)+",Status:=PASS,Method:=EnterUserAndPasswordhasheader,Parmeters:=,Note:Username and Password is entered successfully(column header)";
		logger.info(strOp);
		if(isCaptureScreenShotEnabled==true) {
			Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserAndPasswordhasheader");
		}
		HTMLReportGenerator.StepDetails("PASS", "EnterUserAndPasswordhasheader", "Username and Password is entered successfully(column header)", strScreenShotFileName);
    	}
    	}
		catch(Exception e)
		{
			strOp= "StepNumber:="+(intStepCounter++)+",Status:=ERROR,Method:=EnterUserAndPasswordhasheader,Parmeters:=,Note:Username and Password is not entered successfully(column header)";
			logger.error(strOp);
			if(isCaptureScreenShotEnabled==true) {
				Config.CaptureScreenshot(strScreenShotFolderPath, "EnterUserAndPasswordhasheader");
			}
			HTMLReportGenerator.StepDetails("PASS", "EnterUserAndPasswordhasheader", "Username and Password is not entered successfully(column header)", strScreenShotFileName);
		}
    }
	public String GetParameterValue_again(String strParamterName, String strFileName) throws IOException
	{
		InputStream input=null;
		Properties objProp=new Properties();
		input=getClass().getClassLoader().getResourceAsStream(strFileName);
		objProp.load(input);
		String strParameterValue= objProp.getProperty(strParamterName);
		return strParameterValue;
	}
	
	@Before
	public void before(Scenario scene) throws IOException, ParserConfigurationException, SAXException {

		if(InitStarted==false)
			{InitFlags();
			InitStarted = true;
			//String workingDir = System.getProperty("user.dir");
			//System.out.println(workingDir);
			String strDateFormat=File_Operations.GetCurrentDateAsPerGivenFormat("yyyy-MM-dd_hh_mm_ss");
			
			File_Operations.CreateChildFolder("E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER","\\Result"+strDateFormat,"\\LOGS");
			//String strParentFolderName = File_Operations.strParentFolderName;
			
			File_Operations.CreateChildFolder("E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER","\\Result"+strDateFormat,"\\REPORT");
		   Config.strReportFolderPath = File_Operations.strChildFolderName+"\\Report_"+strDateFormat+".html";
	//		Config.strReportFolderPath = "E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER\\REPORTS\\report.html";
			File_Operations.CreateChildFolder("E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER","\\Result"+strDateFormat,"\\SCREENSHOTS");	
			Config.strScreenShotFolderPath = File_Operations.strChildFolderName+"\\";
			//Config.strScreenShotFolderPath = "E:\\selenium\\Workspace\\workspace_maven\\EJCUCUMBER\\SCREENSHOTS\\";
			}
		HTMLReportGenerator.TestSuiteStart(Config.strReportFolderPath , "ejagruti");
		String ScenarioName = scene.getName();
		HTMLReportGenerator.TestCaseStart(ScenarioName, ScenarioName);	
		
	}
	
	@After
	public void after() throws IOException, ParserConfigurationException, SAXException, InterruptedException
	{
		//ScenarioName = null;
		Thread.sleep(2000);
		HTMLReportGenerator.TestCaseEnd();
		HTMLReportGenerator.TestSuiteEnd();
	}
	
	
	
		
	public static void main(String[] args) throws Exception
	{
		Config.InitFlags();

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
	}
}

