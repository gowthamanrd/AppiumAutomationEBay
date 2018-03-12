package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class PaymentPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;

	@Steps
	//Payment page
	final String lblPaymentMethodPg = "//*[@text='Choose your payment method']"; //XPATH
	
	/**
	 * <br>
	 * <b>Description</b> Verify 'Choose your payment method' page is displayed
	 * @author Krishnamoorthy
	 **/
	@Step("Verify 'Choose your payment method'page is displayed")
	public void verifyChooseYourPaymentPgDisplayed() throws InterruptedException
	{
		mobileElementByXpath(lblPaymentMethodPg).waitUntilVisible();
		Assert.assertTrue("Verify 'Choose your payment method' page is displayed as expected", mobileElementByXpath(lblPaymentMethodPg).isVisible());
	}
}
    