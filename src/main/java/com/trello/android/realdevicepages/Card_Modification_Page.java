package com.trello.android.realdevicepages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.trello.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * 
 * Description:This class has Method Implementation for Card Modification Page.
 * 
 * @author Gaurav S.
 *
 */
public class Card_Modification_Page {
	public static AndroidDriver<AndroidElement> androidDriver;
	public MobileActionUtil actionUtil;
	public long ETO = 15;

	public Card_Modification_Page(AndroidDriver<AndroidElement> androidDriver, long ETO, MobileActionUtil actionUtil) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		this.actionUtil = actionUtil;
		this.ETO = ETO;
	}
	
	
	/* Options under Quick Actions */
	public static AndroidElement selectQuickActions(String option)
	{
		String xpath="//android.widget.TextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
    /*Card Description TextField*/
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.trello:id/card_description']")
	private AndroidElement txtFldAddCardDescription;
	
	
	/*Label Button*/
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@text,'Labels')]")
	private AndroidElement btnLabels;
	
	/* Create New Label Link*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/create_label']")
	private AndroidElement lnkCreateNewLabel;
	
	/*Label Name TextField*/
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.trello:id/label_name']")
	private AndroidElement txtFldLabelName;
	
	/* Select label color */
	public static AndroidElement selectLabelColor(String color)
	{
		String xpath="//android.widget.ImageView[@content-desc='"+color+"']";
		return androidDriver.findElement(By.xpath(xpath));
	}


	/*Done Button in Label Popup*/
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='com.trello:id/done_button']")
	private AndroidElement btnDoneLabel;
	
	/*Members Button*/
	@AndroidFindBy(xpath="(//android.widget.TextView[contains(@text,'Members')])[2]")
	private AndroidElement btnMembers;
	
	/* Select Members*/
	public static AndroidElement selectMemberFromCardMemberPopup(String member)
	{
		String xpath="//android.widget.TextView[@text='"+member+"']";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/*Done Button in Card Member Popup*/
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	private AndroidElement btnDoneCardMembers;
	
	/*Start Date Button*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/start_date']")
	private AndroidElement btnStartDate;
	
	/* Date DropDown under Start Date*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/date_button']")
	private AndroidElement ddDateStartDate;
	
	/* Select Option From Date DropDown under Start Date*/
	public static AndroidElement selectOptionFromDateDropDownUnderStartDate(String option)
	{
		String xpath="//android.widget.CheckedTextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/* Time DropDown under Start Date*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/time_button']")
	private AndroidElement ddTimeStartDate;
	
	/* Select Option From Time DropDown Under Start Date*/
	public static AndroidElement selectOptionFromTimeDropDownUnderStartDate(String option)
	{
		String xpath="//android.widget.CheckedTextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/*Done Button Under Start Date*/
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	private AndroidElement btnDoneStartDate;
	
	/*Due Date Button*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/due_date']")
	private AndroidElement btnDueDate;
	
	/* Date DropDown under Due Date*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/date_button']")
	private AndroidElement ddDateDueDate;
	
	/* Select Option From Date DropDown Under Due Date*/
	public static AndroidElement selectOptionFromDateDropDownUnderDueDate(String option)
	{
		String xpath="//android.widget.CheckedTextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/* Time DropDown under Due Date*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/time_button']")
	private AndroidElement ddTimeDueDate;
	
	/* Select Option From Time DropDown Under Due Date*/
	public static AndroidElement selectOptionFromTimeDropDownUnderDueDate(String option)
	{
		String xpath="//android.widget.CheckedTextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/* Set Reminder DropDown */
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='android:id/text1']")
	private AndroidElement ddSetReminder;
	
	/* Select Option From Set Reminder DropDown*/
	public static AndroidElement selectOptionFromSetReminderDropDown(String option)
	{
		String xpath="//android.widget.CheckedTextView[contains(@text,'"+option+"')]";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/*Done Button under Due Date Popup*/
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id='android:id/button1']")
	private AndroidElement btnDoneDueDate;
	
	/*Add Item Text Field*/
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id='com.trello:id/add_checkitem_edit_text']")
	private AndroidElement txtFldAddItem;
	
	/*Assign Link*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/assign']")
	private AndroidElement lnkAssign;
	
	/* Select Members from Assign Member PopUp*/
	public static AndroidElement selectMemberFromAssignMemberPopup(String member)
	{
		String xpath="//android.widget.TextView[@text='"+member+"']";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/*Due Date link*/
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id='com.trello:id/due']")
	private AndroidElement lnkDueDate;
	
	/*Add TickMark or Add Icon*/
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Add']")
	private AndroidElement tickMarkAdd;
	
	/*Cancel TickMark or cancel icon*/
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Cancel']")
	private AndroidElement tickMarkCancel;
	
	
	
	
	
	
	/*Close TickMark*/
	@AndroidFindBy(xpath="//android.widget.ImageButton[@content-desc='Close']")
	private AndroidElement tickMarkClose;
	
	/*Card Name Link*/
	public static AndroidElement linkCardName(String cardName)
	{
		String xpath="//android.widget.EditText[@text='"+cardName+"']";
		return androidDriver.findElement(By.xpath(xpath));
	}
	
	/*Save Edit Name TickMark*/
	@AndroidFindBy(xpath="//android.widget.TextView[@content-desc='Save']")
	private AndroidElement tickMarkSaveEditName;
	
	
	
	/**
	 * Description Method to Click on Card Name
	 * 
	 * @author Gaurav S Rai
	 * @param cardName
	 * @param newCardName
	 * 
	 */
	public synchronized void clkCardNameLink(String cardName, String newCardName) {
		try {
			actionUtil.waitForElement(linkCardName(cardName), "Card Name Link");
			actionUtil.clickOnElement(linkCardName(cardName), "Card Name Link");
			actionUtil.clearText(linkCardName(cardName), "Card Name Link");
			
			actionUtil.typeText(linkCardName(""),newCardName, "Card Name Link");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Card Name Link");
			Assert.fail("Unable to click on Card Name Link");
		}
	}
	
	/**
	 * Description Method to Click on Confirm TickMark For Edit Card Name
	 * 
	 * @author Gaurav S Rai
	 * 
	 */
	public synchronized void clkConfirmTickMarkForEditCardName() {
		try {
			actionUtil.waitForElement(tickMarkSaveEditName, "Confirm TickMark For Edit Card Name");
			actionUtil.clickOnElement(tickMarkSaveEditName, "Confirm TickMark For Edit Card Name");
			
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Confirm TickMark For Edit Card Name");
			Assert.fail("Unable to click on Confirm TickMark For Edit Card Name");
		}
	}
	

	
	/**
	 * Description Method to Select Quick Actions
	 * 
	 * @author Gaurav S Rai
	 * @param action
	 */
	public synchronized void clickOnQuickActionOptions(String action) {
		try {
			actionUtil.waitForElement(selectQuickActions(action), action+" Button");
			actionUtil.clickOnElement(selectQuickActions(action), action+" Button");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on "+action);
			Assert.fail("Unable to click on "+action);
		}
	}
	
	
	/**
	 * Description Method to Add Item In Checklist
	 * 
	 * @author Gaurav S Rai
	 * @param  value
	 * 
	 */
	public synchronized void addItemToTheCheckList(String value) {
		try {
			actionUtil.waitForElement(txtFldAddItem, "Add Item Text Field");
			//actionUtil.clickAndType(txtFldAddItem, value, "Add Item Text Field");
			actionUtil.typeText(txtFldAddItem, value , "Add Item Text Field");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Enter  "+value+" Add Item Text Field");
			Assert.fail("Unable to Enter "+value+" Add Item Text Field");
		}
	}
	
	
	/**
	 * Description Method to Assign the members to the checklist
	 * 
	 * @author Gaurav S Rai
	 * @param member
	 * 
	 */
	public synchronized void assignMemberToCheckList(String member) {
		try {
			actionUtil.waitForElement(lnkAssign, "Assign Link");
			actionUtil.clickOnElement(lnkAssign, "Assign Link");
			
			actionUtil.waitForElement(selectMemberFromAssignMemberPopup(member), member +" Board Member");
			actionUtil.clickOnElement(selectMemberFromAssignMemberPopup(member), member +" Board Member");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to assign "+member+" to the checklist");
			Assert.fail("Unable to assign "+member+" to the checklist");
		}
	}
	
	/**
	 * Description Method to set the due date for the checklist
	 * 
	 * @author Gaurav S Rai
	 * @param dueDate ,dueTime
	 */
	public synchronized void selectDueDateForTheChecklist(String dueDate,String dueTime) {
		try {
			actionUtil.waitForElement(lnkDueDate, "Due Date Link");
			actionUtil.clickOnElement(lnkDueDate, "Due Date Link");
			
			actionUtil.waitForElement(ddDateDueDate, " Date Drop Down");
			actionUtil.clickOnElement(ddDateDueDate, " Date Drop Down");
			
			actionUtil.waitForElement(selectOptionFromDateDropDownUnderDueDate(dueDate), dueDate+" Option under  Date DropDown");
			actionUtil.clickOnElement(selectOptionFromDateDropDownUnderDueDate(dueDate), dueDate+" Option under  Date DropDown");
			
			actionUtil.waitForElement(ddTimeDueDate,"Time Drop Down");
			actionUtil.clickOnElement(ddTimeDueDate,"Time Drop Down");
			
			actionUtil.waitForElement(selectOptionFromTimeDropDownUnderDueDate(dueTime), dueTime+" Option under Time DropDown");
			actionUtil.clickOnElement(selectOptionFromTimeDropDownUnderDueDate(dueTime), dueTime+" Option under Time DropDown");
			
			actionUtil.waitForElement(btnDoneDueDate,"Done Button Under Due Date Popup");
			actionUtil.clickOnElement(btnDoneDueDate,"Done Button Under Due Date Popup");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to set due date for the checklist");
			Assert.fail("Unable to set due date for the checklist");
		}
	}
	
	/**
	 * Description Method to Approve or Accept the modified changes in the card
	 * 
	 * @author Gaurav S Rai
	 * 
	 */
	public synchronized void clickOnAcceptIcon() {
		try {
			actionUtil.waitForElement(tickMarkAdd, "Accept Icon");
			actionUtil.clickOnElement(tickMarkAdd, "Accept Icon");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Approve or Accept the modified changes in the card");
			Assert.fail("Unable to Approve or Accept the modified changes in the card");
		}
	}
	
	/**
	 * Description Method to Reject the modified changes in the card
	 * 
	 * @author Gaurav S Rai
	 * 
	 */
	public synchronized void clickOnRejectIcon() {
		try {
			actionUtil.waitForElement(tickMarkCancel, "Reject Icon");
			actionUtil.clickOnElement(tickMarkCancel, "Reject Icon");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Reject the modified changes in the card");
			Assert.fail("Unable to Reject the modified changes in the card");
		}
	}
	
	
	/**
	 * Description Method to Click on Close.
	 * 
	 * @author Gaurav S Rai
	 * 
	 */
	public synchronized void clickOnCloseIcon() {
		try {
			actionUtil.waitForElement(tickMarkClose, "Close Icon");
			actionUtil.clickOnElement(tickMarkClose, "Close Icon");
	
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Close the modified changes in the card");
			Assert.fail("Unable to Close the modified changes in the card");
		}
	}
	
}
