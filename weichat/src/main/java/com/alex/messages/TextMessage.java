package com.alex.messages;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TextMessage {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String Content;
	private String MsgId;
	
}
