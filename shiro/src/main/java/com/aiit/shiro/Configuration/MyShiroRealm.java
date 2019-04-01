package com.aiit.shiro.Configuration;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.aiit.shiro.Service.ShiroService;
import com.aiit.shiro.domain.User;

public class MyShiroRealm extends AuthorizingRealm{

	@Resource
	private ShiroService shiroservice;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
		// TODO Auto-generated method stub
		// String username = (String) principalCollection.getPrimaryPrincipal(); */
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username=(String) authenticationToken.getPrincipal();
		User user=shiroservice.SearchName(username);
		if("".equals(username))
		{
			return null;
		}
		SimpleAuthenticationInfo info= new SimpleAuthenticationInfo(username,user.getPassword(),this.getName());
		return info;
	}

}
