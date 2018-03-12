package com.pages;

import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;

public class CommonPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;
	
	/**
	 * <br>
	 * <b>Description</b> Swipe until specific web element is displayed
	 * @author Krishnamoorthy
	 * @param  mobileElementToFind element to find during the swipe 
	 **/
	@Step("Swipe until specific web element is displayed")
	public void swipeTillElementVisible(String mobileElementToFind)
	
	{
		WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
		Dimension size = ((AndroidDriver<?>) proxiedDriver).manage().window().getSize();
		int starty = (int) (size.height * 0.80);
		int endy = (int) (size.height * 0.20);
		int startx = size.width / 2;
		Boolean isElementVisible = false;
		isElementVisible = mobileElementByXpath(mobileElementToFind).isVisible();
		while (!isElementVisible) {
			((AndroidDriver<?>) proxiedDriver).swipe(startx,starty,startx, endy, 1000);
			isElementVisible = mobileElementByXpath(mobileElementToFind).isVisible();	
		}
	}
	
	/**
	 * <br>
	 * <b>Description</b> Get screen orientation
	 * @author Krishnamoorthy
	 **/
	@Step("Get screen orientation")
	public String getOrientation()
	{
		WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
		ScreenOrientation orientation= ((AndroidDriver<?>) proxiedDriver).getOrientation();
		String currentScreenOrientation= orientation.value();
		return currentScreenOrientation;
	}
	
	/**
	 * <br>
	 * <b>Description</b> Set device to portrait mode
	 * @author Krishnamoorthy
	 **/
	@Step("Set device to portrait mode")
	public void SetPortraitOrientation()
	{
		WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
		((AndroidDriver<?>) proxiedDriver).rotate(ScreenOrientation.PORTRAIT);
		Assert.assertTrue("Device orientation is set to Portrait",true);
	}
	
	/**
	 * <br>
	 * <b>Description</b> Set device to Landscape mode
	 * @author Krishnamoorthy
	 **/
	@Step("Set device to Landscape mode")
	public void SetLandscapeOrientation()
	{
		WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
		((AndroidDriver<?>) proxiedDriver).rotate(ScreenOrientation.LANDSCAPE);
		Assert.assertTrue("Device orientation is set to Landscape",true);
	}
}
    