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

import com.revature.pokebook.models.Follow;
import com.revature.pokebook.services.FollowService;

@RestController
//@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/follows")
public class FollowController {

	private FollowService fs;
	
	@Autowired
	public FollowController(FollowService fs) {
		super();
		this.fs = fs;
	}

	/*
	@GetMapping
	public ResponseEntity<List<Follow>> getFollowsByUser(@RequestParam int user_id) 
	{
		List<Follow> list = fs.getByUserId(user_id);
		if(list==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Follow>> getFollowsByPokemon(@RequestParam int pokemon_id) 
	{
		List<Follow> list = fs.getByPokemonId(pokemon_id);
		if(list==null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}*/

	@PostMapping
	public void create(@RequestBody int userId, int pokeId) 
	{
		fs.createFollow(userId, pokeId);
	}

	@DeleteMapping
	public void delete(@RequestBody int id) 
	{
		fs.deleteFollow(id);
	}


	

}