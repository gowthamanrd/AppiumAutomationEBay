package com.framework;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.AppiumDriver;
import net.thucydides.core.pages.PageObject;
import net.thucydides.core.webdriver.WebDriverFacade;

/**
 * Created by krishnamoorthy on 3/08/18.
 */
public class MobilePageObject extends PageObject {
	String os=null;

	public MobileElementFacade $$(String id) {
		return new MobileElementFacadeImpl(this, id, FindByType.BY_ID);
	}

	public MobileElementFacade mobileElement(String id) {
		return new MobileElementFacadeImpl(this, id, FindByType.BY_ID);
	}

	public MobileElementFacade mobileElementByLabel(String label) {
		return new MobileElementFacadeImpl(this, label, FindByType.BY_LABEL);
	}

	public MobileElementFacade mobileElementByXpath(String xpath) {
		return new MobileElementFacadeImpl(this, xpath, FindByType.BY_XPATH);
	}

	public String getZone() {
		WebDriver proxiedDriver = ((WebDriverFacade) getDriver()).getProxiedDriver();
		String context = ((AppiumDriver<?>) proxiedDriver).getContext();
		if (context.contains("NATIVE")) {
			return  "NATIVE";
		} else {
			return "WEB";
		}
	}

	}
