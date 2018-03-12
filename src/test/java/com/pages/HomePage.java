package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class HomePage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;

	@Steps
	CommonPage commonPage;
	
	@Steps
	//Home page
	final String txtSearchForAnything = "//*[@text='Search for anything']"; //XPath
	final String lnkThreeBarMenu = "//android.widget.ImageButton[@content-desc='Main navigation, open']"; //XPath
	final String lnkSearchResults= "//*[@resource-id='com.ebay.mobile:id/text']"; //XPath 
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
	 * <b>Description</b> Search for Product Category
	 * @author Krishnamoorthy
	 * @param category user searches for particular category for shopping
	 **/
	@Step("Search for Product Category")
	public void searchProductCategory(String category) throws InterruptedException
	{
		//Set device to landscape mode
		if (commonPage.getOrientation().equalsIgnoreCase("portrait")) {
			commonPage.SetLandscapeOrientation();
		}
		//user enters a required category
		mobileElementByXpath(txtSearchForAnything).waitUntilVisible();
		mobileElementByXpath(txtSearchForAnything).sendKeys(category);
		//user selects the searched category from displayed list
		mobileElementByXpath(lnkSearchResults).waitUntilVisible();
		mobileElementByXpath(lnkSearchResults).click();

	}	
}
    