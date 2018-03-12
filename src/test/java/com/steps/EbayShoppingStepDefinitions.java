package com.steps;

import com.pages.CommonPage;
import com.pages.DeliveryDetailsPage;
import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.PaymentPage;
import com.pages.ProductDetailsPage;
import com.pages.ProductListPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class EbayShoppingStepDefinitions {
	
	@Steps
	CommonPage commonPage;
	DeliveryDetailsPage deliveryDetailsPage;
	HomePage homePage;
	LoginPage loginPage;
	PaymentPage paymentPage;
	ProductDetailsPage productDetailsPage;
	ProductListPage productListPage;
	
	@Given("^ebay home page should be displayed$")
	public void ebay_home_page_should_be_displayed() throws Exception {
	    homePage.verifyHomePageDisplayed();
	}

	@When("^user navigates to sign in page$")
	public void user_navigates_to_sign_in_page() throws Exception {
		homePage.clickThreeBarMenu();
	}

	@Then("^sign in page should be displayed$")
	public void sign_in_page_should_be_displayed() throws Exception {
	   loginPage.verifySigninPageDisplayed();
	}

	
	@When("^user logs in to appliction using \"([^\"]*)\" and \"([^\"]*)\" with \"([^\"]*)\"$")
	public void user_logs_in_to_appliction_using_and(String userName, String password,String userID) throws Exception {
	   loginPage.loginApp(userName, password,userID);
	}

	@Then("^taps on sign in button$")
	public void taps_on_sign_in_button() throws Exception {
	   loginPage.clickSigninBtn();
	}

	@When("^user searches for desired category \"([^\"]*)\"$")
	public void user_searches_for_desired_category(String productCategoty) throws Exception {
		homePage.searchProductCategory(productCategoty);
	}

	@Then("^list of available items should be displayed$")
	public void list_of_available_items_should_be_displayed() throws Exception {
		productListPage.verifyProductListPgDisplayed();
	}

	@When("^user selects the desired item \"([^\"]*)\"$")
	public void user_selects_the_desired_item(String productName) throws Exception {
	    productListPage.selectProduct(productName);
	}

	@Then("^buy it now page should be displayed$")
	public void buy_it_now_page_should_be_displayed() throws Exception {
	    productDetailsPage.verifyBuyItNowPgDisplayed();
	}

	@When("^user taps on 'BUY IT NOW'$")
	public void user_taps_on_BUY_IT_NOW() throws Exception {
	    productDetailsPage.clickBuyITNowBtn();
	}

	@Then("^delivery address page should be displayed$")
	public void delivery_address_page_should_be_displayed() throws Exception {
	    deliveryDetailsPage.verifyDeliveryAddrPgDisplayed();
	}

	@When("^user taps on 'Proceed to Pay' button$")
	public void user_taps_on_Proceed_to_Pay_button() throws Exception {
	    deliveryDetailsPage.verifyProceedToPayBtn();
	    deliveryDetailsPage.clickProceedToPayBtn();
	}

	@Then("^'Choose your payment method' should be displayed$")
	public void choose_your_payment_method_should_be_displayed() throws Exception {
	    paymentPage.verifyChooseYourPaymentPgDisplayed();
	}

}
 