package com.revature.pokebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/follows")
public class FollowController 
{

	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void getFollows(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get follows not implemented");
	}

	/*
	public void getFollow(Integer pathParameter, HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get follow not implemented");
	}*/

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("create follow not implemented");
	}

	@RequestMapping(method=RequestMethod.PATCH)
	@ResponseBody
	public void update(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("update follow not implemented");
	}

	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("delete follow not implemented");
	}

}
