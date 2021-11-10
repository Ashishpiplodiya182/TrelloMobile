package com.trello.android.baseutil;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.trello.android.util.MobileActionUtil;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * 
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : Launches the browser according to the browser name specified.
 * @AfterClass : Closes the browser after completion of execution
 * @AfterSuite: Kills the driver (example chromedriver.exe) according to browser
 *              specified.
 */

public class BaseTest {
	public static WebDriver driver;
	public Properties prop;
	public static final int ITO = 5;
	public static final int ITO_High=10;
	public static final int ETO = 20;
	public static final int pageLoadTimeout=30;
	public static String sDirPath = System.getProperty("user.dir");
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static final String EXCELPATH = sDirPath + "./src/main/resources/data/Data.xlsx";
	public static MobileActionUtil actionUtil;
	public String testCaseName;
	public static String className;
	/* Appium related variables */
	public DesiredCapabilities mobileCapabilities;
	public AndroidDriver<AndroidElement> androidDriver;
	public static URL appiumServerURL;
	public static boolean isMobile;
	public static Properties properties;
	public static final String CONFIGPATHEN = sDirPath + "./src/main/resources/EnvironmentVariables/config.properties";
	
	static {
		try {
			
			properties = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATHEN);
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Description : Starts the appium server and emulator
	 * 
	 * @author:Ashish , manish , gaurav
	 * @param applicationType
	 */
	@Parameters("applicationType")
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles(String applicationType) {
		
		try {
			
			actionUtil.info("Starting the Appium Server");
			appiumServerURL = CreateDriver.getInstance().startServer();
			BaseTest.logger.info("Appium Server started");
			BaseTest.logger.info("Appium Server URL: "+ appiumServerURL);
				
				if(applicationType.toLowerCase().contains("virtual"))
				{
					CreateDriver.getInstance().launchingEmulator();
				}
			
		} catch (Exception e) {
			BaseTest.logger.error("Exception while starting the appium server");
		}
		
	}

	/**
	 * Description:  Launch the mobile Application
	 *
	 * @author:Ashish , manish , gaurav
	 */
	
	@BeforeClass
	public synchronized void launchApp() {
		
		mobileCapabilities = CreateDriver.getInstance().setUpMobileCapabilities();

			try {
				androidDriver = new AndroidDriver<AndroidElement>(new URL(appiumServerURL.toString()), mobileCapabilities);
				
			} catch (MalformedURLException e) {
				
			}
			androidDriver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
			actionUtil = new MobileActionUtil(androidDriver, ETO);
			

		}
	
		
	

	
	/**
	 * Description: Closes the driver
	 * 
	 * @author:Ashish , manish , gaurav
	 */
	@AfterClass(alwaysRun = true)
	public synchronized void closeBrowser() {
		try {
			if ( androidDriver != null) {
				
				
					androidDriver.quit();
			}
			
			else {
				BaseTest.logger.error("Unable to close the driver");
			}
		} catch (Exception e) {
			BaseTest.logger.error("Unable to close the driver");
		}

	}

	/**
	 * Description: Kills the driver in Task Manager as specified in the parameter.
	 * 
	 * @author: Ashish , Manish , gaurav
	 * @param :applicationType
	 */
	@AfterSuite(alwaysRun = true)
	@Parameters("applicationType")
	public synchronized void killTask(String applicationType) {

		
		 if (applicationType.toLowerCase().contains("mobile")) {
			CreateDriver.getInstance().stopAppiumServer();
			if (applicationType.toLowerCase().contains("virtual")) {
				CreateDriver.getInstance().closeEmulator();
			}
		}
	}
	

	
	
}