package com.ymatou.uitest.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
	
	public  static  String readFile (String filePath) {
        String content = "";
        try{
        		BufferedReader br = new BufferedReader(new FileReader(filePath));
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
