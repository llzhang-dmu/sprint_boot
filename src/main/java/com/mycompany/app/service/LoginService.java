package com.mycompany.app.service;


import java.util.Map;

import org.springframework.stereotype.Service;



public interface LoginService {

	
	public Map<String, Object> loginValidate(String username,String password);
	
	
}
