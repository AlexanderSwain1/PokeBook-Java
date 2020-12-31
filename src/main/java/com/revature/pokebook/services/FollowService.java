package com.revature.pokebook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.pokebook.dao.FollowDao;
import com.revature.pokebook.models.Follow;

@Service
public class FollowService 
{
	
	private FollowDao fd;
	
	//Construction injection
	@Autowired
	public FollowService(FollowDao fd) {
		super();
		this.fd = fd;
	}
	
	public List<Follow> getByUserId(int followerId)
	{
		
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{
		
	}
	
	public void createFollow(Follow follow)
	{
		
	}
	
	public void deleteFollow(Follow follow)
	{
		
	}
}
