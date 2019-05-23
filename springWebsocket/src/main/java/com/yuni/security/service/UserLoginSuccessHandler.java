package com.yuni.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.yuni.model.UserDTO;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication auth) throws IOException, ServletException {
		//인증된 사용자의 정보 리턴 
		UserDTO dto =(UserDTO) auth.getPrincipal();
		System.out.println(dto);
		String msg= auth.getName()+"님 환영합니다.";
		request.setAttribute("msg", msg);
		
		
		request.getRequestDispatcher("/board/list").forward(request, response);
	}


}
