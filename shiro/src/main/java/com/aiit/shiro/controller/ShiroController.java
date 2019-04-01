package com.aiit.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aiit.shiro.Service.ShiroService;

@Controller
public class ShiroController {
	@RequestMapping("/login")
    @ResponseBody
    public String authenticate(@RequestParam("username") String username, @RequestParam("password") String password,
                               HttpServletRequest request, HttpSession session, HttpServletResponse response) {

        //把前端输入的username和password封装为token
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 认证身份
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            session.setAttribute("user", subject.getPrincipal());
            return "success";
        } catch (Exception e) {
            return "false";
        }
	}
}



