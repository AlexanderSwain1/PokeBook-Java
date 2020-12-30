package com.revature.pokebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/login")
public class LoginController 
{
	@RequestMapping(value="/login")
	@ResponseBody
	public void login(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("login user not implemented");
	}

	@RequestMapping(value="/logout")
	@ResponseBody
	public void logout(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("logout user not implemented");
	}
}
