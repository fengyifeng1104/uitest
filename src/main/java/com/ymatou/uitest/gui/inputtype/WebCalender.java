package com.ymatou.uitest.gui.inputtype;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebCalender extends AbstractWebElement implements InputType{
	
	
	
	
	 public WebCalender(String strMark) {
		 super(strMark);
	}
	
	public WebCalender(SearchContext searchContext, String strMark){
		 super(searchContext,strMark);
	}
	
	
	public void set(String val) {
		RemoteWebDriver remoteWebDriver = (RemoteWebDriver)this.parentContainer;
		remoteWebDriver.executeScript("document.getElementById('"+this.strMark+"').value='"+val + "'");
		//remoteWebDriver.executeScript("document.querySelectorAll('#"+this.strMark+"').value='"+val + "'");
		
		
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new WebCalender("ValidStartDate").set("2016-10-31 15:24:22");
	}

}
