package com.dfs.common.pages;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import groovy.util.logging.Log;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.WebDriverFacade;

public class EbayPage extends com.dfs.framework.MobilePageObject{
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;

	@Steps
	//Home page
	final String txtSearchForAnything = "//*[@text='Search for anything']"; //XPath
	final String lnkThreeBarMenu = "//android.widget.ImageButton[@content-desc='Main navigation, open']"; //XPath
	final String lnkSearchResults= "//*[@resource-id='com.ebay.mobile:id/text']"; //XPath
	//Sign in page
	final String lblSignin = "//android.widget.TextView[@content-desc='Sign in,double tap to activate']"; //XPath
	final String lblSigninStatus = "//*[@resource-id='com.ebay.mobile:id/textview_sign_in_status']"; //XPath
	final String lnkHome = "//*[@content-desc='Home,selected,double tap to activate']"; //XPATH
	final String txtUsername = "//*[@text='Email or username']"; //XPath
	final String txtPassword = "//*[@resource-id='com.ebay.mobile:id/edit_text_password']"; //XPath
	final String btnSignin = "//*[@resource-id='com.ebay.mobile:id/button_sign_in']"; //XPath
	//product list page
	final String lnkSort = "//*[@resource-id='com.ebay.mobile:id/button_sort']"; //XPATH
	//Buy it now page 
	final String btnBuyItNow = "//android.widget.Button[@content-desc='Buy it now']"; //XPATH
	//Delivery address page 
	final String lblDeliveryAddrPg = "//*[@text='Delivery address']"; //XPATH
	final String btnProceedToPay = "//*[@text='Proceed to Pay']"; //XPATH
	//Payment page
	final String lblPaymentMethodPg = "//*[@text='Choose your payment method']"; //XPATH
	//interim page 
	final String lblNextTimeSaveYourself = "//*[@text='Next time, save yourself a step']";//XPath
	final String lnkNoThanks = "//*[@text='No thanks']"; //XPath
	
	/**
	 * <br>
	 * <b>Description</b> To validate eBay landing page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Validate eBay landing page is displayed")
	public void verifyHomePageDisplayed()
	{
		// ByPass Next Time save your self page if displayed 
		if(mobileElementByXpath(lblNextTimeSaveYourself).isVisible())
		{
			mobileElementByXpath(lnkNoThanks).click();
		}
		Assert.assertTrue("Verify ebay applicaion home page is displayed", mobileElementByXpath(txtSearchForAnything).isVisible());
	}

	/**
	 * <br>
	 * <b>Description</b> Click on Three Bar Menu
	 * @author Krishnamoorthy
	 **/
	@Step("Click on Three Bar Menu")
	public void clickThreeBarMenu()
	{
		mobileElementByXpath(lnkThreeBarMenu).click();
	}

	/**
	 * <br>
	 * <b>Description</b> Verify Sign in page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify Sign in page is displayed")
	public boolean verifySigninPageDisplayed()
	{
		Boolean isSigninPagedisplayed= mobileElementByXpath(lblSignin).isVisible();
		return isSigninPagedisplayed;
	}

	/**
	 * <br>
	 * <b>Description</b> Login in to the ebay application
	 * @author Krishnamoorthy
	 * @param userNameorEmail user enters respective user name or email to login in to their account
	 * @param password        user enters respective password to login in to their account
	 * @param userID          user verifies the unique user name displayed for their account          
	 **/
	@Step("Login in to the ebay application")
	public void loginApp(String userNameorEmail,String password,String userID)
	{
		//Click three bar menu
		clickThreeBarMenu();
		//If sign in page displayed : Enter credentials
		if(verifySigninPageDisplayed())
		{
			enterUserName(userNameorEmail);
			enterPassword(password);
			clickSigninBtn();
		}
		else
		{
			//If user already logged in : Verify unique user name 
			final String lblUserID = "//*[@text='" + userID + "']";
			Assert.assertTrue("Verify Signin status page is displayed as expected", mobileElementByXpath(lblSigninStatus).isVisible());
			Assert.assertTrue("Verify respective user name is displayed in Signin status page as expected",mobileElementByXpath(lblUserID).isVisible());	
			//Navigate back to home page
			mobileElementByXpath(lnkHome).click();
		}
	}	

