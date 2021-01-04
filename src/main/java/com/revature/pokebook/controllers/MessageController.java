package com.revature.pokebook.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebook.models.Follow;
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
	
	@GetMapping
	public ResponseEntity<List<Message>> getMessages(
			@RequestParam(name = "pokemon_id", required = false) String pokemon_id) 
	{
		if (pokemon_id != null)
		{
			List<Message> list = ms.getMessagesByPokemonID(Integer.parseInt(pokemon_id));
			if(list==null) 
			{
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else // get all not implemented
			return ResponseEntity.status(HttpStatus.OK).body(ms.getMessages());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Message> getMessage(@PathVariable("id") int id) 
	{
		
		Message result = ms.getMessage(id);
		if (result != null)
			return ResponseEntity.status(HttpStatus.OK).body(result);
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	@PostMapping
	public void create(@RequestBody Message message) 
	{
		message.setMessagePostTime(new Timestamp(System.currentTimeMillis()));
		ms.createMessage(message);
	}

	@PutMapping
	public void update(@RequestBody Message message) 
	{
		ms.updateMessage(message);
	}

	@DeleteMapping
	public void delete(@RequestBody Message message) 
	{
		ms.deleteMessage(message);
	}

}
