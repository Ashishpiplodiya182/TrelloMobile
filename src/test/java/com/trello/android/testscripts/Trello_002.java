package com.trello.android.testscripts;

import org.testng.annotations.Test;

import com.trello.android.baseutil.BaseTest;

import com.trello.android.baseutil.InitializePages;
import com.trello.android.dataprovider.DataProviderFactory;
import com.trello.android.dataprovider.DataProviderFileRowFilter;

/**
 * 
 * Name:Trello_002
 * Description: Verify that whether user is able to Close the board after creating board and multiple list.
 * 
 * @author Ashish Piplodiya.
 *
 */
public class Trello_002 extends BaseTest
{
	
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from TrelloData where SlNo ='2'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Description: Verify that whether user is able to Close the board after creating board and multiple list")
	public void tc_Trello_002(String SlNo , String	boardName , String	listName , String	listName2 , String	listName3	, String card1	 , String card2	 , String itemName	 , String updatedBoardName	, String updatedListName	, String updatedcardName ,String copyListName , String position) 
	
	{
		InitializePages pages = new InitializePages(androidDriver, ETO, actionUtil);

		/* Login to The Application */
		pages.login_Page.loginToApplication();
		
		/* Click on Plus Icon */
		pages.home_Page.clkPlusIcon();

		/* Click on Boards Icon */
		pages.home_Page.clkBoardsIcon();

		/* Set Board Name */
		pages.home_Page.setBoardName(boardName);

		/* Click on Add List Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName);

		/* Click on Add Card Button */
		pages.boardDashboard_page.clkAddCardBtn(listName);

		/* Set Card Name */
		pages.boardDashboard_page.setCardNameTa(listName, card1);

		/* Click on Card Name */
		pages.boardDashboard_page.clkCardName(card1);

		/* Click on Quick Actions Options */
		pages.cardModification_page.clickOnQuickActionOptions(properties.getProperty("checkListItem"));

		/* Set Add Item CheckList */
		pages.cardModification_page.addItemToTheCheckList(itemName);

		/* Click on Accept Icon */
		pages.cardModification_page.clickOnAcceptIcon();

		/* click on Reject Icon */
		pages.cardModification_page.clickOnRejectIcon();

		/* Click on Close Icon */
		pages.cardModification_page.clickOnCloseIcon();

		/* Click on Add list Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName2);

		/* Drag and Drop Card to another List */
		pages.boardDashboard_page.dragAndDropElement(card1, listName2);

		/* Click Add List Button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName3);

		/* Drag and Drop Card to another List */
		pages.boardDashboard_page.dragAndDropElement(card1, listName3);

		/* Click on Action Under Boards */
		pages.boardDashboard_page.clkListActionsBoards();

		/* Click on Boards Setting */
		pages.boardDashboard_page.clkBoardSetting();

		/* Click on Close Boards */
		pages.boardDashboard_page.clkCloseBoards(boardName);

		/* Click on Back button */
		pages.boardDashboard_page.clkBackButton();
		
		/* Logout From The Application */
		pages.home_Page.logoutFromTheApplication();
      
	}

}



