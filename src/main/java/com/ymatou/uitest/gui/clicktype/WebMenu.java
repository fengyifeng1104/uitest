package com.ymatou.uitest.gui.clicktype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebMenu extends AbstractWebElement implements ClickType{

	private List<String> menuList = new ArrayList<String>();
	private List<WebMenuNode>  webMenuNodeList = new ArrayList<WebMenuNode>();
	


	public WebMenu(List<String> menuList) {
		this.menuList = menuList;
	}
	
	
	public WebMenu(String strMenuPath) {
		this.menuList = Arrays.asList(strMenuPath.split("->"));
	}


	
	
	public void click(){
		webMenuNodeList.clear();
		for  (String node: menuList){
			WebMenuNode webMenuNode = new WebMenuNode(node);
			webMenuNode.findElement().click();
			webMenuNodeList.add(webMenuNode);
		}
		this.webElement = webMenuNodeList.get(webMenuNodeList.size()-1);
		
	}
	
	
	
	
	
	
	public class WebMenuNode extends AbstractWebElement  implements ClickType {
		
		 public WebMenuNode(String strMark) {
			this.strMark = strMark;
		}
		
		
		
	
		
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		new WebMenu("ֱ��").click();
		
		
	}
	

}
