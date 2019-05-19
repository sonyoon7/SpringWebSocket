package com.yuni.util;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.log4j.Log4j;
@Log4j
public class EchoHandler extends TextWebSocketHandler implements InitializingBean{

	 private Set<WebSocketSession> sessionSet = new HashSet<WebSocketSession>();
	 
	    public EchoHandler (){
	        super();
	    }
	    
	    // 사용자가 나갈경우 불러오는 메소드 웹소켓세션객체에서 리무브한다
	    @Override
	    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
	        super.afterConnectionClosed(session, status);
	        //삭제 
	        sessionSet.remove(session);
	        log.info("{} 연결 끊김"+ session.getId());
	    }
	// 사용자가 웹소켓에 연결되면 불러온다 add 한다
	    @Override
	    public void afterConnectionEstablished(WebSocketSession session)
	            throws Exception {
	        super.afterConnectionEstablished(session);
	        sessionSet.add(session);
	        log.info(session.getId()+"님이 접속했습니다");
	        log.info("연결 IP "+session.getRemoteAddress().getHostName() );
	    }
	    
	    //웹 소켓 서버로 데이터를 전송했을 경우 
	    @Override
		protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
			//super.handleTextMessage(session, message);
			log.info(session.getId()+"로 부터  {"+message.getPayload()+"} 받음 ");
			//연결된 모든 클라이언트에게 메세지 전송 : 
			for(WebSocketSession sess : sessionSet) {
				sess.sendMessage(new TextMessage(session.getPrincipal().getName()+" | "+message.getPayload()));
			}
		}

		// 사용자가 채팅할 내용을 적고 보내기를 눌르면 불러온다
	    @Override
	    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
	        super.handleMessage(session, message);
	        sendMessage(message.getPayload().toString());
	    }
	//에러
	    @Override
	    public void handleTransportError(WebSocketSession session,
	            Throwable exception) throws Exception {
	    }
	 
	    @Override
	    public boolean supportsPartialMessages() {
	        return super.supportsPartialMessages();
	    }
	// 함수를 따로 정의하였다 메세지를 보내는 함수이다 웹소켓에 저장한 사용자들에게 모두다 보낸다
	    public void sendMessage (String message){
	        for (WebSocketSession session: this.sessionSet){
	            if (session.isOpen()){
	                try{
	                    session.sendMessage(new TextMessage(message));
	                }catch (Exception ignored){
//	                    this.logger.error("fail to send message!", ignored);
	                }
	            }
	        }
	    }
	// thread로 현새기각을 클라이언트에게 주기적으로 
	    @Override
	    public void afterPropertiesSet() throws Exception {
	        Thread thread = new Thread(){
	            int i=0;
	            @Override
	            public void run() {
	                while (true){
	                    try {
	                        String json = String.format("{\"type\":\"time\", \"time\":\"%s\"}", System.currentTimeMillis());
	                        sendMessage(json);
	                        Thread.sleep(300);
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                        break;
	                    }
	                }
	            }
	        };
	 
	        thread.start();
	    }
}
