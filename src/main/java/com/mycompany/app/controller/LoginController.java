package com.mycompany.app.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.*;

import com.mycompany.app.dao.UserMapper;
import com.mycompany.app.model.User;
import com.mycompany.app.service.LoginService;

@RestController
@RequestMapping(value="/user")
public class LoginController {

	@Resource
	private UserMapper userMapper;
	@Resource
	private LoginService loginService;
	
	private Map<String, Object> map;
	
    @RequestMapping(value="/home",method=RequestMethod.GET)
    public Map<String,Object> home() {
        //ModelAndView modelAndView=new ModelAndView();
        //modelAndView.addObject("users",users)
       // return modelAndView;
         map = new HashMap<>();
        List<User> users=userMapper.selectUserList();
        map.put("users", users);
        return map;	
    }
    
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public Map<String, Object> login(String username,String password){
    	map=loginService.loginValidate(username, password);
    	return map;
    }
}
