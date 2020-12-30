package com.revature.pokebook.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.pokebook.models.Like;
import com.revature.pokebook.models.User;

@Controller
@RequestMapping(value="/likes")
public class LikeController 
{
	@RequestMapping(method=RequestMethod.GET)
	@ResponseBody
	public List<Like> getLikes() 
	{
		System.out.println("get follows not implemented");
		return new ArrayList<Like>();
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<Like> getLike(@PathVariable("id") int id) 
	{
		System.out.println("get like not implemented");
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}


	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public void create() 
	{
		System.out.println("create follow not implemented");
	}

	@RequestMapping(method=RequestMethod.PATCH)
	@ResponseBody
	public void update() 
	{
		System.out.println("update follow not implemented");
	}

	@RequestMapping(method=RequestMethod.DELETE)
	@ResponseBody
	public void delete() 
	{
		System.out.println("delete follow not implemented");
	}

}
