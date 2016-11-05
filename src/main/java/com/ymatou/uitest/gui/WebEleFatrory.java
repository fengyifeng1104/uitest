package com.ymatou.uitest.gui;

import com.ymatou.uitest.gui.clicktype.WebButton;
import com.ymatou.uitest.gui.clicktype.WebLink;
import com.ymatou.uitest.gui.clicktype.WebMenu;
import com.ymatou.uitest.gui.clicktype.WebTab;
import com.ymatou.uitest.gui.containertype.WebTable;
import com.ymatou.uitest.gui.inputtype.WebCalender;
import com.ymatou.uitest.gui.inputtype.WebCheckBox;
import com.ymatou.uitest.gui.inputtype.WebEdit;
import com.ymatou.uitest.gui.inputtype.WebList;
import com.ymatou.uitest.gui.inputtype.WebRadioBox;

public class WebEleFatrory {
	public static WebEdit GetWebEdit(String strMark){
		return new WebEdit(strMark);
	}
	
	public static WebButton GetWebButton(String strMark){
		return new WebButton(strMark);
	}
	
	public static WebLink GetWebLink(String strMark){
		return new WebLink(strMark);
	}
	
	public static WebCheckBox GetWebCheckBox(String strMark){
		return new WebCheckBox(strMark);
	}
	
	public static WebRadioBox GetWebRadioBox(String strMark){
		return new WebRadioBox(strMark);
	}
	
	public static WebCalender GetWebCalender(String strMark){
		return new WebCalender(strMark);
	}
	
	public static WebTab GetWebTab(String strMark){
		return new WebTab(strMark);
	}
	
	public static WebMenu GetWebMenu(String strMark){
		return new WebMenu(strMark);
	}
	
	public static WebList GetWebList(String strMark){
		return new WebList(strMark);
	}
	
	public static WebElement GetWebElement(String strMark){
		return new WebElement(strMark);
	}
	
	public static WebTable GetWebTable(String strMark){
		return new WebTable(strMark);
	}
	
	
	public static WebEdit FindWebEdit(String strMark){
		return new WebEdit(strMark);
	}
	
	public static WebButton FindWebButton(String strMark){
		return new WebButton(strMark);
	}
	
	public static WebLink FindWebLink(String strMark){
		return new WebLink(strMark);
	}
	
	public static WebCheckBox FindWebCheckBox(String strMark){
		return new WebCheckBox(strMark);
	}
	
	public static WebRadioBox FindWebRadioBox(String strMark){
		return new WebRadioBox(strMark);
	}
	
	public static WebCalender FindWebCalender(String strMark){
		return new WebCalender(strMark);
	}
	
	public static WebTab FindWebTab(String strMark){
		return new WebTab(strMark);
	}
	
	public static WebMenu FindWebMenu(String strMark){
		return new WebMenu(strMark);
	}
	
	
	public static WebList FindWebList(String strMark){
		return new WebList(strMark);
	}
	
	public static WebElement FindWebElement(String strMark){
		return new WebElement(strMark);
	}
	public static WebTable FindWebTable(String strMark){
		return new WebTable(strMark);
	}
	
	
	
}
