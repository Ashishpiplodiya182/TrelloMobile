package com.trello.android.testscripts;

import org.testng.annotations.Test;

import com.trello.android.baseutil.BaseTest;
import com.trello.android.baseutil.InitializePages;
import com.trello.android.dataprovider.DataProviderFactory;
import com.trello.android.dataprovider.DataProviderFileRowFilter;

/**
 * 
 * Name:Trello_008
 * Description: Verify that whether user is able to Archiev the list.
 * 
 * @author Ashish Piplodiya , Gaurav S.
 *
 */
public class Trello_008 extends BaseTest
{
	@DataProviderFileRowFilter(file = "./src/main/resources/data/Data.xlsx", sql = "Select * from TrelloData where SlNo ='8'")
	@Test(dataProvider = "data1", dataProviderClass = DataProviderFactory.class, description = "Description: Verify that whether user is able to Archiev the list")
	public void tc_Trello_008(String SlNo , String	boardName , String	listName , String	listName2 , String	listName3	, String card1	 , String card2	 , String itemName	 , String updatedBoardName	, String updatedListName	, String updatedcardName , String copyListName , String position) throws InterruptedException
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

		/* Click on Add List */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName);

		/* Click on Add Card Button */
		pages.boardDashboard_page.clkAddCardBtn(listName);

		/* Set Card Name */
		pages.boardDashboard_page.setCardNameTa(listName, card1);

		/* Click Add List button */
		pages.boardDashboard_page.clkAddlistBtn();

		/* Set List Name */
		pages.boardDashboard_page.setListNameTa(listName2);

		/* Drag and Drop Card to another List */
		pages.boardDashboard_page.dragAndDropElement(card1,listName2 );

		/* Click List Action */
		pages.boardDashboard_page.clkListAction(listName2);
		
		/* Click on Archieved list Under list Actions */
		pages.boardDashboard_page.clkArchievListUnderListActions(listName2);
		
		/* Click on List Actions Boards */
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
