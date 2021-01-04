package com.revature.pokebook.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.pokebook.models.User;
import com.revature.pokebook.services.UserService;

@RestController
//@CrossOrigin // Connect to EC2 Eventually
@RequestMapping(value="/users")
public class UserController
{
	
	private UserService us;
	
	@Autowired
	public UserController(UserService us) 
	{
		super();
		this.us = us;
	}
	
	
	@GetMapping
	public List<User> getUsers() 
	{
		return us.getUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id, HttpServletRequest request) 
	{
		System.out.println("id: " + id);
		if (id == 0)
		{
			HttpSession session = request.getSession(false);
			if (session != null) 
				return ResponseEntity.status(HttpStatus.OK).body((User)session.getAttribute("user"));
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		}
		else
		{
			User result = us.getUser(id);
			if (result != null)
				return ResponseEntity.status(HttpStatus.OK).body(result);
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
		}
	}

	@PostMapping
	public void create(@RequestBody User user) 
	{
		us.createUser(user);
	}

	@PutMapping
	public void update(@RequestBody User user) 
	{
		us.updateUser(user);
	}

	@GetMapping("/login")
	public ResponseEntity<Boolean> login(@RequestBody User user, HttpServletRequest request) 
	{
		user = us.loginUser(user);
		if (user != null)
		{
			HttpSession session = request.getSession(true);
			session.setAttribute("user", user);
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(false);
	}

	@GetMapping("/logout")
	public ResponseEntity<Boolean> logout(HttpServletRequest request) 
	{
		HttpSession session = request.getSession(false);
		if (session != null) 
		{
		    session.invalidate();
			return ResponseEntity.status(HttpStatus.OK).body(true);
		}
		else
			return ResponseEntity.status(HttpStatus.OK).body(false);
	}
}
