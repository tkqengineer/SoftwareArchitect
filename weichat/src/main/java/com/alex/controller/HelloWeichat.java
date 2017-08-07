package com.alex.controller;

import com.alex.messages.*;
import com.alex.utils.MessagesUtils;
import com.alex.utils.Sha1Utils;
import com.alex.utils.StringOrderUtils;
import com.alex.utils.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class HelloWeichat {
	
	private String token = "tkqengineer";
	
	@GetMapping("/wx.action")
	@ResponseBody
	public String hello(String signature, String timestamp, String nonce, String echostr) {
		
		List<String> list = StringOrderUtils.OrderStrings(timestamp, nonce, token);
		String string = StringUtils.listToString(list);
		String sha1 = Sha1Utils.getSha1(string);
		if (sha1.equals(signature)) {
			return echostr;
		}
		return null;
	}
	
	@PostMapping("/wx.action")
	@ResponseBody
	public String hello2(HttpServletRequest request) throws Exception {
		
		Map<String, String> messages = MessagesUtils.xmlToMap(request);
		String fromUserName = messages.get("FromUserName");
		String toUserName = messages.get("ToUserName");
		String msgType = messages.get("MsgType");
		String content = messages.get("Content");
		
		if (content.equals("1")) {
			TextMessage textMessage = new TextMessage();
			textMessage.setContent("hello weichat");
			textMessage.setCreateTime(new Date().getTime() + "");
			textMessage.setFromUserName(toUserName);
			textMessage.setToUserName(fromUserName);
			textMessage.setMsgType("text");
			String s = MessagesUtils.textMessageToXml(textMessage);
			return s;
		} else if (content.equals("2")) {
			TextImageMessage textImageMessage = new TextImageMessage();
			textImageMessage.setArticleCount("1");
			textImageMessage.setCreateTime(new Date().getTime() + "");
			textImageMessage.setFromUserName(toUserName);
			textImageMessage.setToUserName(fromUserName);
			textImageMessage.setMsgType("news");
			
			List<News> news = new ArrayList<News>();
			News news1 = new News();
			news1.setDescription("hello weichat");
			news1.setPicUrl("https://www.baidu.com/img/bd_logo1.png");
			news1.setUrl("https://www.baidu.com");
			news1.setTitle("hello alex");
			news.add(news1);
			textImageMessage.setArticles(news);
			System.out.println(MessagesUtils.textImageMessageToXml(textImageMessage));
			
			return MessagesUtils.textImageMessageToXml(textImageMessage);
		} else {
			
			ImageMessage imageMessage = new ImageMessage();
			imageMessage.setCreateTime(new Date().getTime() + "");
			imageMessage.setFromUserName(toUserName);
			imageMessage.setToUserName(fromUserName);
			imageMessage.setMsgType("image");
			Image image = new Image();
			image.setMediaId("qgFoZ3Cje3Y2FJTuDtoDlMIOY9ifJWjV6NDYCenQXOzeMAwf9cK53J41Xh6EmAwR");
			imageMessage.setImage(image);
			System.out.println(MessagesUtils.ImageMessageToXml(imageMessage));
			return MessagesUtils.ImageMessageToXml(imageMessage);
		}
		
	}
	
}
