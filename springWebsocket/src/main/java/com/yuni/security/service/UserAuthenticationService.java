package com.yuni.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.yuni.model.UserDTO;

import lombok.extern.log4j.Log4j;
@Log4j
public class UserAuthenticationService implements UserDetailsService {
	//login-processing-url -> userDetailService를 구현한 클래스가 실행됨
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
//UserDetailsService 의 loadUserByUsername method를 구현하는데 이는 Database에 접근해서 사용자 정보를 가져오는 역할을 한다.

	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		System.out.println("-----------------------loadUserByUsername-----------------------------");
		System.out.println(userid);
		//여기를 통해서 세부 인증 처리가 됨 
		//보기에는 id만 통해서 인증 처리 하는 것 같지만 내부적으로 비밀번호 체크까지 해줌 
		Map<String, Object> user = sqlSession.selectOne("user.selectUser",userid);
		System.out.println(user);
		if(user==null) throw new UsernameNotFoundException(userid);
		
		List<GrantedAuthority> authority= new ArrayList<>();
		
		//오라클은 필드명 대문자로 적어야 함..BIgInteger..
		//(Integer)Integer.valueOf(user.get("ENABLED").toString())==1;
		authority.add(new SimpleGrantedAuthority(user.get("authority").toString()));
		//new UserDTO(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities, userid)
		System.out.println("------------------------------------------------------------------------");
		return new UserDTO(user.get("username").toString(),
				user.get("password").toString(),
				(Integer)Integer.valueOf(user.get("enabled").toString())==1,
				true, 
				true, 
				true, authority, 
				user.get("username").toString());
	}

}
