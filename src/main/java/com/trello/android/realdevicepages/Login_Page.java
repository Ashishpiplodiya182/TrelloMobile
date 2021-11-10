package com.trello.android.realdevicepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trello.android.baseutil.BaseTest;
import com.trello.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Login_Page 
{

	public AndroidDriver<AndroidElement> androidDriver;
	public MobileActionUtil actionUtil;
	public long ETO = 15;

	public Login_Page(AndroidDriver<AndroidElement> androidDriver, long ETO, MobileActionUtil actionUtil) 
	{
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		this.actionUtil = actionUtil;
		this.ETO = ETO;
	

     }
	
	
	
	/* Login button */
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
	private AndroidElement btnLogin;
	
	/* Email Textbox */
	@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.trello:id/user']")
	private AndroidElement txtEmail;
	
	/* Next Button  */
	@AndroidFindBy(xpath = "//android.widget.Button[@resource-id='com.trello:id/authenticate']")
	private AndroidElement btnNext;
	
	/* 	Sign In With Google Link  */
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/google_auth']")
	private AndroidElement lnkSignInWithGoogle;
	
	public synchronized AndroidElement continueBtn( String emailId)
	{
	 String xpath = "//android.widget.TextView[@text='"+emailId+"']/ancestor::android.view.View/following-sibling::android.view.View/android.widget.Button[@resource-id='continue']";
	
			 return androidDriver.findElement(By.xpath(xpath));
	}
	//android.widget.TextView[@text='gaurav.r@testyantra.in']
	
	public synchronized AndroidElement usernameLink( String emailId)
	{
	 String xpath = "//android.widget.TextView[@text='"+emailId+"']";
	
			 return androidDriver.findElement(By.xpath(xpath));
	}
	
	
	
	
	/**
	 * Description Method to click on login button.
	 * 
	 * @author Ashish Piplodiya
	 * @param closedBoardName
	 */
	public synchronized void clkOnLoginBtn() {
		try {
			
			
			actionUtil.waitForElement(btnLogin, "login button");
			actionUtil.clickOnElement(btnLogin, "login button");
			
			
			
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on login button");
			Assert.fail("Unable to click on login button");
		}
	}
	
	
	/**
	 * Description Method to Set Email textbox.
	 * 
	 * @author Ashish Piplodiya
	 * @param closedBoardName
	 */
	public synchronized void setEmailTa() {
		try {
			
			
			actionUtil.waitForElement(txtEmail, "Email Textbox");
			actionUtil.typeText(txtEmail ,BaseTest.properties.getProperty("email"),"Email Textbox");
			
			
			
			
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to set Email textbox");
			Assert.fail("Unable to set Email textbox");
		}
	}
	
	
	/**
	 * Description Method to click on Next Button.
	 * 
	 * @author Ashish Piplodiya
	 * @param closedBoardName
	 */
	public synchronized void clkNextBtn() {
		try {
			
			
			actionUtil.waitForElement(btnLogin, "Next Button");
			actionUtil.clickOnElement(btnLogin, "Next Button");
			
			
			
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Next Button");
			Assert.fail("Unable to click on Next Button");
		}
	}
	
	/**
	 * Description Method to click on Continue Button Or User Account
	 * 
	 * @author Ashish Piplodiya
	 * @param closedBoardName
	 */
	public synchronized void clkOnUserAccount() {
		try {
			
			try {
			//actionUtil.waitForElement(continueBtn(BaseTest.properties.getProperty("email")), "Continue Button in User Account");
				Thread.sleep(7000);
			actionUtil.clickOnElement(continueBtn(BaseTest.properties.getProperty("email")), "Continue Button in User Account");
			}
			catch (Exception e) 
			{
				actionUtil.waitForElement(usernameLink(BaseTest.properties.getProperty("email")), "User Account "+BaseTest.properties.getProperty("email"));
				actionUtil.clickOnElement(usernameLink(BaseTest.properties.getProperty("email")), "User Account "+BaseTest.properties.getProperty("email"));
			}
			
			
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on User Account Link");
			Assert.fail("Unable to click on User Account Link");
		}
	}
	
	/**
	 * Description Method to click on Next Button.
	 * 
	 * @author Ashish Piplodiya
	 * @param closedBoardName
	 */
	public synchronized void clkOnSignInWithGoogle() {
		try {
			
			
			actionUtil.waitForElement(lnkSignInWithGoogle, "Sign In With Google Link");
			actionUtil.clickOnElement(lnkSignInWithGoogle, "Sign In With Google Link");
			
			
			
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Sign In With Google Link");
			Assert.fail("Unable to click on Sign In With Google Link");
		}
	}
	
	/**
	 * Description Method to Login To The Application
	 * 
	 * @author Ashish Piplodiya
	 * 
	 */
	public synchronized void loginToApplication() {
		try {
			
	        clkOnLoginBtn();
	        //setEmailTa();
	        clkOnSignInWithGoogle();
	        clkOnUserAccount();
			
	        actionUtil.pass("Login To The Application Successfully");
	        
		  } 
		catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Login To The Application");
			Assert.fail("Unable to Login To The Application");
		}
	}
	
	
}
