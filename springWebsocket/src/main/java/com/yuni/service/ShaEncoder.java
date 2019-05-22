package com.yuni.service;

import javax.annotation.Resource;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ShaEncoder {
	
	//security-context.xml에 선언된passwordEncoder bean 참조
	@Resource(name="passwordEncoder") //주입해줌 이름으로..
	private ShaPasswordEncoder encoder;
	
	public String encoding(String str) {
		return encoder.encodePassword(str, null);
	}
	
	//평문을 암호화하는 코드 
	public String saltEncoding(String str, String salt) {//key 값을 먼저 준 다음에 암호화 시키는 방법
		return encoder.encodePassword(str,salt);
	}

}
