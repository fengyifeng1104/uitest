package com.ymatou.uitest.gui.inputtype;

import org.openqa.selenium.SearchContext;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebCheckBox extends AbstractWebElement implements InputType{
	public WebCheckBox(String strMark) {
		super(strMark);
	}
	
	public WebCheckBox(SearchContext searchContext, String strMark){
		super(searchContext,strMark);
	}
	
	
	public void setOn(){
		if (!isChecked()){webElement.click();}
		
		
	}
	
	public void setOff(){
		if (isChecked()){webElement.click();}
	}
	
	public boolean isChecked(){
		return Boolean.parseBoolean(webElement.getAttribute("checked"))==true?true:false;
	}
	


	public void set(String val) {
		if (val.equalsIgnoreCase("on") || val.equalsIgnoreCase("true")){
			setOn();
		}else{
			setOff();
		}
		
	}

	
}

