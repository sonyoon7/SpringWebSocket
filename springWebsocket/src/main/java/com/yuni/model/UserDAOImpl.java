package com.yuni.model;

import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {
	
	@Inject
	SqlSession sqlSession;
	
	//회원가입 처리
	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert("user.insertUser", map);
	}
	
	//로그인 처리
	@Override
	public Map<String, Object> selectUser(String userid) {
		return sqlSession.selectOne("user.selectUser", userid);
	}

}
