package com.yuni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChatController {
	
    @RequestMapping("/chat")
    public String viewChattingPage() {
    	log.info("chatting/chat view 이동");
        return "chatting/chat";
    }
     
    @RequestMapping("/websocket")
    public String viewPaintingPage() {
        return "chat";
    }


}
