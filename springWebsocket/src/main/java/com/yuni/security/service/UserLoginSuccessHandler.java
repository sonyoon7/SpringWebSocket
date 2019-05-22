package com.yuni.security.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//request.setAttribute("errMsg", "관리자만 사용할 수 있는 기능 입니다.");
		
		//request.getRequestDispatcher("/WEB-INF/views/user/denied.jsp").forward(request, response);
	}


}
