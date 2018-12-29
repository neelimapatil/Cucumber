package ej.configurations;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Config {
	public static String OBJ_USERNAME = null;
	public static String OBJ_PASSWORD = null;
	public static String OBJ_LOGIN_BUTTON = null;
	public static String OBJ_FINANCIAL_ANALYSIS_LINK = null;
	public static String OBJ_COMPANY_LINK = null;
	public static String OBJ_MANAGE_COMPANY_LINK = null;
	public static String OBJ_NEW_BUTTON = null;
	public static String OBJ_COMPANY_NAME = null;
	public static String OBJ_COMPANY_TYPE = null;
	public static String OBJ_COMPANY_SUBTYPE = null;
	public static String OBJ_COMPANY_ADDRESS=null;
	public static String OBJ_COMPANY_PHONE=null;
	public static String OBJ_COMPANY_EMAIL = null;
	public static String OBJ_COMPANY_PAN = null;
	public static String OBJ_COPANY_TIN = null;
	public static String OBJ_COMPANY_MOBILE = null;
	public static String OBJ_COMPANY_WEBSITE = null;
	public static String OBJ_COUNTRY  = null;
	public static String OBJ_STATE = null;
	public static String OBJ_CITY = null;
	public static String OBJ_TOTAL_EMPLOYEE = null;
	public static String OBJ_SAVE_BUTTON = null;
	
	public static WebDriverWait objWaitDriver = null;
	public static WebDriver driver=null;
	
	private String getParameterValue_child(String parametername) throws IOException
	{
		InputStream input=null;
		Properties prop=new Properties();
		
		input=getClass().getClassLoader().getResourceAsStream("OR.properties");
		prop.load(input);
		
		String parameterValue=prop.getProperty(parametername);
			
		return parameterValue;
	}
	
	public static String GetParameterValue(String parametername) throws IOException
	{
		Config pf = new Config();
		
		return pf.getParameterValue_child(parametername);
	}
	public static void init() throws IOException{
		Config objConfig=new Config();
		
		OBJ_USERNAME = objConfig.GetParameterValue("OBJ_USERNAME");
		OBJ_PASSWORD = objConfig.GetParameterValue("OBJ_PASSWORD");
		OBJ_LOGIN_BUTTON = objConfig.GetParameterValue("OBJ_LOGIN_BUTTON");
		OBJ_FINANCIAL_ANALYSIS_LINK = objConfig.GetParameterValue("OBJ_FINANCIAL_ANALYSIS_LINK");
		OBJ_COMPANY_LINK = objConfig.GetParameterValue("OBJ_COMPANY_LINK");
		OBJ_MANAGE_COMPANY_LINK = objConfig.GetParameterValue("OBJ_MANAGE_COMPANY_LINK");
		OBJ_NEW_BUTTON = objConfig.GetParameterValue("OBJ_NEW_BUTTON");
		OBJ_COMPANY_NAME = objConfig.GetParameterValue("OBJ_COMPANY_NAME");
		OBJ_COMPANY_TYPE = objConfig.GetParameterValue("OBJ_COMPANY_TYPE");
		OBJ_COMPANY_SUBTYPE = objConfig.GetParameterValue("OBJ_COMPANY_SUBTYPE");
		OBJ_COMPANY_ADDRESS = objConfig.GetParameterValue("OBJ_COMPANY_ADDRESS");
		OBJ_COMPANY_PHONE = objConfig.GetParameterValue("OBJ_COMPANY_PHONE");
		OBJ_COMPANY_EMAIL = objConfig.GetParameterValue("OBJ_COMPANY_EMAIL");
		OBJ_COMPANY_PAN = objConfig.GetParameterValue("OBJ_COMPANY_PAN");
		OBJ_COPANY_TIN = objConfig.GetParameterValue("OBJ_COPANY_TIN");
		OBJ_COMPANY_MOBILE = objConfig.GetParameterValue("OBJ_COMPANY_MOBILE");
		OBJ_COMPANY_WEBSITE = objConfig.GetParameterValue("OBJ_COMPANY_WEBSITE");
		OBJ_COUNTRY = objConfig.GetParameterValue("OBJ_COUNTRY");
		OBJ_STATE = objConfig.GetParameterValue("OBJ_STATE");
		OBJ_CITY = objConfig.GetParameterValue("OBJ_CITY");
		OBJ_TOTAL_EMPLOYEE = objConfig.GetParameterValue("OBJ_TOTAL_EMPLOYEE");
		OBJ_SAVE_BUTTON = objConfig.GetParameterValue("OBJ_SAVE_BUTTON");
	
	}
	
	

	
}
