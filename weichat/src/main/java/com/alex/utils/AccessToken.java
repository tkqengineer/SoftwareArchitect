package com.alex.utils;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class AccessToken {
	private static String APPID = "wxf77772ca69cba108";
	private static String APPSECRET = "c0c0a256a85960b66540d6e0b950e974";
	private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + APPID + "&secret=" + APPSECRET;
//	private static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	
	public static String getAccessToken() throws Exception {
		
		DefaultHttpClient client = new DefaultHttpClient();
		
		//String url = ACCESS_TOKEN_URL.replace("APPID", APPID).replace("APPSECRET", APPSECRET);
		HttpGet httpGet = new HttpGet(ACCESS_TOKEN_URL);
		
		HttpResponse httpResponse = client.execute(httpGet);
		HttpEntity entity = httpResponse.getEntity();
		
		return EntityUtils.toString(entity);
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getAccessToken());
	}
	
	
}
