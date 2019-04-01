package com.aiit.shiro.dao;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.aiit.shiro.domain.User;

@Repository
public interface ShiroMapper {

	public User SearchName(String username);
	public void Add(Map<String,Object> map);
}
