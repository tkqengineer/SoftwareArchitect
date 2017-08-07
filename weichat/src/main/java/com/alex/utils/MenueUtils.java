package com.alex.utils;

import com.alex.menue.Button;
import com.alex.menue.ClickButton;
import com.alex.menue.Menu;
import com.alex.menue.ViewButton;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class MenueUtils {
	
	private  static  String CREATE_MENU_URL="https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
	
	public static Menu initMenu(){
		Menu menu = new Menu();
		ClickButton button11 = new ClickButton();
		button11.setName("click菜单");
		button11.setType("click");
		button11.setKey("11");
		
		ViewButton button21 = new ViewButton();
		button21.setName("view菜单");
		button21.setType("view");
		button21.setUrl("http://www.imooc.com");
		
		ClickButton button31 = new ClickButton();
		button31.setName("扫码事件");
		button31.setType("scancode_push");
		button31.setKey("31");
		
		ClickButton button32 = new ClickButton();
		button32.setName("地理位置");
		button32.setType("location_select");
		button32.setKey("32");
		
		Button button = new Button();
		button.setName("菜单");
		button.setSub_button(new Button[]{button31,button32});
		
		menu.setButton(new Button[]{button11,button21,button});
		return menu;
	}
	
	public static String createMenu(String token,String menu) throws ParseException, IOException {
		
		String url = CREATE_MENU_URL.replace("ACCESS_TOKEN", token);
		
		return doPostStr(url, menu);
	}
	
	public static String doPostStr(String url,String outStr) throws ParseException, IOException{
		DefaultHttpClient client = new DefaultHttpClient();
		HttpPost httpost = new HttpPost(url);
	
		httpost.setEntity(new StringEntity(outStr,"UTF-8"));
		HttpResponse response = client.execute(httpost);
		String result = EntityUtils.toString(response.getEntity(),"UTF-8");
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		
		Gson gson=new Gson();
		System.out.println(gson.toJson(initMenu()));
		createMenu("HDj5LnwMCIabobdfAMtL_RaPLjjj9LMus9UWAU-yAuSAciCbor9B7s6C8eiKAPPC5U-k_k8YWS72vObOhxPM-dq4RVrO9MN8fWWLlM9K56U2Lld94FcWXk-woYcF4NwiXITiAFATEP",gson.toJson(initMenu()));
	}
	
	
}
