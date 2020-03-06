package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dao.UserDao;
import com.model.User;

@Controller
public class UserLoginController
{
	@Autowired
	UserDao userDao;
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam("userId")String userId,@RequestParam("password")String password)
	{
		ModelAndView mv =new ModelAndView();
		User user =new User();
		user.setUserId(userId);
		user.setPassword(password);
		
		String name=userDao.loginUser(user);
		if (name != null) 
		{
			mv.addObject("msg","sucessfully logged in  "  +name);
			mv.setViewName("welcome");
		}
		else 
		{
			mv.addObject("msg","invalid userId and password");
			mv.setViewName("login");
		}
		return mv;
	}

	
}
