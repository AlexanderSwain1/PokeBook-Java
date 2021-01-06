package com.revature.pokebook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebook.models.Follow;
import com.revature.pokebook.services.FollowService;

@RestController
@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/follows")
public class FollowController {

	private FollowService fs;
	
	@Autowired
	public FollowController(FollowService fs) {
		super();
		this.fs = fs;
	}
	
	@GetMapping
	public ResponseEntity<List<Follow>> getFollowsByUser(
			@RequestParam(name = "user_id", required = false) String user_id, 
			@RequestParam(name = "pokemon_id", required = false) String pokemon_id) 
	{
		if (user_id != null)
		{
			List<Follow> list = fs.getByUserId(Integer.parseInt(user_id));
			if(list==null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else if (pokemon_id != null)
		{
			List<Follow> list = fs.getByPokemonId(Integer.parseInt(pokemon_id));
			if(list==null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(list);
		}
		else // get all not implemented
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PatchMapping
	public ResponseEntity<Follow> getFollow(@RequestBody Follow follow){
		Follow f = fs.getFollow(follow);
		if(f != null)
			return ResponseEntity.status(200).body(follow);
		else
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(follow);
	}
	
	@PostMapping
	public ResponseEntity<Follow> create(@RequestBody Follow follow) 
	{
		System.out.println("Follow Controller create: " + follow.getPokemonId());
		Follow f = fs.createFollow(follow);
		return ResponseEntity.status(201).body(f); //Created
	}

	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id")int id)
	{
		System.out.println("Delete Method Backend");
		Follow f = new Follow();
		f.setId(id);
		fs.deleteFollow(f);
		return ResponseEntity.status(202).build(); //Accepted
	}


	

}