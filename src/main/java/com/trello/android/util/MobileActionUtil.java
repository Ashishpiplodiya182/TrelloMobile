package com.trello.android.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.trello.android.baseutil.BaseTest;
import com.trello.android.extentreports.ExtentManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDeviceActionShortcuts;
//import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.AndroidKeyMetastate;
/**
 * Description: This class contains action methods which is used for performing
 * action while executing script such as Click, SendKeys
 * 
 * @author : Vikas, Sajal
 */
public class MobileActionUtil {

	public static AndroidDriver<AndroidElement> androidDriver;
	public static WebDriverWait wait;
	public long ETO;
	public JavascriptExecutor jsExecutor;
	public Actions action;
	public static TakesScreenshot screenshot;
	public static TouchAction touchAction;

	public MobileActionUtil(AndroidDriver<AndroidElement> androidDriver, long ETO) {
		this.androidDriver = androidDriver;
		this.ETO = ETO;
		wait = new WebDriverWait(androidDriver, ETO);
		jsExecutor = (JavascriptExecutor) androidDriver;
		action = new Actions(androidDriver);
		screenshot = (TakesScreenshot) androidDriver;
		touchAction = new TouchAction(androidDriver);
	}

	/**
	 * Description Method to provide info in the log,testNg reports
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void info(String message) {
		BaseTest.logger.info(message);
	}

	/**
	 * 
	 * Description Method for the Error updation in Log file,TestNG Report
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void error(String message) {
		BaseTest.logger.error(message);
	}

	/**
	 * Description Method to provide info in the extent report
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void extentinfo(String message) {
		ExtentManager.getTestReport().info(message);
	}

	/**
	 * 
	 * Description Method for the info updation in extent Report
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void pass(String message) {
		ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * 
	 * Description Method for the error/error updation in extent Report
	 * 
	 * @author vikas, sajal
	 * @param message
	 */
	public static synchronized void fail(String message) {
		ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));

	}

	/**
	 * Description Method for the error/errorure updation in extent Report
	 * 
	 * @author Sajal
	 * @param message
	 * @param color
	 * 
	 */
	public static synchronized void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))
			ExtentManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * Description Method for fetching of get Current Date Time
	 * 
	 * @author Sajal
	 */
	public static synchronized String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * 
	 * Description Check Element is clickable with expected conditions
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public synchronized static boolean isElementClickable(AndroidElement element, String elementName) {
		info("Validate " + elementName + " is clickable");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return true;
		} catch (Exception e) {
			error(elementName + " is not clickable");
			return false;
		}
	}

	public static void poll(int poll) {

		try {
			Thread.sleep(poll);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Description Check Element is displayed with expected conditions
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public synchronized boolean isElementDisplayed(AndroidElement element, String elementName) {
		info("Validate " + elementName + " is displayed");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.isDisplayed();
			info(elementName + " is displayed");
			return true;
		} catch (Exception e) {
			error(elementName + " is not displayed");
			return false;
		}
	}

	/**
	 * Description : Checks element is visible
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public static synchronized void isElementPresent(AndroidElement element, String elementName) {
		info("Validate " + elementName + " is present");
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			info(elementName + " is present");
		} catch (Exception e) {
			error(elementName + " is not present");
		}
	}

	/**
	 * 
	 * Description Wait for the Element is displayed with expected conditions
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public synchronized static void waitForElement(AndroidElement element, String elementName) {
		try {
			info("Wait for visibility of " + elementName);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			error(elementName + " is not visible");
		}
	}

	/**
	 * Description : Hide the keyboard
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 * 
	 */
	public synchronized static void hideKeyboard() {
		try {
			androidDriver.hideKeyboard();
			info("Keyboard is hidden");
			// implicitWait(2);
		} catch (Exception e) {
		}
	}

	/**
	 * Description Scroll to the Element
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public synchronized static void scrollToElement(String elementName, String elementText) {
		info("Scroll till the " + elementName);

		try {

			androidDriver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()"
							+ ".scrollIntoView(new UiSelector().text(\"" + elementText + "\"))");
			info("Scroll till the " + elementName + " completed");
			validationinfo("Scroll till the " + elementName + " completed", "blue");

		}

		catch (Exception e) {
			error("Scroll till the " + elementName + " failed");
			Assert.fail("Scroll till the " + elementName + " failed");
		}
	}

	/**
	 * Description Method clicks on element
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public static synchronized void clickOnElement(AndroidElement element, String elementName) {
		if (isElementClickable(element, elementName)) {
			element.click();
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} else {
			error("Unable to click on " + elementName);
			//fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description Capture the screenshot of the complete screen
	 * 
	 * @author Vikas, Sajal
	 * @param screenShotPath
	 * @return
	 */
	public synchronized static String getScreenShot(String screenShotPath) {
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		String dest = screenShotPath + BaseTest.className + ".png";
		File destination = new File(dest);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			error("Capture Failed " + e.getMessage());
		}
		return "./Screenshots/" + BaseTest.className + ".png";
	}

	/**
	 * Description Implicit wait for element to laod
	 * 
	 * @author Vikas, Sajal
	 * @param Seconds
	 */
	public synchronized static void implicitWait(int Seconds) {
		androidDriver.manage().timeouts().implicitlyWait(Seconds, TimeUnit.SECONDS);
	}

	/**
	 * Description : Wait for given time
	 * 
	 * @author Sajal
	 * @param millis
	 */
	public synchronized static void waitForElementToLoad(int milliSeconds) {
		try {
			Thread.sleep(milliSeconds);
		} catch (InterruptedException e) {
		}
	}

	/**
	 * Description Method to click typ
	 * 
	 * @author Vikas, Sajal
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public static synchronized void clickAndType(AndroidElement element, String value, String elementName) {
		try {
			waitForElement(element, elementName);
			element.click();
			// implicitWait(2);
			element.clear();
			waitForElementToLoad(10000);
			androidDriver.getKeyboard().sendKeys(value);
			// implicitWait(1);
			androidDriver.hideKeyboard();
			info("Clicked and type the value in " + elementName);
			extentinfo("Clicked and type the value in " + elementName);
		} catch (AssertionError error) {
			fail("Unable to click and type the value in " + elementName);
			error("Unable to click and type the value in " + elementName);
			Assert.fail("Unable to click and type the value in " + elementName);
		} catch (Exception e) {
			fail("Unable to click and type the value in " + elementName);
			error("Unable to click and type the value in " + elementName);
			Assert.fail("Unable to click and type the value in " + elementName);
		}
	}

	public synchronized void typeText(WebElement element, String value, String elementName) {
		try {

			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(value);
			extentinfo(value + " is entered into " + elementName);
			info(value + " is entered into " + elementName);

		} catch (AssertionError error) {
			fail(value + " is not entered into " + elementName);
			error(value + " is not entered into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		} catch (Exception e) {
			fail(value + " is not entered into " + elementName);
			error(value + " is not entered into " + elementName);
			Assert.fail("Unable to type in " + elementName);
		}
	}

	/**
	 * Description Method to delete the directory
	 * 
	 * @author Sajal
	 * @param pathToDeleteFolder
	 */
	public static synchronized void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * 
	 * Description Method to delete folder directory
	 * 
	 * @author Sajal
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}

		}
		folderToDelete.delete();
	}

	/**
	 * Description Method to perform horizontal Swipe
	 * 
	 * @author Vikas, Sajal
	 * @param startPercentage
	 * @param endPercentage
	 */
	public synchronized void horizontalSwipeByPercentages(double startPercentage, double endPercentage) {
		try {
			Dimension size = androidDriver.manage().window().getSize();
			int startPoint = (int) (size.width * startPercentage);
			int endPoint = (int) (size.width * endPercentage);
			touchAction.press(PointOption.point(endPoint, startPoint))
					.waitAction(new WaitOptions().withDuration(Duration.ofMillis(600)))
					.moveTo(PointOption.point(startPoint, endPoint)).release().perform();
			info("Horizontal swipe performed");
			extentinfo("Horizontal swipe performed");
		} catch (Exception e) {
			error("Unable to perform Horizontal swipe");
			fail("Unable to perform Horizontal swipe");
			Assert.fail("Unable to perform Horizontal swipe");
		}
	}

	/**
	 * Description Method to perform horizontal Swipe
	 * 
	 * @author Vikas, Sajal
	 * @param value
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 */
	public synchronized static void swipeUsingCoordinate(int value, int startx, int starty, int endx, int endy) {
		try {
			info("Swiping the element using Co-ordinates");
			for (int i = 1; i <= value; i++) {
				touchAction.longPress(PointOption.point(startx, starty)).moveTo(PointOption.point(endx, endy)).release()
						.perform();
				waitForElementToLoad(1000);
			}
			extentinfo("Swiping the element using Co-ordinates");
		} catch (AssertionError error) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		} catch (Exception e) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		}
	}

	/**
	 * Description Clear the Text
	 * 
	 * @author Sajal, Vikas
	 * @param element
	 * @param elementName
	 */
	public synchronized void clearText(AndroidElement element, String elementName) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			element.clear();
			info("Clear the text present in" + elementName);
		} catch (Exception e) {
			error("Unable to clear the text in " + elementName);
		}
	}

	/**
	 * Description Method to get the attribute value for Monfarmer
	 * 
	 * @author Sajal, Vikas
	 * @param element
	 * @param elementName
	 */
	public static synchronized void getAttribute(AndroidElement element, String elementName) {
		try {
			waitForElement(element, elementName);

			// WebElement
			// we3=driver.findElementByXPath("//android.view.View[contains(@content-desc,'Mobfarmer')]");
			String r = element.getAttribute("content-desc");
			CharSequence actualFarmer = r.subSequence(2, 11);
			System.out.println(actualFarmer);
			String ra = element.getAttribute("content-desc");
			CharSequence actualvalue = ra.subSequence(2, 11);
			System.out.println(actualFarmer);

			// WebElement we3 =
			// driver.findElementByXPath("//android.view.View[contains(@content-desc,'Mobfarmer')]");
			// System.out.println(we3.getAttribute("content-desc"));
			// String r= we3.getAttribute("content-desc");
			// CharSequence m =r.subSequence(2, 1);
			// System.out.println(m);
			info("User is able to get value " + elementName);

			extentinfo("User is able to get value " + elementName);
		} catch (Exception e) {
			e.printStackTrace();
			error("User is not able to get value " + elementName);
			fail("User is not able to get value " + elementName);
			Assert.fail("User is not able to get value " + elementName);
		}
	}

	/**
	 * Description Method to click on element using JavaSCript
	 * 
	 * @author Sajal, Vikas
	 * @param element
	 * @param elementName
	 */
	public synchronized void clickOnElementUsingJS(AndroidElement element, String elementName) {
		if (isElementClickable(element, elementName)) {
			jsExecutor.executeScript("arguments[0].click();", element);
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} else {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description Method to check whether array elements is sorted or not
	 * 
	 * @author Vikas
	 * @param charArray
	 */
	public synchronized static boolean isSorted(char[] charArray) {
		for (int i = 0; i < charArray.length - 1; i++) {
			if (charArray[i] > charArray[i + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Description Method to tap on element using x and y coordinates
	 * 
	 * @author Ashish , gaurav
	 * @param element
	 * @param elementName
	 * @Param x , y
	 */
	public static void tapByCoordinates(AndroidDriver androidDriver, int x, int y, String elementName) {
		try {
			TouchAction touchAction = new TouchAction(androidDriver);
			touchAction.tap(PointOption.point(x, y)).perform();
			info("Clicked on :" + elementName);
			extentinfo("Clicked on :" + elementName);

		} catch (Exception e) {
			error("Unable to click on: " + elementName);
			fail("Unable to click on: " + elementName);
			Assert.fail("Unable to click on: " + elementName);
		}
	}

	/**
	 * Description Method to type
	 * 
	 * @author Vikas
	 * @param element
	 * @param value
	 * @param elementName
	 */
	public static synchronized void type(String value, String elementName) {
		try {
			// waitForElement(element, elementName);
			// element.click();
			// implicitWait(10);
			// element.clear();
			waitForElementToLoad(5000);
			androidDriver.getKeyboard().sendKeys(value, Keys.ENTER);
			// implicitWait(10);
			androidDriver.hideKeyboard();
			info("Clicked and type the value in " + elementName);
			extentinfo("Clicked and type the value in " + elementName);
		} catch (AssertionError error) {
			fail("Unable to click and type the value in " + elementName);
			error("Unable to click and type the value in " + elementName);
			Assert.fail("Unable to click and type the value in " + elementName);
		} catch (Exception e) {
			fail("Unable to click and type the value in " + elementName);
			error("Unable to click and type the value in " + elementName);
			Assert.fail("Unable to click and type the value in " + elementName);
		}
	}

	/**
	 * Description : Method to Run App In Background
	 * 
	 * @author Manasa
	 */
	public static synchronized void runAppInBackground() {
		try {
			// MobileActionUtil.implicitWait(20);
			androidDriver.runAppInBackground(Duration.ofSeconds(5));
			System.out.println("App running in background for 5 seconds ");
			MobileActionUtil.info("Able to Run Application in Background");
			MobileActionUtil.pass("Able to Run Application in Background");
			// MobileActionUtil.implicitWait(1);
			androidDriver.currentActivity();
			// MobileActionUtil.implicitWait(2);
		} catch (Exception e) {
			MobileActionUtil.error("Unable to Run Application in Background");
			MobileActionUtil.fail("Unable to Run Application in Background");
			Assert.fail("Unable to Run Application in Background");
		}
	}

	/**
	 * Description : Method to click on Aeroplane mode
	 * 
	 * @author Sajal
	 * @param xpath
	 */
	public static synchronized void clkflightMode(String xpath) {
		try {
			Runtime.getRuntime().exec("adb shell am start -a android.settings.AIRPLANE_MODE_SETTINGS");
			TapOptions to = new TapOptions();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
			to.withElement(ElementOption.element(androidDriver.findElement(By.xpath(xpath))));
			touchAction.tap(to).perform();
			androidDriver.activateApp(BaseTest.properties.getProperty("appPackage"));
			info("Clicked on Aeroplane mode");
			extentinfo("Clicked on Aeroplane mode");
		} catch (IOException e) {
			error("Unable to click on Aeroplane mode");
			fail("Unable to click on Aeroplane mode");
			Assert.fail("Unable to click on Aeroplane mode");
		}
	}

	/**
	 * Description : Method for device back button
	 * 
	 * @author Manasa
	 * @param num
	 */
	public static synchronized void clickDeviceBackButton(int num) {
		try {
			for (int i = 0; i < num; i++) {
				androidDriver.pressKey(new KeyEvent(AndroidKey.BACK));
			}
			info("Able to click on device back button");
			extentinfo("Able to click on device back button");
		} catch (Exception e) {
			e.printStackTrace();
			error("Unable to click on device back button");
			fail("Unable to click on device back button");
			Assert.fail("Unable to click on device back button");
		}
	}

	/**
	 * Description Method for fetching Current Date
	 * 
	 * @author Sajal
	 */
	public static synchronized String getCurrentDate() {
		DateFormat customFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * Description Method to perform tap on element
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public static synchronized void tapOnElement(AndroidElement element, String elementName) {
		if (isElementClickable(element, elementName)) {
			Point p1 = null;
			p1 = element.getLocation();
			touchAction.tap(PointOption.point(p1.getX(), p1.getY())).perform();
			info("Tap on : " + elementName);
			extentinfo("Tap on : " + elementName);
		} else {
			error("Unable to tap on " + elementName);
			fail("Unable to tap on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description Method clicks on element using coordinates
	 * 
	 * @author Sajal
	 * @param element
	 * @param elementName
	 */
	public static synchronized void clickOnElementUsingCoordinates(AndroidElement element, String elementName, int x,
			int y) {
		if (isElementClickable(element, elementName)) {
			Point p1 = null;
			p1 = element.getLocation();
			System.out.println("x " + p1.getX());
			System.out.println("y " + p1.getY());
			touchAction.tap(PointOption.point((p1.getX() + x), (p1.getY() + y))).perform();
			System.out.println("pass");
			info("Clicked on : " + elementName);
			extentinfo("Clicked on : " + elementName);
		} else {
			error("Unable to click on " + elementName);
			fail("Unable to click on " + elementName);
			Assert.assertTrue(wait.until(ExpectedConditions.elementToBeClickable(element)) == null);
		}
	}

	/**
	 * Description Method to Drag and Drop.
	 * 
	 * @author Ashish Piplodiya
	 */
	public static synchronized void dragAndDrop(AndroidDriver<AndroidElement> androidDriver,
			AndroidElement elementToDrag, AndroidElement elementToDrop) {
		try {
			  TouchAction action = new TouchAction(androidDriver);
			  action.longPress(new ElementOption().withElement(elementToDrag))
			  .waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000))).
			  moveTo(new ElementOption().withElement(elementToDrop)).release().perform();

			info("Drag and Drop Completed");
		} catch (Exception e) {

			error("Unable to Drag and Drop element");
			fail("Unable to Drag and Drop element");
			Assert.fail("Unable to Drag and Drop element");
		}
	}
	
	
	public static synchronized void dragAndDrop( AndroidElement dragElement , AndroidElement dropElement)
	{

		TouchAction action = new TouchAction(androidDriver);
		  action.longPress(new ElementOption().withElement(dragElement)).perform();
		  
		  action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(3000)));
		  
		 action.moveTo(new ElementOption().withElement(dropElement)).release().perform();
 
		

	}
	
	/**
	 * Description Method to swipe Left to element
	 * 
	 * @author Gaurav S
	 */
	public synchronized static void swipeLeft() {
		try {
			info("Swiping the element using Co-ordinates");
			Dimension sizeOfWindow = androidDriver.manage().window().getSize();
			int width = sizeOfWindow.getWidth();
			int height = sizeOfWindow.getHeight();

			// width=(int)(width*0.6);

			new TouchAction((AppiumDriver) androidDriver).longPress(PointOption.point((int) (width * 0.75), height / 2))
					.moveTo(PointOption.point((int) (width * 0.1), height / 2)).release().perform();
		} catch (AssertionError error) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		} catch (Exception e) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		}
	}

	/**
	 * Description Method to swipe Right to element
	 * 
	 * @author Gaurav S
	 */
	public synchronized static void swipeRight() {
		try {
			info("Swiping the element using Co-ordinates");
			Dimension sizeOfWindow = androidDriver.manage().window().getSize();
			int width = sizeOfWindow.getWidth();
			int height = sizeOfWindow.getHeight();

			new TouchAction((AppiumDriver) androidDriver).longPress(PointOption.point((int) (width * 0.1), height / 2))
					.moveTo(PointOption.point((int) (width * 0.75), height / 2)).release().perform();
		} catch (AssertionError error) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		} catch (Exception e) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		}
	}

	/**
	 * Description Method to swipe Right to element
	 * 
	 * @author Gaurav S
	 * @param xpath
	 */
	public synchronized static void swipeRightToTheElement(String xpath) {
		try {

			WebDriverWait wait = new WebDriverWait(androidDriver, 1);
			Dimension sizeOfWindow = androidDriver.manage().window().getSize();
			int width = sizeOfWindow.getWidth();
			int height = sizeOfWindow.getHeight();
			for (;;) {
				try {

					wait.until(ExpectedConditions.visibilityOf(androidDriver.findElement(By.xpath(xpath))));
					break;
				} catch (Exception e) {
					// TODO: handle exception

					new TouchAction((AppiumDriver) androidDriver)
							.longPress(PointOption.point((int) (width * 0.1), height / 2))
							.moveTo(PointOption.point((int) (width * 0.8), height / 2)).release().perform();
				}
			}
			wait = new WebDriverWait(androidDriver, 30);

		} catch (Exception e) {
			error("Unable to perform swiping using Coodinate");
			fail("Unable to perform swiping using Coodinate");
			Assert.fail("Unable to perform swiping using Coodinate");
		}
	}

}
