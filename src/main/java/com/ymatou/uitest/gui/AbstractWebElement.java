package com.ymatou.uitest.gui;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

public abstract class AbstractWebElement implements WebElement{
	protected String strMark;
	 
	protected WebElement webElement = null;
	
	protected SearchContext parentContainer = BrowserDriver.getWebDriver();
	
	
	public AbstractWebElement() {}
	
	
	public AbstractWebElement(String strMark) {
		 this.strMark = strMark;
		 this.webElement = this.findElement();
		 
	}
	 
	 
	public AbstractWebElement(SearchContext searchContext,String strMark) {
		 this.strMark = strMark;
		 this.webElement = this.findElement(searchContext);
		 
	}
	 
	 

	
	public SearchContext setParentContainer(SearchContext parentContainer){
		SearchContext old = this.parentContainer;
		this.parentContainer = parentContainer;
		return old;
	}

	
	
	public WebElement findElement(){
		return this.findElement(this.strMark);
	}
	
	public WebElement findElement(SearchContext searchContext){
		return this.findElement(searchContext,this.strMark);
	}
	
	
	
	
	public List<WebElement> findElements(){
		return this.findElements(this.strMark);
	}
	
	
	public WebElement findElement(String strMark) {
		return this.findElement(parentContainer, strMark);

	}
	
	public WebElement findElement(SearchContext searchContext,String strMark){
		List<WebElement> elements = this.findElements(searchContext, strMark);
		return elements==null? null:elements.get(0);
	}
	
	public List<WebElement> findElements(String strMark){
		return this.findElements(parentContainer, strMark);
	}

	
	public List<WebElement> findElements(SearchContext searchContext,String strMark){
		try{
			List<WebElement> elements = searchContext.findElements(By.id(strMark));
			if (elements.size() == 0){
				elements = searchContext.findElements(By.linkText(strMark));
				if (elements.size() == 0){
					elements = searchContext.findElements(By.name(strMark));
					if (elements.size() == 0){
						elements = searchContext.findElements(By.tagName(strMark));
						if (elements.size() == 0){
							elements = searchContext.findElements(By.partialLinkText(strMark));
							if (elements.size() == 0){
								elements = searchContext.findElements(By.className(strMark));
								if (elements.size() == 0){
									elements = searchContext.findElements(By.xpath(strMark));
									}if (elements.size() == 0){
									elements = searchContext.findElements(By.cssSelector(strMark));
								}
							}
						}
					}
				}
			}
			
			return elements;
		 }catch(Exception e){
			 System.out.println("falied to find "+this.getClass().getSimpleName()+" by ["+strMark+"]");
		 }
		return null;
	}
	
	
	

	public void click() {
		this.webElement.click();
		
	}


	public void submit() {
		// TODO Auto-generated method stub
		
	}


	public void sendKeys(CharSequence... keysToSend) {
		// TODO Auto-generated method stub
		
	}


	public void clear() {
		// TODO Auto-generated method stub
		
	}


	public String getTagName() {
		// TODO Auto-generated method stub
		return webElement.getTagName();
	}


	public String getAttribute(String name) {
		// TODO Auto-generated method stub
		return webElement.getAttribute(name);
	}


	public boolean isSelected() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}


	public String getText() {
		// TODO Auto-generated method stub
		return webElement.getText();
	}


	public List<WebElement> findElements(By by) {
		return this.webElement.findElements(by);
	}

	public WebElement findElement(By by) {
		return this.webElement.findElement(by);
	}
	



	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}


	public Point getLocation() {
		// TODO Auto-generated method stub
		return null;
	}



	public Dimension getSize() {
		// TODO Auto-generated method stub
		return null;
	}


	public String getCssValue(String propertyName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public boolean isExist(){
		return webElement==null?false:true;
	}
	
	

}
