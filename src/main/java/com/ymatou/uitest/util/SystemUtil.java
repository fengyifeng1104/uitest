package com.ymatou.uitest.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemUtil {
	public static void killProcess(String processName){
	/*	String command = "taskkill /f /im "+processName;  
		try {
			Process p = Runtime.getRuntime().exec("cmd /c tasklist");
			InputStream is = p.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buf = new byte[4096];
			while(is.read(buf)>0){
			 	if (new String(buf).contains(processName)){
			 		Runtime.getRuntime().exec(command);
			 	}
			}
			bis.close();
			is.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		final String command = "taskkill /f /im "+processName;  
		doWithProcess(processName, new doInProcess(){
			public void action(){
				try {
					Runtime.getRuntime().exec(command);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
	
	public static boolean findProcess(String processName){
		try {
			Process p = Runtime.getRuntime().exec("cmd /c tasklist");
			InputStream is = p.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buf = new byte[4096];
			while(is.read(buf)>0){
			 	if (new String(buf).contains(processName)){
			 		return true;
			 	}
			}
			bis.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	public static void doWithProcess(String processName,doInProcess processAction){
		try {
			Process p = Runtime.getRuntime().exec("cmd /c tasklist");
			InputStream is = p.getInputStream();
			BufferedInputStream bis = new BufferedInputStream(is);
			byte[] buf = new byte[4096];
			while(is.read(buf)>0){
			 	if (new String(buf).contains(processName)){
			 		processAction.action();
			 	}
			}
			bis.close();
			is.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		killProcess("chromedriver_x64.exe");
	}
	
	
	public interface doInProcess{
		public void action();
	}
}
