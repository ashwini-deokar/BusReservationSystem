package com.ashwini.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthenticationController {
	@RequestMapping(method=RequestMethod.GET ,value="/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST ,value="/doLogin")
	public ModelAndView doLogin(String username,String password)
	{
		ModelAndView model=new ModelAndView();
		if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin"))
		{
			model.addObject("message", "successfully login");
			model.setViewName("dashboard");
		}
		else
		{
			model.addObject("message", "login error");
			model.setViewName("errorlogin");
		}
		return model;
	}
	

}
