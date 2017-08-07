package com.alex.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符数组工具类
 */
public class StringOrderUtils {
	
	public  static List<String> OrderStrings(String ...str ){
		ArrayList<String> strings = new ArrayList<String>();
		strings.addAll(Arrays.asList(str));
		Collections.sort(strings);
		return strings;
	}
	
}