	/**
	 * <br>
	 * <b>Description</b> Enter the login user name 
	 * @author Krishnamoorthy
	 * @param  userName user enters respective user name or email to login in to their account
	 **/
	@Step("Enter the login user name")
	public void enterUserName(String userName)
	{
		mobileElementByXpath(txtUsername).sendKeys(userName);
	}

	/**
	 * <br>
	 * <b>Description</b> Enter the login password
	 * @author Krishnamoorthy
	 * @param  password user enters respective password to login in to their account
	 **/
	@Step("Enter the login password")
	public void enterPassword(String password)
	{
		mobileElementByXpath(txtPassword).sendKeys(password);
	}

	/**
	 * <br>
	 * <b>Description</b> Click Sign in button
	 * @author Krishnamoorthy
	 **/
	@Step("Click Sign in button")
	public void clickSigninBtn()
	{
		mobileElementByXpath(btnSignin).click();
	}

	/**
	 * <br>
	 * <b>Description</b> Search for Product Category
	 * @author Krishnamoorthy
	 * @param category user searches for particular category for shopping
	 **/
	@Step("Search for Product Category")
	public void searchProductCategory(String category) throws InterruptedException
	{
		//user enters a required category
		mobileElementByXpath(txtSearchForAnything).waitUntilVisible();
		mobileElementByXpath(txtSearchForAnything).sendKeys(category);
		Thread.sleep(20000);
		//user selects the searched category from displayed list
		mobileElementByXpath(lnkSearchResults).waitUntilVisible();
		mobileElementByXpath(lnkSearchResults).click();

	}	

	/**
	 * <br>
	 * <b>Description</b> Verify product list page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify product list page is displayed")
	public void verifyProductListPgDisplayed()
	{
		mobileElementByXpath(lnkSort).waitUntilVisible();
		Assert.assertTrue("Verify list of products page is displayed as expected", mobileElementByXpath(lnkSort).isVisible());
	}

	/**
	 * <br>
	 * <b>Description</b> Select a desired product
	 * @author Krishnamoorthy
	 * @param  productName user selects the respective product in list displayed
	 **/
	@Step("Select a desired product")
	public void selectProduct(String productName)
	{
		// Dynamic XPath: To select a user specific product name
		final String txtSelectProduct = "//*[@text='" + productName +"']";
		//Scroll and select the desired product in a page
		swipeTillElementVisible(txtSelectProduct);
		mobileElementByXpath(txtSelectProduct).click();
	}

	/**
	 * <br>
	 * <b>Description</b> Verify Buy it Now page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify Buy it Now page is displayed")
	public void verifyBuyItNowPgDisplayed()
	{
		mobileElementByXpath(btnBuyItNow).waitUntilVisible();
		Assert.assertTrue("Verify Buy It Now page is displayed as expected", mobileElementByXpath(btnBuyItNow).isVisible());
	}

	/**
	 * <br>
	 * <b>Description</b> Click Buy it now button
	 * @author Krishnamoorthy
	 **/
	@Step("Click Buy it now button")
	public void clickBuyITNowBtn()
	{
		mobileElementByXpath(btnBuyItNow).click();
	}

	/**
	 * <br>
	 * <b>Description</b> Verify Delivery Address page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify Delivery Address page is displayed")
	public void verifyDeliveryAddrPgDisplayed() throws InterruptedException
	{
		Thread.sleep(20000);
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
		swipeTillElementVisible(btnProceedToPay);
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
	
	/**
	 * <br>
	 * <b>Description</b> Verify 'Choose your payment method' page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify 'Choose your payment method'page is displayed")
	public void verifyChooseYourPaymentPgDisplayed() throws InterruptedException
	{
		Thread.sleep(10000);
		mobileElementByXpath(lblPaymentMethodPg).waitUntilVisible();
		Assert.assertTrue("Verify 'Choose your payment method' page is displayed as expected", mobileElementByXpath(lblPaymentMethodPg).isVisible());
	}
	
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
	
}
