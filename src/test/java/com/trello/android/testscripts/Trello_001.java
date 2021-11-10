package com.trello.android.testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.trello.android.baseutil.BaseTest;

import com.trello.android.baseutil.InitializePages;
import com.trello.android.dataprovider.DataProviderFactory;
import com.trello.android.dataprovider.DataProviderFileRowFilter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.WaitOptions;

/**
 * 
 * Name:Trello_001
 * Description: Verify that whether user is able to move the card after creating board and multiple list.
 * 
 * @author Ashish Piplodiya.
 *
 */

public class Trello_001 extends BaseTest
{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from TrelloData where SlNo ='1'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Description: Verify that whether user is able to move the card after creating board and multiple list")
	public void tc_Trello_001(String SlNo , String	boardName , String	listName , String	listName2 , String	listName3	, String card1	 , String card2	 , String itemName	 , String updatedBoardName	, String updatedListName	, String updatedcardName , String copyListName , String position) throws InterruptedException
	{
		InitializePages pages = new InitializePages(androidDriver, ETO, actionUtil);


		
		
		/* Login to The Application */
		pages.login_Page.loginToApplication();
		
		/* Click on Plus Icon */
		pages.home_Page.clkPlusIcon();

		/* Click on Boards icon */
		pages.home_Page.clkBoardsIcon();

		/* Set the Board Name */
		pages.home_Page.setBoardName(boardName);

		/* Click on Add List Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName);

		/* Click on Add Card Button */
		pages.boardDashboard_page.clkAddCardBtn(listName);
		
		/* Set Card Name */
		pages.boardDashboard_page.setCardNameTa(listName, card1);

		/* Click on Card */
		pages.boardDashboard_page.clkCardName(card1);

		/* Click on Quick Action options */
		pages.cardModification_page.clickOnQuickActionOptions(properties.getProperty("checkListItem"));

		/* Click on Add Items */
		pages.cardModification_page.addItemToTheCheckList(itemName);

		/* Click on Accept Icon */
		pages.cardModification_page.clickOnAcceptIcon();

		/* Click on Reject Icon */
		pages.cardModification_page.clickOnRejectIcon();

		/* Click on Close Icon */
		pages.cardModification_page.clickOnCloseIcon();

		/* Click on Add List Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName2);

		/* Drag and Drop Card to another List */
	    pages.boardDashboard_page.dragAndDropElement(card1,listName2 );
		
		/* Click on Add List Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName3);

		/* Drag and Drop Card to another List */
		pages.boardDashboard_page.dragAndDropElement(card1, listName3);
		
		/* Click on Actions Under Boards */
		pages.boardDashboard_page.clkListActionsBoards();

		/* Click on Board Setting */
		pages.boardDashboard_page.clkBoardSetting();

		/* Click on Close Boards */
		pages.boardDashboard_page.clkCloseBoards(boardName);
		
		/* Click on Back button */
		pages.boardDashboard_page.clkBackButton();
		
		/* Logout From The Application */
		pages.home_Page.logoutFromTheApplication();
		
		
      
	}

}
