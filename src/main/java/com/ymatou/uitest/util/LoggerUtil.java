package com.ymatou.uitest.util;

import org.apache.log4j.Logger;

public class LoggerUtil {
	private static Logger  logger = Logger.getLogger(LoggerUtil.class);  
	
	public static void info(String message){
		logger.info(message);
	}
	
	public static void warn(String message){
		logger.warn(message);
	}
	
	public static void fatal(String message){
		logger.fatal(message);
	}
	
	public static void error(String message){
		logger.error(message);
	}
	
	
	public static void debug(String message){
		logger.debug(message);
	}
}
