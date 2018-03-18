package com.cn.wy.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.cn.wy.pojo.User;


/**
 * 基础�?
 * @author Administrator
 *
 */
public class BaseController {
	
	// 获取request
	public static HttpServletRequest getRequest() { 
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
		return attrs.getRequest(); 
	} 
	
	// 获取session
	public static HttpSession getSession() { 
		HttpSession session = null; 
		try { 
		    session = getRequest().getSession(); 
		} catch (Exception e) {} 
	    return session; 
	} 
	
	// 获取user
	public User getUser() {
		return (User) getSession().getAttribute("user");
	}

	// 获取登录�?
	protected String getUserLoginName() {
		return getUser().getName();
	}
	
	// 获取登录�?
	protected String getUserRealName() {
		return getUser().getRelname();
	}
}
