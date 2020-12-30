package com.revature.pokebook.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.services.MessageService;

@Controller
@RequestMapping(value="/messages")
public class MessageController 
{
	
	private MessageService ms;
	
	//Construction injection
	@Autowired
	public MessageController(MessageService ms) {
		super();
		this.ms = ms;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public void getMessages(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get messages not implemented");
	}

	/*
	public void getMessage(Integer pathParameter, HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("get message not implemented");
	}*/

	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void create(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("create message not implemented");
	}

	@RequestMapping(method=RequestMethod.PATCH)
	@ResponseBody
	public void update(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("update message not implemented");
	}

	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public void delete(HttpServletRequest request, HttpServletResponse response) 
	{
		System.out.println("delete message not implemented");
	}

}
