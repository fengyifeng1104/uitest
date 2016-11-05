package com.ymatou.uitest.gui.clicktype;

import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebLink extends AbstractWebElement implements ClickType{
	public WebLink(String strMark) {
		super(strMark);
	}
	
	public WebLink(SearchContext searchContext, String strMark){
		super(searchContext,strMark);
	}
	
	
	@Override
	public void click() {
		webElement.click();
		
	}

	
}
