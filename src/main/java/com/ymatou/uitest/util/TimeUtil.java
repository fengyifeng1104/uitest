package com.ymatou.uitest.util;

public class TimeUtil {

	public static void WaitTime(int second){
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
