package com.qf.util;

import com.qf.pojo.DtsAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * 用于权限支持服务
 * @author zhaojian
 *
 */
public class AuthSupport {

	public static final Object BRAND_ROLE_NAME = "品牌制造商";

	public static final Object SUPER_ROLE_NAME = "超级管理员";
	

	/**
	 * 获取用户
	 * @return
	 */
	public static DtsAdmin currentUser() {
		DtsAdmin admin = null;
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser != null) {
			admin = (DtsAdmin) currentUser.getPrincipal();
		}
		return admin;
	}
	
	/**
	 * 获取用户名
	 * @return
	 */
	public static String userName() {
		String userName = null;
		DtsAdmin currentUser = currentUser();
		if (currentUser != null) {
			userName = currentUser.getUsername();
		}
		return userName;
	}
	
	/**
	 * 获取用户id
	 * @return
	 */
	public static Integer adminId() {
		Integer adminId = null;
		DtsAdmin currentUser = currentUser();
		if (currentUser != null) {
			adminId = currentUser.getId();
		}
		return adminId;
	}
}
