package com.alex.utils;

import java.util.List;

public class StringUtils {
	
	public  static  String listToString(List<String> list){
		
		StringBuilder stringBuilder=new StringBuilder();
		
		for (String s : list) {
			stringBuilder.append(s);
		}
		
		return  stringBuilder.toString();
	}
	
}
