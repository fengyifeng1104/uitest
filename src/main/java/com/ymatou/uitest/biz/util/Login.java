package com.ymatou.uitest.biz.util;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.ymatou.uitest.gui.BrowserDriver;
import com.ymatou.uitest.gui.WebEleFatrory;
import com.ymatou.uitest.gui.YmtDriver;
import com.ymatou.uitest.util.EnvSetup;
import com.ymatou.uitest.util.SystemUtil;
import com.ymatou.uitest.util.constant.ContantData;

public class Login {
	
	public static void loginSellerAsDefault(){
		openBrowser();
		if (!WebEleFatrory.FindWebButton("[��ȫ�˳�]").isExist()){
			BrowserDriver.getWebDriver().get(EnvSetup.getEnvVal(ContantData.sellerLoginSite));
			WebEleFatrory.GetWebEdit("loginName").set(EnvSetup.getEnvVal(ContantData.defaultLoginUser));
			WebEleFatrory.GetWebEdit("loginPwd").set(EnvSetup.getEnvVal(ContantData.defaultLoginPswd));
			WebEleFatrory.GetWebButton("btnSubmit").click();
		}
	}
	
	
	public static void openBrowser(){
		String remoteServer = EnvSetup.getDeployVal(ContantData.chromeRemoteServer);
		String sessionId = EnvSetup.getDeployVal(ContantData.chromeSessionId);
		
		
		if (isBrowserExist()){
			YmtDriver driver = new YmtDriver(remoteServer,sessionId);
			BrowserDriver.setWebDriver(driver);
		}else{
			
			ChromeOptions option = new ChromeOptions();
			 option.addArguments("-test-type");  
			ChromeDriver driver = new ChromeDriver(option);
			RemoteWebDriver remoteWebDriver = (RemoteWebDriver)driver;
			sessionId = remoteWebDriver.getSessionId().toString();
			   
			HttpCommandExecutor httpCommandExecutor = (HttpCommandExecutor)remoteWebDriver.getCommandExecutor();
			remoteServer = httpCommandExecutor.getAddressOfRemoteServer().toString();
			
			EnvSetup.setDeployVal(ContantData.chromeRemoteServer, remoteServer);
			EnvSetup.setDeployVal(ContantData.chromeSessionId, sessionId);

			BrowserDriver.setWebDriver(driver);
		}
		
		BrowserDriver.getWebDriver().manage().window().maximize();
	}
	
	
	public static boolean isBrowserExist(){
		
		try{
			String remoteServer = EnvSetup.getDeployVal(ContantData.chromeRemoteServer);
			String sessionId = EnvSetup.getDeployVal(ContantData.chromeSessionId);
			new YmtDriver(remoteServer,sessionId);
			return true;
		}catch(Exception e){
			SystemUtil.killProcess("chrome.exe");
			System.out.println("Browser is not Exist");
			
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		loginSellerAsDefault();
	}
	
	
}
