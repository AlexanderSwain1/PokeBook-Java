package com.revature.pokebook.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.models.Message;
import com.revature.pokebook.models.User;

@Controller
@RequestMapping(value="/users")
public class UserController 
{
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<User> getUsers() 
	{
		System.out.println("get users not implemented");
		return new ArrayList<User>();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable("id") int id) 
	{
		System.out.println("get user not implemented");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}

	@PostMapping
	@ResponseBody
	public void create(@RequestBody User user) 
	{
		System.out.println("create user not implemented");
	}

	@PutMapping
	@ResponseBody
	public void update(@RequestBody User user) 
	{
		System.out.println("update user not implemented");
	}

	@DeleteMapping
	@ResponseBody
	public void delete(@RequestBody User user) 
	{
		System.out.println("delete user not implemented");
	}
	
	@GetMapping("/login")
	@ResponseBody
	public void login(@RequestBody User user) 
	{
		System.out.println("login user not implemented");
	}

	@GetMapping("/logout")
	@ResponseBody
	public void logout(@RequestBody User user) 
	{
		System.out.println("logout user not implemented");
	}
}
