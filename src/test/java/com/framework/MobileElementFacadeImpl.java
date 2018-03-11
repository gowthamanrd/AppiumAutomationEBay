package com.framework;

import net.serenitybdd.core.pages.WebElementFacade;


import org.openqa.selenium.By;

public class MobileElementFacadeImpl implements MobileElementFacade {

	protected WebElementFacade baseElement=null;
	protected final MobilePageObject page;
	protected final String property;
	protected final FindByType findByType;

	public MobileElementFacadeImpl(MobilePageObject page, String property, FindByType findByType) {
		this.page = page;
		this.property = property;
		this.findByType = findByType;
	}

	protected String getZone() {
		return page.getZone();
	}

	protected WebElementFacade getElement() {
		if (null == baseElement) {
			baseElement = page.find(getXpath());
		}

		return baseElement;
	}

	protected By getXpath() {
		switch (findByType) {
		case BY_ID:
			return By.xpath("//*[@accessibilityIdentifier='" + property +"' or @tag='" + property + "']");
		case BY_LABEL:
			return By.xpath("//*[@accessibilityLabel='" + property + "' or text()='" + property + "']");
		default:
			return By.xpath(property);
		}
	}

	@Override
	public void click() {
		getElement().click();
	}

	@Override
	public void sendKeys(CharSequence... keysToSend) {
		getElement().sendKeys(keysToSend);
	}

	@Override
	public boolean isEnabled() {
		//base implementation. Button etc would override this
		return getElement().isEnabled();

	}

	@Override
	public boolean isVisible() {
		return getElement().isVisible();
	}

	@Override
	public String getAttribute(String property){
		return getElement().getAttribute(property);
	}

	public String getText() {
		return getElement().getText();
	}

	@Override
	public Boolean isCurrentlyVisible() {
		return getElement().isCurrentlyVisible();
	}

	@Override
	public void waitUntilVisible() {
		getElement().waitUntilVisible();

	}

	public void waitForElementToVanish() {
		getElement().waitUntilNotVisible();
	}

}
