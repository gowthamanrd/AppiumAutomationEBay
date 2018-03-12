package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class DeliveryDetailsPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;
	
	@Steps
	CommonPage commonPage ;

	@Steps
	//Delivery address page 
	final String lblDeliveryAddrPg = "//*[@text='Delivery address']"; //XPATH
	final String btnProceedToPay = "//*[@text='Proceed to Pay']"; //XPATH
	
	/**
	 * <br>
	 * <b>Description</b> Verify Delivery Address page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify Delivery Address page is displayed")
	public void verifyDeliveryAddrPgDisplayed() throws InterruptedException
	{
		mobileElementByXpath(lblDeliveryAddrPg).waitUntilVisible();
		Assert.assertTrue("Verify Delivery Address page is displayed as expected", mobileElementByXpath(lblDeliveryAddrPg).isVisible());
	}

	/**
	 * <br>
	 * <b>Description</b> Verify Proceed To Pay button is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify Proceed To Pay button is displayed")
	public void verifyProceedToPayBtn() throws InterruptedException
	{
		//Swipe until button is visible
		commonPage.swipeTillElementVisible(btnProceedToPay);
		Assert.assertTrue("Verify Proceed To Pay button is displayed as expected", mobileElementByXpath(btnProceedToPay).isVisible());
	}

	/**
	 * <br>
	 * <b>Description</b> Click Proceed To Pay button
	 * @author Krishnamoorthy
	 **/
	@Step("Click Proceed To Pay button")
	public void clickProceedToPayBtn()
	{
		mobileElementByXpath(btnProceedToPay).click();
	}
	
}
    