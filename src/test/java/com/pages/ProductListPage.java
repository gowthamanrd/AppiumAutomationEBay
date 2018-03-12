package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ProductListPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;
	
	@Steps
	CommonPage commonPage;

	@Steps
	//product list page
	final String lnkSort = "//*[@resource-id='com.ebay.mobile:id/button_sort']"; //XPATH
	
	/**
	 * <br>
	 * <b>Description</b> Verify product list page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify product list page is displayed")
	public void verifyProductListPgDisplayed()
	{
		//Set device to Portrait mode
		if (commonPage.getOrientation().equalsIgnoreCase("landscape")) {
			commonPage.SetPortraitOrientation();
		}
		//Verify product list is displayed
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
		commonPage.swipeTillElementVisible(txtSelectProduct);
		mobileElementByXpath(txtSelectProduct).click();
	}
}
    