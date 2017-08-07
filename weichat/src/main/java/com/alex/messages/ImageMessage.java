package com.alex.messages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageMessage {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private  Image Image;
	
}
