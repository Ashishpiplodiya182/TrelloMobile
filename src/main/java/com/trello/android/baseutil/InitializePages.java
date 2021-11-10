package com.trello.android.baseutil;


import com.trello.android.realdevicepages.BoardDashboard_Page;
import com.trello.android.realdevicepages.Card_Modification_Page;

import com.trello.android.realdevicepages.Home_Page;
import com.trello.android.realdevicepages.Login_Page;
import com.trello.android.util.MobileActionUtil;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Description: Initialize all pages with androidDriver,ETO, MobileActionUtil
 * 
 * @author: Ashish, gaurav
 */

public class InitializePages {
	
	public Home_Page home_Page;
	public BoardDashboard_Page boardDashboard_page;
	public Card_Modification_Page cardModification_page;
	public Login_Page login_Page;
	
	
	
	public InitializePages(AndroidDriver<AndroidElement> androidDriver, long ETO, MobileActionUtil actionUtil) {

		home_Page = new Home_Page(androidDriver, ETO, actionUtil);
		boardDashboard_page = new BoardDashboard_Page(androidDriver, ETO, actionUtil);
		cardModification_page = new Card_Modification_Page(androidDriver, ETO, actionUtil);
		login_Page=new Login_Page(androidDriver, ETO, actionUtil);
	}

}
