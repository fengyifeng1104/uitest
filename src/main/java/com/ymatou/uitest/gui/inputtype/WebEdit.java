package com.ymatou.uitest.gui.inputtype;


import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;


public class WebEdit extends AbstractWebElement implements InputType{

	
	 public WebEdit(String strMark) {
		 super(strMark);
	}
	
	public WebEdit(SearchContext searchContext, String strMark){
		 super(searchContext,strMark);
	}
	 

	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public void set(String val) {
		webElement.clear();
		webElement.sendKeys(val);
		
	}

}
