package com.yuni.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.extern.log4j.Log4j;
@Log4j
public class UserAuthenticationService implements UserDetailsService {
	
	private SqlSessionTemplate sqlSession;
	
	UserAuthenticationService(){}
	//스프링 컨테이너가 sqlSession 주입 할 수 있도록 하는 생성자 
	UserAuthenticationService(SqlSessionTemplate sqlSession){
		this.sqlSession=sqlSession;
	}

//	로그인 인증을 처리하는 코드
//	파라미터로 입력된 아이디값에 해당하는 테이블의 레코드를 읽어옴
//	정보가 없으면 예외를 방생시킴
//	정보가 있으면 해당 정보가 map(dto)로 리턴됨
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		Map<String, Object> user = sqlSession.selectOne("user.selectUser",userid);
		log.info(user);
		if(user==null )throw new UsernameNotFoundException(userid);
		List<GrantedAuthority> authority= new ArrayList<>();
		
		//오라클은 필드명 대문자로 적어야 함..BIgInteger..
		//(Integer)Integer.valueOf(user.get("ENABLED").toString())==1;
		//authority.add(new SimpleGrantedAuthority(user.get("AUTHORITY").toString()));
		
		return null;
	}

}
