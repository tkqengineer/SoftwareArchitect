package com.alex.messages;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class TextImageMessage {
	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String ArticleCount;
	private List<News> Articles;
	
}
