package com.ymatou.uitest.gui.inputtype;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebRadioBox extends AbstractWebElement implements InputType{
	
	
	
	public WebRadioBox(String strMark) {
		super(strMark);
	}
	
	public WebRadioBox(SearchContext searchContext, String strMark){
		super(searchContext,strMark);
	}

	
	

	public void set(String val) {
		boolean isSet = false;
		
		if (!isSet){
			List<WebElement> webElements = findElements(By.tagName("label"));
			for (WebElement ele : webElements){
				if (ele.getText().equals(val)){
					WebElement radioNodeEle =  findElement(ele.getAttribute("for"));
					if (radioNodeEle!=null){
						radioNodeEle.click();
						isSet = true;
						return;
					}else{
						break;
					}
				}
			}
		}
		
		
		
		if (!isSet){
			List<WebElement> webElements = findElements(this.strMark);
			for(WebElement ele:webElements){
				if (ele.getAttribute("value")!=null && ele.getAttribute("value").equals(val)){
					ele.click();
					isSet = true;
					return;
				}
			}
		}
		
		
	}
}
