package com.ymatou.uitest.gui;

import com.ymatou.uitest.gui.clicktype.ClickType;
import com.ymatou.uitest.gui.inputtype.InputType;

public class WebElement extends AbstractWebElement implements InputType,ClickType{
	public WebElement(String strMark) {
		super(strMark);
	}

	public void set(String val) {
		webElement.sendKeys(val);
		
	}
}
