package com.trello.android.baseutil;



import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.AndroidServerFlag;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


public class CreateDriver {

	private static CreateDriver instance = null;

	
	private CreateDriver() {
	}

	public static String userHomePath = System.getProperty("user.home");
	public static final String NODEJSPATH = "C:\\Program Files\\nodejs\\node.exe";
	public static final String NPMPATH = System.getProperty("user.home")
			+ "\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	public static final String ADBPATH = userHomePath + "\\AppData\\Local\\Android\\Sdk\\platform-tools"
			+ File.separator + "adb";
	public static final String EMULATORPATH = userHomePath + "\\AppData\\Local\\Android\\Sdk\\emulator" + File.separator
			+ "emulator";

	/**
	 * getInstance method to retrieve active driver instance
	 *
	 * @return CreateDriver
	 */
	public static CreateDriver getInstance() {
		if (instance == null) {
			instance = new CreateDriver();
		}
		return instance;
	}

	/**
	 * Description: Start the Appium Server
	 * 
	 * @author Sajal, Vikas
	 */
	public static URL startServer() {
		URL appiumServerURL=null;
try {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("noReset", "false");
		// Build the Appium service
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder.usingDriverExecutable(new File(NODEJSPATH));
		builder.withAppiumJS(new File(NPMPATH));
		builder.withArgument(AndroidServerFlag.BOOTSTRAP_PORT_NUMBER, BaseTest.properties.getProperty("bootstrapPort"));
		builder.withIPAddress(BaseTest.properties.getProperty("hostAddress"));
		builder.usingPort(Integer.parseInt(BaseTest.properties.getProperty("port")));

		// builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
		service.start();
		appiumServerURL = service.getUrl();
		//appiumServerURL = new URL("http://127.0.0.1:4723/wd/hub");
}
      catch (Exception e) {

	BaseTest.logger.error("Unable to set the capabilities");
     }
		return appiumServerURL;
	}

	/**
	 * Description: Start the Emulator
	 * 
	 * @author Sajal, Vikas
	 */
	public static void launchingEmulator() {
		BaseTest.actionUtil.info("Launching the Emulator");
		String avd = BaseTest.properties.getProperty("avd");
		String[] aCommand = new String[] { EMULATORPATH , "-avd", avd };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(30, TimeUnit.SECONDS);
			BaseTest.actionUtil.info("Emulator launched successfully!");
		} catch (Exception e) {
			BaseTest.actionUtil.info("Unable to launch the emulator");
		}
	}

	/**
	 * Description: Close the Emulator
	 * 
	 * @author Sajal, Vikas
	 */
	public static void closeEmulator() {
		BaseTest.actionUtil.info("Killing emulator...");
		String[] aCommand = new String[] { ADBPATH, "emu", "kill" };
		try {
			Process process = new ProcessBuilder(aCommand).start();
			process.waitFor(30, TimeUnit.SECONDS);
			BaseTest.actionUtil.info("Emulator closed successfully!");
		} catch (Exception e) {
			BaseTest.actionUtil.info("Unable to close the emulator");
		}
	}

	/**
	 * Description: Stop the Appium server
	 * 
	 * @author Sajal, Vikas
	 */
	public static void stopAppiumServer() {
		try {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		BaseTest.actionUtil.info("Appium server stopped");
		} catch (Exception e) {
			BaseTest.actionUtil.info("Unable to stop the appium server");
		}
	}

	/**
	 * Description: Set Capabilities for mobile
	 * 
	 * @author Sajal, Vikas
	 */
	public static DesiredCapabilities setUpMobileCapabilities() {
		File app = new File(BaseTest.properties.getProperty("appApkPath"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		//DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, BaseTest.properties.getProperty("platformName"));
		capabilities.setCapability(MobileCapabilityType.FULL_RESET, false);
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,BaseTest.properties.getProperty("appPackage"));
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,BaseTest.properties.getProperty("appActivity"));
	     
		return capabilities;
	}

	

	
}
