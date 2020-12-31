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
	
	@Autowired
	public FollowService(FollowDao fd) {
		super();
		this.fd = fd;
	}
	

	public List<Follow> getByUserId(int followerId)
	{
		return fd.getByUserId(followerId);
		
	}
	
	public List<Follow> getByPokemonId(int pokemonId)
	{
		return fd.getByPokemonId(pokemonId);
	}
	
	public void createFollow(int userId, int pokeId)
	{
		Follow f = new Follow(userId, pokeId);
		fd.createFollow(f);
	}
	
	public void deleteFollow(int id)
	{
		Follow f = new Follow();
		f.setId(id);
		fd.deleteFollow(f);
	}
	
}
