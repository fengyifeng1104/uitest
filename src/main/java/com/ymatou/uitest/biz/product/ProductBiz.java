package com.ymatou.uitest.biz.product;

import java.util.Arrays;

import org.openqa.selenium.By;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.ymatou.uitest.gui.BrowserDriver;
import com.ymatou.uitest.gui.WebEleFatrory;
import com.ymatou.uitest.gui.containertype.WebTable;
import com.ymatou.uitest.gui.inputtype.WebCheckBox;
import com.ymatou.uitest.gui.inputtype.WebEdit;
import com.ymatou.uitest.util.LoggerUtil;
import com.ymatou.uitest.util.TimeUtil;

public class ProductBiz {
	
	public static void AddNewProduct(JSONObject step1,JSONObject step2){
		//navigate
		WebEleFatrory.GetWebMenu("商品->发布商品").click();
		
		//选择规格
		selectCatagroryAndBrand(step1);
	
		
		
		//编辑界面
		WebEleFatrory.GetWebEdit("ProductName").set(step2.getString("ProductName"));
		WebEleFatrory.GetWebEdit("J_mobilescription").set(step2.getString("MobileDescription"));
		WebEleFatrory.GetWebEdit("J_txtDescription").set(step2.getString("WordContent"));
		
		//限购
		if (step2.getBooleanValue("Limited")){
			WebEleFatrory.GetWebCheckBox("UseLimitCheck").setOn();
			WebEleFatrory.GetWebEdit("LimitNum").set(step2.getString("LimitNum"));
		}else{
			WebEleFatrory.GetWebCheckBox("UseLimitCheck").setOff();
		}
		
		
		//砍单风险
		WebEleFatrory.GetWebRadioBox("notrisk").set(step2.getString("NoticeRisk"));
		  
		
		//物流方式
		JSONArray deliveryAry = step2.getJSONArray("DeliveryType");
		int SecondType = 1;
		switch (deliveryAry.getString(1)){
			case "贝海直邮": SecondType = 1;
			case "拼邮": SecondType = 3;
			case "第三方直邮": SecondType = 4;
			case "第三方保税": SecondType = 5;
		}
		
		if (deliveryAry.getString(0).equals("海外")){
			WebEleFatrory.GetWebRadioBox("InventoryLocation").set("0");
			WebEleFatrory.GetWebRadioBox("LogisticsChannel").set(String.valueOf(SecondType));
			
		}else if(deliveryAry.getString(0).equals("保税")){
			WebEleFatrory.GetWebRadioBox("InventoryLocation").set("1");
			WebEleFatrory.GetWebRadioBox("LogisticsChannel").set(String.valueOf(SecondType));
			WebEleFatrory.GetWebList("BondedArea").set(deliveryAry.getString(2));
			WebEleFatrory.GetWebEdit("ProductCode").set(deliveryAry.getString(3));
		}
		
		
		
		//上架设置
		WebEleFatrory.GetWebCheckBox("AutoOnSell").set(step2.getString("AutoSale"));
		
		WebEleFatrory.GetWebRadioBox("OnSaleType").set(step2.getString("OnSaleType"));
		
		if (step2.getString("OnSaleType").equals("1")){
			WebEleFatrory.GetWebCalender("ValidStartDate").set(step2.getString("OnSaleTime"));
		}
		
		
		
		//7天无理由
		WebEleFatrory.GetWebCheckBox("NoReasonReturn").set(step2.getString("NoReasonReturn"));
		
		
		//退货方式
		WebEleFatrory.GetWebRadioBox("LocalReturn").set(step2.getString("LocalReturn"));
		
		
		
		//插图
		BrowserDriver.getWebDriver().findElements(By.xpath(".//*[@accept='.bmp,.jpg,.png,.jpeg']")).get(0).sendKeys(step2.getString("PicUrl"));
		
		//加入直播 todo
		
		//规格
		JSONObject CatalogsBean = step2.getJSONObject("Catalogs");
		if (CatalogsBean.keySet().contains("Property")){
			//多规格
			WebEleFatrory.GetWebCheckBox("setspecification").setOn();
			
			
			JSONObject PropertyBean = CatalogsBean.getJSONObject("Property");
			JSONArray PropertyValuesBean = CatalogsBean.getJSONArray("PropertyValue");
			
			for(String propertyKey:PropertyBean.keySet()){
				WebEleFatrory.GetWebEdit("AddSpecificationField").set(propertyKey);
				WebEleFatrory.GetWebButton("AddSpecification").click();
				
				//填写规格属性值
				JSONArray propertyValAry = PropertyBean.getJSONArray(propertyKey);
				for(int i=0;i<propertyValAry.size();i++){
					WebEleFatrory.GetWebElement("span[addcategory='"+ propertyKey+"']").click();
					WebEleFatrory.GetWebElement("input.c-input-text-md.w50.addcategoryfield").set(propertyValAry.getString(i));
					WebEleFatrory.GetWebButton("addcategorykind").click();
				}
			}
			
			WebTable catalogTbl = WebEleFatrory.GetWebTable("颜色,新客价");
			for(int i=0;i<PropertyValuesBean.size();i++){
				JSONObject PropertyValueBean = PropertyValuesBean.getJSONObject(i);
				
				//get line
				int row = catalogTbl.getRowByKeyVal(Arrays.asList(PropertyValueBean.getString("Property").split(",")));
				catalogTbl.getCellItem(row, 4, WebEdit.class, "price").set(PropertyValueBean.getString("Price"));
				catalogTbl.getCellItem(row, 5, WebEdit.class, "vipPrice").set(PropertyValueBean.getString("VIPPrice"));
				catalogTbl.getCellItem(row, 6, WebEdit.class, "newCustomerPrice").set(PropertyValueBean.getString("NewCustomerPrice"));
				catalogTbl.getCellItem(row, 7, WebEdit.class, "count").set(PropertyValueBean.getString("Num"));
				catalogTbl.getCellItem(row, 8, WebEdit.class, "number").set(PropertyValueBean.getString("SKU"));
				catalogTbl.getCellItem(row, 9, WebEdit.class, "productCode").set(PropertyValueBean.getString("ProductCode"));
				
				
				if (PropertyValueBean.getInteger("Action") == 0){
					catalogTbl.getCellItem(row, 1, WebCheckBox.class, "categorychecked").setOn();
				}else{
					catalogTbl.getCellItem(row, 1, WebCheckBox.class, "categorychecked").setOff();
				}
			}
		}
		
		WebEleFatrory.GetWebButton("SubmitAdd").click();
		
		
		
		
		
		
	}

	
	public static void selectCatagroryAndBrand(JSONObject step1){
		//选择规格
		if (step1.getInteger("CatalogType")==0){
			WebEleFatrory.GetWebRadioBox("liverelease").set("普通商品");;
		}else{
			WebEleFatrory.GetWebRadioBox("liverelease").set("FBX商品");;
		}
		
		WebEleFatrory.GetWebLink(step1.getString("MainCategoryName")).click();
		TimeUtil.WaitTime(1);
		WebEleFatrory.GetWebLink(step1.getString("SubCategoryName")).click();
		TimeUtil.WaitTime(1);
		WebEleFatrory.GetWebLink(step1.getString("ThirdCategoryName")).click();
		TimeUtil.WaitTime(1);
		WebEleFatrory.GetWebEdit("SelectBrandText").set(step1.getString("BrandName"));
		
		WebEleFatrory.GetWebButton("SubFromCategory").click();
	}
	
	
 	

}
