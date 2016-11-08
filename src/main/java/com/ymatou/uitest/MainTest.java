package com.ymatou.uitest;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ymatou.uitest.biz.product.ProductBiz;
import com.ymatou.uitest.biz.util.Login;
import com.ymatou.uitest.util.FileUtil;
import com.ymatou.uitest.util.LoggerUtil;

/**
 * Hello world!
 *
 */
public class MainTest 
{
	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("CatalogType", 0);
		map.put("MainCategoryName", "美容个护");
		map.put("SubCategoryName", "面部护肤");
		map.put("ThirdCategoryName", "爽肤");
		map.put("BrandName", "阿迪达斯");
		
		
		
		
		Login.loginSellerAsDefault();


		
		
		
	//	JSONObject aJsonObject = JSON.parseObject(FileUtil.readFile(System.getProperty("user.dir")+"\\config\\jsonbeantpl\\AddNewProductTpl.json"));
 		//ProductBiz.AddNewProduct(new JSONObject(map), aJsonObject);
		
	}
	

}
