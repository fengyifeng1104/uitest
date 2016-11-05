package com.ymatou.uitest.gui.clicktype;

import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebTab extends AbstractWebElement implements ClickType{
	
	 public WebTab(String strMark) {
		 super(strMark);
	}
	
	public WebTab(SearchContext searchContext, String strMark){
		 super(searchContext,strMark);
	}
	
	
}
