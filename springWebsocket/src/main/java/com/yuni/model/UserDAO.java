package com.yuni.model;

import java.util.Map;

public interface UserDAO {
	public int insertUser(Map<String, String> map);
	public Map<String, Object> selectUser(String userid);

}
