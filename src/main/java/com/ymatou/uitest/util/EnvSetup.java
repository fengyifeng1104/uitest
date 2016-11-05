package com.ymatou.uitest.util;

import com.ymatou.uitest.util.constant.ContantData;

public class EnvSetup {

	
	
	
	private static ConfigUtil configUtil_deploy =  new ConfigUtil("config/test_env/deploy.properties");
	private static String env = configUtil_deploy.getProperty("env").trim().toLowerCase();
	
	static{
		if (!SystemUtil.findProcess("chrome.exe")){SystemUtil.killProcess("chromedriver_x64.exe");}
		System.setProperty("webdriver.chrome.driver", getDeployVal(ContantData.chromeExePath));
	}

	
	
	
	public EnvSetup() {
		
	}

	
	

	public static String getEnv() {
		return env;
	}

	
	public static String getEnvVal(String proKey) {
		ConfigUtil configUtil2 = new ConfigUtil("config/test_env/env_" + env + ".properties");
		return configUtil2.getProperty(proKey);
	}
	
	public static void setDeployVal(String key,String value){
		configUtil_deploy.setProperty(key, value);
		try {
			configUtil_deploy.saveProperty();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static String getDeployVal(String key){
		return configUtil_deploy.getProperty(key);
	}
	
	

	
	public static void setEnv(String env) {
		EnvSetup.env = env;
	}

	public static void main(String[] args) {
		System.out.println(getEnv());
	}
}
