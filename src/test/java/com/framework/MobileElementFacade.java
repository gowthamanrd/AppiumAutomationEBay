package com.framework;

public interface MobileElementFacade {
    public void click();
    public void sendKeys(CharSequence... keysToSend);
    public boolean isEnabled();
    public boolean isVisible();
	public String getAttribute(String string);
	public String getText();
	public Boolean isCurrentlyVisible();
	public void waitUntilVisible();
}
