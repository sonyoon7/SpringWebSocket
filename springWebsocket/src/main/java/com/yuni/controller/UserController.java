package com.yuni.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yuni.model.UserDAO;
import com.yuni.service.ShaEncoder;

import lombok.extern.log4j.Log4j;
@Controller
@Log4j
public class UserController {
	@Inject
	private ShaEncoder shaEncoder;
	
	@Inject
	private UserDAO userDao;
	
	@RequestMapping("/user/login")
	public String login() {
		System.out.println("login 페이지로 이동");
		log.info("login 페이지로 이동");
		return "user/login";
	}
	@RequestMapping("/user/join")
	public String join() {
		System.out.println("join 페이지로 이동");
		return "user/join";
	}
	@RequestMapping("/user/denied")
	public String denied(Model model, Authentication auth, HttpServletRequest request) {
		return "user/denied";
	}
	
	@RequestMapping("/user/insertUser")
	public String insertUser(@RequestParam String userid, String passwd, String name, String authority) {
		System.out.println(userid+", "+passwd+", "+name+", "+authority);
//		@RequestParam 생략가능
		log.info(userid+", "+passwd+", "+name+", "+authority);
		String dbpw= shaEncoder.saltEncoding(passwd, userid);//비밀번호 : 키값(userid)
		Map<String,String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("passwd", passwd);
		map.put("name", name);
		map.put("authority", authority);
		int result =userDao.insertUser(map);
		System.out.println("insert User");
		return "user/login";
	}
	

}
