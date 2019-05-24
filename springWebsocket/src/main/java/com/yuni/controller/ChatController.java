package com.yuni.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class ChatController {
	
    @RequestMapping("/chat")
    public ModelAndView viewChattingPage(ModelAndView mv) {
    	mv.setViewName("chatting/chat");
    	
    	//사용자 정보 출력 (세션)
    	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	System.out.println("userid: "+user.getUsername());
    	mv.addObject("userId", user.getUsername());
        return mv;
    }
     
    @RequestMapping("/websocket")
    public String viewPaintingPage() {
        return "chat";
    }


}
