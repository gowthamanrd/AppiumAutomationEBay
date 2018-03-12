package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class ProductDetailsPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;

	@Steps	
	//Buy it now page 
	final String btnBuyItNow = "//android.widget.Button[@content-desc='Buy it now']"; //XPATH
	
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
}
    