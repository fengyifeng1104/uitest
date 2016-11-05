package com.ymatou.uitest.gui.containertype;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import com.ymatou.uitest.gui.AbstractWebElement;

public class WebTable extends AbstractWebElement{

	private WebElement tblHead;
	private WebElement tblBody;
	
	private List<String> columnNames = null;
	private int rows = -1;
	private boolean isTblInit = false;
	
	public WebTable(String strMark) {
		this(Arrays.asList(strMark.split(",")));
	}
	
	public WebTable(List<String> columnNames){
		findTable(columnNames);
		if (!isTblInit){init();}
	}
	
	
	@Override
	public boolean isEnabled() {
		return false;
	}
	
	private void init(){
		//column name 
		List<WebElement> tblHeadThs = tblHead.findElements(By.tagName("th"));
		List <String> tgtColNames = new ArrayList<String>();
		for (WebElement tblHeadth : tblHeadThs){tgtColNames.add(tblHeadth.getText());}
		this.columnNames = tgtColNames;
		
		this.rows = this.webElement.findElements(By.tagName("tr")).size();
		this.isTblInit = true;
	}
	
	protected void findTable(List<String> columnNames){
		List<WebElement> tblEles = parentContainer.findElements(By.tagName("table"));
		
		for (WebElement tblEle: tblEles){
			List<WebElement> tblHeadths = tblEle.findElement(By.tagName("thead")).findElements(By.tagName("th"));
		
			List <String> tgtColNames = new ArrayList<String>();
			for (WebElement tblHeadth : tblHeadths){tgtColNames.add(tblHeadth.getText());}
			
			if (tgtColNames.containsAll(columnNames)){
				this.webElement = tblEle;
				this.tblHead = tblEle.findElement(By.tagName("thead"));
				this.tblBody = tblEle.findElement(By.tagName("tbody"));
				break;
			}
		}
	}
	
	public List<String> getColumnNames() {
		return columnNames;
	}

	public int getRows() { 
		return rows;
	}

	public int getColumnIdx(String columnName){
		return isTblInit?columnNames.indexOf(columnName):-1;	
	}
	
	public String getCellText(int rowIdx, String colName){
		return this.getCellText(rowIdx, this.getColumnIdx(colName));
	}
	
	public String getCellText(int rowIdx, int colIdx){
		//check
		//rowId and colIdx
		String textStr = "";
		//head
		if (rowIdx == 1){
			textStr = this.columnNames.get(colIdx);
		}
		
		//body
		else{
			WebElement tblTr = this.tblBody.findElements(By.tagName("tr")).get(rowIdx-2);
			WebElement tblTd = tblTr.findElements(By.tagName("td")).get(colIdx);
			textStr =  tblTd.getText();
		}
		return textStr;
	}
	
	
	public <T extends AbstractWebElement> T getCellItem(int rowIdx,String colName,Class<T> clz, String strMark){
		return this.getCellItem(rowIdx, this.getColumnIdx(colName), clz, strMark);
	}
	
	public <T extends AbstractWebElement> T getCellItem(int rowIdx, int colIdx, Class<T> clz, String strMark){
		//check
		//rowId and colIdx

		//head
		
		
		//body
		if (rowIdx > 1){
			WebElement tblTr = this.tblBody.findElements(By.tagName("tr")).get(rowIdx-2);
			WebElement tblTd = tblTr.findElements(By.tagName("td")).get(colIdx-1);
			try {
				return clz.getDeclaredConstructor(SearchContext.class,String.class).newInstance(tblTd,strMark);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	
	
	
	public int getRowByKeyVal(List<String> keyValList){
		if (columnNames.containsAll(keyValList)){
			return 1;
		}else{
			List<WebElement> tblBodyLines = tblBody.findElements(By.tagName("tr"));
			
			
			for (WebElement tblBodyLine : tblBodyLines){
				
				List<WebElement> tblCells = tblBodyLine.findElements(By.tagName("td"));
				List <String> lineVals = new ArrayList<String>();
			
				for(WebElement tblCell : tblCells){lineVals.add(tblCell.getText());}
				
				if (lineVals.containsAll(keyValList)){
					return (tblBodyLines.indexOf(tblBodyLine)+2);
				}
			}
		}
		return -1;
	}
	
	
	
	
	
	public static void main(String[] args) {
		

	}
	

}
