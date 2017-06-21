package com.mycompany.app.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.stereotype.Service;

import com.mycompany.app.dao.UserMapper;
import com.mycompany.app.model.User;
import com.mycompany.app.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

	@Resource
	private UserMapper mapper;
	
	private Map<String, Object> map=new HashMap<>();
	
	/**
	 * 判断数据库是否存在该用户
	 * @param name
	 * @return
	 */
	private boolean getUserByName(String name) {
		// TODO Auto-generated method stub
		User user=mapper.selectUserByName(name);
		if (user==null) {
			return false;
		}else {
			return true;
		}
	}
	
    /**
     * 判断用户输入密码与数据库是否一致
     * @param name
     * @param password
     * @return
     */
	private boolean isEqueryPassw(String name,String password){
		String passw=mapper.getPasswordByName(name);
		if (passw.equals(password)) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * 登录验证
	 */
	@Override
	public Map<String, Object> loginValidate(String username, String password) {
		// TODO Auto-generated method stub
		if (!getUserByName(username)) {
			map.put("code", -1);
			map.put("msg", "不存在该用户");
		}else if(!isEqueryPassw(username, password)){
			map.put("code", -1);
			map.put("msg", "密码输入有误");
		}else {
			map.put("code", 0);
			map.put("msg", "登录成功");
		}
		return map;
	}

}
