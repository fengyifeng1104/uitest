package com.ymatou.uitest.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtil {
	
	public  static  String readFile (String filePath) {
        String content = "";
        try{
    		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath),"UTF-8"));
    		String s;
    		while((s = br.readLine())!=null){
    			content = content+s;
    		}
    		br.close();
        	}catch (FileNotFoundException e){
        		e.printStackTrace();
        	}catch (IOException e){
        		e.printStackTrace();
        	}
        return  content;
	}
}
