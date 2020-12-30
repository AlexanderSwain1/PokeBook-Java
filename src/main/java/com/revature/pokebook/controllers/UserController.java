package com.revature.pokebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.services.UserService;

@Controller
@RequestMapping(value="/users")
public class UserController
{
	
	private UserService us;
	
	//Construction injection
	@Autowired
	public UserController(UserService us) {
		super();
		this.us = us;
	}
	
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void getUsers(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get users not implemented");
	}

	/*
	public void getUser(Integer pathParameter, HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get user not implemented");
	}*/

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("create user not implemented");
	}

	@RequestMapping(method=RequestMethod.PATCH)
	@ResponseBody
	public void update(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("update user not implemented");
	}

	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("delete user not implemented");
	}
	
}
