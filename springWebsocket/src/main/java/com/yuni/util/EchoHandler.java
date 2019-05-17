package com.yuni.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
@Log4j
public class EchoHandler extends TextWebSocketHandler{

	private List<WebSocketSession> sessionList = new ArrayList<>();
//	클라이언트와 연결 된 후
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		//맵을 쓸때 방법
		//sessions.put(session.getId(),session);
		
		//List쓸 때 
		sessionList.add(session);
//		logger.info("{} 연결 됨", session.getId());
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		// TODO Auto-generated method stub
		super.afterConnectionClosed(session, status);
	}
	
	
}
