package com.alex.utils;

import com.alex.messages.ImageMessage;
import com.alex.messages.News;
import com.alex.messages.TextImageMessage;
import com.alex.messages.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将微信发送过来的流数据取出并转换的工具类
 */

public class MessagesUtils {
	
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
		
		/**
		 *
		 * map中的key值
		 ToUserName	开发者微信号
		 FromUserName	发送方帐号（一个OpenID）
		 CreateTime	消息创建时间 （整型）
		 MsgType	text
		 Content	文本消息内容
		 MsgId	消息id，64位整型
		 *
		 *
		 *
		 */
		
		Map<String, String> map = new HashMap<String, String>();
		SAXReader reader = new SAXReader();
		
		InputStream ins = request.getInputStream();
		Document doc = reader.read(ins);
		
		Element root = doc.getRootElement();
		
		List<Element> list = root.elements();
		
		for (Element e : list) {
			map.put(e.getName(), e.getText());
		}
		ins.close();
		
		return map;
		
	}
	
	/**
	 * 将文文本消息转换成 xml格式
	 *
	 * @param textMessage 文本消息封装类
	 * @return
	 */
	
	public static String textMessageToXml(TextMessage textMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml", textMessage.getClass());
		return xStream.toXML(textMessage);
		
	}
	
	public static String textImageMessageToXml(TextImageMessage textImageMessage) {
		XStream xStream = new XStream();
		xStream.alias("item", new News().getClass());
		xStream.alias("xml",TextImageMessage.class);
		return xStream.toXML(textImageMessage);
		
	}
	
	
	
	public static String ImageMessageToXml(ImageMessage imageMessage) {
		XStream xStream = new XStream();
		xStream.alias("xml",ImageMessage.class);
		return xStream.toXML(imageMessage);
		
	}
	
	
}
