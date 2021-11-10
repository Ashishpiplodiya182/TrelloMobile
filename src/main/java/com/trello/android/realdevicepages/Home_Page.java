package com.trello.android.realdevicepages;

import java.util.List;

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
 * Description:This class has Method Implementation for Home Page.
 * 
 * @author Gaurav S , Ashish
 *
 */
public class Home_Page 
{
	

		public AndroidDriver<AndroidElement> androidDriver;
		public MobileActionUtil actionUtil;
		public long ETO = 15;

		public Home_Page(AndroidDriver<AndroidElement> androidDriver, long ETO, MobileActionUtil actionUtil) 
		{
			this.androidDriver = androidDriver;
			PageFactory.initElements(new AppiumFieldDecorator(androidDriver), this);
			this.actionUtil = actionUtil;
			this.ETO = ETO;
		

         }
		
		/* Menu Icon */
		@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Open drawer\"]")
		private AndroidElement iconMenu;
		
		/* Settings Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
		private AndroidElement lnkSettings;
		
		/* Logout Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log out']")
		private AndroidElement lnkLogout;
		
		/* Boards Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Boards']")
		private AndroidElement linkBoards;
		
		/* Home Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
		private AndroidElement linkHome;
		
		/* My Cards Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='My cards']")
		private AndroidElement linkMyCards;
		
		/* My Cards Link */
		@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/textinput_placeholder']")
		private AndroidElement taBoards;
		
		/* Plus Icon */
		@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.trello:id/add_fab']")
		private AndroidElement iconPlus;
		
		/* Boards Icon */
		@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.trello:id/add_board_fab']")
		private AndroidElement iconBoards;
		
		/* Cards Icon */
		@AndroidFindBy(xpath = "//android.widget.ImageButton[@resource-id='com.trello:id/add_card_fab']")
		private AndroidElement iconCard;
		
		/* Create Board Textbox */
		@AndroidFindBy(xpath = "//android.widget.EditText[@resource-id='com.trello:id/board_name']")
		private AndroidElement txtBoardName;
		
		/* Confirm Tick Mark */
		@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/confirm']")
		private AndroidElement tickMarkConfirm;
		
		/* Link Workspace Name */
		public AndroidElement linkWorkspaceName(String workspaceName) {

			String xpath = "//android.widget.FrameLayout/following-sibling::android.widget.TextView[@text='"+workspaceName+"']";

			return androidDriver.findElementByXPath(xpath);
		}
		
		/* Login button */
		@AndroidFindBy(xpath = "//android.widget.Button[@text='Log in']")
		private AndroidElement btnLogin;
		
		
		/* Board Name Under Closed Boards */
		public AndroidElement txtClosedBoard(String boardName) {

			String xpath = "//android.widget.TextView[@text='"+boardName+"']";

			return androidDriver.findElementByXPath(xpath);
		}
		
		
		/* Validate Board Name Text */
		@AndroidFindBy(xpath = "//android.widget.TextView[@resource-id='com.trello:id/toolbar_title']")
		private AndroidElement txtValidateBoardName;
		
		/* Starred Board List */
		@AndroidFindBy(xpath = "//android.widget.TextView[@text='Starred boards']/following-sibling::android.view.ViewGroup/android.widget.FrameLayout/descendant::android.widget.TextView")
		private List<AndroidElement> txtStarredBoard;
		
		
		/**
		 * Description Method to click on Menu Icon.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkMenuIcon() {
			try {
				
				actionUtil.waitForElement(iconMenu, "Menu Icon");
				actionUtil.clickOnElement(iconMenu, "Menu Icon");
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Menu Icon");
				Assert.fail("Unable to click on Menu Icon");
			}
		}
		
		
		/**
		 * Description Method to click on Boards Link.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkBoardsLink() {
			try {
				
				actionUtil.waitForElement(linkBoards, "Boards Link");
				actionUtil.clickOnElement(linkBoards, "Boards Link");
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Boards Link");
				Assert.fail("Unable to click on Boards Link");
			}
		}
		
		/**
		 * Description Method to click on Home Link.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkHomeLink() {
			try {
				
				actionUtil.waitForElement(linkHome, "Home Link");
				actionUtil.clickOnElement(linkHome, "Home Link");
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Home Link");
				Assert.fail("Unable to click on Home Link");
			}
		}
		
		/**
		 * Description Method to click on My Cards Link.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkMyCardsLink() {
			try {
				
				actionUtil.waitForElement(linkMyCards, "My Cards Link");
				actionUtil.clickOnElement(linkMyCards, "My Cards Link");
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on My Cards Link");
				Assert.fail("Unable to click on My Cards Link");
			}
		}
		
		/**
		 * Description Method to click on Plus Icon.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkPlusIcon() {
			try {
				
				
				actionUtil.waitForElement(iconPlus, "Plus Icon");
				actionUtil.clickOnElement(iconPlus, "Plus Icon");
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Plus Icon");
				Assert.fail("Unable to click on Plus Icon");
			}
		}
		
		/**
		 * Description Method to click on Card Icon.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkCardIcon() {
			try {
				
				actionUtil.waitForElement(iconCard, "Card Icon");
				actionUtil.clickOnElement(iconCard, "Card Icon");
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Card Icon");
				Assert.fail("Unable to click on Card Icon");
			}
		}
		
		/**
		 * Description Method to click on Boards Icon.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkBoardsIcon() {
			try {
				
				actionUtil.waitForElement(iconBoards, "Boards Icon");
				actionUtil.clickOnElement(iconBoards, "Boards Icon");
				
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Boards Icon");
				Assert.fail("Unable to click on Boards Icon");
			}
		}
		
		

		/**
		 * Description Method to Validate Board Creation
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
			   actionUtil.pass("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
				
			   } 
			catch (Exception e) {
				actionUtil.error("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
				actionUtil.fail("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
				Assert.fail("Expected Board :"+expectedBoardName+" Matched with Actual Board :"+actualBoardName);
			}
		}
		
		
		
		/**
		 * Description Method to Set value on Board Name Textbox.
		 * 
		 * @author Ashish Piplodiya
		 * @param boardName
		 */
		public synchronized void setBoardName(String boardName) {
			try {
				
				actionUtil.waitForElement(txtBoardName, "Board Name Textbox");
				
				actionUtil.typeText(txtBoardName, boardName, "Board Name Textbox");
				
				clkConfirmTickMark();
				
				validateBoardName(boardName);
				
				
			   } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to Enter Value on Board Name Textbox");
				Assert.fail("Unable to Enter Value on Board Name Textbox");
			}
		}
		
		
		/**
		 * Description Method to Validate The Starred Board
		 * 
		 * @author Gaurav S Rai
		 * @param expectedBoardName
		 */
		public synchronized void validateStarredBoard(String expectedBoardName) {
			try {
				
				boolean flag=false;
				  for(AndroidElement ele:txtStarredBoard)
				  {
					  System.out.println(ele.getText());
					  if(ele.getText().equalsIgnoreCase(expectedBoardName))
					  {
						  actionUtil.info("The board has been starred with name "+expectedBoardName);
						  actionUtil.pass("The board has been starred with name "+expectedBoardName);
						  actionUtil.validationinfo("The board has been starred with name "+expectedBoardName,"green");
						  flag=true;
						  break;
					  }
				  }
				  
				  if(flag==false)
				  {
					  actionUtil.info("Failed to star the board with name "+expectedBoardName);
					  actionUtil.fail("Failed to star the board with name "+expectedBoardName);
					  actionUtil.validationinfo("Failed to star the board with name "+expectedBoardName,"red");
				  }
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Failed to star the board with name "+expectedBoardName);
				Assert.fail("Failed to star the board with name "+expectedBoardName);
			}
		}
		
		
		/**
		 * Description Method to click on Confirm Tick Mark.
		 * 
		 * @author Ashish Piplodiya
		 */
		public synchronized void clkConfirmTickMark() {
			try {
				
				actionUtil.waitForElement(tickMarkConfirm, "Confirm Tick Mark");
				actionUtil.clickOnElement(tickMarkConfirm, "Confirm Tick Mark");
				
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Confirm Tick Mark");
				Assert.fail("Unable to click on Confirm Tick Mark");
			}
		}
		
		/**
		 * Description Method to click on Workspace Name Link.
		 * 
		 * @author Ashish Piplodiya
		 * @param workspaceName
		 */
		public synchronized void clkWorkSpaceLink(String workspaceName) {
			try {
				
				actionUtil.waitForElement(linkWorkspaceName(workspaceName), "Workspace Name Link");
				actionUtil.clickOnElement(linkWorkspaceName(workspaceName), "Workspace Name Link");
				
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Workspace Name Link");
				Assert.fail("Unable to click on Workspace Name Link");
			}
		}
		
		/**
		 * Description Method to click on Board under Closed Board.
		 * 
		 * @author Ashish Piplodiya
		 * @param closedBoardName
		 */
		public synchronized void clkBoardUnderClosedBoards(String closedBoardName) {
			try {
				
				actionUtil.scrollToElement("Board under Closed Board", closedBoardName);
				actionUtil.waitForElement(txtClosedBoard(closedBoardName), "Board under Closed Board");
				actionUtil.clickOnElement(txtClosedBoard(closedBoardName), "Board under Closed Board");
				
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Board under Closed Board");
				Assert.fail("Unable to click on Board under Closed Board");
			}
		}
		
		/**
		 * Description Method to click on Settings Link.
		 * 
		 * @author Ashish Piplodiya
		 * @param closedBoardName
		 */
		public synchronized void clkOnSettingsLink() {
			try {
				
				actionUtil.scrollToElement("Settings Link", "Settings");
				actionUtil.waitForElement(lnkSettings, "Settings Link");
				actionUtil.clickOnElement(lnkSettings, "Settings Link");
				
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to click on Settings Link");
				Assert.fail("Unable to click on Settings Link");
			}
		}
		
		/**
		 * Description Method to Logout From the Application
		 * 
		 * @author Ashish Piplodiya
		 * @param closedBoardName
		 */
		public synchronized void logoutFromTheApplication() 
		{
			try {
				
				clkMenuIcon();
				clkOnSettingsLink();
				actionUtil.scrollToElement("Logout Link", "Log out");
				actionUtil.waitForElement(lnkLogout, "logout Link");
				actionUtil.clickOnElement(lnkLogout, "logout Link");
				
				actionUtil.isElementDisplayed(btnLogin, "Login Button");
				
				actionUtil.pass("Logout From The Application Successfully");
				
				
			  } 
			catch (Exception e) {
				actionUtil.error(e.getMessage());
				actionUtil.fail("Unable to Logout from the Application");
				Assert.fail("Unable to Logout from the Application");
			}
		}
		

}
