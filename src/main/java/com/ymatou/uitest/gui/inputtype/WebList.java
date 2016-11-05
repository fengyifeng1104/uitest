package com.ymatou.uitest.gui.inputtype;


import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;


public class WebList extends AbstractWebElement implements InputType{

	
	 public WebList(String strMark) {
		 super(strMark);
	}
	
	public WebList(SearchContext searchContext, String strMark){
		 super(searchContext,strMark);
	}
	 

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public void set(String val) {
		webElement.sendKeys(val);
		
	}

}
