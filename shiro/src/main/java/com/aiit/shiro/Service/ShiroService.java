package com.aiit.shiro.Service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.aiit.shiro.dao.ShiroMapper;
import com.aiit.shiro.domain.User;

@Service
public class ShiroService {

	@Resource
	private ShiroMapper shiromapper;
	public User SearchName(String username)
	{
		return shiromapper.SearchName(username);
	}
}
