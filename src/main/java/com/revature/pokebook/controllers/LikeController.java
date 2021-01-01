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
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.models.Like;
import com.revature.pokebook.services.LikeService;

@Controller
@ResponseBody
@CrossOrigin
@RequestMapping(value="/likes")
public class LikeController 
{
	private LikeService ls;
	
	@Autowired
	public LikeController(LikeService ls) {
		super();
		this.ls = ls;
	}
	

	@GetMapping("/{id}")
	public ResponseEntity<List<Like>> getLikesByUserId(@PathVariable("id") int id) 
	{
		List<Like> list = ls.getLikesByUserId(id);
		if(list==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<List<Like>> getLikesByMessageId(@PathVariable("id") int id) 
	{
		List<Like> list = ls.getLikesByMessageId(id);
		if(list==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@PostMapping
	public void create(@RequestBody int userId, int pokeId) 
	{
		//ls.createFollow(userId, pokeId);
	}

	@DeleteMapping
	public void delete(@RequestBody int id) 
	{
		//ls.deleteFollow(id);
	}

}
