package com.ymatou.uitest.util;

import org.apache.log4j.Logger;

public class LoggerUtil {
	private static Logger logger ;  
	
	
	@SuppressWarnings("rawtypes")
	public LoggerUtil(Class clz){
		logger = Logger.getLogger(clz);
		
	}
	
	
	
	
	public  void info(String message){
		logger.info(message);
	}
	
	public  void warn(String message){
		logger.warn(message);
	}
	
	public  void fatal(String message){
		logger.fatal(message);
	}
	
	public  void error(String message){
		logger.error(message);
	}
	
	
	public  void debug(String message){
		logger.debug(message);
	}
}
