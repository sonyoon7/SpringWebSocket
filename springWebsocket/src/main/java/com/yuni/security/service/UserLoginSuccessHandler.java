package com.yuni.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.yuni.model.UserDTO;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		//인증된 사용자의 정보 리턴 
		/*
		 * System.out.println(" 1: "+auth.getName());
		 * System.out.println(" 2: "+auth.getAuthorities());
		 * System.out.println(" 3: "+auth.getDetails());
		 * System.out.println(" 4: "+auth.getCredentials());
		 */
		UserDTO dto =(UserDTO) auth.getPrincipal();
		System.out.println(dto);
		String msg= auth.getName()+"님 환영합니다.";
		request.setAttribute("msg", msg);
		 // 세션을 가져온다. (가져올 세션이 없다면 생성한다.)
		HttpSession session= request.getSession(true);
		
		 // "USER"로 sessionVO를 세션에 바인딩한다.
		session.setAttribute("user", auth.getName());
		System.out.println(session.getAttribute("user"));
		
		request.getRequestDispatcher("/board/list").forward(request, response);
	}


}
