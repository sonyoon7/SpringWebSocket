package com.yuni.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yuni.model.UserDAO;
import com.yuni.service.ShaEncoder;

public class UserController {
	@Inject
	private ShaEncoder shaEncoder;
	
	@Inject
	private UserDAO userDao;
	
	@RequestMapping("/user/login")
	public String login() {
		return "user/login";
	}
	@RequestMapping("/user/join")
	public String join() {
		return "user/join";
	}
	@RequestMapping("/user/denied")
	public String denied(Model model, Authentication auth, HttpServletRequest request) {
		return "user/denied";
	}
	

}
