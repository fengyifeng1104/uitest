package com.ymatou.uitest.gui.clicktype;

import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebButton extends AbstractWebElement implements ClickType{
	public WebButton(String strMark) {
		super(strMark);
	}
	
	public WebButton(SearchContext searchContext,String strMark) {
		super(searchContext,strMark);
	}
	
	public void click() {
		webElement.click();
		
	}

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	

	

}
