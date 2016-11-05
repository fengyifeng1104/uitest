package com.ymatou.uitest.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtil {

	private Properties prop = new Properties();
	String fp=null;
	
	/**
	 */
	public ConfigUtil(String filepath) {
		try{
			fp=System.getProperty("user.dir") +"/"+filepath;
			InputStream is = new FileInputStream(new File(System.getProperty("user.dir") +"/"+filepath));
			prop.load(is);
		}catch(Exception e){
			System.err.println("Load Property ERROR��Property File Path:"+filepath);
			e.printStackTrace();
		}
	}
	
	/**
	 * ��ȡ����ֵ
	 * @param property ����key
	 * @return value
	 */
	public String getProperty(String property){
		String value=null;
		try{
			value=prop.getProperty(property);
		}catch(Exception e){
			System.err.println("GET Property Value ERROR��Property Key:"+property);
			e.printStackTrace();
		}
		return value;
	}
	/**
	 * @throws Exception 
	 */
	public void saveProperty() throws Exception{
		FileOutputStream fos=new FileOutputStream(fp);
		prop.store(fos,null);
		fos.close();
	}
	//	 */
	public void setProperty(String key,String value){
		try{
			prop.setProperty(key, value);
		}catch(Exception e){
			System.err.println("SET Property Value ERROR��Property Key:"+key+",Property value:"+value);
			e.printStackTrace();
		}
	}
}