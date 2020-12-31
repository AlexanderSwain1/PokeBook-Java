package com.revature.pokebook.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.models.Follow;
import com.revature.pokebook.services.FollowService;

@Controller
@ResponseBody
@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/follows")
public class FollowController {
	
	private FollowService fs;
	
	@Autowired
	public FollowController(FollowService fs) {
		super();
		this.fs = fs;
	}
	
	//Get all followed pages of a user
	@GetMapping("/{id}")
	public List<Follow> getFollowsByUser(@PathVariable("id")int id) 
	{

		List<Follow> list = fs.getByUserId();
		
		return new ArrayList<Follow>();
	}
	
	//Get Follows by Pokemon
	@GetMapping("/{id}")
	public List<Follow> getFollowsByPokemon(@PathVariable("id")int id) 
	{

		List<Follow> list = fs.getByPokemonId();
		
		return new ArrayList<Follow>();
	}
	
	
	@PutMapping
	public void create(@RequestBody int id) 
	{
		Follow f = new Follow();
		f.
		
	}

	@RequestMapping(method=RequestMethod.DELETE)
	public void delete() 
	{
		
	}
}