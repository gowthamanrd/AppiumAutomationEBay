package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.framework.MobilePageObject;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class LoginPage extends MobilePageObject{
	
	public static EnvironmentVariables variables= SystemEnvironmentVariables.createEnvironmentVariables();
	public static WebDriver driver=null;
	
	@Steps
	HomePage homePage;

	@Steps
	//Sign in page
	final String lblSignin = "//android.widget.TextView[@content-desc='Sign in,double tap to activate']"; //XPath
	final String lblSigninStatus = "//*[@resource-id='com.ebay.mobile:id/textview_sign_in_status']"; //XPath
	final String lnkHome = "//*[@content-desc='Home,selected,double tap to activate']"; //XPATH
	final String txtUsername = "//*[@text='Email or username']"; //XPath
	final String txtPassword = "//*[@resource-id='com.ebay.mobile:id/edit_text_password']"; //XPath
	final String btnSignin = "//*[@resource-id='com.ebay.mobile:id/button_sign_in']"; //XPath	
	
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
		homePage.clickThreeBarMenu();
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
}
    