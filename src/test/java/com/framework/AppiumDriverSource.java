package com.framework;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

public class AppiumDriverSource implements DriverSource {
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();

	@Override
	public WebDriver newDriver() {

		// Created object of DesiredCapabilities class.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", variables.getProperty("deviceName",""));
		capabilities.setCapability("platformName", variables.getProperty("appium.platformName",""));
		capabilities.setCapability("appPackage", variables.getProperty("appPackage",""));
		capabilities.setCapability("appActivity", variables.getProperty("appActivity",""));
		capabilities.setCapability("noReset", variables.getProperty("noReset",""));
		if (getOS().equals("ios")) {
			capabilities.setCapability(IOSMobileCapabilityType.BUNDLE_ID, variables.getProperty("appActivity",""));
			return new IOSDriver<>(getServerURL(), capabilities);
		}
		if (getOS().equals("android")) {
			capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, variables.getProperty("appPackage",""));
			capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, variables.getProperty("androidActivity",""));
			return new AndroidDriver<>(getServerURL(), capabilities);
		}
		throw new RuntimeException("Could not create AppiumDriver, check properties file for OS settings");
	}

	@Override
	public boolean takesScreenshots() {
		return true;
	}

	private URL getServerURL() {
		String server = null;
		server = variables.getProperty("localserver","").concat("/wd/hub");
		URL url = null;
		try {
			url = new URL(server);
		} catch (MalformedURLException e) {
			e.printStackTrace();
			throw new RuntimeException("Server string to url issue: " + server);
		}
		return url;
	}

	public static String getOS() {
		return variables.getProperty("deviceos","").toLowerCase();
	}

}
