package com.trello.android.realdevicepages;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.trello.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * 
 * 
 * Description:This class has Method Implementation for BoardDashBoad Page.
 * 
 * @author Ashish Piplodiya.
 *
 */
public class BoardDashboard_Page  {

	public AndroidDriver<AndroidElement> androidDriver;
	public MobileActionUtil actionUtil;
	public long ETO = 15;

	public BoardDashboard_Page(AndroidDriver<AndroidElement> androidDriver, long ETO, MobileActionUtil actionUtil) {
		this.androidDriver = androidDriver;
		PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
		this.actionUtil = actionUtil;
		this.ETO = ETO;

	}
	

	/* Add List Button */
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Add list']")
	private AndroidElement btnAddList;

	/* List Name Textbox */
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='List name']")
	private AndroidElement txtListName;

	
	/* List Name Link */
	public AndroidElement linklistName(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	
	/* Confirm tick mark */
	@AndroidFindBy(id = "com.trello:id/confirm")
	private AndroidElement tickConfirm;

	/* Add Card Button */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Myfirstcard']")
	private AndroidElement btnAddCard;
	
	/* Card Name */
	public AndroidElement btnAddCard(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/following-sibling::android.widget.LinearLayout/android.widget.Button[@text='+ Add card']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	
	/* Card Name */
	public AndroidElement txtCardName(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/following-sibling::androidx.recyclerview.widget.RecyclerView/descendant::android.widget.EditText[@text='Card name']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	/* Card Name */
	public AndroidElement cardName(String listName , String cardName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/following-sibling::androidx.recyclerview.widget.RecyclerView/descendant::android.widget.EditText[@text='"+cardName+"']";

		return androidDriver.findElementByXPath(xpath);
	}

	/* Card Name textbox */
	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Card name']")
	private AndroidElement txtCardName;

	/* Card Name */
	public AndroidElement linkCardName(String cardName) {

		String xpath = "//android.widget.TextView[@text='" + cardName + "']";

		return androidDriver.findElementByXPath(xpath);
	}

	/* List Actions */
	public AndroidElement listActions(String listName) {

		String xpath = "//android.widget.EditText[@text='" + listName
				+ "']/parent::android.widget.LinearLayout/descendant::android.widget.ImageView";

		return androidDriver.findElementByXPath(xpath);
	}

	/* Move List Link Under List Actions */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Move list']")
	private AndroidElement linkMoveList;
	
	/* Archieve List Under List Actions */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Archive list']")
	private AndroidElement linkArchiveList;

	/* Move all Cards in this List Under List Actions */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Move all cards in this list']")
	private AndroidElement linkMoveAllCardsInThisList;

	/* Copy List Link Under List Actions */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Copy list']")
	private AndroidElement linkCopyList;

	/* List Name textbox Under Copy List */
	@AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.trello:id/list_name_input')]")
	private AndroidElement txtListNameUnderCopyList;

	/* Boards dropdown Under Copy List */
	@AndroidFindBy(id = "com.trello:id/board_selection")
	private AndroidElement ddBoardUndercopyList;

	/* Boards dropdown Options Under Copy List */
	public AndroidElement optBoard(String optBoard) {

		String xpath = "//android.widget.TextView[@text='" + optBoard + "']";

		return androidDriver.findElementByXPath(xpath);
	}

	/* Position Dropdown Under Copy List */
	@AndroidFindBy(id = "com.trello:id/position_selection")
	private AndroidElement ddPositionUnderCopyList;

	/* Position Dropdown Options Under Copy List */
	public AndroidElement optPosition(String optPosition) {

		String xpath = "//android.widget.TextView[@text='" + optPosition + "']";

		return androidDriver.findElementByXPath(xpath);
	}

	/* Board dashboard List Action */
	@AndroidFindBy(id = "com.trello:id/board_sections")
	private AndroidElement listActionBoards;

	/* Board Settings */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Board settings']")
	private AndroidElement linkBoardSettings;


	
	/* Archieved List Link  */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Archived lists']")
	private AndroidElement linkArchievedList;
	
	/* Close Boards */
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Close board']")
	private AndroidElement linkCloseBoards;

	/* Reopen Boards */
	@AndroidFindBy(id = "com.trello:id/board_unavailable_action")
	private AndroidElement btnReOpenBoard;

	/* Drop To  */
	public AndroidElement dropTo(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/following-sibling::androidx.recyclerview.widget.RecyclerView";

		return androidDriver.findElementByXPath(xpath);
	}
	
	/* Drop To  */
	public AndroidElement dropToNew(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/../following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id='com.trello:id/recycler_view']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	
	/* Board Closing Back Button */
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Close']")
	private AndroidElement btnBack;
	
		
	
	/* Validate Drag and Drop */
	public AndroidElement validatedDrop (String cardName) {

		String xpath = "//android.widget.TextView[@text='"+cardName+"']/ancestor::android.view.ViewGroup[@resource-id='com.trello:id/card_list_container']/descendant::android.widget.EditText[@resource-id='com.trello:id/list_name']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	/* Validate Board Name Text */
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/toolbar_title']")
	private AndroidElement txtValidateBoardName;
	
	
	
	
	/* List Drop Down */
	@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/list_selection']")
	private AndroidElement ddList;
	
	/* List Dropdown Options Under Move All Cards in The List*/
	public AndroidElement optList(String optList) {

		String xpath = "//android.widget.TextView[contains(@text,'"+optList+"')]";

		return androidDriver.findElementByXPath(xpath);
	}

 
	
	
	
	/* Archieved list Names Under Board Actions */
	public AndroidElement linkArchievedLists(String listName) {

		String xpath = "//android.widget.TextView[@text='"+listName+"']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	/* Link Send To Board */
	@AndroidFindBy(id="com.trello:id/unarchive")
	private AndroidElement lnkSendToBoard;
	
	
	/* txt This board is closed */
	public AndroidElement txtBoardIsClosed(String boardName) {

		String xpath = "//android.widget.TextView[@text='"+boardName+"']/ancestor::android.widget.FrameLayout[@resource-id='com.trello:id/content_view_wrapper']/descendant::android.widget.TextView[@text='This board is closed.']";

		return androidDriver.findElementByXPath(xpath);
	}
	
	/* txt List Name */
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@resource-id='com.trello:id/card_list_container']/android.widget.LinearLayout[@resource-id='com.trello:id/card_list_header']/android.widget.EditText[@resource-id='com.trello:id/list_name']")
	private List<AndroidElement> txtNameList;
	

	/* Select list on the basis of List Name*/
	public List<AndroidElement> selectList(String listName) {

		String xpath = "//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/following-sibling::androidx.recyclerview.widget.RecyclerView/descendant::android.widget.TextView[@resource-id='com.trello:id/cardText']";

		return androidDriver.findElementsByXPath(xpath);
	}
	
	
	/* Star Board Button*/
	@AndroidFindBy(xpath ="//android.widget.TextView[@resource-id='com.trello:id/star']")
	private AndroidElement btnStarBoard;
	
	/**
	 * Description Method to click on Add List Button.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkAddlistBtn() {
		try {

			actionUtil.waitForElement(btnAddList, "Add List Button");
			actionUtil.clickOnElement(btnAddList, "Add List Button");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Add List Button");
			Assert.fail("Unable to click on Add List Button");
		}
	}
	
	
	/**
	 * Description Method to click on Send to Boards.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkSendToBoardlnk() {
		try {

			actionUtil.waitForElement(lnkSendToBoard, "Send to Boards Link");
			actionUtil.clickOnElement(lnkSendToBoard, "Send to Boards Link");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Send to Boards Link");
			Assert.fail("Unable to click on Send to Boards Link");
		}
	}
	
	
	/**
	 * Description Method to click on Archiev list Under List Action.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName
	 */
	public synchronized void clkArchievListUnderListActions(String listName) {
		try {

			actionUtil.waitForElement(linkArchiveList, "Archiev list Link");
			actionUtil.clickOnElement(linkArchiveList, "Archiev list Link");

			try {
				
				WebDriverWait wait = new WebDriverWait(androidDriver, 10);
				
				wait.until(ExpectedConditions.visibilityOf(linklistName(listName)));
				
				linklistName(listName).isDisplayed();
				
				actionUtil.info(listName + " is displayed");
			}
			catch (Exception e) {
				actionUtil.info(listName+ "List Archieved Successfully");
				actionUtil.pass(listName+ "List Archieved Successfully");
			}
			
		} 
			catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Archiev list Link");
			Assert.fail("Unable to click on Archiev list Link");
		}
	}

	
	/**
	 * Description Method to Set value into List Name TextBox.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName
	 */
	public synchronized void setListNameTa(String listName) {
		try {

			actionUtil.waitForElement(txtListName, "List Name TextBox");
			
			actionUtil.typeText(txtListName, listName, "List Name TextBox");
			
			clkConfirmTickMark();
			
			validateListName(listName);

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to enter value into List Name TextBox");
			Assert.fail("Unable to enter value into List Name TextBox");
		}
	}

	
	
	/**
	 * Description Method to Validate List Creation
	 * 
	 * @author Ashish Piplodiya
	 * @param expectedListName
	 */
	public synchronized void validateListName(String expectedListName) {
		String actualListName =null;
		try {
			
			actionUtil.waitForElement(linklistName(expectedListName), "Board Name Text");
			
		     actualListName = linklistName(expectedListName).getText();
		
		    Assert.assertEquals(actualListName, expectedListName);
		    
		   actionUtil.info("Expected List :"+expectedListName+" Matched with Actual List :"+actualListName);
		   actionUtil.pass("Expected List :"+expectedListName+" Matched with Actual List :"+actualListName);
			
		   } 
		catch (Exception e) {
			actionUtil.error("Expected List :"+expectedListName+" Matched with Actual List :"+actualListName);
			actionUtil.fail("Expected List :"+expectedListName+" Matched with Actual List :"+actualListName);
			Assert.fail("Expected List :"+expectedListName+" Matched with Actual List :"+actualListName);
		}
	}
	
	
	
	
	/**
	 * Description Method to click on Confirm Tick Mark.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkConfirmTickMark() {
		try {

			actionUtil.waitForElement(tickConfirm, "Confirm Tick Mark");
			actionUtil.clickOnElement(tickConfirm, "Confirm Tick Mark");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Confirm Tick Mark");
			Assert.fail("Unable to click on Confirm Tick Mark");
		}
	}

	/**
	 * Description Method to click on Add Card button.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName
	 */
	public synchronized void clkAddCardBtn(String listName) {
		try {

			actionUtil.waitForElement(btnAddCard(listName), "Add Card Button");
			actionUtil.clickOnElement(btnAddCard(listName), "Add Card Button");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Add Card Button");
			Assert.fail("Unable to click on Add Card Button");
		}
	}

	
	
	/**
	 * Description Method to Validate Card Creation
	 * 
	 * @author Ashish Piplodiya
	 * @param expectedCardName
	 */
	public synchronized void validateCardName(String expectedCardName) {
		String actualCardName =null;
		try {
			
			actionUtil.waitForElement(linkCardName(expectedCardName), "Card Name Text");
			
			actualCardName = linkCardName(expectedCardName).getText();
		
		    Assert.assertEquals(actualCardName, expectedCardName);
		    
		   actionUtil.info("Expected Card :"+expectedCardName+" Matched with Actual Card :"+actualCardName);
		   actionUtil.pass("Expected Card :"+expectedCardName+" Matched with Actual Card :"+actualCardName);
			
		   } 
		catch (Exception e) {
			actionUtil.error("Expected Card :"+expectedCardName+" Matched with Actual Card :"+actualCardName);
			actionUtil.fail("Expected Card :"+expectedCardName+" Matched with Actual Card :"+actualCardName);
			Assert.fail("Expected Card :"+expectedCardName+" Matched with Actual Card :"+actualCardName);
		}
	}
	
	
	/**
	 * Description Method to Set value into Card Name TextBox.
	 * 
	 * @author Ashish Piplodiya
	 * @param cardName
	 */
	public synchronized void setCardNameTa(String listName , String cardName) {
		try {

			actionUtil.waitForElement(txtCardName(listName), "Card Name TextBox");
			
			actionUtil.typeText(txtCardName(listName), cardName, "Card Name TextBox");
			
			clkConfirmTickMark();
			
			actionUtil.poll(3000);
			
			validateCardName(cardName);
			

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to enter value into Card Name TextBox");
			Assert.fail("Unable to enter value into Card Name TextBox");
		}
	}
	
	/**
	 * Description Method to click on Card.
	 * 
	 * @author Ashish Piplodiya
	 * @param cardName
	 */
	public synchronized void clkCardName(String cardName) {
		try {

			actionUtil.waitForElement(linkCardName(cardName), "Card Name");
			actionUtil.clickOnElement(linkCardName(cardName), "Card Name ");
			

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Click on Card Name");
			Assert.fail("Unable to Click on Card Name");
		}
	}

	/**
	 * Description Method to click on Card Name.
	 * 
	 * @author Ashish Piplodiya
	 * @param cardName
	 */
	public synchronized void clkAddCardBtnn(String cardName) {
		try {

			actionUtil.waitForElement(linkCardName(cardName), "Card Name");
			actionUtil.clickOnElement(linkCardName(cardName), "Card Name");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Card Name");
			Assert.fail("Unable to click on Card Name");
		}
	}

	
	/**
	 * Description Method to click on List Actions.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName
	 */
	public synchronized void clkListAction(String listName) {
		try {
			actionUtil.poll(1000);
			actionUtil.swipeRightToTheElement("//android.widget.EditText[@text='"+listName+"']/parent::android.widget.LinearLayout/descendant::android.widget.ImageView");
			actionUtil.waitForElement(listActions(listName), "List Actions");
			actionUtil.clickOnElement(listActions(listName), "List Actions");

		} catch (Exception e) {
			
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on List Actions");
			Assert.fail("Unable to click on List Actions");
		}
	}

	/**
	 * Description Method to click on Move List Link Under List Actions.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkMoveListLinkUnderListActions() {
		try {

			actionUtil.waitForElement(linkMoveList, "Move List Link");
			actionUtil.clickOnElement(linkMoveList, "Move List Link");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Move List Link");
			Assert.fail("Unable to click on Move List Link");
		}
	}

	/**
	 * Description Method to click on Move all Cards in this List Under List
	 * Actions.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkMoveAllCardsLinkUnderListActions() {
		try {

			actionUtil.waitForElement(linkMoveAllCardsInThisList, " Move all Cards in this List Link");
			actionUtil.clickOnElement(linkMoveAllCardsInThisList, " Move all Cards in this List Link");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Move all Cards in this List Link");
			Assert.fail("Unable to click on Move all Cards in this List Link");
		}
	}

	/**
	 * Description Method to click on Copy List Link Under List Actions.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkCopyListLinkUnderListActions() {
		try {

			actionUtil.waitForElement(linkCopyList, "Copy List Link");
			actionUtil.clickOnElement(linkCopyList, "Copy List Link");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Copy List Link");
			Assert.fail("Unable to click on Copy List Link");
		}
	}

	/**
	 * Description Method to Set value into List Name textbox Under Copy List.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName
	 */
	public synchronized void setListNameUnderCopyList(String listName) {
		try {

			actionUtil.waitForElement(txtListNameUnderCopyList, "List Name textbox");
			actionUtil.clearText(txtListNameUnderCopyList, "List Name textbox");
			actionUtil.typeText(txtListNameUnderCopyList,listName, "List Name textbox");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to enter value into List Name textbox");
			Assert.fail("Unable to enter value into List Name textbox");
		}
	}

	/**
	 * Description Method to Select Value From Boards Dropdown Under Copy List.
	 * 
	 * @author Ashish Piplodiya
	 * @param optBoards
	 */
	public synchronized void sltBoardsOptUnderCopyList(String optBoards) {
		try {

			actionUtil.waitForElement(ddBoardUndercopyList, "Boards Dropdown");
			actionUtil.clickOnElement(ddBoardUndercopyList, "Boards Dropdown");

			actionUtil.waitForElement(optBoard(optBoards), "Boards Option");
			actionUtil.clickOnElement(optBoard(optBoards), "Boards Option");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Select value from Boards Dropdown");
			Assert.fail("Unable to Select value from Boards Dropdown");
		}
	}

	/**
	 * Description Method to Select Value From position Dropdown Under Copy List.
	 * 
	 * @author Ashish Piplodiya
	 * @param optPosition
	 */
	public synchronized void sltPositionOptUnderCopyList(String optPosition) {
		try {

			actionUtil.waitForElement(ddPositionUnderCopyList, "Position Dropdown");
			actionUtil.clickOnElement(ddPositionUnderCopyList, "Position Dropdown");

			actionUtil.waitForElement(optPosition(optPosition), "Position Options");
			actionUtil.clickOnElement(optPosition(optPosition), "Position Options");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Select value from Position Dropdown");
			Assert.fail("Unable to Select value from Position Dropdown");
		}
	}

	/**
	 * Description Method to click on List Action Under Boards Dashboard
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkListActionsBoards() {
		try {

			actionUtil.waitForElement(listActionBoards, "List Actions Board");
			actionUtil.clickOnElement(listActionBoards, "List Actions Board");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on List Actions Board");
			Assert.fail("Unable to click on List Actions Board");
		}
	}

	/**
	 * Description Method to click on Boards Settings.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkBoardSetting() {
		try {

			actionUtil.waitForElement(linkBoardSettings, "Boards Settings");
			actionUtil.clickOnElement(linkBoardSettings, "Boards Settings");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Boards Settings");
			Assert.fail("Unable to click on Boards Settings");
		}
	}
	
	
	/**
	 * Description Method to click on Archieved list Under Board Actions
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkArchievedlistUnderBoardActions() {
		try {

			actionUtil.waitForElement(linkArchievedList, "Archieved list");
			actionUtil.clickOnElement(linkArchievedList, "Archieved list");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Archieved list");
			Assert.fail("Unable to click on Archieved list");
		}
	}

	/**
	 * Description Method to click on Close Boards.
	 * 
	 * @author Ashish Piplodiya
	 * @param boardName
	 */
	public synchronized void clkCloseBoards(String boardName) {
		try {

			actionUtil.scrollToElement("Close Boards", "Close board");
			actionUtil.waitForElement(linkCloseBoards, "Close Boards");
			actionUtil.clickOnElement(linkCloseBoards, "Close Boards");
			
			validateBoardIsClosed(boardName);

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Close Boards");
			Assert.fail("Unable to click on Close Boards");
		}
	}

	
	
	
	
	/**
	 * Description Method to validate board is closed or not.
	 * 
	 * @author Ashish Piplodiya
	 * @param boardName
	 */
	public synchronized void validateBoardIsClosed(String boardName) {
		try {

			
			actionUtil.waitForElement(txtBoardIsClosed(boardName), "This board is closed text");
			actionUtil.isElementDisplayed(txtBoardIsClosed(boardName), "This board is closed text");
			
			actionUtil.extentinfo("This board is closed text is Displayed");
			actionUtil.pass("Board Closed Successfully");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Close Boards");
			Assert.fail("Unable to click on Close Boards");
		}
	}
	
	
	/**
	 * Description Method to click on Reopen Boards.
	 * 
	 * @author Ashish Piplodiya
	 * @param boardName
	 */
	public synchronized void clkReOpenBoards(String boardName) {
		try {

			actionUtil.waitForElement(btnReOpenBoard, "Reopen Boards");
			actionUtil.clickOnElement(btnReOpenBoard, "Reopen Boards");
			
			validateBoardName(boardName);
			

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Reopen Boards");
			Assert.fail("Unable to click on Reopen Boards");
		}
	}
	
	
	/**
	 * Description Method to click on Reopen Boards.
	 * 
	 * @author Ashish Piplodiya
	 * @param cardName , listName
	 */
	public synchronized void dragAndDropElement(String cardName , String listName) {
		try {

			actionUtil.waitForElement(linkCardName(cardName), "Element To Drag");
			actionUtil.waitForElement(dropTo(listName), "Element To Drop");
			
			
			androidDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Zoom out on board']")).click();
			
			actionUtil.poll(2000);
			actionUtil.dragAndDrop(androidDriver, linkCardName(cardName), dropTo(listName));
			
			androidDriver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Zoom in on board']")).click();
			
			validateDragAndDrop(cardName, listName);
			

		    } catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Drag and Drop");
			Assert.fail("Unable to Drag and Drop");
		   }
	}
	
	
	/**
	 * Description Method to Validate Drag and Drop
	 * 
	 * @author Ashish Piplodiya
	 * @param cardName , expectedListName
	 */
	public synchronized void validateDragAndDrop(String cardName , String expectedListName) {
		String actualListName =null;
		try {
			
			actionUtil.waitForElement(validatedDrop(cardName), "List Name");
			
		     actualListName = validatedDrop(cardName).getText();
		
		    Assert.assertEquals(actualListName, expectedListName);
		    
		   actionUtil.info("Drag Card : "+cardName+" And Drop To : "+actualListName+" List Successfully");
		  
		   actionUtil.validationinfo("Drag Card : "+cardName+" And Drop To : "+actualListName+" List Successfully" ,"blue");
		   
		   actionUtil.pass(cardName+" : Card Moved Successfully To "+actualListName+" List");
			
		   } 
		catch (Exception e) {
			actionUtil.error("Expected List :"+expectedListName+" not Matched with Actual List :"+actualListName);
			actionUtil.fail("Expected List :"+expectedListName+" not Matched with Actual List :"+actualListName);
			Assert.fail("Expected List :"+expectedListName+" not Matched with Actual List :"+actualListName);
		}
	}
	
	
	
	
	
	/**
	 * Description Method to click on Back Button.
	 * 
	 * @author Ashish Piplodiya
	 */
	public synchronized void clkBackButton() {
		try {

			actionUtil.waitForElement(btnBack, "Back Button");
			actionUtil.clickOnElement(btnBack, "Back Button");
			
			

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Back Button");
			Assert.fail("Unable to click on Back Button");
		}
	}
	
	/**
	 * Description Method to Set List Name.
	 * 
	 * @author Ashish Piplodiya
	 * @param listName , newlistName
	 */
	public synchronized void setEditListNameTa(String listName , String newlistName) {
		try {

			actionUtil.waitForElement(linklistName(listName), "List Name");
			actionUtil.clickOnElement(linklistName(listName), "List Name");
			actionUtil.clearText(linklistName(listName), "List Name");
			actionUtil.typeText(linklistName(""), newlistName , "List Name");

			String actualListName = linklistName(newlistName).getText();
			 Assert.assertEquals(actualListName, newlistName);
			 
			 actionUtil.info("List Name Updated Successfully");
			 actionUtil.pass("List Name Updated Successfully");
			
			
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Enter Value into Edit List Name Textbox");
			Assert.fail("Unable to Enter Value into Edit List Name Textbox");
		}
	}
	
	/**
	 * Description Method to Select the list under Move All Card Popup
	 * 
	 * @author Ashish Piplodiya
	 * @param optListss
	 */
	
	public synchronized void sltListOptUnderMoveAllCardsInList(String optLists) {
		try {

			actionUtil.waitForElement(ddList, "List Dropdown");
			actionUtil.clickOnElement(ddList, "List Dropdown");

			actionUtil.waitForElement(optList(optLists), "List Option");
			actionUtil.clickOnElement(optList(optLists), "List Option");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to Select value from List Dropdown");
			Assert.fail("Unable to Select value from List Dropdown");
		}
	}
	
	
	
	
	/**
	 * Description Method to click List Under Archieved List Under Boards Actions
	 * 
	 * @author Ashish Piplodiya
	 * @param list
	 */
	public synchronized void clkArchievedListOptions(String list) {
		try {

			actionUtil.waitForElement(linkArchievedLists(list), "List Under Archieved List");
			actionUtil.clickOnElement(linkArchievedLists(list), "List Under Archieved List");

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on List Under Archieved List");
			Assert.fail("Unable to click on List Under Archieved List");
		}
	}
	
	
	/**
	 * Description Method to validate the Copied list (check whether the copied list is same as the original list or not)
	 * 
	 * @author Gaurav S Rai
	 * @param firstListName, copiedListName, originalListName , position 
	 */
	public synchronized void validateTheCopiedList(String firstListName,String copiedListName,String originalListName ,int position ) {
		try {
			
			
			actionUtil.swipeRightToTheElement("//android.widget.EditText[@text='"+firstListName+"']/parent::android.widget.LinearLayout/descendant::android.widget.ImageView");
			
             Set<String>setNames=new LinkedHashSet<>();
             List<String>actualCardNames=new ArrayList<>();
             List<String>copiedCardNames=new ArrayList<>();
             
             actionUtil.poll(3000);
           
             String secondName="notNull";
             boolean flagOriginal=true;
             boolean flagCopied=true;
             infinate:
             for(; ;)
             {
            	 
            	 String name="";
            	 String firstNme="";
            	 
	             for(AndroidElement ele:txtNameList)
	             {
	            	  name=ele.getText();
	            	  firstNme=name+firstNme;
	            	  setNames.add(name);
	            	 
	            	  if(name.equalsIgnoreCase(originalListName)&& flagOriginal==true)
	            	  {
	            		 List<AndroidElement> originalCardName= selectList(originalListName);
	            		 for(AndroidElement cardName:originalCardName)
	            		 {
	            			 String originalcardName=cardName.getText();
	            			 actualCardNames.add(originalcardName);
	            			 flagOriginal=false;
	            		 }
	            	  }
	            	  else if(name.equalsIgnoreCase(copiedListName)&& flagCopied==true)
	            	  {
	            		     List<AndroidElement> copiedCardName= selectList(copiedListName);
		            		 for(AndroidElement cardName:copiedCardName)
		            		 {
		            			 String copiedCard=cardName.getText();
		            			 copiedCardNames.add(copiedCard);
		            			 flagCopied=false;
		            		 }
	            	  }
	            	 
	            	 
	             }
	             
	             actionUtil.swipeLeft();
            
	             if(firstNme.equalsIgnoreCase(secondName))
	             {
	            	 break infinate;
	             }
	             secondName=firstNme;
             }
			
             List<String>listNames=new ArrayList<>(setNames);
             
             int listCount=0;
             for(int i=0;i<listNames.size();i++)
             {
            	 if(copiedListName.equalsIgnoreCase(listNames.get(i)))
            	 {
            		 listCount++;
            		 break;
            	 }
            	 else
            		 listCount++;
             }
             
             
             if(listCount==position && actualCardNames.equals(copiedCardNames))
             {
            	 actionUtil.info("Succesfully Copied the List To  "+position+" position");
            	 actionUtil.pass("Succesfully Copied the List To  "+position+" position");
            	
             }
             else
             {
            	 actionUtil.info("Failed to copy the List To  "+position+" position");
            	 actionUtil.fail("Failed to copy the List To "+position+" position");
            	 actionUtil.validationinfo("Failed to copy the List To  "+position+" position", "red");
            	  
             }
            
			
		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Failed to Copy the List To  "+position+" position");
			Assert.fail("Failed to Copy the List To "+position+" position");
		}
	}
	
	
	
	/**
	 * Description Method to validate the Position Of List
	 * 
	 * @author Gaurav S Rai
	 * @param expectedPosition,listName, firstListName
	 */
	public synchronized void validateThePositionOfList(int expectedPosition,String listName,String firstListName) {
		try {
			
			
			actionUtil.swipeRightToTheElement("//android.widget.EditText[@text='"+firstListName+"']/parent::android.widget.LinearLayout/descendant::android.widget.ImageView");
			
             Set<String>setNames=new LinkedHashSet<>();
             
             String secondName="notNull";
             infinate:
             for(; ;)
             {
            	 
            	 String name="";
            	 String firstNme="";
            	 
	             for(AndroidElement ele:txtNameList)
	             {
	            	  name=ele.getText();
	            	  firstNme=name+firstNme;
	            	 setNames.add(name);
	            	 
	            	 
	             }
	            
	             actionUtil.swipeLeft();

	             
	             if(firstNme.equalsIgnoreCase(secondName))
	             {
	            	 break infinate;
	             }
	             secondName=firstNme;
	            
             }
			
             List<String>listNames=new ArrayList<>(setNames);
             
             int listCount=0;
             for(int i=0;i<listNames.size();i++)
             {
            	 if(listName.equalsIgnoreCase(listNames.get(i)))
            	 {
            		 listCount++;
            		 break;
            	 }
            	 else
            		 listCount++;
             }
             
             
             if(listCount==expectedPosition)
             {
            	 actionUtil.info("Succesfully Moved List To The "+expectedPosition+" position");
            	 actionUtil.pass("Succesfully Moved List To The "+expectedPosition+" position");
            	
             }
             else
             {
            	 actionUtil.info("Failed to move the List To The "+expectedPosition+" position");
            	 actionUtil.fail("Failed to move the List To The "+expectedPosition+" position");
            	 actionUtil.validationinfo("Failed to move the List To The "+expectedPosition+" position", "red");
            	 
            	 
             }

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Failed to move the List To The "+expectedPosition+" position");
			Assert.fail("Failed to move the List To The "+expectedPosition+" position");
		}
	}
	
	/**
	 * Description Method to validate whether all the cards are moved to another list or not
	 * 
	 * @author Gaurav S Rai
	 * @param firstListName , actualListName,movedCardsList , expectedCard
	 */
	public synchronized void validateMovedCards(String firstListName,String actualListName,String movedCardsList , List<String> expectedCard) {
		try {
			
			
			
			actionUtil.swipeRightToTheElement("//android.widget.EditText[@text='"+firstListName+"']/parent::android.widget.LinearLayout/descendant::android.widget.ImageView");
			
             Set<String>setNames=new LinkedHashSet<>();
             List<String>actualList=new ArrayList<>();
             List<String>cardMovedList=new ArrayList<>();
             
             boolean flagOriginal=true;
             boolean flagCopied=true;
             String secondName="notNull";
             infinate:
             for(; ;)
             {
            	 
            	 String name="";
            	 String firstNme="";
            	 
	             for(AndroidElement ele:txtNameList)
	             {
	            	
	            	  name=ele.getText();
	            	  firstNme=name+firstNme;
	            	  setNames.add(name);
	            	 
	            	 
	             }
	             
	             if(name.equalsIgnoreCase(actualListName)&& flagOriginal==true)
           	  {
	            	 
           		 List<AndroidElement> originalCardName= selectList(actualListName);
           		 for(AndroidElement cardName:originalCardName)
           		 {
           			 String originalcardName=cardName.getText();
           			 actualList.add(originalcardName);
           			 flagOriginal=false;
           		 }
           	  }
           	  else if(name.equalsIgnoreCase(movedCardsList)&& flagCopied==true)
           	  {
           		 
           		     List<AndroidElement> copiedCardName= selectList(movedCardsList);
	            		 for(AndroidElement cardName:copiedCardName)
	            		 {
	            			 String copiedCard=cardName.getText();
	            			 cardMovedList.add(copiedCard);
	            			 flagCopied=false;
	            			 
	            		 }
	            		 
	            		 
           	  }
	            
	             actionUtil.swipeLeft();          
	             if(firstNme.equalsIgnoreCase(secondName))
	             {
	            	 break infinate;
	             }
	             secondName=firstNme;
	            
             }
			
   
            
             
            
             if(actualList.isEmpty()&& cardMovedList.equals(expectedCard))
             {
            	 actionUtil.info("Successfully moved the cards to "+movedCardsList+" list");
            	 actionUtil.pass("Successfully moved the cards to "+movedCardsList+" list");
            	
             }
             else
             {
            	 actionUtil.info("Failed to move the cards to "+movedCardsList+" list");
            	 actionUtil.fail("Failed to move the cards to "+movedCardsList+" list");
            	 actionUtil.validationinfo("Failed to move the cards to "+movedCardsList+" list", "red");
            	 
            
             }

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Failed to move the cards to "+movedCardsList+" list");
			Assert.fail("Failed to move the cards to "+movedCardsList+" list");
		}
	}
	
	/**
	 * Description Method to Validate Board Name
	 * 
	 * @author Ashish Piplodiya
	 * @param expectedBoardName
	 */
	public synchronized void validateBoardName(String expectedBoardName) {
		String actualBoardName =null;
		try {
			
			actionUtil.waitForElement(txtValidateBoardName, "Board Name Text");
			
		     actualBoardName = txtValidateBoardName.getText();
		
		    Assert.assertEquals(actualBoardName, expectedBoardName);
		    
		   actionUtil.info("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
		   actionUtil.validationinfo("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName , "blue");
		   
		   actionUtil.pass(expectedBoardName+" Opened Successfully");
			
		   } 
		catch (Exception e) {
			actionUtil.error("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
			actionUtil.fail("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
			actionUtil.fail("Unable to validate Board is Opened");
			Assert.fail("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
		}
	}
	
	/**
	 * Description Method to Click on Star Board.
	 * 
	 * @author Ashish Piplodiya
	 */
	
	public synchronized void clkStartBoardBtn() {
		try {

			actionUtil.waitForElement(btnStarBoard, "Star Board Button");
			actionUtil.clickOnElement(btnStarBoard, "Star Board Button");
			
//			actionUtil.tapByCoordinates(androidDriver, 100, 100, "Star Board Button");
//			

		} catch (Exception e) {
			actionUtil.error(e.getMessage());
			actionUtil.fail("Unable to click on Star Board Button");
			Assert.fail("Unable to click on Star Board Button");
		}
	}
	
	

}
