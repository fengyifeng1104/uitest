package com.ymatou.uitest;

import static com.codeborne.selenide.Selenide.open;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.codeborne.selenide.Configuration;
public class uitest {
	
	
	@Test
	public void userCanLoginByUsername() {
		try{		
			Configuration.browser="chrome";		
			
			Configuration.browser="chrome";		
			System.setProperty("webdriver.chrome.driver", "E:\\workspace\\uitest\\resource\\chromedriver_x64.exe");

			open("http://www.baidu.com");
		
		
		
		
		
		
		//
		
			//System.setProperty ( "webdriver.firefox.bin" , "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe" );
		// open("http://www.baidu.com");
		 
		 
		 
		/*  $(By.name("user.name")).setValue("johny");
		  $("#submit").click();
		  $(".loading_progress").should(disappear); // Waits until element disappears
		  $("#username").shouldHave(text("Hello, Johny!")); // Waits until element gets text
*/		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//Configuration.browser="chrome";		
		System.setProperty("webdriver.chrome.driver", "E:\\workspace\\uitest\\resource\\chromedriver_x64.exe");

		ChromeOptions option = new ChromeOptions();
		 option.addArguments("-test-type");  
		ChromeDriver driver = new ChromeDriver(option);
		//new uitest().userCanLoginByUsername();
	}
}
	

