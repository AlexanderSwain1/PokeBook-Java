package com.revature.pokebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebook.models.Message;
import com.revature.pokebook.services.MessageService;

@RestController
@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/messages")
public class MessageController 
{
	
	private MessageService ms;
	
	@Autowired
	public MessageController(MessageService ms) 
	{
		super();
		this.ms = ms;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Message> getMessages() 
	{
		return ms.getMessages();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") int id) 
	{
		
		Message result = ms.getMessage(id);
		if (result == null)
			return ResponseEntity.status(HttpStatus.OK).body(result);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	@RequestMapping(method=RequestMethod.POST)
	public void create(@RequestBody Message message) 
	{
		ms.createMessage(message);
	}

	@RequestMapping(method=RequestMethod.PATCH)
	public void update(@RequestBody Message message) 
	{
		ms.updateMessage(message);
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void delete(@RequestBody Message message) 
	{
		ms.deleteMessage(message);
	}

}
