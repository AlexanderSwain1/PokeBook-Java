package com.revature.pokebook.controllers;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebook.models.Like;
import com.revature.pokebook.services.LikeService;

@RestController
@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/likes")
public class LikeController 
{
	private LikeService ls;
	
	@Autowired
	public LikeController(LikeService ls) {
		super();
		this.ls = ls;
	}
	
	@GetMapping
	public ResponseEntity<List<Like>> getLikesByUserId(
			@RequestParam(name = "user_id", required = false) String user_id,
			@RequestParam(name = "message_id", required = false) String message_id) 
	{
		if (user_id != null)
		{
			List<Like> list = ls.getLikesByUserId(Integer.parseInt(user_id));
			if(list==null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else if (message_id != null)
		{
			List<Like> list = ls.getLikesByMessageId(Integer.parseInt(message_id));
			if(list==null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else // get all not implemented
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PostMapping
	public void create(@RequestBody Like like) 
	{
		ls.create(like);
	}

	@DeleteMapping
	public void delete(@RequestBody int id) 
	{
		//ls.deleteFollow(id);
	}

}
